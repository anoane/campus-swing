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
import javax.swing.JSeparator;

public class RiquadroDoc extends Riquadro {

	private JPanel anteprima;
	private JPanel tipo;
	private JPanel pulsanti;
	private JPanel stelle;
	private JLabel titolo;
	private JTextArea descrizione;
	private JLabel facolta;
	private JLabel univ;
	private JLabel corso;
	private JPanel utente;
	private JLabel proprietario_cognome;
	private JLabel proprietario_nome;
	private RimuoviButton rimuovi;

	private static Color colore_stella = new Color(255,222,87);

	public RiquadroDoc(final Documento doc, boolean documentoFalse_preferitoTrue, boolean soloVisualizzazione) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());	
		// Riquadro Anteprima
		anteprima = new JPanel();
		anteprima.setBounds(20, 45, 100, 141);
		anteprima.setBackground(Color.WHITE);
		anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		anteprima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// Event listener
		anteprima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true,doc);
			}
		});

		// JPanel tipo
		tipo = new JPanel();
		tipo.setBounds(10, 56, 58, 20);
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
		// Label facolta
		//facolta = new JLabel(doc.getProprietario().getFacolta().getNome());
		facolta = new JLabel(doc.getFacolta().getNome());
		facolta.setFont(new Font("Arial", Font.PLAIN, 12));
		facolta.setHorizontalAlignment(SwingConstants.LEFT);
		facolta.setBounds(130, 169, 138, 20);

		// Label università
		//univ = new JLabel(doc.getProprietario().getFacolta().getUniversita()
		//		.getNome());
		univ = new JLabel(doc.getFacolta().getUniversita().getNome());
		univ.setFont(new Font("Arial", Font.PLAIN, 12));
		univ.setHorizontalAlignment(SwingConstants.LEFT);
		univ.setBounds(130, 135, 138, 40);

		// Pannello Rimuovi
		pulsanti = new JPanel();
		pulsanti.setBackground(null);
		pulsanti.setSize(128, 52);
		pulsanti.setLocation(302, 13);
		pulsanti.setLayout(null);
		RimuoviButton r = new RimuoviButton("Rimuovi il documento dai Preferiti");
		r.setLocation(75, 0);
		//r.setSize(19,26);
		ModificaButton m = new ModificaButton();
		m.setLocation(15, 0);
		//m.setSize(19,26);
		pulsanti.add(m);
		pulsanti.add(r);
		
		
		
		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(10, 5, 298, 40);
		titolo.setFont(new Font("Arial", Font.BOLD, 25));
		titolo.setForeground(Color.WHITE);
		
		// TextArea descrizione
		descrizione = new JTextArea(doc.getDescrizione());
		if (doc.getDescrizione().length() > 125) {
			descrizione = new JTextArea(doc.getDescrizione().substring(0, 124).concat("..."));
		}
		descrizione.setFont(new Font("Arial", Font.PLAIN, 12));
		descrizione.setEditable(false);
		descrizione.setLocation(130, 66);
		descrizione.setSize(300, 52);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setBackground(super.getPreferitoBgColor());

		// Label corso
		corso = new JLabel(doc.getCorso().getNome());
		corso.setFont(new Font("Arial", Font.PLAIN, 12));
		corso.setHorizontalAlignment(SwingConstants.LEFT);
		corso.setLocation(130, 115);
		corso.setSize(300, 20);
		
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
		stelle.setLocation(130, 45);
		stelle.setSize(150, 20);
		colore.setBackground(colore_stella);
		colore.setSize((int) (stelle.getWidth()*calcolaVoto(doc.getNum_voti(), doc.getVoto())), 30);
		
		
		// Panel utente
		utente = new JPanel();
		utente.setLocation(284, 140);
		utente.setSize(50, 50);

		// Label proprietario
		proprietario_cognome = new JLabel(doc.getProprietario().getCognome());
		proprietario_cognome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_cognome.setLocation(340, 175);
		proprietario_cognome.setSize(90, 20);
		
		proprietario_nome = new JLabel(doc.getProprietario().getNome());
		proprietario_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_nome.setLocation(340, 160);
		proprietario_nome.setSize(90, 20);
		
		add(titolo);
		add(corso);
		add(facolta);
		add(univ);
		add(descrizione);
		add(pulsanti);
		add(stelle);
		add(utente);
		add(proprietario_cognome);
		add(tipo);
		add(anteprima);
		add(proprietario_nome);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(274, 140, 1, 58);
		separator.setBackground(new Color(0x1B, 0x32, 0x80));
		separator.setForeground(new Color(0x1B, 0x32, 0x80));
		add(separator);
				
		pulsanti.setVisible(false);
		if (!soloVisualizzazione) {
			if (documentoFalse_preferitoTrue) {
				pulsanti.setVisible(true);
				m.setVisible(false);
			} else {
				if (doc.getProprietario().getID() == ControllerUtente.getInstance().getUtente(1).getID()) {
					pulsanti.setVisible(true);
				}
			}
		}
	}
	
	public RimuoviButton getRimuovi(){
		return (RimuoviButton) this.pulsanti.getComponent(1);
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
