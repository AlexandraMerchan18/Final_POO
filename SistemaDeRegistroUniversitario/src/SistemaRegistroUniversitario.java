 // Importamos la clase Scanner del paquete java.util
import java.util.Scanner; 

public class SistemaRegistroUniversitario {
    public static void main(String[] args) {
         // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Creamos una cola para almacenar los cursos
        Cola colaCursos = new Cola();
        // Creamos una pila para almacenar el historial académico de los estudiantes
        Pila historialAcademico = new Pila();
        // Creamos una lista enlazada para almacenar los nombres de los estudiantes
        ListaEnlazada listaEstudiantesCursos = new ListaEnlazada();

         // Variable para almacenar la opción seleccionada por el usuario
        int opcion;
        do {
            System.out.println("\n***** Sistema de Registro Universitario *****");
            System.out.println("1. Inscribir estudiante en un curso");
            System.out.println("2. Desinscribir estudiante de un curso");
            System.out.println("3. Consultar historial academico");
            System.out.println("4. Agregar nuevo estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Listar estudiantes");
            System.out.println("7. Agregar nuevo curso");
            System.out.println("8. Listar cursos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            // Leemos la opción seleccionada por el usuario
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del estudiante: ");
                    // Solicitamos el nombre del estudiante
                    String estudiante = scanner.nextLine();
                    System.out.print("Ingrese el nombre del curso al que desea inscribirse: ");
                    // Solicitamos el nombre del curso
                    String nombreCurso = scanner.nextLine();
                    Curso cursoSeleccionado = null;
                    Cola.Nodo tempCurso = colaCursos.verFrente();
                    // Buscamos el curso seleccionado
                    while (tempCurso != null) {
                        if (tempCurso.curso.getNombre().equals(nombreCurso)) {
                            cursoSeleccionado = (Curso) tempCurso.curso;
                            break;
                        }
                        tempCurso = tempCurso.siguiente;
                    }
                    if (cursoSeleccionado == null) {
                        System.out.println("El curso ingresado no está disponible.");
                    } else {
                        if (cursoSeleccionado.getEstudiantesInscritos() < cursoSeleccionado.getCupos()) {
                            // Hay cupo disponible en el curso
                            cursoSeleccionado.incrementarEstudiantesInscritos();
                            System.out.println("Se ha inscrito a " + estudiante + " en el curso " + cursoSeleccionado.getNombre() + ".");
                        } else {
                            // No hay cupo disponible en el curso, se agrega a la cola de espera
                            cursoSeleccionado.agregarEstudianteColaEspera(estudiante);
                            System.out.println("El curso " + cursoSeleccionado.getNombre() + " está lleno. " + estudiante + " ha sido agregado a la cola de espera.");
                        }
                    }
                    break;
                case 2:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del estudiante: ");
                    // Solicitamos el nombre del estudiante
                    estudiante = scanner.nextLine();
                    System.out.print("Ingrese el curso del que desea desinscribirse: ");
                    // Solicitamos el nombre del curso de desinscripción
                    String cursoDesinscripcion = scanner.nextLine();
                    // Verificar si el estudiante está inscrito en el curso
                    if (historialAcademico.estaVacia() || !historialAcademico.consultarTope().toString().equals(cursoDesinscripcion)) {
                        System.out.println(estudiante + " no está inscrito en el curso " + cursoDesinscripcion);
                        break;
                    }
                    // Desinscribir al estudiante del curso
                    historialAcademico.desapilar();
                    // Disminuir el contador de estudiantes inscritos en el curso
                    tempCurso = colaCursos.verFrente();
                    while (tempCurso != null) {
                        if (tempCurso.curso.getNombre().equals(cursoDesinscripcion)) {
                            tempCurso.curso.decrementarEstudiantesInscritos();
                            break;
                        }
                        tempCurso = tempCurso.siguiente;
                    }
                    System.out.println(estudiante + " se ha desinscrito del curso " + cursoDesinscripcion);
                    // Verificar si hay estudiantes en la cola de espera
                    Curso cursoLiberado = null;
                    tempCurso = colaCursos.verFrente();
                    while (tempCurso != null) {
                        if (tempCurso.curso.getNombre().equals(cursoDesinscripcion)) {
                            cursoLiberado = (Curso) tempCurso.curso;
                            break;
                        }
                        tempCurso = tempCurso.siguiente;
                    }
                    if (cursoLiberado != null && !cursoLiberado.getColaEspera().estaVacia()) {
                        // Inscribir al primer estudiante de la cola en el curso liberado
                        String estudianteCola = cursoLiberado.getColaEspera().desencolar();
                        historialAcademico.apilar(cursoDesinscripcion);
                        cursoLiberado.incrementarEstudiantesInscritos();
                        System.out.println(estudianteCola + " se ha inscrito en el curso " + cursoDesinscripcion);
                    }
                    break;
                case 3:
                    System.out.println("\n-- Historial Academico --");
                    if (!historialAcademico.estaVacia()) {
                        System.out.println("Historial academico:");
                        historialAcademico.mostrar();
                    } else {
                        System.out.println("El historial academico está vacio.");
                    }
                    break;
                case 4:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del nuevo estudiante: ");
                     // Solicitamos el nombre del nuevo estudiante
                    String nuevoEstudiante = scanner.nextLine();
                    // Agregamos el nuevo estudiante a la lista
                    listaEstudiantesCursos.agregar(nuevoEstudiante);
                    System.out.println("Se ha agregado a " + nuevoEstudiante + " como nuevo estudiante.");
                    break;
                case 5:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del estudiante que desea eliminar: ");
                    // Agregamos el nuevo estudiante a la lista
                    String estudianteEliminar = scanner.nextLine();
                    // Eliminamos al estudiante de la lista
                    listaEstudiantesCursos.eliminar(estudianteEliminar);
                    System.out.println("Se ha eliminado a " + estudianteEliminar + " de la lista de estudiantes.");
                    break;
                case 6:
                    System.out.println("\n-- Listado de Estudiantes --");
                    if (!listaEstudiantesCursos.estaVacia()) {
                        System.out.println("Lista de estudiantes:");
                        // Mostramos la lista de estudiantes
                        listaEstudiantesCursos.listar();
                    } else {
                        System.out.println("No hay estudiantes registrados.");
                    }
                    break;
                case 7:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del nuevo curso: ");
                    // Solicitamos el nombre del nuevo curso
                    String nuevoCurso = scanner.nextLine();
                    System.out.print("Ingrese el numero de cupos disponibles para el curso: ");
                    // Solicitamos el número de cupos para el nuevo curso
                     // Creamos un nuevo curso
                    int cupos = scanner.nextInt();
                    // Agregamos el nuevo curso a la cola de cursos
                    Curso cursoNuevo = new Curso(nuevoCurso, cupos);
                    // Agregamos el nuevo curso a la cola de cursos
                    colaCursos.encolar(cursoNuevo);
                    System.out.println("Se ha agregado el curso " + nuevoCurso + " con " + cupos + " cupos disponibles.");
                    break;
                case 8:
                    System.out.println("\n-- Listado de Cursos --");
                    if (!colaCursos.estaVacia()) {
                        System.out.println("Cursos disponibles:");
                        // Mostramos la lista de cursos disponibles
                        colaCursos.mostrar();
                    } else {
                        System.out.println("No hay cursos disponibles.");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no valida. Por favor, seleccione una opción valida.");
            }
            // Mostramos la lista de cursos disponibles
        } while (opcion != 9);
        // Cerramos el Scanner
        scanner.close();
    }
}




