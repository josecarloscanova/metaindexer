package org.nanotek;

/**
 * Origin interface "used" as super class of event objects. 
 * Since as a common "the cause of the event generator" has same S source.
 * 
 * @author josecanovamauger.
 *
 * @param <S>
 */
public interface Origin<S> {

	public S getSource();
	
}
