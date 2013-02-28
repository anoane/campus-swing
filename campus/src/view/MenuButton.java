/**
 * 
 */
package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author mw
 *
 */
public class MenuButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5673543130563185661L;
	/**
	 *  0 pressed
	 *  1 released
	 */
	private int status = 0;
	/**
	 * 
	 */
	private static Color colorReleased = new Color(67, 136, 204);
	/**
	 * 
	 */
	private static Color colorPressed = new Color(46, 93, 140);
	/**
	 * 
	 */
	public MenuButton(String icon){
		this.setIcon(new ImageIcon(icon));
		this.setBackground(colorReleased);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
	}
	/**
	 * 
	 */
	public void resetColor() {
		
		if(status == 0){
			this.setBackground(colorReleased);
		}else{
			this.setBackground(colorPressed);
		}
		
		
	}
	/**
	 * 
	 */
	public void pressButton(){
		
		this.status = 1;
		this.setBackground(colorPressed);
	}
	/**
	 * 
	 */
	public void resetButton(){
		
		this.status = 0;
		this.setBackground(colorReleased);
		
	}
	/**
	 * 
	 * @return
	 */
	public int isPressed(){
		return status;
	}
}
