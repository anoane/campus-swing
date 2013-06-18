/**
 * 
 */
package gui.buttons;
import gui.Home;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author mw
 *
 */
public class EliminaCommento extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/elimina_commento.png";
	/**
	 * 
	 */
	public EliminaCommento() {
		
		super();
		
		setSize(15,15);
		setBackground(null);
		setLayout(null);
		//setBackground(new Color(237,239,244));
		setBackground(new Color(255,255,255));
		
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(iconPath));
		lblNewLabel.setBounds(0, 0, 15, 15);
		add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(237,239,244));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(255,255,255));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>Sei sicuro di voler eliminare definitivamente questo commento?</font><br><br><font color=000000 face=arial size=4></font><br></html>","Attenzione",0,JOptionPane.WARNING_MESSAGE);
				if(n==0){
					//removecommento
					//reloaddoc
				}
			}
			
		});
		
	}
}
