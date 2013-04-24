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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;

public class RiquadroPref extends Riquadro {

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
	private RimuoviButton rimuovi;

	private static Color colore_stella = new Color(255,222,87);

	public RiquadroPref(final Documento doc) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());	
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
				Home.openDocument(true,doc);
			}
		});

		// JPanel tipo
		tipo = new JPanel();
		tipo.setBounds(10, 30, 58, 20);
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
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Dispense":
			lblNewLabel.setText("Dispense");
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Esercizi":
			lblNewLabel.setText("Esercizi");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		case "Slide":
			lblNewLabel.setText("Slide");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 30, 58, 24);
			break;
		default:
			lblNewLabel.setText("Documento");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x00, 0x00));
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

		// Pannello Rimuovi
		pulsanti = new JPanel();
		pulsanti.setBackground(null);
		pulsanti.setSize(128, 52);
		pulsanti.setLocation(308, 5);
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
		stelle.setLocation(154, 45);
		stelle.setSize(150, 30);
		colore.setBackground(colore_stella);
		colore.setSize((int) (stelle.getWidth()*calcolaVoto(doc.getNum_voti(), doc.getVoto())), 30);
		
		
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
		add(pulsanti);
		add(stelle);
		add(utente);
		add(proprietario);
		add(tipo);
		add(anteprima);
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
