package com.renren.rsa.transport;

import java.net.InetSocketAddress;

public interface Endpoint {
	
	public InetSocketAddress getLocalAddress();
	
	public void send(Object message);
	
	public void close();
	
	public void close(int timeout);
	
}
