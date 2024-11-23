import java.util.Scanner;

public class SistemaControl {
    private Ascensor ascensor;
    private Piso[] pisos;

    public SistemaControl(int cantidadPisos) {
        this.ascensor = new Ascensor();
        this.pisos = new Piso[cantidadPisos];

        for (int i = 0; i < cantidadPisos; i++) {
            pisos[i] = new Piso(i);
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bienvenido al ascensor ---");
            System.out.println("Piso actual: " + ascensor.getPisoActual());
            System.out.println("Selecciona un piso (0 - " + (pisos.length - 1) + "):");
            int pisoSeleccionado = scanner.nextInt();

            if (pisoSeleccionado < 0 || pisoSeleccionado >= pisos.length) {
                System.out.println("Piso inválido. Intenta de nuevo.");
                continue;
            }

            ascensor.getPuerta().cerrar(); // Cierra puertas del ascensor
            ascensor.mover(pisoSeleccionado); // Mueve al piso seleccionado
            ascensor.getPuerta().abrir(); // Abre puertas del ascensor
            System.out.println("¡Has llegado al piso " + pisoSeleccionado + "!");
        }
    }
}
