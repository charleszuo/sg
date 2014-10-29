package com.renren.rsa.protocol;

import java.nio.ByteBuffer;

import com.renren.rsa.transport.Channel;

public interface CodeC {

	public Object read(Channel channel, ByteBuffer buf);
	
	public void write(Channel channel, ByteBuffer buf, Object message);
}
