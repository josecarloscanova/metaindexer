package org.nanotek.lucene.manage;

import java.util.List;

import org.apache.lucene.index.IndexWriter;
import org.nanotek.lucene.index.config.IndexConfiguration;
//import org.nanotek.cms.domain.lucene.config.IndexConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//TODO:Fix the Lucene Index manager Service. 
public class LuceneIndexManagerService implements  IndexManager<IndexWriter,IndexConfiguration>,ApplicationContextAware {

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
			this.context = arg0;
	}

	@Override
	public IndexWriter createIndex(IndexConfiguration parameters) {
		return null;
	}

	@Override
	public List<IndexWriter> getIndexes(IndexConfiguration parameters) {
		return null;
	}

	@Override
	public IndexWriter mergeIndexes(List<IndexWriter> indexes) {
		return null;
	}

	@Override
	public void deleteIndex(IndexWriter index) {
	}

}
