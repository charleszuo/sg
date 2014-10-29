package com.renren.rsa.rpc;

public interface BeforeInterceptor extends Interceptor{
	public void before(Invocation inv, Object target) throws Throwable;
}
