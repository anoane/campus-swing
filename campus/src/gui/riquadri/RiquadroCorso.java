package gui.riquadri;

import gui.CorsoPanel;
import gui.buttons.RimuoviButton;

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
	private JLabel titolo;
	private JLabel descrizione;
	private JLabel facolta;
	private RimuoviButton rimuovi;
	
	/**
	 * 
	 */
	public RiquadroCorso(Corso c) {
		super();
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());	

		
		anteprima = new JPanel();
		anteprima.setBounds(10, 11, 128, 128);

		titolo = new JLabel(c.getNome());
		titolo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		titolo.setForeground(Color.WHITE);
		titolo.setBounds(158, 11, 133, 40);
		
		descrizione = new JLabel(c.getDescrizione());
		descrizione.setLocation(158, 62);
		descrizione.setSize(245, 41);
		descrizione.setForeground(Color.WHITE);
		
		facolta = new JLabel(c.facolta.toArray()[0].getNome());
		facolta.setLocation(158, 116);
		facolta.setSize(245, 73);
		facolta.setForeground(Color.WHITE);
		
		rimuovi = new RimuoviButton("Cancella il documento");
		rimuovi.setToolTipText("Rimuovi il corso dai preferiti");
		rimuovi.setLocation(385, 5);
		
		add(anteprima);
		add(titolo);
		add(descrizione);
		add(facolta);
		add(rimuovi);
	}
	
	public RimuoviButton getRimuovi(){
		return this.rimuovi;
	}
}
