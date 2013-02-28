/**
 * 
 */
package controller;

/**
 * @author Igor
 * 
 * Router Controller
 * 
 * Questa classe indirizza correttamente le richieste al controller specificato
 *
 */
public class RouterController extends Controller {
	/**
	 * 
	 */
	private static RouterController instance = new RouterController();
	/**
	 * 
	 */
	private RouterController(){
		super();
	}
	/**
	 * 
	 * @return instance
	 */
	public static RouterController getInstance(){
		return instance;
	}
	/**
	 * 
	 */
	public void doAction(String controller,String action){
		
	}
	
}
