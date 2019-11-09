/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pigmonitor.modelo.ConsultarEnfermedad;
import pigmonitor.modelo.Enfermedad;
import pigmonitor.vista.Vista;

/**
 *
 * @author Usuario
 */
public class ControlEnfermedad implements ActionListener{
    
    private Enfermedad enfe;
    private ConsultarEnfermedad enfeC;
    private Vista vista;  
    
    public ControlEnfermedad(Enfermedad enfe, ConsultarEnfermedad enfeC, Vista vista ){
        this.enfe = enfe;
        this.enfeC = enfeC;
        this.vista = vista;
        this.vista.guardarEnfermedadButton.addActionListener(this);
        this.vista.modificarEnfermedadButton.addActionListener(this);
        this.vista.eliminarEnfermedadButton.addActionListener(this);
        this.vista.buscarEnfermedadButton.addActionListener(this);
        this.vista.limpiarEnfermedadButton.addActionListener(this);     
    } 
    
    public void iniciarEnfermedad(){
        vista.setTitle("Enfermedad");
        vista.setLocationRelativeTo(null);
        vista.idEnfermedadTextField.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.guardarEnfermedadButton){
            enfe.setCodigoEnfermedad(Integer.parseInt(vista.codigoEnfermedadTextField.getText()));
            enfe.setNombreEnfermedad(vista.nombreEnfermedadTextField.getText());
            enfe.setCerdosAfectados(Integer.parseInt(vista.numCerdosAfectTextField.getText()));
            
            if(enfeC.registrar(enfe)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.modificarEnfermedadButton){
            enfe.setIdEnfermedad(Integer.parseInt(vista.idEnfermedadTextField.getText()));
            enfe.setCodigoEnfermedad(Integer.parseInt(vista.codigoEnfermedadTextField.getText()));
            enfe.setNombreEnfermedad(vista.nombreEnfermedadTextField.getText());
            enfe.setCerdosAfectados(Integer.parseInt(vista.numCerdosAfectTextField.getText()));
            
            if(enfeC.modificar(enfe)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if(e.getSource() == vista.eliminarEnfermedadButton){
            enfe.setIdEnfermedad(Integer.parseInt(vista.idEnfermedadTextField.getText()));
            
            if(enfeC.eliminar(enfe)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.buscarEnfermedadButton){
            enfe.setCodigoEnfermedad(Integer.parseInt(vista.codigoEnfermedadTextField.getText()));
            
            if(enfeC.buscar(enfe)){
                vista.idEnfermedadTextField.setText(String.valueOf(enfe.getIdEnfermedad()));
                vista.codigoEnfermedadTextField.setText(String.valueOf(enfe.getCodigoEnfermedad()));
                vista.nombreEnfermedadTextField.setText(enfe.getNombreEnfermedad());
                vista.numCerdosAfectTextField.setText(String.valueOf(enfe.getCerdosAfectados()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro coincidencia");
                limpiar();
            }
        }
        if(e.getSource() == vista.limpiarEnfermedadButton){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vista.idEnfermedadTextField.setText(null);
        vista.codigoEnfermedadTextField.setText(null);
        vista.nombreEnfermedadTextField.setText(null);
        vista.numCerdosAfectTextField.setText(null);
    }
    
}
