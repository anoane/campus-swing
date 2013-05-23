package gui;

import gui.riquadri.RiquadroUtenteDoc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import modello_di_dominio.Documento;
import modello_di_dominio.Voto;

import com.sun.pdfview.PDFViewer;

import controller.ControllerDocumento;
import controller.ControllerUtente;
import controller.ControllerVoto;

@SuppressWarnings("serial")
public class DocumentoPanel extends Pagina {

	private PDFViewer pdfDoc = new PDFViewer(true);
	boolean suggestOpened = false;
	private JPanel riquadrodx;
	private JPanel panel;
	private JButton btnAggiungiAiPreferiti;
	JLabel lblPreferiti = new JLabel();
	JLabel lbltipo;
	// Panel stelle
	private JPanel stelle;

	// Panel contenente il colore di riempimento delle stelle
	private JPanel colore;
	JLabel lblNewLabel_1 = new JLabel();
	JLabel lblNewLabel = new JLabel();
	JLabel lblUniversit = new JLabel();
	JLabel lblVoti = new JLabel();
	JTextPane panel_3 = new JTextPane();

	public DocumentoPanel(final Documento d) {
		setBackground(Color.WHITE);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 585));
		add(panel);
		panel.setLayout(null);

		lblPreferiti.setForeground(new Color(6, 121, 159));
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblPreferiti.setBounds(10, 10, 200, 25);
		panel.add(lblPreferiti);

		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(147, 53, 134, 23);
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
					doc_panel.setBounds(10, 100, 594 + 376, 484);
					suggerimenti.setBounds(519 + 376, 0, 75, 484);
					btnNewButton.setText("<");
				}
				toggleInfo();
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

		// CopyOfPDFViewer pdfDoc = new CopyOfPDFViewer(true);
		// pdfDoc.setBackground(Color.WHITE);
		// pdfDoc.setBounds(2, 2, 517, 480);
		// doc.add(pdfDoc);

		pdfDoc.setBounds(0, -48, 518, 529);
		panel_1.add(pdfDoc);
		pdfDoc.setBorder(null);

		// pdfDoc.setBackground(Color.WHITE);

		ButtonStandard buttonCreator = new ButtonStandard();
		btnAggiungiAiPreferiti = buttonCreator.createButton(
				"Aggiungi ai preferiti", 409, 49, 230, 34, false, true);
		panel.add(btnAggiungiAiPreferiti);

		//if (ControllerUtente.getInstance().getUtente(1).documentiPreferiti.contains(d))
		if (ControllerUtente.getInstance().containDocumentoPreferito(ControllerUtente.getInstance().getUtente(1), d))
			btnAggiungiAiPreferiti.setVisible(false);

		lbltipo = new JLabel();
		lbltipo.setBounds(84, 53, 57, 23);
		panel.add(lbltipo);

		lblUniversit.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUniversit.setBounds(290, 53, 121, 23);
		panel.add(lblUniversit);

		riquadrodx = new JPanel();
		riquadrodx.setBackground(Color.WHITE);
		riquadrodx.setBounds(614, 100, 500, 280);
		riquadrodx.setLayout(null);
		panel.add(riquadrodx);

		panel_3.setEditable(false);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 178, 240);
		riquadrodx.add(panel_3);

		RiquadroUtenteDoc panel_4 = new RiquadroUtenteDoc(ControllerUtente
				.getInstance().getUtente(1));
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(188, 0, 178, 240);
		riquadrodx.add(panel_4);

		JButton btnScarica = buttonCreator.createButton("Scarica", 0, 251, 178,
				28, false, true);
		riquadrodx.add(btnScarica);

		JButton btnPrenotaStampa = buttonCreator.createButton("Prenota stampa",
				188, 251, 178, 28, false, true);
		riquadrodx.add(btnPrenotaStampa);

		JLabel lblCommenti = new JLabel("Commenti");
		lblCommenti.setForeground(new Color(6, 121, 159));
		lblCommenti.setFont(new Font("Arial", Font.BOLD, 18));
		lblCommenti.setBounds(624, 390, 200, 25);
		panel.add(lblCommenti);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(27, 50, 128));
		separator_1.setBounds(614, 414, 170, 1);
		panel.add(separator_1);
		stelle = new JPanel();
		stelle.setBounds(205, 10, 150, 30);
		stelle.setLayout(null);
		colore = new JPanel();
		for (int i = 0; i < 5; ++i) {
			// Label contenente la singola stella
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i * 30, 0, 30, 30);
			stella.setIcon(new ImageIcon("./newimage/white_star_big.png"));
			stelle.add(stella);
		}
		colore.setBackground(new Color(255, 222, 87));
		stelle.add(colore);
		panel.add(stelle);
		
		lblVoti.setBounds(365, 20, 50, 20);
		panel.add(lblVoti);
	}

	public void setPDF(String pdfPath) {
		if (pdfPath != null) {
			pdfDoc.doOpen(pdfPath);
		} else {
			pdfDoc.doOpen();
		}
	}


	/**
	 * Metodo che nasconde i riquadri della descrizione del documento, il
	 * riquadro dell'utente e i pulsanti di scarica e prenota altrimenti si
	 * possono vedere...
	 */
	private void toggleInfo() {
		if (riquadrodx.isVisible())
			riquadrodx.setVisible(false);
		else
			riquadrodx.setVisible(true);
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reload(Object o) {
		resetStelle();
		ControllerVoto contrVoto = ControllerVoto.getInstance(); 
		final Documento d = ((Documento) o);
		if (ControllerUtente.getInstance().containDocumentoPreferito(ControllerUtente.getInstance().getUtente(1), d))
			btnAggiungiAiPreferiti.setVisible(false);
		if(d.getPath() != null && !d.getPath().equals("/")){
			String strTipo = d.getPath().split("\\.")[1];
			switch(strTipo){
			case "pdf":
				lbltipo.setIcon(new ImageIcon("./newimage/pdf.png"));
				break;
			case "ppt":
				lbltipo.setIcon(new ImageIcon("./newimage/ppt.png"));
				break;
			case "doc":
				lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
				break;
			default:
				lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
				break;
			}
		}
		else
			lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
		lblPreferiti.setText(d.getNome());
		final int backup_colore = (int) (stelle.getWidth() * contrVoto.calcolaVoto(d));
		colore.setSize(backup_colore, 30);
		lblNewLabel_1.setText(d.getCorso().getNome());
		switch (d.getDiscriminator()) {
		case "Appunti":
			lblNewLabel.setText("Appunti");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x99, 0x00));
			break;
		case "Dispense":
			lblNewLabel.setText("Dispense");
			lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
			break;
		case "Esercizi":
			lblNewLabel.setText("Esercizi");
			lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
			break;
		case "Slide":
			lblNewLabel.setText("Slide");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
			break;
		default:
			lblNewLabel.setText("Documento");
			lblNewLabel.getParent().setBackground(new Color(0xFF, 0xFF, 0xFF));
			break;
		}
		lblUniversit.setText(d.getFacolta().getNome());
		panel_3.setText(d.getDescrizione());
		btnAggiungiAiPreferiti.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ControllerUtente u = ControllerUtente.getInstance();
				u.aggiungiDocumentoPreferito(u.getUtente(1), d);
				//Home.getPagina("preferiti");
				btnAggiungiAiPreferiti.setVisible(false);
			}
		});
		lblVoti.setText(Integer.toString(d.votos.size()));

		boolean giaVotato = ControllerDocumento.getInstance().controlloVotato(
				d, ControllerUtente.getInstance().getUtente(1));
		for (int i = 0; i < 5; ++i) {
			final int j = i + 1;
			MouseListener m = new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					colore.setSize(backup_colore, 30);
					colore.validate();
					colore.repaint();
					stelle.validate();
					stelle.repaint();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					colore.setSize(30 * j, 30);
					colore.validate();
					colore.repaint();
					stelle.validate();
					stelle.repaint();
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					ControllerDocumento.getInstance().votaDocumento(d,
							ControllerUtente.getInstance().getUtente(1), j * 2);
					resetStelle();
					JOptionPane.showMessageDialog(null, "Voto salvato!");
					Home.openDocument(true, d);
				}
			};
			if (!giaVotato) {
				stelle.getComponent(i).setCursor(
						Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				stelle.getComponent(i).addMouseListener(m);
			} else {
				stelle.setToolTipText("Hai già votato questo documento");
			}
		}
	}

	@Override
	public int getAltezzaPagina() {
		return panel.getHeight();
	}
	
	private void resetStelle(){
		for (int i = 0; i < 5; ++i) {
			stelle.remove(i);
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i * 30, 0, 30, 30);
			stella.setIcon(new ImageIcon("./newimage/white_star_big.png"));
			stelle.add(stella, i);
		}
	}
}
