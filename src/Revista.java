import java.time.LocalDate;

/**
Classe que representa uma Revista, contendo informações como título, editora, categoria, ISSN e data de publicação.
 */

public class Revista {
    public String titulo;
    public String editora;
    public String categoria;
    public String issn;
    public LocalDate dataPublicacao;

    /**
     * Construtor da classe Revista.
     * parametro titulo Título da revista.
     * parametro editora Nome da editora.
     * parametro categoria Categoria da revista.
     * parametro issn Código ISSN da revista.
     * parametro dataPublicacao Data de publicação no formato AAAA-MM-DD.
     */

    public Revista(String titulo, String editora, String categoria, String issn, String dataPublicacao) {
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.issn = issn;
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }

    /**
     * Obtém o título da revista.
     * return O título da revista.
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da revista.
     * parametro titulo O novo título da revista.
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o nome da editora da revista.
     * return O nome da editora.
     */

    public String getEditora() {
        return editora;
    }

    /**
     * Define o nome da editora da revista.
     *
     * parametro editora O novo nome da editora.
     */

    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Obtém a categoria da revista.
     * return A categoria da revista.
     */

    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria da revista.
     * parametro categoria A nova categoria da revista.
     */

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém o código ISSN da revista.
     * return O código ISSN da revista.
     */

    public String getIssn() {
        return issn;
    }

    /**
     * Define o código ISSN da revista.
     * parametro issn O novo código ISSN da revista.
     */

    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * Obtém a data de publicação da revista.
     * return A data de publicação no formato AAAA-MM-DD.
     */

    public String getDataPublicacao() {
        return dataPublicacao.toString();
    }

    /**
     * Define a data de publicação da revista.
     * param dataPublicacao A nova data de publicação no formato AAAA-MM-DD.
     */

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }
}
