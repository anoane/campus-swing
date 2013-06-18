/**
 * 
 */
package gui.buttons;
import gui.Home;
import gui.riquadri.RiquadroCommento;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modello_di_dominio.Commento;

/**
 * @author mw
 *
 */
public class RevertModificaCommento extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/revert_commento.png";
	/**
	 * 
	 */
	public RevertModificaCommento(final RiquadroCommento commento) {
		
		super();
		
		setSize(15,15);
		setBackground(null);
		setLayout(null);
		setBackground(new Color(255,255,255));
		
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(iconPath));
		lblNewLabel.setBounds(0, 0, 15, 15);
		add(lblNewLabel);
		
	}
}