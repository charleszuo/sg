package com.renren.rsa.rpc;


public interface ProxyFactory {
	
	public <T> T getProxy(Class<T> type) throws Throwable;
	
}
