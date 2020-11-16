/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;

import projetoRosanTransports.model.motoristaModel;
import projetoRosanTransports.model.telefoneModel;
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
public class motoristaData {
    
   
    public boolean incluirMotorista(motoristaModel obj) throws Exception{
        
        conexao c = new conexao();
        String sql1 = "INSERT INTO PESSOA (NOME_PSA, UF_PSA, CIDADE_PSA, END_PSA, EMAIL_PSA, NIVEL_PSA, TEL_PSA) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getNomePessoa());
        ps.setString(2, obj.getUfPessoa());
        ps.setString(3, obj.getCidadePessoa());
        ps.setString(4, obj.getEnderecoPessoa());
        ps.setString(5, obj.getEmailPessoa());
        ps.setInt(6, obj.getNivelPessoa());
        ps.setString(7, obj.getTelefone());
        if(ps.executeUpdate()>0){
            String sl13 = "SELECT MAX(ID_PSA) AS ID_PSA FROM PESSOA;";
            PreparedStatement ps3 = c.getConexao().prepareStatement(sl13);
            ResultSet rs = ps3.executeQuery();
            int id = 0;
            if(rs.next()){
                id = rs.getInt("ID_PSA");
            }
            
                String sql2 = "INSERT INTO MOTORISTA (DATANASC_MOT, CPF_MOT, RG_MOT, CNH_MOT, PESSOA_ID_PSA, SENHA_MOT) VALUES (?,?,?,?,?,?);";
                PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
                ps2.setString(1, obj.getDatanascimento());
                ps2.setString(2, obj.getCpfMotorista());
                ps2.setString(3, obj.getRgMotorista());
                ps2.setString(4, obj.getCnhMotorista());
                obj.setIdPessoa(id);
                ps2.setInt(5, obj.getIdPessoa());
                ps2.setString(6, obj.getSenhaMotorista());            
                if(ps2.executeUpdate()>0){
                    return true;
                }else{
                    throw new Exception("Erro ao inserir motorista!");
                }
           
        }else{
            throw new Exception("Error!");
        } 
    }
    
    public boolean excluirMotorista(int id) throws Exception{
        conexao c = new conexao();
        String sql1 = "DELETE FROM MOTORISTA WHERE PESSOA_ID_PSA=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setInt(1, id);
        
            throw new Exception("Não foi possível excluir este motorista!");
        
    }
    
