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

public class DocumentoDAOImpl implements modello_di_dominio.dao.DocumentoDAO {
	public Documento loadDocumentoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadDocumentoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento getDocumentoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getDocumentoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadDocumentoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento getDocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return getDocumentoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Documento) session.load(modello_di_dominio.Documento.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento getDocumentoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Documento) session.get(modello_di_dominio.Documento.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Documento) session.load(modello_di_dominio.Documento.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento getDocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Documento) session.get(modello_di_dominio.Documento.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento[] listDocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listDocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento[] listDocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return listDocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento[] listDocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Documento as Documento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Documento[]) list.toArray(new Documento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento[] listDocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Documento as Documento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Documento[]) list.toArray(new Documento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadDocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return loadDocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Documento[] documentos = listDocumentoByQuery(session, condition, orderBy);
		if (documentos != null && documentos.length > 0)
			return documentos[0];
		else
			return null;
	}
	
	public Documento loadDocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Documento[] documentos = listDocumentoByQuery(session, condition, orderBy, lockMode);
		if (documentos != null && documentos.length > 0)
			return documentos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDocumentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateDocumentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.ProjectfinalPersistentManager.instance().getSession();
			return iterateDocumentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Documento as Documento");
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
	
	public static java.util.Iterator iterateDocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Documento as Documento");
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
	
	public Documento createDocumento() {
		return new modello_di_dominio.Documento();
	}
	
	public boolean save(modello_di_dominio.Documento documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().saveObject(documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Documento documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().deleteObject(documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Documento documento)throws PersistentException {
		try {
			if(documento.getFacolta() != null) {
				documento.getFacolta().documento.remove(documento);
			}
			
			modello_di_dominio.Correzione[] lCorrezioness = documento.correziones.toArray();
			for(int i = 0; i < lCorrezioness.length; i++) {
				lCorrezioness[i].setDocumento(null);
			}
			if(documento.getCorso() != null) {
				documento.getCorso().documentoCorso.remove(documento);
			}
			
			modello_di_dominio.Voto[] lVotoss = documento.votos.toArray();
			for(int i = 0; i < lVotoss.length; i++) {
				lVotoss[i].setDocumento(null);
			}
			modello_di_dominio.Commento[] lCommentoss = documento.commentos.toArray();
			for(int i = 0; i < lCommentoss.length; i++) {
				lCommentoss[i].setDocumento(null);
			}
			if(documento.getProprietario() != null) {
				documento.getProprietario().documentiUtente.remove(documento);
			}
			
			modello_di_dominio.Utente_Documento[] lUtentePreferitos = documento.utentePreferito.toArray();
			for(int i = 0; i < lUtentePreferitos.length; i++) {
				lUtentePreferitos[i].setDocumento(null);
			}
			return delete(documento);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Documento documento, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(documento.getFacolta() != null) {
				documento.getFacolta().documento.remove(documento);
			}
			
			modello_di_dominio.Correzione[] lCorrezioness = documento.correziones.toArray();
			for(int i = 0; i < lCorrezioness.length; i++) {
				lCorrezioness[i].setDocumento(null);
			}
			if(documento.getCorso() != null) {
				documento.getCorso().documentoCorso.remove(documento);
			}
			
			modello_di_dominio.Voto[] lVotoss = documento.votos.toArray();
			for(int i = 0; i < lVotoss.length; i++) {
				lVotoss[i].setDocumento(null);
			}
			modello_di_dominio.Commento[] lCommentoss = documento.commentos.toArray();
			for(int i = 0; i < lCommentoss.length; i++) {
				lCommentoss[i].setDocumento(null);
			}
			if(documento.getProprietario() != null) {
				documento.getProprietario().documentiUtente.remove(documento);
			}
			
			modello_di_dominio.Utente_Documento[] lUtentePreferitos = documento.utentePreferito.toArray();
			for(int i = 0; i < lUtentePreferitos.length; i++) {
				lUtentePreferitos[i].setDocumento(null);
			}
			try {
				session.delete(documento);
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
	
	public boolean refresh(modello_di_dominio.Documento documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().refresh(documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Documento documento) throws PersistentException {
		try {
			modello_di_dominio.ProjectfinalPersistentManager.instance().getSession().evict(documento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Documento loadDocumentoByCriteria(DocumentoCriteria documentoCriteria) {
		Documento[] documentos = listDocumentoByCriteria(documentoCriteria);
		if(documentos == null || documentos.length == 0) {
			return null;
		}
		return documentos[0];
	}
	
	public Documento[] listDocumentoByCriteria(DocumentoCriteria documentoCriteria) {
		return documentoCriteria.listDocumento();
	}
}
