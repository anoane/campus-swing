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

public class Corso_UtenteDAOImpl implements modello_di_dominio.dao.Corso_UtenteDAO {
	public Corso_Utente loadCorso_UtenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorso_UtenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente getCorso_UtenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorso_UtenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorso_UtenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente getCorso_UtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorso_UtenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Corso_Utente) session.load(modello_di_dominio.Corso_Utente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente getCorso_UtenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Corso_Utente) session.get(modello_di_dominio.Corso_Utente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Corso_Utente) session.load(modello_di_dominio.Corso_Utente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente getCorso_UtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Corso_Utente) session.get(modello_di_dominio.Corso_Utente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente[] listCorso_UtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorso_UtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente[] listCorso_UtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorso_UtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente[] listCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso_Utente as Corso_Utente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Corso_Utente[]) list.toArray(new Corso_Utente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente[] listCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso_Utente as Corso_Utente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Corso_Utente[]) list.toArray(new Corso_Utente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorso_UtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorso_UtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Corso_Utente[] corso_Utentes = listCorso_UtenteByQuery(session, condition, orderBy);
		if (corso_Utentes != null && corso_Utentes.length > 0)
			return corso_Utentes[0];
		else
			return null;
	}
	
	public Corso_Utente loadCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Corso_Utente[] corso_Utentes = listCorso_UtenteByQuery(session, condition, orderBy, lockMode);
		if (corso_Utentes != null && corso_Utentes.length > 0)
			return corso_Utentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCorso_UtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorso_UtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorso_UtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorso_UtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso_Utente as Corso_Utente");
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
	
	public static java.util.Iterator iterateCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso_Utente as Corso_Utente");
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
	
	public Corso_Utente createCorso_Utente() {
		return new modello_di_dominio.Corso_Utente();
	}
	
	public boolean save(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(corso_Utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(corso_Utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Corso_Utente corso_Utente)throws PersistentException {
		try {
			if(corso_Utente.getUtente() != null) {
				corso_Utente.getUtente().corso.remove(corso_Utente);
			}
			
			if(corso_Utente.getCorso() != null) {
				corso_Utente.getCorso().utenteCorso.remove(corso_Utente);
			}
			
			return delete(corso_Utente);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Corso_Utente corso_Utente, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(corso_Utente.getUtente() != null) {
				corso_Utente.getUtente().corso.remove(corso_Utente);
			}
			
			if(corso_Utente.getCorso() != null) {
				corso_Utente.getCorso().utenteCorso.remove(corso_Utente);
			}
			
			try {
				session.delete(corso_Utente);
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
	
	public boolean refresh(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(corso_Utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(corso_Utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso_Utente loadCorso_UtenteByCriteria(Corso_UtenteCriteria corso_UtenteCriteria) {
		Corso_Utente[] corso_Utentes = listCorso_UtenteByCriteria(corso_UtenteCriteria);
		if(corso_Utentes == null || corso_Utentes.length == 0) {
			return null;
		}
		return corso_Utentes[0];
	}
	
	public Corso_Utente[] listCorso_UtenteByCriteria(Corso_UtenteCriteria corso_UtenteCriteria) {
		return corso_UtenteCriteria.listCorso_Utente();
	}
}
