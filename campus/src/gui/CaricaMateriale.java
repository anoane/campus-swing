package gui;


import gui.helpers.JTextFieldLimit;
import gui.helpers.Pdf2Image;
import gui.helpers.ZebraJListBlue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modello_di_dominio.Corso;
import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import controller.ControllerCorso;
import controller.ControllerDocumento;
import controller.ControllerFacolta;
import controller.ControllerUniversita;
import controller.ControllerUtente;

public class CaricaMateriale extends Pagina  {
	private final static JPanel panel = new JPanel();
	private static ButtonStandard buttonCreator = new ButtonStandard();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JSeparator separator_1 = new JSeparator();
	private static JPanel panel_1 = new JPanel();
	private static JPanel panel_2 = new JPanel();
	private static JPanel panel_3 = new JPanel();
	private static JPanel panel_4 = new JPanel();
	private static JPanel panel_5 = new JPanel();
	private static JPanel scegli_fac = new JPanel();
	private static JPanel scegli_corso = new JPanel();
	private static JPanel scegli_univ = new JPanel();
	private static JPanel panel_9 = new JPanel();
	private static JPanel crea_corso = new JPanel();
	private static JPanel aggiungi_corso = new JPanel();
	private static JPanel panel_13 = new JPanel();
	private static JPanel crea_fac = new JPanel();
	private static JPanel panel_15 = new JPanel();
	private static JPanel crea_univ = new JPanel();
	final static ZebraJListBlue list = new ZebraJListBlue();
	final static ZebraJListBlue list_1 = new ZebraJListBlue();
	final static ZebraJListBlue list_2 = new ZebraJListBlue();
	final static ZebraJListBlue list_3 = new ZebraJListBlue();
	final JTextField textPane = new JTextField();
	final JButton btnScegliFile = new JButton("Scegli file...");
	
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextArea textArea_1 = new JTextArea();
	final static JButton btnConfermaSelezione = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
	final JTextArea textArea = new JTextArea();
	
	final static JButton btnAggiungiFacolt = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
	final static JButton button = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
	final static JButton button_1 = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
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
	
	
	/**
	 * Create the panel.
	 */
	public CaricaMateriale() {
		setLayout(null);

		panel.setBounds(0, 0, 992, 495);
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
				separator_1.setBounds(765, 48, 1, dimensione_fill_home_bottom+192);
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
		
		JLabel lblUltimiCorsiSeguiti = new JLabel("Carica documento");
		lblUltimiCorsiSeguiti.setForeground(new Color(6, 121, 159));
		lblUltimiCorsiSeguiti.setFont(new Font("Arial", Font.BOLD, 18));
		lblUltimiCorsiSeguiti.setBounds(10, 10, 310, 25);
		panel.add(lblUltimiCorsiSeguiti);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 48, 378, 356);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(3dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:max(74dlu;default)"),
				ColumnSpec.decode("right:max(170dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(3dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(3dlu;default)"),
				RowSpec.decode("max(83dlu;default):grow"),
				RowSpec.decode("max(3dlu;default)"),
				RowSpec.decode("top:max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),}));
		
		JLabel lblNewLabel = new JLabel("File *");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel, "3, 2, left, default");
		
		btnScegliFile.setFont(new Font("Arial", Font.PLAIN, 14));
		btnScegliFile.setFocusPainted(false);
		
		btnScegliFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.setFileFilter(new util.DocumentFilter());
				int returnVal = fc.showOpenDialog(btnScegliFile);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            String newname = file.getName();
		            File f = new File("files/"+newname);
		            if(f.exists()){
		            	newname = util.EstensioneFile.addRandToFileName(newname);
		            }
		            Path source = Paths.get(file.getPath());
		            target = Paths.get("files/"+newname);
		            try {
						Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
						fileSelezionato = true;
						btnScegliFile.setText("..."+source.toString().substring(source.toString().length()-30));
						btnScegliFile.setBackground(Color.GREEN);
						btnScegliFile.setForeground(new Color(0, 0, 0));
						//btnScegliFile.setBorder(new LineBorder(new Color(128,128,128),1));
						//btnScegliFile.setBorder(UIManager.getBorder("Button.border"));
						//btnScegliFile.setBorder(new EmptyBorder(0,0,0,0));
						//btnScegliFile.setBorder(new LineBorder(new Color(50,50,50),2));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Home.getFrame(), "Si è verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
					}
		            if (util.EstensioneFile.getExtension(f).matches("pdf")) {
		            	Pdf2Image.pdf2img(new File("files/"+newname));
		            }
		        } else {
		        	JOptionPane.showMessageDialog(Home.getFrame(), "Non riesco ad aprire questo file", "Errore", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnScegliFile.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnScegliFile, "4, 2, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Titolo *");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1, "3, 3, left, default");
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setBorder(UIManager.getBorder("TextField.border"));
			}
		});
		textField.setText("");
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(textField, "4, 3, fill, default");
		textField.setColumns(10);
		textField.setDocument(new JTextFieldLimit(254));
		
		JLabel lblNewLabel_2 = new JLabel("Descrizione *");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2, "3, 5, left, top");
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textArea.setBorder(UIManager.getBorder("TextArea.border"));
			}
		});
		textArea.setText("");
		
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		//textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		textArea.setWrapStyleWord(true);
		textArea.setDocument(new JTextFieldLimit(254));
		JScrollPane scrollPane = new JScrollPane(textArea); 
		panel_1.add(scrollPane, "4, 5, fill, fill");
		
		JLabel lblNewLabel_3 = new JLabel("Categoria *");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_3, "3, 7, left, center");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Appunti", "Dispense", "Esercizi", "Slide"}));
		panel_1.add(comboBox, "4, 7, fill, center");
		
		JLabel lblNewLabel_4 = new JLabel("Corso di studi *");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_4, "3, 9, left, default");
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_2.setDocument(new JTextFieldLimit(254));
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (!isOverSelectionPanel) {
					if (dbIndexUniv != -1) {
						CaricaMateriale.reloadFac(dbIndexUniv);
						CaricaMateriale.nascondiTutto();
						panel_2.setVisible(true);
						panel_4.setVisible(true);
						scegli_fac.setVisible(true);
					} else {
						textField_3.requestFocus();
						textField_3.setBorder(new LineBorder(new Color(128,0,0),2));
						//JOptionPane.showMessageDialog(Home.getFrame(), "Devi prima scegliere la tua università", "Attenzione", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			@Override
			public void focusLost(FocusEvent e) { 
				if (!isOverSelectionPanel) {
					CaricaMateriale.nascondiTutto();
				}
				//System.out.println("fuoco perso - valore booleano "+isOverSelectionPanel);
			}
		});
		panel_1.add(textField_2, "4, 9, fill, default");
		textField_2.setColumns(10);
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				    changed();
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changed();
				  }
				  public void insertUpdate(DocumentEvent e) {
					  changed();
				  }

				  public void changed() {
					  textField_4.setText("");
				  }
		});
		
		JLabel lblNewLabel_5 = new JLabel("Universit\u00E0 *");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_5, "3, 8, left, default");
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setDocument(new JTextFieldLimit(254));
		textField_3.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				    changed();
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changed();
				  }
				  public void insertUpdate(DocumentEvent e) {
					  changed();
				  }

				  public void changed() {
					  textField_2.setText("");
					  textField_4.setText("");
				  }
		});
		textField_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (!isOverSelectionPanel) {
					CaricaMateriale.reloadUniv();
					CaricaMateriale.nascondiTutto();
					panel_2.setVisible(true);
					panel_3.setVisible(true);
					scegli_univ.setVisible(true);
				}
			}
			@Override
			public void focusLost(FocusEvent e) { 
				if (!isOverSelectionPanel) {
					CaricaMateriale.nascondiTutto();
				}
			}
		});
		panel_1.add(textField_3, "4, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Corso *");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNewLabel_6, "3, 10, left, default");
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_4.setDocument(new JTextFieldLimit(254));
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (!isOverSelectionPanel) {
					if (dbIndexUniv != -1) {
						if (dbIndexFac != -1) {
							reloadCorsoByFac(dbIndexFac);
							CaricaMateriale.nascondiTutto();
							panel_2.setVisible(true);
							panel_5.setVisible(true);
							scegli_corso.setVisible(true);
						} else {
							textField_2.requestFocus();
							textField_2.setBorder(new LineBorder(new Color(128,0,0),2));
							//JOptionPane.showMessageDialog(Home.getFrame(), "Devi prima scegliere il tuo corso di studi", "Attenzione", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						textField_3.requestFocus();
						textField_3.setBorder(new LineBorder(new Color(128,0,0),2));
						//JOptionPane.showMessageDialog(Home.getFrame(), "Devi prima scegliere la tua università", "Attenzione", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (!isOverSelectionPanel) {
					CaricaMateriale.nascondiTutto();
				}
			}
		});
		panel_1.add(textField_4, "4, 10, fill, default");
		textField_4.setColumns(10);
		
		
		JButton btnCaricaMateriale = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
		//btnCaricaMateriale.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCaricaMateriale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean continua = true;
				if (!fileSelezionato) {
					continua = false;
					btnScegliFile.setBackground(new Color(128, 0, 0));
					btnScegliFile.setForeground(new Color(255, 255, 255));
					
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessun file selezionato", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (textField.getText().matches("")) {
					continua = false;
					textField.setBorder(new LineBorder(new Color(128,0,0),2));
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessun titolo assegnato", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (textArea.getText().matches("")) {
					continua = false;
					textArea.setBorder(new LineBorder(new Color(128,0,0),2));
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessuna descrizione immessa", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (comboBox.getSelectedItem().toString().matches("")) {
					continua = false;
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessuna tipologia selezionata", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (textField_3.getText().matches("")) {
					continua = false;
					textField_3.setBorder(new LineBorder(new Color(128,0,0),2));
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessuna università selezionata", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (textField_2.getText().matches("")) {
					continua = false;
					textField_2.setBorder(new LineBorder(new Color(128,0,0),2));
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessuna corso di studi selezionato", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (textField_4.getText().matches("")) {
					continua = false;
					textField_4.setBorder(new LineBorder(new Color(128,0,0),2));
					//JOptionPane.showMessageDialog(Home.getFrame(), "Nessuna corso selezionato", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				if (continua) {
					ControllerDocumento.getInstance().creaDocumento(textField.getText(), textArea.getText(), target.toString(), comboBox.getSelectedItem().toString(), Home.getUtenteLoggato(), ControllerCorso.getInstance().getCorso(textField_4.getText()),ControllerFacolta.getInstance().getFacolta(dbIndexFac));
					JOptionPane.showMessageDialog(Home.getFrame(), "Documento caricato correttamente!", "Caricamento documento", JOptionPane.INFORMATION_MESSAGE);
					Home.getPagina("miei_documenti");
						
				}
				
				//ControllerDocumento.getInstance().creaDocumento(nome, descrizione, path, u, c);		
			}
		});
		panel_1.add(btnCaricaMateriale, "4, 11, fill, default");
		
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(764, 48, 2, 356);
		panel.add(separator_1);
		
		/*JLabel lblNonHaiUno = new JLabel("Non hai uno scanner? Non hai tempo per digitalizzare il tuo materiale?");
		lblNonHaiUno.setVerticalAlignment(SwingConstants.TOP);
		lblNonHaiUno.setForeground(new Color(6, 121, 159));
		lblNonHaiUno.setFont(new Font("Arial", Font.BOLD, 20));
		lblNonHaiUno.setBounds(388, 60, 401, 206);
		panel.add(lblNonHaiUno);*/
		
		JTextPane txtpnNonHaiUno = new JTextPane();
		//txtpnNonHaiUno.setDocument(new JTextFieldLimit(254));
		txtpnNonHaiUno.setEditable(false);
		txtpnNonHaiUno.setFont(new Font("Arial", Font.BOLD, 20));
		txtpnNonHaiUno.setForeground(new Color(6, 121, 159));
		txtpnNonHaiUno.setText("Non hai uno scanner? Non hai tempo per digitalizzare il tuo materiale?");
		txtpnNonHaiUno.setBounds(772, 48, 222, 110);
		txtpnNonHaiUno.setHighlighter(null);
		panel.add(txtpnNonHaiUno);
		
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(377, 289, 12, 20);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("./newimage/freccia.png"));
		label_1.setBounds(0, 0, 12, 20);
		panel_3.add(label_1);
		
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setBounds(377, 319, 12, 20);
		panel.add(panel_4);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("./newimage/freccia.png"));
		label.setBounds(0, 0, 12, 20);
		panel_4.add(label);
		
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);
		panel_5.setBounds(377, 349, 12, 20);
		panel.add(panel_5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("./newimage/freccia.png"));
		lblNewLabel_7.setBounds(0, 0, 12, 20);
		panel_5.add(lblNewLabel_7);
		
		
		
		panel_2.setBackground(new Color(50,91,132));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(388, 54, 367, 348);
		panel.add(panel_2);
		panel_2.setLayout(null);
																		aggiungiListnerMouseOver(aggiungi_corso);
																		
																		aggiungi_corso.setBounds(1, 2, 365, 345);
																		panel_2.add(aggiungi_corso);
																		aggiungi_corso.setLayout(null);
																		aggiungi_corso.setBackground(new Color(67, 136, 204));
																		
																		JButton btnAggiungiNuovoCorso = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																		btnAggiungiNuovoCorso.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent arg0) {
																				CaricaMateriale.reloadTuttiCorsi();
																				CaricaMateriale.nascondiTutto();
																				panel_2.setVisible(true);
																				panel_5.setVisible(true);
																				crea_corso.setVisible(true);
																				panel_13.setVisible(true);
																			}
																		});
																		btnAggiungiNuovoCorso.setText("Crea nuovo corso");
																		btnAggiungiNuovoCorso.setForeground(Color.WHITE);
																		btnAggiungiNuovoCorso.setFont(new Font("Arial", Font.BOLD, 18));
																		btnAggiungiNuovoCorso.setFocusPainted(false);
																		btnAggiungiNuovoCorso.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		btnAggiungiNuovoCorso.setBackground(new Color(46, 93, 140));
																		btnAggiungiNuovoCorso.setBounds(185, 304, 170, 30);
																		aggiungi_corso.add(btnAggiungiNuovoCorso);
																		
																		JLabel lblIlTuoCorso = new JLabel("Il tuo corso non \u00E8 presente nella lista?");
																		lblIlTuoCorso.setForeground(Color.WHITE);
																		lblIlTuoCorso.setFont(new Font("Arial", Font.BOLD, 14));
																		lblIlTuoCorso.setBounds(10, 285, 302, 14);
																		aggiungi_corso.add(lblIlTuoCorso);
																		
																		JSeparator separator_8 = new JSeparator();
																		separator_8.setForeground(Color.BLACK);
																		separator_8.setBackground(Color.BLACK);
																		separator_8.setBounds(10, 280, 345, 1);
																		aggiungi_corso.add(separator_8);
																		
																		JScrollPane scrollPane_1 = new JScrollPane(list_3);
																		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
																		scrollPane_1.setBounds(10, 20, 345, 209);
																		aggiungi_corso.add(scrollPane_1);
																		
																		list_3.setForeground(Color.WHITE);
																		list_3.setFont(new Font("Arial", Font.ITALIC, 14));
																		list_3.setBackground(new Color(67, 136, 204));
																		list_3.addListSelectionListener(new ListSelectionListener() {
																			public void valueChanged(ListSelectionEvent arg0) {
																				if (list_3.getSelectedIndex() != -1) {
																					btnConfermaSelezione.setVisible(true);
																				}
																			}
																		});
																		aggiungiListnerMouseOver(btnAggiungiNuovoCorso);
																		aggiungiListnerMouseOver(list_3);
																		
																		JButton button_2 = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																		button_2.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				CaricaMateriale.reloadCorsoByFac(dbIndexFac);
																				CaricaMateriale.nascondiTutto();
																				panel_2.setVisible(true);
																				panel_5.setVisible(true);
																				scegli_corso.setVisible(true);
																			}
																		});
																		button_2.setText("Indietro");
																		button_2.setForeground(Color.WHITE);
																		button_2.setFont(new Font("Arial", Font.BOLD, 18));
																		button_2.setFocusPainted(false);
																		button_2.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		button_2.setBackground(new Color(46, 93, 140));
																		button_2.setBounds(10, 304, 165, 30);
																		aggiungi_corso.add(button_2);
																		
																		btnConfermaSelezione.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				if (list_3.getSelectedIndex() != -1) {
																					String s = (String) list_3.getSelectedValue();
																					textField_4.setText(s);
																					textField_4.setBorder(UIManager.getBorder("TextField.border"));
																					indexCorso = list_3.getSelectedIndex();
																					dbIndexCorso = listaCorsi[indexCorso].getID();
																					CaricaMateriale.collegaCorso(dbIndexCorso,dbIndexFac);
																					CaricaMateriale.reloadCorsoByFac(dbIndexFac);
																					CaricaMateriale.nascondiTutto();
																					panel_2.setVisible(true);
																					panel_5.setVisible(true);
																					scegli_corso.setVisible(true);
																					int index = -1;
																					index = list_1.getNextMatch(s, 0, javax.swing.text.Position.Bias.Forward );
																					if (index >= 0) {
																						list_1.ensureIndexIsVisible(index);
																					}
																					list_1.setSelectedIndex(index);
																					//reload corso by fac
																				} else {
																					JOptionPane.showMessageDialog(Home.getFrame(), "Devi prima selezionare un corso", "Attenzione", JOptionPane.WARNING_MESSAGE);
																				}
																			}
																		});
																		btnConfermaSelezione.setText("Conferma selezione");
																		btnConfermaSelezione.setForeground(Color.WHITE);
																		btnConfermaSelezione.setFont(new Font("Arial", Font.BOLD, 18));
																		btnConfermaSelezione.setFocusPainted(false);
																		btnConfermaSelezione.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		btnConfermaSelezione.setBackground(new Color(46, 93, 140));
																		btnConfermaSelezione.setBounds(10, 240, 345, 30);
																		aggiungi_corso.add(btnConfermaSelezione);
																		aggiungiListnerMouseOver(btnConfermaSelezione);
																		
																		JPanel panel_6 = new JPanel();
																		panel_6.setBackground(new Color(50,91,132));
																		panel_6.setBounds(0, 0, 365, 20);
																		aggiungi_corso.add(panel_6);
																		panel_6.setLayout(null);
																		
																		JLabel lblCorsiGiEsistenti = new JLabel("Corsi presenti nel sistema");
																		lblCorsiGiEsistenti.setBounds(10, 0, 184, 17);
																		panel_6.add(lblCorsiGiEsistenti);
																		lblCorsiGiEsistenti.setForeground(Color.WHITE);
																		lblCorsiGiEsistenti.setFont(new Font("Arial", Font.BOLD, 14));
																		

																		scegli_fac.setBounds(1, 2, 365, 345);
																		scegli_fac.setBackground(new Color(67, 136, 204));
																		panel_2.add(scegli_fac);
																		scegli_fac.setLayout(null);
																		
																		btnAggiungiFacolt.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				//textField_2.requestFocus();
																				CaricaMateriale.nascondiTutto();
																				panel_2.setVisible(true);
																				panel_4.setVisible(true);
																				crea_fac.setVisible(true);
																				panel_15.setVisible(true);
																				
																			}
																		});
																		
																		btnAggiungiFacolt.setText("Aggiungi corso di studi");
																		btnAggiungiFacolt.setForeground(Color.WHITE);
																		btnAggiungiFacolt.setFont(new Font("Arial", Font.BOLD, 18));
																		btnAggiungiFacolt.setFocusPainted(false);
																		btnAggiungiFacolt.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		btnAggiungiFacolt.setBackground(new Color(0x2E, 0x5D, 0x8C));
																		btnAggiungiFacolt.setBounds(10, 304, 345, 30);
																		scegli_fac.add(btnAggiungiFacolt);
																		
																		JLabel lblNewLabel_8 = new JLabel("Non trovi il tuo corso di studi?");
																		lblNewLabel_8.setForeground(Color.WHITE);
																		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 14));
																		lblNewLabel_8.setBounds(10, 285, 302, 14);
																		scegli_fac.add(lblNewLabel_8);
																		
																		JSeparator separator_2 = new JSeparator();
																		separator_2.setBackground(Color.BLACK);
																		separator_2.setForeground(Color.BLACK);
																		separator_2.setBounds(10, 280, 345, 1);
																		scegli_fac.add(separator_2);
																		
																		list.addListSelectionListener(new ListSelectionListener() {
																			public void valueChanged(ListSelectionEvent arg0) {
																				if (list.getSelectedIndex() != -1) {
																					String s = (String) list.getSelectedValue();
																					textField_2.setText(s);
																					textField_2.setBorder(UIManager.getBorder("TextField.border"));
																					indexFac = list.getSelectedIndex();
																					dbIndexFac = listaFacoltaByUniv[indexFac].getID();
																				}
																			}
																		});
																		
																		
																								
																								list.setForeground(Color.WHITE);
																								list.setBackground(new Color(67, 136, 204));
																								list.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
																								
																								JScrollPane pane_list = new JScrollPane(list);  
																								pane_list.setBounds(10, 31, 345, 243);
																								pane_list.setBorder(new EmptyBorder(0, 0, 0, 0));
																								
																								
																								
																								scegli_fac.add(pane_list);
																								scegli_fac.setFocusable(false);
																								list.setFocusable(false);
																								
																								
																								
																								
																								aggiungiListnerMouseOver(scegli_fac);
																								aggiungiListnerMouseOver(btnAggiungiFacolt);
																								aggiungiListnerMouseOver(list);
																								
																								JLabel lblFacoltGiEsistenti = new JLabel("Corsi di studio presenti nel sistema e collegati all'Universit\u00E0 selezionata");
																								lblFacoltGiEsistenti.setForeground(Color.WHITE);
																								lblFacoltGiEsistenti.setFont(new Font("Arial", Font.BOLD, 14));
																								lblFacoltGiEsistenti.setBounds(10, 11, 345, 15);
																								scegli_fac.add(lblFacoltGiEsistenti);
																		
																		scegli_univ.setLayout(null);
																		scegli_univ.setBackground(new Color(67, 136, 204));
																		scegli_univ.setBounds(1, 2, 365, 345);
																		panel_2.add(scegli_univ);
																		
																		JButton btnAggiungiUniversit = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																		btnAggiungiUniversit.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent arg0) {
																				CaricaMateriale.nascondiTutto();
																				panel_2.setVisible(true);
																				panel_3.setVisible(true);
																				crea_univ.setVisible(true);
																				panel_9.setVisible(true);
																			}
																		});
																		btnAggiungiUniversit.setText("Aggiungi universit\u00E0");
																		btnAggiungiUniversit.setForeground(Color.WHITE);
																		btnAggiungiUniversit.setFont(new Font("Arial", Font.BOLD, 18));
																		btnAggiungiUniversit.setFocusPainted(false);
																		btnAggiungiUniversit.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		btnAggiungiUniversit.setBackground(new Color(46, 93, 140));
																		btnAggiungiUniversit.setBounds(10, 304, 345, 30);
																		scegli_univ.add(btnAggiungiUniversit);
																		
																		JLabel lblNonTroviLa = new JLabel("Non trovi la tua universit\u00E0?");
																		lblNonTroviLa.setForeground(Color.WHITE);
																		lblNonTroviLa.setFont(new Font("Arial", Font.BOLD, 14));
																		lblNonTroviLa.setBounds(10, 285, 302, 14);
																		scegli_univ.add(lblNonTroviLa);
																		
																		JSeparator separator_6 = new JSeparator();
																		separator_6.setForeground(Color.BLACK);
																		separator_6.setBackground(Color.BLACK);
																		separator_6.setBounds(10, 280, 345, 1);
																		scegli_univ.add(separator_6);
																		

																		list_2.setForeground(Color.WHITE);
																		list_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
																		list_2.setBackground(new Color(67, 136, 204));
																		
																		list_2.addListSelectionListener(new ListSelectionListener() {
																			public void valueChanged(ListSelectionEvent arg0) {
																				//System.out.println("sss");
																				if (list_2.getSelectedIndex() != -1) {
																					String s = (String) list_2.getSelectedValue();
																					textField_3.setText(s);
																					textField_3.setBorder(UIManager.getBorder("TextField.border"));
																					indexUniv = list_2.getSelectedIndex();
																					dbIndexUniv = listaUniversita[indexUniv].getID();
																				}
																			}
																		});
																		JScrollPane pane_list_2 = new JScrollPane(list_2);  
																		pane_list_2.setBounds(10, 31, 345, 243);
																		pane_list_2.setBorder(new EmptyBorder(0, 0, 0, 0));
																		
																		scegli_univ.add(pane_list_2);
																		aggiungiListnerMouseOver(scegli_univ);
																		aggiungiListnerMouseOver(list_2);
																		aggiungiListnerMouseOver(btnAggiungiUniversit);
																		
																		JLabel lblUniversitGiEsistenti = new JLabel("Universit\u00E0 presenti nel sistema");
																		lblUniversitGiEsistenti.setForeground(Color.WHITE);
																		lblUniversitGiEsistenti.setFont(new Font("Arial", Font.BOLD, 14));
																		lblUniversitGiEsistenti.setBounds(10, 11, 345, 14);
																		scegli_univ.add(lblUniversitGiEsistenti);
																
																		scegli_corso.setLayout(null);
																		scegli_corso.setBackground(new Color(67, 136, 204));
																		scegli_corso.setBounds(1, 2, 365, 345);
																		panel_2.add(scegli_corso);
																		
																		JButton btnAggiungiCorso = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																		btnAggiungiCorso.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent arg0) {
																				CaricaMateriale.reloadTuttiCorsi();
																				CaricaMateriale.nascondiTutto();
																				panel_2.setVisible(true);
																				panel_5.setVisible(true);
																				aggiungi_corso.setVisible(true);
																				//crea_corso.setVisible(true);
																				//panel_13.setVisible(true);
																			}
																		});
																		btnAggiungiCorso.setText("Aggiungi corso");
																		btnAggiungiCorso.setForeground(Color.WHITE);
																		btnAggiungiCorso.setFont(new Font("Arial", Font.BOLD, 18));
																		btnAggiungiCorso.setFocusPainted(false);
																		btnAggiungiCorso.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																		btnAggiungiCorso.setBackground(new Color(46, 93, 140));
																		btnAggiungiCorso.setBounds(10, 304, 345, 30);
																		scegli_corso.add(btnAggiungiCorso);
																		
																		JLabel lblNonTroviIl = new JLabel("Non trovi il tuo corso?");
																		lblNonTroviIl.setForeground(Color.WHITE);
																		lblNonTroviIl.setFont(new Font("Arial", Font.BOLD, 14));
																		lblNonTroviIl.setBounds(10, 285, 302, 14);
																		scegli_corso.add(lblNonTroviIl);
																		
																		JSeparator separator_5 = new JSeparator();
																		separator_5.setForeground(Color.BLACK);
																		separator_5.setBackground(Color.BLACK);
																		separator_5.setBounds(10, 280, 345, 1);
																		scegli_corso.add(separator_5);
																		
																		list_1.setForeground(Color.WHITE);
																		list_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
																		list_1.setBackground(new Color(67, 136, 204));
																		list_1.addListSelectionListener(new ListSelectionListener() {
																			public void valueChanged(ListSelectionEvent arg0) {
																				if (list_1.getSelectedIndex() != -1) {
																					String s = (String) list_1.getSelectedValue();
																					textField_4.setText(s);
																					textField_4.setBorder(UIManager.getBorder("TextField.border"));
																					indexCorso = list_1.getSelectedIndex();
																					dbIndexCorso = listaCorsi[indexCorso].getID();
																				}
																			}
																		});
																		
																		JScrollPane pane_list_1 = new JScrollPane(list_1);  
																		pane_list_1.setBounds(10, 31, 345, 243);
																		pane_list_1.setBorder(new EmptyBorder(0, 0, 0, 0));
																		
																		
																		scegli_corso.add(pane_list_1);
																		aggiungiListnerMouseOver(scegli_corso);
																		aggiungiListnerMouseOver(btnAggiungiCorso);
																		aggiungiListnerMouseOver(list_1);
																		
																		JLabel lblCorsiGiAppartenenti = new JLabel("Corsi presenti nel corso di studi selezionato");
																		lblCorsiGiAppartenenti.setForeground(Color.WHITE);
																		lblCorsiGiAppartenenti.setFont(new Font("Arial", Font.BOLD, 14));
																		lblCorsiGiAppartenenti.setBounds(10, 11, 345, 15);
																		scegli_corso.add(lblCorsiGiAppartenenti);
														
																crea_corso.setBounds(1, 2, 365, 345);
																panel_2.add(crea_corso);
																crea_corso.setLayout(null);
																crea_corso.setBackground(new Color(67, 136, 204));
																

																JButton btnCreaCorso = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																
																btnCreaCorso.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		CaricaMateriale.salvaCorso(textField_1.getText(),textArea_1.getText(),dbIndexFac);
																		CaricaMateriale.reloadTuttiCorsi();
																		CaricaMateriale.reloadCorsoByFac(dbIndexFac);
																		
																		CaricaMateriale.nascondiTutto();
																		panel_2.setVisible(true);
																		panel_5.setVisible(true);
																		scegli_corso.setVisible(true);
																		//int lastIndex = list_1.getModel().getSize() - 1;
																		int index = -1;
																		index = list_1.getNextMatch(textField_1.getText(), 0, javax.swing.text.Position.Bias.Forward );
																		if (index >= 0) {
																			list_1.ensureIndexIsVisible(index);
																		}
																		list_1.setSelectedIndex(index);
																		
																		//btnConfermaSelezione.requestFocus();
																		/*
																		System.out.println(dbIndexFac);
																		CaricaMateriale.collegaCorso(dbIndexCorso,dbIndexFac);
																		CaricaMateriale.reloadCorsoByFac(dbIndexFac);
																		
																		CaricaMateriale.nascondiTutto();
																		panel_2.setVisible(true);
																		panel_5.setVisible(true);
																		scegli_corso.setVisible(true);
																		//int lastIndex = list_1.getModel().getSize() - 1;
																		int index2 = -1;
																		index2 = list_1.getNextMatch(textField_1.getText(), 0, javax.swing.text.Position.Bias.Forward );
																		if (index2 >= 0) {
																			list_1.ensureIndexIsVisible(index2);
																		}
																		list_1.setSelectedIndex(index2);*/
																	}
																});
																btnCreaCorso.setText("Crea corso");
																btnCreaCorso.setForeground(Color.WHITE);
																btnCreaCorso.setFont(new Font("Arial", Font.BOLD, 18));
																btnCreaCorso.setFocusPainted(false);
																btnCreaCorso.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																btnCreaCorso.setBackground(new Color(46, 93, 140));
																btnCreaCorso.setBounds(185, 304, 170, 30);
																crea_corso.add(btnCreaCorso);
																
																JSeparator separator_3 = new JSeparator();
																separator_3.setForeground(Color.BLACK);
																separator_3.setBackground(Color.BLACK);
																separator_3.setBounds(10, 292, 345, 1);
																crea_corso.add(separator_3);
																
																JButton btnIndietro = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
																btnIndietro.setText("Indietro");
																btnIndietro.setForeground(Color.WHITE);
																btnIndietro.setFont(new Font("Arial", Font.BOLD, 18));
																btnIndietro.setFocusPainted(false);
																btnIndietro.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
																btnIndietro.setBackground(new Color(46, 93, 140));
																btnIndietro.setBounds(10, 304, 165, 30);
																btnIndietro.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		CaricaMateriale.nascondiTutto();
																		panel_2.setVisible(true);
																		panel_5.setVisible(true);
																		aggiungi_corso.setVisible(true);
																	}
																});
																crea_corso.add(btnIndietro);
																
																panel_13.setBounds(10, 10, 345, 271);
																crea_corso.add(panel_13);
																panel_13.setBackground(new Color(67, 136, 204));
																panel_13.setLayout(new FormLayout(new ColumnSpec[] {
																		ColumnSpec.decode("10dlu"),
																		ColumnSpec.decode("max(50dlu;default)"),
																		ColumnSpec.decode("10dlu"),
																		ColumnSpec.decode("max(124dlu;default):grow"),
																		ColumnSpec.decode("10dlu"),},
																	new RowSpec[] {
																		RowSpec.decode("10dlu"),
																		RowSpec.decode("max(35dlu;default)"),
																		RowSpec.decode("10dlu"),
																		RowSpec.decode("max(35dlu;default):grow"),
																		RowSpec.decode("10dlu"),
																		RowSpec.decode("max(35dlu;default)"),
																		RowSpec.decode("10dlu"),}));
																
																JLabel lblNewLabel_9 = new JLabel("Corso");
																lblNewLabel_9.setForeground(Color.WHITE);
																lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 14));
																panel_13.add(lblNewLabel_9, "2, 2, left, center");
																
																textField_1 = new JTextField();
																textField_1.setDocument(new JTextFieldLimit(254));
																textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
																panel_13.add(textField_1, "4, 2, fill, default");
																textField_1.setColumns(10);
																
																JLabel lblNewLabel_10 = new JLabel("Descrizione");
																lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 14));
																lblNewLabel_10.setForeground(Color.WHITE);
																panel_13.add(lblNewLabel_10, "2, 4, left, top");
																textArea_1.setWrapStyleWord(true);
																textArea_1.setLineWrap(true);
																textArea_1.setDocument(new JTextFieldLimit(254));
																textArea_1.setFont(new Font("Arial", Font.PLAIN, 14));
																JScrollPane areaScrollPane = new JScrollPane(textArea_1);
																areaScrollPane.setPreferredSize(new Dimension(185, 53));
																areaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
																panel_13.add(areaScrollPane, "4, 4, default, fill");
																
																JLabel lblNewLabel_11 = new JLabel("Corso di studi");
																lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 14));
																lblNewLabel_11.setForeground(Color.WHITE);
																panel_13.add(lblNewLabel_11, "2, 6, left, center");
																
																textField_5 = new JTextField();
																textField_5.setFont(new Font("Arial", Font.PLAIN, 14));
																panel_13.add(textField_5, "4, 6, fill, default");
																textField_5.setColumns(10);
																textField_5.setDocument(new JTextFieldLimit(254));
																aggiungiListnerMouseOver(textField_1);
																aggiungiListnerMouseOver(textField_5);
																aggiungiListnerMouseOver(textArea_1);
																aggiungiListnerMouseOver(crea_corso);
																aggiungiListnerMouseOver(btnCreaCorso);
																aggiungiListnerMouseOver(btnIndietro);
																aggiungiListnerMouseOver(panel_13);
																
																textField_1.addFocusListener(new FocusAdapter() {
																	@Override
																	public void focusLost(FocusEvent arg0) {
																		textField_4.dispatchEvent(arg0);
																	}
																});
																textField_5.addFocusListener(new FocusAdapter() {
																	@Override
																	public void focusLost(FocusEvent arg0) {
																		textField_4.dispatchEvent(arg0);
																	}
																});
																textArea_1.addFocusListener(new FocusAdapter() {
																	@Override
																	public void focusLost(FocusEvent arg0) {
																		textField_4.dispatchEvent(arg0);
																	}
																});
																textField_1.setFocusable(true);
																textField_5.setFocusable(true);
																textArea_1.setFocusable(true);
																lblNewLabel_11.setVisible(false);
																textField_5.setVisible(false);
						
								crea_univ.setBounds(1, 2, 365, 345);
								panel_2.add(crea_univ);
								crea_univ.setBackground(new Color(67, 136, 204));
								crea_univ.setLayout(null);
								
								JButton btnCreaUniversit = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
								btnCreaUniversit.setText("Crea universit\u00E0");
								btnCreaUniversit.setForeground(Color.WHITE);
								btnCreaUniversit.setFont(new Font("Arial", Font.BOLD, 18));
								btnCreaUniversit.setFocusPainted(false);
								btnCreaUniversit.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
								btnCreaUniversit.setBackground(new Color(46, 93, 140));
								btnCreaUniversit.setBounds(185, 304, 170, 30);
								btnCreaUniversit.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										boolean tempUniv = CaricaMateriale.salvaUniv(textPane.getText());
										CaricaMateriale.reloadUniv();
										CaricaMateriale.nascondiTutto();
										panel_2.setVisible(true);
										panel_3.setVisible(true);
										scegli_univ.setVisible(true);
										if (tempUniv) {
											int lastIndex = list_2.getModel().getSize() - 1;
											if (lastIndex >= 0) {
												list_2.ensureIndexIsVisible(lastIndex);
											}
											list_2.setSelectedIndex(lastIndex);
										} else {
											int index = -1;
											index = list_2.getNextMatch(textPane.getText(), 0, javax.swing.text.Position.Bias.Forward );
											if (index >= 0) {
												list_2.ensureIndexIsVisible(index);
											}
											list_2.setSelectedIndex(index);
										}
										
									}
								});
								crea_univ.add(btnCreaUniversit);
								
								JButton button_3 = buttonCreator.createButton("Carica documento", 0, 0, 0, 0, false, true);// = new JButton("Carica materiale");
								button_3.setText("Indietro");
								button_3.setForeground(Color.WHITE);
								button_3.setFont(new Font("Arial", Font.BOLD, 18));
								button_3.setFocusPainted(false);
								button_3.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
								button_3.setBackground(new Color(46, 93, 140));
								button_3.setBounds(10, 304, 165, 30);
								button_3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										CaricaMateriale.reloadUniv();
										CaricaMateriale.nascondiTutto();
										panel_2.setVisible(true);
										panel_3.setVisible(true);
										scegli_univ.setVisible(true);
									}
								});
								crea_univ.add(button_3);
								
								JSeparator separator_7 = new JSeparator();
								separator_7.setForeground(Color.BLACK);
								separator_7.setBackground(Color.BLACK);
								separator_7.setBounds(10, 292, 345, 1);
								crea_univ.add(separator_7);
								
								panel_9.setBounds(10, 10, 345, 271);
								panel_9.setBackground(new Color(67, 136, 204));
								crea_univ.add(panel_9);
								panel_9.setLayout(new FormLayout(new ColumnSpec[] {
										ColumnSpec.decode("10dlu"),
										ColumnSpec.decode("50dlu"),
										ColumnSpec.decode("10dlu"),
										ColumnSpec.decode("123dlu:grow"),
										ColumnSpec.decode("10dlu"),},
									new RowSpec[] {
										RowSpec.decode("10dlu"),
										RowSpec.decode("35dlu"),
										RowSpec.decode("10dlu"),}));
								
								JLabel lblNewLabel_13 = new JLabel("Universit\u00E0");
								lblNewLabel_13.setForeground(Color.WHITE);
								lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 14));
								panel_9.add(lblNewLabel_13, "2, 2");
								
								textPane.setFont(new Font("Arial", Font.PLAIN, 14));
								textPane.setDocument(new JTextFieldLimit(254));
								panel_9.add(textPane, "4, 2, fill, default");
								aggiungiListnerMouseOver(textPane);
								aggiungiListnerMouseOver(crea_univ);
								aggiungiListnerMouseOver(btnCreaUniversit);
								aggiungiListnerMouseOver(button_3);
								aggiungiListnerMouseOver(panel_9);
								
								
								textPane.addFocusListener(new FocusAdapter() {
									@Override
									public void focusLost(FocusEvent arg0) {
										textField_3.dispatchEvent(arg0);
									}
								});
								textPane.setFocusable(true);
						
						crea_fac.setLayout(null);
						crea_fac.setBackground(new Color(67, 136, 204));
						crea_fac.setBounds(1, 2, 365, 345);
						
										panel_2.add(crea_fac);
										
										button.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												
												boolean tempFac = CaricaMateriale.salvaFac(textField_6.getText(),dbIndexUniv);
												if (dbIndexUniv != -1) {
													CaricaMateriale.reloadFac(dbIndexUniv);
												}
												CaricaMateriale.nascondiTutto();
												panel_2.setVisible(true);
												panel_4.setVisible(true);
												scegli_fac.setVisible(true);
												if (tempFac) {
													int lastIndex = list.getModel().getSize() - 1;
													if (lastIndex >= 0) {
														list.ensureIndexIsVisible(lastIndex);
													}
													list.setSelectedIndex(lastIndex);
												} else {
													int index = -1;
													index = list.getNextMatch(textField_6.getText(), 0, javax.swing.text.Position.Bias.Forward );
													if (index >= 0) {
														list.ensureIndexIsVisible(index);
													}
													list.setSelectedIndex(index);
												}
											}
										});
										button.setText("Crea corso di studi");
										button.setForeground(Color.WHITE);
										button.setFont(new Font("Arial", Font.BOLD, 18));
										button.setFocusPainted(false);
										button.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
										button.setBackground(new Color(46, 93, 140));
										button.setBounds(185, 304, 170, 30);
										crea_fac.add(button);
										
										JSeparator separator_4 = new JSeparator();
										separator_4.setForeground(Color.BLACK);
										separator_4.setBackground(Color.BLACK);
										separator_4.setBounds(10, 292, 345, 1);
										crea_fac.add(separator_4);
										
										button_1.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												if (dbIndexUniv != -1) {
													CaricaMateriale.reloadFac(dbIndexUniv);
												}
												CaricaMateriale.nascondiTutto();
												panel_2.setVisible(true);
												panel_4.setVisible(true);
												scegli_fac.setVisible(true);
											}
										});
										button_1.setText("Indietro");
										button_1.setForeground(Color.WHITE);
										button_1.setFont(new Font("Arial", Font.BOLD, 18));
										button_1.setFocusPainted(false);
										button_1.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
										button_1.setBackground(new Color(46, 93, 140));
										button_1.setBounds(10, 304, 165, 30);
										crea_fac.add(button_1);
										
										panel_15.setBackground(new Color(67, 136, 204));
										panel_15.setBounds(10, 10, 345, 271);
										crea_fac.add(panel_15);
										panel_15.setLayout(new FormLayout(new ColumnSpec[] {
												ColumnSpec.decode("10dlu"),
												ColumnSpec.decode("max(50dlu;default)"),
												ColumnSpec.decode("10dlu"),
												ColumnSpec.decode("max(123dlu;default):grow"),
												ColumnSpec.decode("10dlu"),},
											new RowSpec[] {
												RowSpec.decode("10dlu"),
												RowSpec.decode("35dlu"),
												RowSpec.decode("10dlu"),}));
										
										JLabel lblNewLabel_12 = new JLabel("Corso di studi");
										lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 14));
										lblNewLabel_12.setForeground(Color.WHITE);
										panel_15.add(lblNewLabel_12, "2, 2");
										
										textField_6 = new JTextField();
										textField_6.setDocument(new JTextFieldLimit(254));
										textField_6.addFocusListener(new FocusAdapter() {
											@Override
											public void focusLost(FocusEvent arg0) {
												textField_2.dispatchEvent(arg0);
											}
										});
										textField_6.setFont(new Font("Arial", Font.PLAIN, 14));
										panel_15.add(textField_6, "4, 2, fill, default");
										textField_6.setColumns(10);
										aggiungiListnerMouseOver(crea_fac);
										aggiungiListnerMouseOver(button);
										aggiungiListnerMouseOver(button_1);
										aggiungiListnerMouseOver(panel_15);
										aggiungiListnerMouseOver(textField_6);
										textField_6.setFocusable(true);
		

		
		JButton btnPrenotaDigitalizzazione = buttonCreator.createButton("<html><center>Prenota<br>digitalizzazione</center></html>", 776, 164, 203, 86, false, true);
		//.createButton("<html><center>Prenota<br>digitalizzazione</center></html>", 776, 164, 203, 86, "", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
		btnPrenotaDigitalizzazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.loadPages(Home.getPaginaCorrispondente("prenotazione_digitalizzazione"), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);	
			}
		});
		//btnPrenotaDigitalizzazione.setText("Prenota digitalizzazione");
		//btnPrenotaDigitalizzazione.setForeground(Color.WHITE);
		//btnPrenotaDigitalizzazione.setFont(new Font("Arial", Font.BOLD, 18));
		//btnPrenotaDigitalizzazione.setFocusPainted(false);
		//btnPrenotaDigitalizzazione.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		//btnPrenotaDigitalizzazione.setBackground(new Color(0x2E, 0x5D, 0x8C));
		//btnPrenotaDigitalizzazione.setBounds(776, 164, 203, 86);
		panel.add(btnPrenotaDigitalizzazione);
		//panel_2.setFocusable(true);
		aggiungiListnerMouseOver(panel_2);
		
		JLabel lblNewLabel_14 = new JLabel("Tutti i campi contrassegnati da asterisco (*) sono obbligatori.");
		lblNewLabel_14.setForeground(new Color(128, 0, 0));
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 405, 395, 20);
		panel.add(lblNewLabel_14);
		
		/*aggiungiListnerMouseOver
		aggiungiListnerMouseOver(
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver*/
		
		//aggiungiListnerMouseOver(list);
		//aggiungiListnerMouseOver(crea_fac);
		CaricaMateriale.nascondiTutto();
		
		
		
	
	}
	
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
			JOptionPane.showMessageDialog(Home.getFrame(), "" +
					"Corso di studi già esistente", "Attenzione", JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(Home.getFrame(), "Questo corso è già collegato al tuo corso di studi", "Attenzione", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		ControllerCorso.getInstance().collegaCorsoFacolta(index_corso, index_fac);
		return true;
	}

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
		list_3.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
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
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		panel_9.setVisible(false);
		panel_13.setVisible(false);
		panel_15.setVisible(false);
		crea_univ.setVisible(false);
		crea_fac.setVisible(false);
		crea_corso.setVisible(false);
		aggiungi_corso.setVisible(false);
		scegli_univ.setVisible(false);
		scegli_fac.setVisible(false);
		scegli_corso.setVisible(false);
	}

	@Override
	public void reload() {
		panel.setBounds(0, 0, 1008, 429);
		
		btnScegliFile.setText("Scegli file...");
		btnScegliFile.setForeground(new Color(0, 0, 0));
		btnScegliFile.setBackground(new Color(240,240,240));
		textField.setText("");
		textField.setBorder(UIManager.getBorder("TextField.border"));
		textField_2.setText("");
		textField_2.setBorder(UIManager.getBorder("TextField.border"));
		textField_3.setText("");
		textField_3.setBorder(UIManager.getBorder("TextField.border"));
		textField_4.setText("");
		textField_4.setBorder(UIManager.getBorder("TextField.border"));
		btnConfermaSelezione.setVisible(false);
		textPane.setText("");
		textArea.setBorder(UIManager.getBorder("TextArea.border"));
		textField_1.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textArea_1.setText("");
		textArea.setText("");
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