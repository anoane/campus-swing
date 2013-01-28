import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
import javax.swing.JSeparator;
import javax.swing.JTextField;

//test reiss pull git
public class Home {

	//TODO: parametrizzare TUTTO
	private JFrame frame;
	
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
	private final static JTextField ricerca_testuale = new JTextField();
	private final static JButton cerca = new JButton();
	private final static JButton prenota_digitalizzazione_2 = new JButton();
	
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
		//distanza x avvio, distanza y avvio, dimensione x, dimensione y
		
		//solo se undecorated è false - resizable
		//frame.setBounds(50, 50, 1298, 802);
		
		//unresizable
		frame.setResizable(false);
		//rimangono 1280x720 pixel escludendo i bordi
		frame.setBounds(50, 50, 1288, 751);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//toglie la barra dei comandi (close, maximize, minimize)
		//frame.setUndecorated(true);
		//frame.setBounds(50, 50, 1282, 802);
		
		JPanel pannello_intero = new JPanel();
		pannello_intero.setBorder(new LineBorder(Color.BLACK));
		pannello_intero.setBackground(Color.WHITE);
		frame.getContentPane().add(pannello_intero, BorderLayout.CENTER);
		pannello_intero.setLayout(null);
		oldColorState_home[0] = blueButtonUnpressed;
		oldColorState_corsi_seguiti[0] = blueButtonUnpressed;
		oldColorState_preferiti[0] = blueButtonUnpressed;
		oldColorState_miei_documenti[0] = blueButtonUnpressed;
		oldColorState_servizi_esterni[0] = blueButtonUnpressed;
		oldColorState_notifiche[0] = blueButtonUnpressed;
		oldColorState_profilo[0] = blueButtonUnpressed;
		oldColorState_impostazioni[0] = blueButtonUnpressed;
		
		JPanel barra_menu_principale = new JPanel();
		barra_menu_principale.setBackground(blueButtonUnpressed);
		barra_menu_principale.setBounds(1, 1, 1280, 57);
		pannello_intero.add(barra_menu_principale);
		barra_menu_principale.setLayout(null);
		
