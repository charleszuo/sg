package com.renren.rsa.common;

import java.io.Serializable;

import com.renren.rsa.common.util.StringUtils;

public final class URL implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String host;
	
	private int port;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getParameter(String key) {
		return null;
	}

	public int getParameter(String key, int defaultValue) {
		String value = getParameter(key);
		return StringUtils.isEmpty(value) ? defaultValue : Integer
				.parseInt(value);
	}

	public int getPositiveParameter(String key, int defaultValue) {
		if (defaultValue <= 0) {
			throw new IllegalArgumentException("defaultValue <= 0");
		}
		int value = getParameter(key, defaultValue);
		if (value <= 0) {
			return defaultValue;
		}
		return value;
	}

}
