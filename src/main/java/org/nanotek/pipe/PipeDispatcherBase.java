package org.nanotek.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;

import org.apache.commons.lang3.SerializationUtils;
import org.nanotek.Base;

public class PipeDispatcherBase<D extends Base<?>, P extends Pipe> implements
PipeDispatcher<D, P> {

	protected P pipe; 

	public PipeDispatcherBase() {
	}

	public PipeDispatcherBase(P pipe) {
		this.pipe = pipe;
	}

	@Override
	public void dispatch(D data) {
		byte[] serializedMessage = SerializationUtils.serialize(data);
		dispatchSerializedMessage(serializedMessage);
	}

	protected void dispatchSerializedMessage(byte[] serializedMessage){ 
		SinkChannel sinkChannel = pipe.sink();
		if (serializedMessage.length > 0) { 
			ByteBuffer serializationBuffer = ByteBuffer.allocate(serializedMessage.length);
			serializationBuffer.put(serializedMessage);
			try {
				serializationBuffer.position(0);
				sinkChannel.write(serializationBuffer);
			} catch (IOException e) {
				e.printStackTrace();
				throw new PipeException(e);
			}
		}
		
	}
	
	@Override
	public P getPipe() {
		return (P) pipe;
	}

	public void setPipe(P pipeDispatcher) {
		this.pipe = pipeDispatcher;
	}

}
