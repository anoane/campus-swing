/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package modello_di_dominio;

import modello_di_dominio.impl.*;
import modello_di_dominio.dao.*;

public class DAOFactoryImpl extends DAOFactory {
	private UtenteDAO _utenteDAO = new UtenteDAOImpl();
	public UtenteDAO getUtenteDAO() {
		return _utenteDAO;
	}
	
	private DocumentoDAO _documentoDAO = new DocumentoDAOImpl();
	public DocumentoDAO getDocumentoDAO() {
		return _documentoDAO;
	}
	
	private SlideDAO _slideDAO = new SlideDAOImpl();
	public SlideDAO getSlideDAO() {
		return _slideDAO;
	}
	
	private AppuntiDAO _appuntiDAO = new AppuntiDAOImpl();
	public AppuntiDAO getAppuntiDAO() {
		return _appuntiDAO;
	}
	
	private CorsoDAO _corsoDAO = new CorsoDAOImpl();
	public CorsoDAO getCorsoDAO() {
		return _corsoDAO;
	}
	
	private FacoltaDAO _facoltaDAO = new FacoltaDAOImpl();
	public FacoltaDAO getFacoltaDAO() {
		return _facoltaDAO;
	}
	
}
