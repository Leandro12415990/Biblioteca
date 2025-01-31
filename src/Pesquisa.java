import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Classe que contém métodos para realizar pesquisas no sistema, como livros, jornais, revistas
 * e empréstimos e reservas de utentes.
 */
public class Pesquisa {

    /**
     * Realiza a pesquisa de livros no sistema pelo ISBN informado pelo utilizador.
     * Exibe as informações do livro caso encontrado ou uma mensagem indicando que o livro não foi encontrado.
     */
    public static void pesquisarLivros() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Livros ---");
        System.out.print("Insira o ISBN: ");
        String isbn = ler.nextLine(); // Lê o ISBN do livro informado pelo utilizador.

        boolean encontradoLivro = false; // Flag para verificar se o livro foi encontrado.

        // Loop para procurar o livro com o ISBN informado.
        for (Livro livro : CRUD.livros) {
            if (livro.getIsbn().equals(isbn)) { // Verifica se o ISBN do livro corresponde ao informado.
                System.out.println("\nLivro encontrado!");
                // Exibe as informações do livro encontrado.
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("Categoria: " + livro.getCategoria());
                System.out.println("Ano de Edição: " + livro.getAnoEdicao());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Autor: " + livro.getAutor());
                encontradoLivro = true; // Marca que o livro foi encontrado.
                break; // Sai do loop após encontrar o livro.
            }
        }

