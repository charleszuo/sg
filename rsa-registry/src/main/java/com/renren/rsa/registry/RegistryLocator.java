package com.renren.rsa.registry;


public interface RegistryLocator {
	// 按某种策略返回一个注册中心
	public Registry getRegistry();
	// 指定注册中心的地址
	public Registry getRegistry(String registryAddress);
	
}
