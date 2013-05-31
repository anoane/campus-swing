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
	private ImageIcon notificaModificaBlu = new ImageIcon("./newimage/notifica_modifica.png");
	private ImageIcon notificaModificaBianca = new ImageIcon("./newimage/notifica_modifica1.png");
	private ImageIcon aggiungiModificaBlu = new ImageIcon("./newimage/aggiungi_modifica.png");
	private ImageIcon aggiungiModificaBianca = new ImageIcon("./newimage/aggiungi_modifica1.png");
	private ImageIcon notifica = new ImageIcon("./newimage/notifica.png");
	private JLabel lblNotifiche;
	

	public MenuSuggerimenti(boolean Proprietario){
		setPreferredSize(new Dimension(23, 65));
		setSize(23, 65);
		setLayout(null);
		setBackground(Color.WHITE);
		
		
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
		
		lblNotifiche = new JLabel("");
		lblNotifiche.setForeground(Color.WHITE);
		lblNotifiche.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblNotifiche.setVerticalAlignment(SwingConstants.TOP);
		lblNotifiche.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNotifiche.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotifiche.setIcon(notifica);
		lblNotifiche.setBounds(5, 0, 15, 15);
		add(lblNotifiche);
		add(imgNotificheSuggerimento);
		
		imgAggiungiSuggerimento = new JLabel("");
		
		if(Proprietario){
			imgAggiungiSuggerimento.setVisible(false);
		}
		
			
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

	}
	
	public JLabel getNotificaSuggerimento(){
		return imgNotificheSuggerimento;
	}
	
	public JLabel getAggiungiSuggerimento(){
		return imgAggiungiSuggerimento;
	}
	
	public void setNotifiche(int i){
		if(i == 0){
			lblNotifiche.setVisible(false);
		}
		else{
			lblNotifiche.setText(String.valueOf(i));
		}
		lblNotifiche.validate();
		lblNotifiche.repaint();
	}
}
