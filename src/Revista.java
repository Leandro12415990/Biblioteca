public class Revista {
    private String titulo;
    private String editora;
    private String categoria;
    private String issn;
    private String dataPublicacao;

    public Revista(String titulo, String editora, String categoria, String issn, String dataPublicacao) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.issn = issn;
        this.dataPublicacao = dataPublicacao;
    }

    public String getIssn() {
        return issn;
    }
}
