package controller;

import gui.Home;

import org.orm.PersistentException;

import modello_di_dominio.Commento;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CommentoDAO;

/**
 * 
 * @author mw
 *
 */
public class ControllerCommento extends AbstractController {
	/**
	 * 
	 */
	private static ControllerCommento instance;
	/**
	 * 
	 */
	private CommentoDAO commentoDAO;
	/**
	 * 
	 */
	protected ControllerCommento(){
		commentoDAO = DAOFactory.getDAOFactory().getCommentoDAO();
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerCommento getInstance(){
		if(ControllerCommento.instance == null)
			ControllerCommento.instance = new ControllerCommento();
		return ControllerCommento.instance;
	}
	/**
	 * aggiungiCommento
	 * @param commento
	 * @param d
	 * @param u
	 */
	public void aggiungiCommento(String text,Documento d,Utente u){
		
		Commento c = commentoDAO.createCommento();
		
		c.setCommento(text);
		c.setDocumento(d);
		c.setUtente(u);
		
		try {
			commentoDAO.save(c);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * aggiungiCommento
	 * @param text
	 * @param d
	 */
	public void aggiungiCommento(String text,Documento d){
		this.aggiungiCommento(text, d, Home.getUtenteLoggato());
	}
}
