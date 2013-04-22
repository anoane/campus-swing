package gui.riquadri;

import gui.CorsoPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modello_di_dominio.Corso;

import java.awt.Font;
/**
 * 
 * @author mw
 *
 */
public class RiquadroCorso extends Riquadro {
	
	private JPanel anteprima;
	//private JPanel pulsanti;
	private JLabel titolo;
	private JLabel descrizione;
	private JLabel facolta;
	
	/**
	 * 
	 */
	public RiquadroCorso(Corso corso) {
		super();
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());
		
		// Riquadro Anteprima
		anteprima = new JPanel();
		anteprima.setBounds(20, 16, 165, 170);
		anteprima.setBackground(Color.WHITE);
		anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		
		// Label title
		titolo = new JLabel(corso.getNome());
		titolo.setBounds(195, 11, 133, 40);
		titolo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		titolo.setForeground(Color.WHITE);
				
		// Label descrizione
		descrizione = new JLabel(corso.getDescrizione());
		descrizione.setLocation(185, 80);
		descrizione.setSize(245, 41);
		
		add(titolo);
		add(facolta);
		add(descrizione);
		add(anteprima);
	}
}
