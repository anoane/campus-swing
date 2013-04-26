package gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.orm.PersistentException;

import modello_di_dominio.Corso;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;
import modello_di_dominio.Utente;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import controller.ControllerCorso;
import controller.ControllerDocumento;
import controller.ControllerUniversita;
import controller.ControllerUtente;

import controller.ControllerFacolta;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

//TODO:utente, load univ e facolta in base alla facolta a cui è iscritto l'utente

public class RisultatiRicerca extends Pagina  {
	private JPanel panel = new JPanel();
	private static JPanel scegli_fac = new JPanel();
	private static JPanel scegli_corso = new JPanel();
	private static JPanel scegli_univ = new JPanel();
	final static JList list = new JList();
	final static JList list_1 = new JList();
	final static JList list_2 = new JList();
	static boolean isOverSelectionPanel =  false;
	private int indexUniv = -1;
	private int dbIndexUniv = -1;
	private int indexFac = -1;
	private int dbIndexFac = -1;
	private int indexCorso = -1;
	private int dbIndexCorso = -1;
	private int indexCorsoByFac = -1;
	private int dbIndexCorsoByFac = -1;
	private boolean fileSelezionato = false;
	private Path target;
	static Universita[] listaUniversita = ControllerUniversita.getInstance().getAllUniversita();
	static Facolta[] listaFacoltaByUniv = ControllerFacolta.getInstance().getAllFacoltaByUniv(-1); 
	static Corso[] listaCorsi = ControllerCorso.getInstance().getAllCorsi(); 
	static Corso[] listaCorsiByFac = null; 
	JLabel lblNewLabel = new JLabel("");
	private final JLabel label = new JLabel("New label");
	private final JLabel label_1 = new JLabel("New label");
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblUniversit = new JLabel("Universit\u00E0");
	private final JLabel lblFacolt = new JLabel("Facolt\u00E0");
	private final JSeparator separator_2 = new JSeparator();
	private final JLabel lblCorso = new JLabel("Corso");
	private final JSeparator separator_3 = new JSeparator();
	private final JSeparator separator_4 = new JSeparator();
	private final JLabel lblRisultatiTrovatiPer = new JLabel("Risultati trovati per:");
	private final JLabel lblOrdinaPer = new JLabel("Ordina per:");
	private final JLabel lblIPiVotati = new JLabel("I pi\u00F9 votati");
	private final JLabel lblIPiRecenti = new JLabel("I pi\u00F9 recenti");
	private final JLabel lblIPiScaricati = new JLabel("I pi\u00F9 scaricati");
	private final JSeparator separator_5 = new JSeparator();
	private final JSeparator separator_6 = new JSeparator();
	
	
	public void resetPanel(String ricerca) {		
		isOverSelectionPanel =  false;
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
		listaUniversita = ControllerUniversita.getInstance().getAllUniversita();
		listaFacoltaByUniv = ControllerFacolta.getInstance().getAllFacoltaByUniv(-1); 
		listaCorsi = ControllerCorso.getInstance().getAllCorsi(); 
		listaCorsiByFac = null; 
		lblNewLabel.setText(ricerca);
		reloadUniv();
	}
	
