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
 * @author tdnavarrom
 */
public class ConsultarInsumos extends Conexion{
    
    private ArrayList<Integer> insumos_id = new ArrayList<>();
    
    public boolean registrar(Insumos insumo){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "INSERT INTO Insumos (codigoInsumos, nombreInsumo, precio, modificacionInsumos) VALUES(?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getCodigoInsumos());
            insumos_id.add(insumo.getCodigoInsumos());
            ps.setString(2, insumo.getNombreInsumo());
            ps.setInt(3, insumo.getPrecio());
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
    
    public boolean modificar(Insumos insumo){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "UPDATE Insumos SET codigoInsumos=? ,nombreInsumo=?, precio=?, modificacionInsumos=? WHERE idInsumos=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, insumo.getCodigoInsumos());
            ps.setString(2, insumo.getNombreInsumo());
            ps.setInt(3, insumo.getPrecio());
            ps.setString(4, new_Date);
            ps.setInt(5, insumo.getIdInsumos());
            
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
            insumos_id.remove(insumos_id.indexOf(insumo.getCodigoInsumos()));
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
    
    public ArrayList<Integer> getInsumosRegistrados(){
        return insumos_id;
    }

}
