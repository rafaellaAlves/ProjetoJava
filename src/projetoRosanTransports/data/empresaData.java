/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;

import projetoRosanTransports.model.empresaModel;
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
public class empresaData {
    
    public boolean incluirEmpresa(empresaModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "INSERT INTO PESSOA (NOME_PSA, TEL_PSA, UF_PSA, CIDADE_PSA, END_PSA, EMAIL_PSA, NIVEL_PSA) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getNomePessoa());
        ps.setString(2, obj.getTelefone());
        ps.setString(2, obj.getUfPessoa());
        ps.setString(3, obj.getCidadePessoa());
        ps.setString(4, obj.getEnderecoPessoa());
        ps.setString(5, obj.getEmailPessoa());
        ps.setInt(6, obj.getNivelPessoa());        
        if(ps.executeUpdate()>0){
            String sql2 = "INSERT INTO EMPRESA (CNPJ_EMP) VALUES (?);";
            PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
            ps2.setString(1, obj.getCnpjEmpresa());
            if(ps2.executeUpdate()>0){
                return true;
            }else{
                throw new Exception("Erro ao inserir empresa!");
            }
        }else{
            throw new Exception("Error!");
        }
    }
    
    public boolean excluirEmpresa(int id) throws Exception{
        conexao c = new conexao();
        String sql1 = "DELETE FROM EMPRESA WHERE PESSOA_ID_PSA=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setInt(1, id);
        if(ps.executeUpdate() > 0){
            return true;
        }else{
            throw new Exception("Não foi possível excluir esta empresa!");
        }
    }
    
    public boolean alterarEmpresa(empresaModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "UPDATE PESSOA SET NOME_PSA=?, TEL_PSA=?, UF_PSA=?, CIDADE_PSA=?, END_PSA=?, EMAIL_PSA=?, NIVEL_PSA=? WHERE ID_PSA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getNomePessoa());
        ps.setString(2, obj.getTelefone());
        ps.setString(2, obj.getUfPessoa());
        ps.setString(3, obj.getCidadePessoa());
        ps.setString(4, obj.getEnderecoPessoa());
        ps.setString(5, obj.getEmailPessoa());
        ps.setInt(6, obj.getNivelPessoa());
        ps.setInt(7, obj.getIdPessoa());
        if(ps.executeUpdate() > 0){
            String sql2 = "UPDATE EMPRESA SET CNPJ_EMP=? WHERE PESSOA_ID_PSA =?;";
            PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
            ps2.setString(1, obj.getCnpjEmpresa());
            ps2.setInt(2, obj.getIdPessoa());
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                throw new Exception("Não foi possível atualizar empresa!");
            }
        }else{
            throw new Exception("Error!");
        }
    }
    
    public ArrayList<empresaModel> pesquisarEmpresa(String pesq) throws Exception{
        ArrayList<empresaModel> dados = new ArrayList<>();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, E.CNPJ_EMP FROM EMPRESA E, PESSOA P WHERE P.NOME_PSA ILIKE '%" + pesq + "%' ORDER BY P.NOME_PSA";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            empresaModel obj = new empresaModel(rs.getString("cnpjEmpresa"), rs.getInt("idPessoa"), rs.getString("nomePessoa"), rs.getString("telefone"), rs.getString("ufPessoa"), rs.getString("cidadePessoa"), rs.getString("enderecoPessoa"), rs.getString("emailPessoa"), rs.getInt("nivelPessoa"));
            dados.add(obj);
        }
        return dados;
    }
    
    public ArrayList<empresaModel> pesquisarTudo() throws Exception{
        ArrayList<empresaModel> dados = new ArrayList<>();
        String sql1 = "SELECT * FROM EMPRESA";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            empresaModel obj = new empresaModel();
            obj.setCnpjEmpresa(rs.getString("cnpjEmpresa"));
            dados.add(obj);
        }
        return dados;
    }
    
    public boolean EmpresaUnico(empresaModel obj)  throws Exception{
        ArrayList<empresaModel> lista = pesquisarTudo();
        String msg = new String();
        for (empresaModel list : lista){
            if(list.getCnpjEmpresa().equals(obj.getCnpjEmpresa())){
                msg = "CNPJ já cadastrado!\n";
                throw new Exception(msg);
            }            
        }
        return true;
    }
}
