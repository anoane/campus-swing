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

public class Facolta {
	public Facolta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_FACOLTA_ISCRITTO) {
			return ORM_iscritto;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_FACOLTA_CORSO) {
			return ORM_corso;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_FACOLTA_UNIVERSITA) {
			this.universita = (modello_di_dominio.Universita) owner;
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
	
	private modello_di_dominio.Universita universita;
	
	private String nome;
	
	private java.util.Set ORM_iscritto = new java.util.HashSet();
	
	private java.util.Set ORM_corso = new java.util.HashSet();
	
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
	
	private void setORM_Iscritto(java.util.Set value) {
		this.ORM_iscritto = value;
	}
	
	private java.util.Set getORM_Iscritto() {
		return ORM_iscritto;
	}
	
	public final modello_di_dominio.UtenteSetCollection iscritto = new modello_di_dominio.UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_FACOLTA_ISCRITTO, modello_di_dominio.ORMConstants.KEY_UTENTE_FACOLTA, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Corso(java.util.Set value) {
		this.ORM_corso = value;
	}
	
	private java.util.Set getORM_Corso() {
		return ORM_corso;
	}
	
	public final modello_di_dominio.CorsoSetCollection corso = new modello_di_dominio.CorsoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_FACOLTA_CORSO, modello_di_dominio.ORMConstants.KEY_CORSO_FACOLTA, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setUniversita(modello_di_dominio.Universita value) {
		if (universita != null) {
			universita.facolta.remove(this);
		}
		if (value != null) {
			value.facolta.add(this);
		}
	}
	
	public modello_di_dominio.Universita getUniversita() {
		return universita;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Universita(modello_di_dominio.Universita value) {
		this.universita = value;
	}
	
	private modello_di_dominio.Universita getORM_Universita() {
		return universita;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
