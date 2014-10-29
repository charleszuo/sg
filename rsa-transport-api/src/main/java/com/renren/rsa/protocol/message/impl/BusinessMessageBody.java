package com.renren.rsa.protocol.message.impl;

import com.renren.rsa.protocol.message.IMessageBody;

public class BusinessMessageBody implements IMessageBody{

	private Object body;
	
	public BusinessMessageBody(){
		this.body = null;
	}
	
	public BusinessMessageBody(Object body){
		this.body = body;
	}
	
	public void setBody(Object body){
		this.body = body;
	}
	
	@Override
	public Object getBody() {
		return body;
	}

}
