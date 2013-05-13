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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression commento;
	public final IntegerExpression rootID;
	
	public CommentoDetachedCriteria() {
		super(modello_di_dominio.Commento.class, modello_di_dominio.CommentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		commento = new StringExpression("commento", this.getDetachedCriteria());
		rootID = new IntegerExpression("rootID", this.getDetachedCriteria());
	}
	
	public CommentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.CommentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		commento = new StringExpression("commento", this.getDetachedCriteria());
		rootID = new IntegerExpression("rootID", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public UtenteDetachedCriteria createUtenteCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utente"));
	}
	
	public Commento uniqueCommento(PersistentSession session) {
		return (Commento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Commento[] listCommento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Commento[]) list.toArray(new Commento[list.size()]);
	}
}

