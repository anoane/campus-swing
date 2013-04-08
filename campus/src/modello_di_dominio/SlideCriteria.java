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

public class SlideCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	
	public SlideCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		descrizione = new StringExpression("descrizione", this);
	}
	
	public SlideCriteria(PersistentSession session) {
		this(session.createCriteria(Slide.class));
	}
	
	public SlideCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public modello_di_dominio.CorrezioneCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneCriteria(createCriteria("ORM_Correziones"));
	}
	
	public CorsoCriteria createCorsoCriteria() {
		return new CorsoCriteria(createCriteria("corso"));
	}
	
	public UtenteCriteria createUtenteDocumentoCriteria() {
		return new UtenteCriteria(createCriteria("utenteDocumento"));
	}
	
	public modello_di_dominio.UtenteCriteria createDocumentoPreferitoCriteria() {
		return new modello_di_dominio.UtenteCriteria(createCriteria("ORM_DocumentoPreferito"));
	}
	
	public Slide uniqueSlide() {
		return (Slide) super.uniqueResult();
	}
	
	public Slide[] listSlide() {
		java.util.List list = super.list();
		return (Slide[]) list.toArray(new Slide[list.size()]);
	}
}

