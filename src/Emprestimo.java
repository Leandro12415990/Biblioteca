import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
/**
 * Classe que representa um empréstimo de livros.
 * Gerencia a criação, consulta e alteração de empréstimos.
 *
 * @author Daniel
 */
public class Emprestimo {
    /** Scanner para entrada de dados do usuário. */
    private static Scanner ler = new Scanner(System.in);

    /** Lista de todos os empréstimos realizados. */
    public static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>(100);

    /** Contador para geração automática do número do empréstimo. */
    private static int proximoNumero = 1;

    /** Número do empréstimo. */
    private int numero;

    /** NIF do utente responsável pelo empréstimo. */
    private String utente;

    /** Lista de livros incluídos no empréstimo. */
    private ArrayList<String> livros;

    /** Data de início do empréstimo. */
    private LocalDate dataInicio;

    /** Data prevista para devolução dos livros. */
    private LocalDate dataPrevistaDevolucao;

    /** Data efetiva de devolução dos livros. */
    private LocalDate dataEfetivaDevolucao;

    /** Variáveis auxiliares para cálculos estatísticos. */
    private static int nDias = 0;
    private static float total = 0;

    /**
     * Construtor da classe Emprestimo.
     *
     * @param utente NIF do utente responsável pelo empréstimo.
     * @param livros Lista de títulos dos livros emprestados.
     * @param dataInicio Data de início do empréstimo.
     * @param dataPrevistaDevolucao Data prevista para devolução.
     * @param dataEfetivaDevolucao Data efetiva de devolução (pode ser null).
     */

