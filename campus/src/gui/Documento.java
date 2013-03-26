package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import com.sun.pdfview.CopyOfPDFViewer;
import com.sun.pdfview.PagePanel;
import java.awt.FlowLayout;

public class Documento extends JPanel{
	public Documento() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 585));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPreferiti = new JLabel("NomeDocumento");
		lblPreferiti.setForeground(new Color(6, 121, 159));
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblPreferiti.setBounds(10, 10, 200, 25);
		panel.add(lblPreferiti);
		
		JLabel lblNewLabel_1 = new JLabel("Materia");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(147, 57, 134, 14);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(10, 52, 67, 24);
		panel.add(panel_2);
		panel_2.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPUNTI");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(5, 2, 83, 20);
		panel_2.add(lblNewLabel);
		
		JPanel doc_panel = new JPanel();
		doc_panel.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		doc_panel.setBackground(Color.WHITE);
		doc_panel.setBounds(10, 100, 594, 484);
		panel.add(doc_panel);
		doc_panel.setLayout(null);
		
		JPanel suggerimenti = new JPanel();
		suggerimenti.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		suggerimenti.setBackground(Color.WHITE);
		suggerimenti.setBounds(519, 0, 75, 484);
		doc_panel.add(suggerimenti);
		
		JPanel doc = new JPanel();
		doc.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 0, 521, 484);
		doc_panel.add(doc);
		doc.setLayout(null);
		
		CopyOfPDFViewer pdfDoc = new CopyOfPDFViewer(true);
		pdfDoc.setBounds(2, 2, 517, 480);
		doc.add(pdfDoc);
		pdfDoc.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JButton btnAggiungiAiPreferiti = new JButton();
		btnAggiungiAiPreferiti.setText("Aggiungi ai preferiti");
		btnAggiungiAiPreferiti.setForeground(Color.WHITE);
		btnAggiungiAiPreferiti.setFont(new Font("Arial", Font.BOLD, 18));
		btnAggiungiAiPreferiti.setFocusPainted(false);
		btnAggiungiAiPreferiti.setBorder(new LineBorder(Color.BLACK, 1));
		btnAggiungiAiPreferiti.setBackground(Color.BLACK);
		btnAggiungiAiPreferiti.setBounds(420, 48, 184, 28);
		panel.add(btnAggiungiAiPreferiti);
		
		JLabel lblNewLabel_2 = new JLabel("tipo_img");
		lblNewLabel_2.setBounds(84, 53, 57, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblUniversit = new JLabel("Universit\u00E0");
		lblUniversit.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUniversit.setBounds(292, 57, 121, 14);
		panel.add(lblUniversit);
		
	}
	
}
