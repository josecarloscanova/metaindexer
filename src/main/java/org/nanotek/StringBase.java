package org.nanotek;

@SuppressWarnings("serial")
public class StringBase implements Base<String> {

	protected String id; 
	
	public StringBase(String id) {
		super();
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id; 
	}

}
