package org.nanotek.lucene.search;

//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.lucene.index.Index;
//import org.nanotek.query.QueryObject;
//import org.nanotek.query.QueryResult;

public interface LuceneSearcherService {

	public void createIndexSearcher (Index index);
	public void search (String searchPhrase);
//	public QueryResult<?> search (QueryObject<?> query);
	
}
