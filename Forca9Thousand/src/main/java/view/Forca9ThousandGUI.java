package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
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

	private JLabel tentiva1;
	private JLabel tentiva2;
	private JLabel tentiva3;
	private JLabel tentiva4;
	private JLabel tentiva5;
	private JLabel tentiva6;
	private JLabel tentiva7;

	private JLabel[] labelTentativas;

	private int tentativas = 0;

	private JRadioButtonMenuItem itnFacil;
	private JRadioButtonMenuItem itnMedio;
	private JRadioButtonMenuItem itnDificl;

	private Controlador controlador;

	private JLabel titulo;

	private void createGUI() {
		setSize(new Dimension(700, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Forca9Thousand");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Opções");
		JMenuItem itnSair = new JMenuItem("Sair");
		itnSair.addActionListener(e -> System.exit(0));
		menu.add(itnSair);

		menu.addSeparator();

		JMenu itnTrocarDificuldade = new JMenu("Dificuldade");
		itnFacil = new JRadioButtonMenuItem("Fácil");
		itnFacil.addActionListener(e -> {
			this.dificuldade = Selecionador.FACIL;
			reset();
		});
		itnTrocarDificuldade.add(itnFacil);

		itnMedio = new JRadioButtonMenuItem("Médio");
		itnMedio.addActionListener(e -> {
			this.dificuldade = Selecionador.MEDIO;
			reset();
		});
		itnTrocarDificuldade.add(itnMedio);

		itnDificl = new JRadioButtonMenuItem("Difícil");
		itnDificl.addActionListener(e -> {
			this.dificuldade = Selecionador.DIFICIL;
			reset();
		});
		itnTrocarDificuldade.add(itnDificl);
		ButtonGroup agrupamentoDificuldade = new ButtonGroup();
		agrupamentoDificuldade.add(itnFacil);
		agrupamentoDificuldade.add(itnMedio);
		agrupamentoDificuldade.add(itnDificl);

		menu.add(itnTrocarDificuldade);

		menubar.add(menu);

		setJMenuBar(menubar);

		JPanel superior = new JPanel(new BorderLayout());
		titulo = new JLabel("Dificuldade: " + (dificuldade == 1 ? "FÁCIL" : dificuldade == 2 ? "MÉDIA" : "DIFÍCIL"));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		superior.add(titulo, BorderLayout.NORTH);

		JPanel painelTentativas = new JPanel();
		tentiva1 = new JLabel("•");
		tentiva1.setForeground(Color.GREEN);
		painelTentativas.add(tentiva1);
		tentiva2 = new JLabel("•");
		tentiva2.setForeground(Color.GREEN);
		painelTentativas.add(tentiva2);
		tentiva3 = new JLabel("•");
		tentiva3.setForeground(Color.GREEN);
		painelTentativas.add(tentiva3);
		tentiva4 = new JLabel("•");
		tentiva4.setForeground(Color.GREEN);
		painelTentativas.add(tentiva4);
		tentiva5 = new JLabel("•");
		tentiva5.setForeground(Color.GREEN);
		painelTentativas.add(tentiva5);
		tentiva6 = new JLabel("•");
		tentiva6.setForeground(Color.GREEN);
		painelTentativas.add(tentiva6);
		tentiva7 = new JLabel("•");
		tentiva7.setForeground(Color.GREEN);
		painelTentativas.add(tentiva7);
		labelTentativas = new JLabel[] { tentiva1, tentiva2, tentiva3, tentiva4, tentiva5, tentiva6, tentiva7 };

		superior.add(painelTentativas);

		add(superior, BorderLayout.NORTH);

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

		A.addActionListener(e -> handleLetterClick(A));
		B.addActionListener(e -> handleLetterClick(B));
		C.addActionListener(e -> handleLetterClick(C));
		D.addActionListener(e -> handleLetterClick(D));
		E.addActionListener(e -> handleLetterClick(E));
		F.addActionListener(e -> handleLetterClick(F));
		G.addActionListener(e -> handleLetterClick(G));
		H.addActionListener(e -> handleLetterClick(H));
		I.addActionListener(e -> handleLetterClick(I));
		J.addActionListener(e -> handleLetterClick(J));
		K.addActionListener(e -> handleLetterClick(K));
		L.addActionListener(e -> handleLetterClick(L));
		M.addActionListener(e -> handleLetterClick(M));
		N.addActionListener(e -> handleLetterClick(N));
		O.addActionListener(e -> handleLetterClick(O));
		P.addActionListener(e -> handleLetterClick(P));
		Q.addActionListener(e -> handleLetterClick(Q));
		R.addActionListener(e -> handleLetterClick(R));
		S.addActionListener(e -> handleLetterClick(S));
		T.addActionListener(e -> handleLetterClick(T));
		U.addActionListener(e -> handleLetterClick(U));
		V.addActionListener(e -> handleLetterClick(V));
		W.addActionListener(e -> handleLetterClick(W));
		X.addActionListener(e -> handleLetterClick(X));
		Y.addActionListener(e -> handleLetterClick(Y));
		Z.addActionListener(e -> handleLetterClick(Z));

		JPanel botoes = new JPanel();
		botoes.setLayout(new BorderLayout());
		botoes.add(rowbotoes1, BorderLayout.PAGE_START);
		botoes.add(rowbotoes2, BorderLayout.PAGE_END);
		add(botoes, BorderLayout.SOUTH);

		switch (dificuldade) {
		case 1:
			itnFacil.setSelected(true);
			break;
		case 2:
			itnMedio.setSelected(true);
			break;
		case 3:
			itnDificl.setSelected(true);
			break;
		}

		selecionaPalavra();

		requestFocus();
	}

	private void selecionaPalavra() {
		Selecionador selecionador = new Selecionador(dificuldade);
		String palavra = selecionador.seleciona();

		controlador = new Controlador(palavra);
		this.palavra.setText(controlador.mascarar());
	}

	private void reset() {
		tentativas = 0;
		tentiva1.setForeground(Color.GREEN);
		tentiva2.setForeground(Color.GREEN);
		tentiva3.setForeground(Color.GREEN);
		tentiva4.setForeground(Color.GREEN);
		tentiva5.setForeground(Color.GREEN);
		tentiva6.setForeground(Color.GREEN);
		tentiva7.setForeground(Color.GREEN);
		labelTentativas = new JLabel[] { tentiva1, tentiva2, tentiva3, tentiva4, tentiva5, tentiva6, tentiva7 };

		selecionaPalavra();
		this.titulo.setText("Dificuldade: " + (dificuldade == 1 ? "FÁCIL" : dificuldade == 2 ? "MÉDIA" : "DIFÍCIL"));
	}

	private void selecionaDificuldade() {
		DialogSelecaoDificuldade selecaoDialog = new DialogSelecaoDificuldade(this);
		while (!selecaoDialog.isSelecionado()) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				Thread.interrupted();
			}
		}
		this.dificuldade = selecaoDialog.getDificuldade();
	}

	public void launchForca9Thousand() {
		selecionaDificuldade();
		createGUI();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.exit(-1);
		}
		setVisible(true);
	}

	private void handleLetterClick(JButton btnClicked) {
		char letter = btnClicked.getText().charAt(0);

		int retorno = controlador.verificar(letter);

		if (retorno == Controlador.CORRETO) {
			this.palavra.setText(controlador.revelar(this.palavra.getText(), letter));
			if (controlador.verificaCompleto(this.palavra.getText())) {
				int confirm = JOptionPane.showConfirmDialog(this, "Você adivinhou a palavra! Gostaria de jogar novamente?", "Parabéns!", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					reset();
				} else {
					System.exit(0);
				}
			}
		} else if (retorno == Controlador.ESGOTADO) {
			labelTentativas[tentativas].setForeground(Color.RED);
			int confirm = JOptionPane.showConfirmDialog(this, "Você esgotou suas tentativas! Gostaria de recomeçar?", "Ops!", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				reset();
			} else {
				System.exit(0);
			}
		} else if (retorno == Controlador.ERRADO) {
			labelTentativas[tentativas].setForeground(Color.RED);
			tentativas++;
		}
	}

	public static void main(String[] args) {
		new Forca9ThousandGUI().launchForca9Thousand();
	}

}