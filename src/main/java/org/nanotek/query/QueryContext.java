package org.nanotek.query;

import java.util.HashMap;
import java.util.Map;

import org.nanotek.Base;
//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.lucene.index.Index;

@SuppressWarnings("serial")
public class QueryContext implements Base<Long> {

	private Long id;
	private Integer maxHits;
	private Map<ContextKeys, Base<?>> contextVariables;

	public QueryContext() {
		contextVariables = new HashMap<ContextKeys,Base<?>>();
	}

	public QueryContext(Map<ContextKeys,Base<?>> contextMap) {
		contextVariables = contextMap;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMaxHits() {
		if (maxHits == null || maxHits == 0)
			maxHits = ContextKeys.DEFAULT_RESULT_SIZE;
		return maxHits;
	}

	public void setMaxHits(Integer maxHits) {
		this.maxHits = maxHits;
	}

//	public String getSearchPhrase() {
//		return searchPhrase;
//	}
//
//	public void setSearchPhrase(String searchPhrase) {
//		this.searchPhrase = searchPhrase;
//	}

	public  Base<?>  get(ContextKeys key) {
		return contextVariables.get(key);
	}

	public Base<?> put(ContextKeys key, Base<?> value) {
		return contextVariables.put(key, value);
	}

	public Base<?> remove(String key) {
		return contextVariables.remove(key);
	}

	//TODO: Fix the copy of the query context.
	public QueryContext copy()
	{
		QueryContext context = new QueryContext();
		context.setMaxHits(this.getMaxHits());
		context.put(ContextKeys.CURRENT_INDEX, (Index)this.get(ContextKeys.CURRENT_INDEX));
//		context.put(ContextKeys.TARGET_FIELD, (Field)this.get(ContextKeys.TARGET_FIELD));
		return context;
	}

}
