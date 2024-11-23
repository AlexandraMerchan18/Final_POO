public class Piso {
    private int numero;
    private PuertaPiso puerta;
    private BotonPiso boton;

    public Piso(int numero) {
        this.numero = numero;
        this.puerta = new PuertaPiso();
        this.boton = new BotonPiso();
    }

    public int getNumero() {
        return numero;
    }

    public PuertaPiso getPuerta() {
        return puerta;
    }

    public BotonPiso getBoton() {
        return boton;
    }
}
