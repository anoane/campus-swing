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
public class Riquadro extends JPanel {
	/**
	 * 
	 */
	protected int id;
	/**
	 * 
	 */
	protected static Color preferitoBgColor = new Color(67, 136, 204);
	/**
	 * 
	 * @param doc
	 */
	public Riquadro() {
		
		this.setSize(440, 200);
		this.setBackground(preferitoBgColor);
		this.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		setLayout(null);

	}
		
}


