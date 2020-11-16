/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;

import projetoRosanTransports.model.reboqueModel;
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
public class reboqueData {
    
    public boolean incluirReboque(reboqueModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "INSERT INTO REBOQUE (CNPJ_RBQ, PLACA_RBQ, MARCA_RBQ, ANO_RBQ, TRATOR_ID_TRT, RENVAM_RBQ);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        if(ps.executeUpdate()>0){
            ps.setString(1, obj.getCnpjReboque());
            ps.setString(2, obj.getPlacaReboque());
            ps.setString(3, obj.getMarcaReboque());
            ps.setInt(4, obj.getAnoReboque());
            ps.setInt(5, obj.getTrator().getIdTrator());
            ps.setString(6, obj.getRenavamReboque());
            if(ps.executeUpdate()>0){
                return true;
            }else{
                 throw new Exception("Erro ao inserir reboque!");
            }
        }else{
            throw new Exception("Error!");
        }
    }
    
    public boolean excluirReboque(int id) throws Exception{
        conexao c = new conexao();
        String sql1 = "DELETE FROM REBOQUE WHERE ID_RBQ =?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setInt(1, id);
        if(ps.executeUpdate() > 0){
            return true;
        }else{
            throw new Exception("Não foi possível excluir este reboque!");
        }
    }
    
    public boolean alterarReboque(reboqueModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "UPDATE REBOQUE SET CNPJ_RBQ=?, PLACA_RBQ=?, MARCA_RBQ=?, ANO_RBQ=?, TRATOR_ID_TRT=?, RENVAM_RBQ=? WHERE ID_RBQ=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        if(ps.executeUpdate()>0){
            ps.setString(1, obj.getCnpjReboque());
            ps.setString(2, obj.getPlacaReboque());
            ps.setString(3, obj.getMarcaReboque());
            ps.setInt(4, obj.getAnoReboque());
            ps.setInt(5, obj.getTrator().getIdTrator());
            ps.setString(6, obj.getRenavamReboque());
            ps.setInt(7, obj.getIdReboque());
            if(ps.executeUpdate()>0){
                return true;
            }else{
                 throw new Exception("Erro ao inserir reboque!");
            }
        }else{
            throw new Exception("Error!");
        }
    }
    
    public ArrayList<reboqueModel> pesquisarReboque(String pesq) throws Exception{
        ArrayList<reboqueModel> dados = new ArrayList<>();
        
        String sql1 = "SELECT * REBOQUE WHERE PLACA_RBQ ILIKE '%" + pesq + "%' ORDER BY MARCA_RBQ";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            
            reboqueModel obj = new reboqueModel();
            obj.setIdReboque(rs.getInt("idReboque"));
            obj.setTrator(new tratorModel(rs.getInt("trator"), rs.getString("renavamTrator"), rs.getString("cnpjTrator"), rs.getString("placaTrtator"), rs.getInt("combustivelTrator"), rs.getString("marcaTrator"), rs.getString("modeloTrator"), rs.getInt("anoTrator")));
            obj.setRenavamReboque(rs.getString("renavamTrator"));
            obj.setCnpjReboque(rs.getString("cnpjTrator"));
            obj.setPlacaReboque(rs.getString("placaTrator"));
            obj.setMarcaReboque(rs.getString("marcaTrator"));
            obj.setAnoReboque(rs.getInt("anoTrator"));
            dados.add(obj);
        }
        return dados;
    }
}
