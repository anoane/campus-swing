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

public class UniversitaDAOImpl implements modello_di_dominio.dao.UniversitaDAO {
	public Universita loadUniversitaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUniversitaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita getUniversitaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUniversitaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUniversitaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita getUniversitaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUniversitaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Universita) session.load(modello_di_dominio.Universita.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita getUniversitaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Universita) session.get(modello_di_dominio.Universita.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Universita) session.load(modello_di_dominio.Universita.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita getUniversitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Universita) session.get(modello_di_dominio.Universita.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita[] listUniversitaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUniversitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita[] listUniversitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUniversitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita[] listUniversitaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Universita as Universita");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Universita[]) list.toArray(new Universita[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita[] listUniversitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Universita as Universita");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Universita[]) list.toArray(new Universita[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUniversitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUniversitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Universita[] universitas = listUniversitaByQuery(session, condition, orderBy);
		if (universitas != null && universitas.length > 0)
			return universitas[0];
		else
			return null;
	}
	
	public Universita loadUniversitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Universita[] universitas = listUniversitaByQuery(session, condition, orderBy, lockMode);
		if (universitas != null && universitas.length > 0)
			return universitas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUniversitaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUniversitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUniversitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUniversitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUniversitaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Universita as Universita");
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
	
	public static java.util.Iterator iterateUniversitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Universita as Universita");
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
	
	public Universita createUniversita() {
		return new modello_di_dominio.Universita();
	}
	
	public boolean save(modello_di_dominio.Universita universita) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(universita);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Universita universita) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(universita);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Universita universita)throws PersistentException {
		try {
			modello_di_dominio.Facolta[] lFacoltas = universita.facolta.toArray();
			for(int i = 0; i < lFacoltas.length; i++) {
				lFacoltas[i].setUniversita(null);
			}
			return delete(universita);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Universita universita, org.orm.PersistentSession session)throws PersistentException {
		try {
			modello_di_dominio.Facolta[] lFacoltas = universita.facolta.toArray();
			for(int i = 0; i < lFacoltas.length; i++) {
				lFacoltas[i].setUniversita(null);
			}
			try {
				session.delete(universita);
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
	
	public boolean refresh(modello_di_dominio.Universita universita) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(universita);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Universita universita) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(universita);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Universita loadUniversitaByCriteria(UniversitaCriteria universitaCriteria) {
		Universita[] universitas = listUniversitaByCriteria(universitaCriteria);
		if(universitas == null || universitas.length == 0) {
			return null;
		}
		return universitas[0];
	}
	
	public Universita[] listUniversitaByCriteria(UniversitaCriteria universitaCriteria) {
		return universitaCriteria.listUniversita();
	}
}
