package org.nanotek.lucene.analysis;
import org.apache.lucene.analysis.Analyzer;
import org.nanotek.Builder; 

/**
 * An Analyzer interface used to configure specific analyzers 
 * for example when given a certain Document, there is a need 
 * to construct a PerfieldAnalyzer.
 * @author java-eclipse
 *
 * @param <T>
 */
public interface AnalyzerBuilder<T extends Analyzer> extends Builder<T> {

	@Override
	public T build();

}
