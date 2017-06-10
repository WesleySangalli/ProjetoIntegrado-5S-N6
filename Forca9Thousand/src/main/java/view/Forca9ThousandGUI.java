package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import logica.Controlador;
import logica.Selecionador;

public class Forca9ThousandGUI extends JFrame {

	private static final long serialVersionUID = 7292392445981642274L;

	private int dificuldade = 0;

	public Forca9ThousandGUI() {

	}

	// BOTOES
	private JButton A = new JButton("A");
	private JButton B = new JButton("B");
	private JButton C = new JButton("C");
	private JButton D = new JButton("D");
	private JButton E = new JButton("E");
	private JButton F = new JButton("F");
	private JButton G = new JButton("G");
	private JButton H = new JButton("H");
	private JButton I = new JButton("I");
	private JButton J = new JButton("J");
	private JButton K = new JButton("K");
	private JButton L = new JButton("L");
	private JButton M = new JButton("M");
	private JButton N = new JButton("N");
	private JButton O = new JButton("O");
	private JButton P = new JButton("P");
	private JButton Q = new JButton("Q");
	private JButton R = new JButton("R");
	private JButton S = new JButton("S");
	private JButton T = new JButton("T");
	private JButton U = new JButton("U");
	private JButton V = new JButton("V");
	private JButton W = new JButton("W");
	private JButton X = new JButton("X");
	private JButton Y = new JButton("Y");
	private JButton Z = new JButton("Z");

	private JLabel palavra;

	private void createGUI() {
		setSize(new Dimension(700, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Opções");
		JMenuItem itnSair = new JMenuItem("Sair");
		menu.add(itnSair);
		menubar.add(menu);

		setJMenuBar(menubar);

		JPanel titulo = new JPanel();
		titulo.add(new JLabel("Forca9Thousand "));
		titulo.add(new JLabel(
				"Nivel de Dificuldade - " + (dificuldade == 1 ? "FÁCIL" : dificuldade == 2 ? "MÉDIO" : "DIFÍCIL")));

		add(titulo, BorderLayout.NORTH);

		JPanel painelPalavra = new JPanel(new BorderLayout());
		painelPalavra.setBackground(Color.WHITE);

		palavra = new JLabel("");
		palavra.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
		palavra.setHorizontalAlignment(SwingConstants.CENTER);

		painelPalavra.add(palavra);
		add(painelPalavra, BorderLayout.CENTER);

		JPanel rowbotoes1 = new JPanel();

		rowbotoes1.add(A);
		rowbotoes1.add(B);
		rowbotoes1.add(C);
		rowbotoes1.add(D);
		rowbotoes1.add(E);
		rowbotoes1.add(F);
		rowbotoes1.add(G);
		rowbotoes1.add(H);
		rowbotoes1.add(I);
		rowbotoes1.add(J);
		rowbotoes1.add(K);
		rowbotoes1.add(L);

		JPanel rowbotoes2 = new JPanel();
		rowbotoes2.add(M);
		rowbotoes2.add(N);
		rowbotoes2.add(O);
		rowbotoes2.add(P);
		rowbotoes2.add(Q);
		rowbotoes2.add(R);
		rowbotoes2.add(S);
		rowbotoes2.add(T);
		rowbotoes2.add(U);
		rowbotoes2.add(V);
		rowbotoes2.add(W);
		rowbotoes2.add(X);
		rowbotoes2.add(Y);
		rowbotoes2.add(Z);

		JPanel botoes = new JPanel();
		botoes.setLayout(new BorderLayout());
		botoes.add(rowbotoes1, BorderLayout.PAGE_START);
		botoes.add(rowbotoes2, BorderLayout.PAGE_END);
		add(botoes, BorderLayout.SOUTH);

		Selecionador selecionador = new Selecionador(dificuldade);
		String palavra = selecionador.seleciona();

		Controlador controlador = new Controlador(palavra);
		this.palavra.setText(controlador.mascarar());

		requestFocus();
	}

	private void selecionaDificuldade() {
		DialogSelecaoDificuldade selecao = new DialogSelecaoDificuldade(this);

		while (!selecao.isSelecionado()) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				Thread.interrupted();
			}
		}

		this.dificuldade = selecao.getDificuldade();
	}

	public static void main(String[] args) {
		Forca9ThousandGUI forca9ThousandGUI = new Forca9ThousandGUI();
		forca9ThousandGUI.selecionaDificuldade();
		forca9ThousandGUI.createGUI();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.exit(-1);
		}
		forca9ThousandGUI.setVisible(true);
	}
}