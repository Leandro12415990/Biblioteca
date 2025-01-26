import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Files {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Livro> livros = new ArrayList<Livro>();
    private static ArrayList<Revista> revistas = new ArrayList<Revista>();
    private static ArrayList<Jornal> jornais = new ArrayList<Jornal>();
    private static ArrayList<Utente> utentes = new ArrayList<Utente>();
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("Deseja registar ou ler: ");
            System.out.println("1. Registar ");
            System.out.println("2. ler ");
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

        if (opcao == 1) LerFicheiro();
    }

    private static void LerFicheiro()
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Biblioteca.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(";"); // Supondo que os campos são separados por ponto e vírgula

                // O ficheiro contem dados de livros (exemplo: Livro;Autor;ISBN...)
                if (partes.length == 6) {
                    livros.add(new Livro(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]));
                }
                else if (partes.length == 5) {
                    jornais.add(new Jornal(partes[0], partes[1], partes[2], partes[3], partes[4]));
                }
                else if (partes.length == 5) {
                    revistas.add(new Revista(partes[0], partes[1], partes[2], partes[3], partes[4]));
                }
                // O ficheiro contem dados de utentes (exemplo: Nome, Contacto...)
                else if (partes.length == 4) {
                    utentes.add(new Utente(partes[0], partes[1], partes[2], partes[3]);
                }
                // Se o ficheiro contiver dados de reservas (exemplo: Utente;Livro;Data)
                else if (partes.length == 6) {
                    reservas.add(new Reserva(partes[0], partes[1], partes[2], partes[3]));
                }
                else if (partes.length == 3) {
                    emprestimos.add(new Emprestimo(partes[0], partes[1], partes[2], partes[3], partes[4]));
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exibir os dados lidos
        System.out.println("Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
        System.out.println("\nJornais:");
        for (Jornal jornal : jornais) {
            System.out.println(jornal);
        }
        System.out.println("\nRevistas:");
        for (Revista revista : revistas) {
            System.out.println(revista);
        }
        System.out.println("\nUtentes:");
        for (Utente utente : utentes) {
            System.out.println(utente);
        }
        System.out.println("\nReservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
        System.out.println("\nEmprestimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }
}
