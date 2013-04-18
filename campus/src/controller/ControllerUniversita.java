package controller;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UniversitaDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerUniversita extends AbstractController {
	
	private static ControllerUniversita instance;

	protected ControllerUniversita(){
		super();
	}
	
	public void createUniversita(String n){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UniversitaDAO universitaDAO = factory.getUniversitaDAO();
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
	
	public void deleteUniversita(int ID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UniversitaDAO universitaDAO = factory.getUniversitaDAO();
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
	
	public Universita getUniversita(int ID){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UniversitaDAO universitaDAO = factory.getUniversitaDAO();
		//Trovo l'univesita
		try {
			return universitaDAO.getUniversitaByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isUniversitaAlreadyPresent(String univ){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UniversitaDAO universitaDAO = factory.getUniversitaDAO();
		//Trovo l'univesita
		try {
			if (universitaDAO.listUniversitaByQuery("Nome='"+univ+"'",null).length != 0) {
				return true;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Universita[] getAllUniversita(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		UniversitaDAO universitaDAO = factory.getUniversitaDAO();
		//Trovo l'univesita
		try {
			return universitaDAO.listUniversitaByQuery(null,null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ControllerUniversita getInstance(){
		if(ControllerUniversita.instance == null)
			ControllerUniversita.instance = new ControllerUniversita();
		return ControllerUniversita.instance;
	}
}
