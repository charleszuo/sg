package com.renren.rsa.protocol.message.impl;

import com.renren.rsa.protocol.message.IMessage;
import com.renren.rsa.protocol.message.IMessageBody;
import com.renren.rsa.protocol.message.IMessageHead;

public class BusinessMessage implements IMessage{

	private IMessageHead head;
	
	private IMessageBody body;
	
	public BusinessMessage(){
		head = null;
		body = null;
	}
	
	public BusinessMessage(IMessageHead head){
		this(head, null);
	}
	
	public BusinessMessage(IMessageHead head, IMessageBody body){
		this.head = head;
		this.body = body;
	}
	
	@Override
	public IMessageHead getHead() {
		return head;
	}

	@Override
	public void setHead(IMessageHead head) {
		this.head = head;
	}

	@Override
	public IMessageBody getBody() {
		return body;
	}

	@Override
	public void setBody(IMessageBody body) {
		this.body = body;
	}
	
}
