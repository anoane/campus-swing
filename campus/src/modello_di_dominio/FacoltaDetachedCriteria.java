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

public class FacoltaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public FacoltaDetachedCriteria() {
		super(modello_di_dominio.Facolta.class, modello_di_dominio.FacoltaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public FacoltaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.FacoltaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public UniversitaDetachedCriteria createUniversitaCriteria() {
		return new UniversitaDetachedCriteria(createCriteria("universita"));
	}
	
	public modello_di_dominio.UtenteDetachedCriteria createIscrittoCriteria() {
		return new modello_di_dominio.UtenteDetachedCriteria(createCriteria("ORM_Iscritto"));
	}
	
	public modello_di_dominio.CorsoDetachedCriteria createCorsoCriteria() {
		return new modello_di_dominio.CorsoDetachedCriteria(createCriteria("ORM_Corso"));
	}
	
	public Facolta uniqueFacolta(PersistentSession session) {
		return (Facolta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Facolta[] listFacolta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Facolta[]) list.toArray(new Facolta[list.size()]);
	}
}

