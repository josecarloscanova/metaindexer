package org.nanotek.query;

import org.nanotek.Actor;

public interface QueryActor <T extends QueryProcessor<?,?>,P extends QueryContext,M extends QueryObject<?>> extends Actor<T,P,M> {
	@Override
	public <R> R doAct(P role, T type, M merde);
}
