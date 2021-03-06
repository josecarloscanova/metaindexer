package org.nanotek.lucene.index;

import org.nanotek.Base;

/**
 * Store defines a "location", a triple with name, URI and location (all strings)
 * used to define on IndexSearcher where to find a specific index (at opposite on 
 * IndexWriter where the Index is not created on multiple locations - just 1 single location). 
 * Used to simplify when about to open a IndexSearcher. 
 * 
 * 
 * @author josecanovamauger.
 *
 */
@SuppressWarnings("serial")
public class Store implements Base<Long> {

	private Long id; 
	
	private String storeName; 
	
	private String storeURI;  
	
	private String storeLocation; 
	
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public Long getId() {
		return id;
	}

	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreURI() {
		return storeURI;
	}


	public void setStoreURI(String storeURI) {
		this.storeURI = storeURI;
	}


	public String getStoreLocation() {
		return storeLocation;
	}


	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}


}
