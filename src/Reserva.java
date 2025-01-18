import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    public static ArrayList<Reserva> listaReservas = new ArrayList<>(100);
    private static int proximoNumero = 1;
    private int numero;
    private String utente;
    private String livro;
    private LocalDate dataRegisto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reserva(String utente, String livro, LocalDate dataInicio, LocalDate dataFim) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livro = livro;
        this.dataRegisto = LocalDate.now();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getNumero() {
        return numero;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
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

        System.out.print("Nome do utente: ");
        String utente = ler.nextLine();

        System.out.print("Título do livro: ");
        String livro = ler.nextLine();

        while (true) {

            if (CRUD.verificarLivroExistente(livro) != null) {
                System.out.println("Livro encontrado no sistema.");
                break;
            } else {
                System.out.println("Livro não encontrado no sistema.");
                System.out.println("1. Tentar novamente\n0. Cancelar");
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

        for (Reserva reserva : listaReservas) {
            if (reserva.getLivro().equals(livro)) {
                LocalDate reservaInicio = reserva.getDataInicio();
                LocalDate reservaFim = reserva.getDataFim();

                if (!(dataFim.isBefore(reservaInicio) || dataInicio.isAfter(reservaFim))) {
                    System.out.println("Não é possível criar a reserva. O livro já está reservado no intervalo de datas fornecido.");
                    return;
                }
            }
        }

        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                LocalDate emprestimoInicio = emprestimo.getDataInicio();
                LocalDate emprestimoFim = emprestimo.getDataPrevistaDevolucao();

                if (!(dataFim.isBefore(emprestimoInicio) || dataInicio.isAfter(emprestimoFim))) {
                    System.out.println("Não é possível criar a reserva. O livro já está emprestado no intervalo de datas fornecido.");
                    return;
                }
            }
        }

        Reserva reserva = new Reserva(utente, livro, dataInicio, dataFim);
        listaReservas.add(reserva);

        System.out.println("\n Reserva Criada com Sucesso!");
        System.out.println("Número da reserva: " + reserva.getNumero());
        System.out.println("Nome do utente: " + reserva.getUtente());
        System.out.println("Título do livro: " + reserva.getLivro());
        System.out.println("Data de registo: " + reserva.getDataRegisto());
        System.out.println("Data de início: " + reserva.getDataInicio());
        System.out.println("Data de fim: " + reserva.getDataFim());
    }


public static void removerReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Remover Reserva ---");

        System.out.print("Informe o número da reserva que deseja remover: ");
        int numeroReserva = ler.nextInt();

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
            System.out.println("Reserva não encontrada. Verifique o número e tente novamente.");
        }
    }

}
