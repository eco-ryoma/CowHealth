package com.haozileung.scau.server.common.exception;

/**
 * 
 *
 * <b>类名称：</b>BaseUncheckedException<br/>
 * <b>类描述：</b>基本不需检查异常类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午1:52:24<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0<br/>
 *
 */
public class BaseUncheckedException extends RuntimeException {
	
	private static final long serialVersionUID = -1993410383498751491L;
	
	private String msgKey;

	public BaseUncheckedException(String msgKey,String message, Throwable throwable) {
		super(message, throwable);
		this.msgKey=msgKey;
	}
	
	public BaseUncheckedException(String msgKey,String message) {
		super(message);
		this.msgKey=msgKey;
	}
	
	public BaseUncheckedException(String message) {
		super(message);
		this.msgKey=null;
	}
	
	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
	
}
