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

public class CorrezioneDAOImpl implements modello_di_dominio.dao.CorrezioneDAO {
	public Correzione loadCorrezioneByORMID(int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorrezioneByORMID(session, ID, utente, documento);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione getCorrezioneByORMID(int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorrezioneByORMID(session, ID, utente, documento);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByORMID(int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorrezioneByORMID(session, ID, utente, documento, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione getCorrezioneByORMID(int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getCorrezioneByORMID(session, ID, utente, documento, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByORMID(PersistentSession session, int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento) throws PersistentException {
		try {
			Correzione correzione = new modello_di_dominio.Correzione();
			correzione.setID(ID);
			correzione.setUtente(utente);
			correzione.setDocumento(documento);
			
			return (Correzione) session.load(modello_di_dominio.Correzione.class, correzione);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione getCorrezioneByORMID(PersistentSession session, int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento) throws PersistentException {
		try {
			Correzione correzione = new modello_di_dominio.Correzione();
			correzione.setID(ID);
			correzione.setUtente(utente);
			correzione.setDocumento(documento);
			
			return (Correzione) session.get(modello_di_dominio.Correzione.class, correzione);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByORMID(PersistentSession session, int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Correzione correzione = new modello_di_dominio.Correzione();
			correzione.setID(ID);
			correzione.setUtente(utente);
			correzione.setDocumento(documento);
			
			return (Correzione) session.load(modello_di_dominio.Correzione.class, correzione, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione getCorrezioneByORMID(PersistentSession session, int ID, modello_di_dominio.Utente utente, modello_di_dominio.Documento documento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Correzione correzione = new modello_di_dominio.Correzione();
			correzione.setID(ID);
			correzione.setUtente(utente);
			correzione.setDocumento(documento);
			
			return (Correzione) session.get(modello_di_dominio.Correzione.class, correzione, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione[] listCorrezioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorrezioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione[] listCorrezioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listCorrezioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione[] listCorrezioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Correzione as Correzione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Correzione[]) list.toArray(new Correzione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione[] listCorrezioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Correzione as Correzione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Correzione[]) list.toArray(new Correzione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorrezioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadCorrezioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Correzione[] correziones = listCorrezioneByQuery(session, condition, orderBy);
		if (correziones != null && correziones.length > 0)
			return correziones[0];
		else
			return null;
	}
	
	public Correzione loadCorrezioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Correzione[] correziones = listCorrezioneByQuery(session, condition, orderBy, lockMode);
		if (correziones != null && correziones.length > 0)
			return correziones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCorrezioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorrezioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorrezioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateCorrezioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCorrezioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Correzione as Correzione");
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
	
	public static java.util.Iterator iterateCorrezioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Correzione as Correzione");
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
	
	public Correzione createCorrezione() {
		return new modello_di_dominio.Correzione();
	}
	
	public boolean save(modello_di_dominio.Correzione correzione) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(correzione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Correzione correzione) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(correzione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Correzione correzione)throws PersistentException {
		try {
			modello_di_dominio.Utente utente = correzione.getUtente();
			if(correzione.getUtente() != null) {
				correzione.getUtente().correziones.remove(correzione);
			}
			correzione.setORM_Utente(utente);
			
			modello_di_dominio.Documento documento = correzione.getDocumento();
			if(correzione.getDocumento() != null) {
				correzione.getDocumento().correziones.remove(correzione);
			}
			correzione.setORM_Documento(documento);
			
			return delete(correzione);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Correzione correzione, org.orm.PersistentSession session)throws PersistentException {
		try {
			modello_di_dominio.Utente utente = correzione.getUtente();
			if(correzione.getUtente() != null) {
				correzione.getUtente().correziones.remove(correzione);
			}
			correzione.setORM_Utente(utente);
			
			modello_di_dominio.Documento documento = correzione.getDocumento();
			if(correzione.getDocumento() != null) {
				correzione.getDocumento().correziones.remove(correzione);
			}
			correzione.setORM_Documento(documento);
			
			try {
				session.delete(correzione);
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
	
	public boolean refresh(modello_di_dominio.Correzione correzione) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(correzione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Correzione correzione) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(correzione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Correzione loadCorrezioneByCriteria(CorrezioneCriteria correzioneCriteria) {
		Correzione[] correziones = listCorrezioneByCriteria(correzioneCriteria);
		if(correziones == null || correziones.length == 0) {
			return null;
		}
		return correziones[0];
	}
	
	public Correzione[] listCorrezioneByCriteria(CorrezioneCriteria correzioneCriteria) {
		return correzioneCriteria.listCorrezione();
	}
}
