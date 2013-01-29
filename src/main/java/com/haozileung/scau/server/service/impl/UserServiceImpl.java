package com.haozileung.scau.server.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.common.dto.MyPage;
import com.haozileung.scau.server.domain.User;
import com.haozileung.scau.server.dto.UserInfo;
import com.haozileung.scau.server.repository.IUserRepository;
import com.haozileung.scau.server.service.IUserService;

/**
 * 
 * <b>类名称：</b>SystemUserImpl<br/>
 * <b>类描述：</b>SystemUser的服务层实现<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午3:55:32<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@Service("SystemUserService")
public class UserServiceImpl implements IUserService {

	private final Log logger = LogFactory.getLog(getClass().getName());

	@Autowired
	private IUserRepository systemUserRepository;

	/**
	 * @param iSystemUserRepository
	 *            the iSystemUserRepository to set
	 */
	public void setSystemUserRepository(
			IUserRepository iSystemUserRepository) {
		this.systemUserRepository = iSystemUserRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.service.ISystemUserService#addSystemUser(com
	 * .haozileung.scau.server.dto.SystemUserInfo)
	 */
	@Override
	public void addUser(UserInfo systemUserInfo) {
		if (systemUserInfo != null) {
			User user = new User(systemUserInfo);
			if (logger.isInfoEnabled()) {
				logger.info("adding user " + systemUserInfo.getName());
			}
			systemUserRepository.save(user);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.service.ISystemUserService#deleteSystemUser
	 * (com.haozileung.scau.server.dto.SystemUserInfo)
	 */
	@Override
	public void deleteUser(UserInfo systemUserInfo) {
		if (systemUserInfo != null && systemUserInfo.getUserId() != null) {
			if (logger.isInfoEnabled()) {
				logger.info("deleting user " + systemUserInfo.getUserId());
			}
			systemUserRepository
					.delete(new ObjectId(systemUserInfo.getUserId()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.service.ISystemUserService#getSystemUserById
	 * (java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserInfo getUserById(String id) {
		if (id != null) {
			User user = systemUserRepository.findOne(new ObjectId(id));
			return (UserInfo) (DoToDtoConvertorFactory
					.getConvertor(User.class)).doToDto(user);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.service.ISystemUserService#getAllSystemUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getAllSystemUser() {
		if (logger.isInfoEnabled()) {
			logger.info("Listing All User!");
		}
		return (DoToDtoConvertorFactory.getConvertor(User.class))
				.dos2Dtos(systemUserRepository.findAll());
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyPage<UserInfo> getUserByName(String name, int start,
			int limit) {
		if ((limit - start) > 0) {
		}
		Page<User> user = systemUserRepository.findByNameLike(
				name == null ? "^.*$" : name, new PageRequest(start, limit));
		MyPage<UserInfo> userInfos = new MyPage<UserInfo>(user);
		userInfos.setContent(DoToDtoConvertorFactory.getConvertor(
				User.class).dos2Dtos(user.getContent()));
		return userInfos;
	}

	@Override
	public void updateUser(UserInfo user) {
		User u = new User(user);
		systemUserRepository.save(u);
	}
}
