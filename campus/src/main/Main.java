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
import modello_di_dominio.dao.AppuntiDAO;
import controller.ControllerAppunti;
import controller.ControllerCorso;
import controller.ControllerFacolta;
import controller.ControllerSlide;
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
					ControllerUniversita univ = ControllerUniversita.getInstance();
					
					univ.createUniversita("Universita di L'Aquila");
					Universita universita = univ.getUniversita(1);
					
					ControllerFacolta f = ControllerFacolta.getInstance();
					
					f.createFacolta("Ingegneria",universita.getID());
					Facolta facolta = f.getFacolta(1);
					
					ControllerCorso c = ControllerCorso.getInstance();
					
					c.creaCorso("Sistemi Interattivi", "Nah cagata!",facolta.getID());
					Corso corso = c.getCorso("Sistemi Interattivi");
					

					
					ControllerUtente u = ControllerUtente.getInstance();
					u.creaUtente("Pippo","Pluto","PlutoPippo","M",new Date(), facolta);
					
					ControllerAppunti d = ControllerAppunti.getInstance();
					ControllerSlide s = ControllerSlide.getInstance();
					Utente utente = u.getUtente("Pippo", "Pluto");
					
					
					d.creaAppunti("Sistemi", "Appunti", "/", utente, corso);
					d.creaAppunti("Interattivi", "Appunti", "/", utente, corso);
					s.creaSlide("Ingegneria del software", "Slide offerte dal professore", "/", utente, corso);
					JOptionPane.showMessageDialog(null, s.getSlide(4));
					u.aggiungiDocumentoPreferito(utente, s.getSlide(4));
					u.aggiungiDocumentoPreferito(utente, d.getAppunti(2));
					
				
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getAppunti(2));
					u.aggiungiDocumentoPreferito(u.getUtente(1), s.getSlide(4));
					
					u.aggiungiDocumentoPreferito(u.getUtente(1), d.getAppunti(2));
					
					Home window = new Home();
					window.getFrame().setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
		
	}

}
