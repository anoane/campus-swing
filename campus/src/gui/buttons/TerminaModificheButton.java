/**
 * 
 */
package gui.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
@SuppressWarnings("serial")
public class TerminaModificheButton extends CustomButton {
	/**
	 * 
	 */
	protected static String iconPath = "./newimage/save_blue.png";
	protected static String iconPathOver = "./newimage/save_light_blue.png";
	/**
	 * 
	 */
	public TerminaModificheButton(String s) {
		super();
		setSize(52,52);
		setBackground(null);
		setLayout(null);
		setToolTipText(s);
		final JLabel lblX = new JLabel();
		lblX.setIcon(new ImageIcon(iconPath));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(45, 0, 28, 28);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		add(lblX);
		
		final JLabel lblRimuovi = new JLabel("Salva modifiche");
		lblRimuovi.setForeground(new Color(27,50,128));
		lblRimuovi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRimuovi.setBounds(0, 34, 124, 14);
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
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				lblRimuovi.setForeground(new Color(27,50,128));
				lblX.setIcon(new ImageIcon(iconPathOver));
				lblX.setToolTipText("Salve le modifiche");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRimuovi.setForeground(new Color(27,50,128));
				lblX.setIcon(new ImageIcon(iconPath));
				lblX.setToolTipText("Salva le modifiche");
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
