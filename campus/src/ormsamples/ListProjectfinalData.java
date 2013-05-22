/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class ListProjectfinalData {
	private static final int ROW_COUNT = 100;
	
public void listTestData() throws PersistentException {
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		System.out.println("Listing Utente...");
		modello_di_dominio.Utente[] modello_di_DominioUtentes = lDAOFactory.getUtenteDAO().listUtenteByQuery(null, null);
		int length = Math.min(modello_di_DominioUtentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioUtentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Documento...");
		modello_di_dominio.Documento[] modello_di_DominioDocumentos = lDAOFactory.getDocumentoDAO().listDocumentoByQuery(null, null);
		length = Math.min(modello_di_DominioDocumentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioDocumentos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Corso...");
		modello_di_dominio.Corso[] modello_di_DominioCorsos = lDAOFactory.getCorsoDAO().listCorsoByQuery(null, null);
		length = Math.min(modello_di_DominioCorsos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioCorsos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Facolta...");
		modello_di_dominio.Facolta[] modello_di_DominioFacoltas = lDAOFactory.getFacoltaDAO().listFacoltaByQuery(null, null);
		length = Math.min(modello_di_DominioFacoltas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioFacoltas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Universita...");
		modello_di_dominio.Universita[] modello_di_DominioUniversitas = lDAOFactory.getUniversitaDAO().listUniversitaByQuery(null, null);
		length = Math.min(modello_di_DominioUniversitas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioUniversitas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Correzione...");
		modello_di_dominio.Correzione[] modello_di_DominioCorreziones = lDAOFactory.getCorrezioneDAO().listCorrezioneByQuery(null, null);
		length = Math.min(modello_di_DominioCorreziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioCorreziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Voto...");
		modello_di_dominio.Voto[] modello_di_DominioVotos = lDAOFactory.getVotoDAO().listVotoByQuery(null, null);
		length = Math.min(modello_di_DominioVotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioVotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Commento...");
		modello_di_dominio.Commento[] modello_di_DominioCommentos = lDAOFactory.getCommentoDAO().listCommentoByQuery(null, null);
		length = Math.min(modello_di_DominioCommentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioCommentos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Corso_Utente...");
		modello_di_dominio.Corso_Utente[] modello_di_DominioCorso_Utentes = lDAOFactory.getCorso_UtenteDAO().listCorso_UtenteByQuery(null, null);
		length = Math.min(modello_di_DominioCorso_Utentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioCorso_Utentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Utente_Documento...");
		modello_di_dominio.Utente_Documento[] modello_di_DominioUtente_Documentos = lDAOFactory.getUtente_DocumentoDAO().listUtente_DocumentoByQuery(null, null);
		length = Math.min(modello_di_DominioUtente_Documentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioUtente_Documentos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException  {
		System.out.println("Listing Utente by Criteria...");
		modello_di_dominio.UtenteCriteria utenteCriteria = new modello_di_dominio.UtenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//utenteCriteria.ID.eq();
		utenteCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Utente[] modello_di_DominioUtentes = utenteCriteria.listUtente();
		int length =modello_di_DominioUtentes== null ? 0 : Math.min(modello_di_DominioUtentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioUtentes[i]);
		}
		System.out.println(length + " Utente record(s) retrieved."); 
		
		System.out.println("Listing Documento by Criteria...");
		modello_di_dominio.DocumentoCriteria documentoCriteria = new modello_di_dominio.DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//documentoCriteria.ID.eq();
		documentoCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Documento[] modello_di_DominioDocumentos = documentoCriteria.listDocumento();
		length =modello_di_DominioDocumentos== null ? 0 : Math.min(modello_di_DominioDocumentos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioDocumentos[i]);
		}
		System.out.println(length + " Documento record(s) retrieved."); 
		
		System.out.println("Listing Corso by Criteria...");
		modello_di_dominio.CorsoCriteria corsoCriteria = new modello_di_dominio.CorsoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//corsoCriteria.ID.eq();
		corsoCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Corso[] modello_di_DominioCorsos = corsoCriteria.listCorso();
		length =modello_di_DominioCorsos== null ? 0 : Math.min(modello_di_DominioCorsos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioCorsos[i]);
		}
		System.out.println(length + " Corso record(s) retrieved."); 
		
		System.out.println("Listing Facolta by Criteria...");
		modello_di_dominio.FacoltaCriteria facoltaCriteria = new modello_di_dominio.FacoltaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//facoltaCriteria.ID.eq();
		facoltaCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Facolta[] modello_di_DominioFacoltas = facoltaCriteria.listFacolta();
		length =modello_di_DominioFacoltas== null ? 0 : Math.min(modello_di_DominioFacoltas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioFacoltas[i]);
		}
		System.out.println(length + " Facolta record(s) retrieved."); 
		
		System.out.println("Listing Universita by Criteria...");
		modello_di_dominio.UniversitaCriteria universitaCriteria = new modello_di_dominio.UniversitaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//universitaCriteria.ID.eq();
		universitaCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Universita[] modello_di_DominioUniversitas = universitaCriteria.listUniversita();
		length =modello_di_DominioUniversitas== null ? 0 : Math.min(modello_di_DominioUniversitas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioUniversitas[i]);
		}
		System.out.println(length + " Universita record(s) retrieved."); 
		
		System.out.println("Listing Correzione by Criteria...");
		modello_di_dominio.CorrezioneCriteria correzioneCriteria = new modello_di_dominio.CorrezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//correzioneCriteria.ID.eq();
		correzioneCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Correzione[] modello_di_DominioCorreziones = correzioneCriteria.listCorrezione();
		length =modello_di_DominioCorreziones== null ? 0 : Math.min(modello_di_DominioCorreziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioCorreziones[i]);
		}
		System.out.println(length + " Correzione record(s) retrieved."); 
		
		System.out.println("Listing Voto by Criteria...");
		modello_di_dominio.VotoCriteria votoCriteria = new modello_di_dominio.VotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//votoCriteria.ID.eq();
		votoCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Voto[] modello_di_DominioVotos = votoCriteria.listVoto();
		length =modello_di_DominioVotos== null ? 0 : Math.min(modello_di_DominioVotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioVotos[i]);
		}
		System.out.println(length + " Voto record(s) retrieved."); 
		
		System.out.println("Listing Commento by Criteria...");
		modello_di_dominio.CommentoCriteria commentoCriteria = new modello_di_dominio.CommentoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//commentoCriteria.ID.eq();
		commentoCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Commento[] modello_di_DominioCommentos = commentoCriteria.listCommento();
		length =modello_di_DominioCommentos== null ? 0 : Math.min(modello_di_DominioCommentos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioCommentos[i]);
		}
		System.out.println(length + " Commento record(s) retrieved."); 
		
		System.out.println("Listing Corso_Utente by Criteria...");
		modello_di_dominio.Corso_UtenteCriteria corso_UtenteCriteria = new modello_di_dominio.Corso_UtenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//corso_UtenteCriteria.ID.eq();
		corso_UtenteCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Corso_Utente[] modello_di_DominioCorso_Utentes = corso_UtenteCriteria.listCorso_Utente();
		length =modello_di_DominioCorso_Utentes== null ? 0 : Math.min(modello_di_DominioCorso_Utentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioCorso_Utentes[i]);
		}
		System.out.println(length + " Corso_Utente record(s) retrieved."); 
		
		System.out.println("Listing Utente_Documento by Criteria...");
		modello_di_dominio.Utente_DocumentoCriteria utente_DocumentoCriteria = new modello_di_dominio.Utente_DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//utente_DocumentoCriteria.ID.eq();
		utente_DocumentoCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Utente_Documento[] modello_di_DominioUtente_Documentos = utente_DocumentoCriteria.listUtente_Documento();
		length =modello_di_DominioUtente_Documentos== null ? 0 : Math.min(modello_di_DominioUtente_Documentos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioUtente_Documentos[i]);
		}
		System.out.println(length + " Utente_Documento record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListProjectfinalData listProjectfinalData = new ListProjectfinalData();
			try {
				listProjectfinalData.listTestData();
				//listProjectfinalData.listByCriteria();
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
