package gui.riquadri;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import modello_di_dominio.Correzione;

public class RiquadroSuggerimento extends Riquadro {
	private JLabel lblImmagineProfilo;
	private JLabel lblAutore;
	private JLabel lblData;
	private JTextArea txtTesto;
	private JLabel lblOK;
	private JLabel lblApprova;
	private JLabel lblCancel;
	private JLabel lblCancella;

	public RiquadroSuggerimento(Correzione c) {
		super();
		this.setBackground(super.getPreferitoBgColor());
		this.setBorder(super.getRiquadroBorder());	
		
		lblImmagineProfilo = new JLabel("New label");
		lblImmagineProfilo.setBounds(10, 10, 55, 55);
		add(lblImmagineProfilo);
		
		lblAutore = new JLabel(c.getUtente().getUsername());
		lblAutore.setBounds(10, 80, 90, 28);
		add(lblAutore);
		
		lblData = new JLabel(c.getTimestamp().toString());
		lblData.setBounds(10, 130, 90, 20);
		add(lblData);
		
		txtTesto = new JTextArea();
		txtTesto.setEditable(false);
		txtTesto.setWrapStyleWord(true);
		txtTesto.setLineWrap(true);
		txtTesto.setBounds(118, 20, 207, 160);
		add(txtTesto);
		
		lblOK = new JLabel("");
		lblOK.setIcon(new ImageIcon("./newimage/ok.png"));
		lblOK.setBounds(376, 20, 30, 28);
		add(lblOK);
		
		lblApprova = new JLabel("Approva");
		lblApprova.setBounds(364, 50, 46, 14);
		add(lblApprova);
		
		lblCancel = new JLabel("");
		lblCancel.setIcon(new ImageIcon("./newimage/cancel.png"));
		lblCancel.setBounds(376, 99, 30, 28);
		add(lblCancel);
		
		lblCancella = new JLabel("Cancella");
		lblCancella.setBounds(364, 138, 46, 14);
		add(lblCancella);
	}
}
