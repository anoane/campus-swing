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

public class VotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression valore;
	
	public VotoDetachedCriteria() {
		super(modello_di_dominio.Voto.class, modello_di_dominio.VotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		valore = new IntegerExpression("valore", this.getDetachedCriteria());
	}
	
	public VotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.VotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		valore = new IntegerExpression("valore", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public UtenteDetachedCriteria createUtenteCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utente"));
	}
	
	public Voto uniqueVoto(PersistentSession session) {
		return (Voto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Voto[] listVoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Voto[]) list.toArray(new Voto[list.size()]);
	}
}

