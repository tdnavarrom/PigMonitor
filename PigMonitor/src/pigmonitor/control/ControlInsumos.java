/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pigmonitor.modelo.ConsultarInsumos;
import pigmonitor.modelo.Insumos;
import pigmonitor.vista.Vista;

/**
 *
 * @author Usuario
 */
public class ControlInsumos implements ActionListener{
    
    private Insumos insumo;
    private ConsultarInsumos insumoC;
    private Vista vista;  
    
    public ControlInsumos(Insumos insumo, ConsultarInsumos insumoC, Vista vista ){
        this.insumo = insumo;
        this.insumoC = insumoC;
        this.vista = vista;
        this.vista.guardarInsumoButton.addActionListener(this);
        this.vista.modificarInsumoButton.addActionListener(this);
        this.vista.eliminarInsumoButton.addActionListener(this);
        this.vista.buscarInsumoButton.addActionListener(this);
        this.vista.limpiarInsumosButton.addActionListener(this);     
    } 
    
    public void iniciarInsumos(){
        vista.setTitle("Insumos");
        vista.setLocationRelativeTo(null);
        vista.idInsumoTextField.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.guardarInsumoButton){
            insumo.setCodigoInsumos(Integer.parseInt(vista.codigoInsumoTextField.getText()));
            insumo.setNombreInsumo(vista.nombreInsumoTextField.getText());
            insumo.setPrecio(Integer.parseInt(vista.precioInsumoTextField.getText()));
            
            if(insumoC.registrar(insumo)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.modificarInsumoButton){
            insumo.setIdInsumos(Integer.parseInt(vista.idInsumoTextField.getText()));
            insumo.setCodigoInsumos(Integer.parseInt(vista.codigoInsumoTextField.getText()));
            insumo.setNombreInsumo(vista.nombreInsumoTextField.getText());
            insumo.setPrecio(Integer.parseInt(vista.precioInsumoTextField.getText()));
            
            if(insumoC.modificar(insumo)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if(e.getSource() == vista.eliminarInsumoButton){
            insumo.setIdInsumos(Integer.parseInt(vista.idInsumoTextField.getText()));
            
            if(insumoC.eliminar(insumo)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.buscarInsumoButton){
            insumo.setCodigoInsumos(Integer.parseInt(vista.codigoInsumoTextField.getText()));
            
            if(insumoC.buscar(insumo)){
                vista.idInsumoTextField.setText(String.valueOf(insumo.getIdInsumos()));
                vista.codigoInsumoTextField.setText(String.valueOf(insumo.getCodigoInsumos()));
                vista.nombreInsumoTextField.setText(insumo.getNombreInsumo());
                vista.precioInsumoTextField.setText(String.valueOf(insumo.getPrecio()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro coincidencia");
                limpiar();
            }
        }
        if(e.getSource() == vista.limpiarInsumosButton){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vista.idInsumoTextField.setText(null);
        vista.codigoInsumoTextField.setText(null);
        vista.nombreInsumoTextField.setText(null);
        vista.numBultosTextField.setText(null);
        vista.precioInsumoTextField.setText(null);
    }
    
}
