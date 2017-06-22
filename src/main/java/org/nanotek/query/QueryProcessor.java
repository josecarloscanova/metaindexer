package org.nanotek.query;


public interface QueryProcessor<S,C> {

	public void processQuery(S query , C context);
	public <Q extends QueryObject<?>> Q getQueryObject();
	public Integer getMaxNumberOfHits();
	public String getSearchPhrase();
//	public QueryResult<?> getResults();

}
