/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.modelo.reportes;


import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import pigmonitor.modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



 public class LoteCSV extends Conexion{
     
    public void crearCsv(String fecha){
        
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Lote";
        
        try {
            PrintWriter pw= new PrintWriter(new File("ReportesGenerados/Lote-"+fecha+".csv"));
            StringBuilder sb=new StringBuilder();

            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();



            while(rs.next()){
                sb.append(rs.getString("idLote"));
                sb.append(","); 
                sb.append(rs.getString("codigoLote"));
                sb.append(",");
                sb.append(rs.getString("fechaEntrada"));
                sb.append(",");
                sb.append(rs.getString("numHembras"));
                sb.append(",");
                sb.append(rs.getString("numMachos"));
                sb.append(","); 
                sb.append(rs.getString("numeroCerdos"));
                sb.append(",");
                sb.append(rs.getString("MEdicamento_idMedicamento"));
                sb.append(",");
                sb.append(rs.getString("Alimento_idAlimento"));
                sb.append("\r\n");
         }

         pw.write(sb.toString());
         pw.close();
         System.out.println("finished");

        } catch (Exception e) {
         // TODO: handle exception
        } 
    }
}