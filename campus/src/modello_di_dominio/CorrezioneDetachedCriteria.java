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

public class CorrezioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression testo;
	public final TimestampExpression timestamp;
	public final BooleanExpression approvato;
	
	public CorrezioneDetachedCriteria() {
		super(modello_di_dominio.Correzione.class, modello_di_dominio.CorrezioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		testo = new StringExpression("testo", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
		approvato = new BooleanExpression("approvato", this.getDetachedCriteria());
	}
	
	public CorrezioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.CorrezioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		testo = new StringExpression("testo", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
		approvato = new BooleanExpression("approvato", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public UtenteDetachedCriteria createUtenteCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utente"));
	}
	
	public Correzione uniqueCorrezione(PersistentSession session) {
		return (Correzione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Correzione[] listCorrezione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Correzione[]) list.toArray(new Correzione[list.size()]);
	}
}

