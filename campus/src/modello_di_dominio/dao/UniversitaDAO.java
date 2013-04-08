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

public interface UniversitaDAO {
	public Universita loadUniversitaByORMID(int ID) throws PersistentException;
	public Universita getUniversitaByORMID(int ID) throws PersistentException;
	public Universita loadUniversitaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita getUniversitaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita loadUniversitaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Universita getUniversitaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Universita loadUniversitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita getUniversitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita[] listUniversitaByQuery(String condition, String orderBy) throws PersistentException;
	public Universita[] listUniversitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita[] listUniversitaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Universita[] listUniversitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita loadUniversitaByQuery(String condition, String orderBy) throws PersistentException;
	public Universita loadUniversitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita loadUniversitaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Universita loadUniversitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Universita createUniversita();
	public boolean save(modello_di_dominio.Universita universita) throws PersistentException;
	public boolean delete(modello_di_dominio.Universita universita) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Universita universita) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Universita universita, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Universita universita) throws PersistentException;
	public boolean evict(modello_di_dominio.Universita universita) throws PersistentException;
	public Universita loadUniversitaByCriteria(UniversitaCriteria universitaCriteria);
	public Universita[] listUniversitaByCriteria(UniversitaCriteria universitaCriteria);
}
