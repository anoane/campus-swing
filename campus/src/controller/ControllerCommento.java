package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import gui.Home;

import org.orm.PersistentException;

import modello_di_dominio.Commento;
import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.Utente_Documento;
import modello_di_dominio.dao.CommentoDAO;
import modello_di_dominio.dao.DocumentoDAO;

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
		Calendar cal = GregorianCalendar.getInstance();
		Timestamp time = new Timestamp(cal.getTimeInMillis());
		c.setTimestamp(time);
	
		try {
			commentoDAO.save(c);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Commento> getListAllCommenti() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		CommentoDAO commentoDAO = factory.getCommentoDAO();
		try {
			Commento[] temp = commentoDAO.listCommentoByQuery(null, null);
			ArrayList<Commento> commenti = new ArrayList<Commento>();
			for (int i=0; temp.length > i; i++) {
				commenti.add(temp[i]);
			}
			return commenti;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Commento> getListCommentiByDoc(Documento d) {
		Commento[] listacommenti = d.commentos.toArray();
		ArrayList<Commento> commenti = new ArrayList<Commento>();
		for (int i=0; listacommenti.length > i; i++) {
			commenti.add(listacommenti[i]);
		}
		return ordina(commenti);
	}
	
	public void eliminaCommentiByDoc(Documento d) {
		Commento[] listacommenti = d.commentos.toArray();
		for (int i=0; listacommenti.length > i; i++) {
			eliminaCommento(listacommenti[i]);
		}
	}
	
	public void eliminaCommento(Commento comm) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		CommentoDAO commentoDAO = factory.getCommentoDAO();
		try {
			comm.getDocumento().commentos.remove(comm);
			comm.getUtente().commentos.remove(comm);
			
			commentoDAO.delete(comm);
		} catch(NullPointerException ex) {
			
		} catch (PersistentException e) {

		}
	}
	
	public ArrayList<Commento> ordina(ArrayList<Commento> array) {
		
		Comparator timestamp = new Comparator<Commento>() {

			@Override
		    public int compare(Commento obj1, Commento obj2) {
				if (obj1.getTimestamp()==null) {
		        	return -1;
		        }
		        if (obj2.getTimestamp()==null) {
		        	return 1;
		        }
				return obj1.getTimestamp().compareTo(obj2.getTimestamp());
		    }
		};
		
		Collections.sort(array, timestamp);
		//Collections.reverse(array);
		
		return array;
	}
	
	/**
	 * aggiungiCommento
	 * @param text
	 * @param d
	 */
	public void aggiungiCommento(String text,Documento d){
		this.aggiungiCommento(text, d, Home.getUtenteLoggato());
	}
	
	public void modificaCommento(Commento comm, String textCommento) {
		try {
			DAOFactory factory = DAOFactory.getDAOFactory();
			CommentoDAO commentoDAO = factory.getCommentoDAO();
			comm.setCommento(textCommento);
			commentoDAO.save(comm);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
