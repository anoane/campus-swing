package gui.riquadri;

import gui.Home;
import gui.buttons.RimuoviButton;
import gui.buttons.RimuoviCorsoSeguito;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
/**
 * 
 * @author mw
 *
 */
public class RiquadroCorsoSmall extends RiquadroSmall {
	
	private JPanel anteprima;
	private JLabel titolo;
	private JTextArea descrizione;
	private JTextArea facolta;
	private RimuoviCorsoSeguito rimuovi;
	
	/**
	 * 
	 */
	public RiquadroCorsoSmall(final Corso c) {
		super();
		
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(super.getCorsoBgColor());
		this.setBorder(super.getRiquadroBorder());	
		
		final Color exitedColor = super.getCorsoBgColor();
		final Color enteredColor = super.getCorsoOverBgColor();
		
		MouseAdapter comportamento = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openCorso(false,c);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(enteredColor);

				descrizione.setBackground(enteredColor);
				facolta.setBackground(enteredColor);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(exitedColor);

				descrizione.setBackground(exitedColor);
				facolta.setBackground(exitedColor);
			}
		};
		
		this.addMouseListener(comportamento);
		
		anteprima = new JPanel();
		anteprima.setBackground(Color.LIGHT_GRAY);
		anteprima.setBounds(10, 41, 45, 45);

		titolo = new JLabel(c.getNome());
		titolo.setFont(new Font("Arial", Font.BOLD, 20));
		titolo.setForeground(Color.WHITE);
		titolo.setBounds(10, 5, 290, 40);
		
		descrizione = new JTextArea(c.getDescrizione());
		descrizione.setToolTipText("Descrizione Corso");
		descrizione.setDisabledTextColor(Color.WHITE);
		descrizione.setBackground(super.getCorsoBgColor());
		descrizione.setEnabled(false);
		descrizione.setEditable(false);
		descrizione.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		descrizione.setAlignmentY(Component.TOP_ALIGNMENT);
		descrizione.setLocation(65, 41);
		descrizione.setSize(235, 30);
		descrizione.setForeground(Color.WHITE);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setEditable(false);
		descrizione.setBackground(super.getCorsoBgColor());
		descrizione.setFont(new Font("Arial", Font.PLAIN, 12));
		descrizione.setText(util.StringUtility.truncateLines(descrizione,2));
		descrizione.addMouseListener(comportamento);
		
		
		facolta = new JTextArea();
		
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
		}
		
		facolta.setLocation(64, 73);
		facolta.setSize(236, 19);
		facolta.setForeground(Color.WHITE);
		facolta.setLineWrap(true);
		facolta.setBorder(new EmptyBorder(0,0,0,0));
		facolta.setWrapStyleWord(true);
		facolta.setHighlighter(null);
		facolta.setEditable(false);
		facolta.setBackground(super.getCorsoBgColor());
		facolta.setFont(new Font("Arial", Font.PLAIN, 12));
		facolta.setText(util.StringUtility.truncateLines(facolta,1));
		facolta.addMouseListener(comportamento);
		
		rimuovi = new RimuoviCorsoSeguito("Cancella il documento");
		rimuovi.setToolTipText("Rimuovi il corso dai preferiti");
		rimuovi.setLocation(385, 5);
		
		add(anteprima);
		anteprima.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(7, 0, 31, 45);
		anteprima.add(lblNewLabel);
		add(titolo);
		add(descrizione);
		
		add(facolta);
		add(rimuovi);
		
		if (!c.documentoCorso.isEmpty()) {
			Documento[] doc_array = c.documentoCorso.toArray();
			ArrayList<String> png_path = new ArrayList<String>();
			for (int i=0; i<doc_array.length; i++) {
				if (util.EstensioneFile.getExtension(doc_array[i].getPath())!=null){
					if (util.EstensioneFile.getExtension(doc_array[i].getPath()).matches("pdf")) {
						png_path.add("./thumb/"+(doc_array[i].getPath().substring(6))+".png");
					}
				}

				
			}
			
			int doc_size = png_path.size();
			if (doc_size > 0) {
				Image resized = new ImageIcon(png_path.get(0)).getImage().getScaledInstance(31, 45,  java.awt.Image.SCALE_SMOOTH);  
				lblNewLabel.setIcon(new ImageIcon(resized));
			}
		}
	}
	
	public RimuoviCorsoSeguito getRimuovi(){
		return this.rimuovi;
	}
}
