package org.nanotek.lucene.util;

import java.io.File;

import org.nanotek.lucene.index.Index;

@SuppressWarnings("serial")
public class LuceneIndexHolder extends BaseHolder<File,Index>
{

	private File document;
	private Index index;
	private String id;

	public LuceneIndexHolder()
	{}
			
	public LuceneIndexHolder(File document , Index index){
		this.document = document; 
		this.index = index; 
	}
	
	public LuceneIndexHolder(File document, Index index, String id) {
		super();
		this.document = document;
		this.id = id;
		this.index = index;
	}
	
	@Override
	public File getKey() {
		return document;
	}

	@Override
	public Index getValue() {
		return index;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
