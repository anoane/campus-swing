/**
 * 
 */
package controller;

/**
 * @author mw
 *
 */
public class ControllerPreferiti extends AbstractController {

	private static ControllerPreferiti instance;
	
	/**
	 * 
	 */
	protected ControllerPreferiti() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControllerPreferiti getInstance(){
		if(ControllerPreferiti.instance == null)
			ControllerPreferiti.instance = new ControllerPreferiti();
		return ControllerPreferiti.instance;
	}
	
	

}
