package org.nanotek.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SourceChannel;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;
import org.nanotek.Base;

public class PipeReceiverBase <D extends Base<?>,P extends Pipe> implements PipeReceiver<D, P>{

	private static Logger logger = Logger.getLogger(PipeReceiverBase.class);
	private static int STATIC_MEMORY_BUFFER = 100000;
	
	protected P pipe; 

	public PipeReceiverBase() {
	}
	
	public PipeReceiverBase(P p) {
		this.pipe = p;
	}
	
	public void setPipe(P pipe) {
		this.pipe = pipe;
	}

	@Override
	public P getPipe() {
		return pipe;
	}

	@Override
	public D receive() {
		D eventMessage = null;
		logger.debug("MAIN APPLICATION WINDOW ADAPTER THREAD");
		SourceChannel sourceChannel = pipe.source();
		ByteBuffer byteBuffer = ByteBuffer.allocate(STATIC_MEMORY_BUFFER);
			try {
				 logger.debug("SOURCE CHANNEL");
				  int i = sourceChannel.read(byteBuffer);
				  if (i > 0) { 
					  byte [] serialized = new byte[i]; 
					  byteBuffer.position(0);
					  byteBuffer.get(serialized);
					  Object obj = SerializationUtils.deserialize(serialized);
					  eventMessage =  cast(obj);
					  logger.debug("Size of Message " + i + "ObjectClass " + eventMessage.getClass());
				  }
			} catch (IOException e) {
				e.printStackTrace();
			}
		return eventMessage;
	}

	private D cast(Object obj) {
		
		return null;
	}

}
