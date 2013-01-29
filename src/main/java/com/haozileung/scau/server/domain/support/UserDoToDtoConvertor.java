package com.haozileung.scau.server.domain.support;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.bson.types.ObjectId;

import com.haozileung.scau.server.common.dto.AbstractDoToDtoConvertor;
import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.domain.User;
import com.haozileung.scau.server.dto.UserInfo;

/**
 * 
 * <b>类名称：</b>UserDoToDtoConvert<br/>
 * <b>类描述：</b>User的领域对象转DTO对象转换器<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午3:02:53<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class UserDoToDtoConvertor extends
		AbstractDoToDtoConvertor<User, UserInfo> {

	private static UserDoToDtoConvertor instance;

	private UserDoToDtoConvertor() {

	}

	static {
		if (instance == null) {
			instance = new UserDoToDtoConvertor();
			DoToDtoConvertorFactory.register(User.class, instance);
		}
		// DoToDtoConvertorFactory.register(SystemUser.class,
		// LazySystemUserDoToDtoConvert.instance);
	}

	public static UserDoToDtoConvertor getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDto(com.
	 * haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public UserInfo doToDto(User obj) {
		if (obj != null) {
			UserInfo userInfo = new UserInfo();
			ObjectId oid = obj.getId();
			if (oid != null) {
				userInfo.setUserId(oid.toString());
			}
			userInfo.setName(obj.getName());
			userInfo.setSex(obj.getSex());
			userInfo.setUserType(obj.getUserType());
			if (obj.getBirthdate() != null) {
				userInfo.setBirthdate(DateUtil.format(obj.getBirthdate(),
						DateUtil.defaultDatePatternStr));
				Timestamp now = new Timestamp(new Date().getTime());
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				int nowYear = cal.get(Calendar.YEAR);
				cal.setTime(obj.getBirthdate());
				int birthYear = cal.get(Calendar.YEAR);
				userInfo.setAge(nowYear - birthYear);
			}
			return userInfo;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDtoWithLazy
	 * (com.haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public UserInfo doToDtoWithLazy(User obj) {
		return doToDto(obj);
	}
}
