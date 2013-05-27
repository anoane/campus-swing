/**
 * 
 */
package gui.buttons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
public class EliminaButton extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/elimina.png";
	protected static String iconPathOver = "./newimage/eliminaOver.png";
	/**
	 * 
	 */
	public EliminaButton() {
		
		super();
		
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(iconPath));
		lblNewLabel.setBounds(35, 11, 46, 30);
		add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(iconPathOver));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(iconPath));
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
