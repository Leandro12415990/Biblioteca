import java.time.LocalDate;

public class Jornal {
    public String titulo;
    public String editora;
    public String categoria;
    public String issn;
    public LocalDate dataPublicacao;

    public Jornal(String titulo, String editora, String categoria, String issn, String dataPublicacao) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.issn = issn;
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getDataPublicacao() { return dataPublicacao.toString(); }

    public void setDataPublicacao(String dataPublicacao) { this.dataPublicacao = LocalDate.parse(dataPublicacao); }
}
