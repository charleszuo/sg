package com.renren.rsa.protocol.message.impl;

public enum MessageType {
	SYN((byte)(1 << 0)),
	ACK((byte)(1 << 1)),
	FIN((byte)(1 << 2)),
	BUS((byte)(1 << 3)),
	HRT((byte)(1 << 4));
	
	MessageType(byte bit){
		this.bit = bit;
	}
	
	private byte bit;
	
	public byte getBit(){
		return bit;
	}
	
	public static MessageType findByBit(byte bit){
		switch(bit){
		case 1:
			return SYN;
		case 2:
			return ACK;
		case 4:
			return FIN;
		case 8:
			return BUS;
		case 16:
			return HRT;
		default:
			return null;
		}
	}
}
