package controller;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Universita;
import modello_di_dominio.dao.UniversitaDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mysql.jdbc.StringUtils;
/**
 * 
 * @author mw
 *
 */
public class ControllerUniversita extends AbstractController {
	/**
	 * 
	 */
	private static ControllerUniversita instance;
	/**
	 * 
	 */
	protected UniversitaDAO universitaDAO;
	/**
	 * Costruttore
	 */
	protected ControllerUniversita(){
		super();
		universitaDAO = DAOFactory.getDAOFactory().getUniversitaDAO();
	}
	/**
	 * creaUniversità
	 * @param n
	 */
	public void createUniversita(String n){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			Universita universita = universitaDAO.createUniversita();
			
			universita.setNome(n);
			universitaDAO.save(universita);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * deleteUniversità
	 * @param ID
	 */
	public void deleteUniversita(int ID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			//Trovo l'universita
			Universita universita = universitaDAO.getUniversitaByORMID(ID);
			
			//La cancello
			universitaDAO.delete(universita);
			
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * getUniversita
	 * @param ID
	 * @return
	 */
	public Universita getUniversita(int ID){
		//Trovo l'univesita
		try {
			return universitaDAO.getUniversitaByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * isUniversitaAlreadyPresent
	 * @param univ
	 * @return
	 */
	public boolean isUniversitaAlreadyPresent(String univ){
		//Trovo l'univesita
		try {
			
			univ = univ.replace("\'","\'\'");
			
			if (universitaDAO.listUniversitaByQuery("Nome='"+univ+"'",null).length != 0) {
				return true;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * getAllUniversita
	 * @return
	 */
	public Universita[] getAllUniversita(){
		//Trovo l'univesita
		try {
			return universitaDAO.listUniversitaByQuery(null,null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerUniversita getInstance(){
		if(ControllerUniversita.instance == null)
			ControllerUniversita.instance = new ControllerUniversita();
		return ControllerUniversita.instance;
	}
}
