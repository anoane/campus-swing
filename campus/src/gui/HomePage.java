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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

@SuppressWarnings("serial")
public class HomePage extends JPanel {
	private JTextField textField;
	private final static JPanel panel_1 = new JPanel();
	private final static JSeparator separator_3 = new JSeparator();
	private final static JSeparator separator_4 = new JSeparator();
	private static String homeBottomText = "prova";
	private final static JLabel label_6 = new JLabel("new label");
	
	
	public static String getHomeBottomText() {
		
		return homeBottomText;
		
	}
	
	public static void setHomeBottomText(String a) {
		homeBottomText=a;
	}
	
	public void reload() {
		label_6.setText(getHomeBottomText());
	}

	/**
	 * Create the panel.
	 */
	public HomePage() {
		setLayout(null);
		
		final JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 1008, 429);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		
		panel.getParent().addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				int dimensione_fill_home_bottom = (panel.getParent().getHeight()
						- Home.MIN_DIMENSION_Y + 300);
				panel.setBounds(panel.getX(), panel.getY(),
						panel.getWidth(),
						panel.getHeight()+dimensione_fill_home_bottom);
				panel_1.setBounds(0, dimensione_fill_home_bottom+97,
						panel_1.getWidth(),
						panel_1.getHeight());
				separator_3.setBounds(330, 48, 1, dimensione_fill_home_bottom+29);
				separator_4.setBounds(660, 48, 1, dimensione_fill_home_bottom+29);
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
		
		JLabel label = new JLabel("Ultimi corsi seguiti");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 200, 25);
		panel.add(label);
		
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
		
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(46, 93, 140));
		panel_1.setBounds(0, 266, 1008, 163);
		panel.add(panel_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(330, 20, 1, 163);
		panel_1.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setForeground(Color.WHITE);
		separator_6.setBounds(660, 20, 1, 163);
		panel_1.add(separator_6);
		
		JLabel label_3 = new JLabel("Ordini stampa");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 20));
		label_3.setBounds(10, 10, 200, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Classifica utenti");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.BOLD, 20));
		label_4.setBounds(670, 10, 273, 25);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Ordini digitalizzazione");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 20));
		label_5.setBounds(340, 10, 263, 25);
		panel_1.add(label_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 40, 310, 31);
		panel_1.add(panel_2);
		
		panel_2.add(label_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 81, 310, 31);
		panel_1.add(panel_3);
		
		JLabel label_7 = new JLabel("New label");
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 122, 310, 31);
		panel_1.add(panel_4);
		
		JLabel label_8 = new JLabel("New label");
		panel_4.add(label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 52, 310, 97);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 159, 310, 97);
		panel.add(panel_6);
		
		textField = new JTextField();
		textField.setText("Cambia valore label TEST");
		textField.setColumns(10);
		textField.setBounds(350, 72, 132, 40);
		panel.add(textField);
		
		JButton button = new JButton("Cambia");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setHomeBottomText(textField.getText());
			}
		});
		button.setBounds(492, 81, 89, 23);
		panel.add(button);
		
		JLabel lblAdattativa = new JLabel("ADATTATIVA");
		lblAdattativa.setBounds(364, 168, 170, 14);
		panel.add(lblAdattativa);

		
		reload();
	}
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source arg0 label_6
	 * Questo metodo aggiunge ordini di stampa
	 */
	public static JPanel createOrdiniStampa(Component arg0) {
		JPanel panel = new JPanel();
		panel.add(arg0);
		return panel;
	}
}
