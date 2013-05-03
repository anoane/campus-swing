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

public interface UtenteDAO {
	public Utente loadUtenteByORMID(int ID) throws PersistentException;
	public Utente getUtenteByORMID(int ID) throws PersistentException;
	public Utente loadUtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente getUtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente loadUtenteByORMID(PersistentSession session, int ID) throws PersistentException;
	public Utente getUtenteByORMID(PersistentSession session, int ID) throws PersistentException;
	public Utente loadUtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente getUtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente[] listUtenteByQuery(String condition, String orderBy) throws PersistentException;
	public Utente[] listUtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente[] listUtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Utente[] listUtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente loadUtenteByQuery(String condition, String orderBy) throws PersistentException;
	public Utente loadUtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente loadUtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Utente loadUtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Utente createUtente();
	public boolean save(modello_di_dominio.Utente utente) throws PersistentException;
	public boolean delete(modello_di_dominio.Utente utente) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Utente utente) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Utente utente, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Utente utente) throws PersistentException;
	public boolean evict(modello_di_dominio.Utente utente) throws PersistentException;
	public Utente loadUtenteByCriteria(UtenteCriteria utenteCriteria);
	public Utente[] listUtenteByCriteria(UtenteCriteria utenteCriteria);
}
