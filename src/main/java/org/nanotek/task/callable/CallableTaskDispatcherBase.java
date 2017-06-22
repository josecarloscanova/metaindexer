package org.nanotek.task.callable;

import org.nanotek.Base;
//import org.nanotek.BaseTask;
import org.nanotek.task.ConcreteTaskBase;
import org.nanotek.task.base.BaseTask;

public class CallableTaskDispatcherBase <T extends  BaseTask<T,V>,V extends Base<?>> extends CallableTaskDispatcher<T, V>{
	
	    protected T task; 

	    
	    public static void main(String [] args)
	    { 
	    	CallableTaskDispatcherBase<?,?> base = new CallableTaskDispatcherBase();
	    	try {
				base.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public CallableTaskDispatcherBase() {
			this.task =  (T) new ConcreteTaskBase();
		}

		@Override
		public T getTask() {
			return task;
		}

		@SuppressWarnings("unchecked")
		@Override
		public V call() throws Exception {
			dispatch((V) getTask());
			return (V)task;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public void dispatch(V data) {
			try {
				((ConcreteTaskBase)task).call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
