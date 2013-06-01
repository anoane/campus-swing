package gui.helpers;

import modello_di_dominio.Documento;

public class DocFlag {

	private Documento doc;
	private boolean attivaModifica;

	public DocFlag(Documento doc, boolean attivaModifica) {
		this.doc = doc;
		this.attivaModifica = attivaModifica;
	}
	
	public Documento getDoc() {
		return doc;
	}
	
	public boolean getFlag() {
		return attivaModifica;
	}
	
}
