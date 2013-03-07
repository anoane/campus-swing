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

public class CorsoDAOImpl implements modello_di_dominio.dao.CorsoDAO {
	public Corso loadCorsoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorsoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso getCorsoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorsoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorsoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso getCorsoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorsoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Corso) session.load(modello_di_dominio.Corso.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso getCorsoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Corso) session.get(modello_di_dominio.Corso.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Corso) session.load(modello_di_dominio.Corso.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso getCorsoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Corso) session.get(modello_di_dominio.Corso.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso[] listCorsoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorsoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso[] listCorsoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorsoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso[] listCorsoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso as Corso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Corso[]) list.toArray(new Corso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso[] listCorsoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso as Corso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Corso[]) list.toArray(new Corso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorsoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorsoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Corso[] corsos = listCorsoByQuery(session, condition, orderBy);
		if (corsos != null && corsos.length > 0)
			return corsos[0];
		else
			return null;
	}
	
	public Corso loadCorsoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Corso[] corsos = listCorsoByQuery(session, condition, orderBy, lockMode);
		if (corsos != null && corsos.length > 0)
			return corsos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCorsoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorsoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorsoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorsoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorsoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso as Corso");
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
	
	public static java.util.Iterator iterateCorsoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Corso as Corso");
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
	
	public Corso createCorso() {
		return new modello_di_dominio.Corso();
	}
	
	public boolean save(modello_di_dominio.Corso corso) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(corso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Corso corso) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(corso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Corso corso)throws PersistentException {
		try {
			if(corso.getFacolta() != null) {
				corso.getFacolta().corso.remove(corso);
			}
			
			modello_di_dominio.Utente[] lUtentes = corso.utente.toArray();
			for(int i = 0; i < lUtentes.length; i++) {
				lUtentes[i].corso.remove(corso);
			}
			modello_di_dominio.Documento[] lDocumentos = corso.documento.toArray();
			for(int i = 0; i < lDocumentos.length; i++) {
				lDocumentos[i].setCorso(null);
			}
			return delete(corso);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Corso corso, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(corso.getFacolta() != null) {
				corso.getFacolta().corso.remove(corso);
			}
			
			modello_di_dominio.Utente[] lUtentes = corso.utente.toArray();
			for(int i = 0; i < lUtentes.length; i++) {
				lUtentes[i].corso.remove(corso);
			}
			modello_di_dominio.Documento[] lDocumentos = corso.documento.toArray();
			for(int i = 0; i < lDocumentos.length; i++) {
				lDocumentos[i].setCorso(null);
			}
			try {
				session.delete(corso);
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
	
	public boolean refresh(modello_di_dominio.Corso corso) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(corso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Corso corso) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(corso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Corso loadCorsoByCriteria(CorsoCriteria corsoCriteria) {
		Corso[] corsos = listCorsoByCriteria(corsoCriteria);
		if(corsos == null || corsos.length == 0) {
			return null;
		}
		return corsos[0];
	}
	
	public Corso[] listCorsoByCriteria(CorsoCriteria corsoCriteria) {
		return corsoCriteria.listCorso();
	}
}
