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
package modello_di_dominio;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CorsoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	
	public CorsoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		descrizione = new StringExpression("descrizione", this);
	}
	
	public CorsoCriteria(PersistentSession session) {
		this(session.createCriteria(Corso.class));
	}
	
	public CorsoCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public FacoltaCriteria createFacoltaCriteria() {
		return new FacoltaCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.UtenteCriteria createUtenteCriteria() {
		return new modello_di_dominio.UtenteCriteria(createCriteria("ORM_Utente"));
	}
	
	public modello_di_dominio.DocumentoCriteria createDocumentoCriteria() {
		return new modello_di_dominio.DocumentoCriteria(createCriteria("ORM_Documento"));
	}
	
	public Corso uniqueCorso() {
		return (Corso) super.uniqueResult();
	}
	
	public Corso[] listCorso() {
		java.util.List list = super.list();
		return (Corso[]) list.toArray(new Corso[list.size()]);
	}
}

