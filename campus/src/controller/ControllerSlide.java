package controller;

import modello_di_dominio.Corso;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Slide;
import modello_di_dominio.Utente;
import modello_di_dominio.dao.SlideDAO;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class ControllerSlide extends ControllerDocumento {
	
	private static ControllerSlide instance;
	
	protected ControllerSlide(){
		super();
	}
	
	public void creaSlide(String nome, String descrizione,String path, Utente u, Corso c){
		try {
			PersistentTransaction t = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().beginTransaction();
			DAOFactory factory = DAOFactory.getDAOFactory();
			SlideDAO slideDAO = factory.getSlideDAO();
			Slide slide = slideDAO.createSlide();
			slide.setNome(nome);
			slide.setDescrizione(descrizione);
			slide.setPath(path);
			slide.setProprietario(u);
			slide.setCorso(c);
			slideDAO.save(slide);
			//Commit
			t.commit();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static ControllerSlide getInstance(){
		if(ControllerSlide.instance == null)
			ControllerSlide.instance = new ControllerSlide();
		return ControllerSlide.instance;
	}

}
