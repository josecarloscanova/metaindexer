package org.nanotek.lucene.job.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.index.IndexWriter;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class IndexWriterStepListener implements StepExecutionListener {

	private Log log = LogFactory.getLog(IndexWriterStepListener.class);
	
	private IndexWriter indexWriter;
	
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		
		ExitStatus status = ExitStatus.EXECUTING;
		
		try {
			indexWriter.commit();
			indexWriter.close();
			status =ExitStatus.COMPLETED;
		} catch (Exception e) {
			log.debug("Error During AfterStep: ", e);
			e.printStackTrace();
			status = ExitStatus.UNKNOWN;
		}
		 
		return status;
	}

}
