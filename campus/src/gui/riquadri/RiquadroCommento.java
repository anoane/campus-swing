
package gui.riquadri;

import gui.Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import modello_di_dominio.Commento;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.swing.JButton;

/**
 * @author mw
 * 
 */
public class RiquadroCommento extends JPanel {

	JTextArea descrizione = new JTextArea();
	
	public RiquadroCommento(final Commento commento) {
		//Color c = new Color(0x1B, 0x32, 0x80);
		//setBorder(new LineBorder(c));
		this.setSize(428, 62);
		//this.setBackground(new Color(0x43, 0x88, 0xCC));
		setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(4, 4, 54, 54);
		Image resized = new ImageIcon("."+commento.getUtente().getImmagine()).getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH);  
		lblNewLabel.setIcon(new ImageIcon(resized));
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openProfilo(commento.getUtente());
			}
			/*
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(new LineBorder(Home.BLUE_SEARCH_BAR,2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//label_13.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80),2));
				lblNewLabel.setBorder(new EmptyBorder(0,0,0,0));
			}*/
		});
		add(lblNewLabel);
		
		DefaultCaret caret2 = (DefaultCaret) descrizione.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		descrizione.setText(commento.getCommento());
		descrizione.setCaretPosition(0);
		descrizione.setFont(new Font("Arial", Font.PLAIN, 14));
		descrizione.setEditable(false);
		descrizione.setBounds(62,22,361,36);
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		descrizione.setText(util.StringUtility.truncateLines(descrizione,3));
		add(descrizione);
		
		final JLabel nomeUtente = new JLabel(commento.getUtente().getNome()+" "+commento.getUtente().getCognome());
		//nomeUtente.setFont(new Font("Arial", Font.PLAIN, 14));
		//nomeUtente.setForeground(Home.BLUE_BUTTON_PRESSED);
		nomeUtente.setBounds(62, 4, 166, 17);
		
		nomeUtente.setForeground(Home.BLUE_BUTTON_PRESSED);
		nomeUtente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nomeUtente.setFont(new Font("Arial", Font.PLAIN, 14));
		nomeUtente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Home.openProfilo(commento.getUtente());
			}
		    Font original;

		    @Override
		    public void mouseEntered(MouseEvent e) {
		        original = e.getComponent().getFont();
		        Map attributes = original.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        e.getComponent().setFont(original.deriveFont(attributes));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        e.getComponent().setFont(original);
		    }
		});
		add(nomeUtente);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("./newimage/modifica_commento.png"));
		btnNewButton.setBounds(380, 4, 15, 15);
		add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("./newimage/elimina_commento.png"));
		button.setBounds(405, 4, 15, 15);
		add(button);
		
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		
		Timestamp time = commento.getTimestamp();
		Date inputDate = new Date(time.getTime());
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		DateFormat outputFormat2 = new SimpleDateFormat("hh:mm");
		String outputString = outputFormat.format(inputDate);
		String outputString2 = outputFormat2.format(inputDate);
		
		JLabel data = new JLabel("il "+outputString+" alle "+outputString2);
		data.setForeground(Color.LIGHT_GRAY);
		data.setFont(new Font("Arial", Font.PLAIN, 14));
		data.setBounds(238, 4, 132, 17);
		add(data);
		//descrizione.addMouseListener(comportamento);
		//descrizione.setBackground(exitedColor);
	}
}
