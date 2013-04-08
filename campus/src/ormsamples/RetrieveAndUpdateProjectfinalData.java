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
			modello_di_dominio.dao.SlideDAO modello_di_DominioSlideDAO = lDAOFactory.getSlideDAO();
			modello_di_dominio.Slide modello_di_DominioSlide = modello_di_DominioSlideDAO.loadSlideByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioSlideDAO.save(modello_di_DominioSlide);
			modello_di_dominio.dao.AppuntiDAO modello_di_DominioAppuntiDAO = lDAOFactory.getAppuntiDAO();
			modello_di_dominio.Appunti modello_di_DominioAppunti = modello_di_DominioAppuntiDAO.loadAppuntiByQuery(null, null);
			// Update the properties of the persistent object
			modello_di_DominioAppuntiDAO.save(modello_di_DominioAppunti);
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
		
		System.out.println("Retrieving Slide by SlideCriteria");
		modello_di_dominio.SlideCriteria slideCriteria = new modello_di_dominio.SlideCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//slideCriteria.ID.eq();
		System.out.println(slideCriteria.uniqueSlide());
		
		System.out.println("Retrieving Appunti by AppuntiCriteria");
		modello_di_dominio.AppuntiCriteria appuntiCriteria = new modello_di_dominio.AppuntiCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//appuntiCriteria.ID.eq();
		System.out.println(appuntiCriteria.uniqueAppunti());
		
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
