package gui;

import gui.riquadri.RiquadroDoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import controller.ControllerDocumento;
import controller.ControllerUtente;

public class Preferiti extends Pagina {
	
	//Pannello principale
	private JPanel panel;
	
	//Label Pagina
	private JLabel lblPage;
	
	// Linea
	private JSeparator separator;
	
	/**
	 * Pannello che contiene tutti i documenti preferiti dell'utente
	 */
	private JPanel contenuto_pagina;
	
	public void reload() {
		adjustDocs(getDocs());
	}
	
	private ArrayList<Documento> getDocs() {
		if(ControllerUtente.getInstance().getUtente(1) == null){
			return new ArrayList<Documento>();
		}
		return ControllerDocumento.getInstance().getDocumentiPreferiti(ControllerUtente.getInstance().getUtente(1));
	}
	
	/**
	 * 
	 */
	public Preferiti() {
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		
		
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 429));
		add(panel);
		panel.setLayout(null);
		
		lblPage = new JLabel("Preferiti");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.BOLD, 20));
		lblPage.setBounds(10, 10, 200, 25);
		panel.add(lblPage);
		
		separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		contenuto_pagina = new JPanel();
		contenuto_pagina.setLayout(null);
		contenuto_pagina.setBackground(Color.WHITE);
		panel.add(contenuto_pagina);

	}
	/**
	 * addFavourites
	 * @param docs
	 */
	public void addFavourites(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size()/2);
		int altezza = 230*colmax;
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), altezza+71);

		for(int i = 0;i < docs.size();i++){
			int row = i%2;
			int col = (int) Math.floor(i/2);
			final Documento d = docs.get(i);
			final RiquadroDoc preferito = new RiquadroDoc(d,true,false);
			preferito.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(preferito);
			
			preferito.getRimuoviPref().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					int n = JOptionPane.showConfirmDialog(Home.getFrame(),"Sicuro di voler rimuovere dai Preferiti il documento?","Attenzione",0);
					if(n==0){
					docs.remove(d);
					ControllerUtente u = ControllerUtente.getInstance();
					u.rimuoviDocumentoPreferito(u.getUtente(1), d);
					adjustDocs(docs);}
				}
			});
		}
	}
	
	private void adjustDocs(final ArrayList<Documento> docs){
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addFavourites(docs);
	}

	@Override
	public void reload(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}
}
