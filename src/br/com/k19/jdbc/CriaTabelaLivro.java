package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaTabelaLivro {
   public static void main(String[] args) throws Exception {
       String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
       String usuario = "root";
       String senha = "root";
       
       System.out.println("Abrindo conexão...");
       Connection conexao = ConnectionFactory.createConnectio();
       
       System.out.println("Criando a tabela Livro");
       String sql = "CREATE TABLE Livro (" +
               "id BIGINT NOT NULL AUTO_INCREMENT," +
               "titulo VARCHAR (255) NOT NULL," +
               "preco DOUBLE NOT NULL," +
               "editora_id BIGINT NOT NULL," +
               "PRIMARY KEY (id)," +
               "FOREIGN KEY fk_editora(editora_id) REFERENCES Editora(id)"+
               ")" +
               "ENGINE = InnoDB";
       PreparedStatement comando = conexao.prepareCall(sql);
       comando.execute();
       comando.close();
       
       System.out.println("Fechando a conexão");
       conexao.close();
   } 
}
