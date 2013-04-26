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
		
		JLabel lblNewLabel = new JLabel("Descrizione");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		formPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		formPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		formPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
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
		GridBagConstraints gbc_textarea = new GridBagConstraints();
		gbc_textarea.insets = new Insets(0, 0, 5, 0);
		gbc_textarea.fill = GridBagConstraints.HORIZONTAL;
		gbc_textarea.gridx = 1;
		gbc_textarea.gridy = 1;
		formPanel.add(txtAreaDescrizione, gbc_textarea);
		textField.setColumns(10);
	}
}
