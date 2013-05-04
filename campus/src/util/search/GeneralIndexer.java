package util.search;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;

import modello_di_dominio.Corso;
import modello_di_dominio.Documento;

/**
 * 
 * @author mw
 *
 */
public class GeneralIndexer extends AbstractIndexer {
	/**
	 * 
	 */
	public GeneralIndexer(){
		super();
	}
	/**
	 * 
	 * @param cor
	 */
	public void addDocumento(Documento doc){
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
			   d.add(new TextField("type", "corso",Field.Store.YES));
			   d.add(new TextField("nome",doc.getNome(),Field.Store.YES));
			   d.add(new IntField("id", doc.getID(), Field.Store.YES));
			   
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
			   d.add(new TextField("type", "corso",Field.Store.YES));
			   d.add(new TextField("nome",cor.getNome(),Field.Store.YES));
			   d.add(new IntField("id", cor.getID(), Field.Store.YES));
			   
			   iw.addDocument(d);
			   
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }finally{
			   
		   }
	}
}
