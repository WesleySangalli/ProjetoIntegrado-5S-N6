package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum Conexao {

	INSTANCE;

	private Connection connection = null;

	public Connection getConnection() {
		return connection == null ? createConnection() : connection;
	}

	private Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jogo", "postgres", "1234");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
