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
public class CuotaHost {
    private int idCuotaHost;
    private int porcentajeHostEntero;
    private double porcentajeHost;
    private Date fechaCuotaHost;

    public int getIdCuotaHost() {
        return idCuotaHost;
    }

    public void setIdCuotaHost(int idCuotaHost) {
        this.idCuotaHost = idCuotaHost;
    }

    public int getPorcentajeHostEntero() {
        return porcentajeHostEntero;
    }

    public void setPorcentajeHostEntero(int porcentajeHostEntero) {
        this.porcentajeHostEntero = porcentajeHostEntero;
    }

    public double getPorcentajeHost() {
        return porcentajeHost;
    }

    public void setPorcentajeHost(double porcentajeHost) {
        this.porcentajeHost = porcentajeHost;
    }

    public Date getFechaCuotaHost() {
        return fechaCuotaHost;
    }

    public void setFechaCuotaHost(Date fechaCuotaHost) {
        this.fechaCuotaHost = fechaCuotaHost;
    }
    
    
}
