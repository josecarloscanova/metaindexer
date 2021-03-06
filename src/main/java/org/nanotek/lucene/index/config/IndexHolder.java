package org.nanotek.lucene.index.config;

import org.nanotek.Base;
import org.nanotek.Holder;
import org.nanotek.StringKong;
import org.nanotek.lucene.index.Index;

/**
 * An IndexHolder Object describes "A Holder Interface" which is responsible 
 * to Hold a reference of 2 Objects a Pojo Index, and the Concrete Object Index
 * (Which can be any physical description of an "Lucene Index" e.g. IndexReader, IndexWriter)
 * @author josecanovamauger
 *
 * @param <I>
 */

@SuppressWarnings("serial")
public abstract class IndexHolder<I extends Index,S>  implements Base<String>, Holder<S> {


	private I index;
	
	public IndexHolder() {
	}

	public I  getIndex() {
		return index;
	}

	public abstract S getHoldee();

}
