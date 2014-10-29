package com.renren.rsa.rpc.support;

import com.renren.rsa.rpc.AfterInterceptor;
import com.renren.rsa.rpc.BeforeInterceptor;
import com.renren.rsa.rpc.Interceptor;
import com.renren.rsa.rpc.Invocation;
import com.renren.rsa.rpc.Result;
import com.renren.rsa.rpc.ThrowInterceptor;

public class DefaultExporter<T> extends InvocationExecutorBasedExporter<T>{

	private String serviceName;
	
	private static int DEFAULT_PORT = 12306;
	
	private int servicePort;
	
	public DefaultExporter(T service, Class<T> serviceInterface) {
		this(service, serviceInterface, "", DEFAULT_PORT);
	}

	public DefaultExporter(T service, Class<T> serviceInterface, String serviceName){
		this(service, serviceInterface, serviceName, DEFAULT_PORT);
	}
	
	public DefaultExporter(T service, Class<T> serviceInterface, String serviceName, int servicePort) {
		super(service, serviceInterface);
		this.serviceName = serviceName;
		this.servicePort = servicePort;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServicePort() {
		return servicePort;
	}

	public void setServicePort(int servicePort) {
		this.servicePort = servicePort;
	}
	
	@Override
	public Result invoke(Invocation invocation, Object targetObject) {
		Interceptor[] interceptors = getInterceptors();
		if(interceptors == null || interceptors.length == 0){
			return super.invoke(invocation, targetObject);
		}
		for(Interceptor interceptor: this.beforeInterceptors){
			try {
				((BeforeInterceptor) interceptor).before(invocation, targetObject);
			} catch (Throwable e) {
				// logger
			}
		}
		try {
			// invoke the target method
			Object obj = invocation.invoke(targetObject);
			
			for(Interceptor interceptor: this.afterInterceptors){
				try {
					((AfterInterceptor) interceptor).after(invocation, targetObject);
				} catch (Throwable e) {
					// logger
				}
			}
			return new RpcResult(obj); 
		} catch (Throwable e) {
			for(Interceptor interceptor: this.throwInterceptors){
				try {
					((ThrowInterceptor) interceptor).throwException(invocation, targetObject);
				} catch (Throwable ex) {
					// logger
				}
			}
			return new RpcResult(e);
		}
	}
}
