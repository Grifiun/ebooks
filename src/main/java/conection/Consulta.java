/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author grifiun
 */
public class Consulta {   
      
   /**
     * Funcion encargada de realizar peticiones de tipo Update
     * Recibe los parametros de conexion, datos y orden
     * de tipo java.sql.Connection, ArrayList<String> y String
     * @param conexion
     * @param datos
     * @param orden
     * @return 
     */
    public static void registrarOrden(java.sql.Connection conexion, ArrayList<String> datos, String orden){
    try {
           crearDeclaracionPreparada(conexion, datos, orden).executeUpdate(); //Ejecutamos la orden de tipo Query creada a partir de la orden y datos dados
           if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
                conexion.close();
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex); //Imprimimos el error en consola en caso de fallar           
        }  
    }    

    /**
     * Funcion encargada de crear y retornar una declaracion preparada con la
     * orden "orden" de tipo String, con los datos dados en el arrayList
     * de tipo ArrayList<String> y en la conexion "conexion" de tipo 
     * java.sql.Connection
     * @param conexion
     * @param datos
     * @param orden
     * @return 
     */
    public static PreparedStatement crearDeclaracionPreparada(java.sql.Connection conexion, ArrayList<String> datos, String orden){
        try {
            PreparedStatement dp = null;
            dp = conexion.prepareStatement(orden); //asignamos el select que trae el String orden         
            int esUnEntero;
            for(int i = 1; i <= datos.size(); i++){//asignamos los valores del arrayList datos en cada campo del select
                String aux = null;   
                esUnEntero = isEntero(datos.get(i - 1));//Revisamos si la cadena de datos.get(i) es un entero
                switch(esUnEntero){
                    case 1: //Cuando es 1 significa que el dato dentro de datos.get(i) es un entero, por tanto se rellena el campo como tal
                        aux = datos.get(i - 1);
                        dp.setInt(i, Integer.parseInt(aux));                        
                        break;
                    case 0://Cuando es 0 significa que no es un entero y se rellena el campo como String
                        aux = datos.get(i - 1);
                        dp.setString(i, aux);
                        break;
                }                
            }
            return dp;
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex); //Imprimimos el error en consola en caso de fallar           
        } 
        return null;
    }
    
    /**
     * Funcion encargada de ver si la cadena
     * "palabra" contiene solamente numeros
     * @param palabra
     * @return 
     */
    private static int isEntero(String palabra) {
        int resultado;//declaramos la variable a retornar

        try {
            Integer.parseInt(palabra);//convertimos la palabra a Integer
            resultado = 1;//Si no hay un error entonces es un numero y retornamos true
        } catch (NumberFormatException excepcion) {//de lo contrario es una palabra
            resultado = 0;
        }

        return resultado;//retornamos el valor
    }
}


