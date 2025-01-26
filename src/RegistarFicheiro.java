import java.io.*;
import java.util.*;

public class RegistarFicheiro {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Revista> revistas = new ArrayList<>();
        List<Jornal> jornais = new ArrayList<>();
        List<Utente> utentes = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();

        // Exibição dos dados
        System.out.println("Livros:");
        livros.forEach(System.out::println);
        System.out.println("Revistas:");
        revistas.forEach(System.out::println);
        System.out.println("Jornais:");
        jornais.forEach(System.out::println);
        System.out.println("Utentes:");
        utentes.forEach(System.out::println);
        System.out.println("Reservas:");
        reservas.forEach(System.out::println);
        System.out.println("Emprestimos:");
        emprestimos.forEach(System.out::println);

        // Registro em ficheiro
        try (PrintWriter writer = new PrintWriter(new FileWriter("saida.txt"))) {
            for (Livro livro : livros) {
                writer.println("Livro;" + livro);
            }
            for (Revista revista : revistas) {
                writer.println("Revista;" + revista);
            }
            for (Jornal jornal : jornais) {
                writer.println("Jornal;" + jornal);
            }
            for (Utente utente : utentes) {
                writer.println("Utente;" + utente);
            }
            for (Reserva reserva : reservas) {
                writer.println("Reserva;" + reserva);
            }
            for (Emprestimo emprestimo : emprestimos) {
                writer.println("Emprestimo;" + emprestimo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}