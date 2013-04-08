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

public class UtenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final DateExpression datadinascita;
	public final StringExpression sesso;
	
	public UtenteDetachedCriteria() {
		super(modello_di_dominio.Utente.class, modello_di_dominio.UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		datadinascita = new DateExpression("datadinascita", this.getDetachedCriteria());
		sesso = new StringExpression("sesso", this.getDetachedCriteria());
	}
	
	public UtenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		datadinascita = new DateExpression("datadinascita", this.getDetachedCriteria());
		sesso = new StringExpression("sesso", this.getDetachedCriteria());
	}
	
	public FacoltaDetachedCriteria createFacoltaCriteria() {
		return new FacoltaDetachedCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.CorsoDetachedCriteria createCorsoCriteria() {
		return new modello_di_dominio.CorsoDetachedCriteria(createCriteria("ORM_Corso"));
	}
	
	public modello_di_dominio.DocumentoDetachedCriteria createDocumentoUtenteCriteria() {
		return new modello_di_dominio.DocumentoDetachedCriteria(createCriteria("ORM_DocumentoUtente"));
	}
	
	public modello_di_dominio.CorrezioneDetachedCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneDetachedCriteria(createCriteria("ORM_Correziones"));
	}
	
	public modello_di_dominio.DocumentoDetachedCriteria createDocumentoPreferitoCriteria() {
		return new modello_di_dominio.DocumentoDetachedCriteria(createCriteria("ORM_DocumentoPreferito"));
	}
	
	public Utente uniqueUtente(PersistentSession session) {
		return (Utente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Utente[] listUtente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Utente[]) list.toArray(new Utente[list.size()]);
	}
}

