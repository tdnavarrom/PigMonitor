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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ConsultarEnfermedad extends Conexion {
    
    private ArrayList<Integer> enfermedades_id = new ArrayList<>();

    public boolean registrar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "INSERT INTO Enfermedad (codigoEnfermedad, nombreEnfermedad, cerdosAfectados, modificacionEnfermedad) VALUES(?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            enfermedades_id.add(enf.getCodigoEnfermedad());
            ps.setInt(1, enf.getCodigoEnfermedad());
            ps.setString(2, enf.getNombreEnfermedad());
            ps.setInt(3, enf.getCerdosAfectados());
            ps.setString(4, new_Date);
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
    
    public boolean modificar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "UPDATE Enfermedad SET codigoEnfermedad=? ,nombreEnfermedad=?, cerdosAfectados=?, modificacionEnfermedad=? WHERE idEnfermedad=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, enf.getCodigoEnfermedad());
            ps.setString(2, enf.getNombreEnfermedad());
            ps.setInt(3, enf.getCerdosAfectados());
            ps.setString(4, new_Date);
            ps.setInt(5, enf.getIdEnfermedad());
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
    
    public boolean eliminar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Enfermedad WHERE idEnfermedad=?";
        
        try{
         
            ps = con.prepareStatement(sql);
            enfermedades_id.remove(enfermedades_id.indexOf(enf.getCodigoEnfermedad()));
            ps.setInt(1, enf.getIdEnfermedad());
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
    
    public boolean buscar(Enfermedad enf){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Enfermedad WHERE codigoEnfermedad=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, enf.getCodigoEnfermedad());
            rs = ps.executeQuery();
            
            if(rs.next()){
               enf.setIdEnfermedad(Integer.parseInt(rs.getString("idEnfermedad")));
               enf.setCodigoEnfermedad(Integer.parseInt(rs.getString("codigoEnfermedad")));
               enf.setNombreEnfermedad(rs.getString("nombreEnfermedad"));
               enf.setCerdosAfectados(Integer.parseInt(rs.getString("cerdosAfectados")));
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

    public ArrayList<Integer> getEnfermedadesRegistradas(){
        return enfermedades_id;
    }
    
}
