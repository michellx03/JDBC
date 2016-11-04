package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsereEditora {
    public static void main(String[] args) throws Exception {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root";
        String senha = "root";
        
        System.out.println("Abrindo conexão...");
        Connection conexao = ConnectionFactory.createConnectio();
        Scanner entrada = new Scanner(System.in);
        Editora e = new Editora();
        
        System.out.println("Digite o nome da editora: ");
        e.setNome(entrada.nextLine());
        
        System.out.println("Digite o email da editora: ");
        e.setEmail(entrada.nextLine());
        
        entrada.close();
        
        String sql = "INSERT INTO Editora (nome, email) " +
                "VALUES (?, ?)";
        PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        comando.setString(1, e.getNome());
        comando.setString(2, e.getEmail());
        
        System.out.println("Executando comando...");
        comando.execute();
        
        System.out.println("Recuperando o ID gerado pelo SGDB...");
        ResultSet generatedKeys = comando.getGeneratedKeys();
        generatedKeys.next();
        e.setId(generatedKeys.getLong(1));
        System.out.println("ID: " + e.getId());
        
        System.out.println("Fechando conezão...");
        conexao.close();
    }
}
