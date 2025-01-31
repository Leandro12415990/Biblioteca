import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe que representa uma reserva de livros por um utente.
 */

public class Reserva {
    // Lista estática para armazenar todas as reservas criadas

    public static ArrayList<Reserva> listaReservas = new ArrayList<>(100);
    // Variável estática para controlar o próximo número de reserva

    private static int proximoNumero = 1;
    // Atributos da reserva

    private int numero;// Número da reserva
    private String utente;// Nome do utente que fez a reserva
    private ArrayList<String> livros;// Lista de livros reservados
    private LocalDate dataRegisto;// Data em que a reserva foi registrada
    private LocalDate dataInicio;// Data de início da reserva
    private LocalDate dataFim;// Data de término da reserva

    /**
     * Construtor que cria uma reserva com um número gerado automaticamente.
     * parametro utente Nome do utente que faz a reserva.
     * parametro livros Lista de livros reservados.
     * parametro dataInicio Data de início da reserva.
     * parametro dataFim Data de término da reserva.
     */

    public Reserva(String utente, ArrayList<String> livros, LocalDate dataInicio, LocalDate dataFim) {
        this.numero = proximoNumero++;// Atribui um número único à reserva
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();// Evita listas nulasx
        this.dataRegisto = LocalDate.now();// Define a data atual como data de registro
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    /**
     * Construtor que permite criar uma reserva com um número específico.
     * parametro numero Número da reserva.
     * parametro utente Nome do utente que faz a reserva.
     * parametro livros Lista de livros reservados.
     * parametro dataRegisto Data em que a reserva foi registrada.
     * parametro dataInicio Data de início da reserva.
     * parametro dataFim Data de término da reserva.
     */

    public Reserva(int numero, String utente, ArrayList<String> livros, LocalDate dataRegisto, LocalDate dataInicio, LocalDate dataFim) {
        this.numero = numero;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataRegisto = dataRegisto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters

    /**
     * Retorna o número da reserva.
     * return Número da reserva.
     */

    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o nome do utente da reserva.
     * return Nome do utente.
     */

    public String getUtente() {
        return utente;
    }

    /**
     * Define o nome do utente da reserva.
     * parametro utente Nome do utente.
     */

    public void setUtente(String utente) {
        this.utente = utente;
    }

    /**
     * Retorna a lista de livros reservados.
     * return Lista de livros.
     */

    public ArrayList<String> getLivros() {
        return livros;
    }

    /**
     * Define a lista de livros reservados.
     * parametro livros Lista de livros.
     */

    public void setLivros(ArrayList<String> livros) {
        this.livros = livros;
    }

    /**
     * Retorna a data de registro da reserva.
     * return Data de registro.
     */

    public LocalDate getDataRegisto() {
        return dataRegisto;
    }

    /**
     * Retorna a data de início da reserva.
     * return Data de início.
     */

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    /**
     * Define a data de início da reserva.
     * parametro dataInicio Nova data de início.
     */

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    /**
     * Retorna a data de término da reserva.
     * return Data de término.
     */

    public LocalDate getDataFim() {
        return dataFim;
    }
    /**
     * Define a data de término da reserva.
     * parametro dataFim Nova data de término.
     */

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Metodo responsável por criar uma reserva de livros para um cliente.
     * O cliente é identificado pelo seu NIF, e os livros são selecionados
     * com base na disponibilidade no sistema.
     */

    public static void criarReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Reserva ---");

        System.out.print("Insira o NIF do cliente: ");
        String utente;

        while (true) {
            utente = ler.nextLine();

            // Verifica se o cliente existe no sistema
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
                System.out.print("Título do livro " + (i + 1) + ": ");
                String livro = ler.nextLine();

                // Verifica se o livro existe no sistema
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

        /**
         * Metodo para criar uma reserva de livros.
         * O usuário informa a data de início e a data final da reserva.
         * O sistema verifica se os livros estão disponíveis no período desejado.
         * Caso estejam disponíveis, a reserva é criada e adicionada à lista de reservas.
         */

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

        // Exibir detalhes da reserva

        System.out.println("\n Reserva Criada com Sucesso!");
        System.out.println("Número da reserva: " + reserva.getNumero());
        System.out.println("Nome do utente: " + reserva.getUtente());
        System.out.println("Livros reservados: " + reserva.getLivros());
        System.out.println("Data de registo: " + reserva.getDataRegisto());
        System.out.println("Data de início: " + reserva.getDataInicio());
        System.out.println("Data de fim: " + reserva.getDataFim());
    }
    /**
     * Este metodo permite consultar e alterar uma reserva já existente no sistema.
     * O usuário deve fornecer o número da reserva e poderá realizar ações como adicionar
     * ou remover livros associados a essa reserva.
     *
     * Caso a reserva não seja encontrada, uma mensagem será exibida e o processo será encerrado.
     * Após encontrar a reserva, o usuário pode escolher entre adicionar um livro, remover um livro
     * ou sair do menu de alteração.
     */

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

    /**
     * Este metodo permite remover uma reserva do sistema. O usuário deve informar o número
     * da reserva que deseja excluir. Caso a reserva seja encontrada, ela será removida da lista
     * de reservas e uma mensagem de sucesso será exibida.
     * Se a reserva não for encontrada, uma mensagem de erro será mostrada, e o processo será
     * encerrado sem alterações.
     */

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
