package controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UniversitaDAO;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerFacolta extends AbstractController {
	
	private static ControllerFacolta instance;
	
	protected ControllerFacolta() {
		super();
	}
	
	/**
	 * 
	 */
	public void creaFacolta(String nome, Universita u){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			Facolta facolta = facoltaDAO.createFacolta();
			
			facolta.setNome(nome);
			facolta.setUniversita(u);
			facoltaDAO.save(facolta);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Facolta getFacolta(int ID){
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			
		try {
			return facoltaDAO.getFacoltaByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Facolta[] getAllFacoltaByUniv(int indexUniv){
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			
		try {
			return facoltaDAO.listFacoltaByQuery("UniversitaID="+indexUniv,null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ControllerFacolta getInstance(){
		if(ControllerFacolta.instance == null)
			ControllerFacolta.instance = new ControllerFacolta();
		return ControllerFacolta.instance;
	}
	
}
