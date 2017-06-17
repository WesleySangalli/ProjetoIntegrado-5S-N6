package logica.test;

import org.junit.Assert;
import org.junit.Test;

import negocio.Controlador;

public class TestaControlador {

	@Test
	public void testaNaoContem() {
		Controlador controlador = new Controlador("ABACATE");

		int retorno = controlador.verificar('X');
		Assert.assertTrue(retorno == Controlador.ERRADO);
	}

	@Test
	public void testaContem() {
		Controlador controlador = new Controlador("ROBALO");

		int retorno = controlador.verificar('O');
		Assert.assertTrue(retorno == Controlador.CORRETO);
	}

	@Test
	public void testaLimite() {
		Controlador controlador = new Controlador("ESTOMAGO");

		int limite = 0;
		int retorno = 0;
		while (limite <= 7) {
			retorno = controlador.verificar('Z');
			limite++;
		}

		if (!(retorno == Controlador.ESGOTADO)) {
			Assert.fail("Deveria estar esgotado");
		}
	}

	@Test
	public void testaRevela() {
		Controlador controlador = new Controlador("ABACATE");
		String palavra = controlador.mascarar();
		palavra = controlador.revelar(palavra, 'A');
		Assert.assertEquals("A_A_A__", palavra);
	}

}
