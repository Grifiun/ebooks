/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author grifiun
 */
public class CategoriaRevista extends Categoria{
    private int idCategoriaRevista;
    private int idRevista;

    public int getIdCategoriaRevista() {
        return idCategoriaRevista;
    }

    public void setIdCategoriaRevista(int idCategoriaRevista) {
        this.idCategoriaRevista = idCategoriaRevista;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(int idRevista) {
        this.idRevista = idRevista;
    }
    
    
}
