
package gui.riquadri;

import gui.Home;
import gui.buttons.EliminaCommento;
import gui.buttons.ModificaCommento;
import gui.buttons.RevertModificaCommento;
import gui.buttons.SalvaCommento;
import gui.helpers.JTextFieldLimit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;

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

import controller.ControllerCommento;
import controller.ControllerDocumento;

import util.StringUtility;

/**
 * @author mw
 * 
 */
public class RiquadroCommento extends JPanel {

	private JTextArea descrizione = new JTextArea();
	private ModificaCommento btnNewButton = new ModificaCommento(this);
	private EliminaCommento button = new EliminaCommento(this);
	private SalvaCommento salva = new SalvaCommento(this);
	private RevertModificaCommento annulla = new RevertModificaCommento(this);
	
	
	
	public void setModifica(boolean modificaAttiva) {
		if (modificaAttiva) {
			String temp = descrizione.getText();
			Rectangle temp_rect = descrizione.getBounds();
			this.remove(descrizione);
			JScrollPane scroll = new JScrollPane(descrizione);
			scroll.setBorder(new LineBorder(Home.BLUE_BUTTON_PRESSED,1));
			scroll.setBounds(temp_rect);
			this.add(scroll);
			descrizione.setHighlighter(new DefaultHighlighter());
			descrizione.setEditable(true);
			DefaultCaret caret2 = (DefaultCaret) descrizione.getCaret();
			caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			descrizione.setCaretPosition(0);
			//descrizione.setBounds(62,22,359,22*8);
			//this.setSize(421, 62-36+22*8);
			button.setVisible(false);
			btnNewButton.setVisible(false);
			salva.setVisible(true);
			annulla.setVisible(true);
			repaint();
			revalidate();
		} else {
			this.add(descrizione);
			DefaultCaret caret2 = (DefaultCaret) descrizione.getCaret();
			caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
			descrizione.setCaretPosition(0);
			descrizione.setHighlighter(null);
			descrizione.setEditable(false);
			button.setVisible(true);
			btnNewButton.setVisible(true);
			salva.setVisible(false);
			annulla.setVisible(false);
			repaint();
			revalidate();
		}

		
		
	}
	
	public RiquadroCommento(final Commento commento) {
		//Color c = new Color(0x1B, 0x32, 0x80);
		//setBorder(new LineBorder(c));
		this.setSize(421, 62);
		this.setBackground(new Color(0xFF, 0xFF, 0xFF));
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
		descrizione.setCaretPosition(0);
		descrizione.setDocument(new JTextFieldLimit(254));
		descrizione.setText(commento.getCommento());
		descrizione.setFont(new Font("Arial", Font.PLAIN, 14));
		descrizione.setEditable(false);
		descrizione.setBounds(62,22,359,36);
		int righe = StringUtility.countLines(descrizione);
		if (righe>2) {
			descrizione.setBounds(62,22,359,22*righe);
			this.setSize(421, 62-36+22*righe);
		}
		descrizione.setLineWrap(true);
		descrizione.setBorder(new EmptyBorder(0,0,0,0));
		descrizione.setWrapStyleWord(true);
		descrizione.setHighlighter(null);
		add(descrizione);
		
		final JLabel nomeUtente = new JLabel(commento.getUtente().getNome()+" "+commento.getUtente().getCognome());
		//nomeUtente.setFont(new Font("Arial", Font.PLAIN, 14));
		//nomeUtente.setForeground(Home.BLUE_BUTTON_PRESSED);
		nomeUtente.setBounds(62, 4, 166, 17);
		
		nomeUtente.setForeground(Home.BLUE_BUTTON_PRESSED);
		nomeUtente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nomeUtente.setFont(new Font("Arial", Font.BOLD, 14));
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
		
		
		
		btnNewButton.setBounds(378, 4, 15, 15);
		annulla.setBounds(378, 4, 15, 15);
		button.setBounds(403, 4, 15, 15);
		salva.setBounds(403, 4, 15, 15);
		btnNewButton.setVisible(false);
		button.setVisible(false);
		salva.setVisible(false);
		annulla.setVisible(false);
		
		Timestamp time = commento.getTimestamp();
		Date inputDate = new Date(time.getTime());
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		DateFormat outputFormat2 = new SimpleDateFormat("hh:mm");
		String outputString = outputFormat.format(inputDate);
		String outputString2 = outputFormat2.format(inputDate);
		
		JLabel data = new JLabel("il "+outputString+" alle "+outputString2);
		data.setForeground(Color.LIGHT_GRAY);
		data.setFont(new Font("Arial", Font.PLAIN, 14));
		data.setBounds(284, 4, 132, 17);
		add(data);
		
		if (commento.getDocumento().getProprietario().getID()==Home.getUtenteLoggato().getID() || commento.getUtente().getID()==Home.getUtenteLoggato().getID()) {
			data.setBounds(236, 4, 132, 17);
			add(btnNewButton);
			add(button);
			add(salva);
		}
		setModifica(false);
	}

	public ModificaCommento getModifica() {
		// TODO Auto-generated method stub
		return btnNewButton;
	}

	public EliminaCommento getElimina() {
		// TODO Auto-generated method stub
		return button;
	}

	public RevertModificaCommento getAnnulla() {
		// TODO Auto-generated method stub
		return annulla;
	}

	public SalvaCommento getSalva() {
		// TODO Auto-generated method stub
		return salva;
	}

}
