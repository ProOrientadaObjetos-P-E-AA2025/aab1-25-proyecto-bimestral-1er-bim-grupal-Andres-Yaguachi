package clases;

import java.io.Serializable;

public class Delito implements Serializable {
    private String tipoDeDelito;
    private String fecha;
    private String descripcion;
    private String autor;
    private String condena;
    private String gravedad;

    public Delito(String tipoDeDelito, String fecha, String descripcion, String autor, String condena, String gravedad) {
        this.tipoDeDelito = tipoDeDelito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCondena() {
        return condena;
    }

    public void setCondena(String estado) {
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
        sb.append("Delito{");
        sb.append("tipoDeDelito: ").append(tipoDeDelito);
        sb.append(", fecha: ").append(fecha);
        sb.append(", descripcion: ").append(descripcion);
        sb.append(", autor: ").append(autor);
        sb.append(", condena: ").append(condena);
        sb.append(", gravedad: ").append(gravedad);
        sb.append('}');
        return sb.toString();
    }
    

}
