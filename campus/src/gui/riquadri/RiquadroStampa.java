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
import java.awt.Font;

/**
 * @author mw
 *
 */
public class RiquadroStampa extends JPanel {
	
	public RiquadroStampa() {
		this.setSize(800, 49);
		this.setBackground(new Color(0x43, 0x88, 0xCC));
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(294, 11, 1, 27);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(355, 11, 7, 27);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(525, 11, 1, 27);
		add(separator_2);
		
		JLabel lblNome = new JLabel("New label");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(116, 11, 94, 27);
		add(lblNome);
		
		JLabel lblcopie = new JLabel("New label");
		lblcopie.setForeground(Color.WHITE);
		lblcopie.setFont(new Font("Arial", Font.PLAIN, 20));
		lblcopie.setBounds(305, 17, 37, 14);
		add(lblcopie);
		
		JLabel label = new JLabel("New label");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(368, 11, 147, 27);
		add(label);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(721, 11, 1, 27);
		add(separator_3);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(553, 11, 147, 27);
		add(label_1);
	}
}
