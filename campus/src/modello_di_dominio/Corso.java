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

public class Corso {
	public Corso() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_CORSO_UTENTECORSO) {
			return ORM_utenteCorso;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_CORSO_DOCUMENTOCORSO) {
			return ORM_documentoCorso;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_CORSO_FACOLTA) {
			return ORM_facolta;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String nome;
	
	private String descrizione;
	
	private String immagine;
	
	private String path;
	
	private java.util.Set ORM_utenteCorso = new java.util.HashSet();
	
	private java.util.Set ORM_documentoCorso = new java.util.HashSet();
	
	private java.util.Set ORM_facolta = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setImmagine(String value) {
		this.immagine = value;
	}
	
	public String getImmagine() {
		return immagine;
	}
	
	public void setPath(String value) {
		this.path = value;
	}
	
	public String getPath() {
		return path;
	}
	
	private void setORM_UtenteCorso(java.util.Set value) {
		this.ORM_utenteCorso = value;
	}
	
	private java.util.Set getORM_UtenteCorso() {
		return ORM_utenteCorso;
	}
	
	public final modello_di_dominio.UtenteSetCollection utenteCorso = new modello_di_dominio.UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_CORSO_UTENTECORSO, modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_DocumentoCorso(java.util.Set value) {
		this.ORM_documentoCorso = value;
	}
	
	private java.util.Set getORM_DocumentoCorso() {
		return ORM_documentoCorso;
	}
	
	public final modello_di_dominio.DocumentoSetCollection documentoCorso = new modello_di_dominio.DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_CORSO_DOCUMENTOCORSO, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORSO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Facolta(java.util.Set value) {
		this.ORM_facolta = value;
	}
	
	private java.util.Set getORM_Facolta() {
		return ORM_facolta;
	}
	
	public final modello_di_dominio.FacoltaSetCollection facolta = new modello_di_dominio.FacoltaSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_CORSO_FACOLTA, modello_di_dominio.ORMConstants.KEY_FACOLTA_CORSO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
