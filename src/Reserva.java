public class Reserva {
    private int numero;
    private String utente;
    private String livro;
    private String dataRegisto;
    private String dataInicio;
    private String DataFim;

    public Reserva(int numero, String utente, String livro, String dataRegisto, String dataInicio, String dataFim) {
        this.numero = numero;
        this.utente = utente;
        this.livro = livro;
        this.dataRegisto = dataRegisto;
        this.dataInicio = dataInicio;
        this.DataFim = dataFim;
    }

    public int getNumero() {
        return numero;
    }
}
