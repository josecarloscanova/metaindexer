package org.nanotek.lucene.query.result;

import org.nanotek.query.QueryResult;

@SuppressWarnings("serial")
public abstract class AbstractQueryResult <T> implements QueryResult<T>{

	protected T result; 
	
	@Override
	public T result() {
		return result;
	}
	
}
