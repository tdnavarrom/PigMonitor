/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pigmonitor.modelo.ConsultarMedicamento;
import pigmonitor.modelo.Medicamento;
import pigmonitor.vista.Vista;

/**
 *
 * @author Usuario
 */
public class ControlMedicamento implements ActionListener{
    
    private Medicamento med;
    private ConsultarMedicamento medC;
    private Vista vista;  
    private ControlLote lote;
    
    public ControlMedicamento(Medicamento med, ConsultarMedicamento medC, Vista vista ){
        this.med = med;
        this.medC = medC;
        this.vista = vista;
        this.vista.guardarMedicamentoButton.addActionListener(this);
        this.vista.modificarMedicamentoButton.addActionListener(this);
        this.vista.eliminarMedicamentoButton.addActionListener(this);
        this.vista.buscarMedicamentoButton.addActionListener(this);
        this.vista.limpiarMedicamentoButton.addActionListener(this);     
    } 
    
    public void iniciarMedicamento(){
        vista.setTitle("Medicamento");
        vista.setLocationRelativeTo(null);
        vista.idMedicamentoTextField.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.guardarMedicamentoButton){
            med.setCodigoMedicamento(Integer.parseInt(vista.codigoMedicamentoTextField.getText()));
            med.setNombreMedicamento(vista.nombreMedicamentoTextField.getText());
            med.setNumeroExistencias(Integer.parseInt(vista.numeroExistenciasTextField.getText()));
            med.setPrecio(Integer.parseInt(vista.precioMedicamentoTextField.getText()));
            
            if(medC.registrar(med)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.modificarMedicamentoButton){
            med.setIdMedicamento(Integer.parseInt(vista.idMedicamentoTextField.getText()));
            med.setCodigoMedicamento(Integer.parseInt(vista.codigoMedicamentoTextField.getText()));
            med.setNombreMedicamento(vista.nombreMedicamentoTextField.getText());
            med.setNumeroExistencias(Integer.parseInt(vista.numeroExistenciasTextField.getText()));
            med.setPrecio(Integer.parseInt(vista.precioMedicamentoTextField.getText()));
            
            if(medC.modificar(med)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if(e.getSource() == vista.eliminarMedicamentoButton){
            med.setIdMedicamento(Integer.parseInt(vista.idMedicamentoTextField.getText()));
            
            if(medC.eliminar(med)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.buscarMedicamentoButton){
            med.setCodigoMedicamento(Integer.parseInt(vista.codigoMedicamentoTextField.getText()));
            
            if(medC.buscar(med)){
                vista.idMedicamentoTextField.setText(String.valueOf(med.getIdMedicamento()));
                vista.codigoMedicamentoTextField.setText(String.valueOf(med.getCodigoMedicamento()));
                vista.nombreMedicamentoTextField.setText(med.getNombreMedicamento());
                vista.numeroExistenciasTextField.setText(String.valueOf(med.getNumeroExistencias()));
                vista.precioMedicamentoTextField.setText(String.valueOf(med.getPrecio()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro coincidencia");
                limpiar();
            }
        }
        if(e.getSource() == vista.limpiarMedicamentoButton){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vista.idMedicamentoTextField.setText(null);
        vista.codigoMedicamentoTextField.setText(null);
        vista.nombreMedicamentoTextField.setText(null);
        vista.numeroExistenciasTextField.setText(null);
        vista.precioMedicamentoTextField.setText(null);
    }
    
}
