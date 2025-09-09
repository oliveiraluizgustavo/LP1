package ImagemTorreEiffel;

public class Pessoa {
    String sexo;
    String nome;
    int idade;

    
    public Pessoa(String sexo, String nome, int idade) {
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
    }

    private void dancar() {  
        System.out.println(nome + " de " + idade + " anos está dançando.");
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Feminino", "Ana", 25);
        pessoa.dancar(); 
        }
}