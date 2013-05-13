/**
 * 
 */
package controller;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.dao.VotoDAO;

/**
 * @author mw
 *
 */
public class ControllerVoto extends AbstractController {
	
	/**
	 * 
	 */
	private static ControllerVoto instance;
	/**
	 * 
	 */
	private VotoDAO votoDAO;
	/**
	 * 
	 */
	protected ControllerVoto(){
		votoDAO = DAOFactory.getDAOFactory().getVotoDAO();
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerVoto getInstance(){
		if(ControllerVoto.instance == null)
			ControllerVoto.instance = new ControllerVoto();
		return ControllerVoto.instance;
	}
	
}
