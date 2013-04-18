package gui.riquadri;

import gui.Corso;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Font;
/**
 * 
 * @author mw
 *
 */
public class RiquadroCorso extends Riquadro {
	/**
	 * 
	 */
	public RiquadroCorso(Corso c) {
		setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		setLayout(null);
		setSize(400, 150);
		setBackground(new Color(0x22,0x44,0x66));
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 128, 128);
		add(panel);
		
		JLabel label = new JLabel(c.getName());
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setForeground(Color.WHITE);
		label.setBounds(142, 11, 158, 24);
		add(label);
		
	}
}
