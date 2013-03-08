/**
 * 
 */
package controller;

import java.sql.Timestamp;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * @author mw
 *
 */
public class ControllerUtente {
	/**
	 * 
	 */
	public ControllerUtente() {
		super();
	}
	/**
	 * 
	 */
	public void creaUtente(){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
			modello_di_dominio.dao.UtenteDAO modello_di_DominioUtenteDAO = lDAOFactory.getUtenteDAO();
			modello_di_dominio.Utente utente = modello_di_DominioUtenteDAO.createUtente();
			
			utente.setNome("Francesco");
			utente.setCognome("Di Paolo");
			utente.setSesso("M");
			Timestamp time = new Timestamp(48474241);
			
			utente.setDatadinascita(time);
			
			modello_di_DominioUtenteDAO.save(utente);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void 
	
}
