//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Crear sedes
        Sede sede1 = new Sede("Sede A");
        Sede sede2 = new Sede("Sede B");

        // Crear y registrar estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", 1001, "01/01/1995", "juan@example.com");
        estudiante1.agregarExamen(new Examen("Matemática", 85));
        estudiante1.agregarExamen(new Examen("Lenguaje", 90));
        estudiante1.agregarExamen(new Examen("Química", 78));

        Estudiante estudiante2 = new Estudiante("María", "López", 1002, "05/03/1996", "maria@example.com");
        estudiante2.agregarExamen(new Examen("Matemática", 92));
        estudiante2.agregarExamen(new Examen("Lenguaje", 88));
        estudiante2.agregarExamen(new Examen("Química", 75));

        Estudiante estudiante3 = new Estudiante("Pedro", "González", 1003, "10/11/1997", "pedro@example.com");
        estudiante3.agregarExamen(new Examen("Matemática", 78));
        estudiante3.agregarExamen(new Examen("Lenguaje", 85));
        estudiante3.agregarExamen(new Examen("Química", 92));

        Estudiante estudiante4 = new Estudiante("Laura", "Rodríguez", 1004, "15/04/1998", "laura@example.com");
        estudiante4.agregarExamen(new Examen("Matemática", 90));
        estudiante4.agregarExamen(new Examen("Lenguaje", 82));
        estudiante4.agregarExamen(new Examen("Química", 88));

        Estudiante estudiante5 = new Estudiante("Carlos", "Martínez", 1005, "20/07/1999", "carlos@example.com");
        estudiante5.agregarExamen(new Examen("Matemática", 85));
        estudiante5.agregarExamen(new Examen("Lenguaje", 94));
        estudiante5.agregarExamen(new Examen("Química", 87));

        // Agregar estudiantes a las sedes
        sede1.agregarEstudiante(estudiante1);
        sede1.agregarEstudiante(estudiante2);
        sede1.agregarEstudiante(estudiante3);

        sede2.agregarEstudiante(estudiante4);
        sede2.agregarEstudiante(estudiante5);

        // Mostrar resultados ordenados
        mostrarResultadosSede(sede1);
        mostrarResultadosSede(sede2);
    }

    // Método para mostrar resultados ordenados de una sede
    public static void mostrarResultadosSede(Sede sede) {
        System.out.println("Resultados para la sede: " + sede.getNombreSede());
        System.out.println("------------------------------------");

        ArrayList<Estudiante> estudiantes = sede.obtenerEstudiantes();
        
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en esta sede.");
            System.out.println();
            return;
        }

        for (Estudiante estudiante : estudiantes) {
            mostrarInformacionEstudiante(estudiante);
            System.out.println("------------------------------------");
        }
        
        ArrayList<Integer> notasMatematica = obtenerNotasExamen(estudiantes, "Matemática");
        ArrayList<Integer> notasLenguaje = obtenerNotasExamen(estudiantes, "Lenguaje");
        ArrayList<Integer> notasQuimica = obtenerNotasExamen(estudiantes, "Química");

        // Calcular estadísticas para Matemática
        System.out.println("Estadísticas de Matemática:");
        calcularYMostrarEstadisticas(notasMatematica);

        // Calcular estadísticas para Lenguaje
        System.out.println("Estadísticas de Lenguaje:");
        calcularYMostrarEstadisticas(notasLenguaje);

        // Calcular estadísticas para Química
        System.out.println("Estadísticas de Química:");
        calcularYMostrarEstadisticas(notasQuimica);

        System.out.println();
    }

    // Método para mostrar información detallada de un estudiante y sus notas
    public static void mostrarInformacionEstudiante(Estudiante estudiante) {
        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Código Único: " + estudiante.getCodigoUnico());
        System.out.println("Fecha de Nacimiento: " + estudiante.getFechaNacimiento());
        System.out.println("Correo Electrónico: " + estudiante.getCorreoElectronico());
        System.out.println("Notas de Exámenes:");
        for (Examen examen : estudiante.obtenerExamenes()) {
            System.out.println(examen.getNombreExamen() + ": " + examen.getNota());
        }
    }

    // Método para calcular estadísticas (promedio, mediana, moda, desviación estándar) y mostrar resultados
    public static void calcularYMostrarEstadisticas(ArrayList<Integer> notas) {
        if (notas.isEmpty()) {
            System.out.println("No hay notas disponibles.");
            return;
        }

        // Calcular promedio
        double promedio = calcularPromedio(notas);
        System.out.println("Promedio: " + promedio);

        // Calcular mediana
        double mediana = calcularMediana(notas);
        System.out.println("Mediana: " + mediana);

        // Calcular moda
        ArrayList<Integer> moda = calcularModa(notas);
        System.out.println("Moda: " + moda);

        // Calcular desviación estándar
        double desviacionEstandar = calcularDesviacionEstandar(notas);
        System.out.println("Desviación Estándar: " + desviacionEstandar);
    }

    // Métodos para calcular promedio, mediana, moda y desviación estándar
    public static double calcularPromedio(ArrayList<Integer> notas) {
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public static double calcularMediana(ArrayList<Integer> notas) {
        Collections.sort(notas);
        int n = notas.size();
        if (n % 2 == 0) {
            int mid1 = notas.get(n / 2 - 1);
            int mid2 = notas.get(n / 2);
            return (double) (mid1 + mid2) / 2.0;
        } else {
            return (double) notas.get(n / 2);
        }
    }

    public static ArrayList<Integer> calcularModa(ArrayList<Integer> notas) {
        ArrayList<Integer> moda = new ArrayList<>();
        int maxCount = 0;
        for (int nota : notas) {
            int count = Collections.frequency(notas, nota);
            if (count > maxCount) {
                moda.clear();
                moda.add(nota);
                maxCount = count;
            } else if (count == maxCount && !moda.contains(nota)) {
                moda.add(nota);
            }
        }
        return moda;
    }

    public static double calcularDesviacionEstandar(ArrayList<Integer> notas) {
        double promedio = calcularPromedio(notas);
        double sumaDiferenciasCuadrado = 0;
        for (int nota : notas) {
            sumaDiferenciasCuadrado += Math.pow(nota - promedio, 2);
        }
        double varianza = sumaDiferenciasCuadrado / notas.size();
        return Math.sqrt(varianza);
    }

    // Método para obtener las notas de un examen específico de todos los estudiantes
    public static ArrayList<Integer> obtenerNotasExamen(ArrayList<Estudiante> estudiantes, String nombreExamen) {
        ArrayList<Integer> notas = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            ArrayList<Examen> examenes = estudiante.obtenerExamenes();
            for (Examen examen : examenes) {
                if (examen.getNombreExamen().equals(nombreExamen)) {
                    notas.add(examen.getNota());
                }
            }
        }
        return notas;
    }
}
