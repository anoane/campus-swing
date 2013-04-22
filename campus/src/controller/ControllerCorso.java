package controller;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorsoDAO;
import modello_di_dominio.dao.FacoltaDAO;
import modello_di_dominio.dao.UniversitaDAO;
import modello_di_dominio.dao.UtenteDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerCorso extends AbstractController {
	
	private static ControllerCorso instance = null;

	protected ControllerCorso(){
		super();
	}
	
	public void creaCorso(String nome, String descrizione, int FacoltaID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			CorsoDAO corsoDAO = factory.getCorsoDAO();
			Corso corso = corsoDAO.createCorso();
			corso.setNome(nome);
			corso.setDescrizione(descrizione);
			corso.facolta.add(facoltaDAO.getFacoltaByORMID(FacoltaID));
			corsoDAO.save(corso);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isCorsoAlreadyCollegato(int corsoID, int facoltaID) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		CorsoDAO corsoDAO = factory.getCorsoDAO();
		FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
		Facolta facolta = null;
		try {
			facolta = facoltaDAO.getFacoltaByORMID(facoltaID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Corso[] corsi = facolta.corso.toArray();
		for (int i=0; i < corsi.length; i++) {
			if (corsi[i].getID() == corsoID) {
				return true;
			}
		}
		return false;
	}
	
	public void collegaCorsoFacolta(int corsoID, int facoltaID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			CorsoDAO corsoDAO = factory.getCorsoDAO();
			FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			Corso corso = corsoDAO.getCorsoByORMID(corsoID);
			Facolta facolta = facoltaDAO.getFacoltaByORMID(facoltaID);
			
			corso.facolta.add(facolta);

			corsoDAO.save(corso);
			facoltaDAO.save(facolta);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Corso[] getCorsiByFac(int indexFac) throws PersistentException {
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		DAOFactory factory = DAOFactory.getDAOFactory();
		FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
		Facolta facolta = facoltaDAO.getFacoltaByORMID(indexFac);
		Corso[] corsi = facolta.corso.toArray();
		//System.out.println(corsi.length);
		return corsi;
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

	public Corso[] getAllCorsi() {
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		modello_di_dominio.dao.CorsoDAO CorsoDao = lDAOFactory.getCorsoDAO();
		try{
			Corso[] corsi = CorsoDao.listCorsoByQuery(null, null);
			return corsi;
		}catch(PersistentException e){
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean isCorsoAlreadyPresent(String nomeCorso) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		CorsoDAO corsoDAO = factory.getCorsoDAO();
		try {
			if (corsoDAO.listCorsoByQuery("Nome='"+nomeCorso+"'",null).length != 0) {
				return true;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
