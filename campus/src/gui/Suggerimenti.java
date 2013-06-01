package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modello_di_dominio.Correzione;
import modello_di_dominio.Documento;
import controller.ControllerUtente;

public class Suggerimenti extends JPanel {

	private MenuSuggerimenti menuSuggerimenti;
	private PannelloSuggerimenti pannelloSuggerimenti;
	private Dimension minDimension = new Dimension(30, 484);
	private JLabel imgFreccia;

	public Suggerimenti() {
		setPreferredSize(minDimension);
		setSize(minDimension);
		setLayout(null);
		//setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(480,484));
	}

	public void load(final Documento d) {
		removeAll();
		
		imgFreccia = new JLabel("");
		imgFreccia.setIcon(new ImageIcon("./newimage/freccia_left_blu_sugg.png"));
		imgFreccia.setBounds(25, 10, 11, 20);
		imgFreccia.setVisible(false);
		add(imgFreccia);
		
		pannelloSuggerimenti = new PannelloSuggerimenti();
		pannelloSuggerimenti.setLocation(35, 5);
		pannelloSuggerimenti.setVisible(false);
		pannelloSuggerimenti.load(d);
		pannelloSuggerimenti.addComponentListener(
				new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent arg0) {
						Suggerimenti.this.setSize(480,
								pannelloSuggerimenti.getHeight()+Suggerimenti.this.getY());
						Suggerimenti.this.validate();
						Suggerimenti.this.repaint();
					}
				});
		

		add(pannelloSuggerimenti);
		
		if (d!=null) {
			menuSuggerimenti = new MenuSuggerimenti(d.getProprietario().equals(Home.getUtenteLoggato()));
			menuSuggerimenti.setLocation(2, 5);
			menuSuggerimenti.setNotifiche(notificheNonLette(d));
			add(menuSuggerimenti);
			menuSuggerimenti.getNotificaSuggerimento().addMouseListener(
					new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (pannelloSuggerimenti.isVisible()) {
								pannelloSuggerimenti.setVisible(false);
								imgFreccia.setVisible(false);
								Suggerimenti.this.setSize(minDimension);
								Suggerimenti.this.validate();
								Suggerimenti.this.repaint();
							} else {
								pannelloSuggerimenti.load(d);
								pannelloSuggerimenti.setVisible(true);
								imgFreccia.setVisible(true);
								Suggerimenti.this.setSize(480,
										pannelloSuggerimenti.getHeight()+Suggerimenti.this.getY());
								Suggerimenti.this.validate();
								Suggerimenti.this.repaint();
							}
						}
					});
		}

	}
	
	private int notificheNonLette(Documento d){
		int i = 0;
		Correzione[] c = d.correziones.toArray();
		for(int j=0; i<c.length; ++j){
			if(!c[j].getApprovato())
				++i;
		}
		return i;
		
	}

}
