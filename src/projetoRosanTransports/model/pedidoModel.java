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
public class pedidoModel {
    
    private int idPedido;
    private Date dataPedido;
    private int tipoCarga;
    private float valorPedido;
    private String assinaturaPedido;
    private tratorModel trator;
    private motoristaModel motorista;
    private empresaModel emprensa;

    public pedidoModel(int idPedido, Date dataPedido, int tipoCarga, float valorPedido, String assinaturaPedido, tratorModel trator, motoristaModel motorista, empresaModel emprensa) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.tipoCarga = tipoCarga;
        this.valorPedido = valorPedido;
        this.assinaturaPedido = assinaturaPedido;
        this.trator = trator;
        this.motorista = motorista;
        this.emprensa = emprensa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public float getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(float valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getAssinaturaPedido() {
        return assinaturaPedido;
    }

    public void setAssinaturaPedido(String assinaturaPedido) {
        this.assinaturaPedido = assinaturaPedido;
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

    public empresaModel getEmprensa() {
        return emprensa;
    }

    public void setEmprensa(empresaModel emprensa) {
        this.emprensa = emprensa;
    }
    
    
}
