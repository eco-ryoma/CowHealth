/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.action<br />
 * <b>文件名：</b>PassportAction.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:11:17<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.common.dto.RestDataSourceResponse;
import com.haozileung.scau.server.dto.PassportInfo;
import com.haozileung.scau.server.service.IPassportService;

/**
 * 
 * <b>类名称：</b>PassportAction<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:11:17<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Namespace("/passport")
public class PassportAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6120430714015763169L;

	@Autowired
	private IPassportService passportService;

	private String passportId;

	private String userId;

	private String userName;

	private String password;

	private String email;

	private int isEnabled;

	private RestDataSourceResponse<PassportInfo> response = new RestDataSourceResponse<PassportInfo>();

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

	public RestDataSourceResponse<PassportInfo> getResponse() {
		return response;
	}

	public void setResponse(RestDataSourceResponse<PassportInfo> response) {
		this.response = response;
	}

	@Action(value = "getPassport")
	public String getPassportInfoByUserId() {
		return null;
	}

	@Action(value = "addPassport")
	public String addPassportInfo() {
		return null;
	}

	@Action(value = "updatePassport")
	public String updatePassportInfo() {
		return null;
	}

	@Action(value = "deletePassport")
	public String deletePassportInfo() {
		return null;
	}

}
