package clases;

import java.io.Serializable;

import java.util.ArrayList;

public class PPL implements Serializable {
    private String nombre;
    private int edad;
    private long cedula;
    private String fechaIn;
    private int diasVisita;
    private int agravantes;
    ArrayList<Delito> delitos;

    public PPL(String nombre, int edad, long cedula, String fechaIn) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaIn = fechaIn;
        this.diasVisita = 4;
        agravantes = 0;
    }

    public int getDiasVisita() {
        return diasVisita;
    }

    public void setDiasVisita(int diasVisita) {
        this.diasVisita = diasVisita;
    }

    public int getAgravantes() {
        return agravantes;
    }

    public void setAgravantes(int agravantes) {
        this.agravantes = agravantes;
    }
    public void nuevoDelito(String nombre, String fecha, String desc, String estado, String gravedad){
        delitos.add(new Delito(nombre,fecha, desc, this.nombre, estado, gravedad));
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
        sb.append(", agravantes=").append(agravantes);
        sb.append(", delitos=").append(delitos);
        sb.append('}');
        return sb.toString();
    }
    
    
}
