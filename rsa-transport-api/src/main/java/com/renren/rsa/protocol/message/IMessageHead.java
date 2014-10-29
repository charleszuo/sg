package com.renren.rsa.protocol.message;

import java.nio.ByteBuffer;

public interface IMessageHead {
	public void toBytes(ByteBuffer buf);

	public IMessageHead toObject(ByteBuffer buf);
}
