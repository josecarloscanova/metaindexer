package org.nanotek.lucene.util;

import org.nanotek.Base;

@SuppressWarnings("serial")
public abstract class BaseHolder<K, V> implements Base<String> {
	public abstract K getKey(); 
	public abstract V getValue(); 
}