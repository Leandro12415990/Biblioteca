public class Emprestimo {
    private int numero;
    private String utente;
    private String livro;
    private String dataInicio;
    private String dataPrevistaDevolucao;
    private String dataEfetivaDevolucao;

    public Emprestimo(int numero, String utente, String livro, String dataInicio, String dataPrevistaDevolucao, String dataEfetivaDevolucao) {
        this.numero = numero;
        this.utente = utente;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public int getNumero() {
        return numero;
    }
}
