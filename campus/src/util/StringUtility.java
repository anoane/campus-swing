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
	  
	  public static String truncateLines(JTextArea textArea) {
			boolean truncate = true;
			String temp = textArea.getText();
			System.out.println(StringUtility.countLines(textArea));
			for (int i=0; truncate; i++) {
				if (textArea.getLineCount() < 2) {
					return temp;
					//descrizione.setText(descrizione.getText().concat("..."));
				} else {
					temp = temp.substring(0, temp.length()-5);
					textArea.setText(temp);
					System.out.println(temp);
				}
			}
			return textArea.getText();
	  }
	
}
