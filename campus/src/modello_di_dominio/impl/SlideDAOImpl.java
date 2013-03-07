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
package modello_di_dominio.impl;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;
import modello_di_dominio.*;

public class SlideDAOImpl implements modello_di_dominio.dao.SlideDAO {
	public Slide loadSlideByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadSlideByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide getSlideByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getSlideByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadSlideByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide getSlideByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getSlideByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Slide) session.load(modello_di_dominio.Slide.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide getSlideByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Slide) session.get(modello_di_dominio.Slide.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Slide) session.load(modello_di_dominio.Slide.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide getSlideByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Slide) session.get(modello_di_dominio.Slide.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide[] listSlideByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listSlideByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide[] listSlideByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listSlideByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide[] listSlideByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Slide as Slide");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Slide[]) list.toArray(new Slide[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide[] listSlideByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Slide as Slide");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Slide[]) list.toArray(new Slide[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadSlideByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadSlideByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Slide[] slides = listSlideByQuery(session, condition, orderBy);
		if (slides != null && slides.length > 0)
			return slides[0];
		else
			return null;
	}
	
	public Slide loadSlideByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Slide[] slides = listSlideByQuery(session, condition, orderBy, lockMode);
		if (slides != null && slides.length > 0)
			return slides[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSlideByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateSlideByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSlideByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateSlideByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSlideByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Slide as Slide");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSlideByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Slide as Slide");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide createSlide() {
		return new modello_di_dominio.Slide();
	}
	
	public boolean save(modello_di_dominio.Slide slide) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(slide);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Slide slide) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(slide);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Slide slide)throws PersistentException {
		try {
			if(slide.getUtente() != null) {
				slide.getUtente().documento.remove(slide);
			}
			
			if(slide.getCorso() != null) {
				slide.getCorso().documento.remove(slide);
			}
			
			return delete(slide);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Slide slide, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(slide.getUtente() != null) {
				slide.getUtente().documento.remove(slide);
			}
			
			if(slide.getCorso() != null) {
				slide.getCorso().documento.remove(slide);
			}
			
			try {
				session.delete(slide);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(modello_di_dominio.Slide slide) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(slide);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Slide slide) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(slide);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Slide loadSlideByCriteria(SlideCriteria slideCriteria) {
		Slide[] slides = listSlideByCriteria(slideCriteria);
		if(slides == null || slides.length == 0) {
			return null;
		}
		return slides[0];
	}
	
	public Slide[] listSlideByCriteria(SlideCriteria slideCriteria) {
		return slideCriteria.listSlide();
	}
}
