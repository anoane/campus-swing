package gui;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;


import controller.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CorsiSeguiti extends JPanel {
	private final static JPanel panel = new JPanel();
	private final static int MIN_DIMENSION_X = 1024;
	private final static int MIN_DIMENSION_Y = 560;
	private final static JSeparator separator_3 = new JSeparator();
	private final static JSeparator separator_4 = new JSeparator();
	private static int numero_caselle = 0;
	

	public static void reload() {
		numero_caselle = Controller.loadNumeroCorsiSeguiti();
		for (int i=0; i < numero_caselle; i++) {
			creaCasellina(i);
		}
		int altezza = 52+numero_caselle*10+numero_caselle*97;
		panel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), altezza);
		Home.setDimCorsiSeguiti(altezza);
	}

	public static JPanel creaCasellina(int i) {
		JPanel panel_nuova = new JPanel();
		panel_nuova.setBounds(10, 52+i*10+i*97, 310, 97);
		panel.add(panel_nuova);
		return panel_nuova;
	}
	
	/**
	 * Create the panel.
	 */
	public CorsiSeguiti() {
		setLayout(null);
		
		
		panel.setBounds(0, 0, 1008, 542);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		
		panel.getParent().addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				int dimensione_fill_home_bottom = (panel.getParent().getHeight()
						- MIN_DIMENSION_Y + 300);
				/*panel.setBounds(panel.getX(), panel.getY(),
						panel.getWidth(),
						panel.getHeight()+dimensione_fill_home_bottom);*/
				/*panel_1.setBounds(0, dimensione_fill_home_bottom+97,
						panel_1.getWidth(),
						panel_1.getHeight());*/
				//separator_3.setBounds(330, 48, 1, dimensione_fill_home_bottom+29);
				//separator_4.setBounds(660, 48, 1, dimensione_fill_home_bottom+29);
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		
		JLabel lblUltimiCorsiSeguiti = new JLabel("Ultimi corsi seguiti AAAAAAAAAAAAAAAAAA");
		lblUltimiCorsiSeguiti.setForeground(new Color(6, 121, 159));
		lblUltimiCorsiSeguiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblUltimiCorsiSeguiti.setBounds(10, 10, 310, 25);
		panel.add(lblUltimiCorsiSeguiti);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JLabel label_1 = new JLabel("Preferiti recenti");
		label_1.setForeground(new Color(6, 121, 159));
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setBounds(350, 10, 200, 25);
		panel.add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(340, 41, 170, 1);
		panel.add(separator_1);
		
		JLabel label_2 = new JLabel("I miei documenti recenti");
		label_2.setForeground(new Color(6, 121, 159));
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(680, 10, 270, 25);
		panel.add(label_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(670, 41, 170, 1);
		panel.add(separator_2);
		
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(new Color(27, 50, 128));
		separator_3.setBounds(330, 48, 1, 198);
		panel.add(separator_3);
		
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(new Color(27, 50, 128));
		separator_4.setBounds(660, 48, 1, 198);
		panel.add(separator_4);
		
		JLabel lblNonAdattativa = new JLabel("NON ADATTATIVA");
		lblNonAdattativa.setBounds(379, 170, 171, 40);
		panel.add(lblNonAdattativa);

	}

}
