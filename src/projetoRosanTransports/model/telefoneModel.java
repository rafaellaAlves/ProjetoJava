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
public class telefoneModel{
    
    private pessoaModel pessoa;
    private int tipoTelefone;
    private String dddTelefone;
    private String numeroTelefone;

    public telefoneModel(pessoaModel pessoa, int tipoTelefone, String dddTelefone, String numeroTelefone) {
        this.pessoa = pessoa;
        this.tipoTelefone = tipoTelefone;
        this.dddTelefone = dddTelefone;
        this.numeroTelefone = numeroTelefone;
    }
    public telefoneModel(){
        pessoa = new pessoaModel();
        tipoTelefone = 0;
        dddTelefone = new String();
        numeroTelefone = new String();
        
    }
    public pessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(pessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public int getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

      
    
}
