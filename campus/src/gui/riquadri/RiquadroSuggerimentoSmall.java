package gui.riquadri;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import modello_di_dominio.Correzione;

public class RiquadroSuggerimentoSmall extends Riquadro {
	private JLabel lblImmagineProfilo;
	private JLabel lblAutore;
	private JLabel lblData;
	private JTextArea txtTesto;
	private JLabel lblOK;
	private JLabel lblCancel;

	public RiquadroSuggerimentoSmall(Correzione c) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());
		this.setPreferredSize(new Dimension(390, 85));
		
		lblImmagineProfilo = new JLabel("New label");
		lblImmagineProfilo.setBounds(10, 10, 55, 55);
		add(lblImmagineProfilo);
		
		lblAutore = new JLabel(c.getUtente().getNome());
		lblAutore.setBounds(10, 60, 98, 20);
		add(lblAutore);
		
		lblData = new JLabel(c.getTimestamp().toString());
		lblData.setBounds(121, 60, 140, 20);
		add(lblData);
		
		txtTesto = new JTextArea(c.getTesto());
		txtTesto.setEditable(false);
		txtTesto.setWrapStyleWord(true);
		txtTesto.setLineWrap(true);
		txtTesto.setBounds(90, 10, 240, 40);
		add(txtTesto);
		
		lblOK = new JLabel("");
		lblOK.setIcon(new ImageIcon("./newimage/ok.png"));
		lblOK.setBounds(350, 10, 30, 30);
		add(lblOK);
		
		lblCancel = new JLabel("");
		lblCancel.setIcon(new ImageIcon("./newimage/cancel.png"));
		lblCancel.setBounds(350, 45, 30, 28);
		add(lblCancel);
	}
}
