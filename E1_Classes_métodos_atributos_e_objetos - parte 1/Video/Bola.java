package VideoBrave;

public class Bola {
    String modelo;
    String modalidade;
    float circunferencia;

    public Bola(String modelo, String modalidade, float circunferencia) {
        this.modelo = modelo;
        this.modalidade = modalidade;
        this.circunferencia = circunferencia;
    }

    public void jogar() {
        System.out.println("A bola modelo " + modelo + " da modalidade " + modalidade + " está sendo jogada.");
    }

    public void pular() {
        System.out.println("A bola de " + modalidade + " com circunferência de " + circunferencia + " cm está pulando.");
    }

    public void brincar() {
        System.out.println("As crianças estão brincando com a bola " + modelo + " da modalidade " + modalidade + ".");
    }

    public static void main(String[] args) {
        Bola bola = new Bola("Adidas", "Futebol", 70.5f);
        bola.jogar();
        bola.pular();
        bola.brincar();
    }
}