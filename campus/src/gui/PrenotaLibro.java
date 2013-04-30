package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PrenotaLibro extends JPanel {
	/**
	 * Serial ID 
	 */
	private static final long serialVersionUID = -3213821259248266494L;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public PrenotaLibro() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 800);
		add(panel);
		
		JLabel lblPrenotazioneLibri = new JLabel("Prenotazione Libri");
		lblPrenotazioneLibri.setForeground(new Color(6, 121, 159));
		lblPrenotazioneLibri.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrenotazioneLibri.setBounds(10, 10, 200, 25);
		panel.add(lblPrenotazioneLibri);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(34, 68, 363, 294);
		formPanel.setBorder(new EmptyBorder(10,10,10,10));
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{189, 189, 0, 0};
		gbl_formPanel.rowHeights = new int[]{60, 60, 60, 60, 60, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lbltitolo = new JLabel("Titolo");
		lbltitolo.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltitolo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbltitolo = new GridBagConstraints();
		gbc_lbltitolo.anchor = GridBagConstraints.WEST;
		gbc_lbltitolo.fill = GridBagConstraints.VERTICAL;
		gbc_lbltitolo.insets = new Insets(0, 0, 5, 5);
		gbc_lbltitolo.gridx = 0;
		gbc_lbltitolo.gridy = 0;
		formPanel.add(lbltitolo, gbc_lbltitolo);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		formPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblAutore = new JLabel("Autore");
		lblAutore.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAutore.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAutore = new GridBagConstraints();
		gbc_lblAutore.anchor = GridBagConstraints.WEST;
		gbc_lblAutore.fill = GridBagConstraints.VERTICAL;
		gbc_lblAutore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutore.gridx = 0;
		gbc_lblAutore.gridy = 1;
		formPanel.add(lblAutore, gbc_lblAutore);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		formPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCasaed = new JLabel("Casa editrice");
		lblCasaed.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCasaed.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCasaed = new GridBagConstraints();
		gbc_lblCasaed.anchor = GridBagConstraints.WEST;
		gbc_lblCasaed.fill = GridBagConstraints.VERTICAL;
		gbc_lblCasaed.insets = new Insets(0, 0, 5, 5);
		gbc_lblCasaed.gridx = 0;
		gbc_lblCasaed.gridy = 2;
		formPanel.add(lblCasaed, gbc_lblCasaed);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		formPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCodISBN = new JLabel("Codice ISBN");
		lblCodISBN.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodISBN.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCodISBN = new GridBagConstraints();
		gbc_lblCodISBN.anchor = GridBagConstraints.WEST;
		gbc_lblCodISBN.fill = GridBagConstraints.VERTICAL;
		gbc_lblCodISBN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodISBN.gridx = 0;
		gbc_lblCodISBN.gridy = 3;
		formPanel.add(lblCodISBN, gbc_lblCodISBN);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		formPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCitta = new JLabel("Citt\u00E0");
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCitta.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.anchor = GridBagConstraints.WEST;
		gbc_lblCitta.insets = new Insets(0, 0, 0, 5);
		gbc_lblCitta.fill = GridBagConstraints.VERTICAL;
		gbc_lblCitta.gridx = 0;
		gbc_lblCitta.gridy = 4;
		formPanel.add(lblCitta, gbc_lblCitta);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		formPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		panel_1.setBackground(new Color(46, 93, 140));
		panel_1.setBounds(129, 404, 157, 34);
		panel.add(panel_1);
		
		JLabel lblInvRic = new JLabel("Invia Richiesta");
		lblInvRic.setForeground(Color.WHITE);
		lblInvRic.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_1.add(lblInvRic);
	}
}
