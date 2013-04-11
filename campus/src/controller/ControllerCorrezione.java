package controller;

import java.util.Date;

import modello_di_dominio.Correzione;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorrezioneDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerCorrezione extends AbstractController {
	
	private static ControllerCorrezione instance;
	
	protected ControllerCorrezione(){
		super();
	}
	
	public void creaCorrezione(String testo, Date data, Documento d, Utente utente){
		try{
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorrezioneDAO correzioneDAO = factory.getCorrezioneDAO();
			Correzione correzione = correzioneDAO.createCorrezione();
			correzione.setDocumento(d);
			correzione.setTesto(testo);
			correzione.setData(data);
			correzione.setUtente(utente);
			correzione.setApprovato(false);
			correzioneDAO.save(correzione);
			t.commit();
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void approvaCorrezione(Correzione correzione){
		try{
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorrezioneDAO correzioneDAO = factory.getCorrezioneDAO();
			correzione.setApprovato(true);
			correzioneDAO.save(correzione);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCorrezione(Correzione correzione){
		try{
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorrezioneDAO correzioneDAO = factory.getCorrezioneDAO();
			correzioneDAO.delete(correzione);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static ControllerCorrezione getInstance(){
		if(ControllerCorrezione.instance == null)
			ControllerCorrezione.instance = new ControllerCorrezione();
		return ControllerCorrezione.instance;
	}

}
