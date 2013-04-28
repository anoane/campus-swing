package gui.riquadri;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modello_di_dominio.Utente;

public class RiquadroUtenteDoc extends JPanel{
	
	private JLabel immagine;
	private JLabel universita;
	private JLabel facolta;
	private JLabel nome;

	public RiquadroUtenteDoc(Utente u){
		setSize(178,240);
		setLayout(null);
		
		immagine = new JLabel();
		//.setIcon(new ImageIcon(u.getImmagine()));
		immagine.setBounds(5, 5, 100, 100);
		immagine.setBackground(Color.LIGHT_GRAY);
		nome = new JLabel(u.getNome()+" "+u.getCognome());
		nome.setBounds(5, 120,168, 30);
		
		universita = new JLabel("Università: "+u.getFacolta().getUniversita().getNome());
		universita.setBounds(5, 160,168, 30);
		
		facolta = new JLabel("Facoltà: "+u.getFacolta().getNome());
		facolta.setBounds(5, 200,168, 30);
		
		
		add(immagine);
		add(nome);
		add(universita);
		add(facolta);
		
	}

}
