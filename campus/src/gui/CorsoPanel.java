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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CorsoPanel extends Pagina {
	
	private JPanel panel;
	private JPanel paneldx;
	private JPanel panelsx;
	private JPanel doc;
	private int altezzaPagina=0;
	private JTextPane facolta = new JTextPane();
	
	//Label Pagina
	private JLabel lblPage;
	
	private JPanel contenuto_pagina;
	ButtonStandard buttonCreator = new ButtonStandard();
	JButton seguiButton = buttonCreator.createButton("Aggiungi ai corsi seguiti", 740, 8, 230, 28, false, true);
	JButton nonSeguiButton = buttonCreator.createButton("Rimuovi dai corsi seguiti", 740, 8, 230, 28, false, true);
	
	JLabel labelName = new JLabel();
	JTextPane descrizione = new JTextPane();
	ArrayList<String> univ = new ArrayList<String>();
	JComboBox comboBox = new JComboBox();

	
	/**
	 * Create the panel.
	 */
	public CorsoPanel(Corso corso) {
		
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
		//labelName.setText("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		
		//Label
		labelName.setForeground(new Color(6, 121, 159));
		labelName.setFont(new Font("Arial", Font.BOLD, 20));
		labelName.setBounds(10, 10, 723, 25);
		panel.add(labelName);
		
		panel.add(seguiButton);
		panel.add(nonSeguiButton);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 53, 988, 235);
		panel.add(panel_1);
		panel_1.setLayout(null);
		descrizione.setFont(new Font("Arial", Font.PLAIN, 14));
		
		descrizione.setBackground(Color.WHITE);
		descrizione.setMargin(new Insets(0, 0, 0, 0));
		descrizione.setEditable(false);
		descrizione.setBounds(0, 38, 478, 73);
		panel_1.add(descrizione);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(0x1B, 0x32, 0x80));
		separator_1.setBounds(488, 10, 1, 215);
		panel_1.add(separator_1);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setForeground(new Color(0x06, 0x79, 0x9F));
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDescrizione.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDescrizione.setBounds(0, 10, 102, 28);
		panel_1.add(lblDescrizione);
		
		JPanel programma = new JPanel();
		programma.setBackground(Color.WHITE);
		programma.setBounds(500, 50, 460, 174);
		panel_1.add(programma);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] {145, 171, 0};
		gbl_formPanel.rowHeights = new int[]{30, 30, 60, 60, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		programma.setLayout(gbl_formPanel);
		
		JLabel lblNewLabel = new JLabel("Universit\u00E0");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		programma.add(lblNewLabel, gbc_lblNewLabel);
		
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		programma.add(comboBox, gbc_comboBox);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 0;
		//programma.add(textArea, gbc_textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		//textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		textArea.setWrapStyleWord(true);
		textArea.setDocument(new JTextFieldLimit(254));
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea_1.setLineWrap(true);
		textArea_1.setEnabled(false);
		//textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		textArea_1.setWrapStyleWord(true);
		textArea_1.setDocument(new JTextFieldLimit(254));
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 1;
		//programma.add(textArea_1, gbc_textArea_1);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		programma.add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Modalit\u00E0 d'esame");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		programma.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Programma del corso");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		programma.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		programma.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Docenti");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		programma.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		programma.add(scrollPane_1, gbc_scrollPane_1);
		
		
		
		JLabel lblProgramma = new JLabel("Docenti che tengono il corso");
		lblProgramma.setForeground(new Color(0x06, 0x79, 0x9F));
		lblProgramma.setFont(new Font("Arial", Font.PLAIN, 18));
		lblProgramma.setAlignmentX(0.5f);
		lblProgramma.setBounds(500, 10, 243, 28);
		panel_1.add(lblProgramma);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(500, 38, 460, 1);
		panel_1.add(separator_2);
		
		facolta.setFont(new Font("Arial", Font.PLAIN, 14));
		facolta.setMargin(new Insets(0, 0, 0, 0));
		facolta.setEditable(false);
		facolta.setBackground(Color.WHITE);
		facolta.setBounds(0, 150, 478, 74);
		panel_1.add(facolta);


		
		JLabel lblFacolt = new JLabel("Facolt\u00E0");
		lblFacolt.setForeground(new Color(6, 121, 159));
		lblFacolt.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFacolt.setAlignmentX(0.5f);
		lblFacolt.setBounds(0, 122, 102, 28);
		panel_1.add(lblFacolt);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(27, 50, 128));
		separator_4.setBounds(0, 38, 475, 1);
		panel_1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(27, 50, 128));
		separator_5.setBounds(0, 150, 475, 1);
		panel_1.add(separator_5);
		

		doc = new JPanel();
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 300, 1008, 254);
		doc.setLayout(null);
		
		panel.add(doc);
		
		
		lblPage = new JLabel("Materiale relativo al corso");
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
	
		separator_2.setVisible(false);
		separator_4.setVisible(false);
		separator_5.setVisible(false);

	}
	
	public void addDocumenti(Corso corso){
		ArrayList<Documento> docs = null;
		try {
			docs = ControllerDocumento.getInstance().getListAllDocumentiByCorso(0, corso.getID(), false, "all", "timestampUP");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int colmax = (int) Math.ceil((float)docs.size()/2);
		int altezza = 230*colmax;
		
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), 370+altezza);
		doc.setSize(doc.getWidth(), 370+altezza);
		
		for(int i = 0;i < docs.size(); i++){
			int col = (int) Math.floor(i/2);
			int row = i%2;
			final Documento d = docs.get(i);
			final RiquadroDoc documento = new RiquadroDoc(d,false,true);
			documento.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(documento);
		}
	}
	
	private void adjustDocs(Corso corso){
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addDocumenti(corso);		
	}
	
	@Override
	public void reload(Object c) {
		final Corso corso = (Corso)c;
		adjustDocs(corso);
		if(ControllerUtente.getInstance().containCorsoSeguito(ControllerUtente.getInstance().getUtente(1), corso)) {
			seguiButton.setVisible(false);
			nonSeguiButton.setVisible(true);
			nonSeguiButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					ControllerUtente.getInstance().rimuoviCorsoSeguito(ControllerUtente.getInstance().getUtente(1), corso);
					Home.openCorso(false, corso);
				}
			});
		}
		else{
			seguiButton.setVisible(true);
			nonSeguiButton.setVisible(false);
			seguiButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					ControllerUtente.getInstance().aggiungiCorsoSeguito(ControllerUtente.getInstance().getUtente(1), corso);
					Home.openCorso(false, corso);
				}
			});
		}
		labelName.setText(corso.getNome());
		descrizione.setText(corso.getDescrizione());
		for(int i=0; i< corso.facolta.size(); ++i)
			univ.add(i, corso.facolta.toArray()[i].getNome()); 
		
		DefaultComboBoxModel newModel = new DefaultComboBoxModel(univ.toArray());
		comboBox.setModel(newModel);
		addDocumenti(corso);
		
		if (corso != null) {
			if (!corso.facolta.isEmpty()) {
				for(int i=0; i<corso.facolta.size(); ++i){
					if(i == 0){
						facolta.setText(corso.facolta.toArray()[0].getNome());
						++i;
					}
					if (i<corso.facolta.size()) {
						facolta.setText(facolta.getText()+" , "+corso.facolta.toArray()[i].getNome());
					}
				}
			}
		}
	}
	
	public int getAltezzaPagina(){
		return panel.getHeight();
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}
}
