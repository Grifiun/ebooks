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
public class MeGusta {
    private int idMeGusta;
    private int idRevista;
    private String usernameLector;
    private Date fechaMeGusta;

    public int getIdMeGusta() {
        return idMeGusta;
    }

    public void setIdMeGusta(int idMeGusta) {
        this.idMeGusta = idMeGusta;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(int idRevista) {
        this.idRevista = idRevista;
    }

    public String getUsernameLector() {
        return usernameLector;
    }

    public void setUsernameLector(String usernameLector) {
        this.usernameLector = usernameLector;
    }

    public Date getFechaMeGusta() {
        return fechaMeGusta;
    }

    public void setFechaMeGusta(Date fechaMeGusta) {
        this.fechaMeGusta = fechaMeGusta;
    }
    
    
}
