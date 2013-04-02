/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service.impl<br />
 * <b>文件名：</b>ISportDataService.java<br />
 * <b>文件描述：</b>奶牛运动数据服务层实现类<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午4:04:22<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.domain.Equipment;
import com.haozileung.scau.server.domain.SportData;
import com.haozileung.scau.server.dto.SportDataInfo;
import com.haozileung.scau.server.repository.IEquipmentRepository;
import com.haozileung.scau.server.repository.ISportDataRepository;
import com.haozileung.scau.server.service.ISportDataService;

/**
 * 
 * <b>类名称：</b>ISportDataService<br/>
 * <b>类描述：</b>奶牛运动数据服务层实现类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午4:04:22<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Service("SportDataService")
public class SportDataServiceImpl implements ISportDataService {

	@Autowired
	private ISportDataRepository sportDataRepository;

	@Autowired
	private IEquipmentRepository equipmentRepository;

	@Override
	public List<SportDataInfo> getSportDataByCowId(String cowId, Date endDate) {
		Equipment equipment = equipmentRepository.findByCowId(cowId);
		if (null != equipment) {
			List<SportData> sportData = sportDataRepository
					.findByEquipmentIdOrderByCurrentDateDesc(equipment.getId()
							.toString());
			List<SportDataInfo> datas = new ArrayList<SportDataInfo>();
			Date now = new Date();
			for (int i = -30; i < 0; i++) {
				Date date = DateUtil.addDays(now, i);
				Iterator<SportData> it = sportData.iterator();
				SportData t = null;
				while (it.hasNext()) {
					t = it.next();
					if (t.getCurrentDate() == date) {
						it.remove();
						break;
					}
				}
				if (t == null) {
					SportDataInfo nullData = new SportDataInfo();
					float[] d = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
					nullData.setEquipmentId(equipment.getId().toString());
					nullData.setCurrentDate(DateUtil.format(date,
							DateUtil.defaultDatePatternStr));
					nullData.setData(d);
				}
			}
			return datas;
		}
		return null;
	}

	@Override
	public boolean saveSportData(SportDataInfo sportDataInfo) {
		if (sportDataInfo.getSportDataId() == null) {
			SportData data = sportDataRepository
					.findByEquipmentIdAndCurrentDate(
							sportDataInfo.getEquipmentId(),
							sportDataInfo.getCurrentDate());
			if (data != null) {
				sportDataInfo.setSportDataId(data.getId().toString());
			}
		}
		return sportDataRepository.save(new SportData(sportDataInfo)) == null ? false
				: true;
	}
}
