package com.renren.rsa.registry.support;

import java.util.List;

import com.renren.rsa.registry.NotificationListener;
import com.renren.rsa.registry.Registry;

/**
 * 本地的注册表，在本地注册服务名和Exporter的映射
 * **/
public class LocalRegistry implements Registry{

	@Override
	public List<String> lookup(String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> lookup(String serviceName, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(String serviceName, Object service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(String serviceName, Object service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribe(String service, NotificationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribe(String service, NotificationListener listener) {
		// TODO Auto-generated method stub
		
	}

}
