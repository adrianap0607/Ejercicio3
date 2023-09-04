//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.util.ArrayList;

public class Sede {
    private String nombreSede;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
// Constructor nueva sede

    public Sede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    //metodo para agregar estudiante 
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
//Lista de estudiantes registrados
    public ArrayList<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }
//Metodo para obtener nombre de la sede
    public String getNombreSede() {
        return nombreSede;
    }
}
