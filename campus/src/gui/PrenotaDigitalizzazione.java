package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;

import modello_di_dominio.Corso;
import controller.ControllerCorso;

public class PrenotaDigitalizzazione extends Pagina {
	private JPanel panel;
	private ButtonStandard buttonCreator = new ButtonStandard();
	private JButton inviaRichiesta = buttonCreator.createButton("Invia Richiesta", 0, 0, 0, 0, false, true);
	
	public PrenotaDigitalizzazione() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1008, 390);
		add(panel);
		
		JLabel label = new JLabel("Prenota Digitalizzazione");
		label.setForeground(new Color(6, 121, 159));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 10, 235, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		//panel.add(inviaRichiesta);
				
		JPanel formPanel = new JPanel();
		formPanel.setBounds(0, 48, 424, 356);
		formPanel.setBackground(null);
		panel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] {125, 280};
		gbl_formPanel.rowHeights = new int[] {30, 140, 30, 30, 30, 30, 0};
		gbl_formPanel.columnWeights = new double[]{0.0};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		gbc_lblDesc.fill = GridBagConstraints.VERTICAL;
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
		gbc_txtNomeDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeDoc.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblCopisteria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCopisteria.gridx = 0;
		gbc_lblCopisteria.gridy = 5;
		formPanel.add(lblCopisteria, gbc_lblCopisteria);
		
		JTextArea txtAreaDescrizione = new JTextArea();
		//txtAreaDescrizione.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setWrapStyleWord(true);
		//txtAreaDescrizione.setText("Prova prova");
		GridBagConstraints gbc_textarea = new GridBagConstraints();
		gbc_textarea.insets = new Insets(0, 0, 5, 0);
		gbc_textarea.fill = GridBagConstraints.BOTH;
		gbc_textarea.gridx = 1;
		gbc_textarea.gridy = 1;
		txtAreaDescrizione.setColumns(20);
        txtAreaDescrizione.setLineWrap(true);
        txtAreaDescrizione.setRows(5);
        txtAreaDescrizione.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(txtAreaDescrizione); 
		formPanel.add(scrollPane, gbc_textarea);
        
        
		JTextField txtNumPag = new JTextField();
		GridBagConstraints gbc_txtNumPag = new GridBagConstraints();
		gbc_txtNumPag.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumPag.insets = new Insets(0, 0, 5, 0);
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
		JComboBox comboBoxCorsi = new JComboBox();
		if (corsi.length != 0) {
			final String temp[] = new String[corsi.length];
			for (int i=0;corsi.length>i;i++) {
				//System.out.println("ss");
				if (corsi[i].getNome().length() > 20) {
					temp[i] = corsi[i].getNome().substring(0, 19).concat("...");
				} else {
					temp[i] = corsi[i].getNome();
				}
			}			
			
			comboBoxCorsi.setModel(new ComboBoxModel<String>() {
				//TODO: Fix
				private String selected = temp[0];
				
				@Override
				public void addListDataListener(ListDataListener arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public String getElementAt(int arg0) {
					//if (corsi[arg0].getNome().length() > 40) {
					//	return corsi[arg0].getNome().substring(0, 39).concat("...");
					//}
					//return corsi[arg0].getNome();
					return temp[arg0];
				}

				@Override
				public int getSize() {
					return temp.length;
				}

				@Override
				public void removeListDataListener(ListDataListener arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Object getSelectedItem() {
					return selected;
				}

				@Override
				public void setSelectedItem(Object anItem) {
					selected = (String) anItem;
				}
				
			});
		}

		
		GridBagConstraints gbc_lstCorso = new GridBagConstraints();
		gbc_lstCorso.fill = GridBagConstraints.HORIZONTAL;
		gbc_lstCorso.insets = new Insets(0, 0, 5, 0);
		gbc_lstCorso.gridx = 1;
		gbc_lstCorso.gridy = 3;
		formPanel.add(comboBoxCorsi,gbc_lstCorso);
		
		/**
		 *  Inserimento e caricamento corsi dal db
		 */
		
		String[] copisterie = new String[5];
		copisterie[0] = "New Copy";
		copisterie[1] = "Stella degli elfi";
		copisterie[2] = "CopiaCopia";
		copisterie[3] = "Dal magnaccia";
		copisterie[4] = "Vieni da Zio";
		
		JComboBox comboBoxCop = new JComboBox(copisterie);
		comboBoxCop.setSelectedIndex(4);
		
		GridBagConstraints gbc_lstcopisteria = new GridBagConstraints();
		gbc_lstcopisteria.fill = GridBagConstraints.HORIZONTAL;
		gbc_lstcopisteria.insets = new Insets(0, 0, 5, 0);
		gbc_lstcopisteria.gridx = 1;
		gbc_lstcopisteria.gridy = 5;
		formPanel.add(comboBoxCop,gbc_lstcopisteria);
		
		/**
		 * Citta dati
		 */
		
		String[] citta = new String[5];
		citta[0] = "Roma";
		citta[1] = "Milano";
		citta[2] = "Torino";
		citta[3] = "Napoli";
		citta[4] = "L'Aquila";
		
		JComboBox comboBoxCitta = new JComboBox(citta);
		comboBoxCitta.setSelectedIndex(4);
		
		GridBagConstraints gbc_citta = new GridBagConstraints();
		gbc_citta.fill = GridBagConstraints.HORIZONTAL;
		gbc_citta.insets = new Insets(0, 0, 5, 0);
		gbc_citta.gridx = 1;
		gbc_citta.gridy = 4;
		formPanel.add(comboBoxCitta,gbc_citta);
		
		JButton btnNewButton = new JButton("dscsdcsdcsdcs");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		formPanel.add(inviaRichiesta, gbc_btnNewButton);
		//formPanel.add(btnNewButton, gbc_btnNewButton);
		
		
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
