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

public interface FacoltaDAO {
	public Facolta loadFacoltaByORMID(int ID) throws PersistentException;
	public Facolta getFacoltaByORMID(int ID) throws PersistentException;
	public Facolta loadFacoltaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta getFacoltaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta loadFacoltaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Facolta getFacoltaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Facolta loadFacoltaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta getFacoltaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta[] listFacoltaByQuery(String condition, String orderBy) throws PersistentException;
	public Facolta[] listFacoltaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta[] listFacoltaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Facolta[] listFacoltaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta loadFacoltaByQuery(String condition, String orderBy) throws PersistentException;
	public Facolta loadFacoltaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta loadFacoltaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Facolta loadFacoltaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Facolta createFacolta();
	public boolean save(modello_di_dominio.Facolta facolta) throws PersistentException;
	public boolean delete(modello_di_dominio.Facolta facolta) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Facolta facolta) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Facolta facolta, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Facolta facolta) throws PersistentException;
	public boolean evict(modello_di_dominio.Facolta facolta) throws PersistentException;
	public Facolta loadFacoltaByCriteria(FacoltaCriteria facoltaCriteria);
	public Facolta[] listFacoltaByCriteria(FacoltaCriteria facoltaCriteria);
}
