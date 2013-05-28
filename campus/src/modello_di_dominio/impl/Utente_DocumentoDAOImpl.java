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

public class Utente_DocumentoDAOImpl implements modello_di_dominio.dao.Utente_DocumentoDAO {
	public Utente_Documento loadUtente_DocumentoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtente_DocumentoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento getUtente_DocumentoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUtente_DocumentoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtente_DocumentoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento getUtente_DocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUtente_DocumentoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Utente_Documento) session.load(modello_di_dominio.Utente_Documento.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento getUtente_DocumentoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Utente_Documento) session.get(modello_di_dominio.Utente_Documento.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Utente_Documento) session.load(modello_di_dominio.Utente_Documento.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento getUtente_DocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Utente_Documento) session.get(modello_di_dominio.Utente_Documento.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento[] listUtente_DocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUtente_DocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento[] listUtente_DocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUtente_DocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento[] listUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente_Documento as Utente_Documento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Utente_Documento[]) list.toArray(new Utente_Documento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento[] listUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente_Documento as Utente_Documento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Utente_Documento[]) list.toArray(new Utente_Documento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtente_DocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtente_DocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Utente_Documento[] utente_Documentos = listUtente_DocumentoByQuery(session, condition, orderBy);
		if (utente_Documentos != null && utente_Documentos.length > 0)
			return utente_Documentos[0];
		else
			return null;
	}
	
	public Utente_Documento loadUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Utente_Documento[] utente_Documentos = listUtente_DocumentoByQuery(session, condition, orderBy, lockMode);
		if (utente_Documentos != null && utente_Documentos.length > 0)
			return utente_Documentos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUtente_DocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUtente_DocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUtente_DocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUtente_DocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente_Documento as Utente_Documento");
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
	
	public static java.util.Iterator iterateUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente_Documento as Utente_Documento");
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
	
	public Utente_Documento createUtente_Documento() {
		return new modello_di_dominio.Utente_Documento();
	}
	
	public boolean save(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(utente_Documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(utente_Documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Utente_Documento utente_Documento)throws PersistentException {
		try {
			if(utente_Documento.getDocumento() != null) {
				utente_Documento.getDocumento().utentePreferito.remove(utente_Documento);
			}
			
			if(utente_Documento.getUtentePreferito() != null) {
				utente_Documento.getUtentePreferito().documentiPreferiti.remove(utente_Documento);
			}
			
			return delete(utente_Documento);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Utente_Documento utente_Documento, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(utente_Documento.getDocumento() != null) {
				utente_Documento.getDocumento().utentePreferito.remove(utente_Documento);
			}
			
			if(utente_Documento.getUtentePreferito() != null) {
				utente_Documento.getUtentePreferito().documentiPreferiti.remove(utente_Documento);
			}
			
			try {
				session.delete(utente_Documento);
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
	
	public boolean refresh(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(utente_Documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(utente_Documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente_Documento loadUtente_DocumentoByCriteria(Utente_DocumentoCriteria utente_DocumentoCriteria) {
		Utente_Documento[] utente_Documentos = listUtente_DocumentoByCriteria(utente_DocumentoCriteria);
		if(utente_Documentos == null || utente_Documentos.length == 0) {
			return null;
		}
		return utente_Documentos[0];
	}
	
	public Utente_Documento[] listUtente_DocumentoByCriteria(Utente_DocumentoCriteria utente_DocumentoCriteria) {
		return utente_DocumentoCriteria.listUtente_Documento();
	}
}
