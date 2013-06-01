package gui;

import gui.helpers.Sorting;
import gui.riquadri.RiquadroDoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.hibernate.type.YesNoType;
import org.orm.PersistentException;

import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import controller.ControllerDocumento;
import controller.ControllerUtente;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class MieiDocumenti extends Pagina {
	
	//Pannello principale
	private JPanel panel;
	
	//Label Pagina
	private JLabel lblPage;
	
	// Linea
	private JSeparator separator;

	/**
	 * Pannello che contiene tutti i documenti caricati dall'utente
	 */
	private JPanel contenuto_pagina;
	private JPanel panel_1;
	private JLabel label;
	private JSeparator separator_1;
	private JComboBox comboBox_1;
	private JSeparator separator_2;
	private JComboBox comboBox_2;
	private JLabel label_2;
	
	public void reload(Object sorting) {
		adjustDocs(getDocs(((Sorting) sorting).getSorting(),((Sorting) sorting).getFilter()));
	}
	
	@Override
	public void reload() {
		// TODO Auto-generated method stub
		reloadRisultati();
	}
	
	
	/**
	 * getDocs()
	 * @return
	 */
	private ArrayList<Documento> getDocs(String sorting,String filter) {	
		if(Home.getUtenteLoggato() == null){
			return new ArrayList<Documento>();
		}
		ArrayList<Documento> doclist = new ArrayList<Documento>(Home.getUtenteLoggato().documentiUtente.getCollection());
		return ControllerDocumento.getInstance().filtraPerTipo(ControllerDocumento.getInstance().sortBy(doclist, sorting),filter);
	}
	
	protected void reloadRisultati() {
		String filtro = "all";
		if (comboBox_2.getSelectedIndex()==0) {
			filtro = "all";
		}
		if (comboBox_2.getSelectedIndex()==1) {
			filtro = "Appunti";
		}
		if (comboBox_2.getSelectedIndex()==2) {
			filtro = "Esercizi";
		}
		if (comboBox_2.getSelectedIndex()==3) {
			filtro = "Slide";
		}
		if (comboBox_2.getSelectedIndex()==4) {
			filtro = "Dispense";
		}
				
		String sorting = "timestampDOWN";
		if (comboBox_1.getSelectedIndex()==0) {
			sorting = "votoUP";
		}
		if (comboBox_1.getSelectedIndex()==1) {
			sorting = "timestampUP";
		}
		if (comboBox_1.getSelectedIndex()==2) {
			sorting = "downloadUP";
		}
		if (comboBox_1.getSelectedIndex()==3) {
			sorting = "votoDOWN";
		}
		if (comboBox_1.getSelectedIndex()==4) {
			sorting = "timestampDOWN";
		}
		if (comboBox_1.getSelectedIndex()==5) {
			sorting = "downloadDOWN";
		}
		reload(new Sorting(sorting,filtro));
	}
	
	/**
	 * Costruttore
	 */
	public MieiDocumenti() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 429);
		add(panel);
		panel.setLayout(null);
		
		lblPage = new JLabel("I miei documenti");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.BOLD, 20));
		lblPage.setBounds(10, 10, 200, 25);
		panel.add(lblPage);
		
		separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 1006, 1);
		panel.add(separator);
		
		contenuto_pagina = new JPanel();
		contenuto_pagina.setLayout(null);
		contenuto_pagina.setBackground(Color.WHITE);
		panel.add(contenuto_pagina);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1008, 38);
		panel.add(panel_1);
		
		label = new JLabel("Ordina per:");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(700, 9, 108, 25);
		panel_1.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(6, 121, 159));
		separator_1.setBackground(new Color(6, 121, 159));
		separator_1.setBounds(400, 8, 1, 28);
		panel_1.add(separator_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(814, 8, 144, 30);
		panel_1.add(comboBox_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(new Color(6, 121, 159));
		separator_2.setBackground(new Color(6, 121, 159));
		separator_2.setBounds(693, 8, 1, 28);
		panel_1.add(separator_2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(544, 8, 142, 30);
		panel_1.add(comboBox_2);
		
		label_2 = new JLabel("Filtra per tipo:");
		label_2.setForeground(new Color(6, 121, 159));
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(407, 9, 134, 25);
		panel_1.add(label_2);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"I pi\u00F9 votati", "I pi\u00F9 recenti", "I pi\u00F9 scaricati", "I meno votati", "I meno recenti", "I meno scaricati"}));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Qualsiasi tipo", "Solo appunti", "Solo esercizi", "Solo slide", "Solo dispense"}));
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				reloadRisultati();
			}
		});
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				reloadRisultati();
			}
		});
	}

	/**
	 * 
	 * @param docs
	 */
	public void addDocumenti(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size()/2);
		int altezza = 230*colmax;
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), altezza+71);
		
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
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addDocumenti(docs);
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}
}

