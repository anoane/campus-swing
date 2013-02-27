/**
 * 
 */
package utils;

import java.util.TreeMap;

/**
 * @author mw
 *
 */
public class Configuration extends TreeMap<String, String>{

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  Unique instance of configuration 
	 */
	private static Configuration instance;
	
	/**
	 *  Costruttore privato
	 */
	protected Configuration() {
		
		super();
		
		//TODO:Aggiungere un processo di inizializzazione
		
	}
	
	/**
	 * getInstance
	 * 
	 * @return Configuration
	 */
	public static Configuration getInstance() {
		
		if(instance == null){
			instance = new Configuration();
		}
		
		return instance;
		
	}
	
}
