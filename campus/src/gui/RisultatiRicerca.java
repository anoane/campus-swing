package gui;

import gui.riquadri.RiquadroCorso;
import gui.riquadri.RiquadroDoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout.Alignment;
import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;

import org.apache.lucene.queryparser.classic.ParseException;
import org.orm.PersistentException;

import controller.ControllerCorso;
import controller.ControllerDocumento;
import controller.ControllerFacolta;
import controller.ControllerUniversita;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

//TODO:filtro facolta

public class RisultatiRicerca extends Pagina {
	private final JPanel panel = new JPanel();
	private static JPanel scegli_fac = new JPanel();
	private static JPanel scegli_corso = new JPanel();
	private static JPanel scegli_univ = new JPanel();
	final static JList list = new JList();
	final static JList list_1 = new JList();
	final static JList list_2 = new JList();
	static boolean isOverSelectionPanel = false;
	private int indexUniv = -1;
	private int dbIndexUniv = -1;
	private int indexFac = -1;
	private int dbIndexFac = -1;
	private int indexCorso = -1;
	private int dbIndexCorso = -1;
	private int indexCorsoByFac = -1;
	private int dbIndexCorsoByFac = -1;
	private String tempRicerca = "";
	private boolean fileSelezionato = false;
	private Path target;
	static Universita[] listaUniversita = ControllerUniversita.getInstance()
			.getAllUniversita();
	static Facolta[] listaFacoltaByUniv = ControllerFacolta.getInstance()
			.getAllFacoltaByUniv(-1);
	static Corso[] listaCorsi = ControllerCorso.getInstance().getAllCorsi();
	static Corso[] listaCorsiByFac = null;
	private final JLabel label = new JLabel("New label");
	private final JLabel label_1 = new JLabel("New label");
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblUniversit = new JLabel("Universit\u00E0");
	private final JLabel lblFacolt = new JLabel("Facolt\u00E0");
	private final JSeparator separator_2 = new JSeparator();
	private final JLabel lblCorso = new JLabel("Corso");
	private final JSeparator separator_3 = new JSeparator();
	private final JPanel panel_ricerca_guidata = new JPanel();
	private final JPanel panel_risultati = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_14 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JScrollPane scrollPane_2 = new JScrollPane(panel_14);
	private final JScrollPane scrollPane = new JScrollPane(panel_1);
	private final JScrollPane scrollPane_1 = new JScrollPane(panel_3);
	private final GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	private final GroupLayout gl_panel_2 = new GroupLayout(panel_3);
	private final GroupLayout gl_panel_3 = new GroupLayout(panel_14);
	private boolean is_ricerca_guidata_open = false;
	private boolean is_ricerca_by_corso_in_progress = false;
	private final JPanel panel_risultati_bycorso = new JPanel();
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel label_2 = new JLabel("");
	private final JLabel label_4 = new JLabel("Ordina per:");
	private final JLabel lblCercaIn = new JLabel("Cerca in:");
	private final JSeparator separator_10 = new JSeparator();
	private final JSeparator separator_11 = new JSeparator();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JLabel label_3 = new JLabel("Risultati trovati per:");
	private final JPanel panel_12 = new JPanel();
	private final JLabel label_5 = new JLabel("");
	private final JLabel lblDocumentiTrovatiPer = new JLabel("Documenti trovati per il corso:");
	private final JComboBox comboBox = new JComboBox();
	private final JComboBox comboBox_1 = new JComboBox();
	private final JComboBox comboBox_2 = new JComboBox();
	private final ButtonStandard buttonCreator = new ButtonStandard();
	private final JLabel lblRicercaAvanzata = new JLabel(
			"Non sei riuscito a trovare quello che cercavi?");
	private final JButton btnNewButton = buttonCreator.createButton("Mostra la ricerca guidata!", 652, 7, 310, 28, false, true);
	private final JPanel panel_13 = new JPanel();
	private final JLabel label_6 = new JLabel("");
	
