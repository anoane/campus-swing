package main;

import gui.CorsiSeguiti;
import gui.HomePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.Controller;

public class Home {

	// TODO: parametrizzare TUTTO
	static JFrame frame;

	private final static JButton home = new JButton();
	private final static JButton corsi_seguiti = new JButton();
	private final static JButton preferiti = new JButton();
	private final static JButton miei_documenti = new JButton();
	private final static JButton servizi_esterni = new JButton();
	private final static JLabel separatore = new JLabel();
	private final static JButton notifiche = new JButton();
	private final static JButton profilo = new JButton();
	private final static JButton impostazioni = new JButton();

	private final static JButton gestione_stampa = new JButton();
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
	private final static JPanel pagina_home = new HomePage();
	private final static JPanel pagina_corsi_seguiti = new CorsiSeguiti();
	
	private final static GroupLayout gl_pannello_verticale = new GroupLayout(pannello_verticale);


	// private final static JPanel drawingPane = new JPanel();
	private final static JScrollPane scroller = new JScrollPane(
			pannello_verticale);

	public Home() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();

		// resizable
		frame.setResizable(true);

		// dimensione minima 1024x600 (600-40 perchè c'è la barra)
		frame.setMinimumSize(new Dimension(MIN_DIMENSION_X, MIN_DIMENSION_Y));

		// frame.setBounds(0, 0, screenSize.width, screenSize.height-40);
		frame.setBounds(0, 0, MIN_DIMENSION_X, screenSize.height - 40);

