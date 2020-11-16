/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.model;

/**
 *
 * @author Rafaella Alves Silva
 */
public class reboqueModel {
    
    private int idReboque;
    private tratorModel trator;
    private String renavamReboque;
    private String cnpjReboque;
    private String placaReboque;
    private String marcaReboque;
    private int anoReboque;

    public reboqueModel(int idReboque, tratorModel trator, String renavamReboque, String cnpjReboque, String placaReboque, String marcaReboque, int anoReboque) {
        this.idReboque = idReboque;
        this.trator = trator;
        this.renavamReboque = renavamReboque;
        this.cnpjReboque = cnpjReboque;
        this.placaReboque = placaReboque;
        this.marcaReboque = marcaReboque;
        this.anoReboque = anoReboque;
    }
    
    public reboqueModel(){
        idReboque = 0;
    }

    public int getIdReboque() {
        return idReboque;
    }

    public void setIdReboque(int idReboque) {
        this.idReboque = idReboque;
    }

    public tratorModel getTrator() {
        return trator;
    }

    public void setTrator(tratorModel trator) {
        this.trator = trator;
    }

    public String getRenavamReboque() {
        return renavamReboque;
    }

    public void setRenavamReboque(String renavamReboque) {
        this.renavamReboque = renavamReboque;
    }

    public String getCnpjReboque() {
        return cnpjReboque;
    }

    public void setCnpjReboque(String cnpjReboque) {
        this.cnpjReboque = cnpjReboque;
    }

    public String getPlacaReboque() {
        return placaReboque;
    }

    public void setPlacaReboque(String placaReboque) {
        this.placaReboque = placaReboque;
    }

    public String getMarcaReboque() {
        return marcaReboque;
    }

    public void setMarcaReboque(String marcaReboque) {
        this.marcaReboque = marcaReboque;
    }

    public int getAnoReboque() {
        return anoReboque;
    }

    public void setAnoReboque(int anoReboque) {
        this.anoReboque = anoReboque;
    }
    
    
    
}
