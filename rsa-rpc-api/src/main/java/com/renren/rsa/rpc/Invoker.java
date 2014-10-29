package com.renren.rsa.rpc;


public interface Invoker<T> {
	
	public Class<T> getInterface();
	
	public Result invoke(Invocation invocation) throws Throwable;

}
