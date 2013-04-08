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
		
		System.out.println("Listing Slide...");
		modello_di_dominio.Slide[] modello_di_DominioSlides = lDAOFactory.getSlideDAO().listSlideByQuery(null, null);
		length = Math.min(modello_di_DominioSlides.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioSlides[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Appunti...");
		modello_di_dominio.Appunti[] modello_di_DominioAppuntis = lDAOFactory.getAppuntiDAO().listAppuntiByQuery(null, null);
		length = Math.min(modello_di_DominioAppuntis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modello_di_DominioAppuntis[i]);
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
		
		System.out.println("Listing Slide by Criteria...");
		modello_di_dominio.SlideCriteria slideCriteria = new modello_di_dominio.SlideCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//slideCriteria.ID.eq();
		slideCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Slide[] modello_di_DominioSlides = slideCriteria.listSlide();
		length =modello_di_DominioSlides== null ? 0 : Math.min(modello_di_DominioSlides.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioSlides[i]);
		}
		System.out.println(length + " Slide record(s) retrieved."); 
		
		System.out.println("Listing Appunti by Criteria...");
		modello_di_dominio.AppuntiCriteria appuntiCriteria = new modello_di_dominio.AppuntiCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//appuntiCriteria.ID.eq();
		appuntiCriteria.setMaxResults(ROW_COUNT);
		modello_di_dominio.Appunti[] modello_di_DominioAppuntis = appuntiCriteria.listAppunti();
		length =modello_di_DominioAppuntis== null ? 0 : Math.min(modello_di_DominioAppuntis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modello_di_DominioAppuntis[i]);
		}
		System.out.println(length + " Appunti record(s) retrieved."); 
		
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
