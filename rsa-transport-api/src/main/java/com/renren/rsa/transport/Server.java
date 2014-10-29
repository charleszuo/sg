package com.renren.rsa.transport;

import java.net.InetSocketAddress;
import java.util.Collection;

public interface Server extends Endpoint {
	
	public Collection<Channel> getChannels();

	public Channel getChannel(InetSocketAddress remoteAddress);
	
	public void serve();
	
	public boolean isServing();
	
}
