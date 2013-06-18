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

public class Utente_DocumentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final TimestampExpression timestamp;
	
	public Utente_DocumentoDetachedCriteria() {
		super(modello_di_dominio.Utente_Documento.class, modello_di_dominio.Utente_DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
	}
	
	public Utente_DocumentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.Utente_DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public UtenteDetachedCriteria createUtentePreferitoCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utentePreferito"));
	}
	
	public Utente_Documento uniqueUtente_Documento(PersistentSession session) {
		return (Utente_Documento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Utente_Documento[] listUtente_Documento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Utente_Documento[]) list.toArray(new Utente_Documento[list.size()]);
	}
}

