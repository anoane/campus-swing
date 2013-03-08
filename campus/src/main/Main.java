package main;
import java.awt.EventQueue;
import java.sql.Timestamp;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Window thread
		EventQueue.invokeLater(new Runnable() {
			@Override
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

}