		pannello_intero.setBorder(new LineBorder(Color.BLACK));
		pannello_intero.setBackground(Color.WHITE);
		frame.getContentPane().add(pannello_intero, BorderLayout.CENTER);
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
		oldColorState.put("impostazioni", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("home", BLUE_BUTTON_UNPRESSED);

		oldColorState.put("gestione_stampa", BLUE_BUTTON_UNPRESSED);
		oldColorState.put("prenotazione_digitalizzazione",
				BLUE_BUTTON_UNPRESSED);
		oldColorState.put("prenotazione_libri", BLUE_BUTTON_UNPRESSED);

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
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		home.setIcon(new ImageIcon("./newimage/home.png"));
		home.setBackground(BLUE_BUTTON_UNPRESSED);
		home.setFocusPainted(false);
		home.setBorderPainted(false);
		corsi_seguiti.setBounds(211, 0, 129, 52);
		pannello_interno_menu_principale.add(corsi_seguiti);
		corsi_seguiti.setIcon(new ImageIcon("./newimage/corsi_seguiti.png"));
		corsi_seguiti.setBackground(BLUE_BUTTON_UNPRESSED);
		corsi_seguiti.setFocusPainted(false);
		corsi_seguiti.setBorderPainted(false);
		preferiti.setBounds(342, 0, 95, 52);
		pannello_interno_menu_principale.add(preferiti);
		preferiti.setIcon(new ImageIcon("./newimage/preferiti.png"));

		// PREFERITI
		preferiti.setBackground(BLUE_BUTTON_UNPRESSED);
		preferiti.setFocusPainted(false);
		preferiti.setBorderPainted(false);
		miei_documenti.setBounds(439, 0, 163, 52);
		pannello_interno_menu_principale.add(miei_documenti);
		miei_documenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		miei_documenti
				.setIcon(new ImageIcon("./newimage/i_miei_documenti.png"));

		// MIEI DOCUMENTI
		miei_documenti.setFocusPainted(false);
		miei_documenti.setBorderPainted(false);
		miei_documenti.setBackground(BLUE_BUTTON_UNPRESSED);
		servizi_esterni.setBounds(604, 0, 155, 52);
		pannello_interno_menu_principale.add(servizi_esterni);

		servizi_esterni
				.setIcon(new ImageIcon("./newimage/servizi_esterni.png"));

		// SERVIZI ESTERNI
		servizi_esterni.setFocusPainted(false);
		servizi_esterni.setBorderPainted(false);
		servizi_esterni.setBackground(BLUE_BUTTON_UNPRESSED);
		separatore.setBounds(760, 0, 9, 52);
		pannello_interno_menu_principale.add(separatore);
		separatore.setIcon(new ImageIcon("./newimage/separatore.png"));

		// SERPARATORE
		separatore.setOpaque(true);
		separatore.setBackground(BLUE_BUTTON_UNPRESSED);
		notifiche.setIcon(new ImageIcon("./newimage/notifiche.png"));
		notifiche.setBounds(770, 0, 52, 52);
		pannello_interno_menu_principale.add(notifiche);

		// NOTIFICHE
		notifiche.setFocusPainted(false);
		notifiche.setBorderPainted(false);
		notifiche.setBackground(BLUE_BUTTON_UNPRESSED);
		profilo.setIcon(new ImageIcon("./newimage/profilo.png"));
		profilo.setBounds(824, 0, 182, 52);
		pannello_interno_menu_principale.add(profilo);

		// PROFILO
		profilo.setFocusPainted(false);
		profilo.setBorderPainted(false);
		profilo.setBackground(BLUE_BUTTON_UNPRESSED);
		impostazioni.setBounds(3000, 0, 110, 52);
		pannello_interno_menu_principale.add(impostazioni);

		// IMPOSTAZIONI
		impostazioni.setFocusPainted(false);
		impostazioni.setBorderPainted(false);
		impostazioni.setBackground(BLUE_BUTTON_UNPRESSED);
		impostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				impostazioni.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				impostazioni.setBackground(getOldButtonColor("impostazioni"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Home.pulsantiNormali();
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
				setOldButtonColor("notifiche", BLUE_BUTTON_PRESSED);
				notifiche.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
		servizi_esterni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				servizi_esterni.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				servizi_esterni
						.setBackground(getOldButtonColor("servizi_esterni"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Home.pulsanteServiziEsterni();
				setOldButtonColor("servizi_esterni", BLUE_BUTTON_PRESSED);
				servizi_esterni.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
		miei_documenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				miei_documenti.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				miei_documenti
						.setBackground(getOldButtonColor("miei_documenti"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Home.pulsantiNormali();
				setOldButtonColor("miei_documenti", BLUE_BUTTON_PRESSED);
				miei_documenti.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
		preferiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				preferiti.setBackground(BLUE_BUTTON_PRESSED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				preferiti.setBackground(getOldButtonColor("preferiti"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Home.pulsantiNormali();
				setOldButtonColor("preferiti", BLUE_BUTTON_PRESSED);
				preferiti.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
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
				loadCorsiSeguiti();
				pagina_corsi_seguiti.setVisible(true);
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
				loadHome();
				pagina_home.setVisible(true);
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
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setBorder(BorderFactory.createEmptyBorder());
		scroller.setViewportView(pannello_verticale);
		pannello_verticale.setLayout(gl_pannello_verticale);
		pannello_contenuti.add(scroller, BorderLayout.CENTER);
		
		Home.loadHome();
		
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
				Home.resetMenu2Colors();
				Home.resetPagina();
				Home.forceResizeEvent();
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
				Home.resetMenu2Colors();
				Home.resetPagina();
				Home.forceResizeEvent();
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
				Home.resetMenu2Colors();
				Home.resetPagina();
				Home.forceResizeEvent();
				setOldButtonColor("gestione_stampa", BLUE_BUTTON_PRESSED);
				gestione_stampa.setBackground(BLUE_BUTTON_PRESSED);
			}
		});
	}
	
	private static void loadHome() {
		gl_pannello_verticale.setHorizontalGroup(
				gl_pannello_verticale.createParallelGroup(Alignment.LEADING)
					.addComponent(pagina_home, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
			);
		gl_pannello_verticale.setVerticalGroup(
				gl_pannello_verticale.createParallelGroup(Alignment.LEADING)
					.addComponent(pagina_home, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
			);
		HomePage.reload();
	}
	
	private static void loadCorsiSeguiti() {
		gl_pannello_verticale.setHorizontalGroup(
				gl_pannello_verticale.createParallelGroup(Alignment.LEADING)
					.addComponent(pagina_corsi_seguiti, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
			);
		gl_pannello_verticale.setVerticalGroup(
				gl_pannello_verticale.createParallelGroup(Alignment.LEADING)
					.addComponent(pagina_corsi_seguiti, GroupLayout.PREFERRED_SIZE, 1529, GroupLayout.PREFERRED_SIZE)
			);
		CorsiSeguiti.reload();
	}

	protected static void spaghettiResize() {
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
		Home.resetMenuColors();
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
	
	private static void forceResizeEvent() {
		Rectangle old_rect = frame.getBounds();
		frame.setBounds((int)frame.getBounds().getX(),(int)frame.getBounds().getY(),(int)frame.getBounds().getWidth(),(int)frame.getBounds().getHeight()-1);
		frame.revalidate();
		frame.setBounds(old_rect);
	}

	private static void resetPagina() {
		pagina_home.setVisible(false);
		pagina_corsi_seguiti.setVisible(false);
		
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
		setOldButtonColor("prenotazione_digitalizzazione",BLUE_BUTTON_UNPRESSED);
		prenotazione_libri.setBackground(BLUE_BUTTON_UNPRESSED);
		setOldButtonColor("prenotazione_libri", BLUE_BUTTON_UNPRESSED);
	}
}
