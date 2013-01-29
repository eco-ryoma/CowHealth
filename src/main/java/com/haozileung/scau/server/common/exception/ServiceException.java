package com.haozileung.scau.server.common.exception;

/**
 * 
 * <b>类名称：</b>ServiceException<br/>
 * <b>类描述：</b>服务异常类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午2:01:57<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class ServiceException extends BaseCheckedException {

	private static final long serialVersionUID = 3419814986703271880L;

	public ServiceException(String msgKey, String message) {
		super(msgKey, message);
	}

	public ServiceException(String msgKey, String message, Object[] args) {
		super(msgKey, message, args);
	}

}
