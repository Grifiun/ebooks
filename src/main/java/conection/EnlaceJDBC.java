/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grifiun
 */
public class EnlaceJDBC {   
    static String USER = "root";
    static String PASS = "123@MySQL";
    static String STRING_CONECTION = "jdbc:mysql://localhost:3306/ebooks";
    public static java.sql.Connection EnlaceJDBC() {
        try {
            Connection conection = null;    
            conection = DriverManager.getConnection(STRING_CONECTION, USER, PASS);
            return conection;
        } catch (SQLException ex) {
            Logger.getLogger(EnlaceJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
}
