package controller;

import modello_di_dominio.Appunti;
import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.AppuntiDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerAppunti extends AbstractController {
	
	private static ControllerAppunti instance;
	
	public ControllerAppunti(){
		super();
	}
	
	public void creaAppunti(String nome, String descrizione,String path, Utente u, Corso c,Facolta f){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			AppuntiDAO appuntiDAO = factory.getAppuntiDAO();
			Appunti appunti = appuntiDAO.createAppunti();
			appunti.setNome(nome);
			appunti.setDescrizione(descrizione);
			appunti.setPath(path);
			appunti.setProprietario(u);
			appunti.setCorso(c);
			appunti.setFacolta(f);
			appuntiDAO.save(appunti);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public static ControllerAppunti getInstance(){
		if(ControllerAppunti.instance == null)
			ControllerAppunti.instance = new ControllerAppunti();
		return ControllerAppunti.instance;
	}
	
	public Appunti getAppunti(int ID){
		DAOFactory factory = DAOFactory.getDAOFactory();
		AppuntiDAO appuntiDAO = factory.getAppuntiDAO();
		try {
			return appuntiDAO.getAppuntiByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteAppunti(Appunti appunti){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			AppuntiDAO appuntiDAO = factory.getAppuntiDAO();
			appuntiDAO.delete(appunti);
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
