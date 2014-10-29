package com.renren.rsa.protocol.message.thrift.util;

public class NameGenerator {
	public static String generateMethodArgsClassName(String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodName).append("_args");
		return sb.toString();
	}
	
	public static String generateFieldSetterMethodName(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("set").append(Character.toUpperCase(fieldName.charAt(0)))
				.append(fieldName.substring(1));
		return sb.toString();
	}
}
