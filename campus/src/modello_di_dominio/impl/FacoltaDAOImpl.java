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

public class FacoltaDAOImpl implements modello_di_dominio.dao.FacoltaDAO {
	public Facolta loadFacoltaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadFacoltaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta getFacoltaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getFacoltaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadFacoltaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta getFacoltaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getFacoltaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Facolta) session.load(modello_di_dominio.Facolta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta getFacoltaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Facolta) session.get(modello_di_dominio.Facolta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facolta) session.load(modello_di_dominio.Facolta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta getFacoltaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facolta) session.get(modello_di_dominio.Facolta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta[] listFacoltaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listFacoltaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta[] listFacoltaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listFacoltaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta[] listFacoltaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Facolta as Facolta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Facolta[]) list.toArray(new Facolta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta[] listFacoltaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Facolta as Facolta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Facolta[]) list.toArray(new Facolta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadFacoltaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadFacoltaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Facolta[] facoltas = listFacoltaByQuery(session, condition, orderBy);
		if (facoltas != null && facoltas.length > 0)
			return facoltas[0];
		else
			return null;
	}
	
	public Facolta loadFacoltaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Facolta[] facoltas = listFacoltaByQuery(session, condition, orderBy, lockMode);
		if (facoltas != null && facoltas.length > 0)
			return facoltas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFacoltaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateFacoltaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacoltaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateFacoltaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacoltaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Facolta as Facolta");
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
	
	public static java.util.Iterator iterateFacoltaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Facolta as Facolta");
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
	
	public Facolta createFacolta() {
		return new modello_di_dominio.Facolta();
	}
	
	public boolean save(modello_di_dominio.Facolta facolta) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(facolta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Facolta facolta) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(facolta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Facolta facolta)throws PersistentException {
		try {
			modello_di_dominio.Corso[] lCorsos = facolta.corso.toArray();
			for(int i = 0; i < lCorsos.length; i++) {
				lCorsos[i].setFacolta(null);
			}
			return delete(facolta);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Facolta facolta, org.orm.PersistentSession session)throws PersistentException {
		try {
			modello_di_dominio.Corso[] lCorsos = facolta.corso.toArray();
			for(int i = 0; i < lCorsos.length; i++) {
				lCorsos[i].setFacolta(null);
			}
			try {
				session.delete(facolta);
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
	
	public boolean refresh(modello_di_dominio.Facolta facolta) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(facolta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Facolta facolta) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(facolta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Facolta loadFacoltaByCriteria(FacoltaCriteria facoltaCriteria) {
		Facolta[] facoltas = listFacoltaByCriteria(facoltaCriteria);
		if(facoltas == null || facoltas.length == 0) {
			return null;
		}
		return facoltas[0];
	}
	
	public Facolta[] listFacoltaByCriteria(FacoltaCriteria facoltaCriteria) {
		return facoltaCriteria.listFacolta();
	}
}
