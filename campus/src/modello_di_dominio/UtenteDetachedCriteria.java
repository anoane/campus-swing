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
	public final StringExpression immagine;
	public final StringExpression username;
	
	public UtenteDetachedCriteria() {
		super(modello_di_dominio.Utente.class, modello_di_dominio.UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		datadinascita = new DateExpression("datadinascita", this.getDetachedCriteria());
		sesso = new StringExpression("sesso", this.getDetachedCriteria());
		immagine = new StringExpression("immagine", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
	}
	
	public UtenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.UtenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		datadinascita = new DateExpression("datadinascita", this.getDetachedCriteria());
		sesso = new StringExpression("sesso", this.getDetachedCriteria());
		immagine = new StringExpression("immagine", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
	}
	
	public FacoltaDetachedCriteria createFacoltaCriteria() {
		return new FacoltaDetachedCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.DocumentoDetachedCriteria createDocumentiUtenteCriteria() {
		return new modello_di_dominio.DocumentoDetachedCriteria(createCriteria("ORM_DocumentiUtente"));
	}
	
	public modello_di_dominio.CorrezioneDetachedCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneDetachedCriteria(createCriteria("ORM_Correziones"));
	}
	
	public modello_di_dominio.Utente_DocumentoDetachedCriteria createDocumentiPreferitiCriteria() {
		return new modello_di_dominio.Utente_DocumentoDetachedCriteria(createCriteria("ORM_DocumentiPreferiti"));
	}
	
	public modello_di_dominio.VotoDetachedCriteria createVotosCriteria() {
		return new modello_di_dominio.VotoDetachedCriteria(createCriteria("ORM_Votos"));
	}
	
	public modello_di_dominio.CommentoDetachedCriteria createCommentosCriteria() {
		return new modello_di_dominio.CommentoDetachedCriteria(createCriteria("ORM_Commentos"));
	}
	
	public modello_di_dominio.Corso_UtenteDetachedCriteria createCorsoCriteria() {
		return new modello_di_dominio.Corso_UtenteDetachedCriteria(createCriteria("ORM_Corso"));
	}
	
	public Utente uniqueUtente(PersistentSession session) {
		return (Utente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Utente[] listUtente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Utente[]) list.toArray(new Utente[list.size()]);
	}
}

