package org.nanotek.lucene.util;

import java.util.EventObject;

@SuppressWarnings("serial")
public class ThreadEvent extends EventObject {

	public ThreadEvent(Object source) {
		super(source);
	}

}
