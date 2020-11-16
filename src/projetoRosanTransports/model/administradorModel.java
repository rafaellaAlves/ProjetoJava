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
public class administradorModel extends pessoaModel{
    
    private String senhaAdm;

    public administradorModel(int idPessoa, String nomePessoa, String telefone, String ufPessoa, String cidadePessoa, String enderecoPessoa, String emailPessoa, int nivelPessoa, String senhaAdm) {
        super(idPessoa, nomePessoa, telefone, ufPessoa, cidadePessoa, enderecoPessoa, emailPessoa, nivelPessoa);
        this.senhaAdm = senhaAdm;
    }


    public administradorModel(){
        super();
        senhaAdm = new String();
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

       
    
}
