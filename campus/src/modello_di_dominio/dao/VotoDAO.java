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

public interface VotoDAO {
	public Voto loadVotoByORMID(int ID) throws PersistentException;
	public Voto getVotoByORMID(int ID) throws PersistentException;
	public Voto loadVotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto getVotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto loadVotoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Voto getVotoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Voto loadVotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto getVotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto[] listVotoByQuery(String condition, String orderBy) throws PersistentException;
	public Voto[] listVotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto[] listVotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Voto[] listVotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto loadVotoByQuery(String condition, String orderBy) throws PersistentException;
	public Voto loadVotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto loadVotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Voto loadVotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Voto createVoto();
	public boolean save(modello_di_dominio.Voto voto) throws PersistentException;
	public boolean delete(modello_di_dominio.Voto voto) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Voto voto) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Voto voto, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Voto voto) throws PersistentException;
	public boolean evict(modello_di_dominio.Voto voto) throws PersistentException;
	public Voto loadVotoByCriteria(VotoCriteria votoCriteria);
	public Voto[] listVotoByCriteria(VotoCriteria votoCriteria);
}