	/**
	 * Create the panel.
	 */
	public RisultatiRicerca() {
		super();	
	}
	/*
	protected static boolean salvaUniv(String univ) {
		if(ControllerUniversita.getInstance().isUniversitaAlreadyPresent(univ)) {
			JOptionPane.showMessageDialog(Home.getFrame(), "Università già esistente", "Attenzione", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		ControllerUniversita.getInstance().createUniversita(univ);
		return true;
	}

	protected static boolean salvaFac(String facolta, int indexUniv) {
		if(ControllerFacolta.getInstance().isFacoltaByUnivAlreadyPresent(facolta,indexUniv)) {
			JOptionPane.showMessageDialog(Home.getFrame(), "Facoltà già esistente", "Attenzione", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		ControllerFacolta.getInstance().createFacolta(facolta,indexUniv);
		return true;
	}
	
	protected static boolean salvaCorso(String nomeCorso, String descrizione, int index_fac) {
		if(ControllerCorso.getInstance().isCorsoAlreadyPresent(nomeCorso)) {
			JOptionPane.showMessageDialog(Home.getFrame(), "Corso già esistente", "Attenzione", JOptionPane.WARNING_MESSAGE);
			int index_corso = ControllerCorso.getInstance().getCorso(nomeCorso).getID();
			collegaCorso(index_corso,index_fac);
			return false;
		}
		ControllerCorso.getInstance().creaCorso(nomeCorso,descrizione,index_fac);
		return true;
	}
	
	protected static boolean collegaCorso(int index_corso, int index_fac) {
		if(ControllerCorso.getInstance().isCorsoAlreadyCollegato(index_corso,index_fac)) {
			JOptionPane.showMessageDialog(Home.getFrame(), "Questo corso è collegato alla tua facoltà", "Attenzione", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		ControllerCorso.getInstance().collegaCorsoFacolta(index_corso, index_fac);
		return true;
	}
*/
	protected static void reloadFac(int indiceUniv) {
		listaFacoltaByUniv = ControllerFacolta.getInstance().getAllFacoltaByUniv(indiceUniv);
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
			listaCorsiByFac = ControllerCorso.getInstance().getCorsiByFac(dbIndexFac);
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
		//System.out.println("relod corsi");
		listaCorsi = ControllerCorso.getInstance().getAllCorsi();
		final String[] values = new String[listaCorsi.length];
		for (int i = 0; listaCorsi.length > i; i++) {
			values[i] = listaCorsi[i].getNome();
		}
		/*list_3.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
	}

	protected void aggiungiListnerMouseOver(final Component component) {
		component.setFocusable(false);
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				isOverSelectionPanel = true;
				//System.out.println("in");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				isOverSelectionPanel = false;
				//System.out.println("out");
			}
		});
	}

	protected static void nascondiTutto() {
		scegli_univ.setVisible(false);
		scegli_fac.setVisible(false);
		scegli_corso.setVisible(false);
	}

	@Override
	public void load() {
		panel = new JPanel();
		scegli_fac = new JPanel();
		scegli_corso = new JPanel();
		scegli_univ = new JPanel();
		setLayout(null);

		panel.setBounds(0, 0, 1008, 542);
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
				//separator_1.setBounds(765, 48, 1, dimensione_fill_home_bottom+192);
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
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		lblNewLabel.setBounds(163, 225, 382, 25);
		panel.add(lblNewLabel);
		label.setIcon(new ImageIcon("./newimage/freccia_right.png"));
		label.setBounds(320, 120, 12, 20);
		
		panel.add(label);
		label_1.setIcon(new ImageIcon("./newimage/freccia_right.png"));
		label_1.setBounds(641, 120, 12, 20);
		
		panel.add(label_1);
		scegli_univ.setBorder(new LineBorder(new Color(0, 0, 0)));
		scegli_univ.setBounds(11, 40, 310, 180);
		panel.add(scegli_univ);
		
		scegli_univ.setLayout(null);
		scegli_univ.setBackground(new Color(67, 136, 204));
		

		list_2.setForeground(Color.WHITE);
		list_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		list_2.setBackground(new Color(67, 136, 204));
		
		list_2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//System.out.println("sss");
				if (list_2.getSelectedIndex() != -1) {
					String s = (String) list_2.getSelectedValue();
					//textField_3.setText(s);
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
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(10, 28, 290, 1);
		
		scegli_univ.add(separator_1);
		lblUniversit.setFont(new Font("Arial", Font.BOLD, 14));
		lblUniversit.setForeground(Color.LIGHT_GRAY);
		lblUniversit.setBounds(10, 11, 83, 14);
		
		scegli_univ.add(lblUniversit);
				scegli_fac.setBorder(new LineBorder(new Color(0, 0, 0)));
				scegli_fac.setBounds(332, 40, 310, 180);
				panel.add(scegli_fac);
				scegli_fac.setBackground(new Color(67, 136, 204));
				scegli_fac.setLayout(null);
				
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						if (list.getSelectedIndex() != -1) {
							String s = (String) list.getSelectedValue();
							//textField_2.setText(s);
							indexFac = list.getSelectedIndex();
							dbIndexFac = listaFacoltaByUniv[indexFac].getID();
						}
					}
				});
				
				
										
										list.setForeground(Color.WHITE);
										list.setBackground(new Color(67, 136, 204));
										list.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
										
										JScrollPane pane_list = new JScrollPane(list);  
										pane_list.setBounds(10, 40, 290, 130);
										pane_list.setBorder(new EmptyBorder(0, 0, 0, 0));
										
										
										
										scegli_fac.add(pane_list);
										scegli_fac.setFocusable(false);
										list.setFocusable(false);
										
										
										
										
										aggiungiListnerMouseOver(scegli_fac);
										aggiungiListnerMouseOver(list);
										lblFacolt.setForeground(Color.LIGHT_GRAY);
										lblFacolt.setFont(new Font("Arial", Font.BOLD, 14));
										lblFacolt.setBounds(10, 11, 83, 14);
										
										scegli_fac.add(lblFacolt);
										separator_2.setForeground(Color.LIGHT_GRAY);
										separator_2.setBounds(10, 28, 290, 1);
										
										scegli_fac.add(separator_2);
				scegli_corso.setBorder(new LineBorder(new Color(0, 0, 0)));
				scegli_corso.setBounds(653, 40, 310, 180);
				panel.add(scegli_corso);
		
				scegli_corso.setLayout(null);
				scegli_corso.setBackground(new Color(67, 136, 204));
				
				list_1.setForeground(Color.WHITE);
				list_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
				list_1.setBackground(new Color(67, 136, 204));
				list_1.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						if (list_1.getSelectedIndex() != -1) {
							String s = (String) list_1.getSelectedValue();
							//textField_4.setText(s);
							indexCorso = list_1.getSelectedIndex();
							dbIndexCorso = listaCorsi[indexCorso].getID();
						}
					}
				});
				
				JScrollPane pane_list_1 = new JScrollPane(list_1);  
				pane_list_1.setBounds(10, 40, 290, 130);
				pane_list_1.setBorder(new EmptyBorder(0, 0, 0, 0));
				
				
				scegli_corso.add(pane_list_1);
				aggiungiListnerMouseOver(scegli_corso);
				aggiungiListnerMouseOver(list_1);
				lblCorso.setForeground(Color.LIGHT_GRAY);
				lblCorso.setFont(new Font("Arial", Font.BOLD, 14));
				lblCorso.setBounds(10, 11, 83, 14);
				
				scegli_corso.add(lblCorso);
				separator_3.setForeground(Color.LIGHT_GRAY);
				separator_3.setBounds(10, 28, 290, 1);
				
				scegli_corso.add(separator_3);
				
				JSeparator separator = new JSeparator();
				separator.setForeground(new Color(27, 50, 128));
				separator.setBounds(10, 30, 953, 1);
				panel.add(separator);
				
				JLabel lblRicercaAvanzata = new JLabel("Ricerca avanzata");
				lblRicercaAvanzata.setForeground(new Color(6, 121, 159));
				lblRicercaAvanzata.setFont(new Font("Arial", Font.BOLD, 16));
				lblRicercaAvanzata.setBounds(10, 6, 190, 25);
				panel.add(lblRicercaAvanzata);
				separator_4.setForeground(new Color(27, 50, 128));
				separator_4.setBounds(10, 249, 953, 1);
				
				panel.add(separator_4);
				lblRisultatiTrovatiPer.setForeground(new Color(6, 121, 159));
				lblRisultatiTrovatiPer.setFont(new Font("Arial", Font.BOLD, 16));
				lblRisultatiTrovatiPer.setBounds(11, 225, 149, 25);
				
				panel.add(lblRisultatiTrovatiPer);
				lblOrdinaPer.setForeground(new Color(6, 121, 159));
				lblOrdinaPer.setFont(new Font("Arial", Font.BOLD, 16));
				lblOrdinaPer.setBounds(555, 225, 98, 25);
				
				panel.add(lblOrdinaPer);
				lblIPiVotati.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.out.println("click");
					}
				});
				lblIPiVotati.setForeground(new Color(6, 121, 159));
				lblIPiVotati.setFont(new Font("Arial", Font.BOLD, 16));
				lblIPiVotati.setBounds(653, 225, 84, 25);
				
				panel.add(lblIPiVotati);
				lblIPiRecenti.setForeground(new Color(6, 121, 159));
				lblIPiRecenti.setFont(new Font("Arial", Font.BOLD, 16));
				lblIPiRecenti.setBounds(750, 225, 92, 25);
				
				panel.add(lblIPiRecenti);
				lblIPiScaricati.setForeground(new Color(6, 121, 159));
				lblIPiScaricati.setFont(new Font("Arial", Font.BOLD, 16));
				lblIPiScaricati.setBounds(858, 225, 105, 25);
				
				panel.add(lblIPiScaricati);
				separator_5.setOrientation(SwingConstants.VERTICAL);
				separator_5.setForeground(new Color(27, 50, 128));
				separator_5.setBounds(848, 228, 2, 22);
				
				panel.add(separator_5);
				separator_6.setOrientation(SwingConstants.VERTICAL);
				separator_6.setForeground(new Color(27, 50, 128));
				separator_6.setBounds(740, 228, 2, 22);
				
				panel.add(separator_6);
		
		/*aggiungiListnerMouseOver
		aggiungiListnerMouseOver(
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver*/
		
		//aggiungiListnerMouseOver(list);
		//aggiungiListnerMouseOver(crea_fac);
		//RisultatiRicerca.nascondiTutto();
		
		
	}

	@Override
	public int getHeight() {
		return panel.getHeight();
	}
}