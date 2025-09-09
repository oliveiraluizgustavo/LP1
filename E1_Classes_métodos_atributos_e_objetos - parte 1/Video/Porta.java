package VideoBrave;

public class Porta {
    float tamanho;
    String material;
    String cor;

    public Porta(float tamanho, String material, String cor) {
        this.tamanho = tamanho;
        this.material = material;
        this.cor = cor;
    }

    public void abrirPorta() {
        System.out.println("A porta de " + material + " na cor " + cor + " e tamanho " + tamanho + " m foi aberta.");
    }

    public void protegerCasa() {
        System.out.println("A porta de " + material + " está protegendo a casa.");
    }

    public void trancar() {
        System.out.println("A porta " + cor + " feita de " + material + " foi trancada.");
    }

    public static void main(String[] args) {
        Porta porta = new Porta(2.1f, "Madeira", "Branca");
        porta.abrirPorta();
        porta.protegerCasa();
        porta.trancar();
    }
}