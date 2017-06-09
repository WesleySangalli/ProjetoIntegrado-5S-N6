package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import logica.Selecionador;

public class DialogSelecaoDificuldade extends JDialog {

	private static final long serialVersionUID = -8830086507712170306L;

	private int dificuldade;

	public DialogSelecaoDificuldade(Frame owner) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 100));
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
		facil.addActionListener(selecionado -> this.dificuldade = Selecionador.MEDIO);
		selecao.add(medio);
		medio.setSelected(true);

		JRadioButton dificil = new JRadioButton("DIFÍCIL");
		facil.addActionListener(selecionado -> this.dificuldade = Selecionador.DIFICIL);
		selecao.add(dificil);

		ButtonGroup agrupamento = new ButtonGroup();
		agrupamento.add(facil);
		agrupamento.add(medio);
		agrupamento.add(dificil);

		add(titulo, BorderLayout.NORTH);
		add(selecao, BorderLayout.CENTER);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				DialogSelecaoDificuldade.this.setAlwaysOnTop(false);
				DialogSelecaoDificuldade.this.toFront();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				DialogSelecaoDificuldade.this.setVisible(false);
			}
		});

		setVisible(true);
	}

	public int getDificuldade() {
		return dificuldade;
	}
}
