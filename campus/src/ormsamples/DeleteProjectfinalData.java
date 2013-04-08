/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class DeleteProjectfinalData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
		try {
			modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
			modello_di_dominio.dao.UtenteDAO modello_di_DominioUtenteDAO = lDAOFactory.getUtenteDAO();
			modello_di_dominio.Utente modello_di_DominioUtente = modello_di_DominioUtenteDAO.loadUtenteByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioUtenteDAO.delete(modello_di_DominioUtente);
			modello_di_dominio.dao.DocumentoDAO modello_di_DominioDocumentoDAO = lDAOFactory.getDocumentoDAO();
			modello_di_dominio.Documento modello_di_DominioDocumento = modello_di_DominioDocumentoDAO.loadDocumentoByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioDocumentoDAO.delete(modello_di_DominioDocumento);
			modello_di_dominio.dao.SlideDAO modello_di_DominioSlideDAO = lDAOFactory.getSlideDAO();
			modello_di_dominio.Slide modello_di_DominioSlide = modello_di_DominioSlideDAO.loadSlideByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioSlideDAO.delete(modello_di_DominioSlide);
			modello_di_dominio.dao.AppuntiDAO modello_di_DominioAppuntiDAO = lDAOFactory.getAppuntiDAO();
			modello_di_dominio.Appunti modello_di_DominioAppunti = modello_di_DominioAppuntiDAO.loadAppuntiByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioAppuntiDAO.delete(modello_di_DominioAppunti);
			modello_di_dominio.dao.CorsoDAO modello_di_DominioCorsoDAO = lDAOFactory.getCorsoDAO();
			modello_di_dominio.Corso modello_di_DominioCorso = modello_di_DominioCorsoDAO.loadCorsoByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioCorsoDAO.delete(modello_di_DominioCorso);
			modello_di_dominio.dao.FacoltaDAO modello_di_DominioFacoltaDAO = lDAOFactory.getFacoltaDAO();
			modello_di_dominio.Facolta modello_di_DominioFacolta = modello_di_DominioFacoltaDAO.loadFacoltaByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioFacoltaDAO.delete(modello_di_DominioFacolta);
			modello_di_dominio.dao.UniversitaDAO modello_di_DominioUniversitaDAO = lDAOFactory.getUniversitaDAO();
			modello_di_dominio.Universita modello_di_DominioUniversita = modello_di_DominioUniversitaDAO.loadUniversitaByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioUniversitaDAO.delete(modello_di_DominioUniversita);
			modello_di_dominio.dao.CorrezioneDAO modello_di_DominioCorrezioneDAO = lDAOFactory.getCorrezioneDAO();
			modello_di_dominio.Correzione modello_di_DominioCorrezione = modello_di_DominioCorrezioneDAO.loadCorrezioneByQuery(null, null);
			// Delete the persistent object
			modello_di_DominioCorrezioneDAO.delete(modello_di_DominioCorrezione);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProjectfinalData deleteProjectfinalData = new DeleteProjectfinalData();
			try {
				deleteProjectfinalData.deleteTestData();
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
