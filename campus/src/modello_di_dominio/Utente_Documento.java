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

public class Utente_Documento {
	public Utente_Documento() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTO_UTENTEPREFERITO) {
			this.utentePreferito = (modello_di_dominio.Utente) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTO_DOCUMENTO) {
			this.documento = (modello_di_dominio.Documento) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private modello_di_dominio.Documento documento;
	
	private modello_di_dominio.Utente utentePreferito;
	
	private java.sql.Timestamp timestamp;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTimestamp(java.sql.Timestamp value) {
		this.timestamp = value;
	}
	
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setUtentePreferito(modello_di_dominio.Utente value) {
		if (utentePreferito != null) {
			utentePreferito.documentiPreferiti.remove(this);
		}
		if (value != null) {
			value.documentiPreferiti.add(this);
		}
	}
	
	public modello_di_dominio.Utente getUtentePreferito() {
		return utentePreferito;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_UtentePreferito(modello_di_dominio.Utente value) {
		this.utentePreferito = value;
	}
	
	private modello_di_dominio.Utente getORM_UtentePreferito() {
		return utentePreferito;
	}
	
	public void setDocumento(modello_di_dominio.Documento value) {
		if (documento != null) {
			documento.utentePreferito.remove(this);
		}
		if (value != null) {
			value.utentePreferito.add(this);
		}
	}
	
	public modello_di_dominio.Documento getDocumento() {
		return documento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Documento(modello_di_dominio.Documento value) {
		this.documento = value;
	}
	
	private modello_di_dominio.Documento getORM_Documento() {
		return documento;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
