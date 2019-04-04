package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		String nome = "Notebook";
		String descricao = "Notebook i5";
		Connection connection = Database.getConnection();
		
		String sql = "insert into produto (nome, descricao) values (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nome);
		statement.setString(2, descricao);
		boolean resultado = statement.execute();
		System.out.println(resultado);
		ResultSet generatedKeys = statement.getGeneratedKeys();
		
		while(generatedKeys.next()) {
			long id = generatedKeys.getLong("id");
			System.out.println("id gerado: " + id);
		}
		
		generatedKeys.close();
		statement.close();
		connection.close();
	}
}
