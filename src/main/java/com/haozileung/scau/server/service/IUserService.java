package com.haozileung.scau.server.service;

import java.util.List;

import com.haozileung.scau.server.common.dto.MyPage;
import com.haozileung.scau.server.common.service.IService;
import com.haozileung.scau.server.dto.UserInfo;

/**
 * 
 * <b>类名称：</b>ISystemUserService<br/>
 * <b>类描述：</b>SystemUser的服务接口<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午3:52:14<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public interface IUserService extends IService {

	/**
	 * 
	 * addSystemUser(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param systemUserInfo
	 * @return void
	 * @since 1.0.0
	 */
	public void addUser(UserInfo userInfo);

	/**
	 * 
	 * deleteSystemUser(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param systemUserInfo
	 * @return void
	 * @exception
	 * @since 1.0.0
	 */
	public void deleteUser(UserInfo userInfo);

	/**
	 * 
	 * getSystemUserById(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param id
	 * @return
	 * @return SystemUserInfo
	 * @exception
	 * @since 1.0.0
	 */
	public UserInfo getUserById(String id);

	/**
	 * 
	 * getAllSystemUser(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return
	 * @return List<userInfo>
	 * @exception
	 * @since 1.0.0
	 */
	public List<UserInfo> getAllSystemUser();

	/**
	 * 按名字查询
	 * 
	 * @param name
	 * @return
	 */
	public MyPage<UserInfo> getUserByName(String name, int start, int limit);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(UserInfo user);

}
