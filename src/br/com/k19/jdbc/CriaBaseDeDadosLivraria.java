package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaBaseDeDadosLivraria {
    public static void main (String[] args) throws Exception{
        String stringDeConexao = "jdbc:mysql://localhost:3306";
        String usuario = "root";
        String senha = "root";
        
        System.out.println("Abrindo conexão...");
        Connection conexao = ConnectionFactory.createConnectio();
        
        System.out.println("Apagando a base de dados livraria...");
        String sql = "DROP DATABASE IF EXISTS livraria";
        PreparedStatement comando = conexao.prepareCall(sql);
        comando.execute();
        comando.close();
        
        System.out.println("Criando a base de dados livraria...");
        sql = "CREATE DATABASE livraria";
        comando = conexao.prepareCall(sql);
        comando.execute();
        comando.close();
        
        System.out.println("Fechando conexão...");
        conexao.close();
    }
}
