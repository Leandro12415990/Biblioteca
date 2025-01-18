import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {
    public static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>(100);
    private static int proximoNumero = 1;
    private int numero;
    private String utente;
    private ArrayList<String> livros;
    private LocalDate dataInicio;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataEfetivaDevolucao;

    public Emprestimo(String utente, ArrayList<String> livros, LocalDate dataInicio, LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livros = livros != null ? livros : new ArrayList<>();
        this.dataInicio = dataInicio;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public ArrayList<String> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<String> livros) {
        this.livros = livros != null ? livros : new ArrayList<>();
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataEfetivaDevolucao() {
        return dataEfetivaDevolucao;
    }

    public void setDataEfetivaDevolucao(LocalDate dataEfetivaDevolucao) {
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public static void criarEmprestimo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Empréstimo ---");

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

        LocalDate dataInicio = null;
        while (dataInicio == null) {
            try {
                System.out.print("Data de início (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        LocalDate dataPrevistaDevolucao = null; // Inicializa como nulo

// Loop para garantir que a entrada seja válida
        while (dataPrevistaDevolucao == null) {
            try {
                System.out.print("Data prevista de devolução (AAAA-MM-DD): ");
                String input = ler.nextLine(); // Lê a entrada do usuário

                // Verifica se o usuário deixou em branco
                if (input.trim().isEmpty()) {
                    System.out.println("Data prevista de devolução não pode ser vazia. Tente novamente.");
                    continue; // Reinicia o loop
                }

                // Tenta parsear a data
                dataPrevistaDevolucao = LocalDate.parse(input);

                // Valida se a data de devolução é depois ou igual à data de início
                if (dataPrevistaDevolucao.isBefore(dataInicio)) {
                    System.out.println("A data prevista de devolução não pode ser anterior à data de início.");
                    dataPrevistaDevolucao = null; // Reseta para repetir o loop
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Certifique-se de usar o formato AAAA-MM-DD.");
            }
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

        Emprestimo emprestimo = new Emprestimo(utente, livrosParaEmprestimo, dataInicio, dataPrevistaDevolucao, null);
        listaEmprestimos.add(emprestimo);

        System.out.println("\n Empréstimo Criado com Sucesso!");
        System.out.println("Número do empréstimo: " + emprestimo.getNumero());
        System.out.println("NIF do cliente: " + emprestimo.getUtente());
        System.out.println("Livros no empréstimo: " + emprestimo.getLivros());
        System.out.println("Data de início: " + emprestimo.getDataInicio());
        System.out.println("Data prevista de devolução: " + emprestimo.getDataPrevistaDevolucao());
        System.out.println("Data efetiva de devolução: Pendente");
    }

    public static void consultarAlterarEmprestimo(){
        Scanner ler = new Scanner(System.in);

        System.out.print("Indique o número do empréstimo: ");
        int numeroEmprestimo = ler.nextInt();
        ler.nextLine();

        Emprestimo emprestimo = null;
        for (Emprestimo e : Emprestimo.listaEmprestimos) {
            if (e.getNumero() == numeroEmprestimo) {
                emprestimo = e;
                break;
            }
        }

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado!");
            return;
        }

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

                    System.out.print("Informe o título do livro a ser removido: ");
                    String livroRemover = ler.nextLine();
                    if (emprestimo.getLivros().remove(livroRemover)) {
                        System.out.println("Livro removido do empréstimo.");
                    } else {
                        System.out.println("O livro não está associado a este empréstimo.");
                    }
                    break;

                case 0:

                    System.out.println("A sair do menu de alteração de empréstimos...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void totalEmprestimosPorIntervalo(){
        Scanner ler = new Scanner(System.in);

        LocalDate dataInicio = null;
        while(dataInicio == null){
            try{
                System.out.println("Insira a hora de Inicio (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            }catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        LocalDate dataFim = null;
        while(dataFim == null){
            try{
                System.out.println("Insira a hora de Inicio (AAAA-MM-DD): ");
                dataFim = LocalDate.parse(ler.nextLine());
                if(dataFim.isBefore(dataInicio)){
                    System.out.println("A data de fim não pode ser anterior à data de início. Tente novamente.");
                    dataFim = null;
                }
            }catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        int totalEmprestimos = 0;
            for(Emprestimo emprestimo: Emprestimo.listaEmprestimos){
                LocalDate dataEmprestimo = emprestimo.getDataInicio();
                if(dataEmprestimo.isEqual(dataInicio) || dataEmprestimo.isAfter(dataFim) && dataEmprestimo.isEqual(dataFim) || dataEmprestimo.isBefore(dataFim)){
                    totalEmprestimos++;
                }
            }

        System.out.println("\n--- Total de Empréstimos no Intervalo de Datas ---");
        System.out.println("Intervalo: " + dataInicio + " a " + dataFim);
        System.out.println("Total de Empréstimos: " + totalEmprestimos);
    }

}
