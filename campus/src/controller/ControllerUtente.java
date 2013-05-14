/**
 * 
 */
package controller;

import java.util.Date;

import javax.swing.JOptionPane;

//import modello_di_dominio.Appunti;
import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
//import modello_di_dominio.Slide;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * @author mw
 *
 */
public class ControllerUtente extends AbstractController{
	
	private static ControllerUtente instance;
	/**
	 * 
	 */
	protected ControllerUtente() {
		super();
	}
	
	/**
	 * 
	 */
	public void creaUtente(String nome, String cognome,String username, String sesso, Date date, Facolta facolta){
		if(this.getUtente(username) == null){ 
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
	
	public Utente getUtente(int ID){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		try {
			Utente utente = utenteDAO.getUtenteByORMID(ID);
			return utente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Utente getUtente(String user){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		try {
			Utente utente = utenteDAO.loadUtenteByQuery("Username ='"+user+"'", null);
			return utente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void aggiungiDocumentoPreferito(Utente u, Documento d){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		u.documentiPreferiti.add(d);
		try {
			utenteDAO.save(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void rimuoviDocumentoPreferito(Utente u, Documento d){
		u.documentiPreferiti.remove(d);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		try {
			utenteDAO.save(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void rimuoviDocumento(Utente u, Documento d){
		DAOFactory factory = DAOFactory.getDAOFactory();
		ControllerDocumento s = ControllerDocumento.getInstance();
		u.documentiUtente.remove(d);
		u.documentiPreferiti.remove(d);
		s.removeDocumento(d);
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		try {
			utenteDAO.save(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void aggiungiCorsoSeguito(Utente u, Corso c){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		u.corso.add(c);
		try {
			utenteDAO.save(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void rimuoviCorsoSeguito(Utente u, Corso c){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		u.corso.remove(c);
		try {
			utenteDAO.save(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
		
	public static ControllerUtente getInstance(){
		if(ControllerUtente.instance == null)
			ControllerUtente.instance = new ControllerUtente();
		return ControllerUtente.instance;
	}
	
}
