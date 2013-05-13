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

public class CommentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression commento;
	public final IntegerExpression rootID;
	
	public CommentoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		commento = new StringExpression("commento", this);
		rootID = new IntegerExpression("rootID", this);
	}
	
	public CommentoCriteria(PersistentSession session) {
		this(session.createCriteria(Commento.class));
	}
	
	public CommentoCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public DocumentoCriteria createDocumentoCriteria() {
		return new DocumentoCriteria(createCriteria("ORM_Documento"));
	}
	
	public UtenteCriteria createUtenteCriteria() {
		return new UtenteCriteria(createCriteria("ORM_Utente"));
	}
	
	public Commento uniqueCommento() {
		return (Commento) super.uniqueResult();
	}
	
	public Commento[] listCommento() {
		java.util.List list = super.list();
		return (Commento[]) list.toArray(new Commento[list.size()]);
	}
}

