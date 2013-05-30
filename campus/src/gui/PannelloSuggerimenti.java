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
	private static int larghezza = 420;
	
	public PannelloSuggerimenti() {
		
		pannello = new JPanel();
		pannello.setPreferredSize(new Dimension(390,200));
		//setPreferredSize(new Dimension(440,220));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setViewportView(pannello);
		FlowLayout fl_pannello = new FlowLayout();
		fl_pannello.setAlignment(FlowLayout.LEFT);
		pannello.setLayout(fl_pannello);
		
	}
	
	public void load(final Documento d){
		pannello.removeAll();
		//setAltezza(d.correziones.size());
		for(int i=0; i<d.correziones.size(); ++i){
			final RiquadroSuggerimento r = new RiquadroSuggerimento(d.correziones.toArray()[i]);
			final RiquadroSuggerimentoSmall rs = new RiquadroSuggerimentoSmall(d.correziones.toArray()[i]); 
			final int j = i;
			rs.getEspandi().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pannello.getComponent(j).equals(rs)){
						pannello.remove(j);
						pannello.add(r, j);
					}
					else{
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
					if(pannello.getComponent(j).equals(r)){
						pannello.remove(j);
						pannello.add(rs, j);
					}
					else{
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
	
	private void aggiornaAltezza(){
		int altezza = 0;
		if(pannello.getComponents().length == 0){
			pannello.setPreferredSize(new Dimension(390,200));
			pannello.setSize(390, 200);
		}
		else{
			for(int i=0; i<pannello.getComponents().length; ++i){
				altezza += pannello.getComponent(i).getHeight()+10;
			}
			pannello.setPreferredSize(new Dimension(390,altezza));
			pannello.setSize(390, altezza);
		}
		if((altezza+10) < 484){
			setPreferredSize(new Dimension(440, altezza+5));
			setSize(larghezza,altezza+5);
		}
		else{
			setPreferredSize(new Dimension(440, 484));
			setSize(larghezza,484);
		}
	}

}
