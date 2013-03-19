package com.haozileung.scau.server.dto;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

/**
 * <p>类的简介说明</p>
 * 创建时间：2013-1-24 下午3:11:32 
 * @author lianghaopeng
 * @version V1.0
 */
/**
 * 
 * 
 * <b>类名称：</b>PassportInfo<br/>
 * <b>类描述：</b>通行证传输类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午3:11:32<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class PassportInfo implements IDataTransferObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8788869633074474619L;

	private String passportId;

	private String userId;

	private String userName;

	private String password;

	private String email;

	private int isEnabled;

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
}
