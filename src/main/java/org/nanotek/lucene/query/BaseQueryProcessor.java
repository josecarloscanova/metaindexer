package org.nanotek.lucene.query;

/**
 * Processor EndPoint that executes a given query (searchphrase) against
 * an arbitrary data repository.
 *
 */
import org.apache.lucene.analysis.Analyzer;
import org.nanotek.query.QueryContext;
import org.nanotek.query.QueryDispatcher;
import org.nanotek.query.QueryProcessor;
import org.nanotek.query.QueryResult;

public abstract class BaseQueryProcessor <T extends QueryContext> implements QueryProcessor<String, T> {

	private String searchPhrase;
	private Integer maxNumberOfHits = 0;
	private Analyzer analyzer;
	private QueryDispatcher<T> queryDispatcher;
	protected T queryContext; 

	@Override
	public abstract void processQuery(String searchPhrase, T queryContext);

//	@Override 
//	public abstract QueryResult<?> getResults();
	
	public String getSearchPhrase() {
		return searchPhrase;
	}


	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}


	public Integer getMaxNumberOfHits() {
		return maxNumberOfHits;
	}


	public void setMaxNumberOfHits(Integer maxNumberOfHits) {
		this.maxNumberOfHits = maxNumberOfHits;
	}


	public Analyzer getAnalyzer() {
		return analyzer;
	}


	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}


	public QueryDispatcher<T> getQueryDispatcher() {
		return queryDispatcher;
	}


	public void setQueryDispatcher(QueryDispatcher<T> queryDispatcher) {
		this.queryDispatcher = queryDispatcher;
	}

}
