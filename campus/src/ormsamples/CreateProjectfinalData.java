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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : corso, commentos, votos, documentiPreferiti, correziones, documentiUtente, facolta
			modello_di_DominioUtenteDAO.save(modello_di_DominioUtente);
			modello_di_dominio.dao.DocumentoDAO modello_di_DominioDocumentoDAO = lDAOFactory.getDocumentoDAO();
			modello_di_dominio.Documento modello_di_DominioDocumento = modello_di_DominioDocumentoDAO.createDocumento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utentePreferito, proprietario, commentos, votos, downloads, timestamp, num_voti, voto, corso, correziones, facolta
			modello_di_DominioDocumentoDAO.save(modello_di_DominioDocumento);
			modello_di_dominio.dao.CorsoDAO modello_di_DominioCorsoDAO = lDAOFactory.getCorsoDAO();
			modello_di_dominio.Corso modello_di_DominioCorso = modello_di_DominioCorsoDAO.createCorso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : facolta, documentoCorso, utenteCorso
			modello_di_DominioCorsoDAO.save(modello_di_DominioCorso);
			modello_di_dominio.dao.FacoltaDAO modello_di_DominioFacoltaDAO = lDAOFactory.getFacoltaDAO();
			modello_di_dominio.Facolta modello_di_DominioFacolta = modello_di_DominioFacoltaDAO.createFacolta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : documento, corso, iscritto, universita
			modello_di_DominioFacoltaDAO.save(modello_di_DominioFacolta);
			modello_di_dominio.dao.UniversitaDAO modello_di_DominioUniversitaDAO = lDAOFactory.getUniversitaDAO();
			modello_di_dominio.Universita modello_di_DominioUniversita = modello_di_DominioUniversitaDAO.createUniversita();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : facolta
			modello_di_DominioUniversitaDAO.save(modello_di_DominioUniversita);
			modello_di_dominio.dao.CorrezioneDAO modello_di_DominioCorrezioneDAO = lDAOFactory.getCorrezioneDAO();
			modello_di_dominio.Correzione modello_di_DominioCorrezione = modello_di_DominioCorrezioneDAO.createCorrezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utente, documento, approvato
			modello_di_DominioCorrezioneDAO.save(modello_di_DominioCorrezione);
			modello_di_dominio.dao.VotoDAO modello_di_DominioVotoDAO = lDAOFactory.getVotoDAO();
			modello_di_dominio.Voto modello_di_DominioVoto = modello_di_DominioVotoDAO.createVoto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utente, documento, valore
			modello_di_DominioVotoDAO.save(modello_di_DominioVoto);
			modello_di_dominio.dao.CommentoDAO modello_di_DominioCommentoDAO = lDAOFactory.getCommentoDAO();
			modello_di_dominio.Commento modello_di_DominioCommento = modello_di_DominioCommentoDAO.createCommento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : utente, documento, rootID
			modello_di_DominioCommentoDAO.save(modello_di_DominioCommento);
			modello_di_dominio.dao.Corso_UtenteDAO modello_di_DominioCorso_UtenteDAO = lDAOFactory.getCorso_UtenteDAO();
			modello_di_dominio.Corso_Utente modello_di_DominioCorso_Utente = modello_di_DominioCorso_UtenteDAO.createCorso_Utente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : timestamp, corso, utente
			modello_di_DominioCorso_UtenteDAO.save(modello_di_DominioCorso_Utente);
			modello_di_dominio.dao.Utente_DocumentoDAO modello_di_DominioUtente_DocumentoDAO = lDAOFactory.getUtente_DocumentoDAO();
			modello_di_dominio.Utente_Documento modello_di_DominioUtente_Documento = modello_di_DominioUtente_DocumentoDAO.createUtente_Documento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : timestamp, utentePreferito, documento
			modello_di_DominioUtente_DocumentoDAO.save(modello_di_DominioUtente_Documento);
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
