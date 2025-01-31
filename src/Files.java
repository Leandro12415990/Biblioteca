import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Files {
    private static Scanner scanner = new Scanner(System.in);

    public static void registarFicheiroLivros(List<Livro> livros)
    {
        try (FileWriter writer = new FileWriter("Livros.txt")) {
            for (Livro livro : livros) {
                writer.write(String.format("Titulo: %s; Editora: %s; Categoria: %s; Ano de Edicao: %s; ISBN: %s; Autor: %s\n",
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
        try (FileWriter writer = new FileWriter("Revistas.txt")) {
            for (Revista revista : revistas) {
                writer.write(String.format("Titulo: %s; Editora: %s; Categoria: %s; Issn: %s; Data de Publicacao: %s;\n",
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
        try (FileWriter writer = new FileWriter("Jornais.txt")) {
            for (Jornal jornal : jornais) {
                writer.write(String.format("Titulo: %s; Editora: %s; Categoria: %s; Issn: %s; Data de Publicacao: %s;\n",
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
        try (FileWriter writer = new FileWriter("Utentes.txt")) {
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
        try (FileWriter writer = new FileWriter("Reserva.txt")) {
            for (Reserva reserva : reservas) {
                System.out.println("ID: " + reserva.getNumero());
                writer.write(String.format("Numero: %d; Utente: %s; Livros: %s; Data de Registo: %s; Data de Inicio: %s; Data de Fim: %s\n",
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
        try (FileWriter writer = new FileWriter("Emprestimo.txt")) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.write(String.format("Numero: %d; Utente: %s; Livro: %s; Data de Inicio: %s; Data Prevista de Devolucao: %s; Data Efetiva de Devolucao: %s\n",
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
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Livros.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String anoEdicao = dados[3].replace("Ano de Edicao: ", "").trim();
                String isbn = dados[4].replace("ISBN: ", "").trim();
                String autor = dados[5].replace("Autor: ", "").trim();

                Livro livro = new Livro(titulo, editora, categoria, anoEdicao, isbn, autor);
                CRUD.livros.add(livro);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar livros: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " livros");
        return CRUD.livros;
    }
    public static List<Revista> LerRevistas() {
        List<Revista> revistas = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Revistas.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String issn = dados[3].replace("Issn: ", "").trim();
                String dataPublicacao = dados[4].replace("Data de Publicacao: ", "").trim();

                Revista revista = new Revista(titulo, editora, categoria, issn, dataPublicacao);
                CRUD.revistas.add(revista);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar revistas: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " revistas");
        return CRUD.revistas;
    }
    public static List<Jornal> LerJornais() {
        List<Jornal> jornais = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Jornais.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String titulo = dados[0].replace("Titulo: ", "").trim();
                String editora = dados[1].replace("Editora: ", "").trim();
                String categoria = dados[2].replace("Categoria: ", "").trim();
                String issn = dados[4].replace("Issn: ", "").trim();
                String dataPublicacao = dados[5].replace("Data de Publicacao: ", "").trim();

                Jornal jornal = new Jornal(titulo, editora, categoria, issn, dataPublicacao);
                CRUD.jornais.add(jornal);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar jornais: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " jornais");
        return CRUD.jornais;
    }
    public static List<Utente> LerUtentes() {
        List<Utente> utentes = new ArrayList<>();
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Utentes.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                String nif = dados[0].replace("NIF: ", "").trim();
                String nome = dados[1].replace("Nome: ", "").trim();
                String genero = dados[2].replace("Genero: ", "").trim();
                String icontactossn = dados[4].replace("Contacto: ", "").trim();

                Utente utente = new Utente(nif, nome, genero, icontactossn);
                CRUD.utentes.add(utente);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar utentes: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " utentes");
        return CRUD.utentes;
    }
    public static List<Reserva> LerReservas() {
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Reservas.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                int numero = Integer.parseInt(dados[0].replace("Numero: ", "").trim());
                String utente = dados[1].replace("Utente: ", "").trim();
                String livros = dados[2].replace("Livros: [", "").trim();
                ArrayList<String> livrosReservados = new ArrayList<>(Arrays.asList(livros.split(",")));



                LocalDate dataRegisto = LocalDate.parse(dados[3].replace("Data de Registo: ", "").trim());
                LocalDate dataInicio = LocalDate.parse(dados[4].replace(" Data de Inicio: ", "").trim());
                LocalDate dataFim = LocalDate.parse(dados[5].replace("Data de Fim: ", "").trim());

                Reserva reserva = new Reserva(numero, utente, livrosReservados, dataRegisto, dataInicio, dataFim);
                Reserva.listaReservas.add(reserva);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar Reservas: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " Reservas");
        System.out.println(Reserva.listaReservas);
        for (Reserva r : Reserva.listaReservas) {
            System.out.println(r.getNumero());
            System.out.println(r.getLivros());
            System.out.println(r.getUtente());
        }
        return Reserva.listaReservas;
    }
    public static List<Emprestimo> LerEmprestimos() {
        int countLinhas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Emprestimo.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(";");

                int numero = Integer.parseInt(dados[0].replace("Numero: ", "").trim());
                String utente = dados[1].replace("Utente: ", "").trim();
                String livros = dados[2].replace("Livros: [", "").trim();
                ArrayList<String> livrosReservados = new ArrayList<>(Arrays.asList(livros.split(",")));



                LocalDate dataInicio = LocalDate.parse(dados[3].replace("Data de Inicio: ", "").trim());
                LocalDate dataPrevistaDevolucao = LocalDate.parse(dados[4].replace("Data Prevista de Devolucao: ", "").trim());
                LocalDate dataEfetivaDevolucao = LocalDate.parse(dados[5].replace("Data Efetiva de Devolucao: ", "").trim());

                Emprestimo emprestimo = new Emprestimo(numero, utente, livrosReservados, dataInicio, dataPrevistaDevolucao, dataEfetivaDevolucao);
                Emprestimo.listaEmprestimos.add(emprestimo);
                countLinhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar Reservas: " + e.getMessage());
        }
        System.out.println("Foram lidos um total de: " + countLinhas + " Emprestimos");
        return Emprestimo.listaEmprestimos;
    }
}
