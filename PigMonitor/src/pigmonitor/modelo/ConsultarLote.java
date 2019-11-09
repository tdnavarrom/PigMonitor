/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tdnavarrom
 */
public class ConsultarLote extends Conexion{
     

        
    public boolean registrar(Lote lote, ArrayList <Integer> enfermedades_id,ArrayList <Integer> insumos_id){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "INSERT INTO Lote (codigoLote, fechaEntrada, numeroCerdos, PesoPromedio, numMachos, numHembras, Alimento_idAlimento, Medicamento_idMedicamento) VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, lote.getCodigoLote());
            ps.setString(2, new_Date);
            ps.setInt(3, lote.getNumeroCerdos());
            ps.setFloat(4, lote.getPesoPromedio());
            ps.setInt(5, lote.getNumMachos());
            ps.setInt(6, lote.getNumHembras());
            ps.setInt(7, getIdTabla(lote.getAlimento_idAlimento(),"Alimento"));
            ps.setInt(8, getIdTabla(lote.getMedicamento_idMedicamento(), "Medicamento"));
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
    
    public boolean modificar(Lote lote){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());   
        String new_Date = format.format(date);
        
        String sql = "UPDATE Lote SET codigoLote=?, fechaEntrada=?, numeroCerdos=?, PesoPromedio=?, numMachos=?, numHembras=?, Alimento_idAlimento=?, Medicamento_idMedicamento=? WHERE idLote=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, lote.getCodigoLote());
            ps.setString(2, new_Date);
            ps.setInt(3, lote.getNumeroCerdos());
            ps.setFloat(4, lote.getPesoPromedio());
            ps.setInt(5, lote.getNumMachos());
            ps.setInt(6, lote.getNumHembras());
            ps.setInt(7, lote.getAlimento_idAlimento());
            ps.setInt(8, lote.getMedicamento_idMedicamento());
            
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
    
    public boolean eliminar(Lote lote){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Lote WHERE idLote=?";
        
        
        try{          
            ps = con.prepareStatement(sql);
            ps.setInt(1, lote.getIdLote());
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
    
    public boolean buscar(Lote lote){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        eliminarTablaHas(lote, "enfermedad");
        eliminarTablaHas(lote, "insumos");
        
        String sql = "SELECT * FROM Lote WHERE codigoLote=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, lote.getCodigoLote());
            rs = ps.executeQuery();
            
            if(rs.next()){
               lote.setIdLote(Integer.parseInt(rs.getString("idLote")));
               lote.setCodigoLote(rs.getInt("codigoLote"));
               lote.setNumHembras(Integer.parseInt(rs.getString("numHembras")));
               lote.setNumMachos(rs.getInt("numMachos"));
               lote.setPesoPromedio(rs.getInt("PesoPromedio"));
               lote.setNumeroCerdos(Integer.parseInt(rs.getString("numeroCerdos")));
               lote.setMedicamento_idMedicamento(getCodigoTable(rs.getInt("Medicamento_idMedicamento"), "Medicamento"));
               lote.setAlimento_idAlimento(getCodigoTable(rs.getInt("Alimento_idAlimento"), "Alimento"));
       
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
    
    public void insertarEnfermedades(int enfermedad, Lote lote){
        CallableStatement cs;
        Connection con = getConexion();
        try {   
            cs = con.prepareCall("{ call InsertarLote_has_enfermedad(?,?)}");
            int codigoEnfermedad = enfermedad;
            int idLote = getIdTabla(lote.getCodigoLote(), "Lote");
                
            cs.setString("Lote_idLote" , Integer.toString(idLote));
                
            int idEnfermedad = getIdTabla(codigoEnfermedad, "Enfermedad");
                
            cs.setString("Enfermedad_idEnfermedad" , Integer.toString(idEnfermedad));
            cs.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    } 
    
    public void insertarInsumos(int insumos, Lote lote){
        CallableStatement cs;
        Connection con = getConexion();
        
        try {   
            cs = con.prepareCall("{ call InsertarLote_has_insumos(?,?)}");
            int codigoInsumo = insumos;
            int idLote = getIdTabla(lote.getCodigoLote(), "Lote");
                
            cs.setString("Lote_idLote" , Integer.toString(idLote));
                
            int idInsumo = getIdTabla(codigoInsumo, "Insumos");
                
            cs.setString("Insumos_idInsumos" , Integer.toString(idInsumo));
            cs.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }     
    
    public void eliminarTablaHas(Lote lote, String table){
        
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM lote_has_"+ table +" WHERE Lote_idLote=?";
        
        try{          
            ps = con.prepareStatement(sql);
            System.out.println(lote.getIdLote());
            ps.setInt(1, lote.getIdLote());
            ps.execute();
            
        }catch(SQLException e){
            System.err.println(e);
        }
        
    }
    
    public int getIdTabla(int codigoTabla, String table){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM " + table + " WHERE codigo"+table+"=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoTabla);
            rs = ps.executeQuery();
            
            if(rs.next()){
               return rs.getInt("id" + table);
            }
            
            return 0;
            
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
    }
       
    public int getCodigoTable(int idTable, String table){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM " + table +  " WHERE id"+table+"=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTable);
            rs = ps.executeQuery();
            
            if(rs.next()){
               return rs.getInt("codigo"+table);
            }
            
            return 0;
            
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
    }
    
}
