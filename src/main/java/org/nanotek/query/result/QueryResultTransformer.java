package org.nanotek.query.result;

import org.apache.commons.collections4.Transformer;
import org.nanotek.lucene.query.result.ResultBase;
import org.nanotek.query.QueryResult;


public interface QueryResultTransformer<R extends ResultBase<?>,T extends QueryResult<?>> extends Transformer<T,R> {

	@Override
	R transform(T input);
	
}
