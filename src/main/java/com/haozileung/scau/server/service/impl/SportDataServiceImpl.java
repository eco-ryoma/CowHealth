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

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.domain.SportData;
import com.haozileung.scau.server.dto.SportDataInfo;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<SportDataInfo> getSportDataByCowId(ObjectId cowId) {
		List<SportData> sportData = sportDataRepository
				.findByCowIdOrderByCurrentDateDesc(cowId);
		return DoToDtoConvertorFactory.getConvertor(SportData.class).dos2Dtos(
				sportData);
	}

	@Override
	public boolean saveSportData(SportDataInfo sportDataInfo) {
		return false;
	}

	@Override
	public boolean updateSportData(SportDataInfo sportDataInfo) {
		return false;
	}

	@Override
	public boolean deleteSportDataById(ObjectId oId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SportDataInfo> getAllSportData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SportDataInfo getSportDataById(ObjectId oId) {
		// TODO Auto-generated method stub
		return null;
	}

}
