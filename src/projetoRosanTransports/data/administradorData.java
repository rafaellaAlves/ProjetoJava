/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;


import projetoRosanTransports.model.administradorModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Rafaella Alves Silva
 */
public class administradorData {
    
    public boolean incluirAdm(administradorModel obj) throws Exception{
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
            String sql2 = "INSERT INTO ADMINISTRADOR (SENHA_ADM) VALUES (?);";
            PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
            ps2.setString(1, obj.getSenhaAdm());
            if(ps2.executeUpdate()>0){
                return true;
            }else{
                throw new Exception("Erro ao inserir administrador!");
            }
        }else{
             throw new Exception("Error!");
        }
    }
    
    public boolean excluirAdm (int id) throws Exception{
        conexao c = new conexao();
        String sql1 = "DELETE FROM ADMINISTRADOR WHERE PESSOA_ID_PSA=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setInt(1, id);
        if(ps.executeUpdate()>0){
            return true;
        }else{
            throw new Exception("Não foi possível excluir este administrador!");
        }
    }
    
    public boolean alterarAdm(administradorModel obj) throws Exception{
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
        if(ps.executeUpdate()>0){
            String sql2 = "UPDATE ADMINISTRATOR SET SENHA_ADM=? WHERE PESSOA_ID_PSA=?";
            PreparedStatement ps2 = c.getConexao().prepareStatement(sql2);
            ps2.setString(1, obj.getSenhaAdm());
            ps2.setInt(2, obj.getIdPessoa());
            if(ps2.executeUpdate()>0){
                return true;
            }else{
                throw new Exception("Erro ao atualizar administrador!");
            }
        }else{
             throw new Exception("Error!");
        }
    }
    
    public ArrayList<administradorModel> pesquisarAdm (String pesq) throws Exception{
        ArrayList<administradorModel> dados = new ArrayList<>();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, A.SENHA_ADM FROM ADMINISTRADOR A, PESSOA P WHERE P.NOME_PSA ILIKE '%" + pesq + "%' ORDER BY P.NOME_PSA";
        conexao c = new conexao();
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            administradorModel obj = new administradorModel(rs.getInt("idPessoa"), rs.getString("nomePessoa"), rs.getString("telefone"), rs.getString("ufPessoa"), rs.getString("cidadePessoa"), rs.getString("enderecoPessoa"), rs.getString("emailPessoa"), rs.getInt("nivelPessoa"), rs.getString("senhaAdm"));
            dados.add(obj);
        }
        return dados;
    }
    
     public administradorModel validarUsuario(String usuario, String senha) throws Exception{
        administradorModel obj = null;
        conexao c = new conexao();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.TEL_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, A.SENHA_ADM FROM PESSOA P, ADMINISTRADOR A WHERE P.ID_PSA = A.PESSOA_ID_PSA AND P.EMAIL_PSA =? AND A.SENHA_ADM=?;";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            obj = new administradorModel(rs.getInt("id_psa"), rs.getString("nome_psa"), rs.getString("tel_psa"), rs.getString("uf_psa"), rs.getString("cidade_psa"), rs.getString("end_psa"), rs.getString("email_psa"), rs.getInt("nivel_psa"), rs.getString("senha_adm"));
            return obj;
        }else{
            return obj;
                       
        }
     }
     
     public administradorModel VerEmail(String email) throws Exception{
        administradorModel obj = null;
        conexao c = new conexao();
        String sql1 = "SELECT P.ID_PSA, P.NOME_PSA, P.TEL_PSA, P.UF_PSA, P.CIDADE_PSA, P.END_PSA, P.EMAIL_PSA, P.NIVEL_PSA, A.SENHA_ADM FROM PESSOA P, ADMINISTRADOR A WHERE P.ID_PSA = A.PESSOA_ID_PSA WHERE P.EMAIL_PSA =?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql1);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            obj = new administradorModel(rs.getInt("idPessoa"), rs.getString("nomePessoa"), rs.getString("telefone"), rs.getString("ufPessoa"), rs.getString("cidadePessoa"), rs.getString("enderecoPessoa"), rs.getString("emailPessoa"), rs.getInt("nivelPessoa"), rs.getString("senhaAdm"));
            return obj;
        }else{
            return obj;
        }
    }
     
     public boolean AlterarSenha(administradorModel obj) throws Exception {
        conexao c = new conexao();
        c.getConexao().setAutoCommit(false);
        String sql1 = "UPDATE ADMINISTRADOR SET SENHA_ADM=? where PESSOA_ID_PSA=?";
        PreparedStatement ps1 = c.getConexao().prepareStatement(sql1);
        ps1.setString(1, obj.getSenhaAdm());
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
