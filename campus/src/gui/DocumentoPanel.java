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
import modello_di_dominio.Utente;

import org.jopendocument.model.OpenDocument;
import org.jopendocument.panel.ODSViewerPanel;
import org.jopendocument.renderer.ODTRenderer;

import com.sun.pdfview.PDFViewer;

import controller.ControllerDocumento;
import controller.ControllerPreferiti;
import controller.ControllerUtente;
import controller.ControllerVoto;

@SuppressWarnings("serial")
public class DocumentoPanel extends Pagina {

	private PDFViewer pdfDoc = new PDFViewer(true);
	private OpenDocument openDoc = new OpenDocument();
	
	private boolean pdfFile = true;
	
	boolean suggestOpened = false;
	private JPanel riquadrodx;
	private JPanel panel;
	private JButton btnAggiungiAiPreferiti;
	private JButton btnRimuoviDaiPreferiti;
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
	
	private JPanel panel_1 = new JPanel();
	private Suggerimenti suggerimenti;
	private JButton btnNewButton;
	private MenuSuggerimenti menuSuggerimenti;


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

		ButtonStandard buttonCreator = new ButtonStandard();
		btnAggiungiAiPreferiti = buttonCreator.createButton(
				"Aggiungi ai preferiti", 409, 49, 230, 34, false, true);
		panel.add(btnAggiungiAiPreferiti);
		btnRimuoviDaiPreferiti = buttonCreator.createButton(
				"Rimuovi dai preferiti", 409, 49, 230, 34, false, true);
		panel.add(btnRimuoviDaiPreferiti);

		// if
		// (ControllerUtente.getInstance().getUtente(1).documentiPreferiti.contains(d))
		if (d != null) {
			if (ControllerUtente.getInstance().containDocumentoPreferito(
					ControllerUtente.getInstance().getUtente(1), d)) {
				btnAggiungiAiPreferiti.setVisible(false);
				btnRimuoviDaiPreferiti.setVisible(true);
				panel.validate();
				panel.repaint();
			} else {
				btnAggiungiAiPreferiti.setVisible(true);
				btnRimuoviDaiPreferiti.setVisible(false);
				panel.validate();
				panel.repaint();
			}
		}

		JPanel doc = new JPanel();
		doc.setBounds(0, 100, 521, 484);
		panel.add(doc);
		doc.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		doc.setBackground(Color.WHITE);
		doc.setLayout(null);

		panel_1.setBounds(2, 2, 517, 480);
		doc.add(panel_1);
		panel_1.setLayout(null);
		
		pdfDoc.setBounds(0, -48, 518, 529);
		panel_1.add(pdfDoc);
		pdfDoc.setBorder(null);

		//suggerimenti = new PannelloSuggerimenti();
		//suggerimenti.setBounds(575, 100, 430, 400);
		//suggerimenti.setLocation(575,100);
		//suggerimenti.setVisible(false);
		//panel.add(suggerimenti);
		//suggerimenti.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		//suggerimenti.setBackground(Color.WHITE);

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

		JPanel panelCommenti = new JPanel();
		panelCommenti.setBounds(624, 390, 200, 200);
		riquadrodx.add(panelCommenti);
		panelCommenti.setLayout(null);

