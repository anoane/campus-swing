package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.ControllerUtente;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;
import util.GUIConfig;

public class Home {

	private static JFrame frame;
	
	private static int altezza = 0;
	
	private final static JLabel separatore = new JLabel();
	
	private final static ButtonStandard buttonCreator = new ButtonStandard();
	private final static JButton home = buttonCreator.createButton("home", 134, 0, 75, 52, "./newimage/home.png", false, false, false, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE);
	private final static JButton corsi_seguiti = buttonCreator.createButton("corsi_seguiti", 211, 0, 129, 52, "./newimage/corsi_seguiti.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	private final static JButton preferiti = buttonCreator.createButton("preferiti", 342, 0, 95, 52, "./newimage/preferiti.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	private final static JButton miei_documenti = buttonCreator.createButton("miei_documenti", 439, 0, 163, 52, "./newimage/i_miei_documenti.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	//private final static JButton notifiche = new JButton();
	private final static JButton profilo = buttonCreator.createButton("profilo", 770, 0, 235, 52, "./newimage/profilo_new.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	//private final static JButton impostazioni = buttonCreator.createButton("impostazioni", 3000, 0, 110, 52, "./newimage/impostazioni.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);

	private final static ButtonServiziEsterni buttonCreatorSE = new ButtonServiziEsterni();
	private final static JButton servizi_esterni = buttonCreatorSE.createButton("servizi_esterni", 604, 0, 155, 52, "./newimage/servizi_esterni.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	
	private final static ButtonStandard buttonCreatorBarra = new ButtonStandard();
	private final static JButton gestione_stampa = buttonCreatorBarra.createButton("gestione_stampa", 0, 2, 334, 36, "./newimage/gestione_stampa.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	private final static JButton prenotazione_digitalizzazione = buttonCreatorBarra.createButton("prenotazione_digitalizzazione", 336, 2, 334, 36, "./newimage/prenota_digitalizzazione.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);
	private final static JButton prenotazione_libri = buttonCreatorBarra.createButton("prenotazione_libri", 672, 2, 334, 36, "./newimage/prenota_libri.png", false, false, true, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);

	//BLUE_BUTTON_UNPRESSED = 4425932 (67, 136, 204) 4388CC
	//BLUE_BUTTON_PRESSED = 3038604 (46, 93, 140) 2E5D8C
	//BLUE_SEARCH_BAR = 6403279 (97, 180, 207) 61B4CF
	public final static Color BLUE_BUTTON_UNPRESSED = new Color(GUIConfig.loadXMLInt("BLUE_BUTTON_UNPRESSED","color"));
	public final static Color BLUE_BUTTON_PRESSED = new Color(GUIConfig.loadXMLInt("BLUE_BUTTON_PRESSED","color"));
	public final static Color BLUE_SEARCH_BAR = new Color(GUIConfig.loadXMLInt("BLUE_SEARCH_BAR","color"));

	// le dimensioni utili di un netbook 1024x600 con una barra di sistema
	// standard alta 40pixel
	public final static int OS_BAR_DIMENSION = GUIConfig.loadXMLInt("OS_BAR_DIMENSION","dimension");
	public final static int MIN_DIMENSION_X = GUIConfig.loadXMLInt("MIN_DIMENSION_X","dimension");
	public final static int MIN_DIMENSION_Y = GUIConfig.loadXMLInt("MIN_DIMENSION_Y","dimension")-OS_BAR_DIMENSION;

	private final static TreeMap<String, Color> oldColorState = new TreeMap<String, Color>();
	
	private final static JPanel barra_ricerca = new JPanel();
	private final static JPanel barra_servizi_esterni = new JPanel();
	private final static JPanel pannello_intero = new JPanel();
	private final static JPanel pannello_interno_menu_principale = new JPanel();

	private final static JTextField ricerca_testuale = new JTextField();
	private final static JButton cerca = new JButton();
	private final static JButton carica_materiale = new JButton();
	private final static JPanel barra_menu_principale = new JPanel();

	// private final static int scaglione_resize = 1;

	private final static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private final static JPanel pannello_interno_ricerca = new JPanel();
	private final static JPanel pannello_interno_servizi_esterni = new JPanel();
	private final static JPanel pannello_contenuti = new JPanel();
	private final static JPanel pannello_verticale = new JPanel();
	
	private final static HomePage pagina_home = new HomePage();
	private final static CorsiSeguiti pagina_corsi_seguiti = new CorsiSeguiti();
	private final static Preferiti pagina_preferiti = new Preferiti();
	private final static CaricaMateriale pagina_carica_materiale = new CaricaMateriale();
	private final static MieiDocumenti pagina_miei_documenti = new MieiDocumenti();
	private static Profilo pagina_profilo = null;
	private final static GestioneStampa pagina_gestione_stampa = new GestioneStampa();
	private final static PrenotaDigitalizzazione pagina_prenota_digitalizzazione = new PrenotaDigitalizzazione();
	private final static PrenotaLibro pagina_prenota_libri = new PrenotaLibro();
	private final static RisultatiRicerca pagina_risultati_ricerca = new RisultatiRicerca();
	
	private final static DocumentoPanel documento = new DocumentoPanel(null);
	private final static CorsoPanel corso = new CorsoPanel(null);
	
	private final static TreeMap<String, Pagina> relazionePaginaBottone = new TreeMap<String, Pagina>();
	private final static TreeMap<String, JButton> bottoniMenu = new TreeMap<String, JButton>();
	
	
	public static void setAltezzaDinamica(int a) {
		altezza = a;
	}
	
	public static int getAltezzaDinamica() {
		return altezza;
	}
	
	private final static GroupLayout gl_pannello_verticale = new GroupLayout(pannello_verticale);


	// private final static JPanel drawingPane = new JPanel();
	private final static JScrollPane scroller = new JScrollPane(
			pannello_verticale);

	
	public Home() {
		try {
	    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		initialize();
	}

	private void initialize() {
		
		if (ControllerUtente.getInstance().getUtente(1) != null ) {
			pagina_profilo = new Profilo(ControllerUtente.getInstance().getUtente(1));
		} else {
			pagina_profilo = new Profilo(null);
		}
		
		setFrame(new JFrame());

		getFrame().addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent arg0) {
				// TODO Auto-generated method stub
				Home.forceResizeEvent();
			}
        });
		
		// resizable
		getFrame().setResizable(true);

		// dimensione minima 1024x600 (600-40 perchè c'è la barra)
		getFrame().setMinimumSize(new Dimension(MIN_DIMENSION_X, MIN_DIMENSION_Y));

		// frame.setBounds(0, 0, screenSize.width, screenSize.height-40);
		getFrame().setBounds(0, 0, MIN_DIMENSION_X, screenSize.height - 40);
		getFrame().setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pannello_intero.setBorder(new LineBorder(Color.BLACK));
		pannello_intero.setBackground(Color.WHITE);
		getFrame().getContentPane().add(pannello_intero, BorderLayout.CENTER);
		pannello_intero.setLayout(null);

		pannello_intero.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				Home.spaghettiResize();
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

		// inizializzo i colori
		oldColorState.put("home", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("corsi_seguiti", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("preferiti", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("miei_documenti", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("servizi_esterni", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("notifiche", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("profilo", BLUE_BUTTON_UNPRESSED);
		//oldColorState.put("impostazioni", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("home", BLUE_BUTTON_UNPRESSED);

		oldColorState.put("gestione_stampa", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("prenotazione_digitalizzazione",
				BLUE_BUTTON_UNPRESSED);
		oldColorState.put("prenotazione_libri", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("ricerca_doc", BLUE_SEARCH_BAR);
		oldColorState.put("ricerca_corsi", BLUE_SEARCH_BAR);
		
		relazionePaginaBottone.put("home", pagina_home);
		relazionePaginaBottone.put("corsi_seguiti", pagina_corsi_seguiti);
		relazionePaginaBottone.put("preferiti", pagina_preferiti);
		relazionePaginaBottone.put("carica_materiale", pagina_carica_materiale);
		relazionePaginaBottone.put("cerca",pagina_risultati_ricerca);
		relazionePaginaBottone.put("miei_documenti", pagina_miei_documenti);
		relazionePaginaBottone.put("profilo", pagina_profilo);
		relazionePaginaBottone.put("gestione_stampa", pagina_gestione_stampa);
		relazionePaginaBottone.put("prenotazione_digitalizzazione", pagina_prenota_digitalizzazione);
		relazionePaginaBottone.put("prenotazione_libri", pagina_prenota_libri);
		
		barra_menu_principale.setBounds(0, 0, MIN_DIMENSION_X - 8, 52);
		pannello_intero.add(barra_menu_principale);

		barra_menu_principale.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_menu_principale.setLayout(null);

		pannello_interno_menu_principale.setBounds(0, 0, MIN_DIMENSION_X - 8,
				52);
		pannello_interno_menu_principale.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_menu_principale.add(pannello_interno_menu_principale);
		pannello_interno_menu_principale.setLayout(null);
		
		
		
		/*
		 * Metto tutti i bottoni dentro  
		 */
		bottoniMenu.put("home", home);
		bottoniMenu.put("corsi_seguiti", corsi_seguiti);
		bottoniMenu.put("preferiti", preferiti);
		bottoniMenu.put("miei_documenti", miei_documenti);
		bottoniMenu.put("servizi_esterni", servizi_esterni);
		bottoniMenu.put("profilo", profilo);

/*
		notifiche.setBounds(770, 0, 52, 52);
		notifiche.setIcon(new ImageIcon("./newimage/notifiche.png"));
		notifiche.setFocusPainted(false);
		notifiche.setBorderPainted(false);
		notifiche.setBackground(Home.BLUE_BUTTON_UNPRESSED);
		notifiche.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				notifiche.setBackground(Home.BLUE_BUTTON_PRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				notifiche.setBackground(Home.getOldButtonColor("notifiche"));
			}

			public void mouseClicked(MouseEvent e) {
				Notifiche panel_notifiche = new Notifiche();
				pannello_verticale.add(panel_notifiche);
				//Home.pulsantiNormali();
				//Home.setOldButtonColor("notifiche", Home.BLUE_BUTTON_PRESSED);
				//notifiche.setBackground(Home.BLUE_BUTTON_PRESSED);

			}
		});
		*/
		// LOGO LABEL
		JLabel logo = new JLabel();
		logo.setBounds(0, 0, 133, 52);
		pannello_interno_menu_principale.add(logo);
		logo.setIcon(new ImageIcon("./newimage/logo.png"));
		logo.setOpaque(true);
		logo.setBackground(BLUE_BUTTON_UNPRESSED);
		pannello_interno_menu_principale.add(home);
		pannello_interno_menu_principale.add(corsi_seguiti);
		pannello_interno_menu_principale.add(preferiti);
		pannello_interno_menu_principale.add(miei_documenti);
		pannello_interno_menu_principale.add(servizi_esterni);
		//pannello_interno_menu_principale.add(notifiche);
		pannello_interno_menu_principale.add(profilo);
		//pannello_interno_menu_principale.add(impostazioni);
		pannello_interno_menu_principale.add(separatore);
		separatore.setBounds(760, 0, 9, 52);
		separatore.setIcon(new ImageIcon("./newimage/separatore.png"));
		separatore.setOpaque(true);
		separatore.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_ricerca.setBounds(0, 53, MIN_DIMENSION_X - 8, 38);
		pannello_intero.add(barra_ricerca);
		barra_ricerca.setBackground(BLUE_SEARCH_BAR);
		barra_ricerca.setLayout(null);
		pannello_interno_ricerca.setBounds(0, 0, MIN_DIMENSION_X - 8, 38);
		pannello_interno_ricerca.setBackground(BLUE_SEARCH_BAR);
		barra_ricerca.add(pannello_interno_ricerca);
		pannello_interno_ricerca.setLayout(null);
		getRicercaTestuale().setBounds(5, 5, 410, 28);
		pannello_interno_ricerca.add(getRicercaTestuale());
		getRicercaTestuale().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (getRicercaTestuale().getText().equals(" Cerca")) {
					getRicercaTestuale().setText("");
				}
			}
		});
		getRicercaTestuale().addKeyListener(
				new KeyListener() {

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
							Home.cerca(getRicercaTestuale().getText());
						}
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				}
		);
		getRicercaTestuale().setText(" Cerca");
		getRicercaTestuale().setFont(new Font("Arial", Font.BOLD, 14));
		getRicercaTestuale().setBackground(Home.BLUE_SEARCH_BAR);
		getRicercaTestuale().setForeground(Color.WHITE);
		getRicercaTestuale().setBorder(new LineBorder(Color.WHITE, 2));
		getRicercaTestuale().setColumns(10);
		cerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cerca.setBounds(420, 5, 28, 28);
		pannello_interno_ricerca.add(cerca);
		cerca.setIcon(new ImageIcon("./newimage/search.png"));
		cerca.setFocusPainted(false);
		cerca.setBorderPainted(false);
		cerca.setBackground(Home.BLUE_SEARCH_BAR);
		cerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cerca.setIcon(new ImageIcon("./newimage/search_over.png"));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				cerca.setIcon(new ImageIcon("./newimage/search.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.cerca(getRicercaTestuale().getText());
			}
		});
		carica_materiale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home.openCaricaMateriale(false, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE);
			}
		});
		carica_materiale.setText("Carica documento");
		carica_materiale.setFont(new Font("Arial", Font.BOLD, 18));
		carica_materiale.setForeground(Color.WHITE);
		carica_materiale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carica_materiale.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				carica_materiale.setBackground(Home.BLUE_BUTTON_UNPRESSED);
			}

			public void mouseExited(MouseEvent arg0) {
				carica_materiale.setBackground(new Color(0x2E, 0x5D, 0x8C));
			}
		});
		//carica_materiale.setBounds(817, 5, 184, 28);
		carica_materiale.setBounds(770, 5, 231, 28);
		pannello_interno_ricerca.add(carica_materiale);
		carica_materiale.setFocusPainted(false);
		// prenota_digitalizzazione_2.setBorderPainted(false);
		carica_materiale.setBackground(new Color(0x2E, 0x5D, 0x8C));
		carica_materiale.setBorder(new LineBorder(new Color(0x1D, 0x3B, 0x59), 2));
		barra_servizi_esterni.setBounds(0, 91, MIN_DIMENSION_X - 8, 38);
		pannello_intero.add(barra_servizi_esterni);
		barra_servizi_esterni.setLayout(null);
		barra_servizi_esterni.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_servizi_esterni.setVisible(false);
		pannello_interno_servizi_esterni.setBounds(0, 0, MIN_DIMENSION_X - 8,
				38);
		pannello_interno_servizi_esterni.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_servizi_esterni.add(pannello_interno_servizi_esterni);
		pannello_interno_servizi_esterni.setLayout(null);
		pannello_interno_servizi_esterni.add(gestione_stampa);
		pannello_interno_servizi_esterni.add(prenotazione_digitalizzazione);
		pannello_interno_servizi_esterni.add(prenotazione_libri);
		pannello_contenuti.setBorder(null);
		pannello_contenuti.setBackground(Color.LIGHT_GRAY);
		pannello_contenuti.setBounds(0, 130, 1004, 386);
		pannello_intero.add(pannello_contenuti);
		pannello_contenuti.setLayout(null);
		pannello_verticale.setBorder(null);
		pannello_verticale.setBackground(Color.WHITE);
		pannello_verticale.setForeground(Color.BLACK);
		scroller.setLocation(0, 0);
		scroller.setSize(1004, 386);
		scroller.getVerticalScrollBar().setUnitIncrement(16);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setBorder(BorderFactory.createEmptyBorder());
		scroller.setViewportView(pannello_verticale);
		pannello_verticale.setLayout(gl_pannello_verticale);
		pannello_contenuti.add(scroller, BorderLayout.CENTER);
		
		Home.loadPages(pagina_home, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE);
		home.setBackground(BLUE_BUTTON_PRESSED);
		setOldButtonColor("home", BLUE_BUTTON_PRESSED);
		

	}
	
	protected static void cerca(String text) {
		Home.resetMenuColors();
		Home.resetPagina();
		Home.openRisultatiRicerca(getRicercaTestuale().getText(),false, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE);
	}

	protected static void openCaricaMateriale(final Boolean altezzaDinamica, final Alignment hAlignment, final int hMinSize, final int hPrefSize, final int hMaxSize, final Alignment vAlignment, final int vMinSize, final int vPrefSize, final int vMaxSize) {
		Home.pulsantiNormali();
		pagina_carica_materiale.reload();
		if (altezzaDinamica) {
			Home.loadPages(Home.getPaginaCorrispondente("carica_materiale"), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, Home.getAltezzaDinamica(), vMaxSize);	
		} else {
			Home.loadPages(Home.getPaginaCorrispondente("carica_materiale"), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, vPrefSize, vMaxSize);
		}
	}
	
	protected static void openRisultatiRicerca(String ricerca,final Boolean altezzaDinamica, final Alignment hAlignment, final int hMinSize, final int hPrefSize, final int hMaxSize, final Alignment vAlignment, final int vMinSize, final int vPrefSize, final int vMaxSize) {
		Home.pulsantiNormali();
		pagina_risultati_ricerca.resetPanel(ricerca);
		if (altezzaDinamica) {
			Home.loadPages(Home.getPaginaCorrispondente("cerca"), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, Home.getAltezzaDinamica(), vMaxSize);	
		} else {
			Home.loadPages(Home.getPaginaCorrispondente("cerca"), hAlignment, hMinSize, hPrefSize, hMaxSize, vAlignment, vMinSize, vPrefSize, vMaxSize);
		}
	}
	

	protected static void loadPages(final Pagina pagina, final Alignment hAlignment, final int hMinSize, final int hPrefSize, final int hMaxSize, final Alignment vAlignment, final int vMinSize, int vPrefSize, final int vMaxSize) {
		resetPagina();
		pagina.reload();
		//Autoresize pagine che contengono documenti
		if(pagina.getClass().getName() == "gui.MieiDocumenti" || pagina.getClass().getName() == "gui.Preferiti" || pagina.getClass().getName() == "gui.CorsiSeguiti")
			pagina.getComponents()[0].addComponentListener(new ComponentListener() {
			
				@Override
				public void componentShown(ComponentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void componentResized(ComponentEvent e) {
					gl_pannello_verticale.setHorizontalGroup(
							gl_pannello_verticale.createParallelGroup(hAlignment)
								.addComponent(pagina, hMinSize, hPrefSize, hMaxSize)
						);
						gl_pannello_verticale.setVerticalGroup(
							gl_pannello_verticale.createParallelGroup(vAlignment)
								.addComponent(pagina, vMinSize, pagina.getAltezzaPagina(), vMaxSize)
						);

				}
				
				@Override
				public void componentMoved(ComponentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void componentHidden(ComponentEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		gl_pannello_verticale.setHorizontalGroup(
			gl_pannello_verticale.createParallelGroup(hAlignment)
				.addComponent(pagina, hMinSize, hPrefSize, hMaxSize)
		);
		gl_pannello_verticale.setVerticalGroup(
			gl_pannello_verticale.createParallelGroup(vAlignment)
				.addComponent(pagina, vMinSize, pagina.getAltezzaPagina(), vMaxSize)
		);
		
		//reloadPages(pagina);
		pagina.setVisible(true);
	}

	private static void reloadPages(Pagina pagina) {
		pagina.reload();
	}

	protected static void spaghettiResize() {
			//TODO:check se necessario, reloadPages();
		    int dimensione_fill_centro = ((pannello_intero.getWidth()
					- MIN_DIMENSION_X + 18) / 2);
			barra_menu_principale.setBounds(1, 1,
					pannello_intero.getWidth() - 2, 52);
			pannello_interno_menu_principale.setBounds(
					dimensione_fill_centro, 0,
					pannello_intero.getWidth() + 2, 52);
			if (barra_servizi_esterni.isVisible()) {
				barra_ricerca.setBounds(1, 91,
						pannello_intero.getWidth() - 2, 38);
				barra_servizi_esterni.setBounds(1, 53,
						pannello_intero.getWidth() - 2, 38);
				pannello_contenuti.setBounds(1, 129,
						pannello_intero.getWidth() - 2,
						pannello_intero.getHeight() - 130);
				pannello_interno_servizi_esterni
						.setBounds(dimensione_fill_centro, 0,
								MIN_DIMENSION_X - 18, 38);
				pannello_interno_ricerca.setBounds(dimensione_fill_centro,
						0, MIN_DIMENSION_X - 18, 38);
				scroller.setBounds(dimensione_fill_centro-1, 0,
						MIN_DIMENSION_X - 18,
						pannello_intero.getHeight() - 130);
			} else {
				barra_ricerca.setBounds(1, 53,
						pannello_intero.getWidth() - 2, 38);
				pannello_contenuti.setBounds(1, 91,
						pannello_intero.getWidth() - 2,
						pannello_intero.getHeight() - 92);
				pannello_interno_servizi_esterni
						.setBounds(dimensione_fill_centro, 0,
								MIN_DIMENSION_X - 18, 38);
				pannello_interno_ricerca.setBounds(dimensione_fill_centro,
						0, MIN_DIMENSION_X - 18, 38);
				scroller.setBounds(dimensione_fill_centro-1, 0,
						MIN_DIMENSION_X - 18,
						pannello_intero.getHeight() - 92);
			}
			
	}

	protected static void pulsanteServiziEsterni() {
		//Home.resetMenuColors();
		barra_servizi_esterni.setVisible(true);
		Home.forceResizeEvent();
	}

	protected static void pulsantiNormali() {
		Home.resetMenuColors();
		Home.resetMenu2Colors();
		Home.resetPagina();
		barra_servizi_esterni.setVisible(false);
		Home.forceResizeEvent();
	}
	
	static void forceResizeEvent() {
		/*Rectangle old_rect = getFrame().getBounds();
		int jframe_old_state = getFrame().getExtendedState();
		if (jframe_old_state == JFrame.MAXIMIZED_BOTH) {
			getFrame().revalidate();
			getFrame().repaint();
		} else {
			getFrame().setBounds((int)getFrame().getBounds().getX(),(int)getFrame().getBounds().getY(),(int)getFrame().getBounds().getWidth(),(int)getFrame().getBounds().getHeight()+1);
			getFrame().revalidate();
			getFrame().setBounds(old_rect);
		}*/
		getFrame().revalidate();
		getFrame().repaint();
		spaghettiResize();
	}

	static void resetPagina() {
		Home.unloadDocumento();
		Home.unloadCorso();
		pagina_home.setVisible(false);
		pagina_corsi_seguiti.setVisible(false);
		pagina_preferiti.setVisible(false);
		pagina_carica_materiale.setVisible(false);
		pagina_miei_documenti.setVisible(false);
		pagina_profilo.setVisible(false);
		pagina_gestione_stampa.setVisible(false);
		pagina_prenota_digitalizzazione.setVisible(false);
		pagina_prenota_libri.setVisible(false);
		pagina_risultati_ricerca.setVisible(false);
		pannello_intero.validate();
		pannello_intero.repaint();
	}

	protected static Color getOldButtonColor(String nome_pulsante) {
		return oldColorState.get(nome_pulsante);
	}

	protected static void setOldButtonColor(String nome_pulsante, Color colore) {
		oldColorState.put(nome_pulsante, colore);
	}

	protected static void resetMenuColors() {
		home.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("home", BLUE_BUTTON_UNPRESSED);
		corsi_seguiti.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("corsi_seguiti", BLUE_BUTTON_UNPRESSED);
		preferiti.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("preferiti", BLUE_BUTTON_UNPRESSED);
		miei_documenti.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("miei_documenti", BLUE_BUTTON_UNPRESSED);
		servizi_esterni.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("servizi_esterni", BLUE_BUTTON_UNPRESSED);
		//notifiche.setBackground(BLUE_BUTTON_UNPRESSED);
		//setOldButtonColor("notifiche", BLUE_BUTTON_UNPRESSED);
		profilo.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("profilo", BLUE_BUTTON_UNPRESSED);
		//impostazioni.setBackground(BLUE_BUTTON_UNPRESSED);
		//setOldButtonColor("impostazioni", BLUE_BUTTON_UNPRESSED);
	}

	protected static void resetMenu2Colors() {
		gestione_stampa.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("gestione_stampa", BLUE_BUTTON_UNPRESSED);
		prenotazione_digitalizzazione.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("prenotazione_digitalizzazione",BLUE_BUTTON_UNPRESSED);
		prenotazione_libri.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("prenotazione_libri", BLUE_BUTTON_UNPRESSED);
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		Home.frame = frame;
	}

	public static Pagina getPaginaCorrispondente(String nome_pulsante) {
		return relazionePaginaBottone.get(nome_pulsante);
	}

	public static void unloadDocumento() {
		if (documento!=null) {
			documento.setVisible(false);
		}
	}
	
	public static void unloadCorso() {
		if (corso!=null) {
			corso.setVisible(false);
		}
	}
	
	public static void openDocument(final Boolean altezzaDinamica, Documento doc) {
		//resetPagina();
		//Home.unloadDocumento();
		//TODO:aggiungere parametri del documento
		documento.reload(doc);
		Home.pulsantiNormali();
		Home.loadPages(documento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, documento.getAltezzaPagina(), GroupLayout.PREFERRED_SIZE);	
		/*if (altezzaDinamica) {
			Home.loadPages(documento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getAltezzaDinamica(), GroupLayout.PREFERRED_SIZE);	
		} else {
			Home.loadPages(documento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE);
		}*/
		if (doc.getPath() != null && !doc.getPath().equals("/")) {
			String strTipo = doc.getPath().split("\\.")[1];
			
			switch(strTipo.toLowerCase()){
				case "pdf":
					documento.reload(doc);
					documento.setPDF(doc.getPath());
					break;
				case "ods":
					documento.setOdsDoc(doc.getPath());
					break;
				case "odt":
					documento.setOdtDoc(doc.getPath());
					break;
				default:
					documento.setPDF(null);
			}
			
		}else{
			documento.setPDF(doc.getPath());
		}
		
	}
	
	public static void openCorso(final Boolean altezzaDinamica,Corso c) {
		// TODO Auto-generated method stub
		//resetPagina();
		corso.reload(c);
		Home.pulsantiNormali();
		Home.loadPages(corso, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, corso.getAltezzaPagina(), GroupLayout.PREFERRED_SIZE);	
		/*
		if (getAltezzaDinamica() != 0) {
			Home.loadPages(corso, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, corso.getAltezzaPagina(), GroupLayout.PREFERRED_SIZE);	
		} else {
			Home.loadPages(corso, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE);
		}*/
	}

	public static JTextField getRicercaTestuale() {
		return ricerca_testuale;
	}
	
	public static void getPagina(String pagina){
		Home.pulsantiNormali();
		Home.bottoniMenu.get(pagina).setBackground(BLUE_BUTTON_PRESSED);
		Home.setOldButtonColor(pagina, Home.BLUE_BUTTON_PRESSED);
		Home.loadPages(Home.getPaginaCorrispondente(pagina),Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, Home.getPaginaCorrispondente(pagina).getAltezzaPagina(), GroupLayout.PREFERRED_SIZE);
	}
}
