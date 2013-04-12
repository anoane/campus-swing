/**
 * 
 */
package gui.buttons;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 * @author mw
 *
 */
public class RimuoviButton extends CustomButton {
	
	public RimuoviButton() {
		super();
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(17, 0, 16, 32);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		add(lblX);
		
		JLabel lblRimuovi = new JLabel("Rimuovi");
		lblRimuovi.setForeground(Color.WHITE);
		lblRimuovi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRimuovi.setBounds(0, 34, 56, 14);
		add(lblRimuovi);
	}
	
	
	
}
