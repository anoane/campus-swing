package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviButton;
import gui.buttons.RimuoviCorsoSeguito;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Corso;
import modello_di_dominio.Facolta;
/**
 * 
 * @author mw
 *
 */
public class RiquadroCorso extends Riquadro {
	
	private JPanel anteprima;
	private JLabel titolo;
	private JTextArea descrizione;
	private JTextArea facolta;
	private RimuoviCorsoSeguito rimuovi;
	
	/**
	 * 
	 */
	public RiquadroCorso(final Corso c, boolean pulsantiVisible) {
		super();
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());	

		
		anteprima = new JPanel();
		anteprima.setBounds(15, 56, 130, 130);
		anteprima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		anteprima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openCorso(false,c);
			}
		});

		titolo = new JLabel(c.getNome());
		titolo.setFont(new Font("Arial", Font.BOLD, 25));
		titolo.setForeground(Color.WHITE);
		titolo.setBounds(10, 5, 357, 40);
		
		descrizione = new JTextArea();
		DefaultCaret caret = (DefaultCaret) descrizione.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		descrizione.setText(c.getDescrizione());
		descrizione.setToolTipText("Descrizione Corso");
		descrizione.setDisabledTextColor(Color.WHITE);
		descrizione.setBackground(super.getCorsoBgColor());
		descrizione.setEnabled(false);
		descrizione.setEditable(false);
		descrizione.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		descrizione.setAlignmentY(Component.TOP_ALIGNMENT);
		descrizione.setLocation(155, 56);
		descrizione.setSize(275, 91);
		descrizione.setForeground(Color.WHITE);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setEditable(false);
		descrizione.setBackground(super.getCorsoBgColor());
		descrizione.setFont(new Font("Arial", Font.PLAIN, 12));
		descrizione.setText(util.StringUtility.truncateLines(descrizione,6));
		
		facolta = new JTextArea();
		DefaultCaret caret2 = (DefaultCaret) facolta.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		if (!c.facolta.isEmpty()) {
			for(int i=0; i<c.facolta.size(); ++i){
				if(i == 0){
					facolta.setText(c.facolta.toArray()[0].getNome());
					++i;
				}
				facolta.setText(facolta.getText()+" , "+c.facolta.toArray()[i].getNome());
			}
			//facolta.setText(c.facolta.toArray()[0].getNome());
		}
		facolta.setLocation(155, 158);
		facolta.setSize(275, 30);
		facolta.setForeground(Color.WHITE);
		facolta.setLineWrap(true);
		facolta.setBorder(new EmptyBorder(0,0,0,0));
		facolta.setWrapStyleWord(true);
		facolta.setHighlighter(null);
		facolta.setEditable(false);
		facolta.setBackground(super.getCorsoBgColor());
		facolta.setFont(new Font("Arial", Font.PLAIN, 12));
		facolta.setText(util.StringUtility.truncateLines(facolta,2));
		
		add(anteprima);
		add(titolo);
		add(descrizione);
		add(facolta);
		
		rimuovi = new RimuoviCorsoSeguito("Cancella il documento");
		rimuovi.setToolTipText("Rimuovi il corso dai preferiti");
		rimuovi.setLocation(377, 5);
		
		if (pulsantiVisible) {
			add(rimuovi);
		}

	}
	
	public RimuoviCorsoSeguito getRimuovi(){
		return this.rimuovi;
	}
}
