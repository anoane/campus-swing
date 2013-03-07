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

public class CorsoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	
	public CorsoDetachedCriteria() {
		super(modello_di_dominio.Corso.class, modello_di_dominio.CorsoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
	}
	
	public CorsoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.CorsoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
	}
	
	public FacoltaDetachedCriteria createFacoltaCriteria() {
		return new FacoltaDetachedCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.UtenteDetachedCriteria createUtenteCriteria() {
		return new modello_di_dominio.UtenteDetachedCriteria(createCriteria("ORM_Utente"));
	}
	
	public modello_di_dominio.DocumentoDetachedCriteria createDocumentoCriteria() {
		return new modello_di_dominio.DocumentoDetachedCriteria(createCriteria("ORM_Documento"));
	}
	
	public Corso uniqueCorso(PersistentSession session) {
		return (Corso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Corso[] listCorso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Corso[]) list.toArray(new Corso[list.size()]);
	}
}

