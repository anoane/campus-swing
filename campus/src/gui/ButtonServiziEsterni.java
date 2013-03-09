package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

public class ButtonServiziEsterni implements ButtonInterface {

	@Override
	public JButton createButton(final String action, int x, int y, int width,
			int height, String iconPath, Boolean focusPainted,
			Boolean borderPainted, Alignment hAlignment, int hMinSize, int hPrefSize, int hMaxSize, Alignment vAlignment, int vMinSize, int vPrefSize, int vMaxSize) {
		final JButton button = new JButton();
		button.setBounds(x, y, width, height);
		button.setIcon(new ImageIcon(iconPath));
		button.setFocusPainted(focusPainted);
		button.setBorderPainted(borderPainted);
		button.setBackground(Home.BLUE_BUTTON_UNPRESSED);
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				button.setBackground(Home.getOldButtonColor(action));
			}

			public void mouseClicked(MouseEvent e) {
				Home.pulsantiNormali();
				Home.setOldButtonColor(action, Home.BLUE_BUTTON_PRESSED);
				button.setBackground(Home.BLUE_BUTTON_PRESSED);
			}
		});
		return button;
	}

}
