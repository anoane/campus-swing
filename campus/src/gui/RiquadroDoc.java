package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;

public class RiquadroDoc extends JPanel {

	private JPanel anteprima;
	private JPanel tipo;
	private JPanel pulsanti;
	private JPanel stelle;
	private JLabel titolo;
	private JLabel descrizione;
	private JLabel facolta;
	private JLabel univ;
	private JLabel corso;
	private JPanel utente;
	private JLabel proprietario;

	private static Color preferitoBgColor = new Color(67, 136, 204);

	public RiquadroDoc(Documento doc) {
		super();
		this.setSize(400, 200);
		this.setBackground(preferitoBgColor);
		this.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		setLayout(null);

		// Riquadro Anteprima
		anteprima = new JPanel();
		anteprima.setBounds(20, 16, 116, 170);
		anteprima.setBackground(Color.WHITE);
		anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		anteprima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// Event listener
		anteprima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true);
			}
		});

		// JPanel tipo
		tipo = new JPanel();
		tipo.setBounds(10, 30, 58, 24);
		tipo.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		tipo.setLayout(new BorderLayout(0, 0));

		// Label Tipo
		// TODO: Modificare l'etichetta del documento
		JLabel lblNewLabel = new JLabel(
				doc.getClass().getName().split("\\.")[1]);

		tipo.add(lblNewLabel,BorderLayout.CENTER);
		switch (doc.getClass().getName().split("\\.")[1]) {
		case "Appunti":
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Dispense":
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Esercizi":
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Slide":
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		}
		// Label facolta
		facolta = new JLabel(doc.getProprietario().getFacolta().getNome());
		facolta.setHorizontalAlignment(SwingConstants.LEFT);
		facolta.setBounds(265, 153, 130, 20);

		// Label università
		univ = new JLabel(doc.getProprietario().getFacolta().getUniversita()
				.getNome());
		univ.setHorizontalAlignment(SwingConstants.LEFT);
		univ.setBounds(265, 175, 130, 20);

		// Pannello pulsanti
		pulsanti = new JPanel();
		pulsanti.setLocation(275, 5);
		pulsanti.setSize(120, 30);
		pulsanti.setBackground(Color.WHITE);

		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(145, 5, 120, 40);
		titolo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		titolo.setForeground(Color.WHITE);
		
		// Label descrizione
		descrizione = new JLabel(doc.getDescrizione());
		descrizione.setLocation(145, 80);
		descrizione.setSize(245, 41);

		// Label corso
		corso = new JLabel(doc.getCorso().getNome());
		corso.setHorizontalAlignment(SwingConstants.LEFT);
		corso.setLocation(265, 132);
		corso.setSize(130, 20);
		
		// Panel stelle
		stelle = new JPanel();
		stelle.setLocation(145, 45);
		stelle.setSize(120, 30);
		
		// Panel utente
		utente = new JPanel();
		utente.setLocation(145, 123);
		utente.setSize(50, 50);

		// Label proprietario
		proprietario = new JLabel(doc.getProprietario().getNome());
		proprietario.setLocation(145, 175);
		proprietario.setSize(100, 20);
		
		add(titolo);
		add(corso);
		add(facolta);
		add(univ);
		add(descrizione);
		add(pulsanti);
		add(stelle);
		add(utente);
		add(proprietario);
		add(tipo);
		add(anteprima);
	}
}
