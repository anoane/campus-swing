package gui;


import gui.riquadri.RiquadroCorso;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import modello_di_dominio.Corso;
import modello_di_dominio.Utente;
import controller.ControllerCorso;
import controller.ControllerUtente;

@SuppressWarnings("serial")
public class CorsiSeguiti extends Pagina {

	//Pannello principale
	private JPanel panel;
	
	//Label Pagina
	private JLabel lblPage;
	
	// Linea
	private JSeparator separator;
	
	/**
	 * Pannello che contiene tutti i corsi seguiti dall'utente
	 */
	private JPanel contenuto_pagina;
	/**
	 * 
	 */
	public void reload() {
		adjustCourse(getCorsi());
	}
	/**
	 * getCorsi
	 * @return ArrayList<Corso>
	 */
	private ArrayList<Corso> getCorsi() {
		if(ControllerUtente.getInstance().getUtente(1) == null){
			return new ArrayList<Corso>();
		}
		return ControllerCorso.getInstance().getCorsiSeguiti(ControllerUtente.getInstance().getUtente(1));
	}
	
	/**
	 * addCorsi
	 * @param course
	 */
	public void addCorsi(final ArrayList<Corso> course){
		int colmax = (int) Math.ceil((float)course.size()/2);
		int altezza = 230*colmax;
		contenuto_pagina.setBounds(panel.getX(),panel.getY()+71,panel.getWidth(),altezza);
		panel.setSize(panel.getWidth(), altezza+71);

		for(int i = 0; i < course.size(); i++){
			int row = i%2;
			int col = (int) Math.floor(i/2);
			final Corso c = course.get(i);
			final RiquadroCorso corsi = new RiquadroCorso(c,true);

			corsi.setLocation((32+(485*row)), (230*col));
			contenuto_pagina.add(corsi);
			corsi.getRimuovi().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler rimuovere dai Corsi Seguiti il corso?","Attenzione",0);
					if(n==0){
					course.remove(c);
					ControllerUtente u = ControllerUtente.getInstance();
					//u.rimuoviCorsoSeguito(u.getUtente(1), c);
					adjustCourse(course);}
				}
				});
		}
	}
	/**
	 * 
	 * @param course
	 */
	private void adjustCourse(final ArrayList<Corso> course){
		contenuto_pagina.removeAll();
		contenuto_pagina.validate();
		contenuto_pagina.repaint();
		addCorsi(course);
	}
	
	/**
	 * Constructor
	 * Create the panel.
	 */
	public CorsiSeguiti() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1008, 542);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		
		lblPage = new JLabel("Corsi Seguiti");
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
	@Override
	public void reload(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}

}
