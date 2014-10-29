package com.renren.rsa.rpc.support;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.renren.rsa.rpc.Invocation;

public class RpcInvocation implements Invocation{
	
	private String methodName;
	
	private Class<?>[] argumentTypes;
	
	private Object[] arguments;
	
	public RpcInvocation(){
	}

	public RpcInvocation(Invocation invocation){
		this(invocation.getMethodName(), invocation.getArgumentTypes(), invocation.getArguments());
	}
	
	public RpcInvocation(String methodName, Class<?>[] argumentTypes, Object[] arguments){
		this.methodName = methodName;
		this.argumentTypes = argumentTypes;
		this.arguments = arguments;
	}
	
	public void setArgumentTypes(Class<?>[] argumentTypes) {
		this.argumentTypes = argumentTypes;
	}
	
	@Override
	public Class<?>[] getArgumentTypes() {
		return argumentTypes;
	}
	
	@Override
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	@Override
	public Object invoke(Object targetObject) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = targetObject.getClass().getMethod(this.methodName, this.argumentTypes);
		if(method == null){
			throw new NoSuchMethodException();
		}
		return method.invoke(targetObject, this.arguments);
	}
	
	
}
