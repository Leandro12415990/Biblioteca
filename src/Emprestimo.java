import java.util.Scanner;
public class Emprestimo {
    private int proximoNumero = 1;
    private int numero;
    private String utente;
    private String livro;
    private String dataInicio;
    private String dataPrevistaDevolucao;
    private String dataEfetivaDevolucao;

    public Emprestimo(int numero, String utente, String livro, String dataInicio, String dataPrevistaDevolucao, String dataEfetivaDevolucao) {
        this.numero = proximoNumero;
        this.utente = utente;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
        this.proximoNumero++;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public void criarEmprestimo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("A criar emprestimo!");

        System.out.println("Nome do utente: ");
        String utente = ler.nextLine();

        System.out.println("Data de inicio (AAAA-MM-DD): ");
        String dataInicio = ler.nextLine();

        System.out.print("Data prevista de devolução (AAAA-MM-DD): ");
        String dataPrevistaDevolucao = ler.nextLine();

        System.out.print("Data efetiva de devolução (AAAA-MM-DD) [Deixe vazio se ainda não foi devolvido]: ");
        String dataEfetivaDevolucao = ler.nextLine();

        this.numero = proximoNumero;
        this.utente = utente;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao.isEmpty() ? null : dataEfetivaDevolucao;

        System.out.println("Emprestimo Criado!");

    }
}
