package org.nanotek.lucene.analysis;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.nanotek.lucene.config.FieldAnalyzer;

public class PerFieldAnalyzerBuilder implements AnalyzerBuilder<PerFieldAnalyzerWrapper> {

	protected FieldAnalyzer configuration;
	
	private PerFieldAnalyzerBuilder() {
	}
	
	public PerFieldAnalyzerBuilder(FieldAnalyzer configuration)
	{ 
		this.configuration = configuration;
	}

	public PerFieldAnalyzerBuilder setConfiguration(FieldAnalyzer configuration)
	{ 
		PerFieldAnalyzerBuilder builder = new PerFieldAnalyzerBuilder(); 
		builder.configuration = configuration;
		return builder;
	}
	
	@Override
	public PerFieldAnalyzerWrapper build() {
		Map<String,Analyzer> fieldMapAnalyzer = new HashMap<String,Analyzer>(); 
		fieldMapAnalyzer.put(configuration.getTargetField().get(), configuration.getAnalyzer());
		PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new StandardAnalyzer(configuration.getVersion()), fieldMapAnalyzer);
		return wrapper;
	}

}
