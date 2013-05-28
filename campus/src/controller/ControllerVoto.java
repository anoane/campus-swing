/**
 * 
 */
package controller;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;
import modello_di_dominio.Utente_Documento;
import modello_di_dominio.Voto;
import modello_di_dominio.dao.Utente_DocumentoDAO;
import modello_di_dominio.dao.VotoDAO;

/**
 * @author mw
 *
 */
public class ControllerVoto extends AbstractController {
	
	/**
	 * 
	 */
	private static ControllerVoto instance;
	/**
	 * 
	 */
	private VotoDAO votoDAO;
	/**
	 * 
	 */
	protected ControllerVoto(){
		votoDAO = DAOFactory.getDAOFactory().getVotoDAO();
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerVoto getInstance(){
		if(ControllerVoto.instance == null)
			ControllerVoto.instance = new ControllerVoto();
		return ControllerVoto.instance;
	}
	
	public void votaDocumento(Documento documento, Utente utente, int i) {
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			Voto v = votoDAO.createVoto();
			v.setDocumento(documento);
			v.setUtente(utente);
			v.setValore(i);
			t.commit();
		}catch(PersistentException e) {
			e.printStackTrace();}
	}
	
	public void rimuoviVotoDocumento(Documento documento, Utente utente) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		VotoDAO votoDAO = factory.getVotoDAO();
		try {
			if(containVotoDocumento(documento,utente)) {
				Voto voto = votoDAO.getVotoByORMID(ControllerDocumento.getInstance().getIdVotoDocumento(documento,utente));
				//documento.votos.remove(voto);
				//votoDAO.delete(voto);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public boolean containVotoDocumento(Documento d, Utente u) {
		Integer res = null;
		try {
			res = ControllerDocumento.getInstance().getIdVotoDocumento(d,u);
		} catch (NullPointerException ex) {
			return false;
		}
		if (res != null) {
			return true;
		}
		return false;
	}
	
	public float calcolaVoto(Documento d) {
		Voto[] voti = d.votos.toArray();
		if (voti.length == 0)
			return 0;
		int voto = 0;
		for (int i = 0; i < voti.length; ++i) {
			voto += voti[i].getValore();
		}
		float media = voto / voti.length;
		return media / 10;
	}
		
	 	
	
}
