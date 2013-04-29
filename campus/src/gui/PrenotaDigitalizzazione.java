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

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class PrenotaDigitalizzazione extends JPanel {
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
		
		JPanel btnRichiesta = new JPanel();
		btnRichiesta.setBounds(157, 519, 130, 36);
		panel.add(btnRichiesta);
		btnRichiesta.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnRichiesta.setBackground(new Color(46, 93, 140));
		
		JLabel label_6 = new JLabel("Invia Richiesta");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRichiesta.add(label_6);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(36, 76, 425, 432);
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] {189, 189};
		gbl_formPanel.rowHeights = new int[] {60, 120, 60, 60, 60, 60};
		gbl_formPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lblAsd = new JLabel("Nome documento");
		lblAsd.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAsd = new GridBagConstraints();
		gbc_lblAsd.anchor = GridBagConstraints.WEST;
		gbc_lblAsd.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsd.gridx = 0;
		gbc_lblAsd.gridy = 0;
		formPanel.add(lblAsd, gbc_lblAsd);
		
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
		
		JTextField nomeDoc = new JTextField();
		GridBagConstraints gbc_nomeDoc = new GridBagConstraints();
		gbc_nomeDoc.insets = new Insets(0, 0, 5, 0);
		gbc_nomeDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeDoc.gridx = 1;
		gbc_nomeDoc.gridy = 0;
		formPanel.add(nomeDoc, gbc_nomeDoc);
		nomeDoc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Materia");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		formPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		formPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		formPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JTextArea txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//txtAreaDescrizione.setText("Prova prova");
		GridBagConstraints gbc_textarea = new GridBagConstraints();
		gbc_textarea.insets = new Insets(0, 0, 5, 0);
		gbc_textarea.fill = GridBagConstraints.HORIZONTAL;
		gbc_textarea.gridx = 1;
		gbc_textarea.gridy = 1;
		formPanel.add(txtAreaDescrizione, gbc_textarea);
        txtAreaDescrizione.setColumns(20);
        txtAreaDescrizione.setLineWrap(true);
        txtAreaDescrizione.setRows(5);
        txtAreaDescrizione.setWrapStyleWord(true);
        
		JTextField numPag = new JTextField();
		GridBagConstraints gbc_numPag = new GridBagConstraints();
		gbc_numPag.insets = new Insets(0, 0, 5, 0);
		gbc_numPag.fill = GridBagConstraints.HORIZONTAL;
		gbc_numPag.gridx = 1;
		gbc_numPag.gridy = 2;
		formPanel.add(numPag, gbc_numPag);
		numPag.setColumns(3);
		
		
	}
}
