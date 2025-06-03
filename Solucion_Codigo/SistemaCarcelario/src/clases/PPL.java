package clases;

import java.io.Serializable;

import java.util.ArrayList;

public class PPL implements Serializable {

    private String nombre;
    private int edad;
    private long cedula;
    private String fechaIn;
    private int diasVisita;
    private int condena;
    ArrayList<Delito> delitos;

    public PPL(String nombre, int edad, long cedula, String fechaIn) {
        delitos = new ArrayList<>();
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaIn = fechaIn;
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

    public void nuevoDelito(String nombre, String fecha, String desc, String estado, String gravedad) {
        delitos.add(new Delito(nombre, fecha, desc, this.nombre, estado, gravedad));
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PPL{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", cedula=").append(cedula);
        sb.append(", fechaIn=").append(fechaIn);
        sb.append(", diasVisita=").append(diasVisita);
        sb.append(", delitos=").append(delitos);
        sb.append('}');
        return sb.toString();
    }

}
