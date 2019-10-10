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
public class Insumos {
    private int idInsumos;
    private int codigoInsumos;
    private String nombreInsumo;
    private int precio;

    /**
     * @return the idInsumos
     */
    public int getIdInsumos() {
        return idInsumos;
    }

    /**
     * @param idInsumos the idInsumos to set
     */
    public void setIdInsumos(int idInsumos) {
        this.idInsumos = idInsumos;
    }

    /**
     * @return the codigoInsumos
     */
    public int getCodigoInsumos() {
        return codigoInsumos;
    }

    /**
     * @param codigoInsumos the codigoInsumos to set
     */
    public void setCodigoInsumos(int codigoInsumos) {
        this.codigoInsumos = codigoInsumos;
    }

    /**
     * @return the nombreInsumos
     */
    public String getNombreInsumo() {
        return nombreInsumo;
    }

    /**
     * @param nombreInsumo the nombreInsumos to set
     */
    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
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
