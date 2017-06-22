package org.nanotek.task.callable.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;
import org.nanotek.Base;
//import org.nanotek.BaseTask;
import org.nanotek.Origin;
import org.nanotek.pipe.PipeException;
import org.nanotek.task.base.BaseTask;
import org.nanotek.task.callable.CallableTaskDispatcherBase;

public class PipeTaskDispatcherBase <T extends  BaseTask<T,V>,V extends Base<?>,  S extends Pipe.SinkChannel > extends CallableTaskDispatcherBase<T, V> implements Origin<S>{


		private static Logger logger = Logger.getLogger(PipeTaskDispatcherBase.class);
		
		protected Pipe pipe;
		protected SinkChannel sinkChannel; 
		

		public PipeTaskDispatcherBase() {
		}

		public PipeTaskDispatcherBase(Pipe pipe) {
			super();
			this.pipe = pipe;
			this.sinkChannel = pipe.sink();
		}
		
		public PipeTaskDispatcherBase(Pipe pipe , T task) {
			this.pipe = pipe;
			this.task = task;
			this.sinkChannel = pipe.sink();
		}

		@Override
		public S getSource() {
			return (S) pipe.sink();
		}
		
		@Override
		public V call() throws Exception {
			logger.debug("CALL METHOD EXECUTED");
			return super.call();
		}
		
		@Override
		public void dispatch(V data) {
			assert(pipe !=null);
			byte[] serializedMessage = SerializationUtils.serialize(data);
			ByteBuffer serializationBuffer = ByteBuffer.allocate(serializedMessage.length);
			serializationBuffer.put(serializedMessage);
			logger.debug(" Data " + data.toString());
			try {
				logger.debug(" WRITING TO SERIALIZATION BUFFER ");
				serializationBuffer.position(0);
				sinkChannel.write(serializationBuffer);
				logger.debug(" END WRITING TO SERIALIZATION BUFFER ");
			} catch (IOException e) {
				e.printStackTrace();
				throw new PipeException(e);
			}
		}
		
}
