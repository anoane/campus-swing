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

import java.io.Serializable;
public class Correzione implements Serializable {
	public Correzione() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Correzione))
			return false;
		Correzione correzione = (Correzione)aObj;
		if (getID() != correzione.getID())
			return false;
		if (getUtente() == null) {
			if (correzione.getUtente() != null)
				return false;
		}
		else if (!getUtente().equals(correzione.getUtente()))
			return false;
		if (getDocumento() == null) {
			if (correzione.getDocumento() != null)
				return false;
		}
		else if (!getDocumento().equals(correzione.getDocumento()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getID();
		if (getUtente() != null) {
			hashcode = hashcode + (int) getUtente().getORMID();
		}
		if (getDocumento() != null) {
			hashcode = hashcode + (int) getDocumento().getORMID();
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_CORREZIONE_UTENTE) {
			this.utente = (modello_di_dominio.Utente) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_CORREZIONE_DOCUMENTO) {
			this.documento = (modello_di_dominio.Documento) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private String testo;
	
	private java.util.Date data;
	
	private boolean approvato;
	
	private modello_di_dominio.Utente utente;
	
	private int utenteId;
	
	private void setUtenteId(int value) {
		this.utenteId = value;
	}
	
	public int getUtenteId() {
		return utenteId;
	}
	
	private modello_di_dominio.Documento documento;
	
	private int documentoId;
	
	private void setDocumentoId(int value) {
		this.documentoId = value;
	}
	
	public int getDocumentoId() {
		return documentoId;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setTesto(String value) {
		this.testo = value;
	}
	
	public String getTesto() {
		return testo;
	}
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
	}
	
	public void setApprovato(boolean value) {
		this.approvato = value;
	}
	
	public boolean getApprovato() {
		return approvato;
	}
	
	public void setUtente(modello_di_dominio.Utente value) {
		if (utente != null) {
			utente.correziones.remove(this);
		}
		if (value != null) {
			value.correziones.add(this);
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
	
	public void setDocumento(modello_di_dominio.Documento value) {
		if (documento != null) {
			documento.correziones.remove(this);
		}
		if (value != null) {
			value.correziones.add(this);
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
		return String.valueOf(getID() + " " + ((getUtente() == null) ? "" : String.valueOf(getUtente().getORMID())) + " " + ((getDocumento() == null) ? "" : String.valueOf(getDocumento().getORMID())));
	}
	
}
