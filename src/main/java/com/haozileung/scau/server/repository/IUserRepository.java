package com.haozileung.scau.server.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.haozileung.scau.server.domain.User;

/**
 * 
 * <b>类名称：</b>ISystemUserRepository<br/>
 * <b>类描述：</b>系统用户的仓库接口<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午3:44:13<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public interface IUserRepository extends
		MongoRepository<User, ObjectId> {
	/**
	 * 按名字查询
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	public List<User> findByNameLike(String name);

	/**
	 * 按名字分页查询
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<User> findByNameLike(String name, Pageable pageable);

}
