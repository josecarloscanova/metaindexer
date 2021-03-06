package org.nanotek.lucene.manage;

import org.apache.lucene.search.IndexSearcher;
import org.nanotek.Kong;
import org.nanotek.lucene.index.Index;
//import org.nanotek.cms.domain.lucene.config.Index;

/**
 * A class which holds a reference to it's metadata through the Kong.get() method.
 * A "LuceneIndex, holds after configuration the reader Service which process query to 
 * a "Single Lucene Index" this Object holds the parameters to instantite both a 
 * Lucen Reader (IndexSearcher) or a Writer(IndexWriter) Service. 
 * @see org.apache.lucene.index.IndexSearcher
 * @see org.apache.lucene.index.IndexReader
 * @see org.apache.lucene.index.IndexWriter
 * @see org.nanotek.Kong
 * 
 * @author josecanova
 *
 */

@SuppressWarnings("serial")
public class LuceneIndex  implements Kong<Class<LuceneIndex>>{
	
	private IndexSearcher indexSearcher; 
	private Index index; 
	
	public IndexSearcher getIndexSearcher() {
		return indexSearcher;
	}

	public void setIndexSearcher(IndexSearcher indexSearcher) {
		this.indexSearcher = indexSearcher;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	@Override
	public Class<LuceneIndex> get() {
		return LuceneIndex.class;
	}
}