		JLabel lblCommenti = new JLabel("Commenti");
		lblCommenti.setBounds(0, 0, 200, 25);
		panelCommenti.add(lblCommenti);
		lblCommenti.setForeground(new Color(6, 121, 159));
		lblCommenti.setFont(new Font("Arial", Font.BOLD, 18));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 25, 170, 1);
		panelCommenti.add(separator_1);
		separator_1.setForeground(new Color(27, 50, 128));
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
		suggerimenti = new Suggerimenti();
		panel.add(suggerimenti);
	}

	public void setPDF(String pdfPath) {
		pdfFile = true;
		if (pdfPath != null && !pdfPath.equals("/")) {
			
			panel_1.removeAll();
			
			pdfDoc.doOpen(pdfPath);
			pdfDoc.setBounds(0, -48, 518, 529);
			panel_1.add(pdfDoc);
			pdfDoc.setBorder(null);
			
		} else {
			// pdfDoc.doOpen();
		}
	}
	
	public void setOdsDoc(String docPath){
		pdfFile = false;
		if(docPath != null && !docPath.equals("/")) {
			
			//Reset Panel 1
			panel_1.removeAll();
			
			openDoc.loadFrom(docPath);
			ODSViewerPanel viewer = new ODSViewerPanel(openDoc);
			viewer.setBounds(new Rectangle(0,0,518,529));
			panel_1.add(viewer);
		}
	}
	
	public void setOdtDoc(String docPath){
		pdfFile = false;
		if(docPath != null && !docPath.equals("/")) {
			
			//Reset Panel 1
			panel_1.removeAll();
			
			openDoc.loadFrom(docPath);
			ODTRenderer odtRenderer = new ODTRenderer(openDoc);
			odtRenderer.setBounds(new Rectangle(0,0,518,529));
			panel_1.add(odtRenderer);
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
		//btnNewButton = new JButton(">");
		//panel.add(btnNewButton);
		//btnNewButton.setBounds(521, 165, 45, 45);
		//menuSuggerimenti = new MenuSuggerimenti(false);
		//menuSuggerimenti.setLocation(521, 100);
		//panel.add(menuSuggerimenti);
		resetStelle();
		ControllerVoto contrVoto = ControllerVoto.getInstance(); 
		final Documento d = ((Documento) o);
		riquadrodx.setVisible(true);
		panel.remove(suggerimenti);
		suggerimenti = new Suggerimenti();
		suggerimenti.setLocation(521, 100);
		suggerimenti.load(d);
		panel.add(suggerimenti);
		//suggerimenti.setPreferredSize(new Dimension(440, 400));
		
		
		//suggerimenti.load(d);
		
		//adjustSuggerimenti();
		
		/*suggerimenti.getViewport().getComponent(0).addComponentListener(
				new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent arg0) {
						adjustSuggerimenti();
					}
				});
		
		suggerimenti.setVisible(false);*/
		toggleInfo();
		validate();
		repaint();
		/*btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (suggestOpened) {
					suggestOpened = false;
					suggerimenti.setVisible(false);
					btnNewButton.setText(">");
				} else {
					suggestOpened = true;
					suggerimenti.setVisible(true);
					btnNewButton.setText("<");
				}
				toggleInfo();
				validate();
				repaint();
			}

		});*/

		if (d != null) {
			if (ControllerUtente.getInstance().containDocumentoPreferito(
					ControllerUtente.getInstance().getUtente(1), d)) {
				btnAggiungiAiPreferiti.setVisible(false);
				btnRimuoviDaiPreferiti.setVisible(true);
				panel.validate();
				panel.repaint();
			} else {
				btnAggiungiAiPreferiti.setVisible(true);
				btnRimuoviDaiPreferiti.setVisible(false);
				panel.validate();
				panel.repaint();

			}
		}
		if (d.getPath() != null && !d.getPath().equals("/")) {
			String strTipo = d.getPath().split("\\.")[1];
			switch (strTipo) {
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
		} else
			lbltipo.setIcon(new ImageIcon("./newimage/doc.png"));
		lblPreferiti.setText(d.getNome());
		final int backup_colore = (int) (stelle.getWidth() * contrVoto
				.calcolaVoto(d));
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
				Utente u = ControllerUtente.getInstance().getUtente(1);
				ControllerPreferiti.getInstance().aggiungiDocumentoPreferito(u, d);
				// Home.getPagina("preferiti");
				btnAggiungiAiPreferiti.setVisible(false);
				btnRimuoviDaiPreferiti.setVisible(true);
				validate();
				repaint();
			}
		});
		btnRimuoviDaiPreferiti.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ControllerUtente u = ControllerUtente.getInstance();
				u.rimuoviDocumentoPreferito(u.getUtente(1), d);
				btnAggiungiAiPreferiti.setVisible(true);
				btnRimuoviDaiPreferiti.setVisible(false);
				validate();
				repaint();
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

	private void resetStelle() {
		for (int i = 0; i < 5; ++i) {
			stelle.remove(i);
			JLabel stella = new JLabel();
			stella.setAlignmentY(Component.TOP_ALIGNMENT);
			stella.setBounds(i * 30, 0, 30, 30);
			stella.setIcon(new ImageIcon("./newimage/white_star_big.png"));
			stelle.add(stella, i);
		}
	}
	/*
	private void adjustSuggerimenti(){
		if(suggerimenti.getViewport().getComponent(0).getHeight() >= 484){

			suggerimenti.setPreferredSize(new Dimension(440,484));
			suggerimenti.setSize(440,484);
		}
		suggerimenti.validate();
		suggerimenti.repaint();
	}*/
}
