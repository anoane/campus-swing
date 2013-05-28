package controller;
/**
 * 
 */
import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 */
import modello_di_dominio.Correzione;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorrezioneDAO;
/**
 * 
 */
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
/**
 * 
 * @author mw
 *
 */
public class ControllerCorrezione extends AbstractController {
	/**
	 * 
	 */
	private static ControllerCorrezione instance;
	/**
	 * 
	 */
	protected CorrezioneDAO correzioneDAO;
	/**
	 * Costruttore
	 */
	protected ControllerCorrezione(){
		super();
		correzioneDAO = DAOFactory.getDAOFactory().getCorrezioneDAO();
	}
	/**
	 * creaCorrezione
	 * @param testo
	 * @param data
	 * @param d
	 * @param utente
	 */
	public void creaCorrezione(String testo, Timestamp data, Documento d, Utente utente){
		try{
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			Correzione correzione = correzioneDAO.createCorrezione();
			correzione.setDocumento(d);
			correzione.setTesto(testo);
			correzione.setTimestamp(data);
			correzione.setUtente(utente);
			correzione.setApprovato(false);
			correzioneDAO.save(correzione);
			t.commit();
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Correzione getCorrezioneByID(int ID){
		try {
			return correzioneDAO.getCorrezioneByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * approvaCorrezione
	 * @param correzione
	 */
	public void approvaCorrezione(Correzione correzione){
		try{
			correzione.setApprovato(true);
			correzioneDAO.save(correzione);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * deleteCorrezione
	 * @param correzione
	 */
	public void deleteCorrezione(Correzione correzione){
		try{
			correzioneDAO.delete(correzione);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerCorrezione getInstance(){
		if(ControllerCorrezione.instance == null)
			ControllerCorrezione.instance = new ControllerCorrezione();
		return ControllerCorrezione.instance;
	}

}
