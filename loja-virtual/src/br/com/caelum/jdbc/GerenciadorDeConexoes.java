package br.com.caelum.jdbc;

public class GerenciadorDeConexoes {

	public static Connection getConnection(String tipo, String ip, String nome, String usuario, String senha) {

		if (tipo.equals("mysql")) {
			return new MySQLConnection(ip, nome, usuario, senha);
		} else if (tipo.equals("sqlserver")) {
			return new SqlServerConnection(ip, nome, usuario, senha);
		}

		throw new IllegalArgumentException("Tipo de banco não suportado");
	}

}