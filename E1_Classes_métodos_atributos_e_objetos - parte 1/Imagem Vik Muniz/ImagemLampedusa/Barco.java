package ImagemLampedusa;

public class Barco {
    String tipo;
    float comprimento;
    String cor;

    public Barco(String tipo, float comprimento, String cor) {
        this.tipo = tipo;
        this.comprimento = comprimento;
        this.cor = cor;
    }

    public void navegar() {
        System.out.println("O barco do tipo " + tipo 
                           + " com comprimento de " + comprimento + " metros "
                           + "e cor " + cor + " está navegando.");
    }

    public static void main(String[] args) {
        Barco barco = new Barco("Veleiro", 12.5f, "azul");
        barco.navegar();
    }
}