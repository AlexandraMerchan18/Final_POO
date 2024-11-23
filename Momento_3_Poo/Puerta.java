public abstract class Puerta {
    private boolean abierta;

    public Puerta() {
        this.abierta = false;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void abrir() {
        if (!abierta) {
            abierta = true;
            System.out.println("La puerta se ha abierto.");
        } else {
            System.out.println("La puerta ya está abierta.");
        }
    }

    public void cerrar() {
        if (abierta) {
            abierta = false;
            System.out.println("La puerta se ha cerrado.");
        } else {
            System.out.println("La puerta ya está cerrada.");
        }
    }

    public abstract void mostrarTipo(); // Método abstracto para polimorfismo
}
