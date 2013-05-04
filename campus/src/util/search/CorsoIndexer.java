/**
 * 
 */
package util.search;

import java.io.IOException;

import modello_di_dominio.Corso;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;

/**
 * @author mw
 *
 */
public class CorsoIndexer extends AbstractIndexer {
	
	/**
	 * Costruttore
	 */
	public CorsoIndexer(){
		super();
	}
	
	/**
	 * addCorso
	 * @param cor
	 */
	public void addCorso(Corso cor){
		   try{
			   /**
			    * Creo un documento
			    */
			   Document d = new Document();
			   
			   /**
			    * Aggiungo i campi
			    * per ora id e nome
			    * 
			    */
			   d.add(new TextField("Descrizione",cor.getDescrizione(),Field.Store.YES));
			   d.add(new TextField("Nome",cor.getNome(),Field.Store.YES));
			   d.add(new IntField("ID", cor.getID(), Field.Store.YES));
			   
			   iw.addDocument(d);
			   
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }finally{
			   
		   }
	}
	/**
	 * 
	 * @param cor
	 */
	public void removeCorso(Corso cor){
		//TODO:implementare
	}
	
}
