package controller;

import java.sql.Timestamp;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerFacolta extends AbstractController {
	
	public ControllerFacolta() {
		super();
	}
	
	/**
	 * 
	 */
	public void creaFacolta(Universita u){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			Facolta facolta = facoltaDAO.createFacolta();
			
			facolta.setNome("Ingegneria");
			facolta.setUniversita(u);
			facoltaDAO.save(facolta);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
