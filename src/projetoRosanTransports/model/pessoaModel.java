/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.model;

import java.util.ArrayList;

/**
 *
 * @author Rafaella Alves Silva
 */
public class pessoaModel {
    private int idPessoa;
    private String nomePessoa;
    private String telefone;
    private String ufPessoa;
    private String cidadePessoa;
    private String enderecoPessoa;
    private String emailPessoa;
    private int nivelPessoa;
    

    public pessoaModel(int idPessoa, String nomePessoa, String telefone, String ufPessoa, String cidadePessoa, String enderecoPessoa, String emailPessoa, int nivelPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.ufPessoa = ufPessoa;
        this.cidadePessoa = cidadePessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.emailPessoa = emailPessoa;
        this.nivelPessoa = nivelPessoa;
    }
    public pessoaModel() {
        idPessoa = 0;
       nomePessoa = new String();
       telefone = new String();
       ufPessoa = new String();
       cidadePessoa = new String();
       enderecoPessoa = new String();
       emailPessoa = new String();
       nivelPessoa = 0;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getUfPessoa() {
        return ufPessoa;
    }

    public void setUfPessoa(String ufPessoa) {
        this.ufPessoa = ufPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public int getNivelPessoa() {
        return nivelPessoa;
    }

    public void setNivelPessoa(int nivelPessoa) {
        this.nivelPessoa = nivelPessoa;
    }
    
    
}
