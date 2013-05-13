package controller;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.dao.CommentoDAO;

/**
 * 
 * @author mw
 *
 */
public class ControllerCommento extends AbstractController {
	/**
	 * 
	 */
	private static ControllerCommento instance;
	/**
	 * 
	 */
	private CommentoDAO commentoDAO;
	/**
	 * 
	 */
	protected ControllerCommento(){
		commentoDAO = DAOFactory.getDAOFactory().getCommentoDAO();
	}
	/**
	 * getInstance
	 * @return
	 */
	public static ControllerCommento getInstance(){
		if(ControllerCommento.instance == null)
			ControllerCommento.instance = new ControllerCommento();
		return ControllerCommento.instance;
	}
}
