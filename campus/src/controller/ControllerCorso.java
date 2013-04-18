package controller;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorsoDAO;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerCorso extends AbstractController {
	
	private static ControllerCorso instance = null;

	protected ControllerCorso(){
		super();
	}
	
	public void creaCorso(String nome, String descrizione){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorsoDAO corsoDAO = factory.getCorsoDAO();
			Corso corso = corsoDAO.createCorso();
			corso.setNome(nome);
			corso.setDescrizione(descrizione);
			corsoDAO.save(corso);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Corso getCorso(String nome){
		DAOFactory factory = DAOFactory.getDAOFactory();
		CorsoDAO corsoDAO = factory.getCorsoDAO();
		try {
			Corso corso = corsoDAO.loadCorsoByQuery("Nome = '" + nome + "'", null);
			return corso;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteCorso(Corso corso){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorsoDAO corsoDAO = factory.getCorsoDAO();
			corsoDAO.delete(corso);
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param u Utente
	 * @return 
	 */
	public Corso[] getCorsiSeguiti(Utente u){
		
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		modello_di_dominio.dao.CorsoDAO CorsoDao = lDAOFactory.getCorsoDAO();
		try{
			//TODO cancellare
			Corso[] corsi = CorsoDao.listCorsoByQuery("", null);
			return corsi;
		}catch(PersistentException e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static ControllerCorso getInstance(){
		if(ControllerCorso.instance == null)
			ControllerCorso.instance = new ControllerCorso();
		return ControllerCorso.instance;
	}
}
