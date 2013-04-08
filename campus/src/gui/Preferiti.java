package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;
import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.FlowLayout;

public class Preferiti extends JPanel{
	
	private ArrayList<JPanel> preferiti = new ArrayList<JPanel>();
	private Color preferitoBgColor = new Color(67,136,204);
	//private 
	
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
		preferito.setBackground(preferitoBgColor);
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
				Home.openDocument(true);
			}
		});
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 11, 116, 128);
		preferito.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(217, 116, 346, 218);
		preferito.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
	}
	

	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source background new java.awt.Color(67,136,204)
	 * @wbp.factory.parameter.source layout null
	 * @wbp.factory.parameter.source arg0 panel_2
	 * @wbp.factory.parameter.source arg0_1 panel_1
	 */
	public static JPanel addPreferito(Color background, LayoutManager layout, Component arg0, Component arg0_1) {
		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setLayout(layout);
		panel.add(arg0);
		panel.add(arg0_1);
		return panel;
	}
}
