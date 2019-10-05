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
public class CostoGlobalDia {
    private int idCostoDia;   
    private double costoDia;
    private Date fechaCostoDia; 

    public int getIdCostoDia() {
        return idCostoDia;
    }

    public void setIdCostoDia(int idCostoDia) {
        this.idCostoDia = idCostoDia;
    }

    public double getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(double costoDia) {
        this.costoDia = costoDia;
    }

    public Date getFechaCostoDia() {
        return fechaCostoDia;
    }

    public void setFechaCostoDia(Date fechaCostoDia) {
        this.fechaCostoDia = fechaCostoDia;
    }
    
    
}
