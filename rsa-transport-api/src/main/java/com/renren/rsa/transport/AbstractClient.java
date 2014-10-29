package com.renren.rsa.transport;

import java.net.InetSocketAddress;

import com.renren.rsa.common.URL;

/**
 * 客户端支持长连接，支持断开重连
 * **/
public abstract class AbstractClient extends AbstractEndpoint implements Client{

	public AbstractClient(URL url, ChannelHandler handler){
		super(url, handler);
		
		try {
			doOpen();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			connect(url);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public void connect(URL url) throws Throwable{
		doConnect();
	}
	
	public void disconnect() throws Throwable{
		Channel ch = getChannel();
		if(ch != null){
			ch.close();
		}
		
		doDisconnect();
	}
	
	public boolean isConnected(){
		try {
			Channel ch = getChannel();
			if(ch != null){
				return ch.isConnected();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public InetSocketAddress getServerAddress(){
		return new InetSocketAddress(getUrl().getHost(), getUrl().getPort());
	}
	
	public abstract void doOpen() throws Throwable;
	
	public abstract void doConnect() throws Throwable;
	
	// 断开连接，但是不关闭连接
	public abstract void doDisconnect() throws Throwable;
	
	public abstract Channel getChannel() throws Throwable;
}
