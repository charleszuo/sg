package com.renren.rsa.protocol.util;

import com.renren.rsa.protocol.message.impl.MessageType;

public class ProtocolUtil {
	public static boolean isSYN(byte typeFlag){
		return (MessageType.SYN.getBit() & typeFlag) != 0;
	}
	
	public static boolean isACK(byte typeFlag){
		return (MessageType.ACK.getBit() & typeFlag) != 0;
	}
	
	public static boolean isFIN(byte typeFlag){
		return (MessageType.FIN.getBit() & typeFlag) != 0;
	}
	
	public static boolean isBusiness(byte typeFlag){
		return (MessageType.BUS.getBit() & typeFlag) != 0;
	}
	
	public static boolean isHeartBeat(byte typeFlag){
		return (MessageType.HRT.getBit() & typeFlag) != 0;
	}

	// 取flags前4位值
	public static int getProtocolType(byte flags){
		return (flags >> 4) & 0x0F;
	}
	
	// 取flags从右向左数，第4位，从1开始数
	public static boolean isRequest(byte flags){
		return (flags & 0x08) != 0;
	}
	
	// 取flags从右向左数，第4位，从1开始数
	public static boolean isResponse(byte flags){
		return (flags & 0x08) == 0;
	}
	
	// 取flags从右向左数，第3位，从1开始数
	public static boolean isTwoWay(byte flags){
		return (flags & 0x04) != 0;
	}
	
	// 取flags从右向左数，第3位，从1开始数
	public static boolean isOneWay(byte flags){
		return (flags & 0x04) == 0;
	}
	
	// 取flasg后两位值
	public static int getStatusCode(byte flags){
		return flags & 0x03;
	}
	
	public static void main(String[] args){
		System.out.println(isSYN((byte)1));
		System.out.println(isSYN((byte)2));
		System.out.println(isACK((byte)2));
		System.out.println(isACK((byte)4));
		System.out.println(isFIN((byte)4));
		System.out.println(isFIN((byte)8));
		System.out.println(isBusiness((byte)8));
		System.out.println(isBusiness((byte)16));
		System.out.println(isHeartBeat((byte)16));
		System.out.println(isHeartBeat((byte)17));
		System.out.println(isHeartBeat((byte)32));
		
		System.out.println("---------------测试Flags------------");
		// 10000000
		System.out.println(getProtocolType((byte)128) == 8);
		// 00010000
		System.out.println(getProtocolType((byte)16) == 1);
		// 00100000
		System.out.println(getProtocolType((byte)32) == 2);
		// 00110000
		System.out.println(getProtocolType((byte)48) == 3);
		
		// 00111000
		System.out.println(isRequest((byte)56));
		System.out.println(isRequest((byte)48));
		System.out.println(isResponse((byte)48));
		
		// 00111100
		System.out.println(isOneWay((byte)60));
		System.out.println(isOneWay((byte)56));
		System.out.println(isTwoWay((byte)60));
		
		// 00110000
		System.out.println(getStatusCode((byte)48) == 0);
		// 00110001
		System.out.println(getStatusCode((byte)49) == 1);
		// 00110010
		System.out.println(getStatusCode((byte)50) == 2);
		// 00110011
		System.out.println(getStatusCode((byte)51) == 3);
	}
}
