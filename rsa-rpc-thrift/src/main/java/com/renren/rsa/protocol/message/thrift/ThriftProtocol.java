package com.renren.rsa.protocol.message.thrift;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TProtocol;

import com.renren.rsa.protocol.AbstractCodeC;
import com.renren.rsa.protocol.message.IMessage;
import com.renren.rsa.protocol.message.impl.BusinessMessage;
import com.renren.rsa.protocol.message.impl.BusinessMessageBody;
import com.renren.rsa.protocol.message.impl.BusinessMessageHead;
import com.renren.rsa.protocol.message.impl.MessageType;
import com.renren.rsa.protocol.message.thrift.util.NameGenerator;
import com.renren.rsa.rpc.support.RpcInvocation;

public class ThriftProtocol extends AbstractCodeC{

	private TProtocol protocol;
	
	public ThriftProtocol(TProtocol protocol){
		this.protocol = protocol;
	}
	
	@Override
	public IMessage readMessage(ByteBuffer buf) {
		byte headSize = getHeadSize(buf);
		if(headSize <= 0){
			return null;
		}
		
		byte typeByte = buf.get(0);
		MessageType messageType = MessageType.findByBit(typeByte);
		switch(messageType){
		case SYN:
			return null;
		case ACK:
			return null;
		case FIN:
			return null;
		case BUS:
			return readBusinessMessage(buf);
		case HRT:
			return null;
		}
		
		return null;
	}

	public IMessage readBusinessMessage(ByteBuffer buf){
		BusinessMessageHead head = new BusinessMessageHead();
		head.toObject(buf);
		
		if(buf.remaining() != (head.getMesssageSize() - head.getHeadSize())){
			return null;
		}
		
		BusinessMessageBody body = new BusinessMessageBody();
		
		
		BusinessMessage message = new BusinessMessage();
		message.setHead(head);
		message.setBody(body);
		return message;
	}
	
	private byte getHeadSize(ByteBuffer buf){
		if(buf.remaining() < 2){
			return 0;
		}
		return buf.get(1);
	}	
	
	@Override
	public void writeMessage(ByteBuffer buf, IMessage message) {
		if(message instanceof BusinessMessage){
			writeBusinessMessage(buf, (BusinessMessage)message);
		}
	}

	public void writeBusinessMessage(ByteBuffer buf, BusinessMessage message) {
		message.getHead().toBytes(buf);
		RpcInvocation invocation = (RpcInvocation)message.getBody();
		
		String methodName = invocation.getMethodName();
		
		String methodArgsClassName = NameGenerator.generateMethodArgsClassName(methodName);
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName(methodArgsClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(clazz == null){
			return;
		}
		
		TBase args = null;
		try {
			args = (TBase)clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < invocation.getArguments().length; i++){
			Object argValue = invocation.getArguments()[i];
			TFieldIdEnum field = args.fieldForId(i + 1);
			String setter = NameGenerator.generateFieldSetterMethodName(field.getFieldName());
			
			Method method = null;
			try {
				method = clazz.getMethod(setter, invocation.getArgumentTypes()[i]);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			try {
				method.invoke(args, argValue);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
