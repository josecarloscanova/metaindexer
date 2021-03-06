package org.nanotek.query;

public enum ContextKeys {

	LAST_SCORED_DOC ("last_scored_docs"),
	PAGE_SIZE ("page_size"),
	CURRENT_INDEX ("currentIndex"),
	TOP_DOCS ("top_docs"),
	TARGET_FIELD ("TextData"), 
	HOOKED_EVENT ("HookedEvent");

	public static final Integer DEFAULT_RESULT_SIZE = 20;
	private String contextValue; 

	private ContextKeys(String val) 
	{ 
		this.contextValue = val;
	}

	public String getContextValue() {
		return contextValue;
	}
}
