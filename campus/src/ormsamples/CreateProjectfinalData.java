/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateProjectfinalData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
		try {
			modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
			modello_di_dominio.dao.UtenteDAO modello_di_DominioUtenteDAO = lDAOFactory.getUtenteDAO();
			modello_di_dominio.Utente modello_di_DominioUtente = modello_di_DominioUtenteDAO.createUtente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : documentoPreferito, correziones, documentoUtente, corso, facolta
			modello_di_DominioUtenteDAO.save(modello_di_DominioUtente);
			modello_di_dominio.dao.DocumentoDAO modello_di_DominioDocumentoDAO = lDAOFactory.getDocumentoDAO();
			modello_di_dominio.Documento modello_di_DominioDocumento = modello_di_DominioDocumentoDAO.createDocumento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utenteDocumento, utente, corso, correziones
			modello_di_DominioDocumentoDAO.save(modello_di_DominioDocumento);
			modello_di_dominio.dao.SlideDAO modello_di_DominioSlideDAO = lDAOFactory.getSlideDAO();
			modello_di_dominio.Slide modello_di_DominioSlide = modello_di_DominioSlideDAO.createSlide();
			// Initialize the properties of the persistent object here
			modello_di_DominioSlideDAO.save(modello_di_DominioSlide);
			modello_di_dominio.dao.AppuntiDAO modello_di_DominioAppuntiDAO = lDAOFactory.getAppuntiDAO();
			modello_di_dominio.Appunti modello_di_DominioAppunti = modello_di_DominioAppuntiDAO.createAppunti();
			// Initialize the properties of the persistent object here
			modello_di_DominioAppuntiDAO.save(modello_di_DominioAppunti);
			modello_di_dominio.dao.CorsoDAO modello_di_DominioCorsoDAO = lDAOFactory.getCorsoDAO();
			modello_di_dominio.Corso modello_di_DominioCorso = modello_di_DominioCorsoDAO.createCorso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : documentoCorso, utenteCorso
			modello_di_DominioCorsoDAO.save(modello_di_DominioCorso);
			modello_di_dominio.dao.FacoltaDAO modello_di_DominioFacoltaDAO = lDAOFactory.getFacoltaDAO();
			modello_di_dominio.Facolta modello_di_DominioFacolta = modello_di_DominioFacoltaDAO.createFacolta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : iscritto, universita
			modello_di_DominioFacoltaDAO.save(modello_di_DominioFacolta);
			modello_di_dominio.dao.UniversitaDAO modello_di_DominioUniversitaDAO = lDAOFactory.getUniversitaDAO();
			modello_di_dominio.Universita modello_di_DominioUniversita = modello_di_DominioUniversitaDAO.createUniversita();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : facolta
			modello_di_DominioUniversitaDAO.save(modello_di_DominioUniversita);
			modello_di_dominio.dao.CorrezioneDAO modello_di_DominioCorrezioneDAO = lDAOFactory.getCorrezioneDAO();
			modello_di_dominio.Correzione modello_di_DominioCorrezione = modello_di_DominioCorrezioneDAO.createCorrezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utente, documento, approvato
			modello_di_DominioCorrezioneDAO.save(modello_di_DominioCorrezione);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProjectfinalData createProjectfinalData = new CreateProjectfinalData();
			try {
				createProjectfinalData.createTestData();
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
