package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.DocumentoDAO;

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
			documentoDAO.delete(d);
			ControllerRicerca.getInstance().removeDocumento(d);
			ControllerRicerca.getInstance().commitIndexingDocumento();
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
	public ArrayList<Documento> getListAllDocumentiByStringSearch(String ricerca, boolean soloFac, String sorting) throws PersistentException {
		TreeMap<Integer,Documento> treedocs = new TreeMap<Integer,Documento>();
		Documento[] temp = ControllerRicerca.getInstance().cercaDocumento("Nome", ricerca+"*");
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treedocs.put(temp[i].getID(), temp[i]);
			}
			/*if (soloFac) {
				for (int i=0; temp.length > i; i++) {
					if (temp[i].getFacolta() == ControllerUtente.getInstance().getUtente(1).getFacolta()) {
						treedocs.put(temp[i].getID(), temp[i]);
					}
				}
			} else {
				for (int i=0; temp.length > i; i++) {
					treedocs.put(temp[i].getID(), temp[i]);
				}
			}*/
		}
		temp = ControllerRicerca.getInstance().cercaDocumento("Descrizione", ricerca+"*");
		if (temp != null) {
			for (int i=0; temp.length > i; i++) {
				treedocs.put(temp[i].getID(), temp[i]);
			}
		}
		ArrayList<Documento> docs = new ArrayList<Documento>(treedocs.values());
		if (soloFac) {
			docs = filtraSoloUnaFac(docs, ControllerUtente.getInstance().getUtente(1).getFacolta().getID());
		}
		return sortBy(docs,sorting);
	}
	/**
	 * getListAllDocumentiByCorso
	 * @param indexFac
	 * @param indexCorso
	 * @param soloFac
	 * @param sorting
	 * @return
	 * @throws PersistentException
	 */
	public ArrayList<Documento> getListAllDocumentiByCorso(int indexFac, int indexCorso, boolean soloFac, String sorting) throws PersistentException {
		Documento[] temp = ControllerCorso.getInstance().getCorso(indexCorso).documentoCorso.toArray();
		ArrayList<Documento> docs = new ArrayList<Documento>();
		for (int i=0; temp.length > i; i++) {
			docs.add(temp[i]);
		}
		/*if (soloFac) {
			for (int i=0; temp.length > i; i++) {
				if (temp[i].getFacolta() == ControllerFacolta.getInstance().getFacolta(indexFac)) {
					docs.add(temp[i]);
				}
			}
		} else {
			for (int i=0; temp.length > i; i++) {
				docs.add(temp[i]);
			}
		}*/
		if (soloFac) {
			docs = filtraSoloUnaFac(docs, indexFac);
		}
		return sortBy(docs,sorting);
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
	
	private ArrayList<Documento> sortBy(ArrayList<Documento> docs, String sorting) {

		Comparator nome = new Comparator<Documento>() {

			/*public String leftPad(String stringToPad, String padder, Integer size) {

			    final StringBuilder strb = new StringBuilder(size.intValue());
			    final StringCharacterIterator sci = new StringCharacterIterator(padder);

			    while (strb.length() < (size.intValue() - stringToPad.length())) {
			        for (char ch = sci.first(); ch != CharacterIterator.DONE; ch = sci.next()) {
			            if (strb.length() < (size.intValue() - stringToPad.length())) {
			                strb.insert(strb.length(), String.valueOf(ch));
			            }
			        }
			    }

			    return strb.append(stringToPad).toString();
			}*/
			
		    @Override
		    public int compare(Documento obj1, Documento obj2) {
		    	return obj1.getNome().compareTo(obj2.getNome());
		    	/*
		        String o1 = obj1.getNome();
		        String o2 = obj2.getNome();
		        
		        int maxLen = 254;
		        String REGEX = "[0-9]+";
		        // both numbers
		        if (o1.matches("[1-9]+") && o2.matches("[1-9]+")) {
		            Integer integer1 = Integer.valueOf(o1);
		            Integer integer2 = Integer.valueOf(o2);
		            return integer1.compareTo(integer2);
		        }

		        // both string
		        if (o1.matches("[a-zA-Z]+") && o2.matches("[a-zA-Z]+")) {
		            return o1.compareTo(o2);
		        }

		        Pattern p = Pattern.compile(REGEX);
		        Matcher m1 = p.matcher(o1);
		        Matcher m2 = p.matcher(o2);

		        List<String> list = new ArrayList<String>();
		        while (m1.find()) {
		            list.add(m1.group());
		        }
		        for (String string : list) {
		            o1.replaceFirst(string, leftPad(string, "0", maxLen));
		        }

		        list.clear();

		        while (m2.find()) {
		            list.add(m2.group());
		        }
		        for (String string : list) {
		            o2.replaceFirst(string, leftPad(string, "0", maxLen));
		        }
		        return o1.compareTo(o2);
				*/
		    }

		};
		
		Comparator voto = new Comparator<Documento>() {

			@Override
		    public int compare(Documento obj1, Documento obj2) {
		        return Integer.compare(obj1.getVoto(), obj2.getVoto());
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
		
		//OMMAIGOD
		if (sorting.matches("nomeUP")) {
			Collections.sort(docs, nome);
		}
		if (sorting.matches("nomeDOWN")) {
			Collections.sort(docs, nome);
			Collections.reverse(docs);
		}
		if (sorting.matches("timestampUP")) {
			Collections.sort(docs, timestamp);
		}
		if (sorting.matches("timestampDOWN")) {
			Collections.sort(docs, timestamp);
			Collections.reverse(docs);
		}
		if (sorting.matches("votoUP")) {
			Collections.sort(docs, voto);
		}
		if (sorting.matches("votoDOWN")) {
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
