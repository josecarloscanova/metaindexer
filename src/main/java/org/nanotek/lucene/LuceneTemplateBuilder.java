package org.nanotek.lucene;

import org.apache.lucene.document.Document;
import org.nanotek.TemplateBuilder;

/**
 * A Lucene Template Builder, will be used to define the contract for 
 * ItemWriters, responsible to create 'Lucene Documents' for Field addition. 
 * 
 * @see org.apache.lucene.document.Document 
 * 
 * @author josecanovamauger
 * 
 * @param <I> A Unknown type object that will contain 
 * the information required to create the Lucene Document. 
 * 
 */
public interface LuceneTemplateBuilder <I> extends TemplateBuilder <Document , I>{
	@Override
	public Document createTemplate (I info);
}
