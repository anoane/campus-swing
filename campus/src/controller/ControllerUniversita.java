package controller;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UniversitaDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerUniversita extends AbstractController {

	public ControllerUniversita(){
		super();
	}
	
	public void createUniversita(){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			
			DAOFactory factory = DAOFactory.getDAOFactory();
			UniversitaDAO universitaDAO = factory.getUniversitaDAO();
			Universita universita = universitaDAO.createUniversita();
			
			universita.setNome("Universita dell'Aquila");
			universitaDAO.save(universita);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
