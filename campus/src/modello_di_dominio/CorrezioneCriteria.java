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

public class CorrezioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression testo;
	public final TimestampExpression timestamp;
	public final BooleanExpression approvato;
	
	public CorrezioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		testo = new StringExpression("testo", this);
		timestamp = new TimestampExpression("timestamp", this);
		approvato = new BooleanExpression("approvato", this);
	}
	
	public CorrezioneCriteria(PersistentSession session) {
		this(session.createCriteria(Correzione.class));
	}
	
	public CorrezioneCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public DocumentoCriteria createDocumentoCriteria() {
		return new DocumentoCriteria(createCriteria("ORM_Documento"));
	}
	
	public UtenteCriteria createUtenteCriteria() {
		return new UtenteCriteria(createCriteria("ORM_Utente"));
	}
	
	public Correzione uniqueCorrezione() {
		return (Correzione) super.uniqueResult();
	}
	
	public Correzione[] listCorrezione() {
		java.util.List list = super.list();
		return (Correzione[]) list.toArray(new Correzione[list.size()]);
	}
}

