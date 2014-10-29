package com.renren.rsa.transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 组合模式
 * **/
public class ChannelHandlerChain implements ChannelHandler {

	private final Collection<ChannelHandler> handlers = new ArrayList<ChannelHandler>();

	public ChannelHandlerChain() {

	}

	public ChannelHandlerChain(ChannelHandler... handlers) {
		this(handlers == null? null : Arrays.asList(handlers));
	}

	public ChannelHandlerChain(Collection<ChannelHandler> handlers) {
		if(handlers != null && handlers.size() > 0){
			this.handlers.addAll(handlers);
		}
	}

	public ChannelHandlerChain addChannelHandler(ChannelHandler handler){
		this.handlers.add(handler);
		return this;
	}
	
	public ChannelHandlerChain removeChannelHandler(ChannelHandler handler){
		this.handlers.remove(handler);
		return this;
	}
	
	public Collection<ChannelHandler> getHandlers() {
		return handlers;
	}

	@Override
	public void connected(Channel channel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnected(Channel channel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sent(Channel channel, Object message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void received(Channel channel, Object message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void caught(Channel channel, Throwable exception) {
		// TODO Auto-generated method stub

	}

}
