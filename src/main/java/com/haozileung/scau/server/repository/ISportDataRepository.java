/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.repository<br />
 * <b>文件名：</b>ISportDataRepository.java<br />
 * <b>文件描述：</b>记录数据领域仓库<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午1:53:05<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.haozileung.scau.server.domain.SportData;

/**
 * 
 * <b>类名称：</b>ISportDataRepository<br/>
 * <b>类描述：</b>记录数据领域仓库<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午1:53:05<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface ISportDataRepository extends
		MongoRepository<SportData, ObjectId> {

	/**
	 * 根据奶牛id返回运动数据并按日期排序
	 * 
	 * @param cowId
	 * @return List<SportData>
	 */
	public List<SportData> findByEquipmentIdOrderByCurrentDateDesc(String cowId);

	/**
	 * 查找设备在某天的数据
	 * 
	 * @param equipmentId
	 * @param currentDate
	 * @return
	 */
	public SportData findByEquipmentIdAndCurrentDate(String equipmentId,
			Date currentDate);

	/**
	 * 根据设备ID 和时间范围查找并按时间排序
	 * 
	 * @param EquipmentId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<SportData> findByEquipmentIdAndCurrentDateBetweenOrderByCurrentDateAsc(
			String EquipmentId, Date startDate, Date endDate);
}
