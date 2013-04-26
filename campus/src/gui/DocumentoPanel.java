package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import com.sun.pdfview.PDFViewer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DocumentoPanel extends Pagina{
	
	private JPanel panel;
	private PDFViewer pdfDoc = new PDFViewer(true);
	boolean suggestOpened = false;
	
	
	public DocumentoPanel(String pdfPath) {
		super();
	}
	
	public void setPDF(String pdfPath) {
        if (pdfPath != null) {
        	pdfDoc.doOpen(pdfPath);
        }
        else {
        	pdfDoc.doOpen();
        }
	}

	@Override
	public void load() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
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
		
		final JPanel doc_panel = new JPanel();
		doc_panel.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		doc_panel.setBackground(Color.WHITE);
		doc_panel.setBounds(10, 100, 594, 484);
		panel.add(doc_panel);
		doc_panel.setLayout(null);
		
		final JPanel suggerimenti = new JPanel();
		suggerimenti.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		suggerimenti.setBackground(Color.WHITE);
		suggerimenti.setBounds(519, 0, 75, 484);
		doc_panel.add(suggerimenti);
		suggerimenti.setLayout(null);
		
		final JButton btnNewButton = new JButton(">");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (suggestOpened) {
					suggestOpened = false;
					doc_panel.setBounds(10, 100, 594, 484);
					suggerimenti.setBounds(519, 0, 75, 484);
					btnNewButton.setText(">");
				} else {
					suggestOpened = true;
					doc_panel.setBounds(10, 100, 594+376, 484);
					suggerimenti.setBounds(519+376, 0, 75, 484);
					btnNewButton.setText("<");
				}
			}
		});
		btnNewButton.setBounds(2, 2, 71, 71);
		suggerimenti.add(btnNewButton);
		
		JPanel doc = new JPanel();
		doc.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		doc.setBackground(Color.WHITE);
		doc.setBounds(0, 0, 521, 484);
		doc_panel.add(doc);
		doc.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 2, 517, 480);
		doc.add(panel_1);
		panel_1.setLayout(null);

		

		
		//CopyOfPDFViewer pdfDoc = new CopyOfPDFViewer(true);
		//pdfDoc.setBackground(Color.WHITE);
		//pdfDoc.setBounds(2, 2, 517, 480);
		//doc.add(pdfDoc);
		
		pdfDoc.setBounds(0, -48, 518, 529);
		panel_1.add(pdfDoc);
		pdfDoc.setBorder(null);

		//pdfDoc.setBackground(Color.WHITE);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(614, 100, 178, 240);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(802, 100, 178, 240);
		panel.add(panel_4);
		
		JButton btnScarica = new JButton();
		btnScarica.setText("Scarica");
		btnScarica.setForeground(Color.WHITE);
		btnScarica.setFont(new Font("Arial", Font.BOLD, 18));
		btnScarica.setFocusPainted(false);
		btnScarica.setBorder(new LineBorder(Color.BLACK, 1));
		btnScarica.setBackground(Color.BLACK);
		btnScarica.setBounds(614, 351, 178, 28);
		panel.add(btnScarica);
		
		JButton btnPrenotaStampa = new JButton();
		btnPrenotaStampa.setText("Prenota stampa");
		btnPrenotaStampa.setForeground(Color.WHITE);
		btnPrenotaStampa.setFont(new Font("Arial", Font.BOLD, 18));
		btnPrenotaStampa.setFocusPainted(false);
		btnPrenotaStampa.setBorder(new LineBorder(Color.BLACK, 1));
		btnPrenotaStampa.setBackground(Color.BLACK);
		btnPrenotaStampa.setBounds(802, 351, 178, 28);
		panel.add(btnPrenotaStampa);
		
		JLabel lblCommenti = new JLabel("Commenti");
		lblCommenti.setForeground(new Color(6, 121, 159));
		lblCommenti.setFont(new Font("Arial", Font.BOLD, 18));
		lblCommenti.setBounds(624, 390, 200, 25);
		panel.add(lblCommenti);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(614, 414, 170, 1);
		panel.add(separator_1);
		
	}

	@Override
	public int getHeight() {
		return panel.getHeight();
	}
}
