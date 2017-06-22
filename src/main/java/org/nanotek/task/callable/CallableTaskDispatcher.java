package org.nanotek.task.callable;

import org.nanotek.Dispatcher;
import org.nanotek.Task;

public abstract class CallableTaskDispatcher <T extends  Task<T,V>,V> implements CallableTask<T,V> , Dispatcher<V> {


		public CallableTaskDispatcher() {
		}

}
