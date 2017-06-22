package org.nanotek.lucene.job.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.lucene.job.readers.BaseDAOReader;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class DAOPageChunkListener implements ChunkListener {

	private Log log = LogFactory.getLog(DAOPageChunkListener.class);
	private Integer startPage = 0; 
	private Integer numRecords = 1000; 
	private BaseDAOReader daoReader; 
	
	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}

	@Override
	public void beforeChunk(ChunkContext context) {
		log.debug("STARTING BEFORE CHUNK " + startPage + " | " + numRecords);
		daoReader.setMaxResults(numRecords);
		daoReader.setStartRecord(startPage);
	}

	@Override
	public void afterChunk(ChunkContext context) {
		startPage = startPage + numRecords;
		log.debug("FINISHED AFTER CHUNK " + startPage );
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

	public BaseDAOReader getDaoReader() {
		return daoReader;
	}

	public void setDaoReader(BaseDAOReader daoReader) {
		this.daoReader = daoReader;
	}


}
