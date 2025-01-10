import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    private static int proximoNumero = 1;

    private int numero;
    private String utente;
    private String livro;
    private String dataRegisto;
    private String dataInicio;
    private String dataFim;

    public Reserva(String utente, String livro, String dataInicio, String dataFim) {
        this.numero = proximoNumero++;
        this.utente = utente;
        this.livro = livro;
        this.dataRegisto = LocalDate.now().toString();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }


    public int getNumero() {
        return numero;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getDataRegisto() {
        return dataRegisto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public static void criarReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Criar Reserva ---");

        System.out.print("Nome do utente: ");
        String utente = ler.nextLine();

        System.out.print("Título do livro: ");
        String livro = ler.nextLine();

        LocalDate dataInicio = null;
        while (dataInicio == null) {
            try {
                System.out.print("Data de início da reserva (AAAA-MM-DD): ");
                dataInicio = LocalDate.parse(ler.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        LocalDate dataFim = null;
        while (dataFim == null) {
            try {
                System.out.print("Data final da reserva (AAAA-MM-DD): ");
                dataFim = LocalDate.parse(ler.nextLine());
                if (dataFim.isBefore(dataInicio)) {
                    System.out.println("A data final não pode ser anterior à data de início.");
                    dataFim = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
        ArrayList <Reserva> listaReservas = new ArrayList<>(100);
            Reserva reserva = new Reserva(utente, livro, dataInicio.toString(), dataFim.toString());
                listaReservas.add(new Reserva(utente, livro, dataInicio.toString(), dataFim.toString()));

        System.out.println("\n Reserva Criada com Sucesso!");
        System.out.println("Número da reserva: " + reserva.getNumero());
        System.out.println("Nome do utente: " + reserva.getUtente());
        System.out.println("Título do livro: " + reserva.getLivro());
        System.out.println("Data de registo: " + reserva.getDataRegisto());
        System.out.println("Data de início: " + reserva.getDataInicio());
        System.out.println("Data de fim: " + reserva.getDataFim());

    }
}