	public void resetPanel(String ricerca) {
		tempRicerca = ricerca;
		panel.setBounds(0, 0, 1008, 429);
		panel_risultati_bycorso.setVisible(false);
		panel_risultati.setVisible(true);
		resetListe();
		isOverSelectionPanel = false;
		indexUniv = -1;
		dbIndexUniv = -1;
		indexFac = -1;
		dbIndexFac = -1;
		indexCorso = -1;
		dbIndexCorso = -1;
		indexCorsoByFac = -1;
		dbIndexCorsoByFac = -1;
		fileSelezionato = false;
		Path target = null;
		panel_6.setBackground(Home.BLUE_SEARCH_BAR);
		panel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_7.setBackground(Home.BLUE_BUTTON_PRESSED);
		panel_10.setVisible(false);
		Home.setOldButtonColor("ricerca_corsi", Home.BLUE_BUTTON_PRESSED);
		panel_7.setBackground(Home.BLUE_BUTTON_PRESSED);
		Home.setOldButtonColor("ricerca_doc", Home.BLUE_SEARCH_BAR);
		panel_6.setBackground(Home.BLUE_SEARCH_BAR);
		panel_10.setVisible(false);
		panel_9.setVisible(true);
		lblDocumentiTrovatiPer.setText("Documenti trovati per:");
		label_5.setBounds(225, 9, 770, 25);
		lblDocumentiTrovatiPer.setBounds(10, 9, 215, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tutte le facolt\u00E0", "Solo nella mia facolt\u00E0"}));
		is_ricerca_by_corso_in_progress = false;
		Home.setOldButtonColor("ricerca_doc", Home.BLUE_SEARCH_BAR);
		Home.setOldButtonColor("ricerca_corsi", Home.BLUE_BUTTON_PRESSED);
		listaUniversita = ControllerUniversita.getInstance().getAllUniversita();
		listaFacoltaByUniv = ControllerFacolta.getInstance()
				.getAllFacoltaByUniv(-1);
		listaCorsi = ControllerCorso.getInstance().getAllCorsi();
		listaCorsiByFac = null;
		label_5.setText("'"+ricerca+"'");
		reloadUniv();
		//adjustDocsSearch(ControllerDocumento.getInstance().getListAllDocumenti());
		try {
			adjustDocsSearch(ControllerDocumento.getInstance().getListAllDocumentiByStringSearch(ricerca.toLowerCase(), false, "all", "timestampDOWN"));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		is_ricerca_guidata_open = false;
		reloadRisultati();
		Home.forceResizeEvent();
		panel.revalidate();
		panel.repaint();
	}
	
	private void showRisultatiByCorso(int index_facolta, int index_corso, boolean soloFac, String filtro, String sorting) {
		panel_risultati.setVisible(false);
		panel_risultati_bycorso.setVisible(true);
		lblDocumentiTrovatiPer.setText("Documenti trovati per il corso:");
		label_5.setText(ControllerCorso.getInstance().getCorso(index_corso).getNome());
		label_5.setBounds(301, 9, 694, 25);
		lblDocumentiTrovatiPer.setBounds(10, 9, 288, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tutte le facolt\u00E0", "Solo nella facolt\u00E0 selezionata"}));
		is_ricerca_by_corso_in_progress = true;
		try {
			adjustDocsByCorso(ControllerDocumento.getInstance().getListAllDocumentiByCorso(index_facolta,index_corso,soloFac,filtro,sorting));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//.getListAllDocumenti());
		is_ricerca_guidata_open = false;
		Home.forceResizeEvent();
	}

	/**
	 * Create the panel.
	 */
	public RisultatiRicerca() {
		setLayout(null);

		panel.setBounds(0, 0, 1008, 429);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(16);

		panel.getParent().addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				spaghettiResize();

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
		
		JLabel lab = new JLabel("Cerca documenti");
		lab.setPreferredSize(new Dimension(500,38));
		JLabel lab2 = new JLabel("Cerca documenti");
		lab.setPreferredSize(new Dimension(500,38));
		
		/*JPanel newPanelz = new JPanel();
		newPanelz.setBackground(Color.blue);
		newPanelz.setSize(100, 100);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, newPanelz);
	     */
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 1008, 38);
		panel.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(Home.BLUE_SEARCH_BAR);
		
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setVisible(false);
		separator_12.setBounds(0, 0, 1008, 1);
		separator_12.setForeground(Home.BLUE_BUTTON_PRESSED);
		panel_5.add(separator_12);
		panel_6.setBounds(505, 1, 503, 37);
		panel_5.add(panel_6);
		panel_6.setBackground(Home.BLUE_SEARCH_BAR);
		panel_6.setLayout(null);
		
		JLabel lblCercaCorsi = new JLabel("Cerca corsi");
		lblCercaCorsi.setBounds(202, 9, 99, 22);
		lblCercaCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCercaCorsi.setForeground(Color.WHITE);
		lblCercaCorsi.setFont(new Font("Arial", Font.BOLD, 18));
		panel_6.add(lblCercaCorsi);
		panel_6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				panel_6.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				panel_6.setBackground(Home.getOldButtonColor("ricerca_doc"));
			}

			public void mouseClicked(MouseEvent e) {
				Home.setOldButtonColor("ricerca_corsi", Home.BLUE_SEARCH_BAR);
				panel_7.setBackground(Home.BLUE_SEARCH_BAR);
				Home.setOldButtonColor("ricerca_doc", Home.BLUE_BUTTON_PRESSED);
				panel_6.setBackground(Home.BLUE_BUTTON_PRESSED);
				panel_9.setVisible(false);
				panel_10.setVisible(true);
				String campoRicerca = Home.getRicercaTestuale().getText();
				label_6.setText("'"+campoRicerca+"'");
				loadRisultatiCorsi(campoRicerca);
			}
		});
		
		panel_7.setBounds(0, 1, 503, 37);
		panel_5.add(panel_7);
		panel_7.setBackground(Home.BLUE_SEARCH_BAR);
		panel_7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				panel_7.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				panel_7.setBackground(Home.getOldButtonColor("ricerca_corsi"));
			}

