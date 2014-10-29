package com.renren.rsa.rpc;

public interface Result {
	
	public Object getValue();
	
	public Throwable getException();
	
	public boolean hasException();
	
	public boolean hasReturnValue();
	
}
