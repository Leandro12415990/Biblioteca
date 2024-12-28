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

    public String getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return DataFim;
    }

    public void setDataFim(String dataFim) {
        DataFim = dataFim;
    }
}
