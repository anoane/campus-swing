package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class PrenotaLibro extends JPanel {
	private JTextField textField_autore;
	private JTextField textField_titolo;
	private JTextField textField_casaEd;
	private JTextField textField_ISBN;
	private JTextField textField_;
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
		formPanel.setBounds(22, 68, 399, 321);
		formPanel.setBorder(new EmptyBorder(10,10,10,10));
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{189, 189, 0};
		gbl_formPanel.rowHeights = new int[]{60, 60, 60, 60, 60, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lbltitolo = new JLabel("Titolo");
		lbltitolo.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltitolo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbltitolo = new GridBagConstraints();
		gbc_lbltitolo.fill = GridBagConstraints.BOTH;
		gbc_lbltitolo.insets = new Insets(0, 0, 5, 5);
		gbc_lbltitolo.gridx = 0;
		gbc_lbltitolo.gridy = 0;
		formPanel.add(lbltitolo, gbc_lbltitolo);
		
		textField_titolo = new JTextField();
		textField_titolo.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_titolo.setMargin(new Insets(10, 2, 2, 2));
		GridBagConstraints gbc_textField_titolo = new GridBagConstraints();
		gbc_textField_titolo.fill = GridBagConstraints.BOTH;
		gbc_textField_titolo.insets = new Insets(0, 0, 5, 0);
		gbc_textField_titolo.gridx = 1;
		gbc_textField_titolo.gridy = 0;
		formPanel.add(textField_titolo, gbc_textField_titolo);
		textField_titolo.setColumns(15);
		
		JLabel lblAutore = new JLabel("Autore");
		lblAutore.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAutore.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAutore = new GridBagConstraints();
		gbc_lblAutore.fill = GridBagConstraints.BOTH;
		gbc_lblAutore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutore.gridx = 0;
		gbc_lblAutore.gridy = 1;
		formPanel.add(lblAutore, gbc_lblAutore);
		
		textField_autore = new JTextField();
		textField_autore.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_autore.setMargin(new Insets(10, 2, 2, 2));
		GridBagConstraints gbc_textField_autore = new GridBagConstraints();
		gbc_textField_autore.fill = GridBagConstraints.BOTH;
		gbc_textField_autore.insets = new Insets(0, 0, 5, 0);
		gbc_textField_autore.gridx = 1;
		gbc_textField_autore.gridy = 1;
		formPanel.add(textField_autore, gbc_textField_autore);
		textField_autore.setColumns(15);
		
		JLabel lblCasaed = new JLabel("Casa editrice");
		lblCasaed.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCasaed.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCasaed = new GridBagConstraints();
		gbc_lblCasaed.fill = GridBagConstraints.BOTH;
		gbc_lblCasaed.insets = new Insets(0, 0, 5, 5);
		gbc_lblCasaed.gridx = 0;
		gbc_lblCasaed.gridy = 2;
		formPanel.add(lblCasaed, gbc_lblCasaed);
		
		textField_casaEd = new JTextField();
		textField_casaEd.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_casaEd.setMargin(new Insets(10, 2, 2, 2));
		GridBagConstraints gbc_textField_casaEd = new GridBagConstraints();
		gbc_textField_casaEd.fill = GridBagConstraints.BOTH;
		gbc_textField_casaEd.insets = new Insets(0, 0, 5, 0);
		gbc_textField_casaEd.gridx = 1;
		gbc_textField_casaEd.gridy = 2;
		formPanel.add(textField_casaEd, gbc_textField_casaEd);
		textField_casaEd.setColumns(15);
		
		JLabel lblCodISBN = new JLabel("Codice ISBN");
		lblCodISBN.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodISBN.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCodISBN = new GridBagConstraints();
		gbc_lblCodISBN.fill = GridBagConstraints.BOTH;
		gbc_lblCodISBN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodISBN.gridx = 0;
		gbc_lblCodISBN.gridy = 3;
		formPanel.add(lblCodISBN, gbc_lblCodISBN);
		
		textField_ISBN = new JTextField();
		textField_ISBN.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_ISBN.setMargin(new Insets(10, 2, 2, 2));
		GridBagConstraints gbc_textField_ISBN = new GridBagConstraints();
		gbc_textField_ISBN.fill = GridBagConstraints.BOTH;
		gbc_textField_ISBN.insets = new Insets(0, 0, 5, 0);
		gbc_textField_ISBN.gridx = 1;
		gbc_textField_ISBN.gridy = 3;
		formPanel.add(textField_ISBN, gbc_textField_ISBN);
		textField_ISBN.setColumns(15);
		
		JLabel lblCitta = new JLabel("Citt\u00E0");
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCitta.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.fill = GridBagConstraints.BOTH;
		gbc_lblCitta.insets = new Insets(0, 0, 0, 5);
		gbc_lblCitta.gridx = 0;
		gbc_lblCitta.gridy = 4;
		formPanel.add(lblCitta, gbc_lblCitta);
		
		textField_ = new JTextField();
		textField_.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_.setMargin(new Insets(10, 2, 2, 2));
		GridBagConstraints gbc_textField_ = new GridBagConstraints();
		gbc_textField_.fill = GridBagConstraints.BOTH;
		gbc_textField_.gridx = 1;
		gbc_textField_.gridy = 4;
		formPanel.add(textField_, gbc_textField_);
		textField_.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		panel_1.setBackground(new Color(46, 93, 140));
		panel_1.setBounds(153, 423, 157, 34);
		panel.add(panel_1);
		
		JLabel lblInvRic = new JLabel("Invia Richiesta");
		lblInvRic.setForeground(Color.WHITE);
		lblInvRic.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_1.add(lblInvRic);
	}
}
