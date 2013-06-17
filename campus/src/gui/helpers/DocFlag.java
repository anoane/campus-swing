package gui.helpers;

import modello_di_dominio.Documento;

public class DocFlag {

	private Documento doc;
	private boolean attivaModifica;
	private boolean commentiAperti;

	public DocFlag(Documento doc, boolean attivaModifica, boolean commentiAperti) {
		this.doc = doc;
		this.attivaModifica = attivaModifica;
		this.commentiAperti = commentiAperti;
	}
	
	public Documento getDoc() {
		return doc;
	}
	
	public boolean getFlag() {
		return attivaModifica;
	}
	
	public boolean getCommentiAperti() {
		return commentiAperti;
	}
	
}
