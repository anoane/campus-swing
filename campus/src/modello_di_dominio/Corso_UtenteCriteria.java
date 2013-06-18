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

public class Corso_UtenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final TimestampExpression timestamp;
	
	public Corso_UtenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		timestamp = new TimestampExpression("timestamp", this);
	}
	
	public Corso_UtenteCriteria(PersistentSession session) {
		this(session.createCriteria(Corso_Utente.class));
	}
	
	public Corso_UtenteCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public UtenteCriteria createUtenteCriteria() {
		return new UtenteCriteria(createCriteria("utente"));
	}
	
	public CorsoCriteria createCorsoCriteria() {
		return new CorsoCriteria(createCriteria("corso"));
	}
	
	public Corso_Utente uniqueCorso_Utente() {
		return (Corso_Utente) super.uniqueResult();
	}
	
	public Corso_Utente[] listCorso_Utente() {
		java.util.List list = super.list();
		return (Corso_Utente[]) list.toArray(new Corso_Utente[list.size()]);
	}
}

