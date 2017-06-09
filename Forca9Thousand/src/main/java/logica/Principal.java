package logica;

public class Principal {

	public static void main(String[] args) {
		Selecionador selecionador = new Selecionador(Selecionador.DIFICIL);
		String palavra = selecionador.seleciona();
		Controlador controlador = new Controlador(palavra);
		String mascarado = controlador.mascarar();

		int retorno = controlador.verificar('A');
		System.out.println("Contem letra? " + (retorno == Controlador.CORRETO));
		System.out.println();
		System.out.println(palavra);
		System.out.println(mascarado);

		System.out.println(controlador.revelar(mascarado, 'A'));
	}
}