public class BotonPiso extends Boton {
    @Override
    public void presionar() {
        iluminar();
        System.out.println("El botón del piso ha sido presionado.");
    }
}
