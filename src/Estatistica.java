import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Classe que fornece estatísticas sobre empréstimos e reservas na biblioteca.
 * Inclui funcionalidades para análise de dados, como total de empréstimos,
 * itens mais requisitados e utentes com atrasos.
 *
 * @author Daniel
 */

public class Estatistica {
    /**
     * Calcula o total de empréstimos realizados dentro de um intervalo de tempo especificado pelo usuário.
     */
    public static void totalEmprestimosPorIntervalo(){
        Scanner ler = new Scanner(System.in);

        LocalDate dataInicio = null;
        while(dataInicio == null){
            try{
                System.out.println("Insira a data de Inicio (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            }catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        LocalDate dataFim = null;
        while(dataFim == null){
            try{
                System.out.println("Insira a data final (AAAA-MM-DD): ");
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
            if (!dataEmprestimo.isBefore(dataInicio) && !dataEmprestimo.isAfter(dataFim)) {
                totalEmprestimos++;
            }


        }

        System.out.println("\n--- Total de Empréstimos no Intervalo de Datas ---");
        System.out.println("Intervalo: " + dataInicio + " a " + dataFim);
        System.out.println("Total de Empréstimos: " + totalEmprestimos);
    }
    /**
     * Calcula a média de dias de duração dos empréstimos dentro de um intervalo de tempo fornecido pelo usuário.
     */
    public static void EmprestimosRealizados(){
        Scanner ler = new Scanner(System.in);
        int nDias = 0, total = 0;
        System.out.println("Insira a Data Inicio: ");
        LocalDate dataInicio = LocalDate.parse(ler.nextLine());
        System.out.println("Insira a Data Final: ");
        LocalDate dataFinal = LocalDate.parse(ler.nextLine());
        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            if (emprestimo.getDataInicio().isAfter(dataInicio) && emprestimo.getDataEfetivaDevolucao().isBefore(dataFinal)) {
                nDias++;
                long diasDeDiferenca = ChronoUnit.DAYS.between(emprestimo.getDataInicio(), emprestimo.getDataEfetivaDevolucao());
                total += diasDeDiferenca;
            }
        }
        System.out.println("Media (em Dias): " + total/nDias);
    }
    /**
     * Determina o item mais requisitado dentro de um período específico.
     * Considera tanto empréstimos quanto reservas de livros.
     */
    public static void itemMaisRequisitado() {
            Scanner ler = new Scanner(System.in);

            LocalDate dataInicio = null;
            while (dataInicio == null) {
                try {
                    System.out.print("Insira a Data de Início (AAAA-MM-DD): ");
                    dataInicio = LocalDate.parse(ler.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            }

            LocalDate dataFinal = null;
            while (dataFinal == null) {
                try {
                    System.out.print("Insira a Data Final (AAAA-MM-DD): ");
                    dataFinal = LocalDate.parse(ler.nextLine());
                    if (dataFinal.isBefore(dataInicio)) {
                        System.out.println("A data final não pode ser anterior à data de início. Tente novamente.");
                        dataFinal = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            }

            ArrayList<String> livros = new ArrayList<>();
            ArrayList<Integer> quantidade = new ArrayList<>();

            for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
                LocalDate dataEmprestimo = emprestimo.getDataInicio();
                if ((dataEmprestimo.isEqual(dataInicio) || dataEmprestimo.isAfter(dataInicio)) &&
                        (dataEmprestimo.isEqual(dataFinal) || dataEmprestimo.isBefore(dataFinal))) {

                    for (String livro : emprestimo.getLivros()) {
                        if (livros.contains(livro)) {
                            int index = livros.indexOf(livro);
                            quantidade.set(index, quantidade.get(index) + 1);
                        } else {
                            livros.add(livro);
                            quantidade.add(1);
                        }
                    }
                }
            }

            for (Reserva reserva : Reserva.listaReservas) {
                LocalDate dataReserva = reserva.getDataInicio();
                if ((dataReserva.isEqual(dataInicio) || dataReserva.isAfter(dataInicio)) &&
                        (dataReserva.isEqual(dataFinal) || dataReserva.isBefore(dataFinal))) {

                    for (String livro : reserva.getLivros()) {
                        if (livro.contains(livro)) {
                            int index = livros.indexOf(livro);
                            quantidade.set(index, quantidade.get(index) + 1);
                        } else {
                            livros.add(livro);
                            quantidade.add(1);
                        }
                    }
                }
            }

            String itemMaisRequisitado = null;
            int maxRequisicoes = 0;

            for (int i = 0; i < livros.size(); i++) {
                if (quantidade.get(i) > maxRequisicoes) {
                    maxRequisicoes = quantidade.get(i);
                    itemMaisRequisitado = livros.get(i);
                }
            }

            if (itemMaisRequisitado != null) {
                System.out.println("\n--- Item Mais Requisitado ---");
                System.out.println("Intervalo: " + dataInicio + " a " + dataFinal);
                System.out.println("Item: " + itemMaisRequisitado);
                System.out.println("Quantidade de Requisições: " + maxRequisicoes);
            } else {
                System.out.println("\nNenhum item foi requisitado no intervalo de datas fornecido.");
            }
        }
    /**
     * Apresenta uma lista de todos os utentes que realizaram empréstimos ou reservas.
     */
    public static void apresentarListaDeUtentes() {
        ArrayList<String> listaDeUtentes = new ArrayList<>();

        for (Reserva reserva : Reserva.listaReservas) {
            if (!listaDeUtentes.contains(reserva.getUtente())) {
                listaDeUtentes.add(reserva.getUtente());
            }
        }

        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            if (!listaDeUtentes.contains(emprestimo.getUtente())) {
                listaDeUtentes.add(emprestimo.getUtente());
            }
        }

        System.out.println("\n--- Lista de Utentes da Biblioteca ---");
        for (String utente : listaDeUtentes) {
            System.out.println("- NIF: " + utente);
        }
    }
    /**
     * Identifica os utentes que possuem empréstimos com atraso superior a um número de dias especificado pelo usuário.
     */
    public static void utentesComAtraso() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Insira o número de dias de atraso a considerar: ");
        int diasAtraso = ler.nextInt();
        ler.nextLine();

        ArrayList<String> utentesComAtraso = new ArrayList<>();

        for (Emprestimo emprestimo : Emprestimo.listaEmprestimos) {
            LocalDate dataEfetiva = emprestimo.getDataEfetivaDevolucao();
            LocalDate dataPrevista = emprestimo.getDataPrevistaDevolucao();

            if (dataEfetiva != null && ChronoUnit.DAYS.between(dataPrevista, dataEfetiva) > diasAtraso) {
                if (!utentesComAtraso.contains(emprestimo.getUtente())) {
                    utentesComAtraso.add(emprestimo.getUtente());
                }
            }
        }

        if (utentesComAtraso.isEmpty()) {
            System.out.println("Nenhum utente com atrasos superiores a " + diasAtraso + " dias.");
        } else {
            System.out.println("\n--- Lista de Utentes com Atrasos ---");
            for (String utente : utentesComAtraso) {
                System.out.println("- " + utente);
            }
        }
    }
}

