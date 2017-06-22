package org.nanotek.lucene.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class ThreadPoolListener implements ThreadListener{

	Set <Thread> threads;
	Logger log = Logger.getLogger(ThreadPoolListener.class);

	public ThreadPoolListener() 
	{ 
		 threads = Collections.synchronizedSet(new HashSet<Thread>()); 
	}

	@Override
	public synchronized void executed(final ThreadEvent te) {
		notifyEventSystem(); 
		removeThread((Thread) te.getSource()); 
	}
	
	private void notifyEventSystem() {
	}

	public void removeThread(Thread t) { 
		if (threads.contains(t)){ 
			log.debug(Messages.getString("webster.removed.thread"));
			threads.remove(t);
		}else 
			throw new ThreadListenerException ("FODEU");
	}
	
	public boolean isEmpty() {
		return threads.isEmpty();
	}

	public boolean contains(Object o) {
		return threads.contains(o);
	}

	public Iterator<Thread> iterator() {
		return threads.iterator();
	}

	public boolean add(Thread e) {
		return threads.add(e);
	}

	public boolean remove(Object o) {
		return threads.remove(o);
	}

	public int size() {
		return threads.size();
	}

	public boolean containsAll(Collection<?> c) {
		return threads.containsAll(c);
	}
	
}
