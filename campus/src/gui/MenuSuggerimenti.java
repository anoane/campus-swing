package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class MenuSuggerimenti extends JPanel {
	
	private JLabel imgNotificheSuggerimento;
	private JLabel imgAggiungiSuggerimento;
	private ImageIcon notificaModificaBlu = new ImageIcon("C:\\Users\\Simone\\workspace\\campus-swing\\campus\\newimage\\notifica_modifica.png");
	private ImageIcon notificaModificaBianca = new ImageIcon("C:\\Users\\Simone\\workspace\\campus-swing\\campus\\newimage\\notifica_modifica1.png");
	private ImageIcon aggiungiModificaBlu = new ImageIcon("C:\\Users\\Simone\\workspace\\campus-swing\\campus\\newimage\\aggiungi_modifica.png");
	private ImageIcon aggiungiModificaBianca = new ImageIcon("C:\\Users\\Simone\\workspace\\campus-swing\\campus\\newimage\\aggiungi_modifica1.png");
	

	public MenuSuggerimenti(boolean Proprietario){
		setPreferredSize(new Dimension(23, 65));
		setSize(23, 65);
		setLayout(null);
		setBackground(new Color(6403279));
		
		
		imgNotificheSuggerimento = new JLabel("");
		imgNotificheSuggerimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgNotificheSuggerimento.setToolTipText("Notifiche di suggerimenti");
		imgNotificheSuggerimento.setIcon(notificaModificaBlu);
		imgNotificheSuggerimento.setBounds(0, 0, 20, 30);
		imgNotificheSuggerimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				imgNotificheSuggerimento.setIcon(notificaModificaBianca);
				imgNotificheSuggerimento.validate();
				imgNotificheSuggerimento.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				imgNotificheSuggerimento.setIcon(notificaModificaBlu);
				imgNotificheSuggerimento.validate();
				imgNotificheSuggerimento.repaint();
			}
		});
		add(imgNotificheSuggerimento);
		
		//if(!Proprietario){
		imgAggiungiSuggerimento = new JLabel("");		
		imgAggiungiSuggerimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgAggiungiSuggerimento.setToolTipText("Aggiungi suggerimento");
		imgAggiungiSuggerimento.setIcon(aggiungiModificaBlu);
		imgAggiungiSuggerimento.setBounds(0, 35, 23, 30);
		imgAggiungiSuggerimento.addMouseListener(new MouseAdapter() {
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
		});
		add(imgAggiungiSuggerimento);
		//}
	}
}
