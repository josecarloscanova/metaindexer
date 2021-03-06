package org.nanotek.pipe;

import java.nio.channels.Pipe;
import java.util.Map;

import org.nanotek.Dispatcher;
import org.nanotek.MessageBase;

public class MessageDispatcherDelegate extends MessagePipeDispatcherBase<MessageBase<?>, Pipe, Map<MessageParts,byte[]>>{

	protected Dispatcher<MessageBase<?>> delegateDispatcher; 
	
	public MessageDispatcherDelegate() {
	}

	public MessageDispatcherDelegate(final Dispatcher<MessageBase<?>> delegateDispatcher) {
		this.delegateDispatcher = delegateDispatcher;
	}
	
	
	public Dispatcher<MessageBase<?>> getDelegateDispatcher() {
		return delegateDispatcher;
	}

	public void setDelegateDispatcher(Dispatcher<MessageBase<?>> delegateDispatcher) {
		this.delegateDispatcher = delegateDispatcher;
	}

	@Override
	public void dispatch(MessageBase<?> data) {
		delegateDispatcher.dispatch(data);
	}
	
}
