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

public interface SlideDAO {
	public Slide loadSlideByORMID(int ID) throws PersistentException;
	public Slide getSlideByORMID(int ID) throws PersistentException;
	public Slide loadSlideByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide getSlideByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide loadSlideByORMID(PersistentSession session, int ID) throws PersistentException;
	public Slide getSlideByORMID(PersistentSession session, int ID) throws PersistentException;
	public Slide loadSlideByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide getSlideByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide[] listSlideByQuery(String condition, String orderBy) throws PersistentException;
	public Slide[] listSlideByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide[] listSlideByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Slide[] listSlideByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide loadSlideByQuery(String condition, String orderBy) throws PersistentException;
	public Slide loadSlideByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide loadSlideByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Slide loadSlideByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Slide createSlide();
	public boolean save(modello_di_dominio.Slide slide) throws PersistentException;
	public boolean delete(modello_di_dominio.Slide slide) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Slide slide) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Slide slide, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Slide slide) throws PersistentException;
	public boolean evict(modello_di_dominio.Slide slide) throws PersistentException;
	public Slide loadSlideByCriteria(SlideCriteria slideCriteria);
	public Slide[] listSlideByCriteria(SlideCriteria slideCriteria);
}
