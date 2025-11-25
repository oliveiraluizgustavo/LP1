public class Musica {

    private int id;
    private String titulo;
    private String atributo1;
    private String atributo2;
    private String atributo3;

    public Musica(String titulo, String a1, String a2, String a3) {
        this.titulo = titulo;
        this.atributo1 = a1;
        this.atributo2 = a2;
        this.atributo3 = a3;
    }

    public Musica(int id, String titulo, String a1, String a2, String a3) {
        this.id = id;
        this.titulo = titulo;
        this.atributo1 = a1;
        this.atributo2 = a2;
        this.atributo3 = a3;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAtributo1() { return atributo1; }
    public String getAtributo2() { return atributo2; }
    public String getAtributo3() { return atributo3; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAtributo1(String atributo1) { this.atributo1 = atributo1; }
    public void setAtributo2(String atributo2) { this.atributo2 = atributo2; }
    public void setAtributo3(String atributo3) { this.atributo3 = atributo3; }
}
