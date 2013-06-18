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
		if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIUTENTE) {
			return ORM_documentiUtente;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_CORREZIONES) {
			return ORM_correziones;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIPREFERITI) {
			return ORM_documentiPreferiti;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_VOTOS) {
			return ORM_votos;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_COMMENTOS) {
			return ORM_commentos;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO) {
			return ORM_corso;
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
	
	private String username;
	
	private java.util.Set ORM_documentiUtente = new java.util.HashSet();
	
	private java.util.Set ORM_correziones = new java.util.HashSet();
	
	private java.util.Set ORM_documentiPreferiti = new java.util.HashSet();
	
	private java.util.Set ORM_votos = new java.util.HashSet();
	
	private java.util.Set ORM_commentos = new java.util.HashSet();
	
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
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
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
	
	public modello_di_dominio.Documento[] getDocumentosCorrezione() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = correziones.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Correzione)lIter.next()).getDocumento());
		}
		return (modello_di_dominio.Documento[])lValues.toArray(new modello_di_dominio.Documento[lValues.size()]);
	}
	
	public void removeDocumentoCorrezione(modello_di_dominio.Documento aDocumento) {
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
	
	public final modello_di_dominio.Utente_DocumentoSetCollection documentiPreferiti = new modello_di_dominio.Utente_DocumentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIPREFERITI, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTO_UTENTEPREFERITO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public modello_di_dominio.Documento[] getDocumentosVoto() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = votos.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Voto)lIter.next()).getDocumento());
		}
		return (modello_di_dominio.Documento[])lValues.toArray(new modello_di_dominio.Documento[lValues.size()]);
	}
	
	public void removeDocumentoVoto(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Voto[] lVotos = votos.toArray();
		for(int i = 0; i < lVotos.length; i++) {
			if(lVotos[i].getDocumento().equals(aDocumento)) {
				votos.remove(lVotos[i]);
			}
		}
	}
	
	public void addDocumento(modello_di_dominio.Voto aVoto, modello_di_dominio.Documento aDocumento) {
		aVoto.setDocumento(aDocumento);
		votos.add(aVoto);
	}
	
	public modello_di_dominio.Voto getVotoByDocumento(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Voto[] lVotos = votos.toArray();
		for(int i = 0; i < lVotos.length; i++) {
			if(lVotos[i].getDocumento().equals(aDocumento)) {
				return lVotos[i];
			}
		}
		return null;
	}
	
	private void setORM_Votos(java.util.Set value) {
		this.ORM_votos = value;
	}
	
	private java.util.Set getORM_Votos() {
		return ORM_votos;
	}
	
	public final modello_di_dominio.VotoSetCollection votos = new modello_di_dominio.VotoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_VOTOS, modello_di_dominio.ORMConstants.KEY_VOTO_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public modello_di_dominio.Documento[] getDocumentos() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = commentos.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Commento)lIter.next()).getDocumento());
		}
		return (modello_di_dominio.Documento[])lValues.toArray(new modello_di_dominio.Documento[lValues.size()]);
	}
	
	public void removeDocumento(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Commento[] lCommentos = commentos.toArray();
		for(int i = 0; i < lCommentos.length; i++) {
			if(lCommentos[i].getDocumento().equals(aDocumento)) {
				commentos.remove(lCommentos[i]);
			}
		}
	}
	
	public void addDocumento(modello_di_dominio.Commento aCommento, modello_di_dominio.Documento aDocumento) {
		aCommento.setDocumento(aDocumento);
		commentos.add(aCommento);
	}
	
	public modello_di_dominio.Commento getCommentoByDocumento(modello_di_dominio.Documento aDocumento) {
		modello_di_dominio.Commento[] lCommentos = commentos.toArray();
		for(int i = 0; i < lCommentos.length; i++) {
			if(lCommentos[i].getDocumento().equals(aDocumento)) {
				return lCommentos[i];
			}
		}
		return null;
	}
	
	private void setORM_Commentos(java.util.Set value) {
		this.ORM_commentos = value;
	}
	
	private java.util.Set getORM_Commentos() {
		return ORM_commentos;
	}
	
	public final modello_di_dominio.CommentoSetCollection commentos = new modello_di_dominio.CommentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_COMMENTOS, modello_di_dominio.ORMConstants.KEY_COMMENTO_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Corso(java.util.Set value) {
		this.ORM_corso = value;
	}
	
	private java.util.Set getORM_Corso() {
		return ORM_corso;
	}
	
	public final modello_di_dominio.Corso_UtenteSetCollection corso = new modello_di_dominio.Corso_UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_UTENTE_CORSO, modello_di_dominio.ORMConstants.KEY_CORSO_UTENTE_UTENTE, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
