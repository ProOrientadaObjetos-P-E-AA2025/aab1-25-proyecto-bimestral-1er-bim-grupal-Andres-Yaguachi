package clases;

import java.io.Serializable;

import java.util.ArrayList;

public class PPL implements Serializable {

    private String nombre;
    private int edad;
    private String sexo;
    private long cedula;
    private String fechaIn;
    private int diasVisita;
    private int condena;
    ArrayList<Delito> delitos;

    public PPL(String nombre, int edad, long cedula, String fechaIn, String sexo) {
        delitos = new ArrayList<>();
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaIn = fechaIn;
        this.sexo = sexo;
        this.diasVisita = 4;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public int getDiasVisita() {
        return diasVisita;
    }

    public void setDiasVisita(int diasVisita) {
        this.diasVisita = diasVisita;
    }

    public void nuevoDelito(String nombre, String fecha, String desc, int condena, String gravedad) {
        delitos.add(new Delito(nombre, fecha, desc, condena, gravedad));
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Delito> getDelitos() {
        return delitos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPersona Privada de la Libertad");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nEdad: ").append(edad);
        sb.append("\nCedula: ").append(cedula);
        sb.append("\nSexo: ").append(sexo);
        sb.append("\nCondena: ").append(condena);
        sb.append("\nFecha de ingreso: ").append(fechaIn);
        sb.append("\nDias de visita: ").append(diasVisita);
        sb.append("\nDelitos Cometidos: ").append(delitos);
        return sb.toString();
    }

}
