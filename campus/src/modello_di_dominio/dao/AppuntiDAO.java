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

public interface AppuntiDAO {
	public Appunti loadAppuntiByORMID(int ID) throws PersistentException;
	public Appunti getAppuntiByORMID(int ID) throws PersistentException;
	public Appunti loadAppuntiByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti getAppuntiByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti loadAppuntiByORMID(PersistentSession session, int ID) throws PersistentException;
	public Appunti getAppuntiByORMID(PersistentSession session, int ID) throws PersistentException;
	public Appunti loadAppuntiByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti getAppuntiByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti[] listAppuntiByQuery(String condition, String orderBy) throws PersistentException;
	public Appunti[] listAppuntiByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti[] listAppuntiByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Appunti[] listAppuntiByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti loadAppuntiByQuery(String condition, String orderBy) throws PersistentException;
	public Appunti loadAppuntiByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti loadAppuntiByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Appunti loadAppuntiByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Appunti createAppunti();
	public boolean save(modello_di_dominio.Appunti appunti) throws PersistentException;
	public boolean delete(modello_di_dominio.Appunti appunti) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Appunti appunti) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Appunti appunti, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Appunti appunti) throws PersistentException;
	public boolean evict(modello_di_dominio.Appunti appunti) throws PersistentException;
	public Appunti loadAppuntiByCriteria(AppuntiCriteria appuntiCriteria);
	public Appunti[] listAppuntiByCriteria(AppuntiCriteria appuntiCriteria);
}
