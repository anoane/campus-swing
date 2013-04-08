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

public class DocumentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	public final StringExpression path;
	
	public DocumentoDetachedCriteria() {
		super(modello_di_dominio.Documento.class, modello_di_dominio.DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public modello_di_dominio.CorrezioneDetachedCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneDetachedCriteria(createCriteria("ORM_Correziones"));
	}
	
	public CorsoDetachedCriteria createCorsoCriteria() {
		return new CorsoDetachedCriteria(createCriteria("corso"));
	}
	
	public modello_di_dominio.UtenteDetachedCriteria createUtenteCriteria() {
		return new modello_di_dominio.UtenteDetachedCriteria(createCriteria("ORM_Utente"));
	}
	
	public UtenteDetachedCriteria createUtenteDocumentoCriteria() {
		return new UtenteDetachedCriteria(createCriteria("utenteDocumento"));
	}
	
	public Documento uniqueDocumento(PersistentSession session) {
		return (Documento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Documento[] listDocumento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Documento[]) list.toArray(new Documento[list.size()]);
	}
}

