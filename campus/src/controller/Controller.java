package controller;

public class Controller extends AbstractController {

	public static int loadNumeroCorsiSeguiti() {
		modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
		modello_di_dominio.dao.CorsoDAO modello_di_DominioCorsoDAO = lDAOFactory.getCorsoDAO();
		//modello_di_DominioCorsoDAO.
		return 7;
	}
	
}
