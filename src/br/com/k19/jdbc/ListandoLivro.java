package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListandoLivro {
    public static void main(String[] args) throws Exception {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root";
        String senha = "root";
        
        System.out.println("Abrindo conexão...");
        Connection conexao = DriverManager.getConnection(stringDeConexao, usuario,senha);
        
        String sql = "SELECT * FROM Livro;";
        
        PreparedStatement comando = conexao.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery();
        
        List<Livro> lista = new ArrayList<Livro>();
        while(resultado.next()){
            Livro l = new Livro();
            l.setId(resultado.getLong("id"));
            l.setTitulo(resultado.getString("titulo"));
            l.setPreco(resultado.getDouble("preco"));
            l.setEditora_id(resultado.getLong("editora_id")); 
            lista.add(l);
        }
        
        System.out.println("Registros encontrados: \n");
        for(Livro livro : lista){
            System.out.println("Id: " + livro.getId());
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Preço: " + livro.getPreco());
            System.out.println("Id Editora: " + livro.getEditora_id());
            System.out.println("-----------------------------------------");
        }
        
        System.out.println("/nFechando conexão...");
        conexao.close();
    }
}
