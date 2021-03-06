package org.nanotek.pipe;

import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.nanotek.MessageBase;
import org.nanotek.message.MessageConverter;

/**
 * 
 * @author josecanovamauger
 *
 * @param <D> A MessageBase Class composed by Header and Message. 
 * @param <P> The pipe for message relay. 
 * @param <C> The Map of Values that will be passed through the Pipe.
 */
@SuppressWarnings("serial")
public class MessagePipeDispatcherBase<D extends MessageBase<?>, P extends Pipe,C extends Map<MessageParts, byte[]>> extends PipeDispatcherBase<D, P> implements MessageConverter<C,D> {

	@SuppressWarnings("unchecked")
	public C toConverted(D messageBase)
	{ 
		Map<MessageParts, byte[]> messageParts = new HashMap<MessageParts, byte[]>();
		byte[] headerBytes = SerializationUtils.serialize(messageBase.getHeader());
		byte[] messageBytes = SerializationUtils.serialize(messageBase.getMessage()); 
		assert (headerBytes.length > 0 && messageBytes.length > 0);
		messageParts.put(MessageParts.HEADER, headerBytes);
		messageParts.put(MessageParts.BODY, messageBytes);
		return (C) messageParts; 
	}
	
	public D toData(C mappedMessage) 
	{ 
		return null;
	}

	@Override
	public void dispatch(D data) {
		C convertedMessage = toConverted(data);
		super.dispatchSerializedMessage(convertedMessage.get(MessageParts.HEADER));
		super.dispatchSerializedMessage(convertedMessage.get(MessageParts.BODY));
	}

	@Override
	public C get() {
		return null;
	}
}
