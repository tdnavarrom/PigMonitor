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
public class ConsultarMedicamento extends Conexion{
    public boolean registrar(Medicamento med){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "INSERT INTO Medicamento (codigoMedicamento, nombreMedicamento, numeroExistencias, precio, modificacionMedicamento) VALUES(?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getCodigoMedicamento());
            ps.setString(2, med.getNombreMedicamento());
            ps.setInt(3, med.getNumeroExistencias());
            ps.setInt(4, med.getPrecio());
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
    
    public boolean modificar(Medicamento med){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "UPDATE Medicamento SET codigoMedicamento=? ,nombreMedicamento=?, numeroExistencias=?, precio=?, modificacionMedicamento=? WHERE idMedicamento=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getCodigoMedicamento());
            ps.setString(2, med.getNombreMedicamento());
            ps.setInt(3, med.getNumeroExistencias());
            ps.setInt(4, med.getPrecio());
            ps.setString(5, new_Date);
            ps.setInt(6, med.getIdMedicamento());
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
    
    public boolean eliminar(Medicamento med){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Medicamento WHERE idMedicamento=?";
        
        try{
         
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getIdMedicamento());
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
    
    public boolean buscar(Medicamento med){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Medicamento WHERE codigoMedicamento=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getCodigoMedicamento());
            rs = ps.executeQuery();
            
            if(rs.next()){
               med.setIdMedicamento(Integer.parseInt(rs.getString("idMedicamento")));
               med.setCodigoMedicamento(rs.getInt("codigoMedicamento"));
               med.setNombreMedicamento(rs.getString("nombreMedicamento"));
               med.setNumeroExistencias(Integer.parseInt(rs.getString("numeroExistencias")));
               med.setPrecio(rs.getInt("precio"));
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
