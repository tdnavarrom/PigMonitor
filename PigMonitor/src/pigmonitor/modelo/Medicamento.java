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
public class Medicamento {
    private int idMedicamento;
    private int codigoMedicamento;
    private String nombreMedicamento;
    private int numeroExistencias;
    private int precio;
    private String modificacionMedicamento;

    /**
     * @return the idMedicamento
     */
    public int getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * @param idMedicamento the idMedicamento to set
     */
    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    /**
     * @return the codigoMedicamento
     */
    public int getCodigoMedicamento() {
        return codigoMedicamento;
    }

    /**
     * @param codigoMedicamento the codigoMedicamento to set
     */
    public void setCodigoMedicamento(int codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    /**
     * @return the nombreMedicamento
     */
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    /**
     * @param nombreMedicamento the nombreMedicamento to set
     */
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    /**
     * @return the numeroExistenciia
     */
    public int getNumeroExistencias() {
        return numeroExistencias;
    }

    /**
     * @param numeroExistenciia the numeroExistenciia to set
     */
    public void setNumeroExistencias(int numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
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

    /**
     * @return the modificacionMedicamento
     */
    public String getModificacionMedicamento() {
        return modificacionMedicamento;
    }

    /**
     * @param modificacionMedicamento the modificacionMedicamento to set
     */
    public void setModificacionMedicamento(String modificacionMedicamento) {
        this.modificacionMedicamento = modificacionMedicamento;
    }

}