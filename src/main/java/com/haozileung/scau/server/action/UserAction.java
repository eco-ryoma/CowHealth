package com.haozileung.scau.server.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.common.dto.MyPage;
import com.haozileung.scau.server.common.dto.RestDataSourceResponse;
import com.haozileung.scau.server.dto.UserInfo;
import com.haozileung.scau.server.service.IUserService;

/**
 * 
 * <b>类名称：</b>SystemUserAction<br/>
 * <b>类描述：</b>SystemUserr的Action层<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午3:57:00<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@ParentPackage("json-default")
@Namespace("/user")
/*
 * @Results({ @Result(name = "success", location = "/index.jsp"),
 * 
 * @Result(name = "error", location = "/error.jsp") })
 * 
 * @ExceptionMappings({ @ExceptionMapping(exception =
 * "java.lange.RuntimeException", result = "error") })
 */
public class UserAction extends BaseAction {

	/**
	 * serialVersionUID
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 7873797059589872336L;

	@Autowired
	private IUserService userService;

	/**
	 * @param systemUserService
	 *            the systemUserService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private String name;
	private String birthdate;
	private int userType;
	private String userId;
	private String sex;
	private RestDataSourceResponse<UserInfo> response = new RestDataSourceResponse<UserInfo>();

	@Action(value = "getUser", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties",
			"response\\.\\w+,response\\.data\\[\\d+\\]\\.\\w+",
			"ignoreHierarchy", "false" }) })
	public String getUserList() {
		MyPage<UserInfo> userInfos = userService.getUserByName(name, _startRow,
				_endRow);
		response.setData(userInfos.getContent());
		response.setStartRow(userInfos.getNumber() * userInfos.getSize());
		response.setEndRow(response.getStartRow()
				+ userInfos.getNumberOfElements());
		response.setTotalRow(userInfos.getTotalElements());
		response.setStatus(0);
		return SUCCESS;
	}

	@Action(value = "addUser", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties", "response\\.\\w+", "ignoreHierarchy", "false" }) })
	public String addUser() {
		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setBirthdate(birthdate);
		user.setName(name);
		user.setSex(sex);
		user.setUserType(userType);
		userService.addUser(user);
		response.setStatus(0);
		return SUCCESS;
	}

	@Action(value = "deleteUser", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties", "response\\.\\w+", "ignoreHierarchy", "false" }) })
	public String deleteUser() {
		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setBirthdate(birthdate);
		user.setName(name);
		user.setSex(sex);
		user.setUserType(userType);
		userService.deleteUser(user);
		response.setStatus(0);
		return SUCCESS;
	}

	@Action(value = "updateUser", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties", "response\\.\\w+", "ignoreHierarchy", "false" }) })
	public String updateUser() {
		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setBirthdate(birthdate);
		user.setName(name);
		user.setSex(sex);
		user.setUserType(userType);
		userService.updateUser(user);
		response.setStatus(0);
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the response
	 */
	public RestDataSourceResponse<UserInfo> getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(RestDataSourceResponse<UserInfo> response) {
		this.response = response;
	}

	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the userType
	 */
	public int getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
}
