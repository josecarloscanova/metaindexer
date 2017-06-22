package org.nanotek.query.event;

import java.util.EventListener;

public interface QueryListener<T extends QueryEvent<?>> extends EventListener{

	public void processed(final T t);

}
