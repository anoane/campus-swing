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

public class Corso_Utente {
	public Corso_Utente() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE_CORSO) {
			this.corso = (modello_di_dominio.Corso) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE_UTENTE) {
			this.utente = (modello_di_dominio.Utente) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private modello_di_dominio.Utente utente;
	
	private modello_di_dominio.Corso corso;
	
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
	
	public void setCorso(modello_di_dominio.Corso value) {
		if (corso != null) {
			corso.utenteCorso.remove(this);
		}
		if (value != null) {
			value.utenteCorso.add(this);
		}
	}
	
	public modello_di_dominio.Corso getCorso() {
		return corso;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Corso(modello_di_dominio.Corso value) {
		this.corso = value;
	}
	
	private modello_di_dominio.Corso getORM_Corso() {
		return corso;
	}
	
	public void setUtente(modello_di_dominio.Utente value) {
		if (utente != null) {
			utente.corso.remove(this);
		}
		if (value != null) {
			value.corso.add(this);
		}
	}
	
	public modello_di_dominio.Utente getUtente() {
		return utente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Utente(modello_di_dominio.Utente value) {
		this.utente = value;
	}
	
	private modello_di_dominio.Utente getORM_Utente() {
		return utente;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