		//LOGO LABEL
		JLabel logo = new JLabel();
		logo.setBounds(0, 0, 163, 57);
		barra_menu_principale.add(logo);
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("pressed");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("released");
			}
		});
		logo.setIcon(new ImageIcon("./image/resized_campus.png"));
		logo.setOpaque(true);
		logo.setBackground(blueButtonUnpressed);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		//SE NON SI VUOLE L'EFFETTO ON PRESSED CHE SBIANCA IL PULSANTE
		//BASTA TRASFORMARE JButton in JPanel
		//AGGIUGNERE .setOpaque(true);
		//TOGLIERE .setFocusPainted(false);
		//TOGLIERE .setBorderPainted(false);
		
		//HOME BUTTON
		home.setBounds(163, 0, 93, 57);
		home.setIcon(new ImageIcon("./image/resized_home.png"));
		home.setBackground(blueButtonUnpressed);
		home.setFocusPainted(false);
		home.setBorderPainted(false);
		barra_menu_principale.add(home);
		corsi_seguiti.setIcon(new ImageIcon("./image/resized_corsi_seguiti.png"));

		
		corsi_seguiti.setBounds(258, 0, 161, 57);
		corsi_seguiti.setBackground(blueButtonUnpressed);
		corsi_seguiti.setFocusPainted(false);
		corsi_seguiti.setBorderPainted(false);
		barra_menu_principale.add(corsi_seguiti);
		preferiti.setIcon(new ImageIcon("./image/resized_preferiti.png"));

		
		//PREFERITI
		preferiti.setBackground(blueButtonUnpressed);
		preferiti.setFocusPainted(false);
		preferiti.setBorderPainted(false);
		preferiti.setBounds(421, 0, 119, 57);
		barra_menu_principale.add(preferiti);
		
		miei_documenti.setBounds(542, 0, 184, 57);
		barra_menu_principale.add(miei_documenti);
		
		//MIEI DOCUMENTI
		miei_documenti.setFocusPainted(false);
		miei_documenti.setBorderPainted(false);
		miei_documenti.setBackground(blueButtonUnpressed);
		
		
		servizi_esterni.setIcon(new ImageIcon("./image/resized_servizi_esterni.png"));
		servizi_esterni.setBounds(728, 0, 185, 57);
		barra_menu_principale.add(servizi_esterni);
		
		//SERVIZI ESTERNI
		servizi_esterni.setFocusPainted(false);
		servizi_esterni.setBorderPainted(false);
		servizi_esterni.setBackground(blueButtonUnpressed);
		separatore.setIcon(new ImageIcon("./image/resized_separatore.png"));
		separatore.setBounds(913, 0, 11, 57);
		barra_menu_principale.add(separatore);
		
		//SERPARATORE
		separatore.setOpaque(true);
		separatore.setBackground(blueButtonUnpressed);
		notifiche.setBounds(924, 0, 70, 57);
		barra_menu_principale.add(notifiche);
		
		//NOTIFICHE
		notifiche.setFocusPainted(false);
		notifiche.setBorderPainted(false);
		notifiche.setBackground(blueButtonUnpressed);
		profilo.setBounds(996, 0, 149, 57);
		barra_menu_principale.add(profilo);
		
		//PROFILO
		profilo.setFocusPainted(false);
		profilo.setBorderPainted(false);
		profilo.setBackground(blueButtonUnpressed);
		impostazioni.setBounds(1147, 0, 133, 57);
		barra_menu_principale.add(impostazioni);
		
		//IMPOSTAZIONI
		impostazioni.setFocusPainted(false);
		impostazioni.setBorderPainted(false);
		impostazioni.setBackground(blueButtonUnpressed);
		
		
		
		barra_ricerca.setBackground(blueSearchBar);
		barra_ricerca.setBounds(1, 58, 1280, 38);
		pannello_intero.add(barra_ricerca);
		barra_ricerca.setLayout(null);
		
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
		ricerca_testuale.setBounds(5, 5, 386, 28);
		barra_ricerca.add(ricerca_testuale);
		ricerca_testuale.setColumns(10);
		cerca.setIcon(new ImageIcon("./image/search.png"));
		cerca.setBounds(396, 5, 28, 28);
		cerca.setFocusPainted(false);
		cerca.setBorderPainted(false);
		cerca.setBackground(blueSearchBar);
		
		barra_ricerca.add(cerca);

		
		prenota_digitalizzazione_2.setBounds(1080, 5, 195, 28);
		prenota_digitalizzazione_2.setFocusPainted(false);
		//prenota_digitalizzazione_2.setBorderPainted(false);
		prenota_digitalizzazione_2.setBackground(blueButtonUnpressed);
		prenota_digitalizzazione_2.setBorder(new LineBorder(Color.BLACK, 1));
		
		barra_ricerca.add(prenota_digitalizzazione_2);
		barra_servizi_esterni.setLayout(null);
		barra_servizi_esterni.setBackground(blueButtonUnpressed);
		barra_servizi_esterni.setBounds(1, 58, 1280, 38);
		barra_servizi_esterni.setVisible(false);
		pannello_intero.add(barra_servizi_esterni);
		

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
		gestione_stampa.setBounds(0, 2, 425, 36);
		gestione_stampa.setFocusPainted(false);
		gestione_stampa.setBorderPainted(false);
		gestione_stampa.setBackground(blueButtonUnpressed);
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
		barra_servizi_esterni.add(gestione_stampa);
		
		prenotazione_digitalizzazione.setBounds(427, 2, 425, 36);
		prenotazione_digitalizzazione.setFocusPainted(false);
		prenotazione_digitalizzazione.setBorderPainted(false);
		prenotazione_digitalizzazione.setBackground(blueButtonUnpressed);
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
		barra_servizi_esterni.add(prenotazione_digitalizzazione);
		
		prenotazione_libri.setBounds(854, 2, 426, 36);
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
		barra_servizi_esterni.add(prenotazione_libri);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 96, 1280, 38);		
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);
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
				barra_ricerca.setBounds(1, 58, 1280, 38);	
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
