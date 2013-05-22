package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import modello_di_dominio.Corso;
import modello_di_dominio.Corso_Utente;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.Utente_Documento;
import modello_di_dominio.dao.Corso_UtenteDAO;
import modello_di_dominio.dao.DocumentoDAO;
import modello_di_dominio.dao.Utente_DocumentoDAO;

import org.apache.lucene.queryparser.classic.ParseException;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerDocumento extends AbstractController{
	
	private static ControllerDocumento instance;
	
	protected DocumentoDAO documentoDAO;
	/**
	 * Costruttore privato
	 */
	protected ControllerDocumento(){
		super();
		documentoDAO = DAOFactory.getDAOFactory().getDocumentoDAO();
	}
	/**
	 * creaDocumento
	 * @param nome String
	 * @param descrizione String
	 * @param path String
	 * @param discriminator String
	 * @param u Utente
	 * @param c Corso
	 * @param f Facolta
	 */
	public void creaDocumento(String nome, String descrizione,String path, String discriminator, Utente u, Corso c, Facolta f){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			Documento documento = documentoDAO.createDocumento();
			documento.setNome(nome);
			documento.setDescrizione(descrizione);
			documento.setPath(path);
			documento.setProprietario(u);
			documento.setCorso(c);
			documento.setFacolta(f);
			documento.setDiscriminator(discriminator);
			//Calendar cal = GregorianCalendar.getInstance();
			//Timestamp time = Timestamp.valueOf("2007-09-23 10:10:10.0");
			//System.out.println(time);
			//documento.setDatetime(time);
			documento.setDownloads(1);
			documentoDAO.save(documento);
			//Commit
			t.commit();
			ControllerRicerca.getInstance().aggiungiDocumento(documento);
			ControllerRicerca.getInstance().commitIndexingDocumento();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Incrementa il download di un documento
	 * @param docID
	 */
	public void incrementaDownloadDocumento(int docID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			Documento documento = documentoDAO.getDocumentoByORMID(docID);
			documento.setDownloads(documento.getDownloads()+1);
			documentoDAO.save(documento);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getDocumento
	 * @param ID
	 * @return
	 */
	public Documento getDocumento(int ID){
		try {
			Documento documento = documentoDAO.getDocumentoByORMID(ID);
			return documento;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * RemoveDocumento
	 * @param d
	 */
	public void removeDocumento(Documento d){
		try {
			//XXX:Serve?
			d.setProprietario(null); 
			ControllerRicerca.getInstance().removeDocumento(d);
			ControllerRicerca.getInstance().commitIndexingDocumento();
			d.getFacolta().documento.remove(d);
			d.getCorso().documentoCorso.remove(d);
			documentoDAO.delete(d);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerDocumento getInstance(){
		if(ControllerDocumento.instance == null)
			ControllerDocumento.instance = new ControllerDocumento();
		return ControllerDocumento.instance;
	}
	
	public boolean controlloVotato(Documento doc,Utente utente){
		boolean giaVotato = false;
		for(Utente u: doc.getUtentesVoto())
			if(u.equals(utente))
				giaVotato = true;
		return giaVotato;
	}
	
	public void votaDocumento(Documento d, Utente u, int voto){
		if(controlloVotato(d, u) == false)
			ControllerVoto.getInstance().votaDocumento(d, u, voto);
	}
	
	public ArrayList<Documento> getDocumentiPreferiti(Utente u) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		Utente_Documento ud = null;
		try {
			Utente_Documento[] temp = udDAO.listUtente_DocumentoByQuery("UtenteID = " + u.getID(), "timestamp DESC");
			ArrayList<Documento> docs = new ArrayList<Documento>();
			for (int i=0; temp.length > i; i++) {
				docs.add(temp[i].getDocumento());
			}
			return docs;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public Integer getIdDocumentoPreferito(Utente u, Documento d) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		Utente_DocumentoDAO udDAO = factory.getUtente_DocumentoDAO();
		Utente_Documento ud = null;
		try {
			ud = udDAO.loadUtente_DocumentoByQuery("DocumentoID = " + d.getID() + "AND UtenteID = " +u.getID(), null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return null;
		}
		return ud.getID();
	}
	
	
	/**
	 * getListAllDocumenti
	 * @return
	 */
	public ArrayList<Documento> getListAllDocumenti() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DocumentoDAO documentoDAO = factory.getDocumentoDAO();
		try {
			Documento[] temp = documentoDAO.listDocumentoByQuery(null, null);
			ArrayList<Documento> docs = new ArrayList<Documento>();
			for (int i=0; temp.length > i; i++) {
				docs.add(temp[i]);
			}
			return docs;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * getAllDocumentiByStringSearch
	 * @param ricerca
	 * @param soloFac
	 * @param sorting
	 * @return
	 * @throws PersistentException
	 */
	public ArrayList<Documento> getListAllDocumentiByStringSearch(String ricerca, boolean soloFac, String filtro, String sorting) throws PersistentException {
		TreeMap<Integer,Documento> treedocs = new TreeMap<Integer,Documento>();
		Documento[] temp = null;
		try {
			temp = ControllerRicerca.getInstance().cercaDocumento("Nome", ricerca+"*");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treedocs.put(temp[i].getID(), temp[i]);
			}
		}
		try {
			temp = ControllerRicerca.getInstance().cercaDocumento("Descrizione", ricerca+"*");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treedocs.put(temp[i].getID(), temp[i]);
			}
		}
		ArrayList<Documento> docs = new ArrayList<Documento>(treedocs.values());
		if (soloFac) {
			docs = filtraSoloUnaFac(docs, ControllerUtente.getInstance().getUtente(1).getFacolta().getID());
		}
		return sortBy(filtraPerTipo(docs,filtro),sorting);
	}
	/**
	 * getListAllDocumentiByCorso
	 * @param indexFac
	 * @param indexCorso
	 * @param soloFac
	 * @param sorting
	 * @param sorting2 
	 * @return
	 * @throws PersistentException
	 */
	public ArrayList<Documento> getListAllDocumentiByCorso(int indexFac, int indexCorso, boolean soloFac, String filtro, String sorting) throws PersistentException {
		Documento[] temp = ControllerCorso.getInstance().getCorso(indexCorso).documentoCorso.toArray();
		ArrayList<Documento> docs = new ArrayList<Documento>();
		for (int i=0; temp.length > i; i++) {
			docs.add(temp[i]);
		}
		if (soloFac) {
			docs = filtraSoloUnaFac(docs, indexFac);
		}
		return sortBy(filtraPerTipo(docs,filtro),sorting);
	}
	/**
	 * TODO: Questa funzione ha bisogno di un'ampia ristrutturazione
	 * 
	 * filtraSoloUnaFac
	 * @param docs
	 * @param index
	 * @return
	 */
	private ArrayList<Documento> filtraSoloUnaFac(ArrayList<Documento> docs, int index) {
		ArrayList<Documento> newdocs = new ArrayList<Documento>();
		for (int i=0; docs.size() > i; i++) {
			if (docs.get(i).getFacolta().getID() == index) {
				newdocs.add(docs.get(i));
			}
		}
		return newdocs;
	}
	
	public ArrayList<Documento> filtraPerTipo(ArrayList<Documento> docs, String filtro) {
		ArrayList<Documento> newdocs = new ArrayList<Documento>();
		for (int i=0; docs.size() > i; i++) {
			if (filtro.matches("all") || docs.get(i).getDiscriminator().matches(filtro)) {
				newdocs.add(docs.get(i));
			}
		}
		return newdocs;
	}
	
	public ArrayList<Documento> sortBy(ArrayList<Documento> docs, String sorting) {

		
		Comparator nome = new Comparator<Documento>() {
		    @Override
		    public int compare(Documento obj1, Documento obj2) {
		    	return obj1.getNome().compareTo(obj2.getNome());
		    }
		};
		
		Comparator voto = new Comparator<Documento>() {

			@Override
		    public int compare(Documento obj1, Documento obj2) {
		        return Float.compare(ControllerVoto.getInstance().calcolaVoto(obj1), ControllerVoto.getInstance().calcolaVoto(obj2));
		    }
		};
		
		Comparator download = new Comparator<Documento>() {

			@Override
		    public int compare(Documento obj1, Documento obj2) {
		        return Integer.compare(obj1.getDownloads(), obj2.getDownloads());
		    }
		};
		
		Comparator timestamp = new Comparator<Documento>() {

			@Override
		    public int compare(Documento obj1, Documento obj2) {
		        return obj1.getTimestamp().compareTo(obj2.getTimestamp());
		    }
		};
		
		if (sorting.matches("nomeUP")) {
			Collections.sort(docs, nome);
		}
		if (sorting.matches("nomeDOWN")) {
			Collections.sort(docs, nome);
			Collections.reverse(docs);
		}
		if (sorting.matches("timestampDOWN")) {
			Collections.sort(docs, timestamp);
		}
		if (sorting.matches("timestampUP")) {
			Collections.sort(docs, timestamp);
			Collections.reverse(docs);
		}
		if (sorting.matches("votoDOWN")) {
			Collections.sort(docs, voto);
		}
		if (sorting.matches("votoUP")) {
			Collections.sort(docs, voto);
			Collections.reverse(docs);
		}
		if (sorting.matches("downloadUP")) {
			Collections.sort(docs, download);
		}
		if (sorting.matches("downloadDOWN")) {
			Collections.sort(docs, download);
			Collections.reverse(docs);
		}
		return docs;
	}
}
