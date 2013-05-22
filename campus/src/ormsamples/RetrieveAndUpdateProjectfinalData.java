/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateProjectfinalData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
		try {
			modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
			modello_di_dominio.dao.UtenteDAO modello_di_DominioUtenteDAO = lDAOFactory.getUtenteDAO();
			modello_di_dominio.Utente modello_di_DominioUtente = modello_di_DominioUtenteDAO.loadUtenteByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioUtenteDAO.save(modello_di_DominioUtente);
			modello_di_dominio.dao.DocumentoDAO modello_di_DominioDocumentoDAO = lDAOFactory.getDocumentoDAO();
			modello_di_dominio.Documento modello_di_DominioDocumento = modello_di_DominioDocumentoDAO.loadDocumentoByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioDocumentoDAO.save(modello_di_DominioDocumento);
			modello_di_dominio.dao.CorsoDAO modello_di_DominioCorsoDAO = lDAOFactory.getCorsoDAO();
			modello_di_dominio.Corso modello_di_DominioCorso = modello_di_DominioCorsoDAO.loadCorsoByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioCorsoDAO.save(modello_di_DominioCorso);
			modello_di_dominio.dao.FacoltaDAO modello_di_DominioFacoltaDAO = lDAOFactory.getFacoltaDAO();
			modello_di_dominio.Facolta modello_di_DominioFacolta = modello_di_DominioFacoltaDAO.loadFacoltaByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioFacoltaDAO.save(modello_di_DominioFacolta);
			modello_di_dominio.dao.UniversitaDAO modello_di_DominioUniversitaDAO = lDAOFactory.getUniversitaDAO();
			modello_di_dominio.Universita modello_di_DominioUniversita = modello_di_DominioUniversitaDAO.loadUniversitaByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioUniversitaDAO.save(modello_di_DominioUniversita);
			modello_di_dominio.dao.CorrezioneDAO modello_di_DominioCorrezioneDAO = lDAOFactory.getCorrezioneDAO();
			modello_di_dominio.Correzione modello_di_DominioCorrezione = modello_di_DominioCorrezioneDAO.loadCorrezioneByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioCorrezioneDAO.save(modello_di_DominioCorrezione);
			modello_di_dominio.dao.VotoDAO modello_di_DominioVotoDAO = lDAOFactory.getVotoDAO();
			modello_di_dominio.Voto modello_di_DominioVoto = modello_di_DominioVotoDAO.loadVotoByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioVotoDAO.save(modello_di_DominioVoto);
			modello_di_dominio.dao.CommentoDAO modello_di_DominioCommentoDAO = lDAOFactory.getCommentoDAO();
			modello_di_dominio.Commento modello_di_DominioCommento = modello_di_DominioCommentoDAO.loadCommentoByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioCommentoDAO.save(modello_di_DominioCommento);
			modello_di_dominio.dao.Corso_UtenteDAO modello_di_DominioCorso_UtenteDAO = lDAOFactory.getCorso_UtenteDAO();
			modello_di_dominio.Corso_Utente modello_di_DominioCorso_Utente = modello_di_DominioCorso_UtenteDAO.loadCorso_UtenteByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioCorso_UtenteDAO.save(modello_di_DominioCorso_Utente);
			modello_di_dominio.dao.Utente_DocumentoDAO modello_di_DominioUtente_DocumentoDAO = lDAOFactory.getUtente_DocumentoDAO();
			modello_di_dominio.Utente_Documento modello_di_DominioUtente_Documento = modello_di_DominioUtente_DocumentoDAO.loadUtente_DocumentoByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioUtente_DocumentoDAO.save(modello_di_DominioUtente_Documento);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Utente by UtenteCriteria");
		modello_di_dominio.UtenteCriteria utenteCriteria = new modello_di_dominio.UtenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//utenteCriteria.ID.eq();
		System.out.println(utenteCriteria.uniqueUtente());
		
		System.out.println("Retrieving Documento by DocumentoCriteria");
		modello_di_dominio.DocumentoCriteria documentoCriteria = new modello_di_dominio.DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//documentoCriteria.ID.eq();
		System.out.println(documentoCriteria.uniqueDocumento());
		
		System.out.println("Retrieving Corso by CorsoCriteria");
		modello_di_dominio.CorsoCriteria corsoCriteria = new modello_di_dominio.CorsoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//corsoCriteria.ID.eq();
		System.out.println(corsoCriteria.uniqueCorso());
		
		System.out.println("Retrieving Facolta by FacoltaCriteria");
		modello_di_dominio.FacoltaCriteria facoltaCriteria = new modello_di_dominio.FacoltaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//facoltaCriteria.ID.eq();
		System.out.println(facoltaCriteria.uniqueFacolta());
		
		System.out.println("Retrieving Universita by UniversitaCriteria");
		modello_di_dominio.UniversitaCriteria universitaCriteria = new modello_di_dominio.UniversitaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//universitaCriteria.ID.eq();
		System.out.println(universitaCriteria.uniqueUniversita());
		
		System.out.println("Retrieving Correzione by CorrezioneCriteria");
		modello_di_dominio.CorrezioneCriteria correzioneCriteria = new modello_di_dominio.CorrezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//correzioneCriteria.ID.eq();
		System.out.println(correzioneCriteria.uniqueCorrezione());
		
		System.out.println("Retrieving Voto by VotoCriteria");
		modello_di_dominio.VotoCriteria votoCriteria = new modello_di_dominio.VotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//votoCriteria.ID.eq();
		System.out.println(votoCriteria.uniqueVoto());
		
		System.out.println("Retrieving Commento by CommentoCriteria");
		modello_di_dominio.CommentoCriteria commentoCriteria = new modello_di_dominio.CommentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//commentoCriteria.ID.eq();
		System.out.println(commentoCriteria.uniqueCommento());
		
		System.out.println("Retrieving Corso_Utente by Corso_UtenteCriteria");
		modello_di_dominio.Corso_UtenteCriteria corso_UtenteCriteria = new modello_di_dominio.Corso_UtenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//corso_UtenteCriteria.ID.eq();
		System.out.println(corso_UtenteCriteria.uniqueCorso_Utente());
		
		System.out.println("Retrieving Utente_Documento by Utente_DocumentoCriteria");
		modello_di_dominio.Utente_DocumentoCriteria utente_DocumentoCriteria = new modello_di_dominio.Utente_DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//utente_DocumentoCriteria.ID.eq();
		System.out.println(utente_DocumentoCriteria.uniqueUtente_Documento());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateProjectfinalData retrieveAndUpdateProjectfinalData = new RetrieveAndUpdateProjectfinalData();
			try {
				retrieveAndUpdateProjectfinalData.retrieveAndUpdateTestData();
				//retrieveAndUpdateProjectfinalData.retrieveByCriteria();
			}
			finally {
				modello_di_dominio.ProjectfinalPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