    public Emprestimo(String utente, ArrayList<String> livros, LocalDate dataInicio, LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public Emprestimo(int numero, String utente, ArrayList<String> livros, LocalDate dataInicio, LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        this.numero = numero;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    /**
     * Obtém o número do empréstimo.
     *
     * @return Número do empréstimo.
     */

    public int getNumero() {
        return numero;
    }
    /**
     * Define o número do empréstimo.
     *
     * @param numero Novo número do empréstimo.
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Define o número do empréstimo.
     *
     *  numero Novo número do empréstimo.
     */
    public String getUtente() {
        return utente;
    }
    /**
     * Define o NIF do utente responsável pelo empréstimo.
     *
     * @param utente Novo NIF do utente.
     */
    public void setUtente(String utente) {
        this.utente = utente;
    }
    /**
     * Obtém a lista de livros incluídos no empréstimo.
     *
     * @return Lista de livros emprestados.
     */
    public ArrayList<String> getLivros() {
        return livros;
    }
    /**
     * Define a lista de livros emprestados.
     *
     * @param livros Nova lista de livros.
     */

    public void setLivros(ArrayList<String> livros) {
        this.livros = livros != null ? livros : new ArrayList<>();
    }
    /**
     * Obtém a data de início do empréstimo.
     *
     * @return Data de início do empréstimo.
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    /**
     * Define a data de início do empréstimo.
     *
     * @param dataInicio Nova data de início.
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    /**
     * Obtém a data prevista para devolução do empréstimo.
     *
     * @return Data prevista para devolução.
     */
    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    /**
     * Define a data prevista para devolução do empréstimo.
     *
     *  dataPrevistaDevolucao Nova data prevista para devolução.
     */
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    /**
     * Obtém a data efetiva de devolução do empréstimo.
     *
     * @return Data efetiva de devolução.
     */

    public LocalDate getDataEfetivaDevolucao() {
        return dataEfetivaDevolucao;
    }
    /**
     * Define a data efetiva de devolução do empréstimo.
     *
     * @param dataEfetivaDevolucao Nova data efetiva de devolução.
     */

    public void setDataEfetivaDevolucao(LocalDate dataEfetivaDevolucao) {
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }
    /**
     * Método para criar um novo empréstimo.
     *
     * Solicita informações ao usuário, incluindo o NIF do utente, os livros a serem emprestados e as datas relevantes.
     * Valida a existência do utente e dos livros, bem como verifica conflitos de datas com outros empréstimos.
     * Se todas as verificações forem bem-sucedidas, o empréstimo é adicionado à lista de empréstimos.
     */
    public static void criarEmprestimo() {

        System.out.println("\n--- Criar Empréstimo ---");
        // Solicita e valida o NIF do utente.
        System.out.print("Insira o NIF do cliente: ");
        String utente;

        while (true) {
            utente = ler.nextLine();

            if (CRUD.encontrarUtentePorNif(utente) != null) {
                System.out.println("Utente encontrado no sistema.");
                break;
            } else {
                System.out.println("O utente não foi encontrado!");
                System.out.println("1. Tentar novamente\n0. Cancelar operação");
                System.out.print("Escolha uma opção: ");

                while (!ler.hasNextInt()) {
                    System.out.print("Entrada inválida. Escolha 1 para tentar novamente ou 0 para cancelar: ");
                    ler.next();
                }

                int opcao = ler.nextInt();
                ler.nextLine();

                if (opcao == 0) {
                    System.out.println("Operação cancelada.");
                    return;
                }

                System.out.print("Insira o NIF do cliente: ");
            }
        }

        // Solicita a quantidade de livros para o empréstimo e valida sua existência.
        System.out.print("Quantos livros deseja incluir no empréstimo? ");
        int quantidadeLivros = ler.nextInt();
        ler.nextLine();

        ArrayList<String> livrosParaEmprestimo = new ArrayList<>();
        for (int i = 0; i < quantidadeLivros; i++) {
            while (true) {
                System.out.print("Título do livro " + (i + 1) + ": ");
                String livro = ler.nextLine();

                if (CRUD.verificarLivroExistente(livro) != null) {
                    livrosParaEmprestimo.add(livro);
                    System.out.println("Livro adicionado ao empréstimo.");
                    break;
                } else {
                    System.out.println("Livro não encontrado no sistema.");
                    System.out.println("1. Tentar novamente\n0. Cancelar operação");
                    System.out.print("Escolha uma opção: ");

                    int opcao = ler.nextInt();
                    ler.nextLine();

                    if (opcao == 0) {
                        System.out.println("Operação cancelada.");
                        return;
                    }
                }
            }
        }
        // Solicita e valida a data de início do empréstimo.
        LocalDate dataInicio = null;
        while (dataInicio == null) {
            try {
                System.out.print("Data de início (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
        // Solicita e valida a data prevista de devolução.
        LocalDate dataPrevistaDevolucao = null;

        while (dataPrevistaDevolucao == null) {
            try {
                System.out.print("Data prevista de devolução (AAAA-MM-DD): ");
                String input = ler.nextLine();


                if (input.trim().isEmpty()) {
                    System.out.println("Data prevista de devolução não pode ser vazia. Tente novamente.");
                    continue;
                }

                dataPrevistaDevolucao = LocalDate.parse(input);

                if (dataPrevistaDevolucao.isBefore(dataInicio)) {
                    System.out.println("A data prevista de devolução não pode ser anterior à data de início.");
                    dataPrevistaDevolucao = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Certifique-se de usar o formato AAAA-MM-DD.");
            }
        }
        // Verifica se o usuário deseja inserir a data efetiva de devolução.
        LocalDate dataEfetivaDevolucao = null;
        System.out.print("Deseja inserir a data efetiva de devolução agora? (1 - Sim, 0 - Não): ");
        int inserirDataEfetiva = ler.nextInt();
        ler.nextLine();

        if (inserirDataEfetiva == 1) {
            while (dataEfetivaDevolucao == null) {
                try {
                    System.out.print("Data efetiva de devolução (AAAA-MM-DD): ");
                    String input = ler.nextLine();

                    if (input.trim().isEmpty()) {
                        System.out.println("A data efetiva de devolução não pode ser vazia se escolhida para inserção.");
                        continue;
                    }

                    dataEfetivaDevolucao = LocalDate.parse(input);

                    if (dataEfetivaDevolucao.isBefore(dataInicio)) {
                        System.out.println("A data efetiva de devolução não pode ser anterior à data de início.");
                        dataEfetivaDevolucao = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Certifique-se de usar o formato AAAA-MM-DD.");
                }
            }
        } else {
            System.out.println("Data efetiva de devolução será marcada como Pendente.");
        }

        for (String livro : livrosParaEmprestimo) {
            for (Emprestimo emprestimo : listaEmprestimos) {
                if (emprestimo.getLivros().contains(livro)) {
                    LocalDate emprestimoInicio = emprestimo.getDataInicio();
                    LocalDate emprestimoFim = emprestimo.getDataPrevistaDevolucao();

                    if (!(dataPrevistaDevolucao.isBefore(emprestimoInicio) || dataInicio.isAfter(emprestimoFim))) {
                        System.out.println("Não é possível criar o empréstimo. O livro '" + livro + "' já está emprestado.");
                        return;
                    }
                }
            }
        }
        // Cria e adiciona o empréstimo à lista.
        Emprestimo emprestimo = new Emprestimo(utente, livrosParaEmprestimo, dataInicio, dataPrevistaDevolucao, dataEfetivaDevolucao);
        listaEmprestimos.add(emprestimo);
        // Exibe os detalhes do empréstimo criado.
        System.out.println("\n Empréstimo Criado com Sucesso!");
        System.out.println("Número do empréstimo: " + emprestimo.getNumero());
        System.out.println("NIF do cliente: " + emprestimo.getUtente());
        System.out.println("Livros no empréstimo: " + emprestimo.getLivros());
        System.out.println("Data de início: " + emprestimo.getDataInicio());
        System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
        System.out.println("Data efetiva de devolução: " + (emprestimo.getDataEfetivaDevolucao() != null ? emprestimo.getDataEfetivaDevolucao() : "Pendente"));
    }

    /**
     * Método para consultar e alterar um empréstimo existente.
     *
     * Permite buscar um empréstimo pelo número, exibir os livros associados e adicionar ou remover livros do empréstimo.
     *
     * Se o número do empréstimo não for encontrado, exibe uma mensagem de erro.
     */
    public static void consultarAlterarEmprestimo() {
        System.out.print("Indique o número do empréstimo: ");
        int numeroEmprestimo = ler.nextInt();
        ler.nextLine();

        // Procura o empréstimo pelo número informado.
        Emprestimo emprestimo = null;
        for (Emprestimo e : Emprestimo.listaEmprestimos) {
            if (e.getNumero() == numeroEmprestimo) {
                emprestimo = e;
                break;
            }
        }

        // Se o empréstimo não for encontrado, exibe uma mensagem e encerra a função.
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado!");
            return;
        }

        // Exibe os livros associados ao empréstimo e permite alterações.
        while (true) {
            System.out.println("Livros associados ao empréstimo:");
            for (String livro : emprestimo.getLivros()) {
                System.out.println("- " + livro);
            }

            System.out.println("\nO que deseja fazer?");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    // Adiciona um novo livro ao empréstimo.
                    System.out.print("Informe o título do livro a ser adicionado: ");
                    String novoLivro = ler.nextLine();
                    if (CRUD.verificarLivroExistente(novoLivro) != null) {
                        if (!emprestimo.getLivros().contains(novoLivro)) {
                            emprestimo.getLivros().add(novoLivro);
                            System.out.println("Livro adicionado ao empréstimo.");
                        } else {
                            System.out.println("O livro já está associado a este empréstimo.");
                        }
                    } else {
                        System.out.println("Livro não encontrado no sistema.");
                    }
                    break;

                case 2:
                    // Remove um livro do empréstimo.
                    System.out.print("Informe o título do livro a ser removido: ");
                    String livroRemover = ler.nextLine();
                    if (emprestimo.getLivros().remove(livroRemover)) {
                        System.out.println("Livro removido do empréstimo.");
                    } else {
                        System.out.println("O livro não está associado a este empréstimo.");
                    }
                    break;

                case 0:
                    // Encerra a função e retorna ao menu anterior.
                    System.out.println("A sair do menu de alteração de empréstimos...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Método para calcular a média de dias de duração dos empréstimos realizados em um intervalo de tempo.
     *
     * Solicita ao usuário uma data de início e uma data final para considerar apenas os empréstimos dentro deste período.
     * Calcula a média de dias de duração dos empréstimos realizados.
     */
    public static void EmprestimosRealizados() {
        System.out.println("Insira a Data Inicio: ");
        LocalDate dataInicio = LocalDate.parse(ler.nextLine());
        System.out.println("Insira a Data Final: ");
        LocalDate dataFinal = LocalDate.parse(ler.nextLine());

        // Itera sobre a lista de empréstimos e calcula o total de dias dos empréstimos no período especificado.
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getDataInicio().isAfter(dataInicio) && emprestimo.getDataEfetivaDevolucao().isBefore(dataFinal)) {
                nDias++;
                long diasDeDiferenca = ChronoUnit.DAYS.between(emprestimo.getDataInicio(), emprestimo.getDataEfetivaDevolucao());
                total += diasDeDiferenca;
            }
        }

        // Exibe a média de duração dos empréstimos no intervalo informado.
        if (nDias > 0) {
            System.out.println("Média (em Dias): " + total / nDias);
        } else {
            System.out.println("Nenhum empréstimo realizado no período informado.");
        }
    }
}
