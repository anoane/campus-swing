package gui;

import gui.helpers.JTextFieldLimit;
import gui.riquadri.RiquadroDoc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	ButtonStandard buttonCreator = new ButtonStandard();
	//JButton seguiButton = buttonCreator.createButton("Aggiungi ai corsi seguiti", 740, 8, 230, 28, false, true);
	//JButton nonSeguiButton = buttonCreator.createButton("Rimuovi dai corsi seguiti", 740, 8, 230, 28, false, true);
	
	JLabel labelName = new JLabel();
	ArrayList<String> univ = new ArrayList<String>();

	
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
		labelName.setFont(new Font("Arial", Font.BOLD, 20));
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
		separator_1.setBounds(488, 10, 1, 215);
		panel_1.add(separator_1);
		
		JLabel lblNomeUtente = new JLabel("");
		lblNomeUtente.setForeground(new Color(0x06, 0x79, 0x9F));
		lblNomeUtente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNomeUtente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeUtente.setBounds(0, 10, 102, 28);
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
		lblProgramma.setBounds(500, 10, 243, 28);
		panel_1.add(lblProgramma);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(500, 38, 460, 1);
		panel_1.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(27, 50, 128));
		separator_4.setBounds(0, 38, 475, 1);
		panel_1.add(separator_4);
		

		doc = new JPanel();
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 300, 1008, 254);
		doc.setLayout(null);
		
		panel.add(doc);
		
		
		lblPage = new JLabel("Documenti caricati");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.BOLD, 20));
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
		
		lblNomeUtente.setText(utente.getNome()+" "+utente.getCognome());
		
		JLabel imgUtente = new JLabel("");
		imgUtente.setBounds(10, 50, 175, 175);
		panel_1.add(imgUtente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(195, 50, 283, 175);
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0};
		gbl_panel_2.rowHeights = new int[]{0};
		gbl_panel_2.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

	}
	
	public void addDocumenti(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size()/2);
		int altezza = 230*colmax;
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		//panel.setSize(panel.getWidth(), altezza+71);
		
		for(int i = 0;i < docs.size();i++){
			int row = i%2;
			int col = (int) Math.floor(i/2);
			final Documento d = docs.get(i);
			final RiquadroDoc documento = new RiquadroDoc(d,false,false);//createFavourite(docs.get(i));
			documento.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(documento);
			
			documento.getRimuovi().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					int n = JOptionPane.showConfirmDialog(Home.getFrame(),"Sicuro di voler cancellare il documento?","Attenzione",0);
					if(n==0){
						docs.remove(d);
						ControllerDocumento cd = ControllerDocumento.getInstance();
						cd.removeDocumento(d);
						adjustDocs(docs);}
					}
				});
		}
		
	}
	
	private void adjustDocs(final ArrayList<Documento> docs){
		System.out.println(docs.size());
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addDocumenti(docs);		
	}
	
	private ArrayList<Documento> getDocs(String sorting,String filter) {	
		Utente u = ControllerUtente.getInstance().getUtente(1);
			
		if(u == null){
			return new ArrayList<Documento>();
		}
		ArrayList<Documento> doclist = new ArrayList<Documento>(u.documentiUtente.getCollection());
		return ControllerDocumento.getInstance().filtraPerTipo(ControllerDocumento.getInstance().sortBy(doclist, sorting),filter);
	}
	
	@Override
	public void reload(Object d) {


	}
	
	public int getAltezzaPagina(){
		return panel.getHeight();
	}

	@Override
	public void reload() {
		adjustDocs(getDocs("all","timestampDOWN"));
		//addDocumenti(documento);
	}
}
