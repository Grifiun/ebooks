/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import entidades.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author grifiun
 */
public class RegistroCategoria {
    public static ArrayList<entidades.Categoria> obtenerTodasLasCategorias(java.sql.Connection conexion) throws SQLException{
        String orden = "SELECT * FROM Categoria";//Creamos la orden
        ArrayList<Categoria> categorias = new ArrayList();//creamos un ArrayList de tipo Categoria    
        
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparadaSimple(conexion, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        while(rsPrueba.next()){//se verfican los datos hasta que ya no hayan mas datos
            Categoria catAux = new Categoria();           
            String categoriaAux = rsPrueba.getString("categoria");//variable auxiliar que guarda el valor de la categoria
            int idCatAux = rsPrueba.getInt("id_categoria");
            
            catAux.setCategoria(categoriaAux);//agregamos el valor al objeto auxiliar catAux
            catAux.setIdCategoria(idCatAux);
            
            categorias.add(catAux);//agregamos el objeto auxiliar a un ArrayList
        }        
        rsPrueba.close();//Cerramos el rs
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();           
        
        
        return categorias;//retornamos el booleano
    }
    
    /**
     * Funcion encargada de registrar las categorias
     * @param conexion
     * @param datos 
     */
    public static void registrarCategoria(java.sql.Connection conexion, ArrayList<String> datos){
        String orden = "INSERT INTO Categoria (id_revista, id_categoria, categoria)" //Creamos la orden a enviar
                + "VALUES (?, ?, ?)";
        Consulta.registrarOrden(conexion, datos, orden);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir     
    }
    
    /**
     * Obtenemos la categoria por id
     * @param conexion
     * @param idCategoriaSeleccionada
     * @return
     * @throws SQLException 
     */
    public static String obtenerCategoriaPorId(Connection conexion, String idCategoriaSeleccionada) throws SQLException {
        String categoria = null;
        ArrayList<String> datos = new ArrayList();
        datos.add(idCategoriaSeleccionada);
        String orden = "SELECT categoria FROM Categoria WHERE id_categoria=?";//
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparada(conexion, datos, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        
        while(rsPrueba.next()){//si existe la categoria del id ingresado
            categoria = rsPrueba.getString("categoria");//a la variable categoria le ingresamos el valor del atributo categoria
        } 
        
        rsPrueba.close();//se cierra el ResultSet
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
        
        return categoria;//retornamos la categoria
    }
}
