import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

    public static void pesquisarEmprestimosEReservasPorUtente() {
        Scanner ler = new Scanner(System.in);

        // Solicita o NIF do utente
        System.out.println("\n--- Pesquisa de Empréstimos e Reservas por Utente ---");
        System.out.print("Insira o NIF do utente: ");
        String nif = ler.nextLine();

        // Verifica se o utente existe
        Utente utente = CRUD.encontrarUtentePorNif(nif);
        if (utente == null) {
            System.out.println("Utente não encontrado!");
            return;
        }

        // Solicita o intervalo de datas
        LocalDate dataInicio = null, dataFim = null;

        while (dataInicio == null) {
            try {
                System.out.print("Insira a data de início (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        while (dataFim == null) {
            try {
                System.out.print("Insira a data final (AAAA-MM-DD): ");
                dataFim = LocalDate.parse(ler.nextLine());
                if (dataFim.isBefore(dataInicio)) {
                    System.out.println("A data final não pode ser anterior à data de início.");
                    dataFim = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        // Pesquisa os empréstimos do utente no intervalo de datas
        System.out.println("\n--- Empréstimos do Utente no Intervalo de Datas ---");
        boolean encontrouEmprestimo = false;
        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            if (emprestimo.getUtente().equals(nif) &&
                    !(emprestimo.getDataInicio().isBefore(dataInicio) || emprestimo.getDataInicio().isAfter(dataFim))) {
                encontrouEmprestimo = true;
                System.out.println("\nNúmero do Empréstimo: " + emprestimo.getNumero());
                System.out.println("Livros emprestados: " + emprestimo.getLivros());
                System.out.println("Data de início: " + emprestimo.getDataInicio());
                System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
                System.out.println("Data efetiva de devolução: " +
                        (emprestimo.getDataEfetivaDevolucao() != null ? emprestimo.getDataEfetivaDevolucao() : "Pendente"));
            }
        }
        if (!encontrouEmprestimo) {
            System.out.println("Nenhum empréstimo encontrado para este utente no intervalo de datas informado.");
        }

        // Pesquisa as reservas do utente no intervalo de datas
        System.out.println("\n--- Reservas do Utente no Intervalo de Datas ---");
        boolean encontrouReserva = false;
        for (Reserva reserva : Reserva.listaReservas) {
            if (reserva.getUtente().equals(nif) &&
                    !(reserva.getDataInicio().isBefore(dataInicio) || reserva.getDataInicio().isAfter(dataFim))) {
                encontrouReserva = true;
                System.out.println("\nNúmero da Reserva: " + reserva.getNumero());
                System.out.println("Livros reservados: " + reserva.getLivros());
                System.out.println("Data de início: " + reserva.getDataInicio());
                System.out.println("Data de fim: " + reserva.getDataFim());
            }
        }
        if (!encontrouReserva) {
            System.out.println("Nenhuma reserva encontrada para este utente no intervalo de datas informado.");
        }
    }
}
