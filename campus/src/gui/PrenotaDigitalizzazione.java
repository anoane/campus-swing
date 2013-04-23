package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PrenotaDigitalizzazione extends JPanel {
	private JTextField textField;
	public PrenotaDigitalizzazione() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 800);
		add(panel);
		
		JLabel label = new JLabel("Prenotazione Libri");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 200, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(21, 72, 415, 396);
		formPanel.setBorder(new EmptyBorder(10,10,10,10));
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{189, 189, 0, 0};
		gbl_formPanel.rowHeights = new int[] {60, 60, 60, 60, 60, 0, 0, 60, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lblNomeDoc = new JLabel("Nome documento");
		lblNomeDoc.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNomeDoc = new GridBagConstraints();
		gbc_lblNomeDoc.anchor = GridBagConstraints.WEST;
		gbc_lblNomeDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoc.gridx = 0;
		gbc_lblNomeDoc.gridy = 0;
		formPanel.add(lblNomeDoc, gbc_lblNomeDoc);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		formPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descrizione");
		lblDesc.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.anchor = GridBagConstraints.WEST;
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 1;
		formPanel.add(lblDesc, gbc_lblDesc);
		
		JLabel lblnumPag = new JLabel("Numero di pagine");
		lblnumPag.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblnumPag = new GridBagConstraints();
		gbc_lblnumPag.anchor = GridBagConstraints.WEST;
		gbc_lblnumPag.insets = new Insets(0, 0, 5, 5);
		gbc_lblnumPag.gridx = 0;
		gbc_lblnumPag.gridy = 2;
		formPanel.add(lblnumPag, gbc_lblnumPag);
		
		JLabel lblmateria = new JLabel("Materia");
		lblmateria.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblmateria = new GridBagConstraints();
		gbc_lblmateria.anchor = GridBagConstraints.WEST;
		gbc_lblmateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblmateria.gridx = 0;
		gbc_lblmateria.gridy = 3;
		formPanel.add(lblmateria, gbc_lblmateria);
		
		JLabel lblcitta = new JLabel("Citt\u00E0");
		lblcitta.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcitta = new GridBagConstraints();
		gbc_lblcitta.anchor = GridBagConstraints.WEST;
		gbc_lblcitta.insets = new Insets(0, 0, 5, 5);
		gbc_lblcitta.gridx = 0;
		gbc_lblcitta.gridy = 4;
		formPanel.add(lblcitta, gbc_lblcitta);
		
		JLabel lblcopisteria = new JLabel("Copisteria");
		lblcopisteria.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcopisteria = new GridBagConstraints();
		gbc_lblcopisteria.anchor = GridBagConstraints.WEST;
		gbc_lblcopisteria.gridheight = 2;
		gbc_lblcopisteria.insets = new Insets(0, 0, 0, 5);
		gbc_lblcopisteria.gridx = 0;
		gbc_lblcopisteria.gridy = 5;
		formPanel.add(lblcopisteria, gbc_lblcopisteria);
		
		JPanel btnRichiesta = new JPanel();
		btnRichiesta.setBounds(154, 479, 130, 36);
		panel.add(btnRichiesta);
		btnRichiesta.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnRichiesta.setBackground(new Color(46, 93, 140));
		
		JLabel label_6 = new JLabel("Invia Richiesta");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRichiesta.add(label_6);
	}

}
