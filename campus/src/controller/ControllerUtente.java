/**
 * 
 */
package controller;

import java.util.Date;

import modello_di_dominio.Corso;
import modello_di_dominio.Corso_Utente;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.Utente_Documento;
import modello_di_dominio.dao.Corso_UtenteDAO;
import modello_di_dominio.dao.UtenteDAO;
import modello_di_dominio.dao.Utente_DocumentoDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;
//import modello_di_dominio.Appunti;
//import modello_di_dominio.Slide;

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
			//PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UtenteDAO utenteDAO = factory.getUtenteDAO();
			
			//Trovo l'utente
			Utente utente = utenteDAO.getUtenteByORMID(ID);
			
			//Lo cancello
			utenteDAO.delete(utente);
			
			//Commit
			//t.commit();
			
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

	/**
	 * 
	 * @param u
	 * @param d
	 */
	public void rimuoviDocumentoPreferito(Utente u, Documento d){
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		try {
			if(containDocumentoPreferito(u,d)) {
				Utente_Documento ud = udDAO.getUtente_DocumentoByORMID(ControllerDocumento.getInstance().getIdDocumentoPreferito(u,d));
				d.utentePreferito.remove(ud);
				u.documentiPreferiti.remove(ud);
				udDAO.delete(ud);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void aggiungiCorsoSeguito(Utente u, Corso c){
		DAOFactory factory = DAOFactory.getDAOFactory();
		Corso_UtenteDAO cuDAO = factory.getCorso_UtenteDAO();
		Corso_Utente cu = cuDAO.createCorso_Utente();
		cu.setCorso(c);
		cu.setUtente(u);
		try {
			cuDAO.save(cu);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void rimuoviCorsoSeguito(Utente u, Corso c){
		DAOFactory factory = DAOFactory.getDAOFactory();
		Corso_UtenteDAO cuDAO = factory.getCorso_UtenteDAO();
		try {
			if(containCorsoSeguito(u,c)) {
				Corso_Utente cu = cuDAO.getCorso_UtenteByORMID(ControllerCorso.getInstance().getIdCorsoSeguito(u,c));
				cuDAO.delete(cu);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
		
	public static ControllerUtente getInstance(){
		if(ControllerUtente.instance == null)
			ControllerUtente.instance = new ControllerUtente();
		return ControllerUtente.instance;
	}
	
	public boolean containCorsoSeguito(Utente u, Corso c) {
		Integer res = null;
		try {
			res = ControllerCorso.getInstance().getIdCorsoSeguito(u,c);
		} catch (NullPointerException ex) {
			return false;
		}
		if (res != null) {
			return true;
		}
		return false;
	}
	
	public boolean containDocumentoPreferito(Utente u, Documento d) {
		Integer res = null;
		try {
			res = ControllerDocumento.getInstance().getIdDocumentoPreferito(u,d);
		} catch (NullPointerException ex) {
			return false;
		}
		if (res != null) {
			return true;
		}
		return false;
	}
	
}
