package org.nanotek;
/**
 * 
 * @author josecanovamauger
 *
 * @param <T> Target class which the builder is designed to. 
 * @param <B> Base class used as a "configuration" 
 */
public interface BuilderBase<T,B> extends Builder<T>{

	@Override
	public T build();

	public T build(B baseParameters);

}
