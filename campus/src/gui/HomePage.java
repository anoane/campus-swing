package gui;


import gui.riquadri.RiquadroCorsoSmall;
import gui.riquadri.RiquadroDocSmall;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.ControllerUtente;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
import modello_di_dominio.Utente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class HomePage extends Pagina {
	private JPanel panel;
	private final static JPanel panel_1 = new JPanel();
	private final static JSeparator separator_3 = new JSeparator();
	private final static JSeparator separator_4 = new JSeparator();
	private static String homeBottomText = "prova";
	private final static JLabel label_6 = new JLabel("new label");
	private final JPanel panel_corsi_seguiti = new JPanel();
	private final JPanel panel_preferiti_recenti = new JPanel();
	private final JPanel panel_miei_doc = new JPanel();
	
	
	public static String getHomeBottomText() {
		
		return homeBottomText;
		
	}
	
	public void reload() {
		panel.setBounds(0, 0, 1008, 429);
		
		adjustCorsiRec(getCorsiRec());
		adjustMieiPref(getMieiPref());
		adjustMieiDocs(getMieiDocs());
	}
	
	private ArrayList<Corso> getCorsiRec() {
		Utente u = ControllerUtente.getInstance().getUtente(1);
		
		if(u == null){
			return new ArrayList<Corso>();
		}
		
		return new ArrayList<Corso>(u.getFacolta().corso.getCollection());
	}
	
	private ArrayList<Documento> getMieiPref() {
		Utente u = ControllerUtente.getInstance().getUtente(1);
		
		if(u == null){
			return new ArrayList<Documento>();
		}
		
		return new ArrayList<Documento>(u.documentiPreferiti.getCollection());
	}
	
	private ArrayList<Documento> getMieiDocs() {
		Utente u = ControllerUtente.getInstance().getUtente(1);
		
		if(u == null){
			return new ArrayList<Documento>();
		}
		
		return new ArrayList<Documento>(u.documentiPreferiti.getCollection());
	}

	private void adjustCorsiRec(final ArrayList<Corso> corsi){
		panel_corsi_seguiti.removeAll();
		panel_corsi_seguiti.validate();
		panel_corsi_seguiti.repaint();
		addCorsiRec(corsi);
	}
	
	private void adjustMieiPref(final ArrayList<Documento> docs){
		panel_preferiti_recenti.removeAll();
		panel_preferiti_recenti.validate();
		panel_preferiti_recenti.repaint();
		addMieiPref(docs);
	}
	
	private void adjustMieiDocs(final ArrayList<Documento> docs){
		panel_miei_doc.removeAll();
		panel_miei_doc.validate();
		panel_miei_doc.repaint();
		addMieiDocs(docs);
	}
	
	public void addCorsiRec(final ArrayList<Corso> corsi){
		int colmax = (int) Math.ceil((float)corsi.size());
		int altezza = 230*colmax;
		panel_corsi_seguiti.setBounds(panel_corsi_seguiti.getX(),panel_corsi_seguiti.getY(),panel_corsi_seguiti.getWidth(),altezza);
		panel_corsi_seguiti.setBounds(panel_corsi_seguiti.getX(),panel_corsi_seguiti.getY(),panel_corsi_seguiti.getWidth(),800);
		//panel.setSize(panel.getWidth(), altezza+71);

		for(int i = 0;i < corsi.size();i++){
			final Corso d = corsi.get(i);
			final RiquadroCorsoSmall corso = new RiquadroCorsoSmall(d);
			corso.setLocation(0, (107*i));
			panel_corsi_seguiti.add(corso);
		}
	}
	
	public void addMieiPref(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size());
		int altezza = 230*colmax;
		panel_preferiti_recenti.setBounds(panel_preferiti_recenti.getX(),panel_preferiti_recenti.getY(),panel_preferiti_recenti.getWidth(),altezza);
		panel_preferiti_recenti.setBounds(panel_preferiti_recenti.getX(),panel_preferiti_recenti.getY(),panel_preferiti_recenti.getWidth(),800);
		//panel.setSize(panel.getWidth(), altezza+71);

		for(int i = 0;i < docs.size();i++){
			final Documento d = docs.get(i);
			final RiquadroDocSmall documento = new RiquadroDocSmall(d,true,false);
			documento.setLocation(0, (107*i));
			panel_preferiti_recenti.add(documento);
		}
	}
	
	public void addMieiDocs(final ArrayList<Documento> docs){
		int colmax = (int) Math.ceil((float)docs.size());
		int altezza = 230*colmax;
		panel_miei_doc.setBounds(panel_miei_doc.getX(),panel_miei_doc.getY(),panel_miei_doc.getWidth(),altezza);
		panel_miei_doc.setBounds(panel_miei_doc.getX(),panel_miei_doc.getY(),panel_miei_doc.getWidth(),800);
		//panel.setSize(panel.getWidth(), altezza+71);

		for(int i = 0;i < docs.size();i++){
			final Documento d = docs.get(i);
			final RiquadroDocSmall documento = new RiquadroDocSmall(d,true,false);
			documento.setLocation(0, (107*i));
			panel_miei_doc.add(documento);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public HomePage() {
		setLayout(null);
		
		panel = new JPanel();
		
		panel.setBounds(0, 0, 1008, 429);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		
		panel.getParent().addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				int dimensione_fill_home_bottom = (panel.getParent().getHeight()
						- Home.MIN_DIMENSION_Y + 300);
				panel.setBounds(panel.getX(), panel.getY(),
						panel.getWidth(),
						panel.getHeight()+dimensione_fill_home_bottom);
				panel_1.setBounds(0, dimensione_fill_home_bottom+97,
						panel_1.getWidth(),
						panel_1.getHeight());
				separator_3.setBounds(330, 48, 1, dimensione_fill_home_bottom+29);
				separator_4.setBounds(660, 48, 1, dimensione_fill_home_bottom+29);
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		
		JLabel label = new JLabel("Ultimi corsi seguiti");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 200, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JLabel label_1 = new JLabel("Preferiti recenti");
		label_1.setForeground(new Color(6, 121, 159));
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setBounds(350, 10, 200, 25);
		panel.add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(340, 41, 170, 1);
		panel.add(separator_1);
		
		JLabel label_2 = new JLabel("I miei documenti recenti");
		label_2.setForeground(new Color(6, 121, 159));
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(680, 10, 270, 25);
		panel.add(label_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(670, 41, 170, 1);
		panel.add(separator_2);
		
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(new Color(27, 50, 128));
		separator_3.setBounds(330, 48, 1, 198);
		panel.add(separator_3);
		
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(new Color(27, 50, 128));
		separator_4.setBounds(660, 48, 1, 198);
		panel.add(separator_4);
		
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(46, 93, 140));
		panel_1.setBounds(0, 266, 1008, 163);
		panel.add(panel_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(330, 20, 1, 163);
		panel_1.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setForeground(Color.WHITE);
		separator_6.setBounds(660, 20, 1, 163);
		panel_1.add(separator_6);
		
		JLabel label_3 = new JLabel("Ordini stampa");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 20));
		label_3.setBounds(10, 10, 200, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Classifica utenti");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.BOLD, 20));
		label_4.setBounds(670, 10, 273, 25);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Ordini digitalizzazione");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 20));
		label_5.setBounds(340, 10, 263, 25);
		panel_1.add(label_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 40, 310, 31);
		panel_1.add(panel_2);
		
		panel_2.add(label_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 81, 310, 31);
		panel_1.add(panel_3);
		
		JLabel label_7 = new JLabel("New label");
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 122, 310, 31);
		panel_1.add(panel_4);
		
		JLabel label_8 = new JLabel("New label");
		panel_4.add(label_8);
		
		panel_corsi_seguiti.setBackground(Color.WHITE);
		panel_corsi_seguiti.setBounds(10, 52, 310, 194);
		panel.add(panel_corsi_seguiti);
		panel_corsi_seguiti.setLayout(null);
		
		panel_preferiti_recenti.setBackground(Color.WHITE);
		panel_preferiti_recenti.setBounds(340, 52, 310, 194);
		panel.add(panel_preferiti_recenti);
		panel_preferiti_recenti.setLayout(null);
		
		panel_miei_doc.setBackground(Color.WHITE);
		panel_miei_doc.setBounds(670, 53, 310, 194);
		panel.add(panel_miei_doc);
		panel_miei_doc.setLayout(null);

		
		reload();
	}
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source arg0 label_6
	 * Questo metodo aggiunge ordini di stampa
	 */
	public static JPanel createOrdiniStampa(Component arg0) {
		JPanel panel = new JPanel();
		panel.add(arg0);
		return panel;
	}

	@Override
	public void reload(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}
}
