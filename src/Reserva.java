import java.util.Scanner;
import java.time.LocalDate;

public class Reserva {
    private int proximoNumero = 1;
    private int numero;
    private String utente;
    private String livro;
    private String dataRegisto;
    private String dataInicio;
    private String dataFim;

    public Reserva(int numero, String utente, String livro, String dataRegisto, String dataInicio, String dataFim) {
        this.numero = proximoNumero;
        this.utente = utente;
        this.livro = livro;
        this.dataRegisto = dataRegisto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.proximoNumero++;
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

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
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
        dataFim = dataFim;
    }

    public void criarReserva() {
        Scanner ler = new Scanner(System.in);
        System.out.println("A criar Reserva!");

        System.out.println("Nome do utente: ");
        String utente = ler.nextLine();

        LocalDate dataRegisto = LocalDate.now();

        System.out.print("Data de ínicio da reserva (AAAA-MM-DD): ");
        String dataInicio = ler.nextLine();

        System.out.print("Data final da reserva (AAAA-MM-DD): ");
        String dataEfetivaDevolucao = ler.nextLine();

        this.numero = proximoNumero;
        this.utente = utente;
        this.livro = livro;
        this.dataRegisto = LocalDate.now().toString();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;

        System.out.println("Reserva Criada!");

    }
}

