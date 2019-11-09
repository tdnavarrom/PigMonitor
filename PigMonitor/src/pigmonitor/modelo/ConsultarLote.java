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
            ps.setInt(7, lote.getAlimento_idAlimento());
            ps.setInt(8, lote.getMedicamento_idMedicamento());
            ps.execute();
            insertarEnfermedades(enfermedades_id, lote);
            insertarInsumos(insumos_id, lote);
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
        
        String sql = "SELECT * FROM Lote WHERE codigoLote=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, lote.getCodigoLote());
            rs = ps.executeQuery();
            
            if(rs.next()){
               lote.setIdLote(Integer.parseInt(rs.getString("idLote")));
               lote.setCodigoLote(rs.getInt("codigoLote"));
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
    
    public void insertarEnfermedades(ArrayList <Integer> enfermedad, Lote lote){
        CallableStatement cs;
        Connection con = getConexion();
        try {   
            cs = con.prepareCall("{ call InsertarLote_has_enfermedad(?,?)}");
            int codigoEnfermedad;
            for (int i = 0; i < enfermedad.size(); i++) {
                codigoEnfermedad = enfermedad.get(1);
                cs.setString("Lote_idLote" , Integer.toString(lote.getCodigoLote()));
                cs.setString("Enfermedad_idEnfermedad" , Integer.toString(codigoEnfermedad));
                cs.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    } 
    
    public void insertarInsumos(ArrayList <Integer> insumos, Lote lote){
        CallableStatement cs;
        Connection con = getConexion();
        try {   
            cs = con.prepareCall("{ call InsertarLote_has_insumos(?,?)}");
            int codigoInsumo;
            for (int i = 0; i < insumos.size(); i++) {
                codigoInsumo= insumos.get(1);
                cs.setString("Lote_idLote" , Integer.toString(lote.getCodigoLote()));
                cs.setString("Insumos_idInsumos" , Integer.toString(codigoInsumo));
                cs.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }     
    
    
}
