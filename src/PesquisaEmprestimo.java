import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A classe PesquisaEmprestimo é responsável por permitir a pesquisa de empréstimos e reservas feitos por um utente
 * dentro de um intervalo de datas específico. Ela contém classes internas para representar os empréstimos, reservas
 * e a lógica para realizar a pesquisa e apresentar os resultados.
 */
public class PesquisaEmprestimo {

    /**
     * A classe Emprestimo representa um empréstimo realizado por um utente, com informações sobre o utente e a data
     * em que o empréstimo foi realizado.
     */
    class Emprestimo {

        private String utente;
        private LocalDate dataEmprestimo;

        /**
         * Construtor que cria um objeto Emprestimo com as informações do utente e data do empréstimo.
         *
         * @param utente O nome do utente que realizou o empréstimo.
         * @param dataEmprestimo A data em que o empréstimo foi realizado.
         */
        public Emprestimo(String utente, LocalDate dataEmprestimo) {
            this.utente = utente;
            this.dataEmprestimo = dataEmprestimo;
        }

        /**
         * Retorna o nome do utente.
         */
        public String getUtente() {
            return utente;
        }

        /**
         * Retorna a data do empréstimo.
         */
        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        /**
         * Retorna uma representação em string do empréstimo, com informações sobre o utente e a data.
         */
        @Override
        public String toString() {
            return "Empréstimo de " + utente + " em " + dataEmprestimo;
        }
    }

    /**
     * A classe Reserva representa uma reserva feita por um utente, com informações sobre o utente e a data da reserva.
     */
    class Reserva {

        private String utente;
        private LocalDate dataReserva;

        /**
         * Construtor que cria um objeto Reserva com as informações do utente e data da reserva.
         */
        public Reserva(String utente, LocalDate dataReserva) {
            this.utente = utente;
            this.dataReserva = dataReserva;
        }

        /**
         * Retorna o nome do utente.
         */
        public String getUtente() {
            return utente;
        }

        /**
         * Retorna a data da reserva.
         */
        public LocalDate getDataReserva() {
            return dataReserva;
        }

        /**
         * Retorna uma representação em string da reserva, com informações sobre o utente e a data.
         */
        public String toString() {
            return "Reserva de " + utente + " em " + dataReserva;
        }
    }

    /**
     * A classe Biblioteca contém o método principal que permite realizar a pesquisa de empréstimos e reservas feitos
     * por um utente dentro de um intervalo de datas fornecido pelo utilizador.
     */
    public class Biblioteca {

        /**
         * O método main é responsável por executar a lógica de entrada do utilizador, pesquisa de empréstimos e reservas
         * no intervalo de datas fornecido e exibição dos resultados.
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Listas para armazenar os empréstimos e reservas
            List<Emprestimo> emprestimos = new ArrayList<>();
            List<Reserva> reservas = new ArrayList<>();

            // Entrada do utilizador
            System.out.print("Digite o nome do utente: ");
            String utente = scanner.nextLine();

            // Entrada da data de início e fim para o intervalo da pesquisa
            System.out.print("Digite a data de início (yyyy-MM-dd): ");
            LocalDate inicio = LocalDate.parse(scanner.nextLine());

            System.out.print("Digite a data de fim (yyyy-MM-dd): ");
            LocalDate fim = LocalDate.parse(scanner.nextLine());

            // Pesquisa de empréstimos no intervalo das datas
            List<Emprestimo> emprestimosFiltrados = new ArrayList<>();
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getUtente().equalsIgnoreCase(utente) &&
                        (emprestimo.getDataEmprestimo().isEqual(inicio) || emprestimo.getDataEmprestimo().isAfter(inicio)) &&
                        (emprestimo.getDataEmprestimo().isEqual(fim) || emprestimo.getDataEmprestimo().isBefore(fim))) {
                    emprestimosFiltrados.add(emprestimo);
                }
            }

            // Pesquisa de reservas no intervalo das datas
            List<Reserva> reservasFiltradas = new ArrayList<>();
            for (Reserva reserva : reservas) {
                if (reserva.getUtente().equalsIgnoreCase(utente) &&
                        (reserva.getDataReserva().isEqual(inicio) || reserva.getDataReserva().isAfter(inicio)) &&
                        (reserva.getDataReserva().isEqual(fim) || reserva.getDataReserva().isBefore(fim))) {
                    reservasFiltradas.add(reserva);
                }
            }

            // Resultados da pesquisa
            System.out.println("\nEmpréstimos de " + utente + " no intervalo:");
            if (emprestimosFiltrados.isEmpty()) {
                System.out.println("Nenhum empréstimo encontrado.");
            } else {
                for (Emprestimo emprestimo : emprestimosFiltrados) {
                    System.out.println(emprestimo);
                }
            }

            System.out.println("\nReservas de " + utente + " no intervalo:");
            if (reservasFiltradas.isEmpty()) {
                System.out.println("Nenhuma reserva encontrada.");
            } else {
                for (Reserva reserva : reservasFiltradas) {
                    System.out.println(reserva);
                }
            }

            // Fecha o scanner para evitar perda de recursos
            scanner.close();
        }
    }
}