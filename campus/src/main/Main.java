package main;
import gui.Home;

import java.awt.EventQueue;
import java.util.Date;

import modello_di_dominio.Corso;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;
import controller.ControllerAppunti;
import controller.ControllerCorso;
import controller.ControllerFacolta;
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
					Home window = new Home();
					window.getFrame().setVisible(true);
					/*
					ControllerCorso c = ControllerCorso.getInstance();
					
					c.creaCorso("Sistemi Interattivi", "Nah cagata!");
					Corso corso = c.getCorso("Sistemi Interattivi");
					
					ControllerUniversita univ = ControllerUniversita.getInstance();
					
					univ.createUniversita("Universita di L'Aquila");
					Universita universita = univ.getUniversita(1);
					
					ControllerFacolta f = ControllerFacolta.getInstance();
					
					f.creaFacolta("Ingegneria",universita);
					Facolta facolta = f.getFacolta(1);
					
					
					
					ControllerUtente u = ControllerUtente.getInstance();
					u.creaUtente("Pippo","Pluto","M",new Date(), facolta);
					
					ControllerAppunti d = ControllerAppunti.getInstance();
					Utente utente = u.getUtente("Pippo", "Pluto");
					
					
					d.creaAppunti("Sistemi", "Appunti", "/", utente, corso);
					d.creaAppunti("Interattivi", "Appunti", "/", utente, corso);
					d.creaDocumento("Ing", "Appunti", "/", utente, corso);
					
					u.aggiungiDocumentoPreferito(utente, d.getAppunti(1));
					u.aggiungiDocumentoPreferito(utente, d.getAppunti(2));
					*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
		
	}

}
