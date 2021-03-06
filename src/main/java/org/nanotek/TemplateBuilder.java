package org.nanotek;

/**
 * A template builder interface, establishes the definition that given I(info)
 * the method shall build the T (that defines a template of a document or a finite vector based on the I object), 
 * which means that for all I that belongs to some domain, the same output of type T shall be produced. 
 * Differently from the Transformer (pattern) which defines a "generic class" performing the transformation, 
 * the TemplateBuilder is generally designed to be constructed at 1 by 1 origin target classes which means 
 * there is a relationship between each I class to T classes (which differs from the Transoformer pattern 
 * that can define a 1 to N relation between the I (origin) and T target.   
 * 
 * 
 * @author josecanova
 *
 * @param <T> the final result  or Template created based on the I (info) object.
 * @param <I> the object that is used to construct the T (template) object. 
 * 
 */

public interface TemplateBuilder<T, I> extends Template<I,T>{

	public T createTemplate (I info);
	
}
