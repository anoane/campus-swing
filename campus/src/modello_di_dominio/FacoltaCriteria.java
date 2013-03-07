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

public class FacoltaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public FacoltaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
	}
	
	public FacoltaCriteria(PersistentSession session) {
		this(session.createCriteria(Facolta.class));
	}
	
	public FacoltaCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public modello_di_dominio.CorsoCriteria createCorsoCriteria() {
		return new modello_di_dominio.CorsoCriteria(createCriteria("ORM_Corso"));
	}
	
	public Facolta uniqueFacolta() {
		return (Facolta) super.uniqueResult();
	}
	
	public Facolta[] listFacolta() {
		java.util.List list = super.list();
		return (Facolta[]) list.toArray(new Facolta[list.size()]);
	}
}

