package gui;

import gui.riquadri.RiquadroStampa;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GestioneStampa extends Pagina {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2221792807472367352L;
	private JPanel panel = new JPanel();
	
	public GestioneStampa() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 492);
		add(panel);
		
		JLabel label = new JLabel("Gestione delle stampe prenotate");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 327, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(55, 90, 900, 1);
		panel.add(separator_1);
		
		RiquadroStampa r1 = new RiquadroStampa("Appunti","doc", "Sistemi", 1, "Flash Copy", "12/12/13", "In stampa");
		r1.setLocation(55, 109);
		panel.add(r1);
		
		RiquadroStampa r2 = new RiquadroStampa("Esercizi","ppt", "Sistemi", 1, "Flash Copy", "12/12/13", "In stampa");
		r2.setLocation(55, 189);
		panel.add(r2);
		
		RiquadroStampa r3 = new RiquadroStampa("Slide","pdf", "Sistemi", 1, "Flash Copy", "12/12/13", "In stampa");
		r3.setLocation(55, 269);
		panel.add(r3);
		
		JLabel lblFile = new JLabel("File in Stampa");
		lblFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblFile.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFile.setForeground(new Color(6,121,159));
		lblFile.setBounds(55, 55, 132, 25);
		panel.add(lblFile);
		
		JLabel lblCopie = new JLabel("N° Copie");
		lblCopie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopie.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCopie.setForeground(new Color(6,121,159));
		lblCopie.setBounds(359, 55, 87, 25);
		panel.add(lblCopie);
		
		JLabel lblCopisteria = new JLabel("Copisteria");
		lblCopisteria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopisteria.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCopisteria.setForeground(new Color(6,121,159));
		lblCopisteria.setBounds(500, 55, 100, 25);
		panel.add(lblCopisteria);
		
		JLabel lblRitiro = new JLabel("Data Ritiro");
		lblRitiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRitiro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRitiro.setForeground(new Color(6,121,159));
		lblRitiro.setBounds(700, 55, 100, 25);
		panel.add(lblRitiro);
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reload(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}

}
