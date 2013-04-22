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

public class Utente {
	public Utente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO) {
			return ORM_corso;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIUTENTE) {
			return ORM_documentiUtente;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_CORREZIONES) {
			return ORM_correziones;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIPREFERITI) {
			return ORM_documentiPreferiti;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_FACOLTA) {
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
	
	private String cognome;
	
	private java.util.Date datadinascita;
	
	private String sesso;
	
	private String immagine;
	
	private java.util.Set ORM_corso = new java.util.HashSet();
	
	private java.util.Set ORM_documentiUtente = new java.util.HashSet();
	
	private java.util.Set ORM_correziones = new java.util.HashSet();
	
	private java.util.Set ORM_documentiPreferiti = new java.util.HashSet();
	
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
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setDatadinascita(java.util.Date value) {
		this.datadinascita = value;
	}
	
	public java.util.Date getDatadinascita() {
		return datadinascita;
	}
	
	public void setSesso(String value) {
		this.sesso = value;
	}
	
	public String getSesso() {
		return sesso;
	}
	
	public void setImmagine(String value) {
		this.immagine = value;
	}
	
	public String getImmagine() {
		return immagine;
	}
	
	private void setORM_Corso(java.util.Set value) {
		this.ORM_corso = value;
	}
	
	private java.util.Set getORM_Corso() {
		return ORM_corso;
	}
	
	public final modello_di_dominio.CorsoSetCollection corso = new modello_di_dominio.CorsoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO, modello_di_dominio.ORMConstants.KEY_CORSO_UTENTECORSO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_DocumentiUtente(java.util.Set value) {
		this.ORM_documentiUtente = value;
	}
	
	private java.util.Set getORM_DocumentiUtente() {
		return ORM_documentiUtente;
	}
	
	public final modello_di_dominio.DocumentoSetCollection documentiUtente = new modello_di_dominio.DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIUTENTE, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_PROPRIETARIO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setFacolta(modello_di_dominio.Facolta value) {
		if (facolta != null) {
			facolta.iscritto.remove(this);
		}
		if (value != null) {
			value.iscritto.add(this);
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
	
	public modello_di_dominio.Documento[] getDocumentos() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = correziones.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Correzione)lIter.next()).getDocumento());
		}
		return (modello_di_dominio.Documento[])lValues.toArray(new modello_di_dominio.Documento[lValues.size()]);
	}
	
	public void removeDocumento(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Correzione[] lCorreziones = correziones.toArray();
		for(int i = 0; i < lCorreziones.length; i++) {
			if(lCorreziones[i].getDocumento().equals(aDocumento)) {
				correziones.remove(lCorreziones[i]);
			}
		}
	}
	
	public void addDocumento(modello_di_dominio.Correzione aCorrezione, modello_di_dominio.Documento aDocumento) {
		aCorrezione.setDocumento(aDocumento);
		correziones.add(aCorrezione);
	}
	
	public modello_di_dominio.Correzione getCorrezioneByDocumento(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Correzione[] lCorreziones = correziones.toArray();
		for(int i = 0; i < lCorreziones.length; i++) {
			if(lCorreziones[i].getDocumento().equals(aDocumento)) {
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
	
	public final modello_di_dominio.CorrezioneSetCollection correziones = new modello_di_dominio.CorrezioneSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_CORREZIONES, modello_di_dominio.ORMConstants.KEY_CORREZIONE_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_DocumentiPreferiti(java.util.Set value) {
		this.ORM_documentiPreferiti = value;
	}
	
	private java.util.Set getORM_DocumentiPreferiti() {
		return ORM_documentiPreferiti;
	}
	
	public final modello_di_dominio.DocumentoSetCollection documentiPreferiti = new modello_di_dominio.DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIPREFERITI, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTEPREFERITO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
