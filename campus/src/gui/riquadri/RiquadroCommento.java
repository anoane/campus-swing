
package gui.riquadri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Commento;

import java.awt.Dimension;

/**
 * @author mw
 * 
 */
public class RiquadroCommento extends JPanel {

	JTextArea descrizione = new JTextArea();
	
	public RiquadroCommento(Commento commento) {
		//Color c = new Color(0x1B, 0x32, 0x80);
		//setBorder(new LineBorder(c));
		this.setSize(446, 62);
		//this.setBackground(new Color(0x43, 0x88, 0xCC));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(4, 4, 54, 54);
		Image resized = new ImageIcon("."+commento.getUtente().getImmagine()).getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH);  
		lblNewLabel.setIcon(new ImageIcon(resized));
		add(lblNewLabel);
		
		DefaultCaret caret2 = (DefaultCaret) descrizione.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		descrizione.setText(commento.getCommento());
		descrizione.setCaretPosition(0);
		descrizione.setFont(new Font("Arial", Font.PLAIN, 12));
		descrizione.setEditable(false);
		descrizione.setBounds(62,26,374,32);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setText(util.StringUtility.truncateLines(descrizione,3));
		add(descrizione);
		
		JLabel nomeUtente = new JLabel(commento.getUtente().getNome()+" "+commento.getUtente().getCognome());
		nomeUtente.setBounds(62, 11, 278, 14);
		add(nomeUtente);
		//descrizione.addMouseListener(comportamento);
		//descrizione.setBackground(exitedColor);
	}
}
