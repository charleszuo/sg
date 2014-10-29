package com.renren.rsa.rpc;

/**
 * 封装方法调用过程
 * **/
public interface InvocationExecutor {
	public Result invoke(Invocation inv, Object target);
}
