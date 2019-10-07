/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author grifiun
 */
public class EdicionRevista extends Revista{    
    private int idEdicionRevista;
    private String tituloEdicionRevista;
    private String descripcionEdicionRevista;    
    private Date fechaPublicacionEdicionRevista;    
    private InputStream revistaPDF;
    private byte[] byteRevistaPDF;
    private String nombreRevistaPDF;
    private boolean estadoPublicacion;

    public int getIdEdicionRevista() {
        return idEdicionRevista;
    }

    public void setIdEdicionRevista(int idEdicionRevista) {
        this.idEdicionRevista = idEdicionRevista;
    }
    
    public String getTituloEdicionRevista() {
        return tituloEdicionRevista;
    }

    public void setTituloEdicionRevista(String tituloEdicionRevista) {
        this.tituloEdicionRevista = tituloEdicionRevista;
    }

    public String getDescripcionEdicionRevista() {
        return descripcionEdicionRevista;
    }

    public void setDescripcionEdicionRevista(String descripcionEdicionRevista) {
        this.descripcionEdicionRevista = descripcionEdicionRevista;
    }

    public Date getFechaPublicacionEdicionRevista() {
        return fechaPublicacionEdicionRevista;
    }

    public void setFechaPublicacionEdicionRevista(Date fechaPublicacionEdicionRevista) {
        this.fechaPublicacionEdicionRevista = fechaPublicacionEdicionRevista;
    }

    public InputStream getRevistaPDF() {
        return revistaPDF;
    }

    public void setRevistaPDF(InputStream revistaPDF) {
        this.revistaPDF = revistaPDF;
    }

    public byte[] getByteRevistaPDF() {
        return byteRevistaPDF;
    }

    public void setByteRevistaPDF(byte[] byteRevistaPDF) {
        this.byteRevistaPDF = byteRevistaPDF;
    }

    public String getNombreRevistaPDF() {
        return nombreRevistaPDF;
    }

    public void setNombreRevistaPDF(String nombreRevistaPDF) {
        this.nombreRevistaPDF = nombreRevistaPDF;
    }

    public boolean isEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(boolean estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    
    
    
}
