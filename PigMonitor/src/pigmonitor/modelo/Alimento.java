/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.modelo;

/**
 *
 * @author tdnavarrom
 */
public class Alimento {
    private int idAlimento;
    private int codigoAlimento;
    private String nombreAlimento;
    private int numeroBultos;
    private int precio;

    /**
     * @return the idAlimento
     */
    public int getIdAlimento() {
        return idAlimento;
    }

    /**
     * @param idAlimento the idAlimento to set
     */
    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    /**
     * @return the codigoAlimento
     */
    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    /**
     * @param codigoAlimento the codigoAlimento to set
     */
    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    /**
     * @return the nombreAlimento
     */
    public String getNombreAlimento() {
        return nombreAlimento;
    }

    /**
     * @param nombreAlimento the nombreAlimento to set
     */
    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    /**
     * @return the numeroBultos
     */
    public int getNumeroBultos() {
        return numeroBultos;
    }

    /**
     * @param numeroBultos the numeroBultos to set
     */
    public void setNumeroBultos(int numeroBultos) {
        this.numeroBultos = numeroBultos;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
