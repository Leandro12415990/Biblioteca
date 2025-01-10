import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {
    private static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>(100);
    private static int proximoNumero = 1;
    private int numero;
    private String utente;
    private String livro;
    private String dataInicio;
    private String dataPrevistaDevolucao;
    private String dataEfetivaDevolucao;

    public Emprestimo(String utente, String livro, String dataInicio, String dataPrevistaDevolucao, String dataEfetivaDevolucao) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public String getDataEfetivaDevolucao() {
        return dataEfetivaDevolucao;
    }

    public void setDataEfetivaDevolucao(String dataEfetivaDevolucao) {
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public static void criarEmprestimo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Empréstimo ---");

        System.out.print("Nome do utente: ");
        String utente = ler.nextLine();

        System.out.print("Título do livro: ");
        String livro = ler.nextLine();

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


        Emprestimo emprestimo = new Emprestimo(utente, livro, dataInicio.toString(), dataPrevistaDevolucao.toString(), dataEfetivaDevolucao != null ? dataEfetivaDevolucao.toString() : "Pendente");
            listaEmprestimos.add(new Emprestimo(utente, livro, dataInicio.toString(), dataPrevistaDevolucao.toString(), dataEfetivaDevolucao != null ? dataEfetivaDevolucao.toString() : "Pendente"));

        System.out.println("\n Empréstimo Criado com Sucesso!");
        System.out.println("Número do empréstimo: " + emprestimo.getNumero());
        System.out.println("Nome do utente: " + emprestimo.getUtente());
        System.out.println("Título do livro: " + emprestimo.getLivro());
        System.out.println("Data de início: " + emprestimo.getDataInicio());
        System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
        System.out.println("Data efetiva de devolução: " + emprestimo.getDataEfetivaDevolucao());

        }
    }

