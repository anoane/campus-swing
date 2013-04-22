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

public class UniversitaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public UniversitaDetachedCriteria() {
		super(modello_di_dominio.Universita.class, modello_di_dominio.UniversitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public UniversitaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.UniversitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public modello_di_dominio.FacoltaDetachedCriteria createFacoltaCriteria() {
		return new modello_di_dominio.FacoltaDetachedCriteria(createCriteria("ORM_Facolta"));
	}
	
	public Universita uniqueUniversita(PersistentSession session) {
		return (Universita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Universita[] listUniversita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Universita[]) list.toArray(new Universita[list.size()]);
	}
}

