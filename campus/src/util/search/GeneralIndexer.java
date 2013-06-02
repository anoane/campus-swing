package util.search;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;

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
			   d.add(new TextField("Descrizione", doc.getDescrizione(),Field.Store.YES));
			   d.add(new TextField("Nome",doc.getNome(),Field.Store.YES));
			   d.add(new TextField("Corso",doc.getCorso().getNome(),Field.Store.YES));
			   d.add(new IntField("ID", doc.getID(), Field.Store.YES));
			   
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
			   d.add(new TextField("Descrizione", cor.getDescrizione(),Field.Store.YES));
			   d.add(new TextField("Nome",cor.getNome(),Field.Store.YES));
			   d.add(new TextField("ID", ""+cor.getID(), Field.Store.YES));
			   
			   iw.addDocument(d);
			   
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }finally{
			   
		   }
	}
	
	public void removeDocumento(Documento doc) {
		// TODO Auto-generated method stub
	}
	
	public void removeCorso(Corso cor){
		// TODO auto
	}

}
