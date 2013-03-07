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
		if (key == modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE) {
			return ORM_utente;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_CORSO_DOCUMENTO) {
			return ORM_documento;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_CORSO_FACOLTA) {
			this.facolta = (modello_di_dominio.Facolta) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private modello_di_dominio.Facolta facolta;
	
	private String nome;
	
	private String descrizione;
	
	private java.util.Set ORM_utente = new java.util.HashSet();
	
	private java.util.Set ORM_documento = new java.util.HashSet();
	
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
	
	public void setFacolta(modello_di_dominio.Facolta value) {
		if (facolta != null) {
			facolta.corso.remove(this);
		}
		if (value != null) {
			value.corso.add(this);
		}
	}
	
	public modello_di_dominio.Facolta getFacolta() {
		return facolta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Facolta(modello_di_dominio.Facolta value) {
		this.facolta = value;
	}
	
	private modello_di_dominio.Facolta getORM_Facolta() {
		return facolta;
	}
	
	private void setORM_Utente(java.util.Set value) {
		this.ORM_utente = value;
	}
	
	private java.util.Set getORM_Utente() {
		return ORM_utente;
	}
	
	public final modello_di_dominio.UtenteSetCollection utente = new modello_di_dominio.UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE, modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Documento(java.util.Set value) {
		this.ORM_documento = value;
	}
	
	private java.util.Set getORM_Documento() {
		return ORM_documento;
	}
	
	public final modello_di_dominio.DocumentoSetCollection documento = new modello_di_dominio.DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_CORSO_DOCUMENTO, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORSO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
