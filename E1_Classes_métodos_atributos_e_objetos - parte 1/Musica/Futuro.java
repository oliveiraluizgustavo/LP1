package Musica;

public class Futuro {
    String astronave;
    String destino;
    String sentimento;

    public Futuro(String astronave, String destino, String sentimento) {
        this.astronave = astronave;
        this.destino = destino;
        this.sentimento = sentimento;
    }

    public void pilotar() {
        System.out.println("A astronave " + astronave 
                           + " está viajando para " + destino 
                           + " com o sentimento de " + sentimento);
    }

    public static void main(String[] args) {
        Futuro futuro = new Futuro("Millennium Falcon", "Marte", "esperança");
        futuro.pilotar();
    }
}