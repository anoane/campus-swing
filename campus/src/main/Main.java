package main;
import gui.Home;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JOptionPane;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;
//import modello_di_dominio.dao.AppuntiDAO;
//import controller.ControllerAppunti;
import controller.ControllerCorso;
import controller.ControllerDocumento;
import controller.ControllerFacolta;
//import controller.ControllerSlide;
import controller.ControllerUniversita;
import controller.ControllerUtente;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Window thread
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {	
					/*
					ControllerUniversita univ = ControllerUniversita.getInstance();
					
					univ.createUniversita("Universita di L'Aquila");
					Universita universita = univ.getUniversita(1);
					
					ControllerFacolta f = ControllerFacolta.getInstance();
					
					f.createFacolta("Ingegneria",universita.getID());
					Facolta facolta1 = f.getFacolta(1);
					f.createFacolta("Scienze",universita.getID());
					Facolta facolta2 = f.getFacolta(2);
					
					
					ControllerCorso c = ControllerCorso.getInstance();
					
					c.creaCorso("Sistemi Interattivi", "Nah cagata!",facolta1.getID());
					Corso corso = c.getCorso("Sistemi Interattivi");
					
					ControllerUtente u = ControllerUtente.getInstance();
					u.creaUtente("Pippo","Pluto","PlutoPippo","M",new Date(), facolta1);
					
					ControllerDocumento d = ControllerDocumento.getInstance();
					Utente utente = u.getUtente(1);
					
					
					d.creaDocumento("Sistemi", "Appunti", "/","Slide", u.getUtente(1), corso, facolta1);
					d.creaDocumento("Interattivi", "Appunti", "/","Appunti", utente, corso, facolta1);
					d.creaDocumento("Sistemi", "Appunti", "/","Esercizi", u.getUtente(1), corso, facolta2);
					d.creaDocumento("Interattivi", "Appunti", "/","Dispense", utente, corso, facolta2);
					
				
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getDocumento(1));
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getDocumento(2));
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getDocumento(3));
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getDocumento(4));
					*/
					
					ControllerUtente u = ControllerUtente.getInstance();
					Utente utente = u.getUtente(1);
					ControllerCorso c = ControllerCorso.getInstance();
					u.aggiungiCorsoSeguito(utente, c.getCorso(1));

					Home window = new Home();
					window.getFrame().setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
		
	}

}
