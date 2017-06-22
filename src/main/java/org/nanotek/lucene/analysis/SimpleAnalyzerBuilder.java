package org.nanotek.lucene.analysis;

import org.apache.lucene.analysis.Analyzer;

/**
 * An immutable class that holds a reference to a specific Analyzer 
 * provided on construction. 
 * 
 * @author java-eclipse
 *
 */
public class SimpleAnalyzerBuilder implements AnalyzerBuilder<Analyzer> {

	private Analyzer analyzer;

	public SimpleAnalyzerBuilder(Analyzer analyzer) {
		super();
		this.analyzer = analyzer;
	}

	@Override
	public Analyzer build() {
		return analyzer;
	}

}
