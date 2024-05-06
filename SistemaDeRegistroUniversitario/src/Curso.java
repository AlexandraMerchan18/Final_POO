public class Curso {
    private String nombre;
    private int cupos;
    private int estudiantesInscritos;
    private Cola colaEspera;

        // Constructor de la clase Curso
    public Curso(String nombre, int cupos) {
        this.nombre = nombre;
        this.cupos = cupos;
        this.estudiantesInscritos = 0;
        this.colaEspera = new Cola();
    }

    // Método para obtener el nombre del curso
    public String getNombre() {
        return nombre;
    }
 // Método para obtener el número de cupos disponibles en el curso
    public int getCupos() {
        return cupos;
    }
// Método para obtener el número de estudiantes inscritos en el curso
    public int getEstudiantesInscritos() {
        return estudiantesInscritos;
    }
// Método para obtener la cola de espera del curso
    public Cola getColaEspera() {
        return colaEspera;
    }
// Método para incrementar el contador de estudiantes inscritos en el curso
    public void incrementarEstudiantesInscritos() {
        estudiantesInscritos++;
    }
// Método para decrementar el contador de estudiantes inscritos en el curso
    public void decrementarEstudiantesInscritos() {
        estudiantesInscritos--;
    }
 // Método para agregar un estudiante a la cola de espera del curso
    public void agregarEstudianteColaEspera(String estudiante) {
        colaEspera.encolar(estudiante);
    }
}