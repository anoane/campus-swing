
package gui.riquadri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

/**
 * @author mw
 * 
 */
public class RiquadroCommento extends JPanel {

	public RiquadroCommento(String type,String estenzione, String nome,int copie, String copisteria, String data, String stato) {
		Color c = new Color(0x1B, 0x32, 0x80);
		setBorder(new LineBorder(c));
		this.setSize(446, 43);
		this.setBackground(new Color(0x43, 0x88, 0xCC));
		setLayout(null);
		
		
	}
}
