/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tdnavarrom
 */
public class ConsultarAlimento extends Conexion{
    
    
    public boolean registrar(Alimento food){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "INSERT INTO Alimento (codigoAlimento, nombreAlimento, numeroBultos, precio, modificacionAlimento) VALUES(?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, food.getCodigoAlimento());
            ps.setString(2, food.getNombreAlimento());
            ps.setInt(3, food.getNumeroBultos());
            ps.setInt(4, food.getPrecio());
            ps.setString(5, new_Date);
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    } 
    
    public boolean modificar(Alimento food){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        
        String sql = "UPDATE Alimento SET codigoAlimento=? ,nombreAlimento=?, numeroBultos=?, precio=?, modificacionAlimento=? WHERE idAlimento=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, food.getCodigoAlimento());
            ps.setString(2, food.getNombreAlimento());
            ps.setInt(3, food.getNumeroBultos());
            ps.setInt(4, food.getPrecio());
            ps.setString(5, new_Date);
            ps.setInt(6, food.getIdAlimento());
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(Alimento food){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Alimento WHERE idAlimento=?";
        
        try{
         
            ps = con.prepareStatement(sql);
            ps.setInt(1, food.getIdAlimento());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Alimento food){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Alimento WHERE codigoAlimento=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, food.getCodigoAlimento());
            rs = ps.executeQuery();
            
            if(rs.next()){
               food.setIdAlimento(Integer.parseInt(rs.getString("idAlimento")));
               food.setCodigoAlimento(rs.getInt("codigoAlimento"));
               food.setNombreAlimento(rs.getString("nombreAlimento"));
               food.setNumeroBultos(Integer.parseInt(rs.getString("numeroBultos")));
               food.setPrecio(rs.getInt("precio"));
               return true;         
            }
      
            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
}
