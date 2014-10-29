package com.renren.rsa.transport;

import com.renren.rsa.common.URL;


public abstract class AbstractChannel extends AbstractPeer implements Channel{

	public AbstractChannel(URL url, ChannelHandler handler){
		super(url, handler);
	}
	
}
