import java.util.Scanner;

public class Pesquisa {

    public static void pesquisarLivros() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Livros ---");
        System.out.print("Insira o ISBN: ");
        String isbn = ler.nextLine();


        boolean encontradoLivro = false;
        for (Livro livro : CRUD.livros) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.println("\nLivro encontrado!");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("Categoria: " + livro.getCategoria());
                System.out.println("Ano de Edição: " + livro.getAnoEdicao());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Autor: " + livro.getAutor());
                encontradoLivro = true;
                break;
            }
        }
        System.out.println("Não foi encontrado nenhum livro com esse ISBN.");
    }

    public static void pesquisarJornais() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Jornais ---");
        System.out.print("Insira o ISSN: ");
        String issn = ler.nextLine();

        boolean encontradoJornal = false;
        for (Jornal jornal : CRUD.jornais) {
            if (jornal.getIssn().equals(issn)) {
                System.out.println("\nJornal encontrado!");
                System.out.println("Título: " + jornal.getTitulo());
                System.out.println("Editora: " + jornal.getEditora());
                System.out.println("Categoria: " + jornal.getCategoria());
                System.out.println("Data de publicação: " + jornal.getDataPublicacao());
                System.out.println("ISSN: " + jornal.getIssn());
                encontradoJornal = true;
                break;
            }
        }
        System.out.println("Não foi encontrado nenhum Jornal com esse ISSN.");
    }

    public static void pesquisarRevistas() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Revistas ---");
        System.out.print("Insira o ISSN: ");
        String issn = ler.nextLine();

        boolean encontradoRevista = false;
        for (Revista revista : CRUD.revistas) {
            if (revista.getIssn().equals(issn)) {
                System.out.println("\nJornal encontrado!");
                System.out.println("Título: " + revista.getTitulo());
                System.out.println("Editora: " + revista.getEditora());
                System.out.println("Categoria: " + revista.getCategoria());
                System.out.println("Data de publicação: " + revista.getDataPublicacao());
                System.out.println("ISSN: " + revista.getIssn());
                encontradoRevista = true;
                break;
            }
        }
        System.out.println("Não foi encontrado nenhuma revista com esse ISSN.");
    }
}
