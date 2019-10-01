/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pigmonitor.modelo.ConsultarAlimento;
import pigmonitor.modelo.Alimento;
import pigmonitor.vista.Vista;

/**
 *
 * @author Usuario
 */
public class ControlAlimento implements ActionListener{
    
    private Alimento food;
    private ConsultarAlimento foodC;
    private Vista vista;  
    
    public ControlAlimento(Alimento food, ConsultarAlimento foodC, Vista vista ){
        this.food = food;
        this.foodC = foodC;
        this.vista = vista;
        this.vista.guardarAlimentoButton.addActionListener(this);
        this.vista.modificarAlimentoButton.addActionListener(this);
        this.vista.eliminarAlimentoButton.addActionListener(this);
        this.vista.buscarAlimentoButton.addActionListener(this);
        this.vista.limpiarAlimentoButton.addActionListener(this);     
    } 
    
    public void iniciarAlimento(){
        vista.setTitle("Alimento");
        vista.setLocationRelativeTo(null);
        vista.idAlimentoTextField.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.guardarAlimentoButton){
            food.setCodigoAlimento(Integer.parseInt(vista.codigoAlimentoTextField.getText()));
            food.setNombreAlimento(vista.nombreAlimentoTextField.getText());
            food.setNumeroBultos(Integer.parseInt(vista.numBultosTextField.getText()));
            food.setPrecio(Integer.parseInt(vista.precioAlimentoTextField.getText()));
            
            if(foodC.registrar(food)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.modificarAlimentoButton){
            food.setIdAlimento(Integer.parseInt(vista.idAlimentoTextField.getText()));
            food.setCodigoAlimento(Integer.parseInt(vista.codigoAlimentoTextField.getText()));
            food.setNombreAlimento(vista.nombreAlimentoTextField.getText());
            food.setNumeroBultos(Integer.parseInt(vista.numBultosTextField.getText()));
            food.setPrecio(Integer.parseInt(vista.precioAlimentoTextField.getText()));
            
            if(foodC.modificar(food)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if(e.getSource() == vista.eliminarAlimentoButton){
            food.setIdAlimento(Integer.parseInt(vista.idAlimentoTextField.getText()));
            
            if(foodC.eliminar(food)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        if(e.getSource() == vista.buscarAlimentoButton){
            food.setCodigoAlimento(Integer.parseInt(vista.codigoAlimentoTextField.getText()));
            
            if(foodC.buscar(food)){
                vista.idAlimentoTextField.setText(String.valueOf(food.getIdAlimento()));
                vista.codigoAlimentoTextField.setText(String.valueOf(food.getCodigoAlimento()));
                vista.nombreAlimentoTextField.setText(food.getNombreAlimento());
                vista.numBultosTextField.setText(String.valueOf(food.getNumeroBultos()));
                vista.precioAlimentoTextField.setText(String.valueOf(food.getPrecio()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro coincidencia");
                limpiar();
            }
        }
        if(e.getSource() == vista.limpiarAlimentoButton){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vista.idAlimentoTextField.setText(null);
        vista.codigoAlimentoTextField.setText(null);
        vista.nombreAlimentoTextField.setText(null);
        vista.numBultosTextField.setText(null);
        vista.precioAlimentoTextField.setText(null);
    }
    
}
