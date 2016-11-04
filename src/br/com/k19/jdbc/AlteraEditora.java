package br.com.k19.jdbc;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;

public class AlteraEditora {
    public static void main (String[] args) throws Exception {
        
        System.out.println("Abrindo conexão...");
        Connection conexao = ConnectionFactory.createConnectio();
        
        Scanner entrada = new Scanner(System.in);
        Editora e = new Editora();
        
        System.out.println("Escolha o ID da editora que deseja alterar: ");
        e.setId(Long.parseLong(entrada.nextLine()));
        
        System.out.println("Digite o novo nome da editora: ");
        e.setNome(entrada.nextLine());
        
        System.out.println("Digite o novo email da editra: ");
        e.setEmail(entrada.nextLine());
        
        entrada.close();
        
        String sql = "UPDATE Editora SET nome=?, email=? WHERE id=?";
        
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, e.getNome());
        comando.setString(2, e.getEmail());
        comando.setLong(3, e.getId());
        
        System.out.println("Executando o comando...");
        comando.execute();
        
        System.out.println("Fechando conexão...");
        conexao.close();
    }
}
