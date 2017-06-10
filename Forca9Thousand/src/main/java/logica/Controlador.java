package logica;

import java.util.concurrent.atomic.AtomicInteger;

public class Controlador {

	private final String palavra;
	private AtomicInteger tentativas = new AtomicInteger(6);

	public static final int CORRETO = 1;
	public static final int ERRADO = 2;
	public static final int ESGOTADO = 3;
	public static final int COMPLETO = 4;

	public Controlador(String palavra) {
		this.palavra = palavra;
	}

	public String mascarar() {
		char[] caracteres = palavra.toCharArray();

		StringBuilder mascarados = new StringBuilder();
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i] == ' ' || caracteres[i] == '-') {
				mascarados.append(caracteres[i]);
			} else {
				mascarados.append("_");
			}
		}

		return mascarados.toString();
	}

	public int verificar(char caractere) {
		if (palavra.contains("" + caractere)) { // GAMBIARRA LOL
			return CORRETO;
		} else {
			if (verificaTentativasEsgotadas()) {
				return ESGOTADO;
			} else {
				tentativas.decrementAndGet();
				return ERRADO;
			}
		}
	}

	public String revelar(String palavra, char caractere) {
		char[] caracteres = palavra.toCharArray();

		for (int i = 0; i < this.palavra.length(); i++) {
			if (this.palavra.toCharArray()[i] == caractere) {
				caracteres[i] = caractere;
			}
		}

		return new String(caracteres).toUpperCase(); // UPPER CASE POR GARANTIA
	}

	private boolean verificaTentativasEsgotadas() {
		return tentativas.get() <= 0;
	}

	public boolean verificaCompleto(String palavra) {
		return this.palavra.equals(palavra);
	}
}