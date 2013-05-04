/**
 * 
 */
package controller;

import java.io.IOException;

import modello_di_dominio.Documento;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;

import util.search.DocumentoIndexer;

/**
 * @author Igor
 *
 */
public class ControllerRicerca extends AbstractController {
	/**
	 * 
	 */
	private static ControllerRicerca instance;
	/**
	 * 
	 */
	private DocumentoIndexer docIndex = new DocumentoIndexer();
	/**
	 * 
	 */
	protected ControllerRicerca() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	public static ControllerRicerca getInstance(){
		if(ControllerRicerca.instance == null)
			ControllerRicerca.instance = new ControllerRicerca();
		return ControllerRicerca.instance;
	}
	/**
	 * aggiungiDocumento
	 * @param doc
	 */
	public void aggiungiDocumento(Documento doc){
		docIndex.addDoc(doc);
	}
	/**
	 * @throws ParseException 
	 * 
	 */
	public Documento[] cercaDocumento(String field,String stQuery) {
		IndexReader ir = null;
		Documento[] docs = null;
		
		try {
			
			ir = DirectoryReader.open(docIndex.getDir());
			IndexSearcher is = new IndexSearcher(ir);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
			
			QueryParser qp = new QueryParser(Version.LUCENE_42,field,analyzer);
			
			Query query= qp.parse(stQuery);
			TopDocs result = is.search(query, null,5);
			ScoreDoc[] hits = result.scoreDocs;
			
			docs = new Documento[hits.length];
			
			for(int i= 0; i < hits.length;i++){
				/**
				 * Per prendere un singolo documento ...
				 * 
				 */
				Document doc = is.doc(hits[0].doc);
				docs[i] = ControllerDocumento.getInstance().getDocumento(Integer.parseInt(doc.get("id")));
				
			}
			

			
			/**
			 * Da questo documento ho tutte le informazioni
			 * e posso caricare i risultati, sembra macchinoso ma è veloce e potente
			 * FIXME:sta classe ha troppe responsabilità
			 */
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch ( ParseException e){
			e.printStackTrace();
		}finally{
			
		}
		
		return docs;
	}
}
