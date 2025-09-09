package VideoBrave;

public class Desenho {
    String tipo;
    String cor;
    double tamanho;

    public Desenho(String tipo, String cor, double tamanho) {
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public void colorir() {
        System.out.println("O desenho do tipo " + tipo + " foi colorido na cor " + cor + ".");
    }

    public void imaginar() {
        System.out.println("Estou imaginando um desenho do tipo " + tipo + " com " + tamanho + " cm.");
    }

    public void exibir() {
        System.out.println("O desenho " + tipo + " de cor " + cor + " e tamanho " + tamanho + " cm está sendo exibido.");
    }

    public static void main(String[] args) {
        Desenho desenho = new Desenho("Retrato", "Azul", 30.5);
        desenho.colorir();
        desenho.imaginar();
        desenho.exibir();
    }
}