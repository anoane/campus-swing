package gui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Preferiti extends JPanel{
	public Preferiti() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 429));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPreferiti = new JLabel("Preferiti");
		lblPreferiti.setForeground(new Color(6, 121, 159));
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblPreferiti.setBounds(10, 10, 200, 25);
		panel.add(lblPreferiti);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel preferito = new JPanel();
		preferito.setBackground(new Color(67,136,204));
		preferito.setBounds(50, 71, 400, 150);
		panel.add(preferito);
		preferito.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(10, 21, 58, 24);
		preferito.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPUNTI");
		lblNewLabel.setBackground(new Color(0xFF,0x99,0x00));
		lblNewLabel.setBounds(5, 2, 54, 20);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
			}
		});
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 11, 116, 128);
		preferito.add(panel_1);
		
	}
}
