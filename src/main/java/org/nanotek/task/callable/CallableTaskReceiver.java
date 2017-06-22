package org.nanotek.task.callable;

import org.apache.log4j.Logger;
import org.nanotek.Receiver;
import org.nanotek.Task;
import org.nanotek.task.callable.pipe.PipeTaskDispatcherBase;

public abstract class CallableTaskReceiver<T extends  Task<T,V>,V> implements CallableTask<T,V> , Receiver<V> {


	private static Logger logger = Logger.getLogger(CallableTaskReceiver.class);
	
	public CallableTaskReceiver() {
	}

	@Override
	public V call() {
		V called = null; 
		try {
			logger.debug("Callable Method on Execution Receiver Method Issued");
			called = this.receive();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return called;
	}
}
