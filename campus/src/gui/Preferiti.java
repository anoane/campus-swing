package gui;

import gui.riquadri.RiquadroDoc;
import gui.riquadri.RiquadroPref;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.dao.UtenteDAO;
import controller.ControllerUtente;

public class Preferiti extends JPanel{
	
	//Pannelli preferiti
	private ArrayList<JPanel> preferiti = new ArrayList<JPanel>();
	
	//Padding 
//	private int preferitoPadTop = 10;
//	private int preferitoPadLeft = 10;
	private static Color preferitoBgColor = new Color(67,136,204);
	
	//Pannello principale
	private JPanel panel;
	
	//Label Pagina
	private JLabel lblPage;
	
	// Linea
	private JSeparator separator;
	
	//private 
	
	public Preferiti() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 429));
		add(panel);
		panel.setLayout(null);
		
		lblPage = new JLabel("Preferiti");
		lblPage.setForeground(new Color(6, 121, 159));
		lblPage.setFont(new Font("Arial", Font.BOLD, 20));
		lblPage.setBounds(10, 10, 200, 25);
		panel.add(lblPage);
		
		separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		try {
			ArrayList<Documento> d = new ArrayList<Documento>(ControllerUtente.getInstance().getUtente(1).documentiPreferiti.getCollection());
			
			addFavourites(d);
		} catch (NullPointerException npe) { } {
			System.out.println("non esiste l'utente 1");
		}
		
		
		
	}
	

	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source layout null
	 * @wbp.factory.parameter.source arg0 panel_2
	 * @wbp.factory.parameter.source arg0_1 panel_1
	 */
	public static JPanel createFavourite(final Documento doc) {
		
		//Contenitore
		JPanel preferito = new JPanel();
		preferito.setBackground(preferitoBgColor);
		preferito.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		
		preferito.setLayout(null);
		
		//Anteprima
		JPanel anteprima = new JPanel();
		anteprima.setBackground(Color.WHITE);
		anteprima.setBounds(23, 16, 116, 170);
		anteprima.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		anteprima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Event listener
		anteprima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true,doc.getPath());
			}
		});
		
		//Label panel
		JPanel panelLabel = new JPanel();
		panelLabel.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80), 2));
		panelLabel.setBounds(10, 21, 58, 24);
		panelLabel.setLayout(null);
		
		//Label
		//TODO: Modificare l'etichetta del documento
		JLabel lblNewLabel = new JLabel(doc.getClass().getName().split("\\.")[1]);
		lblNewLabel.setBackground(new Color(0xFF,0x99,0x00));
		lblNewLabel.setBounds(5, 2, 54, 20);
		
		//Label facolta
		JLabel facolta = new JLabel(doc.getProprietario().getFacolta().getNome());
		facolta.setBounds(260,80,100,20);
		
		//Label università
		JLabel univ = new JLabel(doc.getProprietario().getFacolta().getUniversita().getNome());
		univ.setBounds(260,100,130,20);
		
		//Label title
		JLabel title = new JLabel(doc.getNome());
		title.setBounds(170,10,50,40);
		title.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));
		title.setForeground(Color.WHITE);
		
		//Label rimuovi
		JPanel rimuovi = new JPanel();
		rimuovi.setBounds(260,10,80,100);
		rimuovi.setBackground(Color.WHITE);
		
		preferito.add(panelLabel);
		panelLabel.add(lblNewLabel);
		preferito.add(anteprima);
		preferito.add(facolta);
		preferito.add(univ);
		preferito.add(title);
		preferito.add(rimuovi);
		
		return preferito;
	}
	
	public void addFavourites(final ArrayList<Documento> docs){
		for(int i = 0;i < docs.size();i++){
			final int num_doc = i;
			final Documento d = docs.get(i);
			final RiquadroPref preferito = new RiquadroPref(d);//createFavourite(docs.get(i));
			int col = (int) Math.floor(i/2);
			int row = i%2;
			preferito.setLocation((32+(485*row)), 71+(230*col));
			panel.add(preferito);
			
			preferito.getRimuovi().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					docs.remove(num_doc);
					ControllerUtente u = ControllerUtente.getInstance();
					//u.rimuoviDocumentoPreferito(u.getUtente(1), d);
					adjustDocs(docs);
					validate();
					repaint();}
				});
			panel.setBounds(panel.getX(),panel.getY(),panel.getWidth(),322+(230*col));	
		}	
	}
	
	private void adjustDocs(final ArrayList<Documento> docs){
		panel.removeAll();
		panel.add(lblPage);
		panel.add(separator);
		addFavourites(docs);
	}
}
