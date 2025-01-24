import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PesquisaEmprestimo {
    class Emprestimo {
        private String utente;
        private LocalDate dataEmprestimo;

        public Emprestimo(String utente, LocalDate dataEmprestimo) {
            this.utente = utente;
            this.dataEmprestimo = dataEmprestimo;
        }

        public String getUtente() {
            return utente;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        @Override
        public String toString() {
            return "Empréstimo de " + utente + " em " + dataEmprestimo;
        }
    }

    class Reserva {
        private String utente;
        private LocalDate dataReserva;

        public Reserva(String utente, LocalDate dataReserva) {
            this.utente = utente;
            this.dataReserva = dataReserva;
        }

        public String getUtente() {
            return utente;
        }

        public LocalDate getDataReserva() {
            return dataReserva;
        }


        public String toString() {
            return "Reserva de " + utente + " em " + dataReserva;
        }
    }
    public class Biblioteca {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Listas para armazenar os empréstimos e reservas
            List<Emprestimo> emprestimos = new ArrayList<>();
            List<Reserva> reservas = new ArrayList<>();

            // Entrada do utilizador
            System.out.print("Digite o nome do utente: ");
            String utente = scanner.nextLine();

            System.out.print("Digite a data de início (yyyy-MM-dd): ");
            LocalDate inicio = LocalDate.parse(scanner.nextLine());

            System.out.print("Digite a data de fim (yyyy-MM-dd): ");
            LocalDate fim = LocalDate.parse(scanner.nextLine());

            // Pesquisa de empréstimos no intervalo
            List<Emprestimo> emprestimosFiltrados = new ArrayList<>();
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getUtente().equalsIgnoreCase(utente) &&
                        (emprestimo.getDataEmprestimo().isEqual(inicio) || emprestimo.getDataEmprestimo().isAfter(inicio)) &&
                        (emprestimo.getDataEmprestimo().isEqual(fim) || emprestimo.getDataEmprestimo().isBefore(fim))) {
                    emprestimosFiltrados.add(emprestimo);
                }
            }

            // Pesquisa de reservas no intervalo
            List<Reserva> reservasFiltradas = new ArrayList<>();
            for (Reserva reserva : reservas) {
                if (reserva.getUtente().equalsIgnoreCase(utente) &&
                        (reserva.getDataReserva().isEqual(inicio) || reserva.getDataReserva().isAfter(inicio)) &&
                        (reserva.getDataReserva().isEqual(fim) || reserva.getDataReserva().isBefore(fim))) {
                    reservasFiltradas.add(reserva);
                }
            }

            // Resultados
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

            scanner.close();
        }
    }
}
