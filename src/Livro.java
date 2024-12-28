public class Livro {
    private String titulo;
    private String editora;
    private String categoria;
    private String AnoEdicao;
    private String isbn;
    private String autor;

    public Livro(String titulo, String editora, String categoria, String anoEdicao, String isbn, String autor) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.AnoEdicao = anoEdicao;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }
}
