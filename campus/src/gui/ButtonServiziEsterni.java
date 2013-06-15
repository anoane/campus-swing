package gui;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

public class ButtonServiziEsterni  {

	private boolean opened = false;

	public JButton createButton(final String action, int x, int y, int width,
			int height, final String iconPath, final String iconPath2, Boolean focusPainted,
			Boolean borderPainted, final Boolean altezzaDinamica, final Alignment hAlignment, final int hMinSize, final int hPrefSize, final int hMaxSize, final Alignment vAlignment, final int vMinSize, final int vPrefSize, final int vMaxSize) {
		final JButton button = new JButton();
		button.setBounds(x, y, width, height);
		button.setIcon(new ImageIcon(iconPath));
		button.setFocusPainted(focusPainted);
		button.setBorderPainted(borderPainted);
		button.setBackground(Home.BLUE_BUTTON_UNPRESSED);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				button.setBackground(Home.getOldButtonColor(action));
			}

			public void mouseClicked(MouseEvent e) {
				if (!opened) {
					Home.showServiziEsterni();
					button.setIcon(new ImageIcon(iconPath2));
					opened = true;
				} else {
					Home.hideServiziEsterni();
					button.setIcon(new ImageIcon(iconPath));
					opened = false;
				}
				//Home.setOldButtonColor("servizi_esterni", Home.BLUE_BUTTON_PRESSED);
				//button.setBackground(Home.BLUE_BUTTON_PRESSED);
				
				/*if (altezzaDinamica) {
					Home.loadPages(Home.getPaginaCorrispondente(action), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, Home.getAltezzaDinamica(), vMaxSize);	
				} else {
					Home.loadPages(Home.getPaginaCorrispondente(action), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, vPrefSize, vMaxSize);
				}*/
			}
		});
		return button;
	}

}
