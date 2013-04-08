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

public interface CorsoDAO {
	public Corso loadCorsoByORMID(int ID) throws PersistentException;
	public Corso getCorsoByORMID(int ID) throws PersistentException;
	public Corso loadCorsoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso getCorsoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso loadCorsoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Corso getCorsoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Corso loadCorsoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso getCorsoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso[] listCorsoByQuery(String condition, String orderBy) throws PersistentException;
	public Corso[] listCorsoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso[] listCorsoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Corso[] listCorsoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso loadCorsoByQuery(String condition, String orderBy) throws PersistentException;
	public Corso loadCorsoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso loadCorsoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Corso loadCorsoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Corso createCorso();
	public boolean save(modello_di_dominio.Corso corso) throws PersistentException;
	public boolean delete(modello_di_dominio.Corso corso) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Corso corso) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Corso corso, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Corso corso) throws PersistentException;
	public boolean evict(modello_di_dominio.Corso corso) throws PersistentException;
	public Corso loadCorsoByCriteria(CorsoCriteria corsoCriteria);
	public Corso[] listCorsoByCriteria(CorsoCriteria corsoCriteria);
}
