package com.renren.rsa.protocol.message.impl;

import java.nio.ByteBuffer;

import com.renren.rsa.protocol.message.IMessageHead;

public class BusinessMessageHead implements IMessageHead {

	// syn: 1 ack: 2, fin, 4, bus 8
	private byte type;

	// 消息头长几个字节
	private byte headSize;

	// 消息体长
	private int messageSize;
	
	// 服务版本号
	private byte version;

	// +----------------------------------------------------------+
	// | 协议类型(4位) | 请求/响应(1位) | 单向/双向(1位) | 返回状态(2位) |
	// +----------------------------------------------------------+
	private byte flags;

	// 连接id
	private int connectionId;

	// messageId
	private int msgId;

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public byte getHeadSize() {
		return headSize;
	}

	public void setHeadSize(byte headSize) {
		this.headSize = headSize;
	}

	public byte getVersion() {
		return version;
	}

	public void setVersion(byte version) {
		this.version = version;
	}

	public byte getFlags() {
		return flags;
	}

	public void setFlags(byte flags) {
		this.flags = flags;
	}

	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}

	public int getMesssageSize() {
		return messageSize;
	}

	public void setMessageSize(int messageSize) {
		this.messageSize = messageSize;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	@Override
	public void toBytes(ByteBuffer buf) {
		buf.put(type);
		buf.put(headSize);
		buf.putInt(connectionId);
		buf.put(version);
		buf.put(flags);		
		buf.putInt(messageSize);
		buf.putInt(msgId);
	}

	@Override
	public IMessageHead toObject(ByteBuffer buf) {
		this.setType(buf.get());
		this.setHeadSize(buf.get());
		this.setMessageSize(buf.getInt());
		this.setVersion(buf.get());
		this.setFlags(buf.get());
		this.setConnectionId(buf.getInt());
		this.setMsgId(buf.getInt());
		return this;
	}

}
