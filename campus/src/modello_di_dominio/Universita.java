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

public class Universita {
	public Universita() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_UNIVERSITA_FACOLTA) {
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
	
	private void setORM_Facolta(java.util.Set value) {
		this.ORM_facolta = value;
	}
	
	private java.util.Set getORM_Facolta() {
		return ORM_facolta;
	}
	
	public final modello_di_dominio.FacoltaSetCollection facolta = new modello_di_dominio.FacoltaSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UNIVERSITA_FACOLTA, modello_di_dominio.ORMConstants.KEY_FACOLTA_UNIVERSITA, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
