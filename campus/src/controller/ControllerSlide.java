package controller;

import modello_di_dominio.Corso;
import modello_di_dominio.Utente;

public class ControllerSlide extends ControllerDocumento {
	
	private static ControllerSlide instance;
	
	protected ControllerSlide(){
		super();
	}
	
	public void creaSlide(String nome, String descrizione,String path, Utente u, Corso c){
		super.creaDocumento(nome, descrizione, path, u, c);
	}
	
	public static ControllerSlide getInstance(){
		if(ControllerSlide.instance == null)
			ControllerSlide.instance = new ControllerSlide();
		return ControllerSlide.instance;
	}

}
