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

public class Documento {
	public Documento() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORREZIONES) {
			return ORM_correziones;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTE) {
			return ORM_utente;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORSO) {
			this.corso = (modello_di_dominio.Corso) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTEDOCUMENTO) {
			this.utenteDocumento = (modello_di_dominio.Utente) owner;
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
	
	private java.util.Set ORM_correziones = new java.util.HashSet();
	
	private modello_di_dominio.Corso corso;
	
	private String nome;
	
	private String descrizione;
	
	private String path;
	
	private java.util.Set ORM_utente = new java.util.HashSet();
	
	private modello_di_dominio.Utente utenteDocumento;
	
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
	
	public void setPath(String value) {
		this.path = value;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setCorso(modello_di_dominio.Corso value) {
		if (corso != null) {
			corso.documentoCorso.remove(this);
		}
		if (value != null) {
			value.documentoCorso.add(this);
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
	
	public modello_di_dominio.Utente[] getUtentes() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = correziones.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Correzione)lIter.next()).getUtente());
		}
		return (modello_di_dominio.Utente[])lValues.toArray(new modello_di_dominio.Utente[lValues.size()]);
	}
	
	public void removeUtente(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Correzione[] lCorreziones = correziones.toArray();
		for(int i = 0; i < lCorreziones.length; i++) {
			if(lCorreziones[i].getUtente().equals(aUtente)) {
				correziones.remove(lCorreziones[i]);
			}
		}
	}
	
	public void addUtente(modello_di_dominio.Correzione aCorrezione, modello_di_dominio.Utente aUtente) {
		aCorrezione.setUtente(aUtente);
		correziones.add(aCorrezione);
	}
	
	public modello_di_dominio.Correzione getCorrezioneByUtente(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Correzione[] lCorreziones = correziones.toArray();
		for(int i = 0; i < lCorreziones.length; i++) {
			if(lCorreziones[i].getUtente().equals(aUtente)) {
				return lCorreziones[i];
			}
		}
		return null;
	}
	
	private void setORM_Correziones(java.util.Set value) {
		this.ORM_correziones = value;
	}
	
	private java.util.Set getORM_Correziones() {
		return ORM_correziones;
	}
	
	public final modello_di_dominio.CorrezioneSetCollection correziones = new modello_di_dominio.CorrezioneSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORREZIONES, modello_di_dominio.ORMConstants.KEY_CORREZIONE_DOCUMENTO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Utente(java.util.Set value) {
		this.ORM_utente = value;
	}
	
	private java.util.Set getORM_Utente() {
		return ORM_utente;
	}
	
	public final modello_di_dominio.UtenteSetCollection utente = new modello_di_dominio.UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTE, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTOPREFERITO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setUtenteDocumento(modello_di_dominio.Utente value) {
		if (utenteDocumento != null) {
			utenteDocumento.documentoUtente.remove(this);
		}
		if (value != null) {
			value.documentoUtente.add(this);
		}
	}
	
	public modello_di_dominio.Utente getUtenteDocumento() {
		return utenteDocumento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_UtenteDocumento(modello_di_dominio.Utente value) {
		this.utenteDocumento = value;
	}
	
	private modello_di_dominio.Utente getORM_UtenteDocumento() {
		return utenteDocumento;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
