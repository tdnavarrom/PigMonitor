/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor;

import pigmonitor.control.ControlEnfermedad;
import pigmonitor.modelo.ConsultarEnfermedad;
import pigmonitor.modelo.Enfermedad;
import pigmonitor.control.ControlAlimento;
import pigmonitor.modelo.ConsultarAlimento;
import pigmonitor.modelo.Alimento;
import pigmonitor.control.ControlMedicamento;
import pigmonitor.modelo.ConsultarMedicamento;
import pigmonitor.modelo.Medicamento;
import pigmonitor.control.ControlInsumos;
import pigmonitor.modelo.ConsultarInsumos;
import pigmonitor.modelo.Insumos;
import pigmonitor.vista.Vista;
import pigmonitor.vista.Inicio;
import pigmonitor.vista.Informes;
/**
 *
 * @author pcorream
 */
public class PigMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Enfermedad enfe = new Enfermedad(); 
        ConsultarEnfermedad enfeC = new ConsultarEnfermedad();
        
        Alimento food = new Alimento();
        ConsultarAlimento foodC = new ConsultarAlimento();
        
        Medicamento med = new Medicamento();
        ConsultarMedicamento medC = new ConsultarMedicamento();

        Insumos insumo = new Insumos();
        ConsultarInsumos insumoC = new ConsultarInsumos();
        
        Vista vista = new Vista();
        Inicio inicio = new Inicio();
        Informes informes = new Informes();
        
        ControlEnfermedad ctrlE = new ControlEnfermedad(enfe, enfeC, vista);
        ControlAlimento ctrlA = new ControlAlimento(food, foodC, vista);
        ControlMedicamento ctrlM = new ControlMedicamento(med, medC, vista);
        ControlInsumos ctrlI = new ControlInsumos(insumo, insumoC, vista);
        
        ctrlE.iniciarEnfermedad();
        ctrlA.iniciarAlimento();
        ctrlM.iniciarMedicamento();
        ctrlI.iniciarInsumos();

        
        
        vista.setVisible(true);
        
        
    }
    
}
