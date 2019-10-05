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
public class CostoDia extends CostoGlobalDia{    
    private int idEdicionRevista;

    public int getIdEdicionRevista() {
        return idEdicionRevista;
    }

    public void setIdEdicionRevista(int idEdicionRevista) {
        this.idEdicionRevista = idEdicionRevista;
    } 
    
    
}
