/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.repository<br />
 * <b>文件名：</b>IEquipmentRepository.java<br />
 * <b>文件描述：</b>设备领域仓库<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-29 下午1:46:22<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.haozileung.scau.server.domain.Equipment;

/**
 * 
 * <b>类名称：</b>IEquipmentRepository<br/>
 * <b>类描述：</b>设备领域仓库<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-29 下午1:46:22<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface IEquipmentRepository extends
		MongoRepository<Equipment, ObjectId> {
	
	public Equipment findByCowId(String cowId);

}
