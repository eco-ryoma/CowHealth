package com.haozileung.scau.server.common.exception;


/**
 * 
 *
 * <b>类名称：</b>BaseCheckedException<br/>
 * <b>类描述：</b>基本检查异常类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午1:51:26<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0<br/>
 *
 */
public class BaseCheckedException extends Exception {
	
	private static final long serialVersionUID = 3608778997258900435L;
	
	private String msgKey;
	public String getMsgKey() {
		return msgKey;
	}
	
	private Object[] args;
	public Object[] getArgs() {
		return args;
	}
	
	public BaseCheckedException(String msgKey) {
		super();
		this.msgKey=msgKey;
	}

	public BaseCheckedException(String msgKey,String message) {
		super(message);
		this.msgKey=msgKey;
	}
	
	public BaseCheckedException(String msgKey, String message, Object[] args) {
		super(message);
		this.msgKey=msgKey;
		this.args = args;
	}

}
