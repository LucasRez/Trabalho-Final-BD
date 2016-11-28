package br.unb.cic.DiariasEPassagens.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaProcuraPorNome extends JFrame {

	private JPanel contentPane;
	private JTextField txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcuraPorNome frame = new TelaProcuraPorNome();
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
	public TelaProcuraPorNome() {
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JTextArea txtrDigiteONome = new JTextArea();
		txtrDigiteONome.setBackground(UIManager.getColor("Button.background"));
		txtrDigiteONome.setText("Digite o nome:");
		panel_1.add(txtrDigiteONome);
		
		txtS = new JTextField();
		panel_1.add(txtS);
		txtS.setColumns(10);
		
	}

}
