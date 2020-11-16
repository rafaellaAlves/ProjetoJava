/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.data;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Rafaella Alves Silva
 */
public class conexao {
    private Connection con;
    
    public conexao() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/RosanTransportes";
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url,"postgres","adminadmin");
        System.out.println("Conectado com sucesso!");
    }
    public Connection getConexao(){
        return con;
    }
}
