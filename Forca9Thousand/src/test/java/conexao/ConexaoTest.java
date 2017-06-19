package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.PalavrasDAO;

public class ConexaoTest {

	@Test
	public void testaConexao() {
		Connection connection = Conexao.INSTANCE.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testaSelectDificuldade() throws SQLException {
		PalavrasDAO dificuldadeDAO = new PalavrasDAO();
		List<String> lista = dificuldadeDAO.selectAll();
		Assert.assertNotNull(lista);
		if (lista.size() <= 0) {
			Assert.fail("Lista vázia!");
		}
	}
}
