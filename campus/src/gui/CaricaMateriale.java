package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.nio.file.StandardCopyOption.*;
import controller.Controller;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import util.DocumentFilter;
import util.RandomString;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.orm.PersistentException;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Documento;
import modello_di_dominio.dao.UtenteDAO;
import controller.ControllerDocumento;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.EtchedBorder;

public class CaricaMateriale extends JPanel  {
	private final static JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JSeparator separator_1 = new JSeparator();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	 
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
		
		JPanel panel_1 = new JPanel();
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
		panel_1.add(lblNewLabel_4, "3, 8, left, default");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setBackground(UIManager.getColor("TextField.backgroud"));
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				panel_2.setVisible(true);
				panel_3.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				panel_2.setVisible(false);
				panel_3.setVisible(false);
			}
		});
		panel_1.add(textField_2, "4, 8, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Universit\u00E0");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_5, "3, 9, left, default");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setBackground(UIManager.getColor("TextField.backgroud"));
		panel_1.add(textField_3, "4, 9, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Corso");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6, "3, 10, left, default");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setBackground(UIManager.getColor("TextField.backgroud"));
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
		
		panel_6.setBounds(1, 1, 365, 345);
		panel_6.setBackground(new Color(67, 136, 204));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnAggiungiFacolt = new JButton();
		btnAggiungiFacolt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAggiungiFacolt.setText("Aggiungi facolt\u00E0");
		btnAggiungiFacolt.setForeground(Color.WHITE);
		btnAggiungiFacolt.setFont(new Font("Arial", Font.BOLD, 18));
		btnAggiungiFacolt.setFocusPainted(false);
		btnAggiungiFacolt.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnAggiungiFacolt.setBackground(new Color(0x2E, 0x5D, 0x8C));
		btnAggiungiFacolt.setBounds(10, 304, 345, 30);
		panel_6.add(btnAggiungiFacolt);
		
		JLabel lblNewLabel_8 = new JLabel("Non trovi la tua facolt\u00E0?");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 285, 302, 14);
		panel_6.add(lblNewLabel_8);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 280, 345, 1);
		panel_6.add(separator_2);
		
		final JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String s = (String) list.getSelectedValue();
				textField_2.setText(s);
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"PROVA", "PROVAa"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(67, 136, 204));
		list.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		list.setBounds(10, 10, 345, 264);
		panel_6.add(list);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 0, 365, 345);
		panel_2.add(panel_12);
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(67, 136, 204));
		
		JButton btnCreaFacolt = new JButton();
		btnCreaFacolt.setText("Crea corso");
		btnCreaFacolt.setForeground(Color.WHITE);
		btnCreaFacolt.setFont(new Font("Arial", Font.BOLD, 18));
		btnCreaFacolt.setFocusPainted(false);
		btnCreaFacolt.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnCreaFacolt.setBackground(new Color(46, 93, 140));
		btnCreaFacolt.setBounds(189, 304, 166, 30);
		panel_12.add(btnCreaFacolt);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(10, 292, 345, 1);
		panel_12.add(separator_3);
		
		JButton btnIndietro = new JButton();
		btnIndietro.setText("Indietro");
		btnIndietro.setForeground(Color.WHITE);
		btnIndietro.setFont(new Font("Arial", Font.BOLD, 18));
		btnIndietro.setFocusPainted(false);
		btnIndietro.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnIndietro.setBackground(new Color(46, 93, 140));
		btnIndietro.setBounds(10, 304, 169, 30);
		panel_12.add(btnIndietro);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(10, 10, 345, 271);
		panel_12.add(panel_13);
		panel_13.setBackground(new Color(67, 136, 204));
		panel_13.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("max(63dlu;default)"),
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
		panel_13.add(textField_1, "4, 2, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Descrizione");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_10.setForeground(Color.WHITE);
		panel_13.add(lblNewLabel_10, "2, 4, left, top");
		
		JTextArea textArea_1 = new JTextArea();
		panel_13.add(textArea_1, "4, 4, fill, fill");
		
		JLabel lblNewLabel_11 = new JLabel("Facolt\u00E0");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_11.setForeground(Color.WHITE);
		panel_13.add(lblNewLabel_11, "2, 6, left, center");
		
		textField_5 = new JTextField();
		panel_13.add(textField_5, "4, 6, fill, default");
		textField_5.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(67, 136, 204));
		panel_14.setBounds(0, 0, 365, 345);
		panel_2.add(panel_14);
		
		JButton button = new JButton();
		button.setText("Crea facolt\u00E0");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setFocusPainted(false);
		button.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		button.setBackground(new Color(46, 93, 140));
		button.setBounds(189, 304, 166, 30);
		panel_14.add(button);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(10, 292, 345, 1);
		panel_14.add(separator_4);
		
		JButton button_1 = new JButton();
		button_1.setText("Indietro");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 18));
		button_1.setFocusPainted(false);
		button_1.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		button_1.setBackground(new Color(46, 93, 140));
		button_1.setBounds(10, 304, 169, 30);
		panel_14.add(button_1);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(67, 136, 204));
		panel_15.setBounds(10, 10, 345, 271);
		panel_14.add(panel_15);
		panel_15.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("max(63dlu;default)"),
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
		textField_6.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_15.add(textField_6, "4, 2, fill, default");
		textField_6.setColumns(10);
		
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		
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
	}
}