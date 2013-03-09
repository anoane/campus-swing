package gui;

import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

public interface ButtonInterface {
	
	public JButton createButton(String action, int X, int Y, int width, int height, String iconPath, Boolean focusPainted, Boolean borderPainted, Alignment hAlignment, int hMinSize, int hPrefSize, int hMaxSize, Alignment vAlignment, int vMinSize, int vPrefSize, int vMaxSize);
	
}
