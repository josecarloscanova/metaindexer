package org.nanotek.dao;

import java.io.Serializable;
import java.util.List;

import org.nanotek.Base;

public interface DAO <T extends Base<?>>{
	
	public <K extends Serializable> T findById( K id);
	public List<T> loadAll(); 
	public void persist(T object);
	public void update (T object); 
	public void delete (T object);
	public List<T> listRecords (Integer firstResult , Integer maxResults);
	
}
