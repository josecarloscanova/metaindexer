package org.nanotek.message;

import java.io.Serializable;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class PipeMessageCallback<K extends Serializable> implements Base<K>{

	private K id;
	
	public PipeMessageCallback() {
	}

	public K getId() {
		return id;
	}
	
	public void setId(K id) {
		this.id = id;
	}

}
