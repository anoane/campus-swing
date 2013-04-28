package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import modello_di_dominio.Corso;
/**
 * 
 * @author mw
 *
 */
public class RiquadroCorso extends Riquadro {
	
	private JPanel anteprima;
	private JLabel titolo;
	private JTextPane descrizione;
	private JLabel facolta;
	private RimuoviButton rimuovi;
	
	/**
	 * 
	 */
	public RiquadroCorso(final Corso c) {
		super();
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());	

		
		anteprima = new JPanel();
		anteprima.setBounds(10, 34, 128, 128);
		anteprima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		anteprima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openCorso(false,c);
			}
		});

		titolo = new JLabel(c.getNome());
		titolo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		titolo.setForeground(Color.WHITE);
		titolo.setBounds(158, 11, 217, 40);
		
		descrizione = new JTextPane();
		descrizione.setToolTipText("Descrizione Corso");
		descrizione.setDisabledTextColor(Color.WHITE);
		descrizione.setBackground(super.getCorsoBgColor());
		descrizione.setEnabled(false);
		descrizione.setEditable(false);
		descrizione.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		descrizione.setText(c.getDescrizione());
		descrizione.setAlignmentY(Component.TOP_ALIGNMENT);
		descrizione.setLocation(158, 62);
		descrizione.setSize(217, 76);
		descrizione.setForeground(Color.WHITE);
		
		facolta = new JLabel(c.facolta.toArray()[0].getNome());
		facolta.setLocation(158, 138);
		facolta.setSize(245, 40);
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
