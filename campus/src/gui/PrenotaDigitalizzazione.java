package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modello_di_dominio.Corso;
import controller.ControllerCorso;
import javax.swing.ScrollPaneConstants;

public class PrenotaDigitalizzazione extends Pagina {
	private JPanel panel;
	
	public PrenotaDigitalizzazione() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 800);
		add(panel);
		
		JLabel label = new JLabel("Prenotazione Libri");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 200, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel btnRichiesta = new JPanel();
		btnRichiesta.setBounds(157, 519, 130, 36);
		panel.add(btnRichiesta);
		btnRichiesta.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		btnRichiesta.setBackground(new Color(46, 93, 140));
		
		JLabel label_6 = new JLabel("Invia Richiesta");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRichiesta.add(label_6);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(20, 55, 425, 315);
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] {189, 189};
		gbl_formPanel.rowHeights = new int[] {30, 140, 30, 30, 30, 30};
		gbl_formPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lblNomedoc = new JLabel("Nome documento");
		lblNomedoc.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNomedoc = new GridBagConstraints();
		gbc_lblNomedoc.anchor = GridBagConstraints.WEST;
		gbc_lblNomedoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomedoc.gridx = 0;
		gbc_lblNomedoc.gridy = 0;
		formPanel.add(lblNomedoc, gbc_lblNomedoc);
		
		JLabel lblDesc = new JLabel("Descrizione");
		lblDesc.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.anchor = GridBagConstraints.WEST;
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 1;
		formPanel.add(lblDesc, gbc_lblDesc);
		
		JLabel lblnumPag = new JLabel("Numero di pagine");
		lblnumPag.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblnumPag = new GridBagConstraints();
		gbc_lblnumPag.anchor = GridBagConstraints.WEST;
		gbc_lblnumPag.insets = new Insets(0, 0, 5, 5);
		gbc_lblnumPag.gridx = 0;
		gbc_lblnumPag.gridy = 2;
		formPanel.add(lblnumPag, gbc_lblnumPag);
		
		JTextField txtNomeDoc = new JTextField();
		GridBagConstraints gbc_txtNomeDoc = new GridBagConstraints();
		gbc_txtNomeDoc.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeDoc.gridx = 1;
		gbc_txtNomeDoc.gridy = 0;
		formPanel.add(txtNomeDoc, gbc_txtNomeDoc);
		txtNomeDoc.setColumns(10);
		
		JLabel lblCorso = new JLabel("Materia");
		lblCorso.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorso = new GridBagConstraints();
		gbc_lblCorso.anchor = GridBagConstraints.WEST;
		gbc_lblCorso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorso.gridx = 0;
		gbc_lblCorso.gridy = 3;
		formPanel.add(lblCorso, gbc_lblCorso);
		
		JLabel lblCitta = new JLabel("Citt\u00E0");
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.anchor = GridBagConstraints.WEST;
		gbc_lblCitta.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitta.gridx = 0;
		gbc_lblCitta.gridy = 4;
		formPanel.add(lblCitta, gbc_lblCitta);
		
		JLabel lblCopisteria = new JLabel("Copisteria");
		lblCopisteria.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCopisteria = new GridBagConstraints();
		gbc_lblCopisteria.anchor = GridBagConstraints.WEST;
		gbc_lblCopisteria.insets = new Insets(0, 0, 0, 5);
		gbc_lblCopisteria.gridx = 0;
		gbc_lblCopisteria.gridy = 5;
		formPanel.add(lblCopisteria, gbc_lblCopisteria);
		
		JTextArea txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//txtAreaDescrizione.setText("Prova prova");
		GridBagConstraints gbc_textarea = new GridBagConstraints();
		gbc_textarea.insets = new Insets(0, 0, 5, 0);
		gbc_textarea.fill = GridBagConstraints.HORIZONTAL;
		gbc_textarea.gridx = 1;
		gbc_textarea.gridy = 1;
		formPanel.add(txtAreaDescrizione, gbc_textarea);
        txtAreaDescrizione.setColumns(20);
        txtAreaDescrizione.setLineWrap(true);
        txtAreaDescrizione.setRows(5);
        txtAreaDescrizione.setWrapStyleWord(true);
        
		JTextField txtNumPag = new JTextField();
		GridBagConstraints gbc_txtNumPag = new GridBagConstraints();
		gbc_txtNumPag.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumPag.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumPag.gridx = 1;
		gbc_txtNumPag.gridy = 2;
		formPanel.add(txtNumPag, gbc_txtNumPag);
		txtNumPag.setColumns(3);
		
		/**
		 * Lista citta'
		 */
		Vector<String> listCitta = new Vector<String>();
		listCitta.add("L'Aquila");
		listCitta.add("Torino");
		listCitta.add("Roma");
		
		/**
		 *  Inserimento e caricamento corsi dal db
		 */
		
		final Corso[] corsi = ControllerCorso.getInstance().getAllCorsi();
		JList lstCorsi = new JList();
		
		lstCorsi.setModel(new AbstractListModel() {
			public int getSize() {
				return corsi.length;
			}
			public Object getElementAt(int index) {
				return corsi[index].getNome();
			}
		});
		
		GridBagConstraints gbc_lstCorso = new GridBagConstraints();
		gbc_lstCorso.insets = new Insets(0, 0, 5, 0);
		gbc_lstCorso.fill = GridBagConstraints.HORIZONTAL;
		gbc_lstCorso.gridx = 1;
		gbc_lstCorso.gridy = 3;
		formPanel.add(lstCorsi,gbc_lstCorso);
		
		/**
		 *  Inserimento e caricamento corsi dal db
		 */
		
		final String[] copisterie = new String[5];
		copisterie[0] = "New Copy";
		copisterie[1] = "Stella degli elfi";
		copisterie[2] = "CopiaCopia";
		copisterie[3] = "Dal magnaccia";
		copisterie[4] = "Vieni da Zio";
		
		JList lstCopisteria = new JList();
		lstCopisteria.setModel(new AbstractListModel() {
			public int getSize() {
				return copisterie.length;
			}
			public Object getElementAt(int index) {
				return copisterie[index];
			}
		});
		
		JScrollPane scrollPaneCopist = new JScrollPane();
		scrollPaneCopist.getViewport().setView(lstCopisteria);
		//scrollPaneCopist.setVisibleRowCount(1);
		
		GridBagConstraints gbc_lstcopisteria = new GridBagConstraints();
		gbc_lstcopisteria.insets = new Insets(0, 0, 5, 0);
		gbc_lstcopisteria.fill = GridBagConstraints.HORIZONTAL;
		gbc_lstcopisteria.gridx = 1;
		gbc_lstcopisteria.gridy = 4;
		formPanel.add(scrollPaneCopist,gbc_lstcopisteria);
		
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
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
