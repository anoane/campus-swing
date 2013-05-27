/**
 * 
 */
package gui.riquadri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

/**
 * @author mw
 * 
 */
public class RiquadroStampa extends JPanel {

	public RiquadroStampa(String type,String estenzione, String nome,int copie, String copisteria, String data, String stato) {
		Color c = new Color(0x1B, 0x32, 0x80);
		setBorder(new LineBorder(c));
		this.setSize(900, 60);
		this.setBackground(new Color(0x43, 0x88, 0xCC));
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(c);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(300, 5, 1, 50);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(c);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(395, 5, 1, 50);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(c);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(595, 5, 1, 50);
		add(separator_2);

		JLabel lblNome = new JLabel(nome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNome.setBounds(170, 15, 120, 30);
		add(lblNome);

		JLabel lblcopie = new JLabel(String.valueOf(copie));
		lblcopie.setHorizontalAlignment(SwingConstants.CENTER);
		lblcopie.setForeground(Color.WHITE);
		lblcopie.setFont(new Font("Arial", Font.PLAIN, 18));
		lblcopie.setBounds(330, 15, 35, 30);
		add(lblcopie);

		JLabel label = new JLabel(copisteria);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(424, 15, 147, 30);
		add(label);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(c);
		separator_3.setBounds(795, 5, 1, 50);
		add(separator_3);

		JLabel label_1 = new JLabel(data);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(637, 15, 120, 30);
		add(label_1);

		
		// JPanel tipo
		JPanel tipo = new JPanel();
		tipo.setBounds(10, 15, 80, 30);
		tipo.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		tipo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// Label Tipo
		// TODO: Modificare l'etichetta del documento
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setPreferredSize(new Dimension(80, 25));
		lblNewLabel.setSize(80, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipo.add(lblNewLabel, BorderLayout.CENTER);
		switch (type) {
		case "Appunti":
			lblNewLabel.setText("Appunti");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x99, 0x00));
			//lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Dispense":
			lblNewLabel.setText("Dispense");
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			//lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Esercizi":
			lblNewLabel.setText("Esercizi");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			//lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		case "Slide":
			lblNewLabel.setText("Slide");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			//lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		default:
			lblNewLabel.setText("Documento");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x00, 0x00));
			//lblNewLabel.getParent().setBounds(10, 56, 58, 24);
			break;
		}
		add(tipo);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(841, 10, 25, 25);
		lblImage.setIcon(new ImageIcon("./newimage/stampa.png"));
		add(lblImage);
		
		JLabel lblNewLabel_1 = new JLabel("In stampa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(817, 35, 73, 20);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblNewLabel_1);
		
		JLabel lblEstenzione = new JLabel();
		switch (estenzione) {
		case "doc":
			lblEstenzione.setIcon(new ImageIcon("./newimage/doc.png"));
			break;
		case "pdf":
			lblEstenzione.setIcon(new ImageIcon("./newimage/pdf.png"));
			break;
		case "ppt" :
			lblEstenzione.setIcon(new ImageIcon("./newimage/ppt.png"));
			break;
		default:
			lblEstenzione.setIcon(new ImageIcon("./newimage/doc.png"));
			break;
		}
		
		lblEstenzione.setBounds(105, 15, 45, 30);
		add(lblEstenzione);
	}
}
