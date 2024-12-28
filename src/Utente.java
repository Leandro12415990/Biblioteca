public class Utente {
    private String nif;
    private String nome;
    private String genero;
    private int contacto;

    public Utente(String nif, String nome, String genero, int contacto) {
        this.nif = nif;
        this.nome = nome;
        this.genero = genero;
        this.contacto = contacto;
    }

    public String getNome() {
        return nome;
    }
}
