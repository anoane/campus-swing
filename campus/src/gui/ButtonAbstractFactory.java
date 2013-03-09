package gui;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;

public interface ButtonAbstractFactory {
	
	public JButton createButton(String action, int X, int Y, int width, int height, String iconPath, Boolean focusPainted, Boolean borderPainted);
	
}
