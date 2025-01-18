import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. CRUD");
            System.out.println("2. Criar Reserva");
            System.out.println("3. Criar Empréstimo");
            System.out.println("4. Apagar Reserva");
            System.out.println("5. Pesquisar Livros/Revistas/Jornais pelo ISBN/ISSN");
            System.out.println("6. Pesquisar Empréstimos e Reservas num intervalo de datas");
            System.out.println("7. Consultar/alterar a lista de livros de uma reserva ou de um empréstimo");
            System.out.println("8. Lista de utentes da biblioteca");
            System.out.println("9. Total de empréstimos realizados num intervalo de datas");
            System.out.println("10. Tempo médio (em dias) dos empréstimos realizados num intervalo de datas");
            System.out.println("11. Requisitado (empréstimos e reservas) durante um intervalo de datas");
            System.out.println("12. Lista dos utentes cuja devolução dos itens emprestados tenha um atraso superior a um número de dias");
            System.out.println("13. Registar em ficheiro toda a informação");
            System.out.println("14. Ler de um ficheiro toda a informação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    CRUD.main();
                    break;
                case 2:
                    Reserva.criarReserva();
                    break;
                case 3:
                    Emprestimo.criarEmprestimo();
                    break;
                case 4:
                    CRUD.ler();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
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
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

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

