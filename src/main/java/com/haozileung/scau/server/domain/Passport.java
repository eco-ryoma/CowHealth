package com.haozileung.scau.server.domain;

import org.bson.types.ObjectId;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.dto.PassportInfo;

/**
 * 
 * 
 * <b>类名称：</b>Passport<br/>
 * <b>类描述：</b>通行证<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-01-24 上午10:52:39<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Passport implements IDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -851885710424068575L;

	private ObjectId id;

	private ObjectId userId;

	private String userName;

	private String password;

	private String email;

	private int isEnabled;

	public Passport() {
	}

	public Passport(PassportInfo passportInfo) {
		if (null != passportInfo)
			update(passportInfo);
	}

	private void update(PassportInfo passportInfo) {
		this.email = passportInfo.getEmail();
		this.id = new ObjectId(passportInfo.getId());
		this.isEnabled = passportInfo.getIsEnabled();
		this.password = passportInfo.getPassword();
		this.userId = new ObjectId(passportInfo.getUserId());
		this.userName = passportInfo.getUserName();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
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