			public void mouseClicked(MouseEvent e) {
				Home.setOldButtonColor("ricerca_corsi", Home.BLUE_BUTTON_PRESSED);
				panel_7.setBackground(Home.BLUE_BUTTON_PRESSED);
				Home.setOldButtonColor("ricerca_doc", Home.BLUE_SEARCH_BAR);
				panel_6.setBackground(Home.BLUE_SEARCH_BAR);
				panel_10.setVisible(false);
				panel_9.setVisible(true);
				Home.cerca(Home.getRicercaTestuale().getText());
				//reload();
				//resetPanel(Home.getRicercaTestuale().getText());
				//label_6.setText("Risultati trovati per:");
			}
		});
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cerca documenti");
		lblNewLabel_1.setBounds(177, 9, 149, 22);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel_7.add(lblNewLabel_1);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(0, 38, 1008, 391);
		
		panel.add(panel_10);
		panel_10.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(0, 0, 1008, 38);
		
		panel_10.add(panel_11);
		panel_11.setLayout(null);
		label_3.setBounds(5, 5, 188, 24);
		label_3.setForeground(new Color(6, 121, 159));
		label_3.setFont(new Font("Arial", Font.BOLD, 20));
		
		panel_11.add(label_3);
		label_6.setForeground(new Color(6, 121, 159));
		label_6.setFont(new Font("Arial", Font.BOLD, 20));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(196, 5, 802, 24);
		
		panel_11.add(label_6);
		panel_13.setLayout(null);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(0, 38, 1008, 313);
		
		panel_10.add(panel_13);
		
		
		
		
		
		
		gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE))
			);
		gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(223, Short.MAX_VALUE))
			);
			panel_13.setBounds(0, 38, 1008, 313);
			
					panel_13.setBackground(Color.WHITE);
					panel_13.setLayout(null);
																	panel_14.setBackground(Color.WHITE);
																	panel_14.setBounds(56, 81, 525, 300);
																	scrollPane_2.setBorder(new LineBorder(new Color(27, 50, 128)));
																	
																	scrollPane_2
																					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
																			panel_15.setBorder(new EmptyBorder(0, 0, 0, 0));
																			panel_15.setBackground(Color.WHITE);
																			panel_15.setLayout(null);
																			panel_14.setLayout(gl_panel_3);
																			scrollPane_2.setBounds(0, 0, 1006, 313);
																			panel_13.add(scrollPane_2, BorderLayout.CENTER);
		panel_9.setBackground(Color.WHITE);
	
		panel_9.setBounds(0, 38, 1008, 391);
		panel.add(panel_9);
		panel_9.setLayout(null);
		panel_12.setLayout(null);
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(0, 0, 1008, 38);
		
		panel_9.add(panel_12);
		label_5.setForeground(new Color(6, 121, 159));
		label_5.setFont(new Font("Arial", Font.BOLD, 20));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(301, 9, 694, 25);
		
		panel_12.add(label_5);
		lblDocumentiTrovatiPer.setForeground(new Color(6, 121, 159));
		lblDocumentiTrovatiPer.setFont(new Font("Arial", Font.BOLD, 20));
		lblDocumentiTrovatiPer.setBounds(10, 9, 288, 25);
		
		panel_12.add(lblDocumentiTrovatiPer);
		panel_8.setBounds(0, 38, 1008, 38);
		panel_9.add(panel_8);
		panel_8.setBackground(Color.WHITE);
		panel_8.setLayout(null);
		label_4.setBounds(740, 6, 108, 25);
		panel_8.add(label_4);
		label_4.setForeground(new Color(6, 121, 159));
		label_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblCercaIn.setBounds(10, 6, 85, 25);
		panel_8.add(lblCercaIn);
		lblCercaIn.setForeground(new Color(6, 121, 159));
		lblCercaIn.setFont(new Font("Arial", Font.BOLD, 20));
		separator_10.setBackground(new Color(6, 121, 159));
		separator_10.setBounds(440, 5, 1, 28);
		panel_8.add(separator_10);
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setForeground(new Color(6, 121, 159));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tutte le facolt\u00E0", "Solo nella mia facolt\u00E0"}));
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				reloadRisultati();
			}
		});
		comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox.setBounds(97, 5, 336, 30);
		comboBox.setBackground(new Color(255,255,255));
		panel_8.add(comboBox);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"I pi\u00F9 votati", "I pi\u00F9 recenti", "I pi\u00F9 scaricati", "I meno votati", "I meno recenti", "I meno scaricati"}));
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_1.setBounds(854, 5, 144, 30);
		comboBox_1.setBackground(new Color(255,255,255));
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				reloadRisultati();
			}
		});
		panel_8.add(comboBox_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(new Color(6, 121, 159));
		separator_4.setBackground(new Color(6, 121, 159));
		separator_4.setBounds(733, 5, 1, 28);
		panel_8.add(separator_4);
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Qualsiasi tipo", "Solo appunti", "Solo esercizi", "Solo slide", "Solo dispense"}));
		comboBox_2.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(584, 5, 142, 30);
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				reloadRisultati();
			}
		});
		panel_8.add(comboBox_2);
		
		JLabel lblFiltraPerTipo = new JLabel("Filtra per tipo:");
		lblFiltraPerTipo.setForeground(new Color(6, 121, 159));
		lblFiltraPerTipo.setFont(new Font("Arial", Font.BOLD, 20));
		lblFiltraPerTipo.setBounds(447, 6, 134, 25);
		panel_8.add(lblFiltraPerTipo);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		panel_risultati.setBounds(0, 76, 1008, 186);
		panel_9.add(panel_risultati);
		
				panel_risultati.setBackground(Color.WHITE);
				panel_risultati.setLayout(null);
																panel_1.setBackground(Color.WHITE);
																panel_1.setBounds(56, 81, 525, 300);
																scrollPane.setBorder(new LineBorder(new Color(27, 50, 128)));
																
																		scrollPane
																				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
																		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
																		panel_2.setBackground(Color.WHITE);
																		panel_2.setLayout(null);
																		panel_1.setLayout(gl_panel_1);
																		scrollPane.setBounds(0, 0, 1006, 313);
																		panel_risultati.add(scrollPane, BorderLayout.CENTER);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE))
			);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(223, Short.MAX_VALUE))
			);
		panel_risultati_bycorso.setBounds(0, 76, 1008, 186);
		panel_9.add(panel_risultati_bycorso);
		
		panel_risultati_bycorso.setLayout(null);
		panel_risultati_bycorso.setBackground(Color.WHITE);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBorder(new LineBorder(new Color(27, 50, 128)));
		scrollPane_1.setBounds(0, 0, 1006, 313);
		
		panel_risultati_bycorso.add(scrollPane_1);
		separator_11.setForeground(new Color(27, 50, 128));
		separator_11.setBounds(0, 41, 170, 1);
		
		panel_risultati_bycorso.add(separator_11);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(56, 81, 525, 300);
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_3.setLayout(gl_panel_2);
		panel_ricerca_guidata.setForeground(Color.WHITE);
		panel_ricerca_guidata.setBounds(0, 350, 1008, 235);
		panel_9.add(panel_ricerca_guidata);

		panel_ricerca_guidata.setBackground(Home.BLUE_BUTTON_PRESSED);
		panel_ricerca_guidata.setLayout(null);
		label.setBounds(319, 130, 12, 20);
		panel_ricerca_guidata.add(label);
		label.setIcon(new ImageIcon("./newimage/freccia_right_blue.png"));
		label_1.setBounds(640, 130, 12, 20);
		panel_ricerca_guidata.add(label_1);
		label_1.setIcon(new ImageIcon("./newimage/freccia_right_blue.png"));


		lblRicercaAvanzata.setBounds(10, 10, 428, 25);
		panel_ricerca_guidata.add(lblRicercaAvanzata);
		lblRicercaAvanzata.setForeground(Color.WHITE);
		lblRicercaAvanzata.setFont(new Font("Arial", Font.BOLD, 20));
		scegli_univ.setBorder(new LineBorder(new Color(0, 0, 0)));
		scegli_univ.setBounds(10, 41, 310, 180);
		panel_ricerca_guidata.add(scegli_univ);

		scegli_univ.setLayout(null);
		scegli_univ.setBackground(Color.WHITE);

		list_2.setForeground(Color.DARK_GRAY);
		list_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		list_2.setBackground(Color.WHITE);

		list_2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// System.out.println("sss");
				if (list_2.getSelectedIndex() != -1) {
					String s = (String) list_2.getSelectedValue();
					// textField_3.setText(s);
					indexUniv = list_2.getSelectedIndex();
					dbIndexUniv = listaUniversita[indexUniv].getID();
					RisultatiRicerca.reloadFac(dbIndexUniv);
				}
			}
		});
		JScrollPane pane_list_2 = new JScrollPane(list_2);
		pane_list_2.setBounds(10, 40, 290, 130);
		pane_list_2.setBorder(new EmptyBorder(0, 0, 0, 0));

		scegli_univ.add(pane_list_2);
		aggiungiListnerMouseOver(scegli_univ);
		aggiungiListnerMouseOver(list_2);
		separator_1.setForeground(Home.BLUE_BUTTON_PRESSED);
		separator_1.setBounds(10, 28, 290, 1);

		scegli_univ.add(separator_1);
		lblUniversit.setFont(new Font("Arial", Font.BOLD, 14));
		lblUniversit.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblUniversit.setBounds(10, 11, 83, 14);

		scegli_univ.add(lblUniversit);
		scegli_fac.setBorder(new LineBorder(new Color(0, 0, 0)));
		scegli_fac.setBounds(331, 41, 310, 180);
		panel_ricerca_guidata.add(scegli_fac);
		scegli_fac.setBackground(Color.WHITE);
		scegli_fac.setLayout(null);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedIndex() != -1) {
					String s = (String) list.getSelectedValue();
					// textField_2.setText(s);
					indexFac = list.getSelectedIndex();
					dbIndexFac = listaFacoltaByUniv[indexFac].getID();
					RisultatiRicerca.reloadCorsoByFac(dbIndexFac);
				}
			}
		});

		list.setForeground(Color.DARK_GRAY);
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));

		JScrollPane pane_list = new JScrollPane(list);
		pane_list.setBounds(10, 40, 290, 130);
		pane_list.setBorder(new EmptyBorder(0, 0, 0, 0));

		scegli_fac.add(pane_list);
		scegli_fac.setFocusable(false);
		list.setFocusable(false);

		aggiungiListnerMouseOver(scegli_fac);
		aggiungiListnerMouseOver(list);
		lblFacolt.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblFacolt.setFont(new Font("Arial", Font.BOLD, 14));
		lblFacolt.setBounds(10, 11, 83, 14);

		scegli_fac.add(lblFacolt);
		separator_2.setForeground(Home.BLUE_BUTTON_PRESSED);
		separator_2.setBounds(10, 28, 290, 1);

		scegli_fac.add(separator_2);
		scegli_corso.setBorder(new LineBorder(new Color(0, 0, 0)));
		scegli_corso.setBounds(652, 41, 310, 180);
		panel_ricerca_guidata.add(scegli_corso);

		scegli_corso.setLayout(null);
		scegli_corso.setBackground(Color.WHITE);

		list_1.setForeground(Color.DARK_GRAY);
		list_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		list_1.setBackground(Color.WHITE);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list_1.getSelectedIndex() != -1) {
					String s = (String) list_1.getSelectedValue();
					// textField_4.setText(s);
					indexCorso = list_1.getSelectedIndex();
					dbIndexCorsoByFac = listaCorsiByFac[indexCorso].getID();
					showRisultatiByCorso(dbIndexFac,dbIndexCorsoByFac,false,"all","timestampDOWN");
				}
			}
		});

		JScrollPane pane_list_1 = new JScrollPane(list_1);

		pane_list_1.setBounds(10, 40, 290, 130);
		pane_list_1.setBorder(new EmptyBorder(0, 0, 0, 0));

		scegli_corso.add(pane_list_1);
		aggiungiListnerMouseOver(scegli_corso);
		aggiungiListnerMouseOver(list_1);
		lblCorso.setForeground(Home.BLUE_BUTTON_PRESSED);
		lblCorso.setFont(new Font("Arial", Font.BOLD, 14));
		lblCorso.setBounds(10, 11, 83, 14);

		scegli_corso.add(lblCorso);
		separator_3.setForeground(Home.BLUE_BUTTON_PRESSED);
		separator_3.setBounds(10, 28, 290, 1);

		scegli_corso.add(separator_3);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAndHideBarraGuidata();
			}
		});
		//btnNewButton.setBounds(688, 7, 310, 28);
		panel_ricerca_guidata.add(btnNewButton);

	}

	protected void spaghettiResize() {
		int dimensione_fill_home_bottom = (panel.getParent()
				.getHeight() - Home.MIN_DIMENSION_Y + 300);
		panel_10.setBounds(panel_10.getX(), panel_10.getY(), panel_10.getWidth(),
				panel_10.getHeight() + dimensione_fill_home_bottom+184);
		panel_13.setBounds(0, 38, panel_13.getWidth(),
				dimensione_fill_home_bottom+184);
		scrollPane_2.setBounds(scrollPane_2.getX(), scrollPane_2.getY(),
				scrollPane_2.getWidth(), panel_13.getHeight());
		if (is_ricerca_guidata_open) {
			panel.setBounds(panel.getX(), panel.getY(), panel.getWidth(),
					panel.getHeight() + dimensione_fill_home_bottom);
			panel_9.setBounds(panel_9.getX(), panel_9.getY(), panel_9.getWidth(),
					panel_9.getHeight() + dimensione_fill_home_bottom);
			panel_risultati.setBounds(0, 76, panel_risultati.getWidth(),
					dimensione_fill_home_bottom -8 -76);
			panel_risultati_bycorso.setBounds(0, 76, panel_risultati.getWidth(),
					dimensione_fill_home_bottom -8 -76);
			scrollPane.setBounds(scrollPane.getX(), scrollPane.getY(),
					scrollPane.getWidth(), panel_risultati.getHeight() - 0);
			scrollPane_1.setBounds(scrollPane.getX(), scrollPane.getY(),
					scrollPane.getWidth(), panel_risultati.getHeight() - 0);
			panel_ricerca_guidata.setBounds(0,
					dimensione_fill_home_bottom + 20 - 28,
					panel_ricerca_guidata.getWidth(),
					panel_ricerca_guidata.getHeight());
			btnNewButton.setText("Nascondi la ricerca guidata");
			lblRicercaAvanzata.setText("Ricerca guidata");
		} else {
			panel.setBounds(panel.getX(), panel.getY(), panel.getWidth(),
					panel.getHeight() + dimensione_fill_home_bottom );
			panel_9.setBounds(panel_9.getX(), panel_9.getY(), panel_9.getWidth(),
					panel_9.getHeight() + dimensione_fill_home_bottom );
			panel_risultati.setBounds(0, 76, panel_risultati.getWidth(),
					dimensione_fill_home_bottom -18 -76 + 200);
			panel_risultati_bycorso.setBounds(0, 76, panel_risultati.getWidth(),
					dimensione_fill_home_bottom -18 -76 + 200);
			scrollPane.setBounds(scrollPane.getX(), scrollPane.getY(),
					scrollPane.getWidth(), panel_risultati.getHeight() - 0);
			scrollPane_1.setBounds(scrollPane.getX(), scrollPane.getY(),
					scrollPane.getWidth(), panel_risultati.getHeight() - 0);
			panel_ricerca_guidata.setBounds(0,
					dimensione_fill_home_bottom + 20 + 200 - 38,
					panel_ricerca_guidata.getWidth(),
					panel_ricerca_guidata.getHeight());
			btnNewButton.setText("Mostra la ricerca guidata!");
			lblRicercaAvanzata.setText("Non sei riuscito a trovare quello che cercavi?");
		}
		
	}

	protected void loadRisultatiCorsi(String campoRicerca) {
		try {
			adjustCorsiSearch(ControllerCorso.getInstance().getListCorsoByString(campoRicerca.toLowerCase()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCorsiSearch(final ArrayList<Corso> corsi) {

		if (corsi == null) {
			return;
		}

		int col = 0;
		for (int i = 0; i < corsi.size(); i++) {
			final Corso d = corsi.get(i);
			final RiquadroCorso corso = new RiquadroCorso(d,false);//
			col = (int) Math.floor(i / 2);
			int row = i % 2;
			corso.setLocation((32 + (485 * row)), 32 + (230 * col));
			panel_15.add(corso);

		}
		
		if (corsi.size() == 0) {
			JLabel lblNoCor = new JLabel("Nessun corso trovato");
			lblNoCor.setFont(new Font("Arial", Font.BOLD, 20));
			lblNoCor.setBounds(10, 0, 310, 57);
			lblNoCor.setForeground(Color.LIGHT_GRAY);
			panel_15.add(lblNoCor);
		}
		
		int altezza = 252 + (230 * col);

		panel_15.setSize(panel_15.getWidth(), altezza);

		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE,
								altezza, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE)));

	}

	private void adjustCorsiSearch(final ArrayList<Corso> corsi) {
		panel_15.removeAll();
		panel_15.validate();
		panel_15.repaint();
		addCorsiSearch(corsi);
	}

	protected void reloadRisultati() {
		//System.out.println(is_ricerca_by_corso_in_progress);
		boolean fac = false;
		if (comboBox.getSelectedIndex()==1) {
			fac = true;
		}
		String filtro = "all";
		if (comboBox_2.getSelectedIndex()==0) {
			filtro = "all";
		}
		if (comboBox_2.getSelectedIndex()==1) {
			filtro = "Appunti";
		}
		if (comboBox_2.getSelectedIndex()==2) {
			filtro = "Esercizi";
		}
		if (comboBox_2.getSelectedIndex()==3) {
			filtro = "Slide";
		}
		if (comboBox_2.getSelectedIndex()==4) {
			filtro = "Dispense";
		}
				
		String sorting = "timestampDOWN";
		if (comboBox_1.getSelectedIndex()==0) {
			sorting = "votoUP";
		}
		if (comboBox_1.getSelectedIndex()==1) {
			sorting = "timestampUP";
		}
		if (comboBox_1.getSelectedIndex()==2) {
			sorting = "downloadUP";
		}
		if (comboBox_1.getSelectedIndex()==3) {
			sorting = "votoDOWN";
		}
		if (comboBox_1.getSelectedIndex()==4) {
			sorting = "timestampDOWN";
		}
		if (comboBox_1.getSelectedIndex()==5) {
			sorting = "downloadDOWN";
		}
		
		if (is_ricerca_by_corso_in_progress) {
			try {
				adjustDocsByCorso(ControllerDocumento.getInstance().getListAllDocumentiByCorso(dbIndexFac,dbIndexCorsoByFac,fac,filtro,sorting));
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		} else {
			try {
				adjustDocsSearch(ControllerDocumento.getInstance().getListAllDocumentiByStringSearch(tempRicerca, fac, filtro,sorting));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void showAndHideBarraGuidata() {
		if (is_ricerca_guidata_open) {
			is_ricerca_guidata_open = false;
		} else {
			is_ricerca_guidata_open = true;
		}
		panel.revalidate();
		panel.repaint();
		Home.forceResizeEvent();
		spaghettiResize();
	}

	public void addDocumentiSearch(final ArrayList<Documento> docs) {

		if (docs == null) {
			return;
		}

		int col = 0;
		for (int i = 0; i < docs.size(); i++) {
			final Documento d = docs.get(i);
			final RiquadroDoc documento = new RiquadroDoc(d, false, true);// createFavourite(docs.get(i));
			col = (int) Math.floor(i / 2);
			int row = i % 2;
			documento.setLocation((32 + (485 * row)), 32 + (230 * col));
			panel_2.add(documento);

		}
		
		if (docs.size() == 0) {
			JLabel lblNoDoc = new JLabel("Nessun documento trovato");
			lblNoDoc.setFont(new Font("Arial", Font.BOLD, 20));
			lblNoDoc.setBounds(10, 0, 310, 57);
			lblNoDoc.setForeground(Color.LIGHT_GRAY);
			panel_2.add(lblNoDoc);
		}
		
		int altezza = 252 + (230 * col);

		panel_2.setSize(panel_2.getWidth(), altezza);

		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE,
								altezza, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE)));

	}

	private void adjustDocsSearch(final ArrayList<Documento> docs) {
		panel_2.removeAll();
		panel_2.validate();
		panel_2.repaint();
		addDocumentiSearch(docs);
	}
	
	public void addDocumentiByCorso(final ArrayList<Documento> docs) {

		if (docs == null) {
			return;
		}

		int col = 0;
		for (int i = 0; i < docs.size(); i++) {
			final Documento d = docs.get(i);
			final RiquadroDoc documento = new RiquadroDoc(d, false,true);// createFavourite(docs.get(i));
			col = (int) Math.floor(i / 2);
			int row = i % 2;
			documento.setLocation((32 + (485 * row)), 32 + (230 * col));
			panel_4.add(documento);

		}
		
		if (docs.size() == 0) {
			JLabel lblNoDocCorso = new JLabel("Nessun documento trovato");
			lblNoDocCorso.setFont(new Font("Arial", Font.BOLD, 20));
			lblNoDocCorso.setBounds(10, 0, 310, 57);
			lblNoDocCorso.setForeground(Color.LIGHT_GRAY);
			panel_4.add(lblNoDocCorso);
		}
		
		int altezza = 252 + (230 * col);

		panel_4.setSize(panel_4.getWidth(), altezza);

		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE,
								altezza, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE)));

	}
	
	private void adjustDocsByCorso(final ArrayList<Documento> docs) {
		panel_4.removeAll();
		panel_4.validate();
		panel_4.repaint();
		addDocumentiByCorso(docs);
	}

	protected static void reloadFac(int indiceUniv) {
		listaFacoltaByUniv = ControllerFacolta.getInstance()
				.getAllFacoltaByUniv(indiceUniv);
		final String[] values = new String[listaFacoltaByUniv.length];
		for (int i = 0; listaFacoltaByUniv.length > i; i++) {
			values[i] = listaFacoltaByUniv[i].getNome();
		}
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	protected static void reloadUniv() {
		listaUniversita = ControllerUniversita.getInstance().getAllUniversita();
		final String[] values = new String[listaUniversita.length];
		for (int i = 0; listaUniversita.length > i; i++) {
			values[i] = listaUniversita[i].getNome();
		}
		list_2.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	protected static void reloadCorsoByFac(int dbIndexFac) {
		try {
			listaCorsiByFac = ControllerCorso.getInstance().getCorsiByFac(
					dbIndexFac);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String[] values = new String[listaCorsiByFac.length];
		for (int i = 0; listaCorsiByFac.length > i; i++) {
			values[i] = listaCorsiByFac[i].getNome();
		}
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	protected static void reloadTuttiCorsi() {
		listaCorsi = ControllerCorso.getInstance().getAllCorsi();
		final String[] values = new String[listaCorsi.length];
		for (int i = 0; listaCorsi.length > i; i++) {
			values[i] = listaCorsi[i].getNome();
		}
	}

	protected void aggiungiListnerMouseOver(final Component component) {
		component.setFocusable(false);
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				isOverSelectionPanel = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				isOverSelectionPanel = false;
			}
		});
	}

	protected static void nascondiTutto() {
		scegli_univ.setVisible(false);
		scegli_fac.setVisible(false);
		scegli_corso.setVisible(false);
	}

	private void resetListe() {
		list_2.removeAll();
		list_1.removeAll();
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return 0;
			}

			public Object getElementAt(int index) {
				return null;
			}
		});
		list.removeAll();
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return 0;
			}

			public Object getElementAt(int index) {
				return null;
			}
		});
	}

	@Override
	public void reload() {
		resetPanel(Home.getRicercaTestuale().getText());
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}

	@Override
	public void reload(Object o) {

	}
	
	public static class MyTabbedPaneUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {

	    @Override
	    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, 
	               int tabIndex, Rectangle iconRect, Rectangle textRect) {
	        Color savedColor = g.getColor();
	        g.setColor(Color.PINK);
	        
	        //g.fillRect(rects[tabIndex].x, rects[tabIndex].y, 
	        //       rects[tabIndex].width, rects[tabIndex].height);
	        g.fillRect(0,0,200,200);
	        g.setColor(Color.BLUE);
	        //g.drawRect(rects[tabIndex].x, rects[tabIndex].y, 
	        //       rects[tabIndex].width, rects[tabIndex].height);
	        g.drawRect(0,0,200,200);
	        g.setColor(savedColor);
	    }
	 }
}

