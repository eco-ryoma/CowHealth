/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service.impl<br />
 * <b>文件名：</b>CowServiceImpl.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午3:57:48<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.domain.Cow;
import com.haozileung.scau.server.domain.Equipment;
import com.haozileung.scau.server.domain.support.CowDoToDtoConvertor;
import com.haozileung.scau.server.dto.CowInfo;
import com.haozileung.scau.server.repository.ICowRepository;
import com.haozileung.scau.server.repository.IEquipmentRepository;
import com.haozileung.scau.server.service.ICowService;

/**
 * 
 * <b>类名称：</b>CowServiceImpl<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午3:57:48<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Service("CowService")
public class CowServiceImpl implements ICowService {

	private final static Logger logger = LoggerFactory
			.getLogger(CowServiceImpl.class);

	@Autowired
	private ICowRepository cowRepository;
	
	@Autowired
	private IEquipmentRepository equipmentRepository;

	@Override
	public boolean saveCow(CowInfo cowInfo) {
		Cow cow = new Cow(cowInfo);
		Cow c = null;
		try {
			c = cowRepository.save(cow);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		if (c == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCow(CowInfo cowInfo) {
		if (cowInfo.getCowId() != null && !cowInfo.getCowId().isEmpty()) {
			return saveCow(cowInfo);
		}
		return false;
	}

	@Override
	public List<CowInfo> getAllCow() {
		List<Cow> cows = cowRepository.findAll();
		return CowDoToDtoConvertor.getInstance().dos2Dtos(cows);
	}

	@Override
	public CowInfo getCowById(ObjectId oId) {
		return CowDoToDtoConvertor.getInstance().doToDto(
				cowRepository.findOne(oId));
	}

	@Override
	public boolean deleteCowById(ObjectId oId) {
		if (oId != null) {
			cowRepository.delete(oId);
			Equipment e = equipmentRepository.findByCowId(oId.toString());
			if(e != null){
				equipmentRepository.delete(e);
			}
			return true;
		}
		return false;
	}

	public ICowRepository getCowRepository() {
		return cowRepository;
	}

	public void setCowRepository(ICowRepository cowRepository) {
		this.cowRepository = cowRepository;
	}

}
