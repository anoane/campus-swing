package controller;

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
	
	//TODO: Da modificare aggiungere facolta
	public void creaDocumento(String nome, String descrizione,String path, Utente u, Corso c, Facolta f){
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
