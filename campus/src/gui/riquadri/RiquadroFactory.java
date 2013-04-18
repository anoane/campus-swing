package gui.riquadri;

import java.awt.Color;

/**
 * 
 * @author mw
 *
 */
/**
 * @author mw
 *
 */
public abstract class RiquadroFactory {
	/**
	 * Background color
	 */
	private static Color preferitoBgColor = new Color(67, 136, 204);
	/**
	 * Border Color
	 */
	private static Color lineBorderColor = new Color(0x1B, 0x32, 0x80);
	/**
	 * 
	 * @return
	 */
	abstract Riquadro createRiquadro();
	/**
	 * @return the lineBorderColor
	 */
	public static Color getLineBorderColor() {
		return lineBorderColor;
	}

	/**
	 * @param lineBorderColor the lineBorderColor to set
	 */
	public static void setLineBorderColor(Color lineBorderColor) {
		RiquadroFactory.lineBorderColor = lineBorderColor;
	}

	/**
	 * @return the preferitoBgColor
	 */
	public static Color getPreferitoBgColor() {
		return preferitoBgColor;
	}

	/**
	 * @param preferitoBgColor the preferitoBgColor to set
	 */
	public static void setPreferitoBgColor(Color preferitoBgColor) {
		RiquadroFactory.preferitoBgColor = preferitoBgColor;
	}
	
}
