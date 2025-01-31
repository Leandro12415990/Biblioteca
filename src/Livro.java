import java.util.Scanner;

/**
 * A classe Livro representa um livro com informações essenciais como título, editora, categoria, ano de edição,
 * ISBN e autor. Esta classe fornece métodos para acessar e modificar estes dados.
 */
public class Livro {

    // Atributos da classe
    private String titulo;
    private String editora;
    private String categoria;
    private String anoEdicao;
    private String isbn;
    private String autor;

    /**
     * Construtor da classe Livro, responsável por inicializar um objeto Livro com as informações fornecidas.
     *
     * @param titulo O título do livro.
     * @param editora A editora responsável pela publicação do livro.
     * @param categoria A categoria do livro (ex: Ficção, História, Tecnologia, etc.).
     * @param anoEdicao O ano de edição do livro.
     * @param isbn O ISBN (International Standard Book Number) do livro.
     * @param autor O autor do livro.
     */
    public Livro(String titulo, String editora, String categoria, String anoEdicao, String isbn, String autor) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.anoEdicao = anoEdicao;
        this.isbn = isbn;
        this.autor = autor;
    }

    /**
     * Retorna o título do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do livro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna a editora do livro.
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Define a editora do livro.
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Retorna a categoria do livro.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do livro.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o ano de edição do livro.
     */
    public String getAnoEdicao() {
        return anoEdicao;
    }

    /**
     * Define o ano de edição do livro.
     */
    public void setAnoEdicao(String anoEdicao) {
        this.anoEdicao = anoEdicao;  // Corrigido o erro no setter onde a variável local não estava sendo atribuída à instância
    }

    /**
     * Retorna o ISBN do livro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Define o ISBN do livro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Retorna o autor do livro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Define o autor do livro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
}