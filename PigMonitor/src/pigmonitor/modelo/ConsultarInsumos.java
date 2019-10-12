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

/**
 *
 * @author tdnavarrom
 */
public class ConsultarInsumos extends Conexion{
    
    
    public boolean registrar(Insumos insumo){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO Insumos (codigoInsumos, nombreInsumo, precio) VALUES(?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getCodigoInsumos());
            ps.setString(2, insumo.getNombreInsumo());
            ps.setInt(3, insumo.getPrecio());
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
    
    public boolean modificar(Insumos insumo){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "UPDATE Insumos SET codigoInsumos=? ,nombreInsumo=?, precio=? WHERE idInsumos=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getCodigoInsumos());
            ps.setString(2, insumo.getNombreInsumo());
            ps.setInt(3, insumo.getPrecio());
            ps.setInt(4, insumo.getIdInsumos());
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
    
    public boolean eliminar(Insumos insumo){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Insumos WHERE idInsumos=?";
        
        try{
         
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getIdInsumos());
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
    
    public boolean buscar(Insumos insumo){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Insumos WHERE codigoInsumos=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getCodigoInsumos());
            rs = ps.executeQuery();
            
            if(rs.next()){
               insumo.setIdInsumos(Integer.parseInt(rs.getString("idInsumos")));
               insumo.setCodigoInsumos(rs.getInt("codigoInsumos"));
               insumo.setNombreInsumo(rs.getString("nombreInsumo"));
               insumo.setPrecio(rs.getInt("precio"));
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
