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

public class UniversitaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public UniversitaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
	}
	
	public UniversitaCriteria(PersistentSession session) {
		this(session.createCriteria(Universita.class));
	}
	
	public UniversitaCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public modello_di_dominio.FacoltaCriteria createFacoltaCriteria() {
		return new modello_di_dominio.FacoltaCriteria(createCriteria("ORM_Facolta"));
	}
	
	public Universita uniqueUniversita() {
		return (Universita) super.uniqueResult();
	}
	
	public Universita[] listUniversita() {
		java.util.List list = super.list();
		return (Universita[]) list.toArray(new Universita[list.size()]);
	}
}

