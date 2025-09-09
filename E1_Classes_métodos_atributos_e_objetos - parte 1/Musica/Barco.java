package Musica;

public class Barco {
	float tamanho;
	String estilo;
	String cor;
	
	public Barco (float tamanho, String estilo, String cor) {
		this.tamanho = tamanho;
		this.estilo = estilo;
		this.cor = cor;
				
	}
	public void navegar(float tamanho) {
		System.out.println("O tamanho do barco é " +tamanho +"m , seu estilo é "+ estilo +" e sua cor é "+cor  );
	}

	public static void main(String[] args) {
		Barco barco = new Barco(10, "Vela", "Azul");
		barco.navegar(50);
		
				
		

	}

}
