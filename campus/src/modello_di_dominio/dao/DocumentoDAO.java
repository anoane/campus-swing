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
package modello_di_dominio.dao;

import org.orm.*;
import modello_di_dominio.*;

public interface DocumentoDAO {
	public Documento loadDocumentoByORMID(int ID) throws PersistentException;
	public Documento getDocumentoByORMID(int ID) throws PersistentException;
	public Documento loadDocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento getDocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento loadDocumentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Documento getDocumentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Documento loadDocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento getDocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento[] listDocumentoByQuery(String condition, String orderBy) throws PersistentException;
	public Documento[] listDocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento[] listDocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Documento[] listDocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento loadDocumentoByQuery(String condition, String orderBy) throws PersistentException;
	public Documento loadDocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento loadDocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Documento loadDocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Documento createDocumento();
	public boolean save(modello_di_dominio.Documento documento) throws PersistentException;
	public boolean delete(modello_di_dominio.Documento documento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Documento documento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Documento documento, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Documento documento) throws PersistentException;
	public boolean evict(modello_di_dominio.Documento documento) throws PersistentException;
	public Documento loadDocumentoByCriteria(DocumentoCriteria documentoCriteria);
	public Documento[] listDocumentoByCriteria(DocumentoCriteria documentoCriteria);
}
