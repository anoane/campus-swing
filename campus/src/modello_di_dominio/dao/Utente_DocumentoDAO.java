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

public interface Utente_DocumentoDAO {
	public Utente_Documento loadUtente_DocumentoByORMID(int ID) throws PersistentException;
	public Utente_Documento getUtente_DocumentoByORMID(int ID) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento getUtente_DocumentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Utente_Documento getUtente_DocumentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento getUtente_DocumentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento[] listUtente_DocumentoByQuery(String condition, String orderBy) throws PersistentException;
	public Utente_Documento[] listUtente_DocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento[] listUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Utente_Documento[] listUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByQuery(String condition, String orderBy) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente_Documento createUtente_Documento();
	public boolean save(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException;
	public boolean delete(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Utente_Documento utente_Documento, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException;
	public boolean evict(modello_di_dominio.Utente_Documento utente_Documento) throws PersistentException;
	public Utente_Documento loadUtente_DocumentoByCriteria(Utente_DocumentoCriteria utente_DocumentoCriteria);
	public Utente_Documento[] listUtente_DocumentoByCriteria(Utente_DocumentoCriteria utente_DocumentoCriteria);
}
