import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {
    public static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>(100);
    private static int proximoNumero = 1;
    private int numero;
    private String utente;
    private String livro;
    private LocalDate dataInicio;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataEfetivaDevolucao;

    public Emprestimo(String utente, String livro, LocalDate dataInicio, LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataEfetivaDevolucao() {
        return dataEfetivaDevolucao;
    }

    public void setDataEfetivaDevolucao(LocalDate dataEfetivaDevolucao) {
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public static void criarEmprestimo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Empréstimo ---");

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
                    System.out.print("Data de início (AAAA-MM-DD): ");
                    dataInicio = LocalDate.parse(ler.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente.");
                }
            }

            LocalDate dataPrevistaDevolucao = null;
            while (dataPrevistaDevolucao == null) {
                try {
                    System.out.print("Data prevista de devolução (AAAA-MM-DD): ");
                    dataPrevistaDevolucao = LocalDate.parse(ler.nextLine());
                    if (dataPrevistaDevolucao.isBefore(dataInicio)) {
                        System.out.println("A data prevista de devolução não pode ser anterior à data de início.");
                        dataPrevistaDevolucao = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente.");
                }
            }

            for (Emprestimo emprestimo : listaEmprestimos) {
                if (emprestimo.getLivro().equals(livro)) {
                    LocalDate emprestimoInicio = emprestimo.getDataInicio();
                    LocalDate emprestimoFim = emprestimo.getDataPrevistaDevolucao();

                    if (!(dataPrevistaDevolucao.isBefore(emprestimoInicio) || dataInicio.isAfter(emprestimoFim))) {
                        System.out.println("Não é possível criar o empréstimo. O livro já está emprestado no intervalo de datas fornecido.");
                        return;
                    }
                }
            }

            for (Reserva reserva : Reserva.listaReservas) {
                if (reserva.getLivro().equals(livro)) {
                    LocalDate reservaInicio = reserva.getDataInicio();
                    LocalDate reservaFim = reserva.getDataFim();

                    if (!(dataPrevistaDevolucao.isBefore(reservaInicio) || dataInicio.isAfter(reservaFim))) {
                        System.out.println("Não é possível criar o empréstimo. O livro já está reservado no intervalo de datas fornecido.");
                        return;
                    }
                }
            }

            LocalDate dataEfetivaDevolucao = null;
            System.out.print("Data efetiva de devolução (AAAA-MM-DD) [Deixe vazio se ainda não foi devolvido]: ");
            String dataEfetiva = ler.nextLine();
            if (!dataEfetiva.isEmpty()) {
                try {
                    dataEfetivaDevolucao = LocalDate.parse(dataEfetiva);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Devolução marcada como pendente.");
                }
            }

            Emprestimo emprestimo = new Emprestimo(utente, livro, dataInicio, dataPrevistaDevolucao, dataEfetivaDevolucao);
            listaEmprestimos.add(emprestimo);

            System.out.println("\n Empréstimo Criado com Sucesso!");
            System.out.println("Número do empréstimo: " + emprestimo.getNumero());
            System.out.println("Nome do utente: " + emprestimo.getUtente());
            System.out.println("Título do livro: " + emprestimo.getLivro());
            System.out.println("Data de início: " + emprestimo.getDataInicio());
            System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
            System.out.println("Data efetiva de devolução: " + (emprestimo.getDataEfetivaDevolucao() != null ? emprestimo.getDataEfetivaDevolucao() : "Pendente"));
        }
    }
