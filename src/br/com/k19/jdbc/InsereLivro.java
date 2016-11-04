package br.com.k19.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class InsereLivro {
    public static void main(String[] args) throws Exception {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root";
        String senha = "root";
        
        System.out.println("Abrindo conexão...");
        Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
        Scanner entrada = new Scanner(System.in);
        Livro l = new Livro();
        
        System.out.println("Digite o titulo do livro: ");
        l.setTitulo(entrada.nextLine());
        
        System.out.println("Digite o preco do livro");
        l.setPreco(entrada.nextDouble());
        
        System.out.println("Digite o ID da Editora");
        l.setEditora_id(entrada.nextLong());
        
        entrada.close();
        
        String sql = "INSERT INTO Livro (titulo, preco, editora_id)" +
                "VALUES (?, ?, ?)";
        PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        comando.setString(1, l.getTitulo());
        comando.setDouble(2, l.getPreco());
        comando.setLong(3, l.getEditora_id());
        
        System.out.println("Executando comando");
        comando.execute();
        
        System.out.println("Recuperando o ID gerado pelo SGDB...");
        ResultSet generatedKeys = comando.getGeneratedKeys();
        generatedKeys.next();
        l.setId(generatedKeys.getLong(1));
        System.out.println("ID: " + l.getId());
        
        System.out.println("Fechando conezão...");
        conexao.close();
    }
}

