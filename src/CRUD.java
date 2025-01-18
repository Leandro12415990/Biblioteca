import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

    public static ArrayList<Livro> livros = new ArrayList<Livro>();
    public static ArrayList<Revista> revistas = new ArrayList<Revista>();
    public static ArrayList<Jornal> jornais = new ArrayList<Jornal>();
    public static ArrayList<Utente> utentes = new ArrayList<Utente>();

    public static void main() {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Escolha a opção que deseja ir: ");
            System.out.println("1. Livro ");
            System.out.println("2. Revista ");
            System.out.println("3. Jornal ");
            System.out.println("4. Utente ");
            opcao = ler.nextInt();
            ler.nextLine();
        } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

        String titulo = "";
        String editora = "";
        String categoria = "";
        String anoEdicao = "";
        String isbn = "";
        String autor = "";
        String issn = "";
        String dataPublicacao = "";
        String nif = "";
        String nome = "";
        String genero = "";
        String contacto = "";

        if (opcao == 1) {
            System.out.println("Indique o titulo do livro:");
            titulo = ler.nextLine();
            System.out.println("Indique a editora do livro:");
            editora = ler.nextLine();
            System.out.println("Indique a categoria do livro:");
            categoria = ler.nextLine();
            System.out.println("Indique o ano de edição do livro:");
            anoEdicao = ler.nextLine();
            System.out.println("Indique o isbn do livro:");
            isbn = ler.nextLine();
            System.out.println("Indique o autor do livro:");
            autor = ler.nextLine();
            Livro livro = new Livro(titulo, editora, categoria, anoEdicao, isbn, autor);
            livros.add(new Livro(titulo, editora, categoria, anoEdicao, isbn, autor));


        } else if (opcao == 2) {
            System.out.println("Indique o titulo da revista:");
            titulo = ler.nextLine();
            System.out.println("Indique a editora da revista:");
            editora = ler.nextLine();
            System.out.println("Indique a categoria da revista:");
            categoria = ler.nextLine();
            System.out.println("Indique o issn da revista:");
            issn = ler.nextLine();
            System.out.println("Indique a data de publicação da revista: ");
            dataPublicacao = ler.nextLine();
            Revista revista = new Revista(titulo, editora, categoria, issn, dataPublicacao);
            revistas.add(new Revista(titulo, editora, categoria, issn, dataPublicacao));
        } else if (opcao == 3) {
            System.out.println("Indique o titulo do jornal:");
            titulo = ler.nextLine();
            System.out.println("Indique a editora do jornal:");
            editora = ler.nextLine();
            System.out.println("Indique a categoria do jornal:");
            categoria = ler.nextLine();
            System.out.println("Indique o issn do jornal:");
            issn = ler.nextLine();
            System.out.println("Indique a data de publicação do jornal: ");
            dataPublicacao = ler.nextLine();
            Jornal jornal = new Jornal(titulo, editora, categoria, issn, dataPublicacao);
            jornais.add(new Jornal(titulo, editora, categoria, issn, dataPublicacao));
        } else if (opcao == 4) {
            System.out.println("Indique o nif do utente:");
            nif = ler.nextLine();
            System.out.println("Indique o nome do utente:");
            nome = ler.nextLine();
            System.out.println("Indique o genero do utente:");
            genero = ler.nextLine();
            System.out.println("Indique o contacto do utente:");
            contacto = ler.nextLine();
            Utente utente = new Utente(nif, nome, genero, contacto);
            utentes.add(new Utente(nif, nome, genero, contacto));
        } else {
            System.out.println("Não selecionou nenhuma opção, por favor selecione uma opção!!");
        }
    }

    public static void ler() {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Escolha a opção que deseja pesquisar: ");
            System.out.println("1. Livro ");
            System.out.println("2. Revista ");
            System.out.println("3. Jornal ");
            System.out.println("4. Utente ");
            opcao = ler.nextInt();
            ler.nextLine();
        } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

        if (opcao == 1) {
            System.out.println("Insira o ISBN: ");
            String isbn = ler.nextLine();
            boolean livroencontrado = true;
            for (Livro livro : livros) {
                if (livro.getIsbn().equals(isbn)) {
                    System.out.println(livro.titulo);
                    System.out.println(livro.editora);
                    System.out.println(livro.categoria);
                    System.out.println(livro.anoEdicao);
                    System.out.println(livro.isbn);
                    System.out.println(livro.autor);
                    livroencontrado = false;
                    break;
                }
            }
            if(livroencontrado) System.out.println("Livro não encontrado!! ");

        } else if (opcao == 2) {
            System.out.println("Insira o ISSN: ");
            String issn = ler.nextLine();
            boolean revistaencontrada = true;
            for (Revista revista : revistas) {
                if (revista.getIssn().equals(issn)) {
                    System.out.println(revista.titulo);
                    System.out.println(revista.editora);
                    System.out.println(revista.categoria);
                    System.out.println(revista.issn);
                    System.out.println(revista.dataPublicacao);
                    revistaencontrada = false;
                    break;
                }
            }
            if(revistaencontrada) System.out.println("Revista não encontrada!! ");

        } else if (opcao == 3) {
            System.out.println("Insira o ISSN: ");
            String issn = ler.nextLine();
            boolean jornalencontrado = true;
            for (Jornal jornal : jornais) {
                if (jornal.getIssn().equals(issn)) {
                    System.out.println(jornal.titulo);
                    System.out.println(jornal.editora);
                    System.out.println(jornal.categoria);
                    System.out.println(jornal.issn);
                    System.out.println(jornal.dataPublicacao);
                    jornalencontrado = false;
                    break;
                }
            }
            if(jornalencontrado) System.out.println("Jornal não encontrado!! ");

        } else if (opcao == 4) {
            System.out.println("Insira o NIF: ");
            String nif = ler.nextLine();
            boolean utenteencontrado = true;
            for (Utente utente : utentes) {
                if (utente.getNif().equals(nif)) {
                    System.out.println(utente.nif);
                    System.out.println(utente.nome);
                    System.out.println(utente.genero);
                    System.out.println(utente.contacto);
                    utenteencontrado = false;
                    break;
                }
            }
            if(utenteencontrado) System.out.println("Utente não encontrado!! ");

        } else {
            System.out.println("Não selecionou nenhuma opção, por favor selecione uma opção!!");

        }

    }
    public static void update() {
        int posicao = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha a opção que deseja editar: ");
        System.out.println("1. Livro ");
        System.out.println("2. Revista ");
        System.out.println("3. Jornal ");
        System.out.println("4. Utente ");
        int opcao = ler.nextInt();
        if (opcao == 1) {
            System.out.println("Qual o Título do livro que deseja alterar? ");
            String tituloup = ler.nextLine();
            System.out.println("Quantas opções deseja alterar ");
            int opcaoAlterar = ler.nextInt();
            System.out.println("O que deseja alterar do livro ");
            System.out.println("1. Titulo ");
            System.out.println("2. Editora ");
            System.out.println("3. Categoria ");
            System.out.println("4. Ano edição ");
            System.out.println("5. ISBN  ");
            System.out.println("6. Autor ");
            int[] opcaoLivro = new int[6];
            for (int i = 0; i < opcaoAlterar; i++) {
                opcaoLivro[i] = ler.nextInt();
            }
            Livro livroAlterar = new Livro("","","","","","");
            for (Livro livro : livros) {
                if (livro.getTitulo().equals(tituloup)) {
                    livroAlterar = livros.get(posicao);

                    break;
                }
                posicao++ ;
            }
            for (int i = 0; i < opcaoLivro.length; i++) {
                if (opcaoLivro[i] == 1) {
                    System.out.println("Digite o novo titulo: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }
                if (opcaoLivro[i] == 2) {
                    System.out.println("Digite a nova Editora: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }
                if (opcaoLivro[i] == 3) {
                    System.out.println("Digite a nova Categoria: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }
                if (opcaoLivro[i] == 4) {
                    System.out.println("Digite o novo Ano edição: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }
                if (opcaoLivro[i] == 5) {
                    System.out.println("Digite o novo ISBN: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }
                if (opcaoLivro[i] == 6) {
                    System.out.println("Digite o novo Autor: ");
                    String tituloNovo = ler.nextLine();
                    livroAlterar.setTitulo(tituloNovo);
                    livros.add(livroAlterar);
                    break;
                }

            }

        } else if (opcao == 2)
        {
            System.out.println("Qual o Título da revista que deseja alterar? ");
            String tituloup = ler.nextLine();
            System.out.println("Quantas opções deseja alterar ");
            int opcaoAlterar = ler.nextInt();
            System.out.println("O que deseja alterar do livro ");
            System.out.println("1. Titulo ");
            System.out.println("2. Editora ");
            System.out.println("3. Categoria ");
            System.out.println("4. ISSN ");
            System.out.println("5. Data Publicação ");
            int[] opcaoRevista = new int[6];
            for (int i = 0; i < opcaoAlterar; i++) {
                opcaoRevista[i] = ler.nextInt();
            }
            Revista revistaAlterar = new Revista("","","","","");
            for (Revista revista : revistas) {
                if (revista.getTitulo().equals(tituloup)) {
                    revistaAlterar = revistas.get(posicao);

                    break;
                }
                posicao++ ;
            }
            for (int i = 0; i < opcaoRevista.length; i++) {
                if (opcaoRevista[i] == 1) {
                    System.out.println("Digite o novo titulo da Revista: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }
                if (opcaoRevista[i] == 2) {
                    System.out.println("Digite a nova Editora: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }
                if (opcaoRevista[i] == 3) {
                    System.out.println("Digite a nova Categoria: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }
                if (opcaoRevista[i] == 4) {
                    System.out.println("Digite o novo ano de edição: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }
                if (opcaoRevista[i] == 5) {
                    System.out.println("Digite o novo ISSN: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }
                if (opcaoRevista[i] == 6) {
                    System.out.println("Digite o novo Autor: ");
                    String tituloNovo = ler.nextLine();
                    revistaAlterar.setTitulo(tituloNovo);
                    revistas.add(revistaAlterar);
                    break;
                }

            }
        } else if (opcao == 3)
        {
            System.out.println("Qual o Título do jornal que deseja alterar? ");
            String tituloup = ler.nextLine();
            System.out.println("Quantas opções deseja alterar ");
            int opcaoAlterar = ler.nextInt();
            System.out.println("O que deseja alterar do Jornal ");
            System.out.println("1. Titulo ");
            System.out.println("2. Editora ");
            System.out.println("3. Categoria ");
            System.out.println("4. ISSN ");
            System.out.println("5. Data Publicação ");
            int[] opcaoJornal = new int[6];
            for (int i = 0; i < opcaoAlterar; i++) {
                opcaoJornal[i] = ler.nextInt();
            }
            Jornal jornalAlterar = new Jornal("","","","","");
            for (Jornal jornal : jornais) {
                if (jornal.getTitulo().equals(tituloup)) {
                    jornalAlterar = jornais.get(posicao);

                    break;
                }
                posicao++ ;
            }
            for (int i = 0; i < opcaoJornal.length; i++) {
                if (opcaoJornal[i] == 1) {
                    System.out.println("Digite o novo titulo do Jornal: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }
                if (opcaoJornal[i] == 2) {
                    System.out.println("Digite a nova Editora: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }
                if (opcaoJornal[i] == 3) {
                    System.out.println("Digite a nova Categoria: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }
                if (opcaoJornal[i] == 4) {
                    System.out.println("Digite o novo ano de edição: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }
                if (opcaoJornal[i] == 5) {
                    System.out.println("Digite o novo ISSN: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }
                if (opcaoJornal[i] == 6) {
                    System.out.println("Digite o novo Autor: ");
                    String tituloNovo = ler.nextLine();
                    jornalAlterar.setTitulo(tituloNovo);
                    jornais.add(jornalAlterar);
                    break;
                }

            }
        } else if (opcao == 4)
        {
            System.out.println("Qual o NIF do Utente que deseja alterar? ");
            String tituloup = ler.nextLine();
            System.out.println("Quantas opções deseja alterar ");
            int opcaoAlterar = ler.nextInt();
            System.out.println("O que deseja alterar do Utente ");
            System.out.println("1. NIF ");
            System.out.println("2. Nome ");
            System.out.println("3. Género ");
            System.out.println("4. Contacto ");
            int[] opcaoUtente = new int[6];
            for (int i = 0; i < opcaoAlterar; i++) {
                opcaoUtente[i] = ler.nextInt();
            }
            Utente utenteAlterar = new Utente("","","","");
            for (Utente utente : utentes) {
                if (utenteAlterar.getNif().equals(tituloup)) {
                    utenteAlterar = utentes.get(posicao);

                    break;
                }
                posicao++ ;
            }
            for (int i = 0; i < opcaoUtente.length; i++) {
                if (opcaoUtente[i] == 1) {
                    System.out.println("Digite o novo NIF: ");
                    String tituloNovo = ler.nextLine();
                    utenteAlterar.setNif(tituloNovo);
                    utentes.add(utenteAlterar);
                    break;
                }
                if (opcaoUtente[i] == 2) {
                    System.out.println("Digite o novo Nome: ");
                    String tituloNovo = ler.nextLine();
                    utenteAlterar.setNif(tituloNovo);
                    utentes.add(utenteAlterar);
                    break;
                }
                if (opcaoUtente[i] == 3) {
                    System.out.println("Digite o novo Género: ");
                    String tituloNovo = ler.nextLine();
                    utenteAlterar.setNif(tituloNovo);
                    utentes.add(utenteAlterar);
                    break;
                }
                if (opcaoUtente[i] == 4) {
                    System.out.println("Digite o novo Contacto: ");
                    String tituloNovo = ler.nextLine();
                    utenteAlterar.setNif(tituloNovo);
                    utentes.add(utenteAlterar);
                    break;
                }

            }
        }
    }
    public static void remover () {
        int posicao = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha a opção que deseja remover: ");
        System.out.println("1. Livro ");
        System.out.println("2. Revista ");
        System.out.println("3. Jornal ");
        System.out.println("4. Utente ");
        int opcao = ler.nextInt();
        if (opcao == 1) {
            System.out.println("Qual o Título do livro que deseja remover? ");
            String tituloremove = ler.nextLine();
            for (Livro livro : livros) {
                if (livro.getTitulo().equals(tituloremove)) {
                    livros.remove(posicao);
                    break;
                }
                posicao++ ;
            }
        }
        if (opcao == 2) {
            System.out.println("Qual o Título da Revista que deseja remover? ");
            String tituloremove = ler.nextLine();
            for (Revista revista : revistas) {
                if (revista.getTitulo().equals(tituloremove)) {
                    revistas.remove(posicao);
                    break;
                }
                posicao++ ;
            }
        }
        if (opcao == 3) {
            System.out.println("Qual o Título da Jornal que deseja remover? ");
            String tituloremove = ler.nextLine();
            for (Jornal jornal : jornais) {
                if (jornal.getTitulo().equals(tituloremove)) {
                    jornais.remove(posicao);
                    break;
                }
                posicao++ ;
            }
        }
        if (opcao == 4) {
            System.out.println("Qual o nif do utente que deseja remover? ");
            String nifremove = ler.nextLine();
            for (Utente utente : utentes) {
                if (utente.getNif().equals(nifremove)) {
                    utentes.remove(posicao);
                    break;
                }
                posicao++ ;
            }
        }
    }

    public static Livro verificarLivroExistente(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public static Utente encontrarUtentePorNif(String nif) {
        for (Utente utente : utentes) {
            if (utente.getNif().equals(nif)) {
                return utente;
            }
        }
        return null;
    }
}
