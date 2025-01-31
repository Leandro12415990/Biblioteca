import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe principal que oferece o menu interativo para o utilizador escolher entre várias funcionalidades
 * relacionadas ao CRUD, reservas, empréstimos, pesquisas, estatísticas e manipulação de arquivos.
 */
public class Main {

    /**
     * Método principal que exibe um menu com opções interativas para o utilizador.
     * Dependendo da escolha do utilizador, o sistema chama os métodos apropriados para manipulação
     * de dados ou exibição de informações.
     */
    public static void main(String[] args) {
        // Scanner para entrada de dados do utilizador
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Controlo para manter o programa em execução

        // Loop principal para exibição do menu até que o utilizador escolha sair
        while (running) {
            // Exibe o menu de opções
            System.out.println("\n=== MENU ===");
            System.out.println("1. CRUD - Criar");
            System.out.println("2. CRUD - Ler");
            System.out.println("3. CRUD - Alterar");
            System.out.println("4. CRUD - Remover");
            System.out.println("5. Criar Reserva");
            System.out.println("6. Criar Empréstimo");
            System.out.println("7. Apagar Reserva");
            System.out.println("8. Pesquisar Livros/Revistas/Jornais pelo ISBN/ISSN");
            System.out.println("9. Pesquisar Empréstimos e Reservas num intervalo de datas");
            System.out.println("10. Consultar/alterar a lista de livros de uma reserva ou de um empréstimo");
            System.out.println("11. Lista de utentes da biblioteca");
            System.out.println("12. Total de empréstimos realizados num intervalo de datas");
            System.out.println("13. Tempo médio (em dias) dos empréstimos realizados num intervalo de datas");
            System.out.println("14. Requisitado (empréstimos e reservas) durante um intervalo de datas");
            System.out.println("15. Lista dos utentes cuja devolução dos itens emprestados tenha um atraso superior a um número de dias");
            System.out.println("16. Registar em ficheiro toda a informação");
            System.out.println("17. Ler de um ficheiro toda a informação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção escolhida pelo utilizador
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            // Ação baseada na opção escolhida pelo utilizador
            switch (opcao) {
                case 1:
                    CRUD.main(); // Chama o método de criação no CRUD
                    break;
                case 2:
                    CRUD.ler(); // Chama o método de leitura no CRUD
                    break;
                case 3:
                    CRUD.update(); // Chama o método de alteração no CRUD
                    break;
                case 4:
                    CRUD.remover(); // Chama o método de remoção no CRUD
                    break;
                case 5:
                    Reserva.criarReserva(); // Cria uma nova reserva
                    break;
                case 6:
                    Emprestimo.criarEmprestimo(); // Cria um novo empréstimo
                    break;
                case 7:
                    Reserva.removerReserva(); // Remove uma reserva existente
                    break;
                case 8:
                    // Exibe o menu para pesquisar livros, revistas ou jornais
                    System.out.println("Insira uma opção: ");
                    System.out.println("1. Pesquisar Livros.");
                    System.out.println("2. Pesquisar Revistas.");
                    System.out.println("3. Pesquisar Jornais.");
                    System.out.println("0. Sair");
                    int escolha2 = scanner.nextInt();
                    switch (escolha2){
                        case 1:
                            Pesquisa.pesquisarLivros(); // Pesquisa livros
                            break;
                        case 2:
                            Pesquisa.pesquisarRevistas(); // Pesquisa revistas
                            break;
                        case 3:
                            Pesquisa.pesquisarJornais(); // Pesquisa jornais
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                case 9:
                    Pesquisa.pesquisarEmprestimosEReservasPorUtente(); // Pesquisa empréstimos e reservas por utente
                    break;
                case 10:
                    // Menu para consultar ou alterar empréstimos e reservas
                    Scanner ler = new Scanner(System.in);
                    int escolha = 0;
                    do {
                        System.out.println("Escolha a opção que deseja ir: ");
                        System.out.println("1. Consultar/Alterar Emprestimo ");
                        System.out.println("2. Consultar/Alterar Reserva ");
                        escolha = ler.nextInt();
                        ler.nextLine(); // Limpa o buffer de entrada
                    } while (escolha != 1 && escolha != 2);

                    if (escolha == 1) {
                        Emprestimo.consultarAlterarEmprestimo(); // Consulta ou altera um empréstimo
                    } else {
                        Reserva.consultarAlterarReserva(); // Consulta ou altera uma reserva
                    }
                    break;
                case 11:
                    Estatistica.apresentarListaDeUtentes(); // Apresenta a lista de utentes
                    break;
                case 12:
                    Estatistica.totalEmprestimosPorIntervalo(); // Exibe o total de empréstimos por intervalo de datas
                    break;
                case 13:
                    Estatistica.EmprestimosRealizados(); // Exibe estatísticas sobre empréstimos realizados
                    break;
                case 14:
                    Estatistica.itemMaisRequisitado(); // Exibe o item mais requisitado
                    break;
                case 15:
                    Estatistica.utentesComAtraso(); // Exibe os utentes com atraso na devolução
                    break;
                case 16:
                    Files.registarFicheiroLivros(CRUD.livros); // Regista livros em um arquivo
                    break;
                case 17:
                    Files.registarFicheiroRevistas(CRUD.revistas); // Regista revistas em um arquivo
                    break;
                case 18:
                    Files.registarFicheiroJornais(CRUD.jornais); // Regista jornais em um arquivo
                    break;
                case 19:
                    Files.registarFicheiroUtentes(CRUD.utentes); // Regista utentes em um arquivo
                    break;
                case 20:
                    Files.registarFicheiroReserva(Reserva.listaReservas); // Regista reservas em um arquivo
                    break;
                case 21:
                    Files.registarFicheiroEmprestimo(Emprestimo.listaEmprestimos); // Regista empréstimos em um arquivo
                    break;
                case 0:
                    running = false; // Encerra o loop e finaliza o programa
                    System.out.println("A sair do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Caso a opção seja inválida
            }
        }
    }
}

