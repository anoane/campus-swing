package gui;

import javax.swing.JPanel;
/**
 * 
 * @author mw
 *
 */
public abstract class Pagina extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2638112733315713624L;

	public abstract void reload();
	public abstract void reload(Object o);
	public abstract int getAltezzaPagina();
	
	
	
}

