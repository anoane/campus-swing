package gui;

import gui.riquadri.RiquadroDoc;
import gui.riquadri.RiquadroPref;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.dao.UtenteDAO;
import controller.ControllerUtente;

public class Preferiti extends JPanel{
	
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
	
	protected void reload() {
		adjustDocs(getDocs());
	}
	
	private ArrayList<Documento> getDocs() {
		ArrayList<Documento> d = new ArrayList<Documento>();
		try {
			d = new ArrayList<Documento>(ControllerUtente.getInstance().getUtente(1).documentiPreferiti.getCollection());
			return d;
		} catch (NullPointerException npe) { } {
			return null;
		}
	}
	
	//private 
	
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
	
	public void addFavourites(final ArrayList<Documento> docs){
		int col = 0;
		for(int i = 0;i < docs.size();i++){
			final Documento d = docs.get(i);
			final RiquadroPref preferito = new RiquadroPref(d);//createFavourite(docs.get(i));
			col = (int) Math.floor(i/2);
			int row = i%2;
			preferito.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(preferito);
			
			preferito.getRimuovi().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					docs.remove(d);
					ControllerUtente u = ControllerUtente.getInstance();
					//u.rimuoviDocumentoPreferito(u.getUtente(1), d);
					adjustDocs(docs);}
				});
		}
		int altezza = 322+(230*col);
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), altezza);
		Home.setAltezzaDinamica(altezza);
	}
	
	private void adjustDocs(final ArrayList<Documento> docs){
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addFavourites(docs);
	}
}
