package gui.riquadri;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import modello_di_dominio.Correzione;
import java.awt.Insets;

public class RiquadroSuggerimento extends Riquadro {
	private JLabel lblImmagineProfilo;
	private JLabel lblAutore;
	private JLabel lblData;
	private JTextArea txtTesto;
	private JLabel lblOK;
	private JLabel lblApprova;
	private JLabel lblCancel;
	private JLabel lblCancella;
	private JLabel btnEspandi;

	public RiquadroSuggerimento(Correzione c) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());
		this.setPreferredSize(new Dimension(390, 125));
		this.setSize(390,125);
		lblImmagineProfilo = new JLabel("New label");
		lblImmagineProfilo.setBounds(10, 10, 55, 55);
		add(lblImmagineProfilo);
		
		lblAutore = new JLabel(c.getUtente().getNome());
		lblAutore.setBounds(10, 70, 98, 20);
		add(lblAutore);
		
		lblData = new JLabel(c.getTimestamp().toString());
		lblData.setBounds(10, 95, 98, 20);
		add(lblData);
		
		txtTesto = new JTextArea();
		txtTesto.setText(c.getTesto());
		txtTesto.setEditable(false);
		txtTesto.setWrapStyleWord(true);
		txtTesto.setLineWrap(true);
		txtTesto.setBounds(118, 10, 190, 105);
		add(txtTesto);
		
		lblOK = new JLabel("");
		lblOK.setIcon(new ImageIcon("./newimage/ok.png"));
		lblOK.setBounds(335, 5, 30, 30);
		add(lblOK);
		
		lblApprova = new JLabel("Approva");
		lblApprova.setBounds(330, 40, 46, 15);
		add(lblApprova);
		
		lblCancel = new JLabel("");
		lblCancel.setIcon(new ImageIcon("./newimage/cancel.png"));
		lblCancel.setBounds(335, 60, 30, 28);
		add(lblCancel);
		
		lblCancella = new JLabel("Cancella");
		lblCancella.setBounds(330, 100, 46, 14);
		add(lblCancella);
		
		btnEspandi = new JLabel();
		btnEspandi.setIcon(new ImageIcon("./newimage/reduce.png"));
		btnEspandi.setBounds(365, 2, 23, 23);
		add(btnEspandi);
	}
	
	public JLabel getEspandi(){
		return btnEspandi;
	}
}
