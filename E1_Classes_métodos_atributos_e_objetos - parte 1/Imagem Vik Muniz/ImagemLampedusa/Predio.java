package ImagemLampedusa;

public class Predio {
    float altura;
    float quantidadeAndares;
    String endereco;

    public Predio(float altura, float quantidadeAndares, String endereco) {
        this.altura = altura;
        this.quantidadeAndares = quantidadeAndares;
        this.endereco = endereco;
    }

    public void acenderLuzes() {
        System.out.println("O prédio localizado em " + endereco 
                           + " com " + quantidadeAndares + " andares "
                           + " e altura de " + altura + " metros acendeu as luzes de Natal.");
    }

    public static void main(String[] args) {
        Predio predio = new Predio(50, 15, "Av. Paulista, 1000");
        predio.acenderLuzes();
    }
}