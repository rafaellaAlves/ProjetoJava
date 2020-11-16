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
public class tratorModel {
    
    private int idTrator;
    private String renavamTrator;
    private String cnpjTrator;
    private String placaTrator;
    private int combustivelTrator;
    private String marcaTrator;
    private String modeloTrator;
    private int anoTrator;

    public tratorModel(int idTrator, String renavamTrator, String cnpjTrator, String placaTrator, int combustivelTrator, String marcaTrator, String modeloTrator, int anoTrator) {
        this.idTrator = idTrator;
        this.renavamTrator = renavamTrator;
        this.cnpjTrator = cnpjTrator;
        this.placaTrator = placaTrator;
        this.combustivelTrator = combustivelTrator;
        this.marcaTrator = marcaTrator;
        this.modeloTrator = modeloTrator;
        this.anoTrator = anoTrator;
    }
    
    public tratorModel(){
        super();
        idTrator = 0;
        renavamTrator = new String();
        cnpjTrator = new String();
        placaTrator = new String();
        combustivelTrator = 0;
        marcaTrator = new String();
        modeloTrator = new String();
        anoTrator = 0;
    }
    

    public int getIdTrator() {
        return idTrator;
    }

    public void setIdTrator(int idTrator) {
        this.idTrator = idTrator;
    }

    public String getRenavamTrator() {
        return renavamTrator;
    }

    public void setRenavamTrator(String renavamTrator) {
        this.renavamTrator = renavamTrator;
    }

    public String getCnpjTrator() {
        return cnpjTrator;
    }

    public void setCnpjTrator(String cnpjTrator) {
        this.cnpjTrator = cnpjTrator;
    }

    public String getPlacaTrator() {
        return placaTrator;
    }

    public void setPlacaTrator(String placaTrator) {
        this.placaTrator = placaTrator;
    }

    public int getCombustivelTrator() {
        return combustivelTrator;
    }

    public void setCombustivelTrator(int combustivelTrator) {
        this.combustivelTrator = combustivelTrator;
    }

    public String getMarcaTrator() {
        return marcaTrator;
    }

    public void setMarcaTrator(String marcaTrator) {
        this.marcaTrator = marcaTrator;
    }

    public String getModeloTrator() {
        return modeloTrator;
    }

    public void setModeloTrator(String modeloTrator) {
        this.modeloTrator = modeloTrator;
    }

    public int getAnoTrator() {
        return anoTrator;
    }

    public void setAnoTrator(int anoTrator) {
        this.anoTrator = anoTrator;
    }
    
    
}
