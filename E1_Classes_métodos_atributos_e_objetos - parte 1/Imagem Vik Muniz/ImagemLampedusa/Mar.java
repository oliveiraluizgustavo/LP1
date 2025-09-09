package ImagemLampedusa;

public class Mar {
    float profundidade;
    float temperatura;
    boolean temOndas;

    public Mar(float profundidade, float temperatura, boolean temOndas) {
        this.profundidade = profundidade;
        this.temperatura = temperatura;
        this.temOndas = temOndas;
    }

    public void refrescar() {
        String ondas = temOndas ? "com ondas" : "sem ondas";
        System.out.println("O mar com profundidade de " + profundidade 
                           + " metros, temperatura de " + temperatura + "°C "
                           + "e " + ondas + " está refrescando.");
    }

    public static void main(String[] args) {
        Mar mar = new Mar(3000, 22.5f, true);
        mar.refrescar();
    }
}
