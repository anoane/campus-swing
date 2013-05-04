package util.search;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public abstract class AbstractIndexer {
	
	protected Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
	protected IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);
	protected IndexWriter iw;
	protected Directory dir = new RAMDirectory();
	/**
	 * 
	 */
	public AbstractIndexer(){
		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
		
		try {
			iw = new IndexWriter(dir,iwc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
    public IndexWriter getIndexWriter() {
        return iw;
   }   
    /**
     * getDir
     * @return dir
     */
    public Directory getDir(){
    	return dir;
    }
    
    /**
     * Close Writer
     */
    public void closeWriter(){
 	   try {
 		iw.forceMerge(1); 
 		iw.close();
 	   }catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 	   }
    }
    /**
     * 
     */
    public void commit(){
    	try{
    		iw.commit();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}
