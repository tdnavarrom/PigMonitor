package pigmonitor.modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pcorream
 */
public class Conexion {
    
 
    private final String base = "pigmonitor";
    private final String username = "root";
    private final String password = "TomasDavid2001";
    private final String url = "jdbc:mysql://localhost:3306/" + base+"?autoReconnect=true&useSSL=false";
    private Connection con = null;
    
    public Connection getConexion(){
       System.out.println("Hola");
       try{
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
           
       }catch(SQLException e){
           System.out.println(e);
           
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return con;
    }
    
    
    
    
}
