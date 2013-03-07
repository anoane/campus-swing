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

public class AppuntiDAOImpl implements modello_di_dominio.dao.AppuntiDAO {
	public Appunti loadAppuntiByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadAppuntiByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti getAppuntiByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getAppuntiByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadAppuntiByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti getAppuntiByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getAppuntiByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Appunti) session.load(modello_di_dominio.Appunti.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti getAppuntiByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Appunti) session.get(modello_di_dominio.Appunti.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Appunti) session.load(modello_di_dominio.Appunti.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti getAppuntiByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Appunti) session.get(modello_di_dominio.Appunti.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti[] listAppuntiByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listAppuntiByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti[] listAppuntiByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listAppuntiByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti[] listAppuntiByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Appunti as Appunti");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Appunti[]) list.toArray(new Appunti[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti[] listAppuntiByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Appunti as Appunti");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Appunti[]) list.toArray(new Appunti[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadAppuntiByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadAppuntiByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Appunti[] appuntis = listAppuntiByQuery(session, condition, orderBy);
		if (appuntis != null && appuntis.length > 0)
			return appuntis[0];
		else
			return null;
	}
	
	public Appunti loadAppuntiByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Appunti[] appuntis = listAppuntiByQuery(session, condition, orderBy, lockMode);
		if (appuntis != null && appuntis.length > 0)
			return appuntis[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAppuntiByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateAppuntiByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAppuntiByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateAppuntiByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAppuntiByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Appunti as Appunti");
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
	
	public static java.util.Iterator iterateAppuntiByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Appunti as Appunti");
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
	
	public Appunti createAppunti() {
		return new modello_di_dominio.Appunti();
	}
	
	public boolean save(modello_di_dominio.Appunti appunti) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(appunti);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Appunti appunti) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(appunti);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Appunti appunti)throws PersistentException {
		try {
			if(appunti.getUtente() != null) {
				appunti.getUtente().documento.remove(appunti);
			}
			
			if(appunti.getCorso() != null) {
				appunti.getCorso().documento.remove(appunti);
			}
			
			return delete(appunti);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Appunti appunti, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(appunti.getUtente() != null) {
				appunti.getUtente().documento.remove(appunti);
			}
			
			if(appunti.getCorso() != null) {
				appunti.getCorso().documento.remove(appunti);
			}
			
			try {
				session.delete(appunti);
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
	
	public boolean refresh(modello_di_dominio.Appunti appunti) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(appunti);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Appunti appunti) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(appunti);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Appunti loadAppuntiByCriteria(AppuntiCriteria appuntiCriteria) {
		Appunti[] appuntis = listAppuntiByCriteria(appuntiCriteria);
		if(appuntis == null || appuntis.length == 0) {
			return null;
		}
		return appuntis[0];
	}
	
	public Appunti[] listAppuntiByCriteria(AppuntiCriteria appuntiCriteria) {
		return appuntiCriteria.listAppunti();
	}
}
