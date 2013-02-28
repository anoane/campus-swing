package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * 
 * Classe Home
 * 
 * classe mostro
 * 
 */
public class Home {

	// TODO: parametrizzare TUTTO
	public JFrame frame;

	private final static MenuButton home = MenuButtonFactory.getInstance()
			.createMenuButton("./newimage/home.png", null, null);
	private final static MenuButton corsi_seguiti = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/corsi_seguiti.png",
					null, null);
	private final static MenuButton preferiti = MenuButtonFactory.getInstance()
			.createMenuButton("./newimage/preferiti.png", null, null);
	private final static MenuButton miei_documenti = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/i_miei_documenti.png",
					null, null);
	private final static MenuButton servizi_esterni = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/servizi_esterni.png",
					null, null);
	private final static JLabel separatore = new JLabel();
	private final static MenuButton notifiche = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/notifiche.png", null, null);
	private final static MenuButton profilo = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/profilo.png", null, null);
	private final static MenuButton impostazioni = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/notifiche.png", null, null);
	private final static MenuButton gestione_stampa = MenuButtonFactory
			.getInstance().createMenuButton("./newimage/notifiche.png",null,null);
	private final static JButton prenotazione_digitalizzazione = new JButton();
	private final static JButton prenotazione_libri = new JButton();

	private final static Color BLUE_BUTTON_UNPRESSED = new Color(67, 136, 204);
	private final static Color BLUE_BUTTON_PRESSED = new Color(46, 93, 140);
	private final static Color BLUE_SEARCH_BAR = new Color(97, 180, 207);

	// le dimensioni utili di un netbook 1024x600 con una barra di sistema
	// standard alta 40pixel
	private final static int MIN_DIMENSION_X = 1024;
	private final static int MIN_DIMENSION_Y = 560;

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

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		/*
		 * frame.addComponentListener(new ComponentListener() { public void
		 * componentResized(ComponentEvent e) { if
		 * ((pannello_intero.getWidth()-2 % scaglione_resize != 0) ||
		 * (pannello_intero.getHeight() % scaglione_resize != 0)) { int
		 * screenWidth = ((pannello_intero.getWidth()-2 + scaglione_resize) /
		 * scaglione_resize) * scaglione_resize; int screenHeight =
		 * ((pannello_intero.getHeight() + scaglione_resize) / scaglione_resize)
		 * * scaglione_resize; frame.setSize(screenWidth, screenHeight);
		 * System.out.println("adsa"); } } public void
		 * componentHidden(ComponentEvent arg0) {} public void
		 * componentMoved(ComponentEvent arg0) {} public void
		 * componentShown(ComponentEvent arg0) {} });
		 */

		// distanza x avvio, distanza y avvio, dimensione x, dimensione y

		// solo se undecorated è false - resizable
		// frame.setBounds(50, 50, 1298, 802);

		// resizable
		frame.setResizable(true);

		// dimensione minima 1024x600 (600-40 perchè c'è la barra)
		frame.setMinimumSize(new Dimension(MIN_DIMENSION_X, MIN_DIMENSION_Y));

		frame.setBounds(0, 0, MIN_DIMENSION_X, screenSize.height - 40);

		// TODO: disabilitare una volta finito lo sviluppo
		// utilizzabili sono 1006x519
		// frame.setBounds(0, 0, 1024, 560);

		// frame.setExtendedState(frame.getExtendedState() |
		// frame.MAXIMIZED_BOTH);

		// SPAZZATURA, per ora la lascio in caso serve più in la da
		// riferimento...
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// toglie la barra dei comandi (close, maximize, minimize)
		// frame.setUndecorated(true);
		// frame.setBounds(50, 50, 1282, 802);

		pannello_intero.setBorder(new LineBorder(Color.BLACK));
		pannello_intero.setBackground(Color.WHITE);
		frame.getContentPane().add(pannello_intero, BorderLayout.CENTER);
		pannello_intero.setLayout(null);

		pannello_intero.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				// MIN_DIMENSION_X + 18 perchè 18 pixel sono per le barre
				// laterali
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
					pannello_verticale.setBounds(dimensione_fill_centro, 0,
							MIN_DIMENSION_X - 18,
							pannello_intero.getHeight() - 130);

					// pannello_interno_servizi_esterni.setBounds(dimensione_fill_centro,
					// 0, pannello_intero.getWidth()+2, 38);
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
					pannello_verticale.setBounds(dimensione_fill_centro, 0,
							MIN_DIMENSION_X - 18,
							pannello_intero.getHeight() - 92);

				}
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

		barra_menu_principale.setBounds(0, 0, MIN_DIMENSION_X - 8, 52);
		pannello_intero.add(barra_menu_principale);

		barra_menu_principale.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_menu_principale.setLayout(null);

		pannello_interno_menu_principale.setBounds(0, 0, MIN_DIMENSION_X - 8,
				52);
		pannello_interno_menu_principale.setBackground(BLUE_BUTTON_UNPRESSED);
		barra_menu_principale.add(pannello_interno_menu_principale);
		pannello_interno_menu_principale.setLayout(null);

		// LOGO LABEL
		JLabel logo = new JLabel();
		logo.setBounds(0, 0, 133, 52);
		pannello_interno_menu_principale.add(logo);
		logo.setIcon(new ImageIcon("./newimage/logo.png"));
		logo.setOpaque(true);
		logo.setBackground(BLUE_BUTTON_UNPRESSED);
		home.setBounds(134, 0, 75, 52);
		pannello_interno_menu_principale.add(home);

		corsi_seguiti.setBounds(211, 0, 129, 52);
		pannello_interno_menu_principale.add(corsi_seguiti);

		preferiti.setBounds(342, 0, 95, 52);
		pannello_interno_menu_principale.add(preferiti);

		miei_documenti.setBounds(439, 0, 163, 52);
		pannello_interno_menu_principale.add(miei_documenti);

		servizi_esterni.setBounds(604, 0, 155, 52);
		pannello_interno_menu_principale.add(servizi_esterni);
		/*
		 * 
		 * servizi_esterni.setIcon(new
		 * ImageIcon("./newimage/servizi_esterni.png"));
		 * 
		 * //SERVIZI ESTERNI servizi_esterni.setFocusPainted(false);
		 * servizi_esterni.setBorderPainted(false);
		 * servizi_esterni.setBackground(BLUE_BUTTON_UNPRESSED);
		 */
		separatore.setBounds(760, 0, 9, 52);
		pannello_interno_menu_principale.add(separatore);
		separatore.setIcon(new ImageIcon("./newimage/separatore.png"));

		// SERPARATORE
		separatore.setOpaque(true);
		separatore.setBackground(BLUE_BUTTON_UNPRESSED);
		
		notifiche.setBounds(770, 0, 52, 52);
		pannello_interno_menu_principale.add(notifiche);

		//profilo.setIcon(new ImageIcon("./newimage/profilo.png"));
		profilo.setBounds(824, 0, 182, 52);
		pannello_interno_menu_principale.add(profilo);
		impostazioni.setBounds(3000, 0, 110, 52);
		pannello_interno_menu_principale.add(impostazioni);

		// IMPOSTAZIONI
		impostazioni.setFocusPainted(false);
		impostazioni.setBorderPainted(false);
		impostazioni.setBackground(BLUE_BUTTON_UNPRESSED);
		impostazioni.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsantiNormali();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("impostazioni", BLUE_BUTTON_PRESSED);
				impostazioni.setBackground(BLUE_BUTTON_PRESSED);

			}
		});
		profilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				profilo.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				profilo.setBackground(getOldButtonColor("profilo"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsantiNormali();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("profilo", BLUE_BUTTON_PRESSED);
				profilo.setBackground(BLUE_BUTTON_PRESSED);

			}
		});
		notifiche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				notifiche.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				notifiche.setBackground(getOldButtonColor("notifiche"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsantiNormali();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("notifiche", BLUE_BUTTON_PRESSED);
				notifiche.setBackground(BLUE_BUTTON_PRESSED);

			}
		});

		servizi_esterni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsanteServiziEsterni();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("servizi_esterni", BLUE_BUTTON_PRESSED);
				servizi_esterni.setBackground(BLUE_BUTTON_PRESSED);

			}
		});
		
		  miei_documenti.addMouseListener(new MouseAdapter() {
		  
		 @Override public void mouseEntered(MouseEvent arg0) {
		  miei_documenti.setBackground(BLUE_BUTTON_PRESSED); }
		  
		  @Override public void mouseExited(MouseEvent arg0) {
		  miei_documenti.setBackground(getOldButtonColor("miei_documenti")); }
		  
		  @Override public void mouseClicked(MouseEvent e) {
		  
		  Home.pulsantiNormali();
		  
		  //assegna il colore di pulsante selezionato
		  setOldButtonColor("miei_documenti",BLUE_BUTTON_PRESSED);
		  miei_documenti.setBackground(BLUE_BUTTON_PRESSED);
		  
		  
		  
		  } });
		  
		  preferiti.addMouseListener(new MouseAdapter() {
		  
		  @Override public void mouseEntered(MouseEvent arg0) {
		  preferiti.setBackground(BLUE_BUTTON_PRESSED); }
		  
		  @Override public void mouseExited(MouseEvent arg0) {
		  preferiti.setBackground(getOldButtonColor("preferiti")); }
		  
		  @Override public void mouseClicked(MouseEvent e) {
		  
		  Home.pulsantiNormali();
		  
		  //assegna il colore di pulsante selezionato
		  setOldButtonColor("preferiti",BLUE_BUTTON_PRESSED);
		  preferiti.setBackground(BLUE_BUTTON_PRESSED);
		  
		  
		  
		  } });
		 
		corsi_seguiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				corsi_seguiti.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				corsi_seguiti.setBackground(getOldButtonColor("corsi_seguiti"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsantiNormali();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("corsi_seguiti", BLUE_BUTTON_PRESSED);
				corsi_seguiti.setBackground(BLUE_BUTTON_PRESSED);

			}
		});
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				home.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				home.setBackground(getOldButtonColor("home"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Home.pulsantiNormali();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("home", BLUE_BUTTON_PRESSED);
				home.setBackground(BLUE_BUTTON_PRESSED);

			}
		});
		barra_ricerca.setBounds(0, 53, MIN_DIMENSION_X - 8, 38);
		pannello_intero.add(barra_ricerca);

		barra_ricerca.setBackground(BLUE_SEARCH_BAR);
		barra_ricerca.setLayout(null);
		pannello_interno_ricerca.setBounds(0, 0, MIN_DIMENSION_X - 8, 38);
		pannello_interno_ricerca.setBackground(BLUE_SEARCH_BAR);
		barra_ricerca.add(pannello_interno_ricerca);
		pannello_interno_ricerca.setLayout(null);
		ricerca_testuale.setBounds(5, 5, 410, 28);
		pannello_interno_ricerca.add(ricerca_testuale);

		ricerca_testuale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ricerca_testuale.getText().equals(" Cerca")) {
					ricerca_testuale.setText(" ");
				}
			}
			/*
			 * @Override public void mouseExited(MouseEvent arg0) { if
			 * (ricerca_testuale.getText().equals("") ||
			 * ricerca_testuale.getText().equals(" ")) {
			 * ricerca_testuale.setText(" Cerca"); } }
			 */
		});
		ricerca_testuale.setText(" Cerca");
		ricerca_testuale.setFont(new Font("Arial", Font.BOLD, 14));
		ricerca_testuale.setBackground(BLUE_SEARCH_BAR);
		ricerca_testuale.setForeground(Color.WHITE);
		ricerca_testuale.setBorder(new LineBorder(Color.WHITE, 2));
		ricerca_testuale.setColumns(10);
		cerca.setBounds(420, 5, 28, 28);
		pannello_interno_ricerca.add(cerca);
		cerca.setIcon(new ImageIcon("./image/search.png"));
		cerca.setFocusPainted(false);
		cerca.setBorderPainted(false);
		cerca.setBackground(BLUE_SEARCH_BAR);
		carica_materiale.setText("Carica materiale");
		carica_materiale.setFont(new Font("Arial", Font.BOLD, 18));
		carica_materiale.setForeground(Color.WHITE);
		carica_materiale.setBounds(817, 5, 184, 28);
		pannello_interno_ricerca.add(carica_materiale);
		carica_materiale.setFocusPainted(false);
		// prenota_digitalizzazione_2.setBorderPainted(false);
		carica_materiale.setBackground(BLUE_BUTTON_UNPRESSED);
		carica_materiale.setBorder(new LineBorder(Color.BLACK, 1));
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
		gestione_stampa
				.setIcon(new ImageIcon("./newimage/gestione_stampa.png"));
		gestione_stampa.setBounds(0, 2, 334, 36);
		pannello_interno_servizi_esterni.add(gestione_stampa);

		gestione_stampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		gestione_stampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		gestione_stampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		gestione_stampa.setFocusPainted(false);
		gestione_stampa.setBorderPainted(false);
		gestione_stampa.setBackground(BLUE_BUTTON_UNPRESSED);
		prenotazione_digitalizzazione.setIcon(new ImageIcon(
				"./newimage/prenota_digitalizzazione.png"));
		prenotazione_digitalizzazione.setBounds(336, 2, 334, 36);
		pannello_interno_servizi_esterni.add(prenotazione_digitalizzazione);
		prenotazione_digitalizzazione.setFocusPainted(false);
		prenotazione_digitalizzazione.setBorderPainted(false);
		prenotazione_digitalizzazione.setBackground(BLUE_BUTTON_UNPRESSED);
		prenotazione_libri
				.setIcon(new ImageIcon("./newimage/prenota_libri.png"));
		prenotazione_libri.setBounds(672, 2, 334, 36);
		pannello_interno_servizi_esterni.add(prenotazione_libri);
		prenotazione_libri.setFocusPainted(false);
		prenotazione_libri.setBorderPainted(false);
		prenotazione_libri.setBackground(BLUE_BUTTON_UNPRESSED);

		pannello_contenuti.setBackground(Color.LIGHT_GRAY);
		pannello_contenuti.setBounds(0, 130, MIN_DIMENSION_X - 8, 386);
		pannello_intero.add(pannello_contenuti);
		pannello_contenuti.setLayout(null);
		pannello_verticale.setBackground(Color.WHITE);

		pannello_verticale.setForeground(Color.BLACK);
		pannello_verticale.setBounds(0, 0, 1006, 386);
		pannello_contenuti.add(pannello_verticale);
		pannello_verticale.setLayout(null);
		prenotazione_libri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				prenotazione_libri.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				prenotazione_libri
						.setBackground(getOldButtonColor("prenotazione_libri"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// resetta tutti i colori di pulsanti precedentemente
				// selezionati
				Home.resetMenu2Colors();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("prenotazione_libri", BLUE_BUTTON_PRESSED);
				prenotazione_libri.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
		prenotazione_digitalizzazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				prenotazione_digitalizzazione
						.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				prenotazione_digitalizzazione
						.setBackground(getOldButtonColor("prenotazione_digitalizzazione"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// resetta tutti i colori di pulsanti precedentemente
				// selezionati
				Home.resetMenu2Colors();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("prenotazione_digitalizzazione",
						BLUE_BUTTON_PRESSED);
				prenotazione_digitalizzazione
						.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
		gestione_stampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				gestione_stampa.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				gestione_stampa
						.setBackground(getOldButtonColor("gestione_stampa"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// resetta tutti i colori di pulsanti precedentemente
				// selezionati
				Home.resetMenu2Colors();

				// assegna il colore di pulsante selezionato
				setOldButtonColor("gestione_stampa", BLUE_BUTTON_PRESSED);
				gestione_stampa.setBackground(BLUE_BUTTON_PRESSED);
			}
		});

	}

	protected static void pulsanteServiziEsterni() {
		// resetta tutti i colori di pulsanti precedentemente selezionati
		Home.resetMenuColors();

		barra_servizi_esterni.setVisible(true);
		barra_servizi_esterni.setBounds(1, 53, pannello_intero.getWidth() - 2,
				38);
		barra_ricerca.setBounds(1, 91, pannello_intero.getWidth() - 2, 38);
		pannello_contenuti.setBounds(1, 129, pannello_intero.getWidth() - 2,
				pannello_intero.getHeight() - 130);
		pannello_verticale.setBounds(pannello_verticale.getBounds().x,
				pannello_verticale.getBounds().y,
				pannello_verticale.getBounds().width,
				pannello_intero.getHeight() - 130);

	}

	protected static void pulsantiNormali() {
		// resetta tutti i colori di pulsanti precedentemente selezionati
		Home.resetMenuColors();
		Home.resetMenu2Colors();

		barra_servizi_esterni.setVisible(false);
		barra_ricerca.setBounds(1, 53, pannello_intero.getWidth() - 2, 38);
		pannello_contenuti.setBounds(1, 91, pannello_intero.getWidth() - 2,
				pannello_intero.getHeight() - 92);
		pannello_verticale.setBounds(pannello_verticale.getBounds().x,
				pannello_verticale.getBounds().y,
				pannello_verticale.getBounds().width,
				pannello_intero.getHeight() - 92);
	}

	protected static Color getOldButtonColor(String nome_pulsante) {
		return oldColorState.get(nome_pulsante);
	}

	protected static void setOldButtonColor(String nome_pulsante, Color colore) {
		oldColorState.put(nome_pulsante, colore);
	}

	/**
	 * 
	 */
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

		notifiche.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("notifiche", BLUE_BUTTON_UNPRESSED);

		profilo.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("profilo", BLUE_BUTTON_UNPRESSED);

		impostazioni.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("impostazioni", BLUE_BUTTON_UNPRESSED);

	}

	protected static void resetMenu2Colors() {
		gestione_stampa.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("gestione_stampa", BLUE_BUTTON_UNPRESSED);

		prenotazione_digitalizzazione.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("prenotazione_digitalizzazione",
				BLUE_BUTTON_UNPRESSED);

		prenotazione_libri.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("prenotazione_libri", BLUE_BUTTON_UNPRESSED);
	}
}
