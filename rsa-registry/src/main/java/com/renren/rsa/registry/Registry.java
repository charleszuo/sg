package com.renren.rsa.registry;

import java.util.List;

public interface Registry {

	// 返回所有的服务提供者地址信息，客户端自己选择服务提供者地址
	public List<String> lookup(String serviceName);
	
	// 返回所有的服务提供者地址信息，客户端自己选择服务提供者地址
	public List<String> lookup(String serviceName, String version);
	
	// 服务提供者注册服务
	public void register(String serviceName, Object service);
	
	// 服务提供者取消注册服务
	public void unregister(String serviceName, Object service);
	
	// 服务消费者订阅服务的消息。service = ip+port+serviceName+version
	// 比如订阅服务关闭的消息，可以让客户端选择新的服务提供者
	public void subscribe(String service, NotificationListener listener);
	
	// 服务消费者取消订阅服务的消息。service = ip+port+serviceName+version
	public void unsubscribe(String service, NotificationListener listener);
}
