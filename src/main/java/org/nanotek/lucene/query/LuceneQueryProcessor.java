package org.nanotek.lucene.query;

import org.nanotek.Base;
import org.nanotek.query.QueryContext;
import org.nanotek.query.QueryObject;
import org.nanotek.query.QueryResult;


public class LuceneQueryProcessor<T extends QueryContext>  extends BaseQueryProcessor<T> {

	QueryObject<?> queryObject;
	
	@Override
	public void processQuery(String searchPhrase, T queryContext) {
		queryObject = new BaseQueryObject<Base<?>>(searchPhrase);
		getQueryDispatcher().dispatch(queryObject, queryContext);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <S extends QueryObject<?>> S getQueryObject() {
		return (S) queryObject;
	}
}
