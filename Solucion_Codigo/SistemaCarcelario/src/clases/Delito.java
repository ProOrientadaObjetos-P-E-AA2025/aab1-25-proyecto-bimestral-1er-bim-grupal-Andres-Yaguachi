package clases;

import java.io.Serializable;

public class Delito implements Serializable {
    private String tipoDeDelito;
    private String fecha;
    private String descripcion;
    private String autor;
    private String estado;
    private String gravedad;

    public Delito(String tipoDeDelito, String fecha, String descripcion, String autor, String estado, String gravedad) {
        this.tipoDeDelito = tipoDeDelito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.autor = autor;
        this.estado = estado;
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
        sb.append(", estado: ").append(estado);
        sb.append(", gravedad: ").append(gravedad);
        sb.append('}');
        return sb.toString();
    }
    

}
