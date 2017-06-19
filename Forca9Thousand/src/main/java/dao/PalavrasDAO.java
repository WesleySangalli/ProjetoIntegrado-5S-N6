package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import conexao.Conexao;

public class PalavrasDAO {
	private final String SELECT_DIFICULDADES = "SELECT DESCRICAO FROM Dificuldade";
	private final String SELECT_PALAVRA = "SELECT PALAVRA FROM Palavras WHERE id_dificuldade = ?";

	private Connection conn = Conexao.INSTANCE.getConnection();

	public List<String> selectAll() throws SQLException {
		try {
			PreparedStatement statement = conn.prepareStatement(SELECT_DIFICULDADES);
			ResultSet rs = statement.executeQuery();

			List<String> dificuldades = new ArrayList<String>();
			while (rs.next()) {
				String dificuldade = rs.getString("DESCRICAO");
				dificuldades.add(dificuldade);
			}
			statement.close();
			return dificuldades;
		} catch (SQLException e) {
			throw e; // TODO error
		}
	}

	public List<String> selectPalavra(int dificuldade) throws SQLException {
		try {
			PreparedStatement statement = conn.prepareStatement(SELECT_PALAVRA);
			AtomicInteger paramIndex = new AtomicInteger(1);

			statement.setInt(paramIndex.getAndIncrement(), dificuldade);
			ResultSet rs = statement.executeQuery();
			List<String> palavras = new ArrayList<String>();
			while (rs.next()) {
				String palavra = rs.getString("PALAVRA");
				palavras.add(palavra);
			}
			return palavras;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
