/**
 * 
 */
package gui.buttons;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
@SuppressWarnings("serial")
public class RimuoviButton extends CustomButton {
	
	protected static String iconPath = "./newimage/elimina.png";
	protected static String iconPathOver = "./newimage/eliminaOver.png";
	
	public RimuoviButton(String s) {
		super();
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		setToolTipText(s);
		final JLabel lblX = new JLabel();
		lblX.setIcon(new ImageIcon(iconPath));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(17, 0, 19, 26);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		add(lblX);
		
		final JLabel lblRimuovi = new JLabel(" Elimina");
		lblRimuovi.setForeground(Color.WHITE);
		lblRimuovi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRimuovi.setBounds(0, 34, 56, 14);
		add(lblRimuovi);
		
		lblRimuovi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lblRimuovi.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblRimuovi.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblRimuovi.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRimuovi.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lblRimuovi.getParent().dispatchEvent(e);
				
			}
		});
		
		lblX.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblX.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.getParent().dispatchEvent(e);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lblX.getParent().dispatchEvent(e);
				
			}
		});
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblRimuovi.setForeground(new Color(27,50,128));
				lblX.setIcon(new ImageIcon(iconPathOver));
				lblX.setToolTipText("Elimina il documento");
			}

			public void mouseExited(MouseEvent e) {
				lblRimuovi.setForeground(Color.WHITE);
				lblX.setIcon(new ImageIcon(iconPath));
			}			
		});
	}
	
	
	
}
