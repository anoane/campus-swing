package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import controller.ControllerUtente;

import modello_di_dominio.Documento;

public class Preferiti extends JPanel{
	
	//Pannelli preferiti
	private ArrayList<JPanel> preferiti = new ArrayList<JPanel>();
	
	//Padding 
//	private int preferitoPadTop = 10;
//	private int preferitoPadLeft = 10;
	private static Color preferitoBgColor = new Color(67,136,204);
	
	//Pannello principale
	private JPanel panel;
	
	
	//private 
	
	public Preferiti() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 429));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPreferiti = new JLabel("Preferiti");
		lblPreferiti.setForeground(new Color(6, 121, 159));
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblPreferiti.setBounds(10, 10, 200, 25);
		panel.add(lblPreferiti);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		ArrayList<Documento> d = new ArrayList<Documento>(ControllerUtente.getInstance().getUtente(1).documentoPreferiti.getCollection());
		
		addFavourites(d);
		
	}
	

	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source layout null
	 * @wbp.factory.parameter.source arg0 panel_2
	 * @wbp.factory.parameter.source arg0_1 panel_1
	 */
	public static JPanel createFavourite(Documento doc) {
		
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
				Home.openDocument(true);
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
		
		//Label universitÓ
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
	
	public void addFavourites(ArrayList<Documento> docs){
		
		
		
		for(int i = 0;i < docs.size();i++){
			
			JPanel preferito = createFavourite(docs.get(i));
			
			int col = (int) Math.floor(i/2);
			int row = i%2;
			
			preferito.setBounds((50+(445*row)), 71+(230*col), 400, 200);
			panel.add(preferito);
			
			panel.setBounds(panel.getX(),panel.getY(),panel.getWidth(),322+(230*col));
			
		}
		
	}
}
