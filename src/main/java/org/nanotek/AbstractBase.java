package org.nanotek;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AbstractBase <T extends Serializable> implements Base<T>{

	protected T id; 
	
	public AbstractBase(){ 
		id = null;
	}
	
	public AbstractBase(T id) {
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
}
