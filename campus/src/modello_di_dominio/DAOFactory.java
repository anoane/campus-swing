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

import modello_di_dominio.dao.*;

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract UtenteDAO getUtenteDAO();
	public abstract DocumentoDAO getDocumentoDAO();
	public abstract SlideDAO getSlideDAO();
	public abstract AppuntiDAO getAppuntiDAO();
	public abstract CorsoDAO getCorsoDAO();
	public abstract FacoltaDAO getFacoltaDAO();
	public abstract UniversitaDAO getUniversitaDAO();
	public abstract CorrezioneDAO getCorrezioneDAO();
}

