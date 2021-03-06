package org.nanotek.lucene.analysis;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.nanotek.lucene.config.MappedFieldAnalyzer;


public class MapPerFieldAnalyzerBuilder extends PerFieldAnalyzerBuilder {

	private MapPerFieldAnalyzerBuilder(MappedFieldAnalyzer configuration) {
		super(configuration);
	}

	@Override
	public PerFieldAnalyzerWrapper build() {
		Map<String,Analyzer> fieldMapAnalyzer = new HashMap<String,Analyzer>(); 
		fieldMapAnalyzer.put(configuration.getTargetField().get(), configuration.getAnalyzer());
		MappedFieldAnalyzer instance = ((MappedFieldAnalyzer) configuration).get();
		PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(configuration.getAnalyzer(), instance.getFieldMapConfiguration());
		return wrapper;
	}
	
}
