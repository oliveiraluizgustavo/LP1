package DoodlePicnikPoster;

public class Bicicleta {
    int quantidadeMarchas;
    String cor;
    String modelo;

    public Bicicleta(int quantidadeMarchas, String cor, String modelo) {
        this.quantidadeMarchas = quantidadeMarchas;
        this.cor = cor;
        this.modelo = modelo;
    }

    public void pedalar() {
        System.out.println("A bicicleta " + modelo + " de cor " + cor + " está pedalando pela estrada.");
    }

    public void exercitar() {
        System.out.println("Andar na bicicleta " + modelo + " com " + quantidadeMarchas + " marchas ajuda a exercitar o corpo.");
    }

    public void fazerManobras() {
        System.out.println("A bicicleta " + modelo + " de cor " + cor + " está fazendo manobras radicais.");
    }

    public static void main(String[] args) {
        Bicicleta bike = new Bicicleta(21, "Vermelha", "Mountain Bike");
        bike.pedalar();
        bike.exercitar();
        bike.fazerManobras();
    }
}