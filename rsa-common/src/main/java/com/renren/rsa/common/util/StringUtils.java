package com.renren.rsa.common.util;

public class StringUtils {
	public static boolean isEmpty(String s){
		return s == null || s.length() == 0 || "".equals(s.trim());
	}
	
	public static void main(String[] args){
		System.out.println(isEmpty("   "));
	}
}
