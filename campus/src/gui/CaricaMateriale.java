package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.Controller;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CaricaMateriale extends JPanel  {
	private final static JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	/**
	 * Create the panel.
	 */
	public CaricaMateriale() {
		setLayout(null);

		panel.setBounds(0, 0, 1008, 542);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);

		panel.getParent().addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				@SuppressWarnings("unused")
				int dimensione_fill_home_bottom = (panel.getParent().getHeight()
						- Home.MIN_DIMENSION_Y + 300);
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
		
		JLabel lblUltimiCorsiSeguiti = new JLabel("Carica materiale");
		lblUltimiCorsiSeguiti.setForeground(new Color(6, 121, 159));
		lblUltimiCorsiSeguiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblUltimiCorsiSeguiti.setBounds(10, 10, 310, 25);
		panel.add(lblUltimiCorsiSeguiti);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 50, 1008, 492);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(3dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85dlu;default)"),
				ColumnSpec.decode("max(159dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(37dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(60dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),}));
		
		JLabel lblNewLabel = new JLabel("File");
		panel_1.add(lblNewLabel, "3, 2");
		
		JLabel lblNewLabel_1 = new JLabel("Titolo");
		panel_1.add(lblNewLabel_1, "3, 3, right, default");
		
		textField = new JTextField();
		panel_1.add(textField, "4, 3, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrizione");
		panel_1.add(lblNewLabel_2, "3, 4, right, default");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "4, 4, fill, fill");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		panel_1.add(lblNewLabel_3, "3, 5");
		
		JLabel lblNewLabel_4 = new JLabel("Facolt\u00E0");
		panel_1.add(lblNewLabel_4, "3, 6, right, default");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "4, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Universit\u00E0");
		panel_1.add(lblNewLabel_5, "3, 7, right, default");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "4, 7, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Corso");
		panel_1.add(lblNewLabel_6, "3, 8, right, default");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "4, 8, fill, default");
		textField_4.setColumns(10);
		
		JButton btnCaricaMateriale = new JButton("Carica materiale");
		panel_1.add(btnCaricaMateriale, "4, 9");

	}
}