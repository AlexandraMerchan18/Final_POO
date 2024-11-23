public abstract class Boton {
    private boolean iluminado;

    public Boton() {
        this.iluminado = false;
    }

    public boolean isIluminado() {
        return iluminado;
    }

    public void iluminar() {
        iluminado = true;
        System.out.println("El botón se ha iluminado.");
    }

    public void apagar() {
        iluminado = false;
        System.out.println("El botón se ha apagado.");
    }

    public abstract void presionar(); // Método abstracto para polimorfismo
}
