package org.nanotek.lucene.job.readers;

import java.util.List;

import org.nanotek.Base;
import org.nanotek.dao.DAO;
import org.springframework.batch.item.ItemReader;

public interface BaseDAOReader<T extends List<Base<?>>> extends  ItemReader<List<?>>{

	public abstract void setStartRecord(Integer startIndex);

	public abstract void setMaxResults(Integer maxResults);
	
	public void setDAO(DAO<Base<?>> dao);

}