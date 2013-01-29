package com.haozileung.scau.server.dto;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

/**
 * 
 * <b>类名称：</b>SystemUserInfo<br/>
 * <b>类描述：</b>用户传输类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午2:55:08<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class UserInfo implements IDataTransferObject {
	/**
	 * serialVersionUID
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 2791744162145545325L;
	/**
	 * 数据库主键
	 */
	private String userId;

	private String name;

	private int age;

	private String sex;

	private String birthdate;

	private int userType;

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
	 * name
	 * 
	 * @return the name
	 * @since 1.0.0
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * age
	 * 
	 * @return the age
	 * @since 1.0.0
	 */

	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * sex
	 * 
	 * @return the sex
	 * @since 1.0.0
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

	/**
	 * userType
	 * 
	 * @return the userType
	 * @since 1.0.0
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
