import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Files {
    private static Scanner scanner = new Scanner(System.in);

    public static void registarFicheiroLivros(List<Livro> livros)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Livro livro : livros) {
                writer.write(String.format("ISBN: %s; Nome: %s; Editora: %s; Categoria: %s; Ano: %s; Autor: %s\n",
                        livro.getTitulo(),
                        livro.getEditora(),
                        livro.getCategoria(),
                        livro.getAnoEdicao(),
                        livro.getIsbn(),
                        livro.getAutor()));
            }
            System.out.println("\nLivros exportados com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }
    public static void registarFicheiroRevistas(List<Revista> revistas)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Revista revista : revistas) {
                writer.write(String.format("Titulo: %s; Editora: %s; Categoria: %s; Issn: %s; Data de Publicação: %s;\n",
                        revista.getTitulo(),
                        revista.getEditora(),
                        revista.getCategoria(),
                        revista.getIssn(),
                        revista.getDataPublicacao()));
            }
            System.out.println("\nRevistas exportados com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as Revistas: " + e.getMessage());
        }
    }
    public static void registarFicheiroJornais(List<Jornal> jornais)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Jornal jornal : jornais) {
                writer.write(String.format("Titulo: %s; Editora: %s; Categoria: %s; Issn: %s; Data de Publicação: %s;\n",
                        jornal.getTitulo(),
                        jornal.getEditora(),
                        jornal.getCategoria(),
                        jornal.getIssn(),
                        jornal.getDataPublicacao()));
            }
            System.out.println("\nJornais exportados com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os jornais: " + e.getMessage());
        }
    }
    public static void registarFicheiroUtentes(List<Utente> utentes)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Utente utente : utentes) {
                writer.write(String.format("NIF: %s; Nome: %s; Genero: %s; Contacto: %s\n",
                        utente.getNif(),
                        utente.getNome(),
                        utente.getGenero(),
                        utente.getContacto()));
            }
            System.out.println("\nUtentes exportados com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os utentes: " + e.getMessage());
        }
    }
    public static void registarFicheiroReserva(List<Reserva> reservas)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Reserva reserva : reservas) {
                writer.write(String.format("Número: %d; Utente: %s; Livro: %s; Data de registo: %s; Data de Inicio: %s; Data de Fim: %s\n",
                        reserva.getNumero(),
                        reserva.getUtente(),
                        reserva.getLivros(),
                        reserva.getDataRegisto(),
                        reserva.getDataInicio(),
                        reserva.getDataFim()));
            }
            System.out.println("\nReservas exportadas com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os reservas: " + e.getMessage());
        }
    }
    public static void registarFicheiroEmprestimo(List<Emprestimo> emprestimos)
    {
        try (FileWriter writer = new FileWriter("Biblioteca.txt")) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.write(String.format("Número: %d; Utente: %s; Livro: %s; Data de Inicio: %s; Data Prevista de Devolução: %s; Data Efetiva de Devolução: %s\n",
                        emprestimo.getNumero(),
                        emprestimo.getUtente(),
                        emprestimo.getLivros(),
                        emprestimo.getDataInicio(),
                        emprestimo.getDataPrevistaDevolucao(),
                        emprestimo.getDataEfetivaDevolucao()));
            }
            System.out.println("\nEmprestimos exportados com sucesso para o ficheiro!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os emprestimos: " + e.getMessage());
        }
    }

    public static List<Livro> LerLivros() {
        List<Livro> livros = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("ISBN: ", "").trim();
                String editora = dados[1].replace("Nome: ", "").trim();
                String categoria = dados[2].replace("Editora: ", "").trim();
                String anoEdicao = dados[3].replace("Categoria: ", "").trim();
                String isbn = dados[4].replace("Ano: ", "").trim();
                String autor = dados[5].replace("Autor: ", "").trim();

                Livro livro = new Livro(titulo, editora, categoria, anoEdicao, isbn, autor);
                livros.add(livro);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar livros: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " livros");
        return livros;
    }

}
