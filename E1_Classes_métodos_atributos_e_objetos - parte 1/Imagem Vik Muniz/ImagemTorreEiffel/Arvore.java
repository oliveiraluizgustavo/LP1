package ImagemTorreEiffel;

public class Arvore {
    float altura;
    String especie;
    String cor;

    public Arvore(float altura, String especie, String cor) {
        this.altura = altura;
        this.especie = especie;
        this.cor = cor;
    }

    public void arejar() {
        System.out.println("A árvore da espécie " + especie 
                           + " com " + altura + " metros e cor " + cor 
                           + " está arejando o ambiente.");
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore(20, "Ipê", "amarela");
        arvore.arejar();
    }
}