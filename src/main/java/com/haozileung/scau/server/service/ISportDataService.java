/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service<br />
 * <b>文件名：</b>ISportDataService.java<br />
 * <b>文件描述：</b>运动数据业务逻辑层<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:08:37<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service;

import java.util.Date;
import java.util.List;

import com.haozileung.scau.server.common.service.IService;
import com.haozileung.scau.server.dto.SportDataInfo;

/**
 * 
 * <b>类名称：</b>ISportDataService<br/>
 * <b>类描述：</b>运动数据业务逻辑层<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:08:37<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface ISportDataService extends IService {

	/**
	 * 根据奶牛id取运动数据
	 * 
	 * @param cowId
	 * @return List<SportDataInfo>
	 */
	public List<SportDataInfo> getSportDataByEquipmentId(String equipmentId, Date endDate);

	/**
	 * 保存从action传过来的运动数据
	 * 
	 * @param sportDataInfo
	 */
	public boolean saveSportData(SportDataInfo sportDataInfo);
}
