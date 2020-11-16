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
public class empresaModel extends pessoaModel{
    
    private String cnpjEmpresa;

    public empresaModel(String cnpjEmpresa, int idPessoa, String nomePessoa, String telefone, String ufPessoa, String cidadePessoa, String enderecoPessoa, String emailPessoa, int nivelPessoa) {
        super(idPessoa, nomePessoa, telefone, ufPessoa, cidadePessoa, enderecoPessoa, emailPessoa, nivelPessoa);
        this.cnpjEmpresa = cnpjEmpresa;
    }
    
    public empresaModel(){
        super();
        cnpjEmpresa = new String();
    }
    
    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
   
    
}
