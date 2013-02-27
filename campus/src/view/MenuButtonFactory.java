package view;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

/**
 * 
 * @author mw
 * 
 * Button Factory
 * Questa classe ha la responsibilità di creare i pulsanti
 *
 */
public class MenuButtonFactory {
	/**
	 * 
	 */
	private static MenuButtonFactory instance;
	
	private Color released = new Color(67, 136, 204);
	private Color pressed = new Color(67, 136, 204);
	
	/**
	 * 
	 */
	protected MenuButtonFactory(){
		
	}
	/**
	 * 
	 */
	public static MenuButtonFactory getInstance() {
		
		if(instance == null){
			instance = new MenuButtonFactory();
		}
		
		return instance;
		
	}
	
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source background BLUE_BUTTON_UNPRESSED
	 */
	public JButton createJButton() {
		final JButton button = new JButton();
		button.setIcon(new ImageIcon("./newimage/corsi_seguiti.png"));
		button.setBackground(released);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		
		//Aggiungo il Listener
		button.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				button.setBackground(pressed);
			}
			@Override
			public void focusLost(FocusEvent arg0){
				button.setBackground(released);
			}
		});
		
		return button;
	}
}
