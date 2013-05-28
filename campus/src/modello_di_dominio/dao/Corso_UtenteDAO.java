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

public interface Corso_UtenteDAO {
	public Corso_Utente loadCorso_UtenteByORMID(int ID) throws PersistentException;
	public Corso_Utente getCorso_UtenteByORMID(int ID) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente getCorso_UtenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByORMID(PersistentSession session, int ID) throws PersistentException;
	public Corso_Utente getCorso_UtenteByORMID(PersistentSession session, int ID) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente getCorso_UtenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente[] listCorso_UtenteByQuery(String condition, String orderBy) throws PersistentException;
	public Corso_Utente[] listCorso_UtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente[] listCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Corso_Utente[] listCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByQuery(String condition, String orderBy) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso_Utente createCorso_Utente();
	public boolean save(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException;
	public boolean delete(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Corso_Utente corso_Utente, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException;
	public boolean evict(modello_di_dominio.Corso_Utente corso_Utente) throws PersistentException;
	public Corso_Utente loadCorso_UtenteByCriteria(Corso_UtenteCriteria corso_UtenteCriteria);
	public Corso_Utente[] listCorso_UtenteByCriteria(Corso_UtenteCriteria corso_UtenteCriteria);
}
