import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
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

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    CRUD.main();
                    break;
                case 2:
                    CRUD.ler();
                    break;
                case 3:
                    CRUD.update();
                    break;
                case 4:
                    CRUD.remover();
                    break;
                case 5:
                    Reserva.criarReserva();
                    break;
                case 6:
                    Emprestimo.criarEmprestimo();
                    break;
                case 7:
                    Reserva.removerReserva();
                    break;
                case 8:

                case 9:

                    break;
                case 10:
                    Scanner ler = new Scanner(System.in);
                    int escolha = 0;
                    do {
                        System.out.println("Escolha a opção que deseja ir: ");
                        System.out.println("1. Consultar/Alterar Emprestimo ");
                        System.out.println("2. Consultar/Alterar Reserva ");

                        escolha = ler.nextInt();
                        ler.nextLine();
                    } while (escolha != 1 && escolha != 2);

                    if( escolha == 1){
                        Emprestimo.consultarAlterarEmprestimo();
                    }else
                        Reserva.consultarAlterarReserva();
                    break;
                case 11:
                    Estatistica.apresentarListaDeUtentes();
                    break;
                case 12:
                    Estatistica.totalEmprestimosPorIntervalo();
                    break;
                case 13:
                    Estatistica.EmprestimosRealizados();
                    break;
                case 14:
                    Estatistica.itemMaisRequisitado();
                    break;
                case 15:
                    Estatistica.utentesComAtraso();
                    break;
                case 0:
                    running = false;
                    System.out.println("A sair do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

