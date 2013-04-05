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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.domain.Cow;
import com.haozileung.scau.server.domain.Equipment;
import com.haozileung.scau.server.domain.SportData;
import com.haozileung.scau.server.domain.support.SportDataDoToDtoConvertor;
import com.haozileung.scau.server.dto.SportDataInfo;
import com.haozileung.scau.server.repository.ICowRepository;
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
	private ICowRepository cowRepository;

	@Autowired
	private IEquipmentRepository equipmentRepository;

	@Override
	public List<SportDataInfo> getSportDataByEquipmentId(String equipmentId,
			Date endDate) {
		if (equipmentId == null || endDate == null) {
			return null;
		}
		Equipment equipment = equipmentRepository.findOne(new ObjectId(
				equipmentId));
		if (equipment != null && equipment.getCowId() != null
				&& !equipment.getCowId().isEmpty()) {
			Cow cow = cowRepository.findOne(new ObjectId(equipment.getCowId()));
			if (null != equipment) {
				List<SportData> sportData = sportDataRepository
						.findByEquipmentIdAndCurrentDateBetweenOrderByCurrentDateAsc(
								equipment.getId().toString(),
								DateUtil.addDays(endDate, -30), endDate);
				Map<Date, SportData> dataMap = new HashMap<Date, SportData>();
				for (SportData d : sportData) {
					dataMap.put(d.getCurrentDate(), d);
				}
				List<SportDataInfo> datas = new ArrayList<SportDataInfo>();
				Date now = DateUtil.getBeginOfDay(new Date());
				for (int i = -30; i < 0; i++) {
					Date date = DateUtil.addDays(now, i);
					SportData t = dataMap.get(date);
					if (t != null) {
						dataMap.remove(date);
					}
					if (t == null) {
						SportDataInfo nullData = new SportDataInfo();
						String d = "-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1";
						nullData.setEquipmentId(equipment.getId().toString());
						nullData.setCurrentDate(DateUtil.format(date,
								DateUtil.defaultDatePatternStr));
						nullData.setData(d);
						datas.add(nullData);
					} else {
						datas.add(SportDataDoToDtoConvertor.getInstance()
								.doToDto(t));
					}
				}
				for (SportDataInfo data : datas) {
					data.setCowName(cow.getName());
				}
				return datas;
			}
		}
		return null;
	}

	@Override
	public boolean saveSportData(SportDataInfo sportDataInfo) {
		if (sportDataInfo.getSportDataId() == null) {
			SportData data = null;
			try {
				data = sportDataRepository.findByEquipmentIdAndCurrentDate(
						sportDataInfo.getEquipmentId(), DateUtil.parse(
								sportDataInfo.getCurrentDate(),
								DateUtil.defaultDatePatternStr));
			} catch (ParseException e) {
				return false;
			}
			if (data != null) {
				sportDataInfo.setSportDataId(data.getId().toString());
			}
		}
		return sportDataRepository.save(new SportData(sportDataInfo)) == null ? false
				: true;
	}
}
