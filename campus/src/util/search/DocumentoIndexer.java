/**
 * 
 */
package util.search;

import java.io.IOException;

import modello_di_dominio.Documento;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 * FIXME:Da migliorare -> Work in progress o come direbbe il Fab WIP
 * @author mw
 *
 */
public class DocumentoIndexer extends AbstractIndexer {
	
	/**
	 * Costruttore
	 * @throws IOException 
	 */
	public DocumentoIndexer()  {
		super();
		
	}
    
   /**
    * Aggiungo un file all'index
    * @param doc
    */
   public void addDoc(Documento doc){
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
		   d.add(new TextField("Descrizione",doc.getDescrizione(),Field.Store.YES));
		   d.add(new TextField("Nome",doc.getNome(),Field.Store.YES));
		   d.add(new IntField("ID", doc.getID(), Field.Store.YES));
		   
		   iw.addDocument(d);
		   
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }finally{
		   
	   }
   }

	public void removeDoc(Documento doc) {
		// TODO Auto-generated method stub
		 
	}

}
