package org.nanotek.lucene.search;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.nanotek.lucene.index.Index;
import org.nanotek.lucene.index.info.FieldStat;
//import org.nanotek.cms.domain.lucene.TermStats;
//import org.nanotek.cms.domain.lucene.config.Index;
//import org.nanotek.lucene.index.FieldStat;
import org.nanotek.lucene.index.info.TermStats;

public abstract class LuceneSearcherProvider implements org.nanotek.search.SearcherProvider<IndexSearcher> {

	public abstract List<TermStats> getTermStats(Index index, List<Term> termList);
	
	public abstract FieldStat getFieldStat(Index index, String field);
	
	@Override
	public abstract IndexSearcher getIndexSearcher(Index index) ;
	
	@Override
	public abstract IndexSearcher getIndexSearcher(Index index,
			ExecutorService executorService);
	
}
