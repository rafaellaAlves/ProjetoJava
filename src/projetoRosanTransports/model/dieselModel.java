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
public class dieselModel {
    
    private int idDiesel;
    private String nomePosto;
    private Date dataEmissao;
    private String horaEmissao;
    private float litrosDiesel;
    private float precoDiesel;
    private float valorTotal;
    private tratorModel trator;
    private motoristaModel motorista;

    public dieselModel(int idDiesel, String nomePosto, Date dataEmissao, String horaEmissao, float litrosDiesel, float precoDiesel, float valorTotal, tratorModel trator, motoristaModel motorista) {
        this.idDiesel = idDiesel;
        this.nomePosto = nomePosto;
        this.dataEmissao = dataEmissao;
        this.horaEmissao = horaEmissao;
        this.litrosDiesel = litrosDiesel;
        this.precoDiesel = precoDiesel;
        this.valorTotal = valorTotal;
        this.trator = trator;
        this.motorista = motorista;
    }
    
    public dieselModel(){
        idDiesel = 0;
    }

    public int getIdDiesel() {
        return idDiesel;
    }

    public void setIdDiesel(int idDiesel) {
        this.idDiesel = idDiesel;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public float getLitrosDiesel() {
        return litrosDiesel;
    }

    public void setLitrosDiesel(float litrosDiesel) {
        this.litrosDiesel = litrosDiesel;
    }

    public float getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(float precoDiesel) {
        this.precoDiesel = precoDiesel;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public tratorModel getTrator() {
        return trator;
    }

    public void setTrator(tratorModel trator) {
        this.trator = trator;
    }

    public motoristaModel getMotorista() {
        return motorista;
    }

    public void setMotorista(motoristaModel motorista) {
        this.motorista = motorista;
    }
    
    
}
