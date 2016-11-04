package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListaEditoras {
    public static void main(String[] args) throws Exception {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root";
        String senha = "root";
     
        System.out.println("Abrindo conexão...");
        Connection conexao = ConnectionFactory.createConnectio();
     
        String sql = "SELECT * FROM Editora;";
     
        PreparedStatement comando = conexao.prepareStatement(sql);
     
        ResultSet resultado = comando.executeQuery();
     
        List<Editora> lista = new ArrayList<Editora>();
     
        while(resultado.next()){
            Editora e = new Editora();
            e.setId(resultado.getLong("id"));
            e.setNome(resultado.getString("nome"));
            e.setEmail(resultado.getString("email"));
            lista.add(e);
        }
        
        System.out.println("Resultados encontrados: \n");
        for(Editora editora : lista){
            System.out.println("Id: " + editora.getId());
            System.out.println("Nome: " + editora.getNome());
            System.out.println("Email: " + editora.getEmail());
            System.out.println("-----------------------------------");
        }
        
        System.out.println("\nFechando conexão...");
        conexao.close();
    }
}
