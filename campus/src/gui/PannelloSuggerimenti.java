package gui;

import gui.riquadri.RiquadroSuggerimento;
import gui.riquadri.RiquadroSuggerimentoSmall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class PannelloSuggerimenti extends JScrollPane {

	private JPanel pannello;
	private JLabel lblNoSuggerimenti;
	private static int larghezza = 420;

	public PannelloSuggerimenti() {

		pannello = new JPanel();
		// pannello.setPreferredSize(new Dimension(390,200));
		setPreferredSize(new Dimension(440, 220));
		setSize(440, 220);
		setBorder(new LineBorder(Home.BLUE_BUTTON_PRESSED, 1));
		setViewportView(pannello);
		// setBackground(Color.WHITE);
		FlowLayout fl_pannello = new FlowLayout();
		fl_pannello.setAlignment(FlowLayout.LEFT);
		pannello.setLayout(fl_pannello);
		pannello.setBackground(Color.WHITE);

		lblNoSuggerimenti = new JLabel(
				"Non ci sono suggerimenti per il documento");
		lblNoSuggerimenti.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblNoSuggerimenti.setFont(new Font("Arial", Font.BOLD, 18));
		pannello.add(lblNoSuggerimenti);

	}

	public void load(final Documento d) {
		int c = d.correziones.size();
		pannello.setSize(390, 100);
		pannello.removeAll();
		if (c != 0) {
			for (int i = 0; i < d.correziones.size(); ++i) {
				final RiquadroSuggerimento r = new RiquadroSuggerimento(
						d.correziones.toArray()[i]);
				final RiquadroSuggerimentoSmall rs = new RiquadroSuggerimentoSmall(
						d.correziones.toArray()[i]);
				final int j = i;
				rs.getEspandi().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (pannello.getComponent(j).equals(rs)) {
							pannello.remove(j);
							pannello.add(r, j);
						} else {
							pannello.remove(j);
							pannello.add(rs, j);
						}
						aggiornaAltezza();
						pannello.validate();
						pannello.repaint();
					}
				});
				r.getEspandi().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (pannello.getComponent(j).equals(r)) {
							pannello.remove(j);
							pannello.add(rs, j);
						} else {
							pannello.remove(j);
							pannello.add(r, j);
						}
						aggiornaAltezza();
						pannello.validate();
						pannello.repaint();
					}
				});
				pannello.add(rs);
			}
			aggiornaAltezza();
		}
		else{
			lblNoSuggerimenti = new JLabel(
					"Non ci sono suggerimenti per il documento");
			lblNoSuggerimenti.setForeground(Home.BLUE_BUTTON_PRESSED);
			lblNoSuggerimenti.setFont(new Font("Arial", Font.BOLD, 18));
			pannello.add(lblNoSuggerimenti);
		}
	}

	private void aggiornaAltezza() {
		int altezza = 5;
		if (pannello.getComponents().length == 0) {
			pannello.setPreferredSize(new Dimension(390, 200));
			pannello.setSize(390, 200);
			altezza += pannello.getHeight();
		} else {
			for (int i = 0; i < pannello.getComponents().length; ++i) {
				altezza += pannello.getComponent(i).getHeight() + 5;
			}
			pannello.setPreferredSize(new Dimension(390, altezza));
			pannello.setSize(390, altezza);
		}
		if ((altezza + 10) < 484) {
			setPreferredSize(new Dimension(440, altezza + 5));
			setSize(larghezza, altezza + 5);
		} else {
			setPreferredSize(new Dimension(440, 484));
			setSize(larghezza, 484);
		}
		validate();
		repaint();
	}

}
