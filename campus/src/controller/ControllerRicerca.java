/**
 * 
 */
package controller;

import java.io.IOException;

import modello_di_dominio.Corso;
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

import util.search.CorsoIndexer;
import util.search.DocumentoIndexer;
import util.search.GeneralIndexer;

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
	private CorsoIndexer corIndex = new CorsoIndexer();
	private GeneralIndexer genIndex = new GeneralIndexer();
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
		genIndex.addDocumento(doc);
	}
	/**
	 * rimuoviDocumento
	 * @param doc
	 */
	public void rimuoviDocumento(Documento doc){
		docIndex.removeDoc(doc);
		genIndex.removeDocumento(doc);
	}
	/**
	 * aggiungiCorso
	 * @param cor
	 */
	public void aggiungiCorso(Corso cor){
		corIndex.addCorso(cor);
		genIndex.addCorso(cor);
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
				Document doc = is.doc(hits[i].doc);
				docs[i] = ControllerDocumento.getInstance().getDocumento(Integer.parseInt(doc.get("ID")));
				
			}
			

			
			/**
			 * Da questo documento ho tutte le informazioni
			 * e posso caricare i risultati, sembra macchinoso ma è veloce e potente
			 * FIXME:sta classe ha troppe responsabilità
			 */
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch ( ParseException e){
			e.printStackTrace();
		}finally{
			
		}
		
		return docs;
	}
	/**
	 * cercaCorso
	 * @param field
	 * @param stQuery
	 * @return
	 */
	public Corso[] cercaCorso(String field,String stQuery){
		//TODO: Da implementare
		return null;
	}
	/**
	 * ricercaGenerica
	 * @param field
	 * @param stQuery
	 * @return
	 */
	public Object[] ricercaGenerica(String field,String stQuery){
		//TODO: Da implementare
		return null;
	}
	/**
	 * 
	 */
	public void closeIndexingDocumento(){
		docIndex.closeWriter();
	}
	/**
	 * 
	 */
	public void closeIndexingCorso(){
		corIndex.closeWriter();
	}
	/**
	 * 
	 */
	public void closeIndexingGeneral(){
		genIndex.closeWriter();
	}
	/**
	 * Commit changes
	 */
	public void commitIndexingDocumento(){
		docIndex.commit();
	}
	/**
	 * 
	 */
	public void commitIndexingGeneral(){
		genIndex.commit();
	}
	/**
	 * 
	 */
	public void commitIndexingCorso(){
		corIndex.commit();
	}
}
