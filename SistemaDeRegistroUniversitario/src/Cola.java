
//Los nodos se crean para poder estructurar la información de manera organizada en la cola
class Cola {
    Nodo frente;
    Nodo fin;
    
    // Constructor de la cola
    public Cola() {
        this.frente = null;
        this.fin = null;
    }
    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }
    // Método para encolar un curso en la cola
    public void encolar(Curso curso) {
        Nodo nuevo = new Nodo(curso);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }
    // Método para obtener el nodo del frente de la cola
    public Nodo verFrente() {
        return frente;
    }
    // Método para mostrar los cursos en la cola
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        Nodo temp = frente;
        while (temp != null) {
            System.out.println(temp.curso.getNombre());
            temp = temp.siguiente;
        }
    }
    // Método para desencolar un estudiante de la cola de espera
    String desencolar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    // Método para encolar un estudiante en la cola de espera de un curso
    void encolar(String estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    // Clase interna Nodo
    static class Nodo {
        Curso curso;
        Nodo siguiente;
        
        // Constructor del Nodo
        public Nodo(Curso curso) {
            this.curso = curso;
            this.siguiente = null;
        }
    }
}


