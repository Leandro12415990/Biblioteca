import java.io.*;
import java.util.*;

public class RegistarFicheiro {
    class Livro implements Serializable {
        private String titulo;
        private String autor;

        public Livro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public String toString() {
            return "Livro{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    '}';
        }
    }

    class Utente implements Serializable {
        private String nome;
        private int idade;

        public Utente(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String toString() {
            return "Utente{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    '}';
        }
    }

    class Reserva implements Serializable {
        private String utente;
        private String livro;

        public Reserva(String utente, String livro) {
            this.utente = utente;
            this.livro = livro;
        }

        public String toString() {
            return "Reserva{" +
                    "utente='" + utente + '\'' +
                    ", livro='" + livro + '\'' +
                    '}';
        }
    }
}
