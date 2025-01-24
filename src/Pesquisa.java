public class Pesquisa {
    // Classe que representar um item (livro, revista/jornal)
    public class Item {
        private String titulo;
        private String codigo;
        private String editora;
        private String categoria;
        private String autores;
        private String dataPublicacao;
        private int anoEdicao;


        public Item(String titulo, String codigo, String editora, String categoria, String autores, String dataPublicacao, int anoEdicao) {
            this.titulo = titulo;
            this.codigo = codigo;
            this.editora = editora;
            this.categoria = categoria;
            this.autores = autores;
            this.dataPublicacao = dataPublicacao;
            this.anoEdicao = anoEdicao;
        }

        public Item(String titulo, String anoEdicao, String editora, String isbn, String categoria) {
        }

        public String getTitulo() {
            return titulo;
        }

        public String getCodigo() {
            return codigo;
        }
        public String getEditora() {
            return editora;
        }
        public String getCategoria() {
            return categoria;
        }
        public String getAutores() {
            return autores;
        }
        public String getDataPublicacao() {
            return dataPublicacao;
        }
        public int getAnoEdicao() {
            return anoEdicao;
        }

        // Classe para representar um livro
        class Livro extends Item {
            public Livro(String titulo,String anoEdicao, String editora, String isbn,String categoria, String autores) {
                super(titulo, anoEdicao, editora, isbn, categoria);


            }

            public String toString() {
                return "Livro{" +
                        "Titulo: " + getTitulo() + "\n" +
                        "Ano de edição: " + getAnoEdicao() + "\n" +
                        "Editora: " + getEditora() + "\n" +
                        "ISBN: " + getCodigo() + "\n" +
                        "Categoria: " + getCategoria() + "\n" +
                        "Autor(es): " + getAutores() + "\n" +
                        '}';
            }
        }

        // Classe para representar uma revista
        class Revista extends Item {
            public Revista(String titulo,String issn, String editora, String dataPublicacao,String categoria) {
                super(titulo, issn, editora, dataPublicacao, categoria);
            }

            public String toString() {
                return "Livro{" +
                        "Titulo: " + getTitulo() + "\n" +
                        "ISSN: " + getCodigo() + "\n" +
                        "Editora: " + getEditora() + "\n" +
                        "Data de publicação: " + getDataPublicacao() + "\n" +
                        "Categoria: " + getCategoria() + "\n" +
                        '}';
            }
        }

        // Classe para representar um jornal
        class Jornal extends Item {
            public Jornal(String titulo,String issn, String editora, String dataPublicacao,String categoria) {
                super(titulo, issn, editora, dataPublicacao, categoria);
            }

            public String toString() {
                return "Livro{" +
                        "Titulo: " + getTitulo() + "\n" +
                        "ISSN: " + getCodigo() + "\n" +
                        "Editora: " + getEditora() + "\n" +
                        "Data de publicação: " + getDataPublicacao() + "\n" +
                        "Categoria: " + getCategoria() + "\n" +
                        '}';
            }
        }
    }
}
