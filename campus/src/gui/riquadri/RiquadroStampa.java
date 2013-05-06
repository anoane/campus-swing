/**
 * 
 */
package gui.riquadri;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * @author mw
 *
 */
public class RiquadroStampa extends JPanel {
	
	public RiquadroStampa() {
		this.setSize(800, 49);
		this.setBackground(Color.RED);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(294, 11, 1, 27);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(355, 11, 7, 27);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(525, 11, 1, 27);
		add(separator_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(116, 11, 64, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(308, 24, 37, 14);
		add(lblNewLabel_1);
	}
}
