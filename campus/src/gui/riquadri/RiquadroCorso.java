package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviCorsoSeguito;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
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
	private JLabel img_1 = new JLabel();
	private JLabel img_2 = new JLabel();
	private JLabel img_3 = new JLabel();
	private JLabel img_4 = new JLabel();
	private JLabel img_5 = new JLabel();
	private JLabel img_6 = new JLabel();
	
	
	/**
	 * 
	 */
	public RiquadroCorso(final Corso c, boolean pulsantiVisible) {
		super();
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());	

		
		anteprima = new JPanel();
		anteprima.setBounds(15, 56, 138, 130);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
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
		descrizione.setLocation(163, 56);
		descrizione.setSize(267, 91);
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
				if (i<c.facolta.size()) {
					facolta.setText(facolta.getText()+" , "+c.facolta.toArray()[i].getNome());
				}
			}
			//facolta.setText(c.facolta.toArray()[0].getNome());
		}
		facolta.setLocation(163, 158);
		facolta.setSize(267, 30);
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
		anteprima.setLayout(null);
		
		img_1.setBounds(0, 0, 44, 64);
		anteprima.add(img_1);
		
		img_2.setBounds(46, 0, 44, 64);
		anteprima.add(img_2);
		
		img_3.setBounds(92, 0, 44, 64);
		anteprima.add(img_3);
		
		img_4.setBounds(0, 66, 44, 64);
		anteprima.add(img_4);
		
		img_5.setBounds(46, 66, 44, 64);
		anteprima.add(img_5);
		
		img_6.setBounds(92, 66, 44, 64);
		anteprima.add(img_6);
		
		if (!c.documentoCorso.isEmpty()) {
			Documento[] doc_array = c.documentoCorso.toArray();
			ArrayList<String> png_path = new ArrayList<String>();
			for (int i=0; i<doc_array.length; i++) {
				if (util.EstensioneFile.getExtension(doc_array[i].getPath()).matches("pdf")) {
					png_path.add("./thumb/"+(doc_array[i].getPath().substring(6))+".png");
				}
			}
			
			int doc_size = png_path.size();
			if (doc_size > 0) {
				img_1.setIcon(new ImageIcon(png_path.get(0)));
			}
			if (doc_size > 1) {
				img_2.setIcon(new ImageIcon(png_path.get(1)));
			}
			if (doc_size > 2) {
				img_3.setIcon(new ImageIcon(png_path.get(2)));
			}
			if (doc_size > 3) {
				img_4.setIcon(new ImageIcon(png_path.get(3)));
			}
			if (doc_size > 4) {
				img_5.setIcon(new ImageIcon(png_path.get(4)));
			}
			if (doc_size > 5) {
				img_6.setIcon(new ImageIcon(png_path.get(5)));
			}
		}
		
		
		
		
		
		
		
		add(titolo);
		add(descrizione);
		add(facolta);
		
		rimuovi = new RimuoviCorsoSeguito("Cancella il documento");
		rimuovi.setToolTipText("Rimuovi dai corsi seguiti");
		rimuovi.setLocation(377, 5);
		
		if (pulsantiVisible) {
			add(rimuovi);
		}

	}
	
	public RimuoviCorsoSeguito getRimuovi(){
		return this.rimuovi;
	}
}
