package com.renren.rsa.transport.transform;

public interface Future<T> {
	public boolean isDone();

	public T get();

	public T get(long timeout);

	public boolean cancel(boolean mayInterruptIfRunning);

	public boolean isCancelled();
	
	public void setCallback(Callback callback);
}
