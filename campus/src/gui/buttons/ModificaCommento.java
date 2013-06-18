/**
 * 
 */
package gui.buttons;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
public class ModificaCommento extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/modifica_commento.png";
	/**
	 * 
	 */
	public ModificaCommento() {
		
		super();
		
		setSize(15,15);
		setBackground(null);
		setLayout(null);
		setBackground(new Color(255,255,255));
		
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(iconPath));
		lblNewLabel.setBounds(0, 0, 15, 15);
		add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(237,239,244));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(255,255,255));
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {}
			
		});
		
	}
}
