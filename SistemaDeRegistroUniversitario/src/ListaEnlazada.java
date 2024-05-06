class ListaEnlazada {
    private Nodo inicio;

    // Constructor de la lista enlazada
    public ListaEnlazada() {
        this.inicio = null;
    }
// Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return inicio == null;
    }
// Método para agregar un nuevo elemento al final de la lista
    public void agregar(String data) {
        Nodo nuevoNodo = new Nodo(data);
        if (estaVacia()) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
// Método para eliminar un elemento de la lista
    public void eliminar(String data) {
        if (estaVacia()) {
            return;
        }
        if (inicio.data.equals(data)) {
            inicio = inicio.siguiente;
            return;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null) {
            if (actual.siguiente.data.equals(data)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }
// Método para buscar un elemento en la lista
    public String buscar(String data) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.data.equals(data)) {
                return actual.data;
            }
            actual = actual.siguiente;
        }
        return null;
    }
  // Método para listar todos los elementos de la lista
    public void listar() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.siguiente;
        }
    }
// Clase interna Nodo
    private class Nodo {
        String data;
        Nodo siguiente;

        // Constructor del Nodo
        public Nodo(String data) {
            this.data = data;
            this.siguiente = null;
        }
    }
}

