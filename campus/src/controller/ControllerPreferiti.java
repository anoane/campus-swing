/**
 * 
 */
package controller;

import java.util.ArrayList;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.Utente_Documento;
import modello_di_dominio.dao.Utente_DocumentoDAO;

import org.orm.PersistentException;

/**
 * @author mw
 *
 */
public class ControllerPreferiti extends AbstractController {
	
	protected Utente_DocumentoDAO utente_documentoDAO;
	/**
	 * 
	 */
	private static ControllerPreferiti instance;
	
	/**
	 * 
	 */
	protected ControllerPreferiti() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControllerPreferiti getInstance(){
		if(ControllerPreferiti.instance == null)
			ControllerPreferiti.instance = new ControllerPreferiti();
		return ControllerPreferiti.instance;
	}
	
	/**
	 * 
	 * @param u
	 * @param d
	 */
	public void aggiungiDocumentoPreferito(Utente u, Documento d){
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		Utente_Documento ud = udDAO.createUtente_Documento();
		ud.setDocumento(d);
		ud.setUtentePreferito(u);
		try {
			udDAO.save(ud);
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param u
	 * @return
	 */
	public ArrayList<Documento> getDocumentiPreferiti(Utente u) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		Utente_Documento ud = null;
		try {
			Utente_Documento[] temp = udDAO.listUtente_DocumentoByQuery("UtenteID = " + u.getID(), "timestamp DESC");
			ArrayList<Documento> docs = new ArrayList<Documento>();
			for (int i=0; temp.length > i; i++) {
				docs.add(temp[i].getDocumento());
			}
			return docs;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param d
	 */
	public void rimuoviDocumentoDaTuttiPreferiti(Documento d) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		Utente_Documento[] ud = null;
		try {
			ud = udDAO.listUtente_DocumentoByQuery("DocumentoID = " + d.getID(), null);
			if (ud.length!=0) {
				for (int i=0; i<ud.length; i++) {
					ud[i].getDocumento().utentePreferito.remove(ud[i]);
					ud[i].getUtentePreferito().documentiPreferiti.remove(ud[i]);
					udDAO.delete(ud[i]);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
