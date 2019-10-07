/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author grifiun
 */
public class RegistroTag {

    public static String obtenerCategoriaPorId(Connection EnlaceJDBC, String idCategoriaSeleccionada) {
        
        return null;
    }

    public static void registrarTags(ArrayList<String> datos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] tags = datos.get(1).split(" ");//Separamos los tags con los espacios
        String idRev = datos.get(0);//Creamos un String que contengra el id de la Revista
        
        for(int i = 0; i < tags.length; i++){  //creamos un for que se repetirá dependiendo de la cantidad de tags que haya          
            if(obtenerIdTag(EnlaceJDBC.EnlaceJDBC(), tags[i]) == null){//Se registra un nuevo tag en la base de datos si no se encuentra un id
                datos.clear();//vaciamos el ArryList
                datos.add(tags[i]);//Agregamos el tag de turno dentro del ArrayList
                registrarNuevoTag(EnlaceJDBC.EnlaceJDBC(), tags[i]); //Registrar el tag       
            }
            //En este paso obligatoriamente debera de encontrar un ide, por lo tanto
            String idTag = obtenerIdTag(EnlaceJDBC.EnlaceJDBC(), tags[i]);
            //Vaciamos y agregamos al ArrayList los valores necesarios para registrar un nuevo TagRevista
            datos.clear();
            datos.add(idRev);
            datos.add(idTag);
            datos.add(tags[i]);
            registrarNuevoTagRevista(EnlaceJDBC.EnlaceJDBC(), datos);//Creamos el registro
        }
        
    }

    private static String obtenerIdTag(Connection conexion, String tag) throws SQLException {
        String orden = "SELECT tag FROM Tag WHERE tag=?";//Creamos la orden
        String idTag = null;
        ArrayList<String> datos = new ArrayList();//creamos un ArrayList de tipo String       
        datos.add(tag);//Agregamos "tag" al ArrayList datos
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparada(conexion, datos, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        datos = null;
        while(rsPrueba.next()){//si no esta vacio
            idTag = rsPrueba.getString("id_tag");
        }   
        
        rsPrueba.close();
        
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
            
        
        return idTag;//retornamos el booleano
    }

    private static void registrarNuevoTag(Connection conexion, String tag) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<String> tags = new ArrayList();
        tags.add(tag);
        String orden = "INSERT INTO Tag (tag)" //Creamos la orden a enviar
                + "VALUES (?)";
        Consulta.registrarOrden(EnlaceJDBC.EnlaceJDBC(), tags, orden);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir    
    }

    private static void registrarNuevoTagRevista(Connection conexion, ArrayList<String> datos) {
        String orden = "INSERT INTO TagRevista (id_revista, id_tag, tag)" //Creamos la orden a enviar
                + "VALUES (?, ?, ?)";
        Consulta.registrarOrden(conexion, datos, orden);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir    
    }
    
}
