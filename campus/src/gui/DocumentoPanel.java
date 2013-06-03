package gui;

import gui.helpers.DocFlag;
import gui.helpers.JTextFieldLimit;
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
import javax.swing.JTextField;
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
import javax.swing.SwingConstants;

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
	private JButton btnAttivaModifica;
	private JButton btnTerminaModifica;
	private JButton btnElimina;
	
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
	private JTextField tf_preferiti = new JTextField();
	
	private boolean canEliminate = true;
	
	private Documento nowDocumento = null;
	
	public void setEliminate(boolean b) {
		canEliminate = b;
	}
	
	public boolean getEliminate() {
		return canEliminate;
	}

	public DocumentoPanel(final Documento d, boolean modificaAttiva) {
		
		setBackground(Color.WHITE);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(new Rectangle(0, 0, 1008, 585));
		add(panel);
		panel.setLayout(null);

		lblPreferiti.setForeground(new Color(6, 121, 159));
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 20));
		lblPreferiti.setBounds(10, 10, 250, 25);
		panel.add(lblPreferiti);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);

		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(307, 59, 353, 23);
		panel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(27, 50, 128));
		separator.setBounds(0, 41, 170, 1);
		panel.add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(10, 59, 67, 24);
		panel.add(panel_2);
		panel_2.setBorder(new LineBorder(Home.BLUE_BUTTON_UNPRESSED, 2));
		panel_2.setLayout(null);

		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(5, 2, 83, 20);
		panel_2.add(lblNewLabel);

		ButtonStandard buttonCreator = new ButtonStandard();
		btnAggiungiAiPreferiti = buttonCreator.createButton(
				"Aggiungi ai preferiti", 750, 8, 230, 28, false, true);
		panel.add(btnAggiungiAiPreferiti);
		btnRimuoviDaiPreferiti = buttonCreator.createButton(
				"Rimuovi dai preferiti", 750, 8, 230, 28, false, true);
		panel.add(btnRimuoviDaiPreferiti);
		btnAttivaModifica = buttonCreator.createButton(
				"Modifica il documento", 270, 8, 230, 28, false, true);
		panel.add(btnAttivaModifica);
		btnTerminaModifica = buttonCreator.createButton(
				"Termina la modifica", 270, 8, 230, 28, false, true);
		panel.add(btnTerminaModifica);
		btnElimina = buttonCreator.createButton(
				"Elimina il documento", 510, 8, 230, 28, false, true);
		panel.add(btnElimina);
		
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
		lbltipo.setBounds(84, 59, 57, 23);
		panel.add(lbltipo);

		lblUniversit.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUniversit.setBounds(682, 59, 298, 23);
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

		RiquadroUtenteDoc panel_4 = new RiquadroUtenteDoc(Home.getUtenteLoggato());
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
		stelle.setBounds(147, 56, 150, 30);
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
		lblVoti.setVisible(false);
		panel.add(lblVoti);
		suggerimenti = new Suggerimenti();
		panel.add(suggerimenti);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(671, 59, 1, 23);
		panel.add(separator_2);
		reload(d);
	}
	
	public void unsetAllPreviewer() {
		setPDF(null);
		panel_1.removeAll();
		JLabel templabel = new JLabel("Anteprima non disponibile");
		templabel.setForeground(Home.BLUE_BUTTON_PRESSED);
		templabel.setBackground(Color.LIGHT_GRAY);
		templabel.setHorizontalAlignment(SwingConstants.CENTER);
		templabel.setFont(new Font("Arial", Font.BOLD, 20));
		templabel.setBounds(0, 0, 518, 481);
		panel_1.add(templabel);
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
		if (o!=null) {
			setEliminate(true);
			btnTerminaModifica.setVisible(false);
			//btnNewButton = new JButton(">");
			//panel.add(btnNewButton);
			//btnNewButton.setBounds(521, 165, 45, 45);
			//menuSuggerimenti = new MenuSuggerimenti(false);
			//menuSuggerimenti.setLocation(521, 100);
			//panel.add(menuSuggerimenti);

			
			resetStelle();
			ControllerVoto contrVoto = ControllerVoto.getInstance(); 
			setDocumento(((DocFlag)o).getDoc());
			final boolean flagModifica = ((DocFlag)o).getFlag();
			riquadrodx.setVisible(true);
			panel.remove(suggerimenti);
			suggerimenti = new Suggerimenti();
			suggerimenti.setLocation(521, 100);
			suggerimenti.load(getDocumento());
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

			if (getDocumento() != null) {
				if (ControllerUtente.getInstance().containDocumentoPreferito(
						Home.getUtenteLoggato(), getDocumento())) {
						btnAggiungiAiPreferiti.setVisible(false);
						btnRimuoviDaiPreferiti.setVisible(true);
					} else {
						btnAggiungiAiPreferiti.setVisible(true);
						btnRimuoviDaiPreferiti.setVisible(false);
				}
				if (getDocumento().getProprietario().getID()==Home.getUtenteLoggato().getID()) {
						lblPreferiti.setBounds(10, 10, 250, 25);
						btnElimina.setVisible(true);
						btnAttivaModifica.setVisible(true);
						btnTerminaModifica.setVisible(false);
					} else {
						lblPreferiti.setBounds(10, 10, 730, 25);
						btnElimina.setVisible(false);
						btnAttivaModifica.setVisible(false);
						btnTerminaModifica.setVisible(false);
				}
				panel.validate();
				panel.repaint();
			}
			if (getDocumento().getPath() != null && !getDocumento().getPath().equals("/")) {
				String strTipo = getDocumento().getPath().split("\\.")[1];
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
			lblPreferiti.setText(getDocumento().getNome());
			final int backup_colore = (int) (stelle.getWidth() * contrVoto
					.calcolaVoto(getDocumento()));
			colore.setSize(backup_colore, 30);
			lblNewLabel_1.setText(getDocumento().getCorso().getNome());
			switch (getDocumento().getDiscriminator()) {
			case "Appunti":
				lblNewLabel.setText("Appunti");
				lblNewLabel.getParent().setBackground(new Color(0xFF, 0x99, 0x00));
				break;
			case "Dispense":
				lblNewLabel.setText("Dispense");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.getParent().setBackground(new Color(0xCC, 0x33, 0xCC));
				break;
			case "Esercizi":
				lblNewLabel.setText("Esercizi");
				lblNewLabel.getParent().setBackground(new Color(0x00, 0x99, 0x00));
				break;
			case "Slide":
				lblNewLabel.setText("Slide");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.getParent().setBackground(new Color(0xFF, 0x00, 0x00));
				break;
			default:
				lblNewLabel.setText("Documento");
				lblNewLabel.getParent().setBackground(new Color(0xFF, 0xFF, 0xFF));
				break;
			}
			lblUniversit.setText(getDocumento().getFacolta().getNome());
			panel_3.setText(getDocumento().getDescrizione());
			btnAggiungiAiPreferiti.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ControllerPreferiti.getInstance().aggiungiDocumentoPreferito(Home.getUtenteLoggato(), getDocumento());
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
					u.rimuoviDocumentoPreferito(Home.getUtenteLoggato(), getDocumento());
					btnAggiungiAiPreferiti.setVisible(true);
					btnRimuoviDaiPreferiti.setVisible(false);
					validate();
					repaint();
				}
			});

			btnElimina.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (getEliminate()) {
						int n = JOptionPane.showConfirmDialog(Home.getFrame(),"Sei sicuro di voler cancellare il documento?","Attenzione",0);
						if(n==0){
							setEliminate(false);
							ControllerDocumento cd = ControllerDocumento.getInstance();
							cd.removeDocumento(getDocumento());
							Home.getPagina("miei_documenti");
						}
					}
				}
			});
			btnAttivaModifica.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					//label
					lblPreferiti.setVisible(false);
					tf_preferiti.setDocument(new JTextFieldLimit(254));
					tf_preferiti.setText(getDocumento().getNome());
					tf_preferiti.setForeground(new Color(6, 121, 159));
					tf_preferiti.setFont(new Font("Arial", Font.BOLD, 20));
					tf_preferiti.setBounds(10, 10, 250, 28);
					panel.add(tf_preferiti);
					btnAttivaModifica.setVisible(false);
					btnTerminaModifica.setVisible(true);
				}
			});
			btnTerminaModifica.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ControllerDocumento.getInstance().modificaDocumento(getDocumento().getID(),tf_preferiti.getText(),getDocumento().getDescrizione(),getDocumento().getPath());
					reload(new DocFlag(getDocumento(),false));
				}
			});

			lblVoti.setText(Integer.toString(getDocumento().votos.size()));

			boolean giaVotato = ControllerDocumento.getInstance().controlloVotato(
					getDocumento(), Home.getUtenteLoggato());
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
						ControllerDocumento.getInstance().votaDocumento(getDocumento(),
								Home.getUtenteLoggato(), j * 2);
						resetStelle();
						JOptionPane.showMessageDialog(null, "Voto salvato!");
						reload(new DocFlag(getDocumento(),false));
					}
				};
				if (!giaVotato) {
					stelle.getComponent(i).setCursor(
							Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					stelle.getComponent(i).addMouseListener(m);
				} else {
					stelle.setToolTipText("Hai gi� votato questo documento");
				}
			}
		
		}
	}

	private void setDocumento(Documento doc) {
		nowDocumento = doc;
	}

	private Documento getDocumento() {
		return nowDocumento;
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
}
