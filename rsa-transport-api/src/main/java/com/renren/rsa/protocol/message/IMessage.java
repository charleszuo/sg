package com.renren.rsa.protocol.message;

public interface IMessage {
	public IMessageHead getHead();
	
	public void setHead(IMessageHead head);
	
	public IMessageBody getBody();
	
	public void setBody(IMessageBody body);
	
}
