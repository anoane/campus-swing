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
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTEPREFERITO) {
			return ORM_utentePreferito;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_VOTOS) {
			return ORM_votos;
		}
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_COMMENTOS) {
			return ORM_commentos;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_CORSO) {
			this.corso = (modello_di_dominio.Corso) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_FACOLTA) {
			this.facolta = (modello_di_dominio.Facolta) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_DOCUMENTO_PROPRIETARIO) {
			this.proprietario = (modello_di_dominio.Utente) owner;
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
	
	private java.util.Set ORM_correziones = new java.util.HashSet();
	
	private modello_di_dominio.Corso corso;
	
	private String nome;
	
	private String descrizione;
	
	private String path;
	
	private String discriminator;
	
	private int voto;
	
	private int num_voti;
	
	private java.sql.Timestamp timestamp;
	
	private int downloads = 1;
	
	private java.util.Set ORM_utentePreferito = new java.util.HashSet();
	
	private java.util.Set ORM_votos = new java.util.HashSet();
	
	private java.util.Set ORM_commentos = new java.util.HashSet();
	
	private modello_di_dominio.Utente proprietario;
	
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
	
	public void setDiscriminator(String value) {
		this.discriminator = value;
	}
	
	public String getDiscriminator() {
		return discriminator;
	}
	
	public void setVoto(int value) {
		this.voto = value;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public void setNum_voti(int value) {
		this.num_voti = value;
	}
	
	public int getNum_voti() {
		return num_voti;
	}
	
	public void setTimestamp(java.sql.Timestamp value) {
		this.timestamp = value;
	}
	
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setDownloads(int value) {
		this.downloads = value;
	}
	
	public int getDownloads() {
		return downloads;
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
	
	public modello_di_dominio.Utente[] getUtentesCorrezione() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = correziones.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Correzione)lIter.next()).getUtente());
		}
		return (modello_di_dominio.Utente[])lValues.toArray(new modello_di_dominio.Utente[lValues.size()]);
	}
	
	public void removeUtenteCorrezione(modello_di_dominio.Utente aUtente) {
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
	
	private void setORM_UtentePreferito(java.util.Set value) {
		this.ORM_utentePreferito = value;
	}
	
	private java.util.Set getORM_UtentePreferito() {
		return ORM_utentePreferito;
	}
	
	public final modello_di_dominio.UtenteSetCollection utentePreferito = new modello_di_dominio.UtenteSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_UTENTEPREFERITO, modello_di_dominio.ORMConstants.KEY_UTENTE_DOCUMENTIPREFERITI, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setFacolta(modello_di_dominio.Facolta value) {
		if (facolta != null) {
			facolta.documento.remove(this);
		}
		if (value != null) {
			value.documento.add(this);
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
	
	public modello_di_dominio.Utente[] getUtentesVoto() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = votos.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Voto)lIter.next()).getUtente());
		}
		return (modello_di_dominio.Utente[])lValues.toArray(new modello_di_dominio.Utente[lValues.size()]);
	}
	
	public void removeUtenteVoto(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Voto[] lVotos = votos.toArray();
		for(int i = 0; i < lVotos.length; i++) {
			if(lVotos[i].getUtente().equals(aUtente)) {
				votos.remove(lVotos[i]);
			}
		}
	}
	
	public void addUtente(modello_di_dominio.Voto aVoto, modello_di_dominio.Utente aUtente) {
		aVoto.setUtente(aUtente);
		votos.add(aVoto);
	}
	
	public modello_di_dominio.Voto getVotoByUtente(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Voto[] lVotos = votos.toArray();
		for(int i = 0; i < lVotos.length; i++) {
			if(lVotos[i].getUtente().equals(aUtente)) {
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
	
	public final modello_di_dominio.VotoSetCollection votos = new modello_di_dominio.VotoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_VOTOS, modello_di_dominio.ORMConstants.KEY_VOTO_DOCUMENTO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public modello_di_dominio.Utente[] getUtentesCommento() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = commentos.getIterator();lIter.hasNext();) {
			lValues.add(((modello_di_dominio.Commento)lIter.next()).getUtente());
		}
		return (modello_di_dominio.Utente[])lValues.toArray(new modello_di_dominio.Utente[lValues.size()]);
	}
	
	public void removeUtenteCommento(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Commento[] lCommentos = commentos.toArray();
		for(int i = 0; i < lCommentos.length; i++) {
			if(lCommentos[i].getUtente().equals(aUtente)) {
				commentos.remove(lCommentos[i]);
			}
		}
	}
	
	public void addUtente(modello_di_dominio.Commento aCommento, modello_di_dominio.Utente aUtente) {
		aCommento.setUtente(aUtente);
		commentos.add(aCommento);
	}
	
	public modello_di_dominio.Commento getCommentoByUtente(modello_di_dominio.Utente aUtente) {
		modello_di_dominio.Commento[] lCommentos = commentos.toArray();
		for(int i = 0; i < lCommentos.length; i++) {
			if(lCommentos[i].getUtente().equals(aUtente)) {
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
	
	public final modello_di_dominio.CommentoSetCollection commentos = new modello_di_dominio.CommentoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DOCUMENTO_COMMENTOS, modello_di_dominio.ORMConstants.KEY_COMMENTO_DOCUMENTO, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setProprietario(modello_di_dominio.Utente value) {
		if (proprietario != null) {
			proprietario.documentiUtente.remove(this);
		}
		if (value != null) {
			value.documentiUtente.add(this);
		}
	}
	
	public modello_di_dominio.Utente getProprietario() {
		return proprietario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Proprietario(modello_di_dominio.Utente value) {
		this.proprietario = value;
	}
	
	private modello_di_dominio.Utente getORM_Proprietario() {
		return proprietario;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
