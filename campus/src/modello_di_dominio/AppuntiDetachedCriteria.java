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

public class AppuntiDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression descrizione;
	public final StringExpression path;
	public final IntegerExpression voto;
	public final IntegerExpression num_voti;
	
	public AppuntiDetachedCriteria() {
		super(modello_di_dominio.Appunti.class, modello_di_dominio.AppuntiCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		voto = new IntegerExpression("voto", this.getDetachedCriteria());
		num_voti = new IntegerExpression("num_voti", this.getDetachedCriteria());
	}
	
	public AppuntiDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.AppuntiCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		voto = new IntegerExpression("voto", this.getDetachedCriteria());
		num_voti = new IntegerExpression("num_voti", this.getDetachedCriteria());
	}
	
	public modello_di_dominio.CorrezioneDetachedCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneDetachedCriteria(createCriteria("ORM_Correziones"));
	}
	
	public CorsoDetachedCriteria createCorsoCriteria() {
		return new CorsoDetachedCriteria(createCriteria("corso"));
	}
	
	public modello_di_dominio.UtenteDetachedCriteria createUtentePreferitoCriteria() {
		return new modello_di_dominio.UtenteDetachedCriteria(createCriteria("ORM_UtentePreferito"));
	}
	
	public UtenteDetachedCriteria createProprietarioCriteria() {
		return new UtenteDetachedCriteria(createCriteria("proprietario"));
	}
	
	public Appunti uniqueAppunti(PersistentSession session) {
		return (Appunti) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Appunti[] listAppunti(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Appunti[]) list.toArray(new Appunti[list.size()]);
	}
}

