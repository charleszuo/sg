package com.renren.rsa.rpc;

import java.lang.reflect.InvocationTargetException;

public interface Invocation {
	public String getMethodName();
	
	public Object[] getArguments();
	
	public Class<?>[] getArgumentTypes();
	
	public Object invoke(Object targetObject) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
	
}
