package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonStandard implements ButtonAbstractFactory {

	private JButton standardButton = new JButton();
	
	@Override
	public JButton createButton(final String action, int x, int y, int width,
			int height, String iconPath, Boolean focusPainted,
			Boolean borderPainted) {
		standardButton.setBounds(x, y, width, height);
		standardButton.setIcon(new ImageIcon(iconPath));
		standardButton.setFocusPainted(focusPainted);
		standardButton.setBorderPainted(borderPainted);
		standardButton.setBackground(Home.BLUE_BUTTON_UNPRESSED);
		standardButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				standardButton.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				standardButton.setBackground(Home.getOldButtonColor(action));
			}

			public void mouseClicked(MouseEvent e) {
				Home.pulsantiNormali();
				Home.setOldButtonColor(action, Home.BLUE_BUTTON_PRESSED);
				standardButton.setBackground(Home.BLUE_BUTTON_PRESSED);
			}
		});
		return standardButton;
	}


}
