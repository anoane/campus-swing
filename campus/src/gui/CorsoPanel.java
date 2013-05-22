package gui;

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

import controller.ControllerDocumento;
import controller.ControllerUtente;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;

@SuppressWarnings("serial")
public class CorsoPanel extends Pagina {
	
	private JPanel panel;
	private JPanel paneldx;
	private JPanel panelsx;
	private JPanel doc;
	private int altezzaPagina=0;
	
	//Label Pagina
	private JLabel lblPage;
	
	private JPanel contenuto_pagina;
	ButtonStandard buttonCreator = new ButtonStandard();
	JButton seguiButton = buttonCreator.createButton("Segui Corso", 300, 11, 157, 34, false, true);
	
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
		
		//Label
		labelName.setForeground(new Color(6, 121, 159));
		labelName.setFont(new Font("Arial", Font.BOLD, 20));
		labelName.setBounds(10, 10, 280, 25);
		panel.add(labelName);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		panel.add(seguiButton);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 53, 988, 275);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		descrizione.setBackground(Color.WHITE);
		descrizione.setMargin(new Insets(5, 5, 5, 5));
		descrizione.setEditable(false);
		descrizione.setBounds(10, 50, 460, 275);
		panel_1.add(descrizione);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(0x1B, 0x32, 0x80));
		separator_1.setBounds(488, 10, 1, 275);
		panel_1.add(separator_1);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setForeground(new Color(0x06, 0x79, 0x9F));
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDescrizione.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDescrizione.setBounds(10, 10, 102, 28);
		panel_1.add(lblDescrizione);
		
		JPanel programma = new JPanel();
		programma.setBackground(Color.WHITE);
		programma.setBounds(508, 50, 460, 275);
		panel_1.add(programma);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] {167, 171, 32, 0};
		gbl_formPanel.rowHeights = new int[]{60, 60, 60, 60, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		programma.setLayout(gbl_formPanel);
		
		JLabel lblNewLabel = new JLabel("Università:");
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
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		programma.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Modalit\u00E0 d'esame:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		programma.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Programma del corso:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		programma.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		programma.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Docenti");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		programma.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		JLabel lblProgramma = new JLabel("Docenti che tengono il corso: ");
		lblProgramma.setForeground(new Color(0x06, 0x79, 0x9F));
		lblProgramma.setFont(new Font("Arial", Font.PLAIN, 18));
		lblProgramma.setAlignmentX(0.5f);
		lblProgramma.setBounds(508, 10, 243, 28);
		panel_1.add(lblProgramma);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(508, 38, 460, 1);
		panel_1.add(separator_2);
		

		doc = new JPanel();
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 350, 1008, 352);
		doc.setLayout(null);
		
		panel.add(doc);
		
		
		lblPage = new JLabel("Materiale relativo al corso");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.BOLD, 20));
		lblPage.setBounds(32, 10, 260, 25);
		doc.add(lblPage);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(27, 50, 128));
		separator_3.setBounds(32, 41, 904, 1);
		doc.add(separator_3);
		
		contenuto_pagina = new JPanel();
		contenuto_pagina.setLayout(null);
		contenuto_pagina.setBackground(Color.WHITE);
		doc.add(contenuto_pagina);
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
		panel.setSize(panel.getWidth(), 420+altezza);
		doc.setSize(doc.getWidth(), 420+altezza);
		
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
		//if(ControllerUtente.getInstance().getUtente(1).corso.contains(corso)){
		if(ControllerUtente.getInstance().containCorsoSeguito(ControllerUtente.getInstance().getUtente(1), corso)) {
			seguiButton.setVisible(false);
		}
		else{
			seguiButton.setVisible(true);
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
		
	}
	
	public int getAltezzaPagina(){
		return panel.getHeight();
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}


}
