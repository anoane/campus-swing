package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

import modello_di_dominio.Corso;
import modello_di_dominio.Corso_Utente;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorsoDAO;
import modello_di_dominio.dao.Corso_UtenteDAO;
import modello_di_dominio.dao.FacoltaDAO;

import org.apache.lucene.queryparser.classic.ParseException;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
/**
 * 
 * @author mw
 *
 */
public class ControllerCorso extends AbstractController {
	/**
	 * 
	 */
	private static ControllerCorso instance = null;
	
	protected CorsoDAO corsoDAO;
	/**
	 * 
	 */
	protected ControllerCorso(){
		super();
		corsoDAO = DAOFactory.getDAOFactory().getCorsoDAO();
	}
	/**
	 * 
	 * @param nome
	 * @param descrizione
	 * @param FacoltaID
	 */
	public void creaCorso(String nome, String descrizione, int FacoltaID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
			Corso corso = corsoDAO.createCorso();
			corso.setNome(nome);
			corso.setDescrizione(descrizione);
			corso.facolta.add(facoltaDAO.getFacoltaByORMID(FacoltaID));
			corsoDAO.save(corso);
			//Commit
			t.commit();
			ControllerRicerca.getInstance().aggiungiCorso(corso);
			ControllerRicerca.getInstance().commitIndexingCorso();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * isCorsoAlreadyCollegato
	 * @param corsoID
	 * @param facoltaID
	 * @return
	 */
	public boolean isCorsoAlreadyCollegato(int corsoID, int facoltaID) {
		DAOFactory factory = DAOFactory.getDAOFactory();
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
	/**
	 * collegaCorsoFacolta
	 * @param corsoID
	 * @param facoltaID
	 */
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
	/**
	 * 
	 * @param indexFac
	 * @return
	 * @throws PersistentException
	 */
	public Corso[] getCorsiByFac(int indexFac) throws PersistentException {
		DAOFactory factory = DAOFactory.getDAOFactory();
		FacoltaDAO facoltaDAO = factory.getFacoltaDAO();
		Facolta facolta = facoltaDAO.getFacoltaByORMID(indexFac);
		Corso[] corsi = facolta.corso.toArray();
		//System.out.println(corsi.length);
		return corsi;
	}
	/**
	 * getCorso
	 * @param nome
	 * @return
	 */
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
	/**
	 * getCorso
	 * @param ID
	 * @return
	 */
	public Corso getCorso(int ID){
		DAOFactory factory = DAOFactory.getDAOFactory();
		CorsoDAO corsoDAO = factory.getCorsoDAO();
		try {
			Corso corso = corsoDAO.getCorsoByORMID(ID);
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
			ControllerRicerca.getInstance().removeCorso(corso);
			ControllerRicerca.getInstance().commitIndexingCorso();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Integer getIdCorsoSeguito(Utente u, Corso c) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Corso_UtenteDAO cuDAO = factory.getCorso_UtenteDAO();
		Corso_Utente cu = null;
		try {
			cu = cuDAO.loadCorso_UtenteByQuery("UtenteID = " + u.getID() + "AND CorsoID = " +c.getID(), null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return null;
		}
		return cu.getID();
	}
	
	public ArrayList<Corso> getCorsiSeguiti(Utente u) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Corso_UtenteDAO cuDAO = factory.getCorso_UtenteDAO();
		Corso_Utente cu = null;
		try {
			Corso_Utente[] temp = cuDAO.listCorso_UtenteByQuery("UtenteID = " + u.getID(), "timestamp DESC");
			ArrayList<Corso> corsi = new ArrayList<Corso>();
			for (int i=0; temp.length > i; i++) {
				corsi.add(temp[i].getCorso());
			}
			return corsi;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return null;
		}
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
	
	public ArrayList<Corso> getListAllCorsi() {
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		modello_di_dominio.dao.CorsoDAO CorsoDao = lDAOFactory.getCorsoDAO();
		try{
			Corso[] temp = CorsoDao.listCorsoByQuery(null, null);
			ArrayList<Corso> corsi = new ArrayList<Corso>();
			for (int i=0; temp.length > i; i++) {
				corsi.add(temp[i]);
			}
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
			nomeCorso = nomeCorso.replace("\'", "\'\'");
			
			if (corsoDAO.listCorsoByQuery("Nome='"+nomeCorso+"'",null).length != 0) {
				return true;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Corso> getListCorsoByString(String campoRicerca) throws ParseException {
		TreeMap<Integer,Corso> treecorso = new TreeMap<Integer,Corso>();
		Corso[] temp = null;
		temp = ControllerRicerca.getInstance().cercaCorso("Nome", campoRicerca+"*");
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treecorso.put(temp[i].getID(), temp[i]);
			}
		}
		temp = ControllerRicerca.getInstance().cercaCorso("Descrizione", campoRicerca+"*");
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treecorso.put(temp[i].getID(), temp[i]);
			}
		}
		ArrayList<Corso> corsi = new ArrayList<Corso>(treecorso.values());

		return corsi;
	}
	
}
