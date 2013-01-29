package com.haozileung.scau.server.domain;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.dto.UserInfo;

/**
 * 
 * <b>类名称：</b>SystemUser<br/>
 * <b>类描述：</b>系统用户类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午2:51:12<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@Document(collection = "userDoc")
public class User implements IDomain {

	/**
	 * serialVersionUID
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 3809227039445877241L;

	@Id
	@Indexed
	private ObjectId id;

	private String name;

	private Integer userType;

	private String sex;

	private Date birthdate;

	public User() {
	}

	public User(UserInfo userInfo) {
		if (null != userInfo)
			update(userInfo);
	}

	private void update(UserInfo userInfo) {
		if (userInfo.getUserId() != null) {
			this.id = new ObjectId(userInfo.getUserId());
		}
		try {
			this.birthdate = DateUtil.parse(userInfo.getBirthdate(),
					DateUtil.defaultDatePatternStr);
		} catch (ParseException e) {
			this.birthdate = new Timestamp(0);
		}
		this.name = userInfo.getName();
		this.sex = userInfo.getSex();
		this.userType = userInfo.getUserType();
	}

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
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
	 * userType
	 * 
	 * @return the userType
	 * @since 1.0.0
	 */

	public Integer getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
