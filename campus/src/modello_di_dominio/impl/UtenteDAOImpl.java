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

public class UtenteDAOImpl implements modello_di_dominio.dao.UtenteDAO {
	public Utente loadUtenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente getUtenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUtenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente getUtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getUtenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Utente) session.load(modello_di_dominio.Utente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente getUtenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Utente) session.get(modello_di_dominio.Utente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Utente) session.load(modello_di_dominio.Utente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente getUtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Utente) session.get(modello_di_dominio.Utente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente[] listUtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente[] listUtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listUtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente[] listUtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente as Utente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Utente[]) list.toArray(new Utente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente[] listUtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente as Utente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Utente[]) list.toArray(new Utente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadUtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Utente[] utentes = listUtenteByQuery(session, condition, orderBy);
		if (utentes != null && utentes.length > 0)
			return utentes[0];
		else
			return null;
	}
	
	public Utente loadUtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Utente[] utentes = listUtenteByQuery(session, condition, orderBy, lockMode);
		if (utentes != null && utentes.length > 0)
			return utentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUtenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUtenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateUtenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente as Utente");
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
	
	public static java.util.Iterator iterateUtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Utente as Utente");
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
	
	public Utente createUtente() {
		return new modello_di_dominio.Utente();
	}
	
	public boolean save(modello_di_dominio.Utente utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Utente utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Utente utente)throws PersistentException {
		try {
			if(utente.getFacolta() != null) {
				utente.getFacolta().iscritto.remove(utente);
			}
			
			modello_di_dominio.Corso[] lCorsos = utente.corso.toArray();
			for(int i = 0; i < lCorsos.length; i++) {
				lCorsos[i].utenteCorso.remove(utente);
			}
			modello_di_dominio.Documento[] lDocumentoUtentes = utente.documentoUtente.toArray();
			for(int i = 0; i < lDocumentoUtentes.length; i++) {
				lDocumentoUtentes[i].setUtenteDocumento(null);
			}
			modello_di_dominio.Documento[] lUtentes = utente.utente.toArray();
			for(int i = 0; i < lUtentes.length; i++) {
				lUtentes[i].documentoPreferito.remove(utente);
			}
			modello_di_dominio.Correzione[] lCorrezioness = utente.correziones.toArray();
			for(int i = 0; i < lCorrezioness.length; i++) {
				lCorrezioness[i].setUtente(null);
			}
			return delete(utente);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Utente utente, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(utente.getFacolta() != null) {
				utente.getFacolta().iscritto.remove(utente);
			}
			
			modello_di_dominio.Corso[] lCorsos = utente.corso.toArray();
			for(int i = 0; i < lCorsos.length; i++) {
				lCorsos[i].utenteCorso.remove(utente);
			}
			modello_di_dominio.Documento[] lDocumentoUtentes = utente.documentoUtente.toArray();
			for(int i = 0; i < lDocumentoUtentes.length; i++) {
				lDocumentoUtentes[i].setUtenteDocumento(null);
			}
			modello_di_dominio.Documento[] lUtentes = utente.utente.toArray();
			for(int i = 0; i < lUtentes.length; i++) {
				lUtentes[i].documentoPreferito.remove(utente);
			}
			modello_di_dominio.Correzione[] lCorrezioness = utente.correziones.toArray();
			for(int i = 0; i < lCorrezioness.length; i++) {
				lCorrezioness[i].setUtente(null);
			}
			try {
				session.delete(utente);
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
	
	public boolean refresh(modello_di_dominio.Utente utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Utente utente) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(utente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Utente loadUtenteByCriteria(UtenteCriteria utenteCriteria) {
		Utente[] utentes = listUtenteByCriteria(utenteCriteria);
		if(utentes == null || utentes.length == 0) {
			return null;
		}
		return utentes[0];
	}
	
	public Utente[] listUtenteByCriteria(UtenteCriteria utenteCriteria) {
		return utenteCriteria.listUtente();
	}
}
