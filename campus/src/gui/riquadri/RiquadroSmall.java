/**
 * 
 */
package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;

/**
 * @author Igor
 *
 */
public class RiquadroSmall extends JPanel {
	/**
	 * 
	 */
	protected int id;
	/**
	 * 
	 */
	private static Color preferitoBgColor = new Color(67, 136, 204);
	private static Color preferitoOverBgColor = new Color(87, 156, 224);
	/**
	 * 
	 */
	private static Color corsoBgColor = new Color(0x22,0x44,0x66);
	
	private static LineBorder riquadroBorder = new LineBorder(new Color(0x1B, 0x32, 0x80), 2);
	
	
	public RiquadroSmall() {
		super();
		this.setSize(310, 97);
		this.setLayout(null);
	}

	/**
	 * @return the preferitoBgColor
	 */
	public static Color getPreferitoOverBgColor() {
		return preferitoOverBgColor;
	}

	/**
	 * @param preferitoBgColor the preferitoBgColor to set
	 */
	public static void setPreferitoOverBgColor(Color preferitoBgColor) {
		RiquadroSmall.preferitoOverBgColor = preferitoOverBgColor;
	}
	
	/**
	 * @return the corsoBgColor
	 */
	public static Color getCorsoBgColor() {
		return corsoBgColor;
	}

	/**
	 * @param corsoBgColor the corsoBgColor to set
	 */
	public static void setCorsoBgColor(Color corsoBgColor) {
		RiquadroSmall.corsoBgColor = corsoBgColor;
	}

	/**
	 * @return the preferitoBgColor
	 */
	public static Color getPreferitoBgColor() {
		return preferitoBgColor;
	}

	/**
	 * @param preferitoBgColor the preferitoBgColor to set
	 */
	public static void setPreferitoBgColor(Color preferitoBgColor) {
		RiquadroSmall.preferitoBgColor = preferitoBgColor;
	}

	/**
	 * @return the riquadroBorder
	 */
	public static LineBorder getRiquadroBorder() {
		return riquadroBorder;
	}

	/**
	 * @param riquadroBorder the riquadroBorder to set
	 */
	public static void setRiquadroBorder(LineBorder riquadroBorder) {
		RiquadroSmall.riquadroBorder = riquadroBorder;
	}





	
}


