package DoodlePicnikPoster;

public class Planeta {
    float tamanho;
    String tipo;
    boolean possuiVida;

    public Planeta(float tamanho, String tipo, boolean possuiVida) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.possuiVida = possuiVida;
    }

    public void orbitar() {
        System.out.println("O planeta do tipo " + tipo + " com tamanho de " + tamanho + " km está orbitando sua estrela.");
    }

    public void girar() {
        System.out.println("O planeta " + tipo + " está girando em seu próprio eixo.");
    }

    public void suportarVida() {
        if (possuiVida) {
            System.out.println("O planeta " + tipo + " suporta vida.");
        } else {
            System.out.println("O planeta " + tipo + " não suporta vida.");
        }
    }

    public static void main(String[] args) {
        Planeta planeta = new Planeta(12742, "Terrestre", true);
        planeta.orbitar();
        planeta.girar();
        planeta.suportarVida();
    }
}