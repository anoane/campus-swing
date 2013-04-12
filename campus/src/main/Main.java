package main;
import gui.Home;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JOptionPane;

import modello_di_dominio.Corso;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;
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
					Home window = new Home();
					window.getFrame().setVisible(true);
					/*
					ControllerCorso c = ControllerCorso.getInstance();
					
					//c.creaCorso("Sistemi Interattivi", "Nah cagata!");
					Corso corso = c.getCorso("Sistemi Interattivi");
					
					ControllerUniversita univ = ControllerUniversita.getInstance();
					
					//univ.createUniversita("Universita di L'Aquila");
					Universita universita = univ.getUniversita(1);
					
					ControllerFacolta f = ControllerFacolta.getInstance();
					
					//f.creaFacolta("Ingegneria",universita);
					Facolta facolta = f.getFacolta(1);
					
					
					
					ControllerUtente u = ControllerUtente.getInstance();
					//u.creaUtente("Pippo","Pluto","M",new Date(), facolta);
					
					//ControllerAppunti d = ControllerAppunti.getInstance();
					ControllerSlide s = ControllerSlide.getInstance();
					Utente utente = u.getUtente("Pippo", "Pluto");
					
					
					//d.creaAppunti("Sistemi", "Appunti", "/", utente, corso);
					//d.creaAppunti("Interattivi", "Appunti", "/", utente, corso);
					//s.creaSlide("Ingegneria del software", "Slide offerte dal professore", "/", utente, corso);
					//JOptionPane.showMessageDialog(null, s.getSlide(4));
					//u.aggiungiDocumentoPreferito(utente, s.getSlide(4));
					//u.aggiungiDocumentoPreferito(utente, d.getAppunti(2));
					*/
					//ControllerAppunti d = ControllerAppunti.getInstance();
					//ControllerSlide s = ControllerSlide.getInstance();
					//ControllerUtente u = ControllerUtente.getInstance();
					//u.aggiungiDocumentoPreferito(u.getUtente(1), d.getAppunti(2));
					//u.aggiungiDocumentoPreferito(u.getUtente(1), s.getSlide(4));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
		
	}

}
