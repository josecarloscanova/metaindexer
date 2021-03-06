package org.nanotek.pipe;

import java.nio.channels.Pipe;

import org.nanotek.Dispatcher;

public interface PipeDispatcher<D, P extends Pipe> extends Dispatcher<D> {

	public P getPipe();
	
}
