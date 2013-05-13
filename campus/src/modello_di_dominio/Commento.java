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

public class Commento {
	public Commento() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_COMMENTO_UTENTE) {
			this.utente = (modello_di_dominio.Utente) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_COMMENTO_DOCUMENTO) {
			this.documento = (modello_di_dominio.Documento) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private String commento;
	
	private int rootID;
	
	private modello_di_dominio.Documento documento;
	
	private modello_di_dominio.Utente utente;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCommento(String value) {
		this.commento = value;
	}
	
	public String getCommento() {
		return commento;
	}
	
	public void setRootID(int value) {
		this.rootID = value;
	}
	
	public int getRootID() {
		return rootID;
	}
	
	public void setUtente(modello_di_dominio.Utente value) {
		if (utente != null) {
			utente.commentos.remove(this);
		}
		if (value != null) {
			value.commentos.add(this);
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
			documento.commentos.remove(this);
		}
		if (value != null) {
			value.commentos.add(this);
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
