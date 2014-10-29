package com.renren.rsa.protocol;

import java.nio.ByteBuffer;

import com.renren.rsa.protocol.message.IMessage;
import com.renren.rsa.transport.Channel;

public abstract class AbstractCodeC implements CodeC {
	
	@Override
	public Object read(Channel channel, ByteBuffer buf) {
		return readMessage(buf);
	}

	@Override
	public void write(Channel channel, ByteBuffer buf, Object message) {
		if(message instanceof IMessage){
			writeMessage(buf, (IMessage)message);
		}else{
			throw new UnsupportedOperationException("Unsupport write method!");
		}
	}

	public abstract IMessage readMessage(ByteBuffer buf);

	public abstract void writeMessage(ByteBuffer buf, IMessage message);
}
