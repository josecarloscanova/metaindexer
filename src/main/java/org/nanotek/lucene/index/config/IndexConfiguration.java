package org.nanotek.lucene.index.config;

import org.nanotek.Base;
import org.nanotek.base.Configuration;
import org.nanotek.lucene.index.Index;

/**
 * Not Yet Finished
 * @author josecanova
 *
 */
@SuppressWarnings("serial")
public class IndexConfiguration  implements Configuration<Index> , Base<Long>{

	private Long id; 
	protected Index index; 

	protected IndexConfiguration() 
	{}
	
	protected IndexConfiguration(Index theIndex) 
	{ 
		this.index = theIndex; 
	}
	

	protected IndexConfiguration(Index theIndex, Long id) 
	{ 
		this.index = theIndex; 
		this.id = id;
	}
	
	
	@Override
	public Index get() {
		return index;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id; 
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
}
