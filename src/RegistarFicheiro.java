import java.io.*;
import java.util.*;

/**
 * Classe principal que demonstra o registro de dados de uma biblioteca em um ficheiro.
 * Esta classe inclui listas para armazenar objetos de diferentes categorias, como livros,
 * revistas, jornais, utentes, reservas e empréstimos. Além disso, exibe esses dados no
 * console e grava-os em um ficheiro de texto.
 */

public class RegistarFicheiro {
    /**
     * Metodo principal que inicializa listas de diferentes categorias e grava seus conteúdos
     * em um ficheiro de texto.
     * parametro args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Inicialização das listas
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("Biblioteca.txt"))) {
            // Grava cada tipo de entidade com prefixos no ficheiro

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
            // Tratamento de exceções de I/O
            e.printStackTrace();
        }
    }
}