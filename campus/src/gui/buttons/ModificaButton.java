/**
 * 
 */
package gui.buttons;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
public class ModificaButton extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/modifica.png";
	/**
	 * 
	 */
	public ModificaButton() {
		
		super();
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(iconPath));
		lblNewLabel.setBounds(35, 11, 46, 30);
		add(lblNewLabel);
	}
	
	
}
