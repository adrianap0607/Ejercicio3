//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


public class Examen {
    private String nombreExamen;
    private int nota;


    //Constructor para crear un nuevo examen
    public Examen(String nombreExamen, int nota) {
        this.nombreExamen = nombreExamen;
        this.nota = nota;
    }
//Metodo para obtener nombre del examen 
    public String getNombreExamen() {
        return nombreExamen;
    }
//Metodo para obner la nota de el examen 
    public int getNota() {
        return nota;
    }
}