        // Exibe uma mensagem caso o livro não tenha sido encontrado.
        if (!encontradoLivro) {
            System.out.println("Não foi encontrado nenhum livro com esse ISBN.");
        }
    }

    /**
     * Realiza a pesquisa de jornais no sistema pelo ISSN informado pelo utilizador.
     * Exibe as informações do jornal caso encontrado ou uma mensagem indicando que o jornal não foi encontrado.
     */
    public static void pesquisarJornais() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Jornais ---");
        System.out.print("Insira o ISSN: ");
        String issn = ler.nextLine(); // Lê o ISSN do jornal informado pelo utilizador.

        boolean encontradoJornal = false; // Flag para verificar se o jornal foi encontrado.

        // Loop para procurar o jornal com o ISSN informado.
        for (Jornal jornal : CRUD.jornais) {
            if (jornal.getIssn().equals(issn)) { // Verifica se o ISSN do jornal corresponde ao informado.
                System.out.println("\nJornal encontrado!");
                // Exibe as informações do jornal encontrado.
                System.out.println("Título: " + jornal.getTitulo());
                System.out.println("Editora: " + jornal.getEditora());
                System.out.println("Categoria: " + jornal.getCategoria());
                System.out.println("Data de publicação: " + jornal.getDataPublicacao());
                System.out.println("ISSN: " + jornal.getIssn());
                encontradoJornal = true; // Marca que o jornal foi encontrado.
                break; // Sai do loop após encontrar o jornal.
            }
        }

        // Exibe uma mensagem caso o jornal não tenha sido encontrado.
        if (!encontradoJornal) {
            System.out.println("Não foi encontrado nenhum Jornal com esse ISSN.");
        }
    }

    /**
     * Realiza a pesquisa de revistas no sistema pelo ISSN informado pelo utilizador.
     * Exibe as informações da revista caso encontrada ou uma mensagem indicando que a revista não foi encontrada.
     */
    public static void pesquisarRevistas() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Pesquisa de Revistas ---");
        System.out.print("Insira o ISSN: ");
        String issn = ler.nextLine(); // Lê o ISSN da revista informado pelo utilizador.

        boolean encontradoRevista = false; // Flag para verificar se a revista foi encontrada.

        // Loop para procurar a revista com o ISSN informado.
        for (Revista revista : CRUD.revistas) {
            if (revista.getIssn().equals(issn)) { // Verifica se o ISSN da revista corresponde ao informado.
                System.out.println("\nRevista encontrada!");
                // Exibe as informações da revista encontrada.
                System.out.println("Título: " + revista.getTitulo());
                System.out.println("Editora: " + revista.getEditora());
                System.out.println("Categoria: " + revista.getCategoria());
                System.out.println("Data de publicação: " + revista.getDataPublicacao());
                System.out.println("ISSN: " + revista.getIssn());
                encontradoRevista = true; // Marca que a revista foi encontrada.
                break; // Sai do loop após encontrar a revista.
            }
        }

        // Exibe uma mensagem caso a revista não tenha sido encontrada.
        if (!encontradoRevista) {
            System.out.println("Não foi encontrado nenhuma revista com esse ISSN.");
        }
    }

    /**
     * Realiza a pesquisa de empréstimos e reservas de um utente pelo seu NIF e intervalo de datas.
     * Exibe os empréstimos e as reservas feitas pelo utente dentro do intervalo informado.
     */
    public static void pesquisarEmprestimosEReservasPorUtente() {
        Scanner ler = new Scanner(System.in);

        // Solicita o NIF do utente para buscar seus empréstimos e reservas.
        System.out.println("\n--- Pesquisa de Empréstimos e Reservas por Utente ---");
        System.out.print("Insira o NIF do utente: ");
        String nif = ler.nextLine(); // Lê o NIF do utente informado pelo utilizador.

        // Verifica se o utente existe no sistema.
        Utente utente = CRUD.encontrarUtentePorNif(nif);
        if (utente == null) { // Caso o utente não seja encontrado.
            System.out.println("Utente não encontrado!");
            return; // Encerra a execução do método.
        }

        // Solicita o intervalo de datas para pesquisar empréstimos e reservas.
        LocalDate dataInicio = null, dataFim = null;

        // Lê a data de início com tratamento de exceção caso o formato da data seja inválido.
        while (dataInicio == null) {
            try {
                System.out.print("Insira a data de início (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        // Lê a data de fim com validação para garantir que seja posterior à data de início.
        while (dataFim == null) {
            try {
                System.out.print("Insira a data final (AAAA-MM-DD): ");
                dataFim = LocalDate.parse(ler.nextLine());
                if (dataFim.isBefore(dataInicio)) {
                    System.out.println("A data final não pode ser anterior à data de início.");
                    dataFim = null; // Reseta a data de fim para o utilizador tentar novamente.
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        // Pesquisa os empréstimos do utente dentro do intervalo de datas.
        System.out.println("\n--- Empréstimos do Utente no Intervalo de Datas ---");
        boolean encontrouEmprestimo = false; // Flag para verificar se algum empréstimo foi encontrado.
        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            if (emprestimo.getUtente().equals(nif) &&
                    !(emprestimo.getDataInicio().isBefore(dataInicio) || emprestimo.getDataInicio().isAfter(dataFim))) {
                encontrouEmprestimo = true;
                // Exibe as informações dos empréstimos encontrados.
                System.out.println("\nNúmero do Empréstimo: " + emprestimo.getNumero());
                System.out.println("Livros emprestados: " + emprestimo.getLivros());
                System.out.println("Data de início: " + emprestimo.getDataInicio());
                System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
                System.out.println("Data efetiva de devolução: " +
                        (emprestimo.getDataEfetivaDevolucao() != null ? emprestimo.getDataEfetivaDevolucao() : "Pendente"));
            }
        }
        // Caso nenhum empréstimo seja encontrado, exibe uma mensagem.
        if (!encontrouEmprestimo) {
            System.out.println("Nenhum empréstimo encontrado para este utente no intervalo de datas informado.");
        }

        // Pesquisa as reservas do utente dentro do intervalo de datas.
        System.out.println("\n--- Reservas do Utente no Intervalo de Datas ---");
        boolean encontrouReserva = false; // Flag para verificar se alguma reserva foi encontrada.
        for (Reserva reserva : Reserva.listaReservas) {
            if (reserva.getUtente().equals(nif) &&
                    !(reserva.getDataInicio().isBefore(dataInicio) || reserva.getDataInicio().isAfter(dataFim))) {
                encontrouReserva = true;
                // Exibe as informações das reservas encontradas.
                System.out.println("\nNúmero da Reserva: " + reserva.getNumero());
                System.out.println("Livros reservados: " + reserva.getLivros());
                System.out.println("Data de início: " + reserva.getDataInicio());
                System.out.println("Data de fim: " + reserva.getDataFim());
            }
        }

        // Caso nenhuma reserva seja encontrada, exibe uma mensagem.
        if (!encontrouReserva) {
            System.out.println("Nenhuma reserva encontrada para este utente no intervalo de datas informado.");
        }
    }
}