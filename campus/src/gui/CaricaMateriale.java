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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modello_di_dominio.Facolta;
import modello_di_dominio.Universita;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import controller.ControllerUniversita;
import controller.ControllerUtente;

import controller.ControllerFacolta;

public class CaricaMateriale extends JPanel  {
	private final static JPanel panel = new JPanel();
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
	private static JPanel panel_13 = new JPanel();
	private static JPanel crea_fac = new JPanel();
	private static JPanel panel_15 = new JPanel();
	private static JPanel crea_univ = new JPanel();
	final static JList list = new JList();
	final static JList list_2 = new JList();
	final JTextPane textPane = new JTextPane();
	
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	final JButton btnAggiungiFacolt = new JButton();
	final JButton button = new JButton();
	final JButton button_1 = new JButton();
	static boolean isOverSelectionPanel =  false;
	private int indexUniv = -1;
	private int dbIndexUniv = -1;
	private int indexFac = -1;
	private int dbIndexFac = -1;
	static Universita[] listaUniversita = ControllerUniversita.getInstance().getAllUniversita();
	static Facolta[] listaFacoltaByUniv = ControllerFacolta.getInstance().getAllFacoltaByUniv(-1); 
	
	
	
	/**
	 * Create the panel.
	 */
	public CaricaMateriale() {
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
		
		JLabel lblUltimiCorsiSeguiti = new JLabel("Carica materiale");
		lblUltimiCorsiSeguiti.setForeground(new Color(6, 121, 159));
		lblUltimiCorsiSeguiti.setFont(new Font("Arial", Font.BOLD, 20));
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
				ColumnSpec.decode("right:max(55dlu;default)"),
				ColumnSpec.decode("max(159dlu;default):grow"),},
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
		
		JLabel lblNewLabel = new JLabel("File");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel, "3, 2, left, default");
		
		final JButton btnScegliFile = new JButton("Scegli file...");
		btnScegliFile.setFont(new Font("Arial", Font.PLAIN, 14));
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
		            Path target = Paths.get("files/"+newname);
		            try {
						Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Si è verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
					}
		        } else {
		        	JOptionPane.showMessageDialog(null, "Non riesco ad aprire questo file", "Errore", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnScegliFile.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnScegliFile, "4, 2, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Titolo");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "3, 3, left, default");
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(textField, "4, 3, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrizione");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "3, 5, left, top");
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		//textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		panel_1.add(scrollPane, "4, 5, fill, fill");
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "3, 7, left, center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Appunti", "Dispense", "Esercizi", "Slide"}));
		panel_1.add(comboBox, "4, 7, fill, center");
		
		JLabel lblNewLabel_4 = new JLabel("Facolt\u00E0");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "3, 9, left, default");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (!isOverSelectionPanel) {
					if (dbIndexUniv != -1) {
						CaricaMateriale.reloadFac(dbIndexUniv);
					}
					CaricaMateriale.nascondiTutto();
					panel_2.setVisible(true);
					panel_4.setVisible(true);
					scegli_fac.setVisible(true);
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
		
		JLabel lblNewLabel_5 = new JLabel("Universit\u00E0");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_5, "3, 8, left, default");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (!isOverSelectionPanel) {
					reloadUniv();
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
				//System.out.println("fuoco perso - valore booleano "+isOverSelectionPanel);
			}
		});
		panel_1.add(textField_3, "4, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Corso");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6, "3, 10, left, default");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				CaricaMateriale.nascondiTutto();
				panel_2.setVisible(true);
				panel_5.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				CaricaMateriale.nascondiTutto();
			}
		});
		panel_1.add(textField_4, "4, 10, fill, default");
		textField_4.setColumns(10);
		
		
		
		JButton btnCaricaMateriale = new JButton("Carica materiale");
		btnCaricaMateriale.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCaricaMateriale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ControllerDocumento.getInstance().creaDocumento(nome, descrizione, path, u, c);		
			}
		});
		panel_1.add(btnCaricaMateriale, "4, 11, fill, default");
		
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(765, 48, 1, 198);
		panel.add(separator_1);
		
		/*JLabel lblNonHaiUno = new JLabel("Non hai uno scanner? Non hai tempo per digitalizzare il tuo materiale?");
		lblNonHaiUno.setVerticalAlignment(SwingConstants.TOP);
		lblNonHaiUno.setForeground(new Color(6, 121, 159));
		lblNonHaiUno.setFont(new Font("Arial", Font.BOLD, 20));
		lblNonHaiUno.setBounds(388, 60, 401, 206);
		panel.add(lblNonHaiUno);*/
		
		JTextPane txtpnNonHaiUno = new JTextPane();
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
		
		
		
		panel_2.setBackground(new Color(67, 136, 204));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(388, 55, 367, 347);
		panel.add(panel_2);
		panel_2.setLayout(null);
								
								scegli_univ.setLayout(null);
								scegli_univ.setBackground(new Color(67, 136, 204));
								scegli_univ.setBounds(1, 1, 365, 345);
								panel_2.add(scegli_univ);
								
								JButton btnAggiungiUniversit = new JButton();
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
											indexUniv = list_2.getSelectedIndex();
											dbIndexUniv = listaUniversita[indexUniv].getID();
										}
									}
								});
								JScrollPane pane_list_2 = new JScrollPane(list_2);  
								pane_list_2.setBounds(10, 10, 345, 264);
								pane_list_2.setBorder(new EmptyBorder(0, 0, 0, 0));
								
								scegli_univ.add(pane_list_2);
								aggiungiListnerMouseOver(scegli_univ);
								aggiungiListnerMouseOver(list_2);
								aggiungiListnerMouseOver(btnAggiungiUniversit);
						
								crea_univ.setBounds(1, 1, 365, 345);
								panel_2.add(crea_univ);
								crea_univ.setBackground(new Color(67, 136, 204));
								crea_univ.setLayout(null);
								
								JButton btnCreaUniversit = new JButton();
								btnCreaUniversit.setText("Crea universit\u00E0");
								btnCreaUniversit.setForeground(Color.WHITE);
								btnCreaUniversit.setFont(new Font("Arial", Font.BOLD, 18));
								btnCreaUniversit.setFocusPainted(false);
								btnCreaUniversit.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
								btnCreaUniversit.setBackground(new Color(46, 93, 140));
								btnCreaUniversit.setBounds(185, 304, 170, 30);
								btnCreaUniversit.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										CaricaMateriale.salvaUniv(textPane.getText());
										CaricaMateriale.reloadUniv();
										CaricaMateriale.nascondiTutto();
										panel_2.setVisible(true);
										panel_3.setVisible(true);
										scegli_univ.setVisible(true);
										int lastIndex = list_2.getModel().getSize() - 1;
										if (lastIndex >= 0) {
											list_2.ensureIndexIsVisible(lastIndex);
										}
										list_2.setSelectedIndex(lastIndex);
										
									}
								});
								crea_univ.add(btnCreaUniversit);
								
								JButton button_3 = new JButton();
								button_3.setText("Indietro");
								button_3.setForeground(Color.WHITE);
								button_3.setFont(new Font("Arial", Font.BOLD, 18));
								button_3.setFocusPainted(false);
								button_3.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
								button_3.setBackground(new Color(46, 93, 140));
								button_3.setBounds(10, 304, 165, 30);
								button_3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
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
						

						scegli_fac.setBounds(1, 1, 365, 345);
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
						
						btnAggiungiFacolt.setText("Aggiungi facolt\u00E0");
						btnAggiungiFacolt.setForeground(Color.WHITE);
						btnAggiungiFacolt.setFont(new Font("Arial", Font.BOLD, 18));
						btnAggiungiFacolt.setFocusPainted(false);
						btnAggiungiFacolt.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
						btnAggiungiFacolt.setBackground(new Color(0x2E, 0x5D, 0x8C));
						btnAggiungiFacolt.setBounds(10, 304, 345, 30);
						scegli_fac.add(btnAggiungiFacolt);
						
						JLabel lblNewLabel_8 = new JLabel("Non trovi la tua facolt\u00E0?");
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
									indexFac = list.getSelectedIndex();
									dbIndexFac = listaFacoltaByUniv[indexFac].getID();
								}
							}
						});
						
						
												
												list.setForeground(Color.WHITE);
												list.setBackground(new Color(67, 136, 204));
												list.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
												
												JScrollPane pane_list = new JScrollPane(list);  
												pane_list.setBounds(10, 10, 345, 264);
												pane_list.setBorder(new EmptyBorder(0, 0, 0, 0));
												
												
												
												scegli_fac.add(pane_list);
												scegli_fac.setFocusable(false);
												list.setFocusable(false);
												
												
												
												
												aggiungiListnerMouseOver(scegli_fac);
												aggiungiListnerMouseOver(btnAggiungiFacolt);
												aggiungiListnerMouseOver(list);
						
						crea_fac.setLayout(null);
						crea_fac.setBackground(new Color(67, 136, 204));
						crea_fac.setBounds(1, 1, 365, 345);
						
										panel_2.add(crea_fac);
										
										button.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												
												CaricaMateriale.salvaFac(textField_6.getText(),dbIndexUniv);
												if (dbIndexUniv != -1) {
													CaricaMateriale.reloadFac(dbIndexUniv);
												}
												CaricaMateriale.nascondiTutto();
												panel_2.setVisible(true);
												panel_4.setVisible(true);
												scegli_fac.setVisible(true);
												int lastIndex = list.getModel().getSize() - 1;
												if (lastIndex >= 0) {
													list.ensureIndexIsVisible(lastIndex);
												}
												list.setSelectedIndex(lastIndex);
											}
										});
										button.setText("Crea facolt\u00E0");
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
										
										JLabel lblNewLabel_12 = new JLabel("Facolt\u00E0");
										lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 14));
										lblNewLabel_12.setForeground(Color.WHITE);
										panel_15.add(lblNewLabel_12, "2, 2");
										
										textField_6 = new JTextField();
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

		crea_corso.setBounds(1, 1, 365, 345);
		panel_2.add(crea_corso);
		crea_corso.setLayout(null);
		crea_corso.setBackground(new Color(67, 136, 204));
		
		JButton btnCreaCorso = new JButton();
		btnCreaCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaMateriale.salvaCorso();
				CaricaMateriale.reloadCorso();
				CaricaMateriale.nascondiTutto();
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
		
		JButton btnIndietro = new JButton();
		btnIndietro.setText("Indietro");
		btnIndietro.setForeground(Color.WHITE);
		btnIndietro.setFont(new Font("Arial", Font.BOLD, 18));
		btnIndietro.setFocusPainted(false);
		btnIndietro.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnIndietro.setBackground(new Color(46, 93, 140));
		btnIndietro.setBounds(10, 304, 165, 30);
		crea_corso.add(btnIndietro);
		
		panel_13.setBounds(10, 10, 345, 271);
		crea_corso.add(panel_13);
		panel_13.setBackground(new Color(67, 136, 204));
		panel_13.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("max(50dlu;default)"),
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("max(123dlu;default):grow"),
				ColumnSpec.decode("10dlu"),},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				RowSpec.decode("max(35dlu;default)"),
				RowSpec.decode("10dlu"),
				RowSpec.decode("max(34dlu;default):grow"),
				RowSpec.decode("10dlu"),
				RowSpec.decode("max(35dlu;default)"),
				RowSpec.decode("10dlu"),}));
		
		JLabel lblNewLabel_9 = new JLabel("Corso");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 14));
		panel_13.add(lblNewLabel_9, "2, 2, left, center");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_13.add(textField_1, "4, 2, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Descrizione");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_10.setForeground(Color.WHITE);
		panel_13.add(lblNewLabel_10, "2, 4, left, top");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_13.add(textArea_1, "4, 4, fill, fill");
		
		JLabel lblNewLabel_11 = new JLabel("Facolt\u00E0");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_11.setForeground(Color.WHITE);
		panel_13.add(lblNewLabel_11, "2, 6, left, center");
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_13.add(textField_5, "4, 6, fill, default");
		textField_5.setColumns(10);

		scegli_corso.setLayout(null);
		scegli_corso.setBackground(new Color(67, 136, 204));
		scegli_corso.setBounds(1, 1, 365, 345);
		panel_2.add(scegli_corso);
		
		JButton btnAggiungiCorso = new JButton();
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
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"corso1", "corso2", "corso3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setForeground(Color.WHITE);
		list_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		list_1.setBackground(new Color(67, 136, 204));
		
		JScrollPane pane_list_1 = new JScrollPane(list_1);  
		pane_list_1.setBounds(10, 10, 345, 264);
		pane_list_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		
		scegli_corso.add(pane_list_1);
		

		
		JButton btnPrenotaDigitalizzazione = new JButton();
		btnPrenotaDigitalizzazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrenotaDigitalizzazione.setText("Prenota digitalizzazione");
		btnPrenotaDigitalizzazione.setForeground(Color.WHITE);
		btnPrenotaDigitalizzazione.setFont(new Font("Arial", Font.BOLD, 18));
		btnPrenotaDigitalizzazione.setFocusPainted(false);
		btnPrenotaDigitalizzazione.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnPrenotaDigitalizzazione.setBackground(new Color(0x2E, 0x5D, 0x8C));
		btnPrenotaDigitalizzazione.setBounds(776, 164, 203, 86);
		panel.add(btnPrenotaDigitalizzazione);
		//panel_2.setFocusable(true);
		aggiungiListnerMouseOver(panel_2);
		aggiungiListnerMouseOver(textField_1);
		aggiungiListnerMouseOver(textField_5);
		aggiungiListnerMouseOver(textArea_1);
		aggiungiListnerMouseOver(crea_corso);
		aggiungiListnerMouseOver(btnCreaCorso);
		aggiungiListnerMouseOver(btnIndietro);
		aggiungiListnerMouseOver(panel_13);
		aggiungiListnerMouseOver(scegli_corso);
		aggiungiListnerMouseOver(btnAggiungiCorso);
		aggiungiListnerMouseOver(list_1);
		/*aggiungiListnerMouseOver
		aggiungiListnerMouseOver(
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver
		aggiungiListnerMouseOver*/
		
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
		
		//aggiungiListnerMouseOver(list);
		//aggiungiListnerMouseOver(crea_fac);
		CaricaMateriale.nascondiTutto();
		
		
		
	}
	
	protected static boolean salvaUniv(String univ) {
		if(ControllerUniversita.getInstance().isUniversitaAlreadyPresent(univ)) {
			JOptionPane.showMessageDialog(null, "Università già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		ControllerUniversita.getInstance().createUniversita(univ);
		return true;
	}

	protected static boolean salvaFac(String facolta, int indexUniv) {
		if(ControllerFacolta.getInstance().isFacoltaByUnivAlreadyPresent(facolta,indexUniv)) {
			JOptionPane.showMessageDialog(null, "Facoltà già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		ControllerFacolta.getInstance().createFacolta(facolta,indexUniv);
		return true;
	}
	
	protected static void salvaCorso() {
		// TODO Auto-generated method stub
		
	}

	protected static void reloadFac(int indiceUniv) {
		listaFacoltaByUniv = ControllerFacolta.getInstance().getAllFacoltaByUniv(indiceUniv);
		final String[] values = new String[listaFacoltaByUniv.length];
		for (int i = 0; listaFacoltaByUniv.length > i; i++) {
			values[i] = listaFacoltaByUniv[i].getNome();
		}
		list.setModel(new AbstractListModel() {
			//String[] values = new String[] {"facolta1", "facolta2", "facolta3"};
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
		//System.out.println(listaUniversità.length);
		for (int i = 0; listaUniversita.length > i; i++) {
			values[i] = listaUniversita[i].getNome();
		}
		list_2.setModel(new AbstractListModel() {
			//String[] values = new String[] {"facolta1", "facolta2", "facolta3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
	
	protected static void reloadCorso() {
		
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
		scegli_univ.setVisible(false);
		scegli_fac.setVisible(false);
		scegli_corso.setVisible(false);
	}
}