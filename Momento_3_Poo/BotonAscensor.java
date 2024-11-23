public class BotonAscensor extends Boton {
    @Override
    public void presionar() {
        iluminar();
        System.out.println("El botón del ascensor ha sido presionado.");
    }
}
