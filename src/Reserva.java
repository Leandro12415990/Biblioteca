import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    public static ArrayList<Reserva> listaReservas = new ArrayList<>(100);
    private static int proximoNumero = 1;
    private int numero;
    private String utente;
    private ArrayList<String> livros;
    private LocalDate dataRegisto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reserva(String utente, ArrayList<String> livros, LocalDate dataInicio, LocalDate dataFim) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataRegisto = LocalDate.now();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Reserva(int numero, String utente, ArrayList<String> livros, LocalDate dataRegisto, LocalDate dataInicio, LocalDate dataFim) {
        this.numero = numero;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataRegisto = dataRegisto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters

    public int getNumero() {
        return numero;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public ArrayList<String> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<String> livros) {
        this.livros = livros;
    }

    public LocalDate getDataRegisto() {
        return dataRegisto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public static void criarReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Reserva ---");

        System.out.print("Insira o NIF do cliente: ");
        String utente;

        while (true) {
            utente = ler.nextLine();

            if (CRUD.encontrarUtentePorNif(utente) != null) {
                System.out.println("Utente encontrado no sistema.");
                break;
            } else {
                System.out.println("O utente não foi encontrado!");
                System.out.println("1. Tentar novamente\n0. Cancelar operação");
                System.out.print("Escolha uma opção: ");

                while (!ler.hasNextInt()) {
                    System.out.print("Entrada inválida. Escolha 1 para tentar novamente ou 0 para cancelar: ");
                    ler.next();
                }

                int opcao = ler.nextInt();
                ler.nextLine();

                if (opcao == 0) {
                    System.out.println("Operação cancelada.");
                    return;
                }

                System.out.print("Insira o NIF do cliente: ");
            }
        }

        System.out.print("Quantos livros deseja incluir na reserva? ");
        int quantidadeLivros = ler.nextInt();
        ler.nextLine();

        ArrayList<String> livrosParaReserva = new ArrayList<>();
        for (int i = 0; i < quantidadeLivros; i++) {
            while (true) {
                System.out.print("ISBN do livro " + (i + 1) + ": ");
                String livro = ler.nextLine();

                if (CRUD.verificarLivroExistente(livro) != null) {
                    livrosParaReserva.add(livro);
                    System.out.println("Livro adicionado à reserva.");
                    break;
                } else {
                    System.out.println("Livro não encontrado no sistema.");
                    System.out.println("1. Tentar novamente\n0. Cancelar operação");
                    System.out.print("Escolha uma opção: ");

                    int opcao = ler.nextInt();
                    ler.nextLine();

                    if (opcao == 0) {
                        System.out.println("Operação cancelada.");
                        return;
                    }
                }
            }
        }

        LocalDate dataInicio = null;
        while (dataInicio == null) {
            try {
                System.out.print("Data de início da reserva (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        LocalDate dataFim = null;
        while (dataFim == null) {
            try {
                System.out.print("Data final da reserva (AAAA-MM-DD): ");
                dataFim = LocalDate.parse(ler.nextLine());
                if (dataFim.isBefore(dataInicio)) {
                    System.out.println("A data final não pode ser anterior à data de início.");
                    dataFim = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        // Verificação de disponibilidade
        for (String livro : livrosParaReserva) {
            for (Reserva reserva : listaReservas) {
                if (reserva.getLivros().contains(livro)) {
                    if (!(dataFim.isBefore(reserva.getDataInicio()) || dataInicio.isAfter(reserva.getDataFim()))) {
                        System.out.println("Não é possível criar a reserva. O livro '" + livro + "' já está reservado no intervalo de datas fornecido.");
                        return;
                    }
                }
            }

            for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
                if (emprestimo.getLivros().contains(livro)) {
                    if (!(dataFim.isBefore(emprestimo.getDataInicio()) || dataInicio.isAfter(emprestimo.getDataPrevistaDevolucao()))) {
                        System.out.println("Não é possível criar a reserva. O livro '" + livro + "' já está emprestado no intervalo de datas fornecido.");
                        return;
                    }
                }
            }
        }

        // Criar a reserva
        Reserva reserva = new Reserva(utente, livrosParaReserva, dataInicio, dataFim);
        listaReservas.add(reserva);

        System.out.println("\n Reserva Criada com Sucesso!");
        System.out.println("Número da reserva: " + reserva.getNumero());
        System.out.println("Nome do utente: " + reserva.getUtente());
        System.out.println("Livros reservados: " + reserva.getLivros());
        System.out.println("Data de registo: " + reserva.getDataRegisto());
        System.out.println("Data de início: " + reserva.getDataInicio());
        System.out.println("Data de fim: " + reserva.getDataFim());
    }

    public static void consultarAlterarReserva() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Indique o número da reserva: ");
        int numeroReserva = ler.nextInt();
        ler.nextLine();

        Reserva reserva = null;
        for (Reserva r : Reserva.listaReservas) {
            if (r.getNumero() == numeroReserva) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        while (true) {
            System.out.println("\nLivros associados à reserva:");
            for (String livro : reserva.getLivros()) {
                System.out.println("- " + livro);
            }

            System.out.println("\nO que deseja fazer?");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1: // Adicionar Livro
                    System.out.print("Informe o título do livro a ser adicionado: ");
                    String novoLivro = ler.nextLine();

                    if (CRUD.verificarLivroExistente(novoLivro) != null) {
                        if (!reserva.getLivros().contains(novoLivro)) {
                            reserva.getLivros().add(novoLivro);
                            System.out.println("Livro adicionado à reserva.");
                        } else {
                            System.out.println("O livro já está associado a esta reserva.");
                        }
                    } else {
                        System.out.println("Livro não encontrado no sistema.");
                    }
                    break;

                case 2: // Remover Livro
                    System.out.print("Informe o título do livro a ser removido: ");
                    String livroRemover = ler.nextLine();

                    if (reserva.getLivros().remove(livroRemover)) {
                        System.out.println("Livro removido da reserva.");
                    } else {
                        System.out.println("O livro não está associado a esta reserva.");
                    }
                    break;

                case 0: // Sair
                    System.out.println("A sair do menu de alteração de reservas...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void removerReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Remover Reserva ---");

        System.out.print("Informe o número da reserva que deseja remover: ");
        int numeroReserva = ler.nextInt();
        ler.nextLine();

        Reserva reservaParaRemover = null;

        for (Reserva reserva : listaReservas) {
            if (reserva.getNumero() == numeroReserva) {
                reservaParaRemover = reserva;
                break;
            }
        }

        if (reservaParaRemover != null) {
            listaReservas.remove(reservaParaRemover);
            System.out.println("Reserva removida com sucesso!");
        } else {
            System.out.println("Reserva não encontrada. Verifique o número informado e tente novamente.");
        }
    }

}
