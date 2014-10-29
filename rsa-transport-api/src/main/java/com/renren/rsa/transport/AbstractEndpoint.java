package com.renren.rsa.transport;

import com.renren.rsa.common.ParameterDefaultValues;
import com.renren.rsa.common.ParameterKeys;
import com.renren.rsa.common.URL;
import com.renren.rsa.protocol.CodeC;

/**
 * 适配CodeC接口，服务器和客户端需要CodeC的能力来编解码。Channel只管发送，所以不需要CodeC
 * **/
public abstract class AbstractEndpoint extends AbstractPeer{

	private CodeC codec;
	
	private int timeout;
	
	private int connectTimeout;
	
	public AbstractEndpoint(URL url, ChannelHandler handler) {
		super(url, handler);
		timeout = url.getPositiveParameter(ParameterKeys.TIMEOUT_KEY, ParameterDefaultValues.DEFAULT_TIMEOUT_VALUE);
		connectTimeout = url.getPositiveParameter(ParameterKeys.CONNECT_TIMEOUT_KEY, ParameterDefaultValues.DEFAULT_CONNECT_TIMEOUT_VALUE);
	}

	public CodeC getCodec() {
		return codec;
	}

	public void setCodec(CodeC codec) {
		this.codec = codec;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	
}
