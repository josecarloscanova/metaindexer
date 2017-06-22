package org.nanotek.lucene.search.local;

import org.apache.lucene.search.IndexSearcher;
import org.nanotek.lucene.index.Index;
//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.lucene.query.LuceneQueryProcessor;
import org.nanotek.lucene.search.LuceneSearcherService;
import org.nanotek.query.QueryContext;
import org.nanotek.query.QueryDispatcher;
import org.nanotek.query.QueryObject;
import org.nanotek.query.QueryProcessor;
import org.nanotek.query.QueryResult;
import org.nanotek.query.event.QueryEvent;
import org.nanotek.query.event.QueryListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SuppressWarnings("unused")
public class LocalSearcherService implements LuceneSearcherService , ApplicationContextAware{

	private ApplicationContext applicationContext; 
	private IndexSearcher indexSearcher;
	private boolean searcherReady = false; 
	
	public boolean isSearcherReady() {
		return searcherReady;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void createIndexSearcher(Index index) {
		IndexSearcherProvider searcherProvider = (IndexSearcherProvider) applicationContext.getBean("indexSearcherProvider");
		indexSearcher = searcherProvider.getIndexSearcher(index);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void search(String searchPhrase) {
		QueryContext queryContext = (QueryContext) applicationContext.getBean("queryContext");		
		QueryProcessor <String,QueryContext> processor = (LuceneQueryProcessor<QueryContext>) applicationContext.getBean("queryProcessor");
		processor.processQuery(searchPhrase, queryContext);
	}

}
