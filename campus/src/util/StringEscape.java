package util;
import java.text.StringCharacterIterator;
public class StringEscape {

	public static String forLucene(String aText){
		
		String result =aText;
		
		while(result.indexOf('?') == 0 || result.indexOf('*') == 0){
			
			result = result.substring(1);
			
		}
		
		result = result.replace("*", " ");
		result = result.replace("?", " ");
		result = result.replace("&&", " ");
		
		/*
	    final StringBuilder result = new StringBuilder();
	    StringCharacterIterator iterator = new StringCharacterIterator(aText);
	    char character = iterator.current();
	    while (character != StringCharacterIterator.DONE){
	      if( character == '\"' ){
	        result.append("\\\"");
	      }
	      else if(character == '\\'){
	        result.append("\\\\");
	      }
	      else if(character == '/'){
	        result.append("\\/");
	      }
	      else if(character == '+'){
	        result.append("\\+");
	      }
	      else if(character == '-'){
	        result.append("\\-");
	      }
	      else if(character == '&'){
	        result.append("\\&");
	      }
	      else if(character == '|'){
	        result.append("\\|");
	      }
	      else if(character == '*'){
	        result.append(" ");
	      }
	      else {
	        //the char is not a special one
	        //add it to the result as is
	        result.append(character);
	      }
	      character = iterator.next();
	    }
	    */
	    return result;    
	  }
	
}
