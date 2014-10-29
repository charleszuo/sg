package com.renren.rsa.transport;

import com.renren.rsa.common.URL;

public interface Client extends Endpoint{
	
	public void connect(URL url) throws Throwable;
	
	public void disconnect() throws Throwable;
	
	public boolean isConnected();
}
