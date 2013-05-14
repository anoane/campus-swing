/**
 * 
 */
package gui.buttons;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
@SuppressWarnings("serial")
public class RimuoviCorsoSeguito extends CustomButton {
	
	protected static String iconPath = "./newimage/eliminaCorsoSeguito.png";
	
	public RimuoviCorsoSeguito(String s) {
		super();
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		setToolTipText(s);
		JLabel lblX = new JLabel();
		lblX.setIcon(new ImageIcon(iconPath));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(17, 0, 19, 26);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		add(lblX);
		
		JLabel lblRimuovi = new JLabel("Rimuovi");
		lblRimuovi.setForeground(Color.WHITE);
		lblRimuovi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRimuovi.setBounds(0, 34, 56, 14);
		add(lblRimuovi);
	}
	
	
	
}