    public boolean alterarMotorista (motoristaModel obj) throws Exception{
        conexao c = new conexao();
        String sql1 = "UPDATE PESSOA SET NOME_PSA=?, UF_PSA=?, CIDADE_PSA=?, END_PSA=?, EMAIL_PSA=?, NIVEL_PSA=?, TEL_PSA=? WHERE ID_PSA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, obj.getNomePessoa());
        ps.setString(2, obj.getUfPessoa());
        ps.setString(3, obj.getCidadePessoa());
        ps.setString(4, obj.getEnderecoPessoa());
        ps.setString(5, obj.getEmailPessoa());
        ps.setInt(6, obj.getNivelPessoa());
        ps.setString(7, obj.getTelefone());
        ps.setInt(8, obj.getIdPessoa());
        if(ps.executeUpdate() > 0){
            String sql2 = "UPDATE MOTORISTA SET DATANASC_MOT=?, CPF_MOT=?, RG_MOT=?, CNH_MOT=?, SENHA_MOT=? WHERE PESSOA_ID_PSA=?";
            PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
            ps2.setString(1, obj.getDatanascimento());
            ps2.setString(2, obj.getCpfMotorista());
            ps2.setString(3, obj.getRgMotorista());
            ps2.setString(4, obj.getCnhMotorista());
            ps2.setString(5, obj.getSenhaMotorista());
            ps2.setInt(6, obj.getIdPessoa());
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                throw new Exception("Não foi possível atualizar motorista!");
            }
        }else{
            throw new Exception("Error!");
        }
    }
    
    public ArrayList<motoristaModel> pesquisarMotorista(String pesq) throws Exception{
        ArrayList<motoristaModel> dados = new ArrayList<>();
        String sql1 = "SELECT * FROM MOTORISTA M, PESSOA P WHERE P.ID_PSA = M.PESSOA_ID_PSA AND P.NOME_PSA ILIKE '%" + pesq + "%' ORDER BY P.NOME_PSA";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            motoristaModel obj = new motoristaModel(rs.getInt("id_psa"), rs.getString("nome_psa"), rs.getString("tel_psa"), rs.getString("uf_psa"), rs.getString("cidade_psa"), rs.getString("end_psa"), rs.getString("email_psa"), rs.getInt("nivel_psa"), rs.getString("datanasc_mot"), rs.getString("cpf_mot"), rs.getString("rg_mot"), rs.getString("cnh_mot"), rs.getString("senha_mot"));
            dados.add(obj);
        }
        return dados;
    }
    
    
    public ArrayList<motoristaModel> pesquisarTudo() throws Exception{
        ArrayList<motoristaModel> dados = new ArrayList<>();
        String sql1 = "SELECT * FROM MOTORISTA";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            motoristaModel obj = new motoristaModel();
            obj.setCpfMotorista(rs.getString("cpf_mot"));
            dados.add(obj);
        }
        return dados;
    }
    
    public boolean motoristaUnico(motoristaModel obj)  throws Exception{
        ArrayList<motoristaModel> lista = pesquisarTudo();
        String msg = new String();
        for (motoristaModel list : lista){
            if(list.getCpfMotorista().equals(obj.getCpfMotorista())){
                msg = "CPF já cadastrado!\n";
                throw new Exception(msg);
            }            
        }
        return true;
    }
    
    public motoristaModel validarUsuario(String usuario, String senha) throws Exception{
        motoristaModel obj = null;
        conexao c = new conexao();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.TEL_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, M.DATANASC_MOT, M.CPF_MOT, M.RG_MOT, M.CNH_MOT, M.SENHA_MOT FROM PESSOA P, MOTORISTA M WHERE P.ID_PSA = M.PESSOA_ID_PSA AND P.EMAIL_PSA =? AND M.SENHA_MOT=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            obj = new motoristaModel(rs.getInt("id_psa"), rs.getString("nome_psa"), rs.getString("tel_psa"), rs.getString("uf_psa"), rs.getString("cidade_psa"), rs.getString("end_psa"), rs.getString("email_psa"), rs.getInt("nivel_psa"), rs.getString("datanasc_mot"), rs.getString("cpf_mot"), rs.getString("rg_mot"), rs.getString("cnh_mot"), rs.getString("senha_mot"));
            return obj;
        }else{
            return obj;
        }
    }
    
    public motoristaModel VerEmail(String email) throws Exception{
        motoristaModel obj = null;
        conexao c = new conexao();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.TEL_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, M.DATANASC_MOT, M.CPF_MOT, M.RG_MOT, M.CNH_MOT, M.SENHA_MOT FROM PESSOA P, MOTORISTA M WHERE P.ID_PSA = M.PESSOA_ID_PSA and P.EMAIL_PSA = ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            obj = new motoristaModel(rs.getInt("id_psa"), rs.getString("nome_psa"), rs.getString("tel_psa"), rs.getString("uf_psa"), rs.getString("cidade_psa"), rs.getString("end_psa"), rs.getString("email_psa"), rs.getInt("nivel_psa"), rs.getString("datanasc_mot"), rs.getString("cpf_mot"), rs.getString("rg_mot"), rs.getString("cnh_mot"), rs.getString("senha_mot"));
            return obj;
        }else{
            return obj;
        }
    }
    
    public boolean AlterarSenha(motoristaModel obj) throws Exception {
        conexao c = new conexao();
        c.getConexao().setAutoCommit(false);
        String sql1 = "UPDATE MOTORISTA SET SENHA_MOT=? where PESSOA_ID_PSA=?";
        PreparedStatement ps1 = c.getConexao().prepareStatement(sql1);
        ps1.setString(1, obj.getSenhaMotorista());
        ps1.setInt(2, obj.getIdPessoa());
        if (ps1.executeUpdate() > 0) {
            c.getConexao().commit();
            c.getConexao().setAutoCommit(true);
            return true;
        } else {
            c.getConexao().rollback();
            c.getConexao().setAutoCommit(true);
            throw new Exception("Não foi possível atualizar.");
        }
    }
}
