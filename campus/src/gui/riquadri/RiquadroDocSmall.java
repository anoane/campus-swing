package gui.riquadri;

import gui.Home;
import gui.buttons.ModificaButton;
import gui.buttons.RimuoviButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ControllerUtente;

import modello_di_dominio.Documento;

public class RiquadroDocSmall extends Riquadro {
	private JPanel tipo;
	private JPanel stelle;
	private JLabel titolo;
	private JLabel corso;
	private JPanel utente;
	private JLabel proprietario_cognome;
	private JLabel proprietario_nome;
	private RimuoviButton rimuovi;

	private static Color colore_stella = new Color(255,222,87);

	public RiquadroDocSmall(final Documento doc, boolean documentoFalse_preferitoTrue, boolean soloVisualizzazione) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());

		// JPanel tipo
		tipo = new JPanel();
		tipo.setBounds(10, 35, 58, 20);
		tipo.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		tipo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// Label Tipo
		// TODO: Modificare l'etichetta del documento
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tipo.add(lblNewLabel,BorderLayout.CENTER);
		switch (doc.getDiscriminator()) {
		case "Appunti":
			lblNewLabel.setText("Appunti");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Dispense":
			lblNewLabel.setText("Dispense");
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Esercizi":
			lblNewLabel.setText("Esercizi");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Slide":
			lblNewLabel.setText("Slide");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		default:
			lblNewLabel.setText("Documento");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		}
		
		
		
		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(10, 5, 290, 30);
		titolo.setFont(new Font("Arial", Font.BOLD, 20));
		titolo.setForeground(Color.WHITE);

		// Label corso
		corso = new JLabel(doc.getCorso().getNome());
		corso.setFont(new Font("Arial", Font.PLAIN, 12));
		corso.setHorizontalAlignment(SwingConstants.LEFT);
		corso.setLocation(10, 66);
		corso.setSize(138, 20);
		
		// Panel stelle
		stelle = new JPanel();
		// Panel contenente il colore di riempimento delle stelle
		JPanel colore = new JPanel();
		stelle.setLayout(null);
		
		for(int i=0; i<5; ++i){
			//Label contenente la singola stella
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i*30, 0, 30, 30);
			stella.setIcon(new ImageIcon("./newimage/star.png"));
			stelle.add(stella);
		}
		stelle.add(colore);
		stelle.setLocation(162, 35);
		stelle.setSize(138, 20);
		colore.setBackground(colore_stella);
		colore.setSize((int) (stelle.getWidth()*calcolaVoto(doc.getNum_voti(), doc.getVoto())), 30);
		
		
		// Panel utente
		utente = new JPanel();
		utente.setLocation(162, 56);
		utente.setSize(30, 30);

		// Label proprietario
		proprietario_cognome = new JLabel(doc.getProprietario().getCognome());
		proprietario_cognome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_cognome.setLocation(200, 70);
		proprietario_cognome.setSize(100, 20);
		
		proprietario_nome = new JLabel(doc.getProprietario().getNome());
		proprietario_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_nome.setLocation(200, 54);
		proprietario_nome.setSize(100, 20);
		
		add(titolo);
		add(corso);
		add(stelle);
		add(utente);
		add(proprietario_cognome);
		add(tipo);
		add(proprietario_nome);

	}
	
	private float calcolaVoto(int num, int voto){
		if(voto == 0 && num == 0)
			return 0;
		else{
			float media = voto / num;
			return media/10;
		}
		
	}
}
