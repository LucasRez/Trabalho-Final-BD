package br.unb.cic.DiariasEPassagens.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2, BorderLayout.SOUTH);
		
		JButton btnAdicionarNovoElemento = new JButton("Adicionar novo elemento");
		panel2.add(btnAdicionarNovoElemento);
		
		JButton btnExecutarQuery = new JButton("Executar Query");
		panel2.add(btnExecutarQuery);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Qual servidor gastou mais?");
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Lista decresc de gastos");
		panel.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Lista cresc de gastos");
		panel.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Orgao superior que mais gastou");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Qual programa gastou mais");
		panel.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Gasto total dos 6 meses");
		panel.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Qual acao gastou mais");
		panel.add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Retornar gastos por PagamCod");
		panel.add(rdbtnNewRadioButton_9);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("Retornar gastos pelo CPF");
		panel.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Retornar gastos pelo nome");
		panel.add(rdbtnNewRadioButton_11);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Qual programa da acao gastou mais?");
		panel.add(rdbtnNewRadioButton_5);
		
	}
}
