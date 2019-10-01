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
import pigmonitor.vista.Vista;

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
        Vista vista = new Vista();
        
        ControlEnfermedad ctrlE = new ControlEnfermedad(enfe, enfeC, vista);
        ControlAlimento ctrlA = new ControlAlimento(food, foodC, vista);
        ctrlE.iniciarEnfermedad();
        ctrlA.iniciarAlimento();
        vista.setVisible(true);
        
        
    }
    
}
