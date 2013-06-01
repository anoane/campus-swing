package gui.riquadri;

import gui.Home;
import gui.buttons.ModificaButton;
import gui.buttons.RimuoviButton;
import gui.buttons.RimuoviPrefButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Documento;
import controller.ControllerUtente;
import controller.ControllerVoto;

public class RiquadroDoc extends Riquadro {

	private JPanel anteprima;
	private JPanel tipo;
	private JPanel pulsanti;
	private JPanel stelle;
	private JLabel titolo;
	private JTextArea descrizione;
	private JLabel facolta;
	private JTextArea univ;
	private JLabel corso;
	private JPanel utente;
	private JLabel proprietario_cognome;
	private JLabel proprietario_nome;
	private RimuoviButton rimuovi;
	private JLabel lbltipo;
	private JLabel img_anteprima = new JLabel();
	private JPanel colore = new JPanel();
	
	private static Color colore_stella = new Color(255,222,87);
	private JLabel imgUtente;

	public RiquadroDoc(final Documento doc, boolean documentoFalse_preferitoTrue, boolean soloVisualizzazione) {
		super();
		final Color exitedColor = super.getPreferitoBgColor();
		final Color enteredColor =super.getPreferitoOverBgColor();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());	
		// Riquadro Anteprima
		anteprima = new JPanel();
		anteprima.setBounds(15, 45, 100, 141);
		anteprima.setBackground(Color.WHITE);
		anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// Event listener
		
		MouseAdapter comportamento = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true,doc,false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(enteredColor);
				stelle.removeAll();
				for(int i=0; i<5; ++i){
					//Label contenente la singola stella
					JLabel stella = new JLabel();
					stella.setAlignmentY(Component.TOP_ALIGNMENT);
					stella.setBounds(i*20, 0, 20, 20);
					stella.setIcon(new ImageIcon("./newimage/star_med_light.png"));
					stelle.add(stella);
					
				}
				stelle.add(colore);
				stelle.setLocation(125, 45);
				stelle.setSize(100, 20);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				univ.setBackground(enteredColor);
				descrizione.setBackground(enteredColor);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(exitedColor);
				stelle.removeAll();
				for(int i=0; i<5; ++i){
					//Label contenente la singola stella
					JLabel stella = new JLabel();
					stella.setAlignmentY(Component.TOP_ALIGNMENT);
					stella.setBounds(i*20, 0, 20, 20);
					stella.setIcon(new ImageIcon("./newimage/star_med.png"));
					stelle.add(stella);
				}
				stelle.add(colore);
				stelle.setLocation(125, 45);
				stelle.setSize(100, 20);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				univ.setBackground(exitedColor);
				descrizione.setBackground(exitedColor);
				
			}
		};
		
		MouseAdapter comportamento2 = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(enteredColor);
				stelle.removeAll();
				for(int i=0; i<5; ++i){
					//Label contenente la singola stella
					JLabel stella = new JLabel();
					stella.setAlignmentY(Component.TOP_ALIGNMENT);
					stella.setBounds(i*20, 0, 20, 20);
					stella.setIcon(new ImageIcon("./newimage/star_med_light.png"));
					stelle.add(stella);
					
				}
				stelle.add(colore);
				stelle.setLocation(125, 45);
				stelle.setSize(100, 20);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				univ.setBackground(enteredColor);
				descrizione.setBackground(enteredColor);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(exitedColor);
				stelle.removeAll();
				for(int i=0; i<5; ++i){
					//Label contenente la singola stella
					JLabel stella = new JLabel();
					stella.setAlignmentY(Component.TOP_ALIGNMENT);
					stella.setBounds(i*20, 0, 20, 20);
					stella.setIcon(new ImageIcon("./newimage/star_med.png"));
					stelle.add(stella);
				}
				stelle.add(colore);
				stelle.setLocation(125, 45);
				stelle.setSize(100, 20);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				univ.setBackground(exitedColor);
				descrizione.setBackground(exitedColor);
				
			}
		};
		
		this.addMouseListener(comportamento);

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
		facolta.setBounds(125, 169, 143, 20);

		// Label università

		univ = new JTextArea();
		DefaultCaret caret = (DefaultCaret) univ.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		univ.setText(doc.getFacolta().getUniversita().getNome());
		univ.setFont(new Font("Arial", Font.PLAIN, 12));
		univ.setLineWrap(true);
		univ.setBorder(new EmptyBorder(0,0,0,0));
		univ.setWrapStyleWord(true);
		univ.setHighlighter(null);
		univ.setEditable(false);
		univ.setBounds(125, 135, 143, 40);
		univ.setText(util.StringUtility.truncateLines(univ,2));
		univ.addMouseListener(comportamento);


		
		// Pannello Rimuovi
		pulsanti = new JPanel();
		pulsanti.setBackground(null);
		pulsanti.setSize(128, 52);
		pulsanti.setLocation(302, 13);
		pulsanti.setLayout(null);
		RimuoviButton r = new RimuoviButton("Rimuovi il documento");
		r.setLocation(75, 0);
		RimuoviPrefButton rp = new RimuoviPrefButton("Rimuovi il documento dai preferiti");
		r.setLocation(75, 0);
		rp.setLocation(75, 0);
		//r.setSize(19,26);
		ModificaButton m = new ModificaButton("Modifica il documento");
		m.setLocation(15, 0);
		//m.setSize(19,26);
		pulsanti.add(m);
		pulsanti.add(r);
		pulsanti.add(rp);
		
		m.addMouseListener(comportamento2);

		r.addMouseListener(comportamento2);

		rp.addMouseListener(comportamento2);

		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(10, 5, 298, 40);
		titolo.setFont(new Font("Arial", Font.BOLD, 25));
		titolo.setForeground(Color.WHITE);
		
		// TextArea descrizione

		descrizione = new JTextArea();
		DefaultCaret caret2 = (DefaultCaret) descrizione.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		descrizione.setText(doc.getDescrizione());
		descrizione.setCaretPosition(0);
		descrizione.setFont(new Font("Arial", Font.PLAIN, 12));
		descrizione.setEditable(false);
		descrizione.setLocation(125, 68);
		descrizione.setSize(305, 47);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setText(util.StringUtility.truncateLines(descrizione,3));
		descrizione.addMouseListener(comportamento);

		univ.setBackground(exitedColor);
		descrizione.setBackground(exitedColor);
		
		// Label corso
		corso = new JLabel(doc.getCorso().getNome());
		corso.setFont(new Font("Arial", Font.PLAIN, 12));
		corso.setHorizontalAlignment(SwingConstants.LEFT);
		corso.setLocation(125, 115);
		corso.setSize(305, 20);
		
		// Panel stelle
		stelle = new JPanel();
		// Panel contenente il colore di riempimento delle stelle
		stelle.setLayout(null);
		
		for(int i=0; i<5; ++i){
			//Label contenente la singola stella
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i*20, 0, 20, 20);
			stella.setIcon(new ImageIcon("./newimage/star_med.png"));
			stelle.add(stella);
		}
		stelle.add(colore);
		stelle.setLocation(125, 45);
		stelle.setSize(100, 20);
		colore.setBackground(colore_stella);
		colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
		
		
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
		
		//Label contenente l'estenzione del documento
		lbltipo = new JLabel();
		lbltipo.setBounds(70, 160, 43, 23);
		
		if(doc.getPath() != null && !doc.getPath().equals("/")){
			String strTipo = doc.getPath().split("\\.")[1];
			switch(strTipo){
			case "pdf":
				lbltipo.setIcon(new ImageIcon("./newimage/pdf.png"));
				break;
			case "ppt":
				lbltipo.setIcon(new ImageIcon("./newimage/ppt.png"));
				break;
			case "doc":
				lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
				break;
			default:
				lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
				break;
			}
		}
		else
			lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
		
		
		add(titolo);
		add(corso);
		add(facolta);
		add(univ);
		add(descrizione);
		add(pulsanti);
		add(stelle);
		add(utente);
		utente.setLayout(null);
		
		imgUtente = new JLabel("");
		imgUtente.setBounds(0, 0, 50, 50);
		
		if (doc != null) {
			Image resized = new ImageIcon("."+doc.getProprietario().getImmagine()).getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);  
			imgUtente.setIcon(new ImageIcon(resized));
		}
		
		utente.add(imgUtente);
		add(proprietario_cognome);
		add(tipo);
		add(lbltipo);
		add(anteprima);
		//anteprima.setLayout(null);
		add(proprietario_nome);
		anteprima.setLayout(null);
		img_anteprima.setBounds(0, 0, 100, 141);
		img_anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		
		anteprima.add(img_anteprima);
		
		if(!doc.getPath().equals("/"))
			img_anteprima.setIcon(new ImageIcon("./thumb/"+(doc.getPath().substring(6))+".png"));

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
				rp.setVisible(true);
				r.setVisible(false);
			} else {
				if (doc.getProprietario().getID() == Home.getUtenteLoggato().getID()) {
					pulsanti.setVisible(true);
					r.setVisible(true);
					rp.setVisible(false);
				}
			}
		}
	}
	
	public RimuoviButton getRimuovi(){
		return (RimuoviButton) this.pulsanti.getComponent(1);
	}
	
	public RimuoviPrefButton getRimuoviPref(){
		return (RimuoviPrefButton) this.pulsanti.getComponent(2);
	}
}
