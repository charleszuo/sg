package com.renren.rsa.rpc.support;

import java.util.ArrayList;
import java.util.List;

import com.renren.rsa.rpc.AfterInterceptor;
import com.renren.rsa.rpc.BeforeInterceptor;
import com.renren.rsa.rpc.Exporter;
import com.renren.rsa.rpc.Interceptor;
import com.renren.rsa.rpc.ThrowInterceptor;

public class AbstractExporter<T> implements Exporter<T>{

	private T service;
	
	private Class<T> serviceInterface;
	
	private Interceptor[] interceptors;
	
	protected List<BeforeInterceptor> beforeInterceptors = null;
	
	protected List<AfterInterceptor> afterInterceptors = null;
	
	protected List<ThrowInterceptor> throwInterceptors = null;
	
	
	public AbstractExporter(T service, Class<T> serviceInterface){
		this.service = service;
		this.serviceInterface = serviceInterface;
	}

	public Interceptor[] getInterceptors() {
		return interceptors;
	}

	public void setInterceptors(Interceptor[] interceptors) {
		this.interceptors = interceptors;
		identifyInterceptors();
	}

	private void identifyInterceptors(){
		for(Interceptor interceptor: interceptors){
			if(interceptor instanceof BeforeInterceptor){
				if(beforeInterceptors == null){
					beforeInterceptors = new ArrayList<BeforeInterceptor>();
				}
				beforeInterceptors.add((BeforeInterceptor)interceptor);
			}
			if(interceptor instanceof AfterInterceptor){
				if(afterInterceptors == null){
					afterInterceptors = new ArrayList<AfterInterceptor>();
				}
				afterInterceptors.add((AfterInterceptor)interceptor);
			}
			if(interceptor instanceof ThrowInterceptor){
				if(throwInterceptors == null){
					throwInterceptors = new ArrayList<ThrowInterceptor>();
				}
				throwInterceptors.add((ThrowInterceptor)interceptor);
			}
		}
	}
	
	@Override
	public T getService() {
		return service;
	}

	public void setService(T service) {
		this.service = service;
	}

	@Override
	public Class<T> getServiceInterface() {
		return serviceInterface;
	}

	public void setServiceInterface(Class<T> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

}
