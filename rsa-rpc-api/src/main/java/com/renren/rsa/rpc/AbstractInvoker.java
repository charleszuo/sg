package com.renren.rsa.rpc;

import com.renren.rsa.common.URL;

public abstract class AbstractInvoker<T> implements Invoker<T>{
	private Class<T> type;
	
	private URL url;
	
	public AbstractInvoker(){
		
	}
	
	public AbstractInvoker(Class<T> type, URL url){
		this.type = type;
		this.url = url;		
	}
	
	
	@Override
	public Class<T> getInterface() {
		return type;
	}

	@Override
	public Result invoke(Invocation invocation) throws Throwable {
		Result result = doInvoke();
		return result;
	}

	public abstract Result doInvoke() throws Throwable;
	
}
