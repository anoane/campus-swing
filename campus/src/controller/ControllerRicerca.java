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
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;

import util.StringUtility;
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
	 * updateDocumento
	 * @param doc
	 */
	public void updateDocumento(Documento doc){
		rimuoviDocumento(doc);
		aggiungiDocumento(doc);
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
	 * rimuoviCorso
	 * @param cor
	 */
	public void rimuoviCorso(Corso cor){
		corIndex.removeCorso(cor);
		genIndex.removeCorso(cor);
	}
	/**
	 * updateCorso
	 * @param cor
	 */
	public void updateCorso(Corso cor){
		rimuoviCorso(cor);
		aggiungiCorso(cor);
	}
	
	/**
	 * @throws ParseException 
	 * 
	 */
	public Documento[] cercaDocumento(String field,String stQuery) throws ParseException {
		IndexReader ir = null;
		Documento[] docs = null;
		
		try {
			
			ir = DirectoryReader.open(docIndex.getDir());
			IndexSearcher is = new IndexSearcher(ir);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
			
			//QueryParser qp = new QueryParser(Version.LUCENE_42,field,analyzer);
			//Query query= qp.parse(stQuery);
			
			Term term = new Term(field, stQuery);
			Query query = new WildcardQuery(term);
			
			TopDocs result = is.search(query, 2147483647);
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
		IndexReader ir = null;
		Corso[] corsi = null;
		
		try {
			
			ir = DirectoryReader.open(corIndex.getDir());
			IndexSearcher is = new IndexSearcher(ir);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
			
			//QueryParser qp = new QueryParser(Version.LUCENE_42,field,analyzer);
			//Query query= qp.parse(stQuery);
			
			Term term = new Term(field, stQuery);
			Query query = new WildcardQuery(term);
			
			TopDocs result = is.search(query, 2147483647);
			ScoreDoc[] hits = result.scoreDocs;
			
			corsi = new Corso[hits.length];
			
			for(int i= 0; i < hits.length;i++){
				/**
				 * Per prendere un singolo documento ...
				 * 
				 */
				Document doc = is.doc(hits[i].doc);
				corsi[i] = ControllerCorso.getInstance().getCorso(Integer.parseInt(doc.get("ID")));
				
			}
			

			
			/**
			 * Da questo documento ho tutte le informazioni
			 * e posso caricare i risultati, sembra macchinoso ma è veloce e potente
			 * FIXME:sta classe ha troppe responsabilità
			 */
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			
		}
		
		return corsi;
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
	/**
	 * 
	 */
	public void removeDocumento(Documento doc){
		docIndex.removeDoc(doc);
		genIndex.removeDocumento(doc);
	}
	/**
	 * 
	 * @param cor
	 */
	public void removeCorso(Corso cor){
		corIndex.removeCorso(cor);
		genIndex.removeCorso(cor);
	}
}
