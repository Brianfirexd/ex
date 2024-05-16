import java.util.Scanner;

public class RegistroEstudiantes {
    
    // Función para registrar el nombre y las notas de un estudiante
    public static void registrarEstudiante(String[] nombresEstudiantes, double[][] notasEstudiantes, int estudianteIndex, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante " + (estudianteIndex + 1) + ": ");
        nombresEstudiantes[estudianteIndex] = scanner.next();
        System.out.println("Registro de notas para el estudiante " + nombresEstudiantes[estudianteIndex] + ":");
        for (int j = 0; j < 6; j++) {
            System.out.print("Ingrese la nota de la asignatura " + (j + 1) + ": ");
            notasEstudiantes[estudianteIndex][j] = scanner.nextDouble();
        }
    }
    
    // Función para calcular el promedio de un estudiante
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }
    
    // Función para determinar la calificación de un estudiante
    public static String determinarCalificacion(double promedio) {
        return promedio >= 70 ? "Satisfactorio" : "Insatisfactorio";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la cantidad de estudiantes a registrar
        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int cantidadEstudiantes = scanner.nextInt();

        // Declarar arreglos para almacenar los nombres, notas y promedios de los estudiantes
        String[] nombresEstudiantes = new String[cantidadEstudiantes];
        double[][] notasEstudiantes = new double[cantidadEstudiantes][6];
        double[] promedios = new double[cantidadEstudiantes];

        // Registro de los nombres y las notas de los estudiantes
        for (int i = 0; i < cantidadEstudiantes; i++) {
            registrarEstudiante(nombresEstudiantes, notasEstudiantes, i, scanner);
        }

        // Calcular promedios y determinar calificaciones de los estudiantes
        for (int i = 0; i < cantidadEstudiantes; i++) {
            promedios[i] = calcularPromedio(notasEstudiantes[i]);
        }

        // Mostrar resultados y determinar si la calificación es satisfactoria o insatisfactoria
        System.out.println("\nResultados:");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\nEstudiante: " + nombresEstudiantes[i]);
            System.out.println("Notas:");
            for (int j = 0; j < 6; j++) {
                System.out.println("Asignatura " + (j + 1) + ": " + notasEstudiantes[i][j]);
            }
            System.out.println("Promedio: " + promedios[i]);
            System.out.println("Calificación: " + determinarCalificacion(promedios[i]));
        }

        scanner.close();
    }
}
