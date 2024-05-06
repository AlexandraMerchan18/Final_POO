class Nodo {
    String data; // Cambiado de "dato" a "data"
    Nodo siguiente;
    String curso; // Agregado el atributo "curso"

    // Constructor modificado para recibir un objeto Curso
    public Nodo(String data) {
        this.data = data;
        this.siguiente = null;
    }

    // Constructor modificado para recibir un objeto Curso
    public Nodo(String data, String curso) {
        this.data = data;
        this.curso = curso;
        this.siguiente = null;
    }
}
