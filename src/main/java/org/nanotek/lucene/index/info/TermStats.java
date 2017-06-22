package org.nanotek.lucene.index.info;

import org.apache.lucene.index.Term;
import org.nanotek.Base;
//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.lucene.index.Index;

@SuppressWarnings("serial")
public class TermStats implements Base<Long> {

	private Long id;
	private Index index; 
	private Term term;
	private Long totalTermFrequency; 
	private Integer termFrequency; 
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Long getTotalTermFrequency() {
		return totalTermFrequency;
	}

	public void setTotalTermFrequency(Long totalTermFrequency) {
		this.totalTermFrequency = totalTermFrequency;
	}

	public Integer getTermFrequency() {
		return termFrequency;
	}

	public void setTermFrequency(Integer termFrequency) {
		this.termFrequency = termFrequency;
	}

}
