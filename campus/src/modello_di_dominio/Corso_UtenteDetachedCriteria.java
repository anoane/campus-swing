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

public class Corso_UtenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final TimestampExpression timestamp;
	
	public Corso_UtenteDetachedCriteria() {
		super(modello_di_dominio.Corso_Utente.class, modello_di_dominio.Corso_UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
	}
	
	public Corso_UtenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.Corso_UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
	}
	
	public UtenteDetachedCriteria createUtenteCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utente"));
	}
	
	public CorsoDetachedCriteria createCorsoCriteria() {
		return new CorsoDetachedCriteria(createCriteria("corso"));
	}
	
	public Corso_Utente uniqueCorso_Utente(PersistentSession session) {
		return (Corso_Utente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Corso_Utente[] listCorso_Utente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Corso_Utente[]) list.toArray(new Corso_Utente[list.size()]);
	}
}

