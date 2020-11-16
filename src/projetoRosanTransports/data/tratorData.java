/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;

import projetoRosanTransports.model.tratorModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.*;
/**
 *
 * @author Rafaella Alves Silva
 */
public class tratorData {
    
    public boolean incluirTrator(tratorModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "INSERT INTO TRATOR (CNPJ_TRT, PLACA_TRT, COMBUTVEL_TRT, MARCA_TRT, MODELO_TRT, ANO_TRT, RENVAM_TRT) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getCnpjTrator());
        ps.setString(2, obj.getPlacaTrator());
        ps.setInt(3, obj.getCombustivelTrator());
        ps.setString(4, obj.getMarcaTrator());
        ps.setString(5, obj.getModeloTrator());
        ps.setInt(6, obj.getAnoTrator());
        ps.setString(7, obj.getRenavamTrator());
        if(ps.executeUpdate()>0){
            return true;
        }else{
            throw new Exception("Erro ao inserir trator!");
        }
        
    }
    
    public boolean excluirTrator(int id) throws Exception{
        conexao c = new conexao();
        String sql1 = "DELETE FROM TRATOR WHERE ID_TRT=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setInt(1, id);
        if(ps.executeUpdate() > 0){
            return true;
        }else{
            throw new Exception("Não foi possível excluir este trator!");
        }
    }
    
    public boolean alterarTrator(tratorModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "UPDATE TRATOR SET CNPJ_TRT=?, PLACA_TRT=?, COMBUTVEL_TRT=?, MARCA_TRT=?, MODELO_TRT=?, ANO_TRT=?, RENVAM_TRT=? WHERE ID_TRT=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getCnpjTrator());
        ps.setString(2, obj.getPlacaTrator());
        ps.setInt(3, obj.getCombustivelTrator());
        ps.setString(4, obj.getMarcaTrator());
        ps.setString(5, obj.getModeloTrator());
        ps.setInt(6, obj.getAnoTrator());
        ps.setString(7, obj.getRenavamTrator());
        ps.setInt(8, obj.getIdTrator());
        if(ps.executeUpdate() > 0){
            return true;
        }else{
            throw new Exception("Não foi possível atualizar trator!");
        }
    }
    
    public ArrayList<tratorModel> pesquisarTrator(String pesq) throws Exception{
        ArrayList<tratorModel> dados = new ArrayList<>();
        String sql1 = "SELECT * TRATOR WHERE MODELO_TRT ILIKE '%" + pesq + "%' ORDER BY MODELO_TRT";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            tratorModel obj = new tratorModel(rs.getInt("idTrator"), rs.getString("renavamTrator"), rs.getString("cnpjTrator"), rs.getString("placaTrtator"), rs.getInt("combustivelTrator"), rs.getString("marcaTrator"), rs.getString("modeloTrator"), rs.getInt("anoTrator"));
            dados.add(obj);
        }
        return dados;
    }
}
