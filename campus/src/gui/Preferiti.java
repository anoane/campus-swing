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

import modello_di_dominio.Documento;

public class Preferiti extends JPanel{
	
	//Pannelli preferiti
	private ArrayList<JPanel> preferiti = new ArrayList<JPanel>();
	
	//Padding 
	private int preferitoPadTop = 10;
	private int preferitoPadLeft = 10;
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
		
		ArrayList<Documento> prova = new ArrayList<Documento>();
			
		prova.add(null);
		prova.add(null);
		prova.add(null);
		prova.add(null);
		prova.add(null);
		prova.add(null);
		
		addFavourites(prova);
		
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
		
		preferito.setLayout(null);
		preferito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		preferito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openDocument(true);
			}
		});
		
		//Anteprima
		JPanel anteprima = new JPanel();
		anteprima.setBackground(Color.WHITE);
		anteprima.setBounds(23, 11, 116, 128);
		
		//Label panel
		JPanel panelLabel = new JPanel();
		panelLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelLabel.setBounds(10, 21, 58, 24);
		preferito.add(panelLabel);
		panelLabel.setLayout(null);
		
		//Label
		//TODO: Modificare in base al documento caricato
		JLabel lblNewLabel = new JLabel("APPUNTI");
		lblNewLabel.setBackground(new Color(0xFF,0x99,0x00));
		lblNewLabel.setBounds(5, 2, 54, 20);
		panelLabel.add(lblNewLabel);
		preferito.add(anteprima);

		return preferito;
	}
	
	public void addFavourites(ArrayList<Documento> docs){
		
		
		
		for(int i = 0;i < docs.size();i++){
			
			JPanel preferito = createFavourite(docs.get(i));
			
			int col = (int) Math.floor(i/2);
			int row = i%2;
			
			preferito.setBounds((50+(445*row)), 71+(180*col), 400, 150);
			panel.add(preferito);
			
			panel.setBounds(panel.getX(),panel.getY(),panel.getWidth(),322+(180*col));
			
		}
		
	}
}
