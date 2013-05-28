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

public interface CommentoDAO {
	public Commento loadCommentoByORMID(int ID) throws PersistentException;
	public Commento getCommentoByORMID(int ID) throws PersistentException;
	public Commento loadCommentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento getCommentoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento loadCommentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Commento getCommentoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Commento loadCommentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento getCommentoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento[] listCommentoByQuery(String condition, String orderBy) throws PersistentException;
	public Commento[] listCommentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento[] listCommentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Commento[] listCommentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento loadCommentoByQuery(String condition, String orderBy) throws PersistentException;
	public Commento loadCommentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento loadCommentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Commento loadCommentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commento createCommento();
	public boolean save(modello_di_dominio.Commento commento) throws PersistentException;
	public boolean delete(modello_di_dominio.Commento commento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Commento commento) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Commento commento, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Commento commento) throws PersistentException;
	public boolean evict(modello_di_dominio.Commento commento) throws PersistentException;
	public Commento loadCommentoByCriteria(CommentoCriteria commentoCriteria);
	public Commento[] listCommentoByCriteria(CommentoCriteria commentoCriteria);
}
