package org.nanotek.lucene.manage;

import org.nanotek.lucene.index.config.IndexHolder;

//import org.nanotek.cms.domain.lucene.IndexHolder;

public interface IndexWriterService <T,I>{
	public void indexDocument (T source);
	public IndexHolder<?,?> getIndexHolder(I index) throws IndexServiceException;
}
