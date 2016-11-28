package br.unb.cic.DiariasEPassagens.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class TelaProcuraPorCPF extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcuraPorCPF frame = new TelaProcuraPorCPF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProcuraPorCPF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Voltar");
		panel.add(btnNewButton);
		
		JButton btnExecutar = new JButton("Executar");
		panel.add(btnExecutar);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JTextArea txtrDigiteOCpf = new JTextArea();
		txtrDigiteOCpf.setBackground(UIManager.getColor("Button.background"));
		txtrDigiteOCpf.setText("Digite o CPF:");
		panel_1.add(txtrDigiteOCpf);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
	}

}
