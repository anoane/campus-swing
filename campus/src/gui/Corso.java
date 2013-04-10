package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Component;

@SuppressWarnings("serial")
public class Corso extends JPanel {

	/**
	 * Create the panel.
	 */
	public Corso( modello_di_dominio.Corso corso) {
		
		//Absolute layout
		setLayout(null);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(new Rectangle(0, 0, 1008, 429));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 429);
		add(panel);
		
		//Label
		JLabel labelName = new JLabel(corso.getNome());
		labelName.setForeground(new Color(6, 121, 159));
		labelName.setFont(new Font("Arial", Font.BOLD, 20));
		labelName.setBounds(10, 10, 200, 25);
		panel.add(labelName);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel seguiButton = new JPanel();
		seguiButton.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		seguiButton.setBounds(220, 11, 157, 34);
		seguiButton.setBackground(new Color(0x2E,0x5D,0x8C));
		panel.add(seguiButton);
		
		JLabel lblSegui = new JLabel("Segui Corso");
		lblSegui.setForeground(Color.WHITE);
		lblSegui.setFont(new Font("Arial", Font.PLAIN, 18));
		seguiButton.add(lblSegui);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 53, 988, 352);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(0x1B, 0x32, 0x80));
		separator_1.setBounds(488, 10, 2, 300);
		panel_1.add(separator_1);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		labelName.setForeground(new Color(6, 121, 159));
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDescrizione.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDescrizione.setBounds(10, 10, 102, 28);
		panel_1.add(lblDescrizione);
		
	}
}
