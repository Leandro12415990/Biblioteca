/** Classe que representa um Utente, contendo informações pessoais como NIF, nome, gênero e contacto.
*/
public class Utente {
    public String nif;
    public String nome;
    public String genero;
    public String contacto;

     /** Construtor da classe Utente.

     * parametro nif Número de Identificação Fiscal do utente.
     * parametro nome Nome do utente.
     * parametro genero Gênero do utente.
     * parametro contacto Contacto telefônico do utente.
     */

    public Utente(String nif, String nome, String genero, String contacto) {
        this.nif = nif;
        this.nome = nome;
        this.genero = genero;
        this.contacto = contacto;
    }

    /**
     * Obtém o NIF do utente.
     * return O NIF do utente.
     */

    public String getNif() {
        return nif;
    }

    /**
     * Define o NIF do utente.
     * parametro nif O novo NIF do utente.
     */

    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtém o nome do utente.
     * return O nome do utente.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do utente.
     * parametro nome O novo nome do utente.
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do utente.
     * return O gênero do utente.
     */

    public String getGenero() {
        return genero;
    }

    /**
     * Define o gênero do utente.
     * parametro genero O novo gênero do utente.
     */

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtém o contacto do utente.
     * return O contacto do utente.
     */

    public String getContacto() {
        return contacto;
    }

    /**
     * Define o contacto do utente.
     * parametro contacto O novo contacto do utente.
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
