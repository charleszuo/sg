package com.renren.rsa.rpc;

public interface ThrowInterceptor extends Interceptor{
	public void throwException(Invocation inv, Object target) throws Throwable;
}
