public class Pila {
    private Nodo tope;

     // Constructor de la pila
    public Pila() {
        this.tope = null;
    }
 // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return tope == null;
    }
// Método para apilar un nuevo elemento en la pila
    public void apilar(String data) {
        Nodo nuevoNodo = new Nodo(data);
        if (estaVacia()) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }
    }
// Método para desapilar un elemento de la pila
    public String desapilar() {
        if (estaVacia()) {
            return null;
        }
        String curso = tope.data; // Cambiado de "dato" a "data"
        tope = tope.siguiente;
        return curso;
    }

    public String consultarTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.data; // Cambiado de "dato" a "data"
    }
// Método para mostrar todos los elementos de la pila
    public void mostrar() {
        Nodo temp = tope;
        while (temp != null) {
            System.out.println(temp.data); // Cambiado de "dato" a "data"
            temp = temp.siguiente;
        }
    }
// Clase interna Nodo
    private class Nodo {
        String data; // Cambiado de "dato" a "data"
        Nodo siguiente;

                // Constructor del Nodo
        public Nodo(String data) {
            this.data = data;
            this.siguiente = null;
        }
    }
}



