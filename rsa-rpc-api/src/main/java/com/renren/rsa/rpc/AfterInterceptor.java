package com.renren.rsa.rpc;

public interface AfterInterceptor extends Interceptor{
	public void after(Invocation inv, Object target) throws Throwable;
}
