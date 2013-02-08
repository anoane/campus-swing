import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Home {

	//TODO: parametrizzare TUTTO
	JFrame frame;
	
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
	
	private final static Color blueButtonUnpressed = new Color(67, 136, 204);
	private final static Color blueButtonPressed = new Color(46, 93, 140);
	private final static Color blueSearchBar = new Color(97, 180, 207);
	
	private final static Color[] oldColorState_home = new Color[1];
	private final static Color[] oldColorState_corsi_seguiti = new Color[1];
	private final static Color[] oldColorState_preferiti = new Color[1];
	private final static Color[] oldColorState_miei_documenti = new Color[1];
	private final static Color[] oldColorState_servizi_esterni = new Color[1];
	private final static Color[] oldColorState_notifiche = new Color[1];
	private final static Color[] oldColorState_profilo = new Color[1];
	private final static Color[] oldColorState_impostazioni = new Color[1];
	
	private final static Color[] oldColorState_gestione_stampa = new Color[1];
	private final static Color[] oldColorState_prenotazione_digitalizzazione = new Color[1];
	private final static Color[] oldColorState_prenotazione_libri = new Color[1];
	
	private final static JPanel barra_ricerca = new JPanel();
	private final static JPanel barra_servizi_esterni = new JPanel();
	private final static JPanel pannello_intero = new JPanel();
	private final static JPanel pannello_interno_menu_principale = new JPanel();
	
	private final static JTextField ricerca_testuale = new JTextField();
	private final static JButton cerca = new JButton();
	private final static JButton carica_materiale = new JButton();
	private final static JPanel barra_menu_principale = new JPanel();

	private final static int scaglione_resize = 1;
	
	private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final static JPanel pannello_interno_ricerca = new JPanel();
	private final static JPanel pannello_interno_servizi_esterni = new JPanel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	    frame.addComponentListener(new ComponentListener() {
	        public void componentResized(ComponentEvent e) {
	            if ((pannello_intero.getWidth()-2 % scaglione_resize != 0) || (pannello_intero.getHeight() % scaglione_resize != 0)) {
	                int screenWidth = ((pannello_intero.getWidth()-2 + scaglione_resize) / scaglione_resize) * scaglione_resize;
	                int screenHeight = ((pannello_intero.getHeight() + scaglione_resize) / scaglione_resize) * scaglione_resize;
	                frame.setSize(screenWidth, screenHeight);
	                System.out.println("adsa");
	            }
	        }
	        public void componentHidden(ComponentEvent arg0) {}
	        public void componentMoved(ComponentEvent arg0) {}
	        public void componentShown(ComponentEvent arg0) {}
	    });
		*/
		
		//distanza x avvio, distanza y avvio, dimensione x, dimensione y
		
		//solo se undecorated è false - resizable
		//frame.setBounds(50, 50, 1298, 802);
		
		//resizable
		frame.setResizable(true);
		
		
		//dimensione minima 1024x600 (600-40 perchè c'è la barra)
		frame.setMinimumSize(new Dimension(1024,560));
		
		//TODO: 0,0, NO centra invece di 0 0!
		//utilizzabili sono 1006x519
		//TODO: riabilitare una volta finito lo sviluppo base a 1024x560
		frame.setBounds(0, 0, screenSize.width, screenSize.height-40);
		
		//TODO: disabilitare una volta finito lo sviluppo
		//utilizzabili sono 1006x519
		//frame.setBounds(0, 0, 1024, 560);
		
		//frame.setExtendedState(frame.getExtendedState() | frame.MAXIMIZED_BOTH);
		
		//SPAZZATURA, per ora la lascio in caso serve più in la da riferimento...
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//toglie la barra dei comandi (close, maximize, minimize)
		//frame.setUndecorated(true);
		//frame.setBounds(50, 50, 1282, 802);
		
		pannello_intero.setBorder(new LineBorder(Color.BLACK));
		pannello_intero.setBackground(Color.WHITE);
		frame.getContentPane().add(pannello_intero, BorderLayout.CENTER);
		pannello_intero.setLayout(null);
		
		pannello_intero.addComponentListener(new ComponentListener() {
	        public void componentResized(ComponentEvent e) {
	            /*if ((pannello_intero.getWidth() % scaglione_resize != 0) || (pannello_intero.getHeight() % scaglione_resize != 0)) {
	                int screenWidth = ((pannello_intero.getWidth() + scaglione_resize) / scaglione_resize) * scaglione_resize;
	                int screenHeight = ((pannello_intero.getHeight() + scaglione_resize) / scaglione_resize) * scaglione_resize;
	                barra_menu_principale.setBounds(1, 1, screenWidth-4, 52);
	        		System.out.println(screenWidth);
	            }*/
	        	
	        	//int screenWidth = ((pannello_intero.getWidth() + scaglione_resize) / scaglione_resize) * scaglione_resize;
	        	//barra_menu_principale.setBounds(1, 1, screenWidth-3, 52);
	        	int dimensione_fill_centro = (pannello_intero.getWidth() - 1016) / 2;
	        	barra_menu_principale.setBounds(1, 1, pannello_intero.getWidth()-2, 52);
	        	pannello_interno_menu_principale.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 52);
	        	if (barra_servizi_esterni.isVisible()) {
	        		barra_ricerca.setBounds(1, 91, pannello_intero.getWidth()-2, 38);
		        	barra_servizi_esterni.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
		        	pannello_interno_servizi_esterni.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 38);
		        	pannello_interno_ricerca.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 38);
		        	//pannello_interno_servizi_esterni.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 38);
	        	} else {
	        		barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
	        		pannello_interno_servizi_esterni.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 38);	
		        	pannello_interno_ricerca.setBounds(dimensione_fill_centro, 0, pannello_intero.getWidth()+2, 38);
	        	}
	        }
	        public void componentHidden(ComponentEvent arg0) {}
	        public void componentMoved(ComponentEvent arg0) {}
	        public void componentShown(ComponentEvent arg0) {}
	    });
		
		
		oldColorState_home[0] = blueButtonUnpressed;
		oldColorState_corsi_seguiti[0] = blueButtonUnpressed;
		oldColorState_preferiti[0] = blueButtonUnpressed;
		oldColorState_miei_documenti[0] = blueButtonUnpressed;
		oldColorState_servizi_esterni[0] = blueButtonUnpressed;
		oldColorState_notifiche[0] = blueButtonUnpressed;
		oldColorState_profilo[0] = blueButtonUnpressed;
		oldColorState_impostazioni[0] = blueButtonUnpressed;
		barra_menu_principale.setBounds(0, 0, 1016, 52);
		pannello_intero.add(barra_menu_principale);
		
		barra_menu_principale.setBackground(blueButtonUnpressed);
		barra_menu_principale.setLayout(null);
		
		pannello_interno_menu_principale.setBounds(0, 0, 1016, 52);
		pannello_interno_menu_principale.setBackground(blueButtonUnpressed);
		barra_menu_principale.add(pannello_interno_menu_principale);
		pannello_interno_menu_principale.setLayout(null);
		
		//LOGO LABEL
		JLabel logo = new JLabel();
		logo.setBounds(4, 0, 133, 52);
		pannello_interno_menu_principale.add(logo);
		logo.setIcon(new ImageIcon("./image/resized_campus.png"));
		logo.setOpaque(true);
		logo.setBackground(blueButtonUnpressed);
		home.setBounds(138, 0, 75, 52);
		pannello_interno_menu_principale.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		home.setIcon(new ImageIcon("./image/resized_home.png"));
		home.setBackground(blueButtonUnpressed);
		home.setFocusPainted(false);
		home.setBorderPainted(false);
		corsi_seguiti.setBounds(215, 0, 129, 52);
		pannello_interno_menu_principale.add(corsi_seguiti);
		corsi_seguiti.setIcon(new ImageIcon("./image/resized_corsi_seguiti.png"));
		corsi_seguiti.setBackground(blueButtonUnpressed);
		corsi_seguiti.setFocusPainted(false);
		corsi_seguiti.setBorderPainted(false);
		preferiti.setBounds(346, 0, 95, 52);
		pannello_interno_menu_principale.add(preferiti);
		preferiti.setIcon(new ImageIcon("./image/resized_preferiti.png"));
		
				
				//PREFERITI
				preferiti.setBackground(blueButtonUnpressed);
				preferiti.setFocusPainted(false);
				preferiti.setBorderPainted(false);
				miei_documenti.setBounds(443, 0, 163, 52);
				pannello_interno_menu_principale.add(miei_documenti);
				miei_documenti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				miei_documenti.setIcon(new ImageIcon("./image/resized_miei_documenti.png"));
				
				//MIEI DOCUMENTI
				miei_documenti.setFocusPainted(false);
				miei_documenti.setBorderPainted(false);
				miei_documenti.setBackground(blueButtonUnpressed);
				servizi_esterni.setBounds(608, 0, 155, 52);
				pannello_interno_menu_principale.add(servizi_esterni);
				
				
				servizi_esterni.setIcon(new ImageIcon("./image/resized_servizi_esterni.png"));
				
				//SERVIZI ESTERNI
				servizi_esterni.setFocusPainted(false);
				servizi_esterni.setBorderPainted(false);
				servizi_esterni.setBackground(blueButtonUnpressed);
				separatore.setBounds(763, 0, 9, 52);
				pannello_interno_menu_principale.add(separatore);
				separatore.setIcon(new ImageIcon("./image/resized_separatore.png"));
				
				//SERPARATORE
				separatore.setOpaque(true);
				separatore.setBackground(blueButtonUnpressed);
				notifiche.setBounds(774, 0, 52, 52);
				pannello_interno_menu_principale.add(notifiche);
				
				//NOTIFICHE
				notifiche.setFocusPainted(false);
				notifiche.setBorderPainted(false);
				notifiche.setBackground(blueButtonUnpressed);
				profilo.setBounds(828, 0, 182, 52);
				pannello_interno_menu_principale.add(profilo);
				
				//PROFILO
				profilo.setFocusPainted(false);
				profilo.setBorderPainted(false);
				profilo.setBackground(blueButtonUnpressed);
				impostazioni.setBounds(3000, 0, 110, 52);
				pannello_interno_menu_principale.add(impostazioni);
				
				//IMPOSTAZIONI
				impostazioni.setFocusPainted(false);
				impostazioni.setBorderPainted(false);
				impostazioni.setBackground(blueButtonUnpressed);
				impostazioni.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						impostazioni.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						impostazioni.setBackground(oldColorState_impostazioni[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_impostazioni[0] = blueButtonPressed;
						impostazioni.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(false);
						barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
					}
				});
				profilo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						profilo.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						profilo.setBackground(oldColorState_profilo[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_profilo[0] = blueButtonPressed;
						profilo.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(false);
						barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
					}
				});
				notifiche.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						notifiche.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						notifiche.setBackground(oldColorState_notifiche[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_notifiche[0] = blueButtonPressed;
						notifiche.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(false);
						barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
					}
				});
				servizi_esterni.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						servizi_esterni.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						servizi_esterni.setBackground(oldColorState_servizi_esterni[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_servizi_esterni[0] = blueButtonPressed;
						servizi_esterni.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(true);
						barra_servizi_esterni.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
						barra_ricerca.setBounds(1, 91, pannello_intero.getWidth()-2, 38);		
					}
				});
				miei_documenti.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						miei_documenti.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						miei_documenti.setBackground(oldColorState_miei_documenti[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_miei_documenti[0] = blueButtonPressed;
						miei_documenti.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(false);
						barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
					}
				});
				preferiti.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						preferiti.setBackground(blueButtonPressed);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						preferiti.setBackground(oldColorState_preferiti[0]);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						//resetta tutti i colori di pulsanti precedentemente selezionati
						Home.resetMenuColors();
						
						//assegna il colore di pulsante selezionato
						oldColorState_preferiti[0] = blueButtonPressed;
						preferiti.setBackground(blueButtonPressed);
						
						barra_servizi_esterni.setVisible(false);
						barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
					}
				});
		corsi_seguiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				corsi_seguiti.setBackground(blueButtonPressed);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				corsi_seguiti.setBackground(oldColorState_corsi_seguiti[0]);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//resetta tutti i colori di pulsanti precedentemente selezionati
				Home.resetMenuColors();
				
				//assegna il colore di pulsante selezionato
				oldColorState_corsi_seguiti[0] = blueButtonPressed;
				corsi_seguiti.setBackground(blueButtonPressed);
				
				barra_servizi_esterni.setVisible(false);
				barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);
			}
		});
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				home.setBackground(blueButtonPressed);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				home.setBackground(oldColorState_home[0]);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//resetta tutti i colori di pulsanti precedentemente selezionati
				Home.resetMenuColors();
				
				//assegna il colore di pulsante selezionato
				oldColorState_home[0] = blueButtonPressed;
				home.setBackground(blueButtonPressed);
				
				barra_servizi_esterni.setVisible(false);
				barra_ricerca.setBounds(1, 53, pannello_intero.getWidth()-2, 38);	
			}
		});
		barra_ricerca.setBounds(0, 53, 1016, 38);
		pannello_intero.add(barra_ricerca);
		
		
		
		barra_ricerca.setBackground(blueSearchBar);
		barra_ricerca.setLayout(null);
		pannello_interno_ricerca.setBounds(0, 0, 1016, 38);
		pannello_interno_ricerca.setBackground(blueSearchBar);
		barra_ricerca.add(pannello_interno_ricerca);
		pannello_interno_ricerca.setLayout(null);
		ricerca_testuale.setBounds(9, 5, 410, 28);
		pannello_interno_ricerca.add(ricerca_testuale);
		
		ricerca_testuale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ricerca_testuale.getText().equals(" Cerca")) {
					ricerca_testuale.setText(" ");
				}
			}
			/*
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (ricerca_testuale.getText().equals("") || ricerca_testuale.getText().equals(" ")) {
					ricerca_testuale.setText(" Cerca");
				}
			}
			*/
		});
		ricerca_testuale.setText(" Cerca");
		ricerca_testuale.setFont(new Font("Arial", Font.BOLD, 14));
		ricerca_testuale.setBackground(blueSearchBar);
		ricerca_testuale.setForeground(Color.WHITE);
		ricerca_testuale.setBorder(new LineBorder(Color.WHITE, 2));
		ricerca_testuale.setColumns(10);
		cerca.setBounds(424, 5, 28, 28);
		pannello_interno_ricerca.add(cerca);
		cerca.setIcon(new ImageIcon("./image/search.png"));
		cerca.setFocusPainted(false);
		cerca.setBorderPainted(false);
		cerca.setBackground(blueSearchBar);
				carica_materiale.setBounds(821, 5, 184, 28);
				pannello_interno_ricerca.add(carica_materiale);
				carica_materiale.setFocusPainted(false);
				//prenota_digitalizzazione_2.setBorderPainted(false);
				carica_materiale.setBackground(blueButtonUnpressed);
				carica_materiale.setBorder(new LineBorder(Color.BLACK, 1));
		barra_servizi_esterni.setBounds(0, 91, 1016, 38);
		pannello_intero.add(barra_servizi_esterni);
		barra_servizi_esterni.setLayout(null);
		barra_servizi_esterni.setBackground(blueButtonUnpressed);
		barra_servizi_esterni.setVisible(false);
		pannello_interno_servizi_esterni.setBounds(0, 0, 1016, 38);
		pannello_interno_servizi_esterni.setBackground(blueButtonUnpressed);
		barra_servizi_esterni.add(pannello_interno_servizi_esterni);
		pannello_interno_servizi_esterni.setLayout(null);
		gestione_stampa.setBounds(4, 2, 334, 36);
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
		gestione_stampa.setBackground(blueButtonUnpressed);
		prenotazione_digitalizzazione.setBounds(340, 2, 334, 36);
		pannello_interno_servizi_esterni.add(prenotazione_digitalizzazione);
		prenotazione_digitalizzazione.setFocusPainted(false);
		prenotazione_digitalizzazione.setBorderPainted(false);
		prenotazione_digitalizzazione.setBackground(blueButtonUnpressed);
		prenotazione_libri.setBounds(676, 2, 334, 36);
		pannello_interno_servizi_esterni.add(prenotazione_libri);
		prenotazione_libri.setFocusPainted(false);
		prenotazione_libri.setBorderPainted(false);
		prenotazione_libri.setBackground(blueButtonUnpressed);
		prenotazione_libri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				prenotazione_libri.setBackground(blueButtonPressed);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				prenotazione_libri.setBackground(oldColorState_prenotazione_libri[0]);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//resetta tutti i colori di pulsanti precedentemente selezionati
				Home.resetMenu2Colors();
				
				//assegna il colore di pulsante selezionato
				oldColorState_prenotazione_libri[0] = blueButtonPressed;
				prenotazione_libri.setBackground(blueButtonPressed);
			}
		});
		prenotazione_digitalizzazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				prenotazione_digitalizzazione.setBackground(blueButtonPressed);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				prenotazione_digitalizzazione.setBackground(oldColorState_prenotazione_digitalizzazione[0]);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//resetta tutti i colori di pulsanti precedentemente selezionati
				Home.resetMenu2Colors();
				
				//assegna il colore di pulsante selezionato
				oldColorState_prenotazione_digitalizzazione[0] = blueButtonPressed;
				prenotazione_digitalizzazione.setBackground(blueButtonPressed);
			}
		});
		gestione_stampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				gestione_stampa.setBackground(blueButtonPressed);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				gestione_stampa.setBackground(oldColorState_gestione_stampa[0]);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//resetta tutti i colori di pulsanti precedentemente selezionati
				Home.resetMenu2Colors();
				
				//assegna il colore di pulsante selezionato
				oldColorState_gestione_stampa[0] = blueButtonPressed;
				gestione_stampa.setBackground(blueButtonPressed);
			}
		});
		

	}

	protected static void resetMenuColors() {
		home.setBackground(blueButtonUnpressed);
		oldColorState_home[0] = blueButtonUnpressed;
		
		corsi_seguiti.setBackground(blueButtonUnpressed);
		oldColorState_corsi_seguiti[0] = blueButtonUnpressed;
		
		preferiti.setBackground(blueButtonUnpressed);
		oldColorState_preferiti[0] = blueButtonUnpressed;
		
		miei_documenti.setBackground(blueButtonUnpressed);
		oldColorState_miei_documenti[0] = blueButtonUnpressed;
		
		servizi_esterni.setBackground(blueButtonUnpressed);
		oldColorState_servizi_esterni[0] = blueButtonUnpressed;
		
		notifiche.setBackground(blueButtonUnpressed);
		oldColorState_notifiche[0] = blueButtonUnpressed;
		
		profilo.setBackground(blueButtonUnpressed);
		oldColorState_profilo[0] = blueButtonUnpressed;
		
		impostazioni.setBackground(blueButtonUnpressed);
		oldColorState_impostazioni[0] = blueButtonUnpressed;
	}
	
	protected static void resetMenu2Colors() {
		gestione_stampa.setBackground(blueButtonUnpressed);
		oldColorState_gestione_stampa[0] = blueButtonUnpressed;
		
		prenotazione_digitalizzazione.setBackground(blueButtonUnpressed);
		oldColorState_prenotazione_digitalizzazione[0] = blueButtonUnpressed;
		
		prenotazione_libri.setBackground(blueButtonUnpressed);
		oldColorState_prenotazione_libri[0] = blueButtonUnpressed;
	}
}
