package com.renren.rsa.rpc;

public interface Exporter<T> {
	
	public T getService();
	
	public Class<T> getServiceInterface();
	
}
