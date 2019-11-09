package pigmonitor.modelo;

/**
 *
 * @author Usuario
 */
public class Enfermedad {
    
    private int idEnfermedad;
    private int codigoEnfermedad;
    private String nombreEnfermedad;
    private int cerdosAfectados;
    private String modificacionEnfermedad;
    
    
    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }
    
    public int getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoEnfermedad(int codigoEnfermedad) {
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

    /**
     * @return the modificacionEnfermedad
     */
    public String getModificacionEnfermedad() {
        return modificacionEnfermedad;
    }

    /**
     * @param modificacionEnfermedad the modificacionEnfermedad to set
     */
    public void setModificacionEnfermedad(String modificacionEnfermedad) {
        this.modificacionEnfermedad = modificacionEnfermedad;
    }
    
}
