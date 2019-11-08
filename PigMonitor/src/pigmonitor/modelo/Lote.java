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
public class Lote {
    private int idLote;
    private int codigoLote;
    private String fechaEntrada;
    private int numeroCerdos;
    private float PesoPromedio;
    private int numMachos;
    private int numHembras;
    private int Alimento_idAlimento;
    private int Medicamento_idMedicamento;

    /**
     * @return the idLote
     */
    public int getIdLote() {
        return idLote;
    }

    /**
     * @param idLote the idLote to set
     */
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    /**
     * @return the codigoLote
     */
    public int getCodigoLote() {
        return codigoLote;
    }

    /**
     * @param codigoLote the codigoLote to set
     */
    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    /**
     * @return the fechaEntrada
     */
    public String getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * @param fechaEntrada the fechaEntrada to set
     */
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * @return the numeroCerdos
     */
    public int getNumeroCerdos() {
        return numeroCerdos;
    }

    /**
     * @param numeroCerdos the numeroCerdos to set
     */
    public void setNumeroCerdos(int numeroCerdos) {
        this.numeroCerdos = numeroCerdos;
    }

    /**
     * @return the PesoPromedio
     */
    public float getPesoPromedio() {
        return PesoPromedio;
    }

    /**
     * @param PesoPromedio the PesoPromedio to set
     */
    public void setPesoPromedio(float PesoPromedio) {
        this.PesoPromedio = PesoPromedio;
    }

    /**
     * @return the numMachos
     */
    public int getNumMachos() {
        return numMachos;
    }

    /**
     * @param numMachos the numMachos to set
     */
    public void setNumMachos(int numMachos) {
        this.numMachos = numMachos;
    }

    /**
     * @return the numHembras
     */
    public int getNumHembras() {
        return numHembras;
    }

    /**
     * @param numHembras the numHembras to set
     */
    public void setNumHembras(int numHembras) {
        this.numHembras = numHembras;
    }

    /**
     * @return the Alimento_idAlimento
     */
    public int getAlimento_idAlimento() {
        return Alimento_idAlimento;
    }

    /**
     * @param Alimento_idAlimento the Alimento_idAlimento to set
     */
    public void setAlimento_idAlimento(int Alimento_idAlimento) {
        this.Alimento_idAlimento = Alimento_idAlimento;
    }

    /**
     * @return the Medicamento_idMedicamento
     */
    public int getMedicamento_idMedicamento() {
        return Medicamento_idMedicamento;
    }

    /**
     * @param Medicamento_idMedicamento the Medicamento_idMedicamento to set
     */
    public void setMedicamento_idMedicamento(int Medicamento_idMedicamento) {
        this.Medicamento_idMedicamento = Medicamento_idMedicamento;
    }

    
}