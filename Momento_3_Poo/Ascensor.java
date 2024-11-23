public class Ascensor {
    private int pisoActual;
    private PuertaAscensor puerta;

    public Ascensor() {
        this.pisoActual = 0; // Inicializa en planta baja
        this.puerta = new PuertaAscensor();
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public PuertaAscensor getPuerta() {
        return puerta;
    }

    public void mover(int pisoDestino) {
        System.out.println("Moviendo del piso " + pisoActual + " al piso " + pisoDestino + "...");
        pisoActual = pisoDestino;
    }
}
