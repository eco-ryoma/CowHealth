/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.domain.support<br />
 * <b>文件名：</b>SportDataDoToDtoConvertor.java<br />
 * <b>文件描述：</b>运动数据转换<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-25 上午10:47:02<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.domain.support;

import com.haozileung.scau.server.common.dto.AbstractDoToDtoConvertor;
import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.domain.SportData;
import com.haozileung.scau.server.dto.SportDataInfo;

/**
 * 
 * <b>类名称：</b>SportDataDoToDtoConvertor<br/>
 * <b>类描述：</b>运动数据转换<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-25 上午10:47:02<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public class SportDataDoToDtoConvertor extends
		AbstractDoToDtoConvertor<SportData, SportDataInfo> {

	@Override
	public SportDataInfo doToDto(SportData sportData) {
		if (sportData == null) {
			return null;
		}
		SportDataInfo sportDataInfo = new SportDataInfo();
		sportDataInfo.setCowId(null == sportData.getCowId() ? null : sportData
				.getCowId().toString());
		sportDataInfo.setCurrentDate(DateUtil.convertDate2Str(sportData
				.getCurrentDate()));
		float[] data = new float[24];
		String dataStr = sportData.getData();
		if (dataStr != null) {
			String[] dataArr = dataStr.split(",");
			int count = 0;
			for (String s : dataArr) {
				if (null != s && !s.isEmpty()) {
					data[count] = Float.parseFloat(s);
				}
				count++;
			}
		}
		sportDataInfo.setData(data);
		sportDataInfo.setEquipmentId(null == sportData.getEquipmentId() ? null
				: sportData.getEquipmentId().toString());
		sportDataInfo.setId(null == sportData.getId() ? null : sportData
				.getId().toString());
		sportDataInfo.setUpdateDate(DateUtil.convertDate2Str(sportData
				.getUpdateDate()));
		return sportDataInfo;
	}

	@Override
	public SportDataInfo doToDtoWithLazy(SportData sportData) {
		return doToDto(sportData);
	}

}
