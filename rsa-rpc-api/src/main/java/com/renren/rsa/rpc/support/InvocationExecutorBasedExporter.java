package com.renren.rsa.rpc.support;

import com.renren.rsa.rpc.Invocation;
import com.renren.rsa.rpc.InvocationExecutor;
import com.renren.rsa.rpc.Result;

public abstract class InvocationExecutorBasedExporter<T> extends AbstractExporter<T> implements InvocationExecutor{

	public InvocationExecutorBasedExporter(T service,
			Class<T> serviceInterface) {
		super(service, serviceInterface);
	}

	@Override
	public Result invoke(Invocation invocation, Object targetObject) {
		try {
			Object obj = invocation.invoke(targetObject);
			return new RpcResult(obj); 
		} catch (Throwable e) {
			return new RpcResult(e);
		}
	}
}
