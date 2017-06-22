package org.nanotek;


/**
 * 
 * A functional interface to describe the Actor Role.
 * 	T - Type, especify a certain stereotype given to this actor.
 *  this stereotype can be defined as "which
 *	P - Paper or Role that he plays on the event.
 *	M - Mass of result or Initial Mass.
 *
 */
public interface Actor <T,P,M>{

 public <R> R doAct(P role,T type,M merde);

}