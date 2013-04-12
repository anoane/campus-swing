/**
 * 
 */
package gui.buttons;

import java.awt.Cursor;

import javax.swing.JPanel;

/**
 * @author mw
 *
 */
public class CustomButton extends JPanel {

	public CustomButton(){
		super();
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
