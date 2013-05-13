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

public class UtenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final DateExpression datadinascita;
	public final StringExpression sesso;
	public final StringExpression immagine;
	public final StringExpression username;
	
	public UtenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		datadinascita = new DateExpression("datadinascita", this);
		sesso = new StringExpression("sesso", this);
		immagine = new StringExpression("immagine", this);
		username = new StringExpression("username", this);
	}
	
	public UtenteCriteria(PersistentSession session) {
		this(session.createCriteria(Utente.class));
	}
	
	public UtenteCriteria() throws PersistentException {
		this(modello_di_dominio.ProjectfinalPersistentManager.instance().getSession());
	}
	
	public FacoltaCriteria createFacoltaCriteria() {
		return new FacoltaCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.CorsoCriteria createCorsoCriteria() {
		return new modello_di_dominio.CorsoCriteria(createCriteria("ORM_Corso"));
	}
	
	public modello_di_dominio.DocumentoCriteria createDocumentiUtenteCriteria() {
		return new modello_di_dominio.DocumentoCriteria(createCriteria("ORM_DocumentiUtente"));
	}
	
	public modello_di_dominio.CorrezioneCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneCriteria(createCriteria("ORM_Correziones"));
	}
	
	public modello_di_dominio.DocumentoCriteria createDocumentiPreferitiCriteria() {
		return new modello_di_dominio.DocumentoCriteria(createCriteria("ORM_DocumentiPreferiti"));
	}
	
	public modello_di_dominio.VotoCriteria createVotosCriteria() {
		return new modello_di_dominio.VotoCriteria(createCriteria("ORM_Votos"));
	}
	
	public modello_di_dominio.CommentoCriteria createCommentosCriteria() {
		return new modello_di_dominio.CommentoCriteria(createCriteria("ORM_Commentos"));
	}
	
	public Utente uniqueUtente() {
		return (Utente) super.uniqueResult();
	}
	
	public Utente[] listUtente() {
		java.util.List list = super.list();
		return (Utente[]) list.toArray(new Utente[list.size()]);
	}
}

