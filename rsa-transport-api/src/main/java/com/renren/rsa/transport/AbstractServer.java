package com.renren.rsa.transport;

import java.net.InetSocketAddress;
import java.util.Collection;

import com.renren.rsa.common.URL;

public abstract class AbstractServer extends AbstractEndpoint implements Server{

	private final InetSocketAddress bindAddress;
	
	public AbstractServer(URL url, ChannelHandler handler) throws Exception{
		super(url, handler);
		bindAddress = new InetSocketAddress(url.getHost(), url.getPort());
		
		try {
			doStart();
		} catch (Throwable e) {
			throw new Exception("Failed to bind to server");
		}
	}
	
	public abstract void doStart() throws Throwable;
	
	public abstract void doClose() throws Throwable;
	
	@Override
	public InetSocketAddress getLocalAddress() {
		return bindAddress;
	}

	@Override
	public void close() {
		super.close();
		
		try {
			doClose();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(int timeout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Channel> getChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Channel getChannel(InetSocketAddress remoteAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isServing() {
		// TODO Auto-generated method stub
		return false;
	}

}
