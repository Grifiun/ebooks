/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author grifiun
 */
public class Revista {
    private int idRevista;
    private String usernameEditor;
    private String nombreRevista;
    private String descripcionRevista;
    private double costoSuscripcion;
    private boolean bloqueoSuscripion;
    private boolean bloqueoMeGusta;
    private boolean bloqueoComentario;
    private Date fechaPublicacionRevista;

    public String getUsernameEditor() {
        return usernameEditor;
    }

    public void setUsernameEditor(String usernameEditor) {
        this.usernameEditor = usernameEditor;
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

    public double getCostoSuscripcion() {
        return costoSuscripcion;
    }

    public void setCostoSuscripcion(double costoSuscripcion) {
        this.costoSuscripcion = costoSuscripcion;
    }

    public boolean isBloqueoSuscripion() {
        return bloqueoSuscripion;
    }

    public void setBloqueoSuscripion(boolean bloqueoSuscripion) {
        this.bloqueoSuscripion = bloqueoSuscripion;
    }

    public boolean isBloqueoMeGusta() {
        return bloqueoMeGusta;
    }

    public void setBloqueoMeGusta(boolean bloqueoMeGusta) {
        this.bloqueoMeGusta = bloqueoMeGusta;
    }

    public boolean isBloqueoComentario() {
        return bloqueoComentario;
    }

    public void setBloqueoComentario(boolean bloqueoComentario) {
        this.bloqueoComentario = bloqueoComentario;
    }

    public Date getFechaPublicacionRevista() {
        return fechaPublicacionRevista;
    }

    public void setFechaPublicacionRevista(Date fechaPublicacionRevista) {
        this.fechaPublicacionRevista = fechaPublicacionRevista;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(int idRevista) {
        this.idRevista = idRevista;
    }
    
    
}
