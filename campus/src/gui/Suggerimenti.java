package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modello_di_dominio.Correzione;
import modello_di_dominio.Documento;

public class Suggerimenti extends JPanel {

	private MenuSuggerimenti menuSuggerimenti;
	private PannelloSuggerimenti pannelloSuggerimenti;
	private Dimension minDimension = new Dimension(30, 484);
	private JLabel imgFreccia;

	public Suggerimenti() {
		setPreferredSize(new Dimension(480, 484));
		setSize(minDimension);
		setLayout(null);
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(480, 484));
	}

	public void load(final Documento d) {
		removeAll();

		pannelloSuggerimenti = new PannelloSuggerimenti();
		pannelloSuggerimenti.setLocation(0, 0);
		pannelloSuggerimenti.setBorder(new LineBorder(
				Home.BLUE_BUTTON_UNPRESSED, 2));
		pannelloSuggerimenti.setVisible(false);
		pannelloSuggerimenti.load(d);
		pannelloSuggerimenti.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				Suggerimenti.this.setSize(Suggerimenti.this.getWidth(), pannelloSuggerimenti.getHeight()
						+ Suggerimenti.this.getY());
				Suggerimenti.this.validate();
				Suggerimenti.this.repaint();
			}
		});

		add(pannelloSuggerimenti);

		if (d != null) {
			menuSuggerimenti = new MenuSuggerimenti(d.getProprietario().equals(
					Home.getUtenteLoggato()));
			menuSuggerimenti.setLocation(0, 0);
			// menuSuggerimenti.setNotifiche(notificheNonLette(d));
			add(menuSuggerimenti);
			menuSuggerimenti.getNotificaSuggerimento().addMouseListener(
					new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (pannelloSuggerimenti.isVisible()) {
								pannelloSuggerimenti.setVisible(false);
								Suggerimenti.this.setSize(minDimension);
								menuSuggerimenti.setLocation(0, 0);
								Suggerimenti.this.validate();
								Suggerimenti.this.repaint();
							} else {
								pannelloSuggerimenti.load(d);
								pannelloSuggerimenti.setVisible(true);
								Suggerimenti.this.setSize(480,
										pannelloSuggerimenti.getHeight()
												+ Suggerimenti.this.getY());
								menuSuggerimenti.setLocation(440, 0);
								Suggerimenti.this.validate();
								Suggerimenti.this.repaint();
							}
						}
					});
		}

	}

	private int notificheNonLette(Documento d) {
		int i = 0;
		Correzione[] c = d.correziones.toArray();
		for (int j = 0; i < c.length; ++j) {
			if (!c[j].getApprovato())
				++i;
		}
		return i;

	}

}
