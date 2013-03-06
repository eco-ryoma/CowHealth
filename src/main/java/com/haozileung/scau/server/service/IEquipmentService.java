/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service<br />
 * <b>文件名：</b>IEquipmentService.java<br />
 * <b>文件描述：</b>设备业务逻辑层<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:07:17<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.haozileung.scau.server.common.service.IService;
import com.haozileung.scau.server.dto.EquipmentInfo;

/**
 * 
 * <b>类名称：</b>IEquipmentService<br/>
 * <b>类描述：</b>设备业务逻辑层<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:07:17<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface IEquipmentService extends IService {
	
	public boolean addEquipment(EquipmentInfo equipmentInfo);
	
	public boolean updateEquipment(EquipmentInfo equipmentInfo);
	
	public boolean deleteEquipmentById(ObjectId oId);
	
	public List<EquipmentInfo> getAllEquipment();
	
	public EquipmentInfo getEquipmentById(ObjectId oId);

}
