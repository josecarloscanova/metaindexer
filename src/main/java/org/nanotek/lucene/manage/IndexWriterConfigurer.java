package org.nanotek.lucene.manage;

import java.util.Map;

import org.apache.lucene.index.IndexWriter;
import org.nanotek.Base;

public class IndexWriterConfigurer implements Configurator<IndexWriter,Map<String,Base<?>>>{

	@Override
	public IndexWriter configure(Map<String, Base<?>> context) {
		return null;
	}

}
