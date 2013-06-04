package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modello_di_dominio.Documento;

public class MenuSuggerimenti extends JPanel {
	
	private JLabel imgNotificheSuggerimento;
	private JLabel imgAggiungiSuggerimento;
	private ImageIcon notificaBlu = new ImageIcon("./newimage/bulb_off.png");
	private ImageIcon notificaBianca = new ImageIcon("./newimage/bulb_on.png");
	private ImageIcon aggiungiSuggerimento = new ImageIcon("./newimage/bulb_plus.png");
	private ImageIcon apriPannello = new ImageIcon("./newimage/frecce_apri.png");
	private ImageIcon chiudiPannello = new ImageIcon("./newimage/frecce_chiudi.png");
	private JLabel imgFrecce;

	

	public MenuSuggerimenti(boolean Proprietario){
		setPreferredSize(new Dimension(50, 140));
		setSize(50, 140);
		setLayout(null);
		setBackground(Home.BLUE_BUTTON_UNPRESSED);
		
		
		imgNotificheSuggerimento = new JLabel();
		imgNotificheSuggerimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgNotificheSuggerimento.setToolTipText("Notifiche di suggerimenti");
		imgNotificheSuggerimento.setIcon(notificaBlu);
		imgNotificheSuggerimento.setBounds(2, 0, 30, 47);
		imgNotificheSuggerimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				imgNotificheSuggerimento.setIcon(notificaBianca);
				imgNotificheSuggerimento.validate();
				imgNotificheSuggerimento.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				imgNotificheSuggerimento.setIcon(notificaBlu);
				imgNotificheSuggerimento.validate();
				imgNotificheSuggerimento.repaint();
			}
		});
		

		add(imgNotificheSuggerimento);
		
		imgAggiungiSuggerimento = new JLabel();
		
		
			
		imgAggiungiSuggerimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgAggiungiSuggerimento.setToolTipText("Aggiungi suggerimento");
		imgAggiungiSuggerimento.setIcon(aggiungiSuggerimento);
		imgAggiungiSuggerimento.setBounds(2, 50, 37, 47);
		add(imgAggiungiSuggerimento);
		/*imgAggiungiSuggerimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				imgAggiungiSuggerimento.setIcon(aggiungiModificaBianca);
				imgAggiungiSuggerimento.validate();
				imgAggiungiSuggerimento.repaint();
			}
		});
		imgAggiungiSuggerimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				imgAggiungiSuggerimento.setIcon(aggiungiModificaBlu);
				imgAggiungiSuggerimento.validate();
				imgAggiungiSuggerimento.repaint();
			}
		});*/
		
		imgFrecce = new JLabel();
		imgFrecce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgFrecce.setToolTipText("Apri Suggerimenti");
		imgFrecce.setIcon(apriPannello);
		imgFrecce.setBounds(3, 110, 35, 24);
		imgFrecce.setName("aperto");
		add(imgFrecce);

	}
	
	public JLabel getNotificaSuggerimento(){
		return imgNotificheSuggerimento;
	}
	
	public JLabel getAggiungiSuggerimento(){
		return imgAggiungiSuggerimento;
	}
	
	public void cambiaFrecce(){
		if(imgFrecce.getName().equals("aperto")){
			imgFrecce.setIcon(chiudiPannello);
			imgFrecce.setName("chiuso");
			imgFrecce.setToolTipText("Chiudi Suggerimenti");
		}
		else{
			imgFrecce.setIcon(apriPannello);
			imgFrecce.setName("aperto");
			imgFrecce.setToolTipText("Apri Suggerimenti");
		}
	}
	
	public JLabel getFrecce(){
		return imgFrecce;
	}
	

}
