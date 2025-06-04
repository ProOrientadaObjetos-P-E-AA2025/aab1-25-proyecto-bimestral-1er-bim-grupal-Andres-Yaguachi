package clases;

import java.io.Serializable;

public class Delito implements Serializable {

    private String tipoDeDelito;
    private String fecha;
    private String descripcion;
    private int condena;
    private String gravedad;

    public Delito(String tipoDeDelito, String fecha, String descripcion, int condena, String gravedad) {
        this.tipoDeDelito = tipoDeDelito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.condena = condena;
        this.gravedad = gravedad;
    }

    public String getTipoDeDelito() {
        return tipoDeDelito;
    }

    public void setTipoDeDelito(String tipoDeDelito) {
        this.tipoDeDelito = tipoDeDelito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int estado) {
        this.condena = estado;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Delito: ").append(tipoDeDelito);
        sb.append("\n  fecha del delito : ").append(fecha);
        sb.append("\n  descripcion: ").append(descripcion);
        sb.append("\n  condena: ").append(condena).append(" dias");
        sb.append("\n  gravedad: ").append(gravedad);
        return sb.toString();
    }

}
