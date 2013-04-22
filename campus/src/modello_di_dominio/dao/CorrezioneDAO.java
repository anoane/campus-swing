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

public interface CorrezioneDAO {
	public Correzione loadCorrezioneByORMID(int ID) throws PersistentException;
	public Correzione getCorrezioneByORMID(int ID) throws PersistentException;
	public Correzione loadCorrezioneByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione getCorrezioneByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione loadCorrezioneByORMID(PersistentSession session, int ID) throws PersistentException;
	public Correzione getCorrezioneByORMID(PersistentSession session, int ID) throws PersistentException;
	public Correzione loadCorrezioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione getCorrezioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione[] listCorrezioneByQuery(String condition, String orderBy) throws PersistentException;
	public Correzione[] listCorrezioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione[] listCorrezioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Correzione[] listCorrezioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione loadCorrezioneByQuery(String condition, String orderBy) throws PersistentException;
	public Correzione loadCorrezioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione loadCorrezioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Correzione loadCorrezioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Correzione createCorrezione();
	public boolean save(modello_di_dominio.Correzione correzione) throws PersistentException;
	public boolean delete(modello_di_dominio.Correzione correzione) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Correzione correzione) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Correzione correzione, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Correzione correzione) throws PersistentException;
	public boolean evict(modello_di_dominio.Correzione correzione) throws PersistentException;
	public Correzione loadCorrezioneByCriteria(CorrezioneCriteria correzioneCriteria);
	public Correzione[] listCorrezioneByCriteria(CorrezioneCriteria correzioneCriteria);
}
