package util;

import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JTextArea;

public class StringUtility {

	  public static int countLines(JTextArea textArea) {
		    AttributedString text = new AttributedString(textArea.getText());
		    FontRenderContext frc = textArea.getFontMetrics(textArea.getFont())
		        .getFontRenderContext();
		    AttributedCharacterIterator charIt = text.getIterator();
		    LineBreakMeasurer lineMeasurer = new LineBreakMeasurer(charIt, frc);
		    float formatWidth = (float) textArea.getSize().width;
		    lineMeasurer.setPosition(charIt.getBeginIndex());

		    int noLines = 0;
		    while (lineMeasurer.getPosition() < charIt.getEndIndex()) {
		      lineMeasurer.nextLayout(formatWidth);
		      noLines++;
		    }

		    return noLines;
		  }
	  
	  public static String truncateLines(JTextArea textArea,int lineNumber) {
			boolean truncate = true;
			String temp = textArea.getText();
			if (StringUtility.countLines(textArea) > lineNumber) {
				for (int i=0; truncate; i++) {
					if (StringUtility.countLines(textArea) <= lineNumber) {
						if (temp.length()>5) {
							temp = temp.substring(0, temp.length()-4).concat("...");
						}
						return temp;
					} else {
						temp = temp.substring(0, temp.length()-5);
						textArea.setText(temp);
					}
				}
			}
			return textArea.getText();
	  }
}
