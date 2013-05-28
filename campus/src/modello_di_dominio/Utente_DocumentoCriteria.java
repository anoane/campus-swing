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

public class Utente_DocumentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final TimestampExpression timestamp;
	
	public Utente_DocumentoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		timestamp = new TimestampExpression("timestamp", this);
	}
	
	public Utente_DocumentoCriteria(PersistentSession session) {
		this(session.createCriteria(Utente_Documento.class));
	}
	
	public Utente_DocumentoCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public DocumentoCriteria createDocumentoCriteria() {
		return new DocumentoCriteria(createCriteria("documento"));
	}
	
	public UtenteCriteria createUtentePreferitoCriteria() {
		return new UtenteCriteria(createCriteria("utentePreferito"));
	}
	
	public Utente_Documento uniqueUtente_Documento() {
		return (Utente_Documento) super.uniqueResult();
	}
	
	public Utente_Documento[] listUtente_Documento() {
		java.util.List list = super.list();
		return (Utente_Documento[]) list.toArray(new Utente_Documento[list.size()]);
	}
}

