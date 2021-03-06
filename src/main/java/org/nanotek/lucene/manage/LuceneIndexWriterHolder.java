package org.nanotek.lucene.manage;

import org.apache.lucene.index.IndexWriter;
//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.lucene.index.Index;
import org.nanotek.lucene.index.config.IndexHolder;

@SuppressWarnings("serial")
public class LuceneIndexWriterHolder extends IndexHolder<Index,IndexWriter> {

	private IndexWriter targetIndex;
	private Index index;
	
	
	public LuceneIndexWriterHolder(IndexWriter targetIndex, Index index) {
		super();
		this.targetIndex = targetIndex;
		this.index = index;
	}

	public Index getIndex() {
		return index;
	}

	@Override
	public IndexWriter getHoldee() {
		return targetIndex;
	}

	@Override
	public void setId(String id) {
		throw new RuntimeException ("Not yet implemented.");
	}

	@Override
	public String getId() {
		throw new RuntimeException ("Not yet implemented.");
	}

	
}
