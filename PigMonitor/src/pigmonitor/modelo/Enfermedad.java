package pigmonitor.modelo;

/**
 *
 * @author Usuario
 */
public class Enfermedad {
    
    private int idEnfermedad;
    private String codigoEnfermedad;
    private String nombreEnfermedad;
    private int cerdosAfectados;
    
    
    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }
    
    public String getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoEnfermedad(String codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }



    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public int getCerdosAfectados() {
        return cerdosAfectados;
    }

    public void setCerdosAfectados(int cerdosAfectados) {
        this.cerdosAfectados = cerdosAfectados;
    }
    
}
