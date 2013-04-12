package gui;

import gui.buttons.RimuoviButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ControllerUtente;

import modello_di_dominio.Documento;

public class RiquadroDoc extends JPanel {

	private int id;
	private JPanel anteprima;
	private JPanel tipo;
	//private JPanel pulsanti;
	private JPanel stelle;
	private JLabel titolo;
	private JLabel descrizione;
	private JLabel facolta;
	private JLabel univ;
	private JLabel corso;
	private JPanel utente;
	private JLabel proprietario;
	private RimuoviButton rimuovi;

	private static Color preferitoBgColor = new Color(67, 136, 204);

	public RiquadroDoc(final Documento doc) {
		//this.id = doc.getID();
		//JPanel j = new JPanel();
		//super(440, 200);
		this.setSize(440, 200);
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
		tipo.setBounds(10, 30, 58, 20);
		tipo.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		tipo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// Label Tipo
		// TODO: Modificare l'etichetta del documento
		JLabel lblNewLabel = new JLabel(
				doc.getClass().getName().split("\\.")[1]);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
		facolta.setBounds(276, 153, 154, 20);

		// Label università
		univ = new JLabel(doc.getProprietario().getFacolta().getUniversita()
				.getNome());
		univ.setHorizontalAlignment(SwingConstants.LEFT);
		univ.setBounds(276, 175, 154, 20);

		// Pannello pulsanti
		rimuovi = new RimuoviButton();
		rimuovi.setLocation(384, 2);
		
		
		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(154, 5, 133, 40);
		titolo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		titolo.setForeground(Color.WHITE);
		
		// Label descrizione
		descrizione = new JLabel(doc.getDescrizione());
		descrizione.setLocation(154, 80);
		descrizione.setSize(245, 41);

		// Label corso
		corso = new JLabel(doc.getCorso().getNome());
		corso.setHorizontalAlignment(SwingConstants.LEFT);
		corso.setLocation(276, 132);
		corso.setSize(154, 20);
		
		// Panel stelle
		stelle = new JPanel();
		stelle.setLocation(154, 45);
		stelle.setSize(120, 30);
		
		// Panel utente
		utente = new JPanel();
		utente.setLocation(154, 118);
		utente.setSize(50, 50);

		// Label proprietario
		proprietario = new JLabel(doc.getProprietario().getNome());
		proprietario.setLocation(154, 175);
		proprietario.setSize(100, 20);
		
		add(titolo);
		add(corso);
		add(facolta);
		add(univ);
		add(descrizione);
		add(rimuovi);
		add(stelle);
		add(utente);
		add(proprietario);
		add(tipo);
		add(anteprima);
	}
}
