package DoodlePicnikPoster;

public class Teatro {
    String genero;
    String enredo;
    int duracao;

    public Teatro(String genero, String enredo, int duracao) {
        this.genero = genero;
        this.enredo = enredo;
        this.duracao = duracao;
    }

    public void encenar() {
        System.out.println("O teatro está encenando uma peça do gênero " + genero + ".");
    }

    public void apresentar() {
        System.out.println("A peça apresenta o enredo: " + enredo + ".");
    }

    public void encerrarPeca() {
        System.out.println("A peça de gênero " + genero + " terminou após " + duracao + " minutos.");
    }

    public static void main(String[] args) {
        Teatro teatro = new Teatro("Comédia", "A vida em família", 120);
        teatro.encenar();
        teatro.apresentar();
        teatro.encerrarPeca();
    }
}