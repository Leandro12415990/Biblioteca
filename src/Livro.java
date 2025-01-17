import java.util.Scanner;

public class Livro {
    public String titulo;
    public String editora;
    public String categoria;
    public String anoEdicao;
    public String isbn;
    public String autor;

    public Livro(String titulo, String editora, String categoria, String anoEdicao, String isbn, String autor) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.anoEdicao = anoEdicao;
        this.isbn = isbn;
        this.autor = autor;
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

    public String getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(String anoEdicao) {
        anoEdicao = anoEdicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
