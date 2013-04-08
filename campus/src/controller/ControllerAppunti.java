package controller;

import modello_di_dominio.Corso;
import modello_di_dominio.Utente;

public class ControllerAppunti extends ControllerDocumento {
	
	private static ControllerAppunti instance;
	
	public ControllerAppunti(){
		super();
	}
	
	protected void creaAppunti(String nome, String descrizione,String path, Utente u, Corso c){
		super.creaDocumento(nome, descrizione, path, u, c);
	}

	public static ControllerAppunti getInstance(){
		if(ControllerAppunti.instance == null)
			ControllerAppunti.instance = new ControllerAppunti();
		return ControllerAppunti.instance;
	}
}
