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
	public final StringExpression discriminator;
	public final IntegerExpression voto;
	public final IntegerExpression num_voti;
	public final TimestampExpression timestamp;
	public final IntegerExpression downloads;
	
	public DocumentoDetachedCriteria() {
		super(modello_di_dominio.Documento.class, modello_di_dominio.DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		discriminator = new StringExpression("discriminator", this.getDetachedCriteria());
		voto = new IntegerExpression("voto", this.getDetachedCriteria());
		num_voti = new IntegerExpression("num_voti", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
		downloads = new IntegerExpression("downloads", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.DocumentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		discriminator = new StringExpression("discriminator", this.getDetachedCriteria());
		voto = new IntegerExpression("voto", this.getDetachedCriteria());
		num_voti = new IntegerExpression("num_voti", this.getDetachedCriteria());
		timestamp = new TimestampExpression("timestamp", this.getDetachedCriteria());
		downloads = new IntegerExpression("downloads", this.getDetachedCriteria());
	}
	
	public FacoltaDetachedCriteria createFacoltaCriteria() {
		return new FacoltaDetachedCriteria(createCriteria("facolta"));
	}
	
	public modello_di_dominio.CorrezioneDetachedCriteria createCorrezionesCriteria() {
		return new modello_di_dominio.CorrezioneDetachedCriteria(createCriteria("ORM_Correziones"));
	}
	
	public CorsoDetachedCriteria createCorsoCriteria() {
		return new CorsoDetachedCriteria(createCriteria("corso"));
	}
	
	public modello_di_dominio.VotoDetachedCriteria createVotosCriteria() {
		return new modello_di_dominio.VotoDetachedCriteria(createCriteria("ORM_Votos"));
	}
	
	public modello_di_dominio.CommentoDetachedCriteria createCommentosCriteria() {
		return new modello_di_dominio.CommentoDetachedCriteria(createCriteria("ORM_Commentos"));
	}
	
	public UtenteDetachedCriteria createProprietarioCriteria() {
		return new UtenteDetachedCriteria(createCriteria("proprietario"));
	}
	
	public modello_di_dominio.Utente_DocumentoDetachedCriteria createUtentePreferitoCriteria() {
		return new modello_di_dominio.Utente_DocumentoDetachedCriteria(createCriteria("ORM_UtentePreferito"));
	}
	
	public Documento uniqueDocumento(PersistentSession session) {
		return (Documento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Documento[] listDocumento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Documento[]) list.toArray(new Documento[list.size()]);
	}
}

