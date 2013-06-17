package gui;

import gui.helpers.DocFlag;
import gui.helpers.JTextFieldLimit;
import gui.riquadri.RiquadroUtenteDoc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultHighlighter;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Map;
import javax.swing.JScrollPane;

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
	private JButton btnAnnullaModifica;
	private JButton btnElimina;
	private JLabel lblNewLabel_7 = new JLabel("txtFac");
	private JLabel lblNewLabel_5 = new JLabel("txtEta");
	private JLabel lblNewLabel_6 = new JLabel("txtUniv");
	private JLabel imgUtente = new JLabel("");
	
	
	JLabel lblPreferiti = new JLabel();
	JLabel lbltipo;
	// Panel stelle
	private JPanel stelle;

	// Panel contenente il colore di riempimento delle stelle
	private JPanel colore;
	JLabel lblFac = new JLabel();
	JLabel lblNewLabel = new JLabel();
	JLabel lblUniversit = new JLabel();
	JLabel lblVoti = new JLabel();
	JTextArea panel_3 = new JTextArea();
	
	private JPanel panel_1 = new JPanel();
	//private Suggerimenti suggerimenti;
	private JButton btnNewButton;
	private MenuSuggerimenti menuSuggerimenti;
	private JTextField tf_preferiti = new JTextField();
	
	private boolean canEliminate = true;
	private JSeparator separator_2 = new JSeparator();
	
	private Documento nowDocumento = null;
	private final JPanel panel_6 = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextArea txtScriviUnCommento;
	
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
		lblPreferiti.setFont(new Font("Arial", Font.BOLD, 18));
		lblPreferiti.setBounds(10, 10, 511, 25);
		panel.add(lblPreferiti);

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
				"Aggiungi ai preferiti", 759, 10, 218, 28, false, true);
		panel.add(btnAggiungiAiPreferiti);
		btnRimuoviDaiPreferiti = buttonCreator.createButton(
				"Rimuovi dai preferiti", 759, 10, 218, 28, false, true);
		panel.add(btnRimuoviDaiPreferiti);
		btnAttivaModifica = buttonCreator.createButton(
				"Modifica il documento", 531, 56, 218, 28, false, true);
		panel.add(btnAttivaModifica);
		btnTerminaModifica = buttonCreator.createButton(
				"Termina la modifica", 531, 56, 218, 28, false, true);
		panel.add(btnTerminaModifica);
		btnAnnullaModifica = buttonCreator.createButton(
				"Annulla la modifica", 531, 10, 218, 28, false, true);
		panel.add(btnAnnullaModifica);
		btnElimina = buttonCreator.createButton(
				"Elimina il documento", 759, 56, 218, 28, false, true);
		panel.add(btnElimina);
		
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
				int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>Sei sicuro di voler rimuovere ''"+getDocumento().getNome()+"'' dai preferiti?</font><br><br><font color=000000 face=arial size=4><em>*Puoi in ogni caso recuperare il documento utilizzando la funzione ''Cerca documenti o corsi''</em></font><br></html>","Attenzione",0);
				if(n==0){
					ControllerUtente u = ControllerUtente.getInstance();
					u.rimuoviDocumentoPreferito(Home.getUtenteLoggato(), getDocumento());
					btnAggiungiAiPreferiti.setVisible(true);
					btnRimuoviDaiPreferiti.setVisible(false);
					validate();
					repaint();
				}
			}
		});

		btnElimina.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (getEliminate()) {
					int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>L'eliminazione è irreversibile! Sei sicuro di voler eliminare definitivamente ''"+getDocumento().getNome()+"'' dal sistema?</font><br><br><font color=000000 face=arial size=4><em>*Puoi in ogni caso ricaricare il documento utilizzando la funzione ''Carica documento''</em></font><br></html>","Attenzione",0,JOptionPane.WARNING_MESSAGE);
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
				int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>Sei sicuro di voler modificare ''"+getDocumento().getNome()+"''?</font><br></html>","Attenzione",0);
				if(n==0){
					reload(new DocFlag(getDocumento(),true));
				}
			}
		});
		btnTerminaModifica.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>Le modifiche al documento sono irreversibili.<br>Sei sicuro di voler salvare le modifiche apportate?</font><br></html>","Attenzione",0);
				if(n==0){
					ControllerDocumento.getInstance().modificaDocumento(getDocumento().getID(),tf_preferiti.getText(),panel_3.getText(),getDocumento().getPath());
					reload(new DocFlag(getDocumento(),false));
				}
			}
		});
		btnAnnullaModifica.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(Home.getFrame(),"<html><font color=000000 face=arial size=4>Sei sicuro di voler annullare le modifiche apportate?<br>Non verrà apportata nessuna modifica al documento.</font><br></html>","Attenzione",0);
				if(n==0){
					reload(new DocFlag(getDocumento(),false));
				}
			}
		});
		lblFac.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Home.openCorso(false,getDocumento().getCorso());
			}
		    Font original;

		    @Override
		    public void mouseEntered(MouseEvent e) {
		        original = e.getComponent().getFont();
		        Map attributes = original.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        e.getComponent().setFont(original.deriveFont(attributes));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        e.getComponent().setFont(original);
		    }
		});
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

		riquadrodx = new JPanel();
		riquadrodx.setBackground(Color.WHITE);
		riquadrodx.setBounds(531, 100, 449, 485);
		riquadrodx.setLayout(null);
		panel.add(riquadrodx);
		panel_3.setFont(new Font("Arial", Font.PLAIN, 14));

		

		riquadrodx.add(panel_3);

		final RiquadroUtenteDoc panel_4 = new RiquadroUtenteDoc(Home.getUtenteLoggato());
		panel_4.setLayout(null);
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 145, 446, 96);
		riquadrodx.add(panel_4);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(95, 2, 341, 92);
		
		panel_4.add(panel_6);
		panel_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openProfilo(getDocumento().getProprietario());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBorder(new LineBorder(Home.BLUE_SEARCH_BAR,2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//label_13.setBorder(new LineBorder(new Color(0x1B, 0x32, 0x80),2));
				panel_4.setBorder(new EmptyBorder(0,0,0,0));
			}
		});
		
		
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{115, 223, 0};
		gbl_panel_6.rowHeights = new int[]{30, 30, 30, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("  Et\u00E0");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_6.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		panel_6.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("  Universit\u00E0");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_6.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panel_6.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("  Corso di studi");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel_6.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		panel_6.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(2, 2, 97, 92);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		imgUtente.setBounds(0, 0, 92, 92);
		panel_5.add(imgUtente);

		JButton btnScarica = buttonCreator.createButton("Scarica", 0, 250, 218,
				28, false, true);
		riquadrodx.add(btnScarica);

		JButton btnPrenotaStampa = buttonCreator.createButton("Prenota stampa",
				228, 250, 218, 28, false, true);
		riquadrodx.add(btnPrenotaStampa);

		JPanel panelCommenti = new JPanel();
		panelCommenti.setBackground(Color.WHITE);
		panelCommenti.setBounds(0, 289, 446, 195);
		riquadrodx.add(panelCommenti);
		panelCommenti.setLayout(null);

		JLabel lblCommenti = new JLabel("Commenti");
		lblCommenti.setBounds(0, 0, 200, 25);
		panelCommenti.add(lblCommenti);
		lblCommenti.setForeground(new Color(6, 121, 159));
		lblCommenti.setFont(new Font("Arial", Font.PLAIN, 18));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 25, 170, 1);
		panelCommenti.add(separator_1);
		separator_1.setForeground(new Color(27, 50, 128));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 36, 446, 160);
		panelCommenti.add(panel_7);
		panel_7.setLayout(null);
		scrollPane.setBounds(0, 0, 446, 104);
		
		panel_7.add(scrollPane);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 105, 446, 54);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel imgMia = new JLabel("");
		imgMia.setBounds(4, 4, 46, 46);
		Image resized = new ImageIcon("."+Home.getUtenteLoggato().getImmagine()).getImage().getScaledInstance(46, 46,  java.awt.Image.SCALE_SMOOTH);  
		imgMia.setIcon(new ImageIcon(resized));
		
		panel_8.add(imgMia);
		txtScriviUnCommento = new JTextArea();
		txtScriviUnCommento.setDocument(new JTextFieldLimit(254));
		JScrollPane scrollPane_1 = new JScrollPane(txtScriviUnCommento);
		scrollPane_1.setBounds(60, 4, 311, 36);
		scrollPane_1.setBorder(new EmptyBorder(0,0,0,0));
		panel_8.add(scrollPane_1);
		
		txtScriviUnCommento.setText("Scrivi un commento...");
		txtScriviUnCommento.setFont(new Font("Arial", Font.PLAIN, 14));
		txtScriviUnCommento.setBounds(60, 4, 376, 30);
		//panel_8.add(txtScriviUnCommento);
		txtScriviUnCommento.setWrapStyleWord(true);
		txtScriviUnCommento.setLineWrap(true);
		txtScriviUnCommento.setColumns(10);
		
		JButton btnInviaCommento = new JButton("");
		btnInviaCommento.setBounds(381, 4, 55, 23);
		panel_8.add(btnInviaCommento);
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
		//suggerimenti = new Suggerimenti();
		//panel.add(suggerimenti);
		
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(new Color(27, 50, 128));
		separator_2.setBounds(643, 59, 1, 23);
		panel.add(separator_2);
		lblFac.setBounds(307, 59, 325, 23);
		panel.add(lblFac);
		lblFac.setHorizontalAlignment(SwingConstants.TRAILING);
		
				lblFac.setFont(new Font("Arial", Font.BOLD, 16));
						lblUniversit.setBounds(653, 60, 325, 23);
						panel.add(lblUniversit);
				lblFac.setForeground(Home.BLUE_BUTTON_PRESSED);
				lblFac.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblUniversit.setFont(new Font("Arial", Font.PLAIN, 16));
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
			pdfDoc.setBounds(0, -48, 518, 529);
			panel_1.add(pdfDoc);
			pdfDoc.setBorder(null);
			pdfDoc.revalidate();
			pdfDoc.repaint();
			pdfDoc.doOpen(pdfPath);
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
			btnAnnullaModifica.setVisible(false);
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
			
			
			

			panel_3.setLayout(null);
			panel_3.setBorder(null);
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(0, 0, 446, 140);
			panel_3.setWrapStyleWord(true);
			panel_3.setLineWrap(true);
			panel_3.setHighlighter(null);
			//panel_3.setHighlighter(new DefaultHighlighter());
			panel_3.setEditable(false);
			
			lblPreferiti.setVisible(true);
			tf_preferiti.setVisible(false);
			
			
			//panel.remove(suggerimenti);
			//suggerimenti = new Suggerimenti();
			//suggerimenti.setLocation(519, 100);
			//suggerimenti.load(getDocumento());
			//panel.add(suggerimenti);
			
			
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
			//toggleInfo();
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
						lblFac.setBounds(307, 59, 214, 23);
						//separator_2.setBounds(442, 59, 1, 23);
						//lblUniversit.setBounds(453, 59, 120, 23);
						separator_2.setVisible(false);
						lblUniversit.setVisible(false);
						lblPreferiti.setBounds(10, 10, 511, 25);
						btnElimina.setVisible(true);
						btnAttivaModifica.setVisible(true);
						btnTerminaModifica.setVisible(false);
						btnAnnullaModifica.setVisible(false);
						
					} else {
						lblFac.setBounds(307, 59, 325, 23);
						separator_2.setVisible(true);
						lblUniversit.setVisible(true);
						separator_2.setBounds(643, 59, 1, 23);
						lblUniversit.setBounds(653, 59, 325, 23);
						lblPreferiti.setBounds(10, 10, 740, 25);
						btnElimina.setVisible(false);
						btnAttivaModifica.setVisible(false);
						btnTerminaModifica.setVisible(false);
						btnAnnullaModifica.setVisible(false);
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
			lblFac.setText(getDocumento().getCorso().getNome());
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
			//gui.helpers.ListenerHelper.removeListeners(btnAggiungiAiPreferiti);
			//gui.helpers.ListenerHelper.removeListeners(btnRimuoviDaiPreferiti);
			//gui.helpers.ListenerHelper.removeListeners(btnElimina);
			//gui.helpers.ListenerHelper.removeListeners(btnAttivaModifica);
			//gui.helpers.ListenerHelper.removeListeners(btnTerminaModifica);
			//gui.helpers.ListenerHelper.removeListeners(btnAnnullaModifica);
			
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
						//JOptionPane.showMessageDialog(null, "Voto salvato!");
						reload(new DocFlag(getDocumento(),false));
					}
				};
				if (!giaVotato) {
					stelle.getComponent(i).setCursor(
							Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					gui.helpers.ListenerHelper.removeListeners(stelle.getComponent(i));
					stelle.getComponent(i).addMouseListener(m);
				} else {
					stelle.setToolTipText("Hai già votato questo documento");
				}
			}
			Calendar rightNow = Calendar.getInstance();
			Calendar dataNascita = Calendar.getInstance();
			dataNascita.setTime(getDocumento().getProprietario().getDatadinascita());
			lblNewLabel_5.setText(rightNow.get(Calendar.YEAR)-dataNascita.get(Calendar.YEAR)+"");
			lblNewLabel_6.setText(getDocumento().getProprietario().getFacolta().getUniversita().getNome());
			lblNewLabel_7.setText(getDocumento().getProprietario().getFacolta().getNome());
			Image resized = new ImageIcon("."+getDocumento().getProprietario().getImmagine()).getImage().getScaledInstance(92, 92,  java.awt.Image.SCALE_SMOOTH);  
			imgUtente.setIcon(new ImageIcon(resized));
			
			if (flagModifica) {
				lblPreferiti.setVisible(false);
				tf_preferiti.setVisible(true);
				tf_preferiti.setDocument(new JTextFieldLimit(254));
				tf_preferiti.setText(getDocumento().getNome());
				tf_preferiti.setForeground(new Color(6, 121, 159));
				tf_preferiti.setFont(new Font("Arial", Font.BOLD, 18));
				tf_preferiti.setBounds(10, 10, 511, 28);
				//tf_preferiti.setBorder(new LineBorder(new Color(0,255,0),2));
				tf_preferiti.setBorder(new LineBorder(Home.BLUE_BUTTON_PRESSED,1));
				panel.add(tf_preferiti);
				btnAttivaModifica.setVisible(false);
				btnTerminaModifica.setVisible(true);
				btnAnnullaModifica.setVisible(true);
				String tempText = panel_3.getText();
				panel_3.setEditable(true);
				//panel_3.setBorder(new LineBorder(new Color(0,255,0),2));
				panel_3.setBorder(new LineBorder(Home.BLUE_BUTTON_PRESSED,1));
				panel_3.setDocument(new JTextFieldLimit(254));
				panel_3.setHighlighter(new DefaultHighlighter());
				panel_3.setText(tempText);
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
