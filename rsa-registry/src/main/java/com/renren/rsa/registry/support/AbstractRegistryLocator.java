package com.renren.rsa.registry.support;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

import com.renren.rsa.registry.Registry;
import com.renren.rsa.registry.RegistryLocator;

public abstract class AbstractRegistryLocator implements RegistryLocator{

	private List<String> registryAddressList;
	
	private ConcurrentMap<String, Registry> registries;
	
	private AtomicBoolean lockFlag = new AtomicBoolean(false);
	
	private volatile boolean releaseLock = false;
	
	public AbstractRegistryLocator() {
		registryAddressList = new ArrayList<String>();
		// 从配置文件中读取注册中心地址，多个集群中机器地址
		// TODO
		registries = new ConcurrentHashMap<String, Registry>();
	}
	
	// 无锁实现单实例Registry的创建
	public Registry getRegistry(String registryAddress){
		Registry registry = registries.get(registryAddress);
		// 第一次创建
		if(registry == null){
			if(!registryAddressList.contains(registryAddress)){
				throw new IllegalArgumentException(registryAddress + " is not in the list!");
			}
			// 利用CAS操作，保证只有第一个操作成功的会拿到false
			boolean isLocked = lockFlag.getAndSet(true);
			if(!isLocked){
				registry = createRegistry();
				registries.put(registryAddress, registry);
				releaseLock = true;
			}else{
				// 自旋等待
				while(!releaseLock){
					
				}
			}
			// 再次获取一下，这时候是肯定不为空
			registry = registries.get(registryAddress);
		}
		return registry;
	}
	
	public abstract Registry createRegistry();
}
