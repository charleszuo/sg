package com.renren.rsa.transport;

import com.renren.rsa.common.URL;

/**
 * 适配器，适配Endpoint和ChannelHandler接口，每个Peer需要ChannelHandler来处理Channel
 * **/
public abstract class AbstractPeer implements Endpoint{
	private final ChannelHandler handler;
	
	private volatile URL url;
	
	private volatile boolean closed;
	
	public AbstractPeer(URL url, ChannelHandler handler){
		this.url = url;
		this.handler = handler;
	}

	public ChannelHandler getChannelHandler() {
		return handler;
	}
	
	public void close(){
		closed = true;
	}
	
	public void close(int timeout){
		close();
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	
}
