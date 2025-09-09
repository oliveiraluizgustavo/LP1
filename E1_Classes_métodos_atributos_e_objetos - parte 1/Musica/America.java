package Musica;


public class America {
    String desenho;
    String tempo;
    String ferramenta;

    
    public America(String desenho, String tempo, String ferramenta) {
        this.desenho = desenho;
        this.tempo = tempo;
        this.ferramenta = ferramenta;
    }

    
    public void desenhar() {
        System.out.println("O desenho da América é " + desenho 
                           + ", feito com " + ferramenta 
                           + " e seu tempo é " + tempo);
    }

    public static void main(String[] args) {
        America america = new America( "grandioso", "eterno" , "força");
        america.desenhar();
    
}
}
