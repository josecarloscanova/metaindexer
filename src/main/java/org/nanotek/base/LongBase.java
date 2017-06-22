package org.nanotek.base;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class LongBase implements Base<Long> {

	private Long id; 
	
	public LongBase() 
	{ 
	}
	
	public LongBase(Long id) {
		super();
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id; 
	}

}
