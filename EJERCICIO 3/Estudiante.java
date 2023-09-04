
//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int codigoUnico;
    private String fechaNacimiento;
    private String correoElectronico;
    private ArrayList<Examen> examenes = new ArrayList<>();

    //Comstructor nuevo estudiante 
// Propiedades del estudiante
    public Estudiante(String nombre, String apellido, int codigoUnico, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }
//Metodo para agregar otro examen al estudiante 
    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public ArrayList<Examen> obtenerExamenes() {
        return examenes;
    }
//Obtener nombre estudiante 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//Obtener apellido 
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}


