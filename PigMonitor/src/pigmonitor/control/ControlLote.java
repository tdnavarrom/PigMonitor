/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pigmonitor.modelo.ConsultarLote;
import pigmonitor.modelo.Lote;
import pigmonitor.vista.Vista;

/**
 *
 * @author tdnavarrom
 */
public class ControlLote implements ActionListener{
    
    private Lote lote;
    private ConsultarLote loteC;
    private Vista vista;  
    
    public ControlLote(Lote lote, ConsultarLote loteC, Vista vista ){
        this.lote = lote;
        this.loteC = loteC;
        this.vista = vista;
        this.vista.guardarLoteButton.addActionListener(this);
        this.vista.modificarLoteButton.addActionListener(this);
        this.vista.eliminarLoteButton.addActionListener(this);
        this.vista.buscarLoteButton.addActionListener(this);
        this.vista.limpiarLoteButton.addActionListener(this);    
        this.vista.loteEnfermedadButton.addActionListener(this);
        this.vista.loteInsumoButton.addActionListener(this);
    } 
    
    public void iniciarLote(){
        vista.setTitle("Lote");
        vista.setLocationRelativeTo(null);
        vista.idLoteTextField.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.guardarLoteButton){
            lote.setCodigoLote(Integer.parseInt(vista.codigoLoteTextField.getText()));
            lote.setNumHembras(Integer.parseInt(vista.numHembrasTextField.getText()));
            lote.setNumMachos(Integer.parseInt(vista.numMachosTextField.getText()));
            lote.setPesoPromedio(Float.parseFloat(vista.pesoLoteTextField.getText()));
            lote.setNumeroCerdos(Integer.parseInt(vista.numHembrasTextField.getText()) + Integer.parseInt(vista.numMachosTextField.getText()));
            lote.setAlimento_idAlimento(Integer.parseInt(vista.alimento_idAlimentoTextField.getText()));
            lote.setMedicamento_idMedicamento(Integer.parseInt(vista.medicamento_idMedicamentoTextField.getText()));
            
            if(loteC.registrar(lote)){
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.modificarLoteButton){
            lote.setIdLote(Integer.parseInt(vista.idLoteTextField.getText()));
            lote.setCodigoLote(Integer.parseInt(vista.codigoLoteTextField.getText()));
            lote.setNumHembras(Integer.parseInt(vista.numHembrasTextField.getText()));
            lote.setNumMachos(Integer.parseInt(vista.numMachosTextField.getText()));
            lote.setPesoPromedio(Float.parseFloat(vista.pesoLoteTextField.getText()));
            lote.setNumeroCerdos(Integer.parseInt(vista.numHembrasTextField.getText()) + Integer.parseInt(vista.numMachosTextField.getText()));
            lote.setAlimento_idAlimento(Integer.parseInt(vista.alimento_idAlimentoTextField.getText()));
            lote.setMedicamento_idMedicamento(Integer.parseInt(vista.medicamento_idMedicamentoTextField.getText()));
            
            if(loteC.modificar(lote)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if(e.getSource() == vista.eliminarLoteButton){
            lote.setIdLote(Integer.parseInt(vista.idLoteTextField.getText()));
            
            if(loteC.eliminar(lote)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.buscarLoteButton){
            lote.setCodigoLote(Integer.parseInt(vista.codigoLoteTextField.getText()));
            
            if(loteC.buscar(lote)){
                vista.idLoteTextField.setText(String.valueOf(lote.getIdLote()));
                vista.codigoLoteTextField.setText(String.valueOf(lote.getCodigoLote()));
                vista.numHembrasTextField.setText(String.valueOf(lote.getNumHembras()));
                vista.numMachosTextField.setText(String.valueOf(lote.getNumMachos()));
                vista.pesoLoteTextField.setText(String.valueOf(lote.getPesoPromedio()));
                vista.alimento_idAlimentoTextField.setText(String.valueOf(lote.getAlimento_idAlimento()));
                vista.medicamento_idMedicamentoTextField.setText(String.valueOf(lote.getMedicamento_idMedicamento()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro coincidencia");
                limpiar();
            }
        }
        if(e.getSource() == vista.limpiarLoteButton){
            limpiar();
        } 
        if(e.getSource() == vista.loteEnfermedadButton ){
            lote.setCodigoLote(Integer.parseInt(vista.codigoLoteTextField.getText()));
            int enfermedad_id = Integer.parseInt(vista.loteEnfermedadTextField.getText());
            loteC.insertarEnfermedades(enfermedad_id, lote);
            System.out.println(enfermedad_id);  
            vista.loteEnfermedadTextField.setText(null);
        } 
        if(e.getSource() == vista.loteInsumoButton){
            lote.setCodigoLote(Integer.parseInt(vista.codigoLoteTextField.getText()));
            int insumo_id = Integer.parseInt(vista.loteInsumosTextField.getText());
            loteC.insertarInsumos(insumo_id, lote);
            System.out.println(insumo_id);
            
        }
    }
    public void limpiar(){
        vista.idLoteTextField.setText(null);
        vista.codigoLoteTextField.setText(null);
        vista.numHembrasTextField.setText(null);
        vista.numMachosTextField.setText(null);
        vista.pesoLoteTextField.setText(null);
        vista.alimento_idAlimentoTextField.setText(null);
        vista.medicamento_idMedicamentoTextField.setText(null);
    }
}
