package com.renren.rsa.rpc.support;

import com.renren.rsa.rpc.Result;

public class RpcResult implements Result{
	
	private Object value;
	
	private Throwable exception;
	
	public RpcResult(Object value){
		this.value = value;
	}
	
	public RpcResult(Throwable exception){
		this.exception = exception;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public Throwable getException() {
		return exception;
	}

	@Override
	public boolean hasException() {
		return exception != null;
	}

	@Override
	public boolean hasReturnValue() {
		return value != null;
	}

}
