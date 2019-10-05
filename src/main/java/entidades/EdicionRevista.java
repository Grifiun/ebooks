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
public class EdicionRevista {
    InputStream archivoRevistaPDFGuardar;
    byte[] archivoRevistaPDFCargar;
    String nombreRevista;
    String descripcionRevista;
    int costoSuscripcion;
    
    String tituloEdicionRevista;
    String descripcionEdicionRevista;
    boolean bloqueoMG; 
    boolean bloqueoComentario; 
    boolean bloqueoSuscripcion;
    boolean estadoPublicacion;
    Date fechaPublicacionEdRevista;
    int costoDiaEdRev;

    public InputStream getArchivoRevistaPDFGuardar() {
        return archivoRevistaPDFGuardar;
    }

    public void setArchivoRevistaPDFGuardar(InputStream archivoRevistaPDFGuardar) {
        this.archivoRevistaPDFGuardar = archivoRevistaPDFGuardar;
    }

    public byte[] getArchivoRevistaPDFCargar() {
        return archivoRevistaPDFCargar;
    }

    public void setArchivoRevistaPDFCargar(byte[] archivoRevistaPDFCargar) {
        this.archivoRevistaPDFCargar = archivoRevistaPDFCargar;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getDescripcionRevista() {
        return descripcionRevista;
    }

    public void setDescripcionRevista(String descripcionRevista) {
        this.descripcionRevista = descripcionRevista;
    }

    public int getCostoSuscripcion() {
        return costoSuscripcion;
    }

    public void setCostoSuscripcion(int costoSuscripcion) {
        this.costoSuscripcion = costoSuscripcion;
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

    public boolean isBloqueoMG() {
        return bloqueoMG;
    }

    public void setBloqueoMG(boolean bloqueoMG) {
        this.bloqueoMG = bloqueoMG;
    }

    public boolean isBloqueoComentario() {
        return bloqueoComentario;
    }

    public void setBloqueoComentario(boolean bloqueoComentario) {
        this.bloqueoComentario = bloqueoComentario;
    }

    public boolean isBloqueoSuscripcion() {
        return bloqueoSuscripcion;
    }

    public void setBloqueoSuscripcion(boolean bloqueoSuscripcion) {
        this.bloqueoSuscripcion = bloqueoSuscripcion;
    }

    public boolean isEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(boolean estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public Date getFechaPublicacionEdRevista() {
        return fechaPublicacionEdRevista;
    }

    public void setFechaPublicacionEdRevista(Date fechaPublicacionEdRevista) {
        this.fechaPublicacionEdRevista = fechaPublicacionEdRevista;
    }

    public int getCostoDiaEdRev() {
        return costoDiaEdRev;
    }

    public void setCostoDiaEdRev(int costoDiaEdRev) {
        this.costoDiaEdRev = costoDiaEdRev;
    }    
    
}
