/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.model;

import java.sql.Date;
import java.util.*;

/**
 *
 * @author Rafaella Alves Silva
 */
public class motoristaModel extends pessoaModel {
    
    private String datanascimento;
    private String cpfMotorista;
    private String rgMotorista;
    private String cnhMotorista;
    private String senhaMotorista;

    public motoristaModel(int idPessoa, String nomePessoa, String telefone, String ufPessoa, String cidadePessoa, String enderecoPessoa, String emailPessoa, int nivelPessoa, String datanascimento, String cpfMotorista, String rgMotorista, String cnhMotorista, String senhaMotorista) {
        super(idPessoa, nomePessoa, telefone, ufPessoa, cidadePessoa, enderecoPessoa, emailPessoa, nivelPessoa);
        this.datanascimento = datanascimento;
        this.cpfMotorista = cpfMotorista;
        this.rgMotorista = rgMotorista;
        this.cnhMotorista = cnhMotorista;
        this.senhaMotorista = senhaMotorista;
    }
    
    
    public motoristaModel(){
        super();
        datanascimento = new String();
        cpfMotorista = new String();
        rgMotorista = new String();
        cnhMotorista = new String();
        senhaMotorista = new String();
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpfMotorista() {
        return cpfMotorista;
    }

    public void setCpfMotorista(String cpfMotorista) {
        this.cpfMotorista = cpfMotorista;
    }

    public String getRgMotorista() {
        return rgMotorista;
    }

    public void setRgMotorista(String rgMotorista) {
        this.rgMotorista = rgMotorista;
    }

    public String getCnhMotorista() {
        return cnhMotorista;
    }

    public void setCnhMotorista(String cnhMotorista) {
        this.cnhMotorista = cnhMotorista;
    }

    public String getSenhaMotorista() {
        return senhaMotorista;
    }

    public void setSenhaMotorista(String senhaMotorista) {
        this.senhaMotorista = senhaMotorista;
    }

    
    
    
}
