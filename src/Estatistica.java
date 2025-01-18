import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Estatistica {

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


}
