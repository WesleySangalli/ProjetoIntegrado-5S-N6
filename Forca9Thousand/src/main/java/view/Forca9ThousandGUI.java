package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Forca9ThousandGUI extends JFrame {

	private static final long serialVersionUID = 7292392445981642274L;

	public Forca9ThousandGUI() {
	}

	private void createGUI() {
		setSize(new Dimension(900, 600));
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		requestFocus();
		setVisible(true);
	}

	private void selecionaDificuldade() {
		DialogSelecaoDificuldade selecao = new DialogSelecaoDificuldade(this);

	}

	public static void main(String[] args) {
		Forca9ThousandGUI forca9ThousandGUI = new Forca9ThousandGUI();
		forca9ThousandGUI.createGUI();
		forca9ThousandGUI.selecionaDificuldade();
	}
}
