import java.time.LocalDate;

/**
 * Representa um jornal com informações como título, editora, categoria, ISSN e data de publicação.
 * Esta classe oferece métodos para acessar e modificar essas informações.
 */
public class Jornal {

    // Atributos da classe
    private String titulo;
    private String editora;
    private String categoria;
    private String issn;
    private LocalDate dataPublicacao;

    /**
     * Construtor da classe Jornal, responsável por inicializar um objeto com os dados fornecidos.
     *
     * @param titulo O título do jornal.
     * @param editora A editora responsável pela publicação.
     * @param categoria A categoria do jornal (ex: política, desporto, etc.).
     * @param issn O ISSN (International Standard Serial Number) do jornal.
     * @param dataPublicacao A data de publicação do jornal no formato "AAAA-MM-DD".
     */
    public Jornal(String titulo, String editora, String categoria, String issn, String dataPublicacao) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.issn = issn;
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }

    /**
     * Retorna o título do jornal.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do jornal.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna a editora do jornal.
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Define a editora do jornal.
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Retorna a categoria do jornal.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do jornal.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o ISSN do jornal.
     */
    public String getIssn() {
        return issn;
    }

    /**
     * Define o ISSN do jornal.
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * Retorna a data de publicação do jornal no formato "AAAA-MM-DD".
     */
    public String getDataPublicacao() {
        return dataPublicacao.toString();
    }

    /**
     * Define a data de publicação do jornal.
     */
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }
}