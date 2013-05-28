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

public class CorsoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	public final StringExpression immagine;
	public final StringExpression path;
	
	public CorsoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		descrizione = new StringExpression("descrizione", this);
		immagine = new StringExpression("immagine", this);
		path = new StringExpression("path", this);
	}
	
	public CorsoCriteria(PersistentSession session) {
		this(session.createCriteria(Corso.class));
	}
	
	public CorsoCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public modello_di_dominio.Corso_UtenteCriteria createUtenteCorsoCriteria() {
		return new modello_di_dominio.Corso_UtenteCriteria(createCriteria("ORM_UtenteCorso"));
	}
	
	public modello_di_dominio.DocumentoCriteria createDocumentoCorsoCriteria() {
		return new modello_di_dominio.DocumentoCriteria(createCriteria("ORM_DocumentoCorso"));
	}
	
	public modello_di_dominio.FacoltaCriteria createFacoltaCriteria() {
		return new modello_di_dominio.FacoltaCriteria(createCriteria("ORM_Facolta"));
	}
	
	public Corso uniqueCorso() {
		return (Corso) super.uniqueResult();
	}
	
	public Corso[] listCorso() {
		java.util.List list = super.list();
		return (Corso[]) list.toArray(new Corso[list.size()]);
	}
}

