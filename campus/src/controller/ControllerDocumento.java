package controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.CorsoDAO;
import modello_di_dominio.dao.DocumentoDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerDocumento extends AbstractController{
	
	private static ControllerDocumento instance;
	
	protected ControllerDocumento(){
		super();
	}
	
	public void creaDocumento(String nome, String descrizione,String path, String discriminator, Utente u, Corso c, Facolta f){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			DocumentoDAO documentoDAO = factory.getDocumentoDAO();
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
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void incrementaDownloadDocumento(int docID){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			DocumentoDAO documentoDAO = factory.getDocumentoDAO();
			Documento documento = documentoDAO.getDocumentoByORMID(docID);
			documento.setDownloads(documento.getDownloads()+1);
			documentoDAO.save(documento);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Documento getDocumento(int ID){
		DAOFactory factory = DAOFactory.getDAOFactory();
		DocumentoDAO documentoDAO = factory.getDocumentoDAO();
		try {
			Documento documento = documentoDAO.getDocumentoByORMID(ID);
			return documento;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void removeDocumento(Documento d){
		DAOFactory factory = DAOFactory.getDAOFactory();
		DocumentoDAO documentoDAO = factory.getDocumentoDAO();
		try {
			d.setProprietario(null);
			documentoDAO.delete(d);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static ControllerDocumento getInstance(){
		if(ControllerDocumento.instance == null)
			ControllerDocumento.instance = new ControllerDocumento();
		return ControllerDocumento.instance;
	}
}
