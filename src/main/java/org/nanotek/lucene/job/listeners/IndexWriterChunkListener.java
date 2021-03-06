package org.nanotek.lucene.job.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.index.IndexWriter;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;


public class IndexWriterChunkListener implements ChunkListener {

	private IndexWriter indexWriter;
	private static  Log log = LogFactory.getLog(IndexWriterChunkListener.class); 

	@Override
	public void beforeChunk(ChunkContext context) {
	}

	@Override
	public void afterChunk(ChunkContext context) {
		try { 
			indexWriter.commit();
		}catch (Exception ex) 
		{ 
			log .debug("ERROR ON CHUNK :" , ex);
			if (OutOfMemoryError.class.equals(ex.getClass()))
			{ 
				try { 
					indexWriter.close();
				}catch (Exception ex1){}				
			}
		}
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

}
