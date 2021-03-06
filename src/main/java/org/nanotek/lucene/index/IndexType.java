package org.nanotek.lucene.index;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;

public enum IndexType { 
	
	SIMPLEFS (SimpleFSDirectory.class),
	NIOFSDIRECTORY (NIOFSDirectory.class), 
	NMAPDIRECTORY(MMapDirectory.class),
	RAMDIRECTORY (RAMDirectory.class);

	private Class<? extends Directory> clazz; 

	IndexType (Class<? extends Directory> clazz) 
	{ 
		this.clazz = clazz; 
	}
	
	public Class<? extends Directory> getClazz()
	{ 
		return this.clazz;
	}

}