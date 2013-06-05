package gui;

import gui.helpers.JTextFieldLimit;
import gui.riquadri.RiquadroDoc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;

import controller.ControllerCorso;
import controller.ControllerDocumento;
import controller.ControllerUtente;
import controller.ControllerVoto;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Profilo extends Pagina {
	
	private JPanel panel;
	private JPanel paneldx;
	private JPanel panelsx;
	private JPanel doc;
	private int altezzaPagina=0;
	
	//Label Pagina
	private JLabel lblPage;
	
	private JPanel contenuto_pagina;
	private ButtonStandard buttonCreator = new ButtonStandard();
	//JButton seguiButton = buttonCreator.createButton("Aggiungi ai corsi seguiti", 740, 8, 230, 28, false, true);
	//JButton nonSeguiButton = buttonCreator.createButton("Rimuovi dai corsi seguiti", 740, 8, 230, 28, false, true);
	private JLabel lblNomeUtente = new JLabel();
	private JLabel imgUtente = new JLabel();
	
	private JLabel labelName = new JLabel();
	private ArrayList<String> univ = new ArrayList<String>();

	private JLabel lblEta = new JLabel();
	private JLabel lblUniv = new JLabel();
	private JLabel lblFac = new JLabel();
	private JLabel lblVoto = new JLabel();
	
	/**
	 * Create the panel.
	 */
	public Profilo(Utente utente) {
		
		//Absolute layout
		setLayout(null);
		
		//Panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 429);
		add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		labelName.setText("Profilo");
		//labelName.setText("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		
		//Label
		labelName.setForeground(new Color(6, 121, 159));
		labelName.setFont(new Font("Arial", Font.BOLD, 18));
		labelName.setBounds(10, 10, 723, 25);
		panel.add(labelName);
		
		//panel.add(seguiButton);
		//panel.add(nonSeguiButton);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 53, 988, 235);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(0x1B, 0x32, 0x80));
		separator_1.setBounds(660, 10, 1, 215);
		panel_1.add(separator_1);
		
		lblNomeUtente.setForeground(new Color(0x06, 0x79, 0x9F));
		lblNomeUtente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNomeUtente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeUtente.setBounds(0, 10, 650, 28);
		panel_1.add(lblNomeUtente);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 0;
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 1;
		
		
		
		JLabel lblProgramma = new JLabel("Ultime attivit\u00E0");
		lblProgramma.setForeground(new Color(0x06, 0x79, 0x9F));
		lblProgramma.setFont(new Font("Arial", Font.PLAIN, 18));
		lblProgramma.setAlignmentX(0.5f);
		lblProgramma.setBounds(671, 10, 289, 28);
		panel_1.add(lblProgramma);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(671, 38, 289, 1);
		panel_1.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(27, 50, 128));
		separator_4.setBounds(0, 38, 650, 1);
		panel_1.add(separator_4);
		

		doc = new JPanel();
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 300, 1008, 254);
		doc.setLayout(null);
		
		panel.add(doc);
		
		
		lblPage = new JLabel("Documenti caricati");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPage.setBounds(10, 10, 260, 25);
		doc.add(lblPage);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(27, 50, 128));
		separator_3.setBounds(0, 41, 1006, 1);
		doc.add(separator_3);
		
		contenuto_pagina = new JPanel();
		contenuto_pagina.setLayout(null);
		contenuto_pagina.setBackground(Color.WHITE);
		doc.add(contenuto_pagina);
	
		separator_2.setVisible(true);
		separator_4.setVisible(true);
		

		imgUtente.setBounds(10, 50, 175, 175);
		imgUtente.setBorder(new LineBorder(Color.black));
		panel_1.add(imgUtente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(195, 50, 455, 175);
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {182, 267, 0};
		gbl_panel_2.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblEt = new JLabel("Et\u00E0");
		lblEt.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblEt = new GridBagConstraints();
		gbc_lblEt.anchor = GridBagConstraints.WEST;
		gbc_lblEt.insets = new Insets(0, 0, 5, 5);
		gbc_lblEt.gridx = 0;
		gbc_lblEt.gridy = 0;
		panel_2.add(lblEt, gbc_lblEt);
		
		GridBagConstraints gbc_lblEta = new GridBagConstraints();
		lblEta.setFont(new Font("Arial", Font.PLAIN, 14));
		
		gbc_lblEta.anchor = GridBagConstraints.WEST;
		gbc_lblEta.insets = new Insets(0, 0, 5, 0);
		gbc_lblEta.gridx = 1;
		gbc_lblEta.gridy = 0;
		panel_2.add(lblEta, gbc_lblEta);
		
		JLabel lblNewLabel = new JLabel("Universit\u00E0");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_lblUniv = new GridBagConstraints();
		gbc_lblUniv.anchor = GridBagConstraints.WEST;
		gbc_lblUniv.insets = new Insets(0, 0, 5, 0);
		gbc_lblUniv.gridx = 1;
		gbc_lblUniv.gridy = 1;
		lblUniv.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblUniv, gbc_lblUniv);
		
		JLabel lblNewLabel_1 = new JLabel("Corso di studi");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		GridBagConstraints gbc_lblFac = new GridBagConstraints();
		gbc_lblFac.anchor = GridBagConstraints.WEST;
		gbc_lblFac.insets = new Insets(0, 0, 5, 0);
		gbc_lblFac.gridx = 1;
		gbc_lblFac.gridy = 2;
		lblFac.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblFac, gbc_lblFac);
		
		JLabel lblNewLabel_2 = new JLabel("Media voto esami");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblEsami = new JLabel("28.7/30");
		lblEsami.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEsami = new GridBagConstraints();
		gbc_lblEsami.anchor = GridBagConstraints.WEST;
		gbc_lblEsami.insets = new Insets(0, 0, 5, 0);
		gbc_lblEsami.gridx = 1;
		gbc_lblEsami.gridy = 3;
		panel_2.add(lblEsami, gbc_lblEsami);
		
		JLabel lblNewLabel_3 = new JLabel("Media voto documenti");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_lblVoto = new GridBagConstraints();
		gbc_lblVoto.anchor = GridBagConstraints.WEST;
		gbc_lblVoto.insets = new Insets(0, 0, 5, 0);
		gbc_lblVoto.gridx = 1;
		gbc_lblVoto.gridy = 4;
		lblVoto.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblVoto, gbc_lblVoto);
		
		JLabel lblNewLabel_4 = new JLabel("Punti");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblPunti = new JLabel("175");
		lblPunti.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPunti = new GridBagConstraints();
		gbc_lblPunti.anchor = GridBagConstraints.WEST;
		gbc_lblPunti.gridx = 1;
		gbc_lblPunti.gridy = 5;
		panel_2.add(lblPunti, gbc_lblPunti);
		
		JPanel recenti = new JPanel();
		recenti.setBackground(Color.WHITE);
		recenti.setBounds(671, 49, 289, 176);
		panel_1.add(recenti);
		recenti.setLayout(null);
		
		JLabel lblHaCaricato = new JLabel("Ha caricato");
		lblHaCaricato.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHaCaricato.setBounds(10, 11, 71, 14);
		recenti.add(lblHaCaricato);
		
		JLabel lblAppuntiDiFisica = new JLabel("Appunti di Fisica I");
		lblAppuntiDiFisica.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAppuntiDiFisica.setFont(new Font("Arial", Font.BOLD, 14));
		lblAppuntiDiFisica.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblAppuntiDiFisica.setBounds(91, 11, 159, 14);
		recenti.add(lblAppuntiDiFisica);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 36, 289, 1);
		separator_5.setForeground(Home.BLUE_BUTTON_PRESSED);
		separator_5.setBackground(Home.BLUE_BUTTON_PRESSED);
		recenti.add(separator_5);
		
		JLabel lblHaCommentato = new JLabel("Ha commentato");
		lblHaCommentato.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHaCommentato.setBounds(10, 48, 98, 14);
		recenti.add(lblHaCommentato);
		
		JLabel lblSlideMicroeconomia = new JLabel("Slide Microeconomia");
		lblSlideMicroeconomia.setForeground(Color.BLACK);
		lblSlideMicroeconomia.setFont(new Font("Arial", Font.BOLD, 14));
		lblSlideMicroeconomia.setBounds(118, 48, 161, 14);
		lblSlideMicroeconomia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSlideMicroeconomia.setForeground(Home.BLUE_BUTTON_PRESSED);
		recenti.add(lblSlideMicroeconomia);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 73, 289, 1);
		separator_6.setForeground(Home.BLUE_BUTTON_PRESSED);
		separator_6.setBackground(Home.BLUE_BUTTON_PRESSED);
		recenti.add(separator_6);
		
		JLabel lblHaAggiuntoUn = new JLabel("Ha aggiunto un suggerimento su");
		lblHaAggiuntoUn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHaAggiuntoUn.setBounds(10, 85, 205, 17);
		recenti.add(lblHaAggiuntoUn);
		
		JLabel label = new JLabel("Ingegneria degli algoritmi");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setForeground(Home.BLUE_BUTTON_PRESSED);
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setBounds(10, 106, 205, 17);
		recenti.add(label);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(0, 134, 289, 1);
		recenti.add(separator_7);
		
		JLabel lblHaVotato = new JLabel("Ha votato");
		lblHaVotato.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHaVotato.setBounds(10, 146, 60, 14);
		recenti.add(lblHaVotato);
		
		JLabel lblEserciziAnalisiIi = new JLabel("Esercizi Analisi II");
		lblEserciziAnalisiIi.setForeground(Color.BLACK);
		lblEserciziAnalisiIi.setFont(new Font("Arial", Font.BOLD, 14));
		lblEserciziAnalisiIi.setBounds(80, 146, 159, 14);
		lblEserciziAnalisiIi.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblEserciziAnalisiIi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		recenti.add(lblEserciziAnalisiIi);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(0, 171, 289, 1);
		recenti.add(separator_8);

	}
	
	public void addDocumenti(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size()/2);
		int altezza = 230*colmax;
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), altezza+370);
		doc.setSize(doc.getWidth(), altezza+370);
		
		for(int i = 0;i < docs.size();i++){
			int row = i%2;
			int col = (int) Math.floor(i/2);
			final Documento d = docs.get(i);
			final RiquadroDoc documento = new RiquadroDoc(d,false,false);//createFavourite(docs.get(i));
			documento.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(documento);
			
			documento.getRimuovi().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					int n = JOptionPane.showConfirmDialog(Home.getFrame(),"Sei sicuro di voler cancellare il documento?","Attenzione",0);
					if(n==0){
						docs.remove(d);
						ControllerDocumento cd = ControllerDocumento.getInstance();
						cd.removeDocumento(d);
						adjustDocs(docs);
					}
				}
			});		
			documento.getModifica().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					int n = JOptionPane.showConfirmDialog(Home.getFrame(),"Sei sicuro di voler modificare il documento?","Attenzione",0);
					if(n==0){
						Home.openDocument(true,d,true);
					}
				}
			});	
		}
		
		if (docs.size() == 0) {
			contenuto_pagina.setBounds(panel.getX()+10,panel.getY()+52,panel.getWidth(),100);
			panel.setSize(panel.getWidth(), 410);
			JLabel lblNoDoc = new JLabel("Nessun documento");
			lblNoDoc.setFont(new Font("Arial", Font.BOLD, 20));
			lblNoDoc.setBounds(0, 0, 310, 57);
			lblNoDoc.setForeground(Color.LIGHT_GRAY);
			contenuto_pagina.add(lblNoDoc);
		}
		
	}
	
	private void adjustDocs(final ArrayList<Documento> docs){
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addDocumenti(docs);		
	}
	
	private ArrayList<Documento> getDocs(Utente u, String filter,String sorting) {	
		if(u == null){
			return new ArrayList<Documento>();
		}
		ArrayList<Documento> doclist = new ArrayList<Documento>(u.documentiUtente.getCollection());
		return ControllerDocumento.getInstance().filtraPerTipo(ControllerDocumento.getInstance().sortBy(doclist, sorting),filter);
	}
	
	@Override
	public void reload(Object u) {
		Utente utente = (Utente) u;
		
		Calendar rightNow = Calendar.getInstance();
		Calendar dataNascita = Calendar.getInstance();
		dataNascita.setTime(utente.getDatadinascita());
		lblEta.setText(rightNow.get(Calendar.YEAR)-dataNascita.get(Calendar.YEAR)+"");
		
		lblUniv.setText(utente.getFacolta().getUniversita().getNome());
		lblFac.setText(utente.getFacolta().getNome());
		
		lblNomeUtente.setText(utente.getNome()+" "+utente.getCognome());
		
		imgUtente.setIcon(new ImageIcon("."+utente.getImmagine()));
		
		adjustDocs(getDocs(utente, "all","timestampUP"));
		
		float somma = 0;
		float temp = 0;
		int num = 0;
		ArrayList<Documento> doclist = new ArrayList<Documento>(utente.documentiUtente.getCollection());
		for (int i=0; i<doclist.size(); i++) {
			temp = ControllerVoto.getInstance().calcolaVoto(doclist.get(i));
			if (temp > 0) {
				temp = temp *10;
				num++;
				somma = somma + temp;
			}
		}
		lblVoto.setText(somma/num+"/10");
				
	}
	
	public int getAltezzaPagina(){
		return panel.getHeight();
	}

	@Override
	public void reload() {

	}
}
