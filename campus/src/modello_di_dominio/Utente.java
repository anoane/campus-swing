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
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTO) {
			return ORM_documento;
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
	
	private String cognome;
	
	private java.sql.Timestamp datadinascita;
	
	private String sesso;
	
	private java.util.Set ORM_corso = new java.util.HashSet();
	
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
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setDatadinascita(java.sql.Timestamp value) {
		this.datadinascita = value;
	}
	
	public java.sql.Timestamp getDatadinascita() {
		return datadinascita;
	}
	
	public void setSesso(String value) {
		this.sesso = value;
	}
	
	public String getSesso() {
		return sesso;
	}
	
	private void setORM_Corso(java.util.Set value) {
		this.ORM_corso = value;
	}
	
	private java.util.Set getORM_Corso() {
		return ORM_corso;
	}
	
	public final modello_di_dominio.CorsoSetCollection corso = new modello_di_dominio.CorsoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO, modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Documento(java.util.Set value) {
		this.ORM_documento = value;
	}
	
	private java.util.Set getORM_Documento() {
		return ORM_documento;
	}
	
	public final modello_di_dominio.DocumentoSetCollection documento = new modello_di_dominio.DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTO, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
