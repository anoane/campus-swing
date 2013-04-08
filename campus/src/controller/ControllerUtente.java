/**
 * 
 */
package controller;

import java.sql.Timestamp;
import java.util.Date;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * @author mw
 *
 */
public class ControllerUtente {
	
	private static ControllerUtente instance;
	/**
	 * 
	 */
	public ControllerUtente() {
		super();
	}
	
	/**
	 * 
	 */
	public void creaUtente(String nome, String cognome, String sesso, Date date, Facolta facolta){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UtenteDAO utenteDAO = factory.getUtenteDAO();
			Utente utente = utenteDAO.createUtente();
			
			utente.setNome(nome);
			utente.setCognome(cognome);
			utente.setSesso(sesso);
			utente.setDatadinascita(date);
			utente.setFacolta(facolta);
			utenteDAO.save(utente);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param ID
	 */
	public void deleteUtente(int ID) {
		try{
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UtenteDAO utenteDAO = factory.getUtenteDAO();
			
			//Trovo l'utente
			Utente utente = utenteDAO.getUtenteByORMID(ID);
			
			//Lo cancello
			utenteDAO.delete(utente);
			
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Utente getUtente(String n, String c){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		try {
			Utente utente = utenteDAO.loadUtenteByQuery("Nome = '" + n + "' AND Cognome = '" + c+"'", null);
			return utente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ControllerUtente getInstance(){
		if(ControllerUtente.instance == null)
			ControllerUtente.instance = new ControllerUtente();
		return ControllerUtente.instance;
	}
	
}
