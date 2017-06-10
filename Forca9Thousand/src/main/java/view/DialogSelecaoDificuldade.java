package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import logica.Selecionador;

public class DialogSelecaoDificuldade extends JDialog {

	private static final long serialVersionUID = -8830086507712170306L;

	private int dificuldade = Selecionador.MEDIO;
	private boolean selecionado = false;

	public DialogSelecaoDificuldade(Frame owner) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 150));
		setLocationRelativeTo(owner);
		setLayout(new BorderLayout());
		DialogSelecaoDificuldade.this.setAlwaysOnTop(true);

		JPanel titulo = new JPanel();
		titulo.add(new JLabel("Selecione a dificuldade Desejada:"));

		JPanel selecao = new JPanel();
		JRadioButton facil = new JRadioButton("FÁCIL");
		facil.addActionListener(selecionado -> this.dificuldade = Selecionador.FACIL);
		selecao.add(facil);

		JRadioButton medio = new JRadioButton("MÉDIO");
		medio.addActionListener(selecionado -> this.dificuldade = Selecionador.MEDIO);
		selecao.add(medio);
		medio.setSelected(true);

		JRadioButton dificil = new JRadioButton("DIFÍCIL");
		dificil.addActionListener(selecionado -> this.dificuldade = Selecionador.DIFICIL);
		selecao.add(dificil);

		ButtonGroup agrupamento = new ButtonGroup();
		agrupamento.add(facil);
		agrupamento.add(medio);
		agrupamento.add(dificil);

		JButton btnInicar = new JButton("Inicar");
		btnInicar.addActionListener(inicar -> {
			this.setVisible(false);
			this.selecionado = true;
		});
		add(btnInicar, BorderLayout.SOUTH);
		btnInicar.requestFocus();

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					DialogSelecaoDificuldade.this.setVisible(false);
					DialogSelecaoDificuldade.this.selecionado = true;
				}
			}
		});

		add(titulo, BorderLayout.NORTH);
		add(selecao, BorderLayout.CENTER);
		setVisible(true);
	}

	public int getDificuldade() {
		return this.dificuldade;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

}
