/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.repository<br />
 * <b>文件名：</b>IPassportRepository.java<br />
 * <b>文件描述：</b>通行证仓库<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-29 下午1:48:22<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.haozileung.scau.server.domain.Passport;

/**
 * 
 * <b>类名称：</b>IPassportRepository<br/>
 * <b>类描述：</b>通行证仓库<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-29 下午1:48:22<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface IPassportRepository extends
		MongoRepository<Passport, ObjectId> {

}
