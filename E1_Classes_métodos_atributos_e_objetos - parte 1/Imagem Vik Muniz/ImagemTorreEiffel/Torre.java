package ImagemTorreEiffel;

public class Torre {
    float tamanho;
    String material;
    String tipo;
   
    public Torre(float tamanho, String material, String tipo) {
        this.tamanho = tamanho;
        this.material = material;
        this.tipo = tipo;
    }
   
    public void fazerSombra() {
        System.out.println("A torre de " + material 
                           + " do tipo " + tipo 
                           + " com " + tamanho + " metros está fazendo sombra.");
    }

    public static void main(String[] args) {
        Torre torre = new Torre(150, "concreto", "residencial");
        torre.fazerSombra();
    }
}