package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviButton;

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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;
import controller.ControllerVoto;

public class RiquadroDocSmall extends RiquadroSmall {
	private JPanel tipo;
	private JPanel stelle;
	private JLabel titolo;
	private JPanel utente;
	private JLabel proprietario_cognome;
	private JLabel proprietario_nome;
	private RimuoviButton rimuovi;

	private static Color colore_stella = new Color(255,222,87);
	private JPanel ext;
	private JLabel label;
	private JLabel lbltipo;
	private JLabel imgUtente;
	private JPanel colore = new JPanel();
	private JTextArea corso = new JTextArea();
	

	public RiquadroDocSmall(final Documento doc, boolean documentoFalse_preferitoTrue, boolean soloVisualizzazione) {
		super();
		
		final Color exitedColor = super.getPreferitoBgColor();
		final Color enteredColor =super.getPreferitoOverBgColor();
		
		this.setBackground(super.getPreferitoBgColor());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(super.getRiquadroBorder());
		
		
		
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
					stella.setBounds(i*15, 0, 15, 15);
					stella.setIcon(new ImageIcon("./newimage/star_small_light.png"));
					stelle.add(stella);
				}
				stelle.add(colore);
				stelle.setLocation(166, 37);
				stelle.setSize(75, 15);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				corso.setBackground(enteredColor);

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(exitedColor);
				stelle.removeAll();
				for(int i=0; i<5; ++i){
					//Label contenente la singola stella
					JLabel stella = new JLabel();
					stella.setAlignmentY(Component.TOP_ALIGNMENT);
					stella.setBounds(i*15, 0, 15, 15);
					stella.setIcon(new ImageIcon("./newimage/star_small.png"));
					stelle.add(stella);
				}
				stelle.add(colore);
				stelle.setLocation(166, 37);
				stelle.setSize(75, 15);
				colore.setBackground(colore_stella);
				colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
				corso.setBackground(exitedColor);
				
			}
		};
		
		
		
		
		this.addMouseListener(comportamento);
		// JPanel tipo
		tipo = new JPanel();
		tipo.setBounds(10, 68, 58, 20);
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
			lblNewLabel.getParent().setBounds(10, 68, 58, 20);
			break;
		case "Dispense":
			lblNewLabel.setText("Dispense");
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			lblNewLabel.getParent().setBounds(10, 68, 58, 20);
			break;
		case "Esercizi":
			lblNewLabel.setText("Esercizi");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			lblNewLabel.getParent().setBounds(10, 68, 58, 20);
			break;
		case "Slide":
			lblNewLabel.setText("Slide");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 68, 58, 20);
			break;
		default:
			lblNewLabel.setText("Documento");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x00, 0x00));
			lblNewLabel.getParent().setBounds(10, 68, 58, 20);
			break;
		}
		
		
		
		// Label title
		titolo = new JLabel(doc.getNome());
		titolo.setBounds(10, 5, 290, 30);
		titolo.setFont(new Font("Arial", Font.BOLD, 20));
		titolo.setForeground(Color.WHITE);

		// Label corso
		corso.setText(doc.getCorso().getNome());
		corso.setFont(new Font("Arial", Font.PLAIN, 12));
		corso.setLineWrap(true);
		corso.setBorder(new EmptyBorder(0,0,0,0));
		corso.setWrapStyleWord(true);
		corso.setHighlighter(null);
		corso.setEditable(false);
		corso.setBackground(exitedColor);
		corso.setLocation(10, 35);
		corso.setSize(146, 30);
		corso.setText(util.StringUtility.truncateLines(corso,2));
		corso.addMouseListener(comportamento);
		
		// Panel stelle
		stelle = new JPanel();
		// Panel contenente il colore di riempimento delle stelle
		stelle.setLayout(null);
		
		for(int i=0; i<5; ++i){
			//Label contenente la singola stella
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i*15, 0, 15, 15);
			stella.setIcon(new ImageIcon("./newimage/star_small.png"));
			stelle.add(stella);
		}
		stelle.add(colore);
		stelle.setLocation(166, 37);
		stelle.setSize(75, 15);
		colore.setBackground(colore_stella);
		colore.setSize((int) (stelle.getWidth()*ControllerVoto.getInstance().calcolaVoto(doc)), 30);
		
		
		// Panel utente
		utente = new JPanel();
		utente.setLocation(166, 58);
		utente.setSize(30, 30);

		// Label proprietario
		proprietario_cognome = new JLabel(doc.getProprietario().getCognome());
		proprietario_cognome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_cognome.setLocation(200, 72);
		proprietario_cognome.setSize(100, 20);
		
		proprietario_nome = new JLabel(doc.getProprietario().getNome());
		proprietario_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		proprietario_nome.setLocation(200, 56);
		proprietario_nome.setSize(100, 20);
		
		lbltipo = new JLabel();
		lbltipo.setBounds(98, 68, 40, 20);
		

		if(doc.getPath() != null && !doc.getPath().equals("/")){
			String strTipo = doc.getPath().split("\\.")[1];
			switch(strTipo){
			case "pdf":
				lbltipo.setIcon(new ImageIcon("./newimage/pdf-small.png"));
				break;
			case "ppt":
				lbltipo.setIcon(new ImageIcon("./newimage/ppt-small.png"));
				break;
			case "doc":
				lbltipo.setIcon(new ImageIcon("./newimage/doc-small.png"));
				break;
			default:
				lbltipo.setIcon(new ImageIcon("./newimage/doc-small.png"));
				break;
			}
		}
		else{
			lbltipo.setIcon(new ImageIcon("./newimage/doc-small.png"));
		}
		add(titolo);
		add(corso);
		add(stelle);
		add(utente);
		utente.setLayout(null);
		
		imgUtente = new JLabel("");
		imgUtente.setBounds(0, 0, 30, 30);
		
		if (doc != null) {
			Image resized = new ImageIcon("."+doc.getProprietario().getImmagine()).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
			imgUtente.setIcon(new ImageIcon(resized));
		}
		
		utente.add(imgUtente);
		add(proprietario_cognome);
		add(tipo);
		add(proprietario_nome);
		add(lbltipo);
		
		ext = new JPanel();
		ext.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		ext.setBounds(78, 35, 58, 20);
		//add(ext);
		ext.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		label = new JLabel();
		label.setAlignmentY(1.0f);
		label.setAlignmentX(0.5f);
		//ext.add(label);

	}
	
	
}
