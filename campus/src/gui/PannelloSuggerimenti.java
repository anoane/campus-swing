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


@SuppressWarnings("serial")
public class PannelloSuggerimenti extends JScrollPane {
	
	private JPanel pannello;
	
	public PannelloSuggerimenti() {
		
		pannello = new JPanel();
		pannello.setPreferredSize(new Dimension(390,500));
		setPreferredSize(new Dimension(440,500));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setViewportView(pannello);
		FlowLayout fl_pannello = new FlowLayout();
		fl_pannello.setHgap(0);
		pannello.setLayout(fl_pannello);
		
	}
	
	public void load(Documento d){
		pannello.removeAll();
		for(int i=0; i<d.correziones.size(); ++i){
			final RiquadroSuggerimentoSmall rs = new RiquadroSuggerimentoSmall(d.correziones.toArray()[i]);
			rs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rs.setPreferredSize(new Dimension(390,500));
					pannello.validate();
					pannello.repaint();
				}
			});
			pannello.add(rs);
		}
	}
	

}
