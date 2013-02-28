package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.RouterController;

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
	public JButton createJButton(String icon,final String controller,final String action) {
		final MenuButton button = new MenuButton(icon);
		
		//Aggiungo il Listener
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				
			}
			@Override
			public void mouseClicked(MouseEvent arg0){
				if(button.isPressed() == 0){
					RouterController.getInstance().doAction(controller, action);
					button.pressButton();
				}else{
					button.resetButton();
				}
					
			}
		});
		
		return button;
	}
}
