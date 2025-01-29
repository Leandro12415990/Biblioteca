import java.time.LocalDate;
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

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String anoEdicao = dados[3].replace("AnoEdicao: ", "").trim();
                String isbn = dados[4].replace("Isbn: ", "").trim();
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
    public static List<Revista> LerRevistas() {
        List<Revista> revistas = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String issn = dados[4].replace("Isbn: ", "").trim();
                String dataPublicacao = dados[5].replace("DataPublicacao: ", "").trim();

                Revista revista = new Revista(titulo, editora, categoria, issn, dataPublicacao);
                revistas.add(revista);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar revistas: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " revistas");
        return revistas;
    }
    public static List<Jornal> LerJornais() {
        List<Jornal> jornais = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String issn = dados[4].replace("Isbn: ", "").trim();
                String dataPublicacao = dados[5].replace("DataPublicacao: ", "").trim();

                Jornal jornal = new Jornal(titulo, editora, categoria, issn, dataPublicacao);
                jornais.add(jornal);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar jornais: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " jornais");
        return jornais;
    }
    public static List<Utente> LerUtentes() {
        List<Utente> utentes = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String nif = dados[0].replace("Titulo: ", "").trim();
                String nome = dados[1].replace("Editora: ", "").trim();
                String genero = dados[2].replace("Categoria: ", "").trim();
                String icontactossn = dados[4].replace("Isbn: ", "").trim();

                Utente utente = new Utente(nif, nome, genero, icontactossn);
                utentes.add(utente);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar utentes: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " utentes");
        return utentes;
    }
    public static List<Reserva> LerReservas() {
        List<Reserva> reservas = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                int numero = Integer.parseInt(dados[4].replace("Numero: ", "").trim());
                String utente = dados[1].replace("Utente: ", "").trim();
                //ArrayList<String> livros = dados[2].replace("Livros: ", "").trim();
                LocalDate dataRegisto = LocalDate.parse(dados[4].replace("dataRegisto: ", "").trim());
                LocalDate dataInicio = LocalDate.parse(dados[5].replace("DataInicio: ", "").trim());
                LocalDate dataFim = LocalDate.parse(dados[6].replace("DataFim: ", "").trim());

                //Reserva reserva = new Reserva(numero, utente, livros, dataRegisto, dataInicio, dataFim);
                //reservas.add(reserva);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar utentes: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " utentes");
        return reservas;
    }
    public static List<Emprestimo> LerEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                int numero = Integer.parseInt(dados[4].replace("Numero: ", "").trim());
                String utente = dados[1].replace("Utente: ", "").trim();
                //ArrayList<String> livros = dados[2].replace("Livros: ", "").trim();
                LocalDate dataInicio = LocalDate.parse(dados[4].replace("dataRegisto: ", "").trim());
                LocalDate dataPrevistaDevolucao = LocalDate.parse(dados[5].replace("DataInicio: ", "").trim());
                LocalDate dataEfetivaDevolucao = LocalDate.parse(dados[6].replace("DataFim: ", "").trim());

                //Emprestimo emprestimo = new Emprestimo(numero, utente, livros, dataInicio, dataPrevistaDevolucao, dataEfetivaDevolucao);
                //emprestimos.add(emprestimo);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar utentes: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " utentes");
        return emprestimos;
    }
}
