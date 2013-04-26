package gui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Pagina extends JPanel {
	
	public Pagina(){
		super();
	}
	
	/**
	 * Metodo che carica il contenuto della specifica pagina
	 */
	public abstract void load();
	
	/**
	 * Metodo che ritorna la dimensione del pannello che contiene il contenuto della pagina
	 */
	public abstract int getHeight();

}
