package gui;
import javax.swing.JPanel;
import java.awt.Component;

public final class HomePageBuilder {
	/**
	 * @wbp.factory
	 */
	public static JPanel createJPanel() {
		JPanel panel = new JPanel();
		return panel;
	}
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source arg0 label_6
	 */
	public static JPanel createOrdineStampa(Component arg0) {
		JPanel panel = new JPanel();
		panel.add(arg0);
		return panel;
	}
}