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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.dto.CowInfo;
import com.haozileung.scau.server.repository.ICowRepository;
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
	
	@Autowired
	private ICowRepository cowRepository;

	@Override
	public boolean saveCow(CowInfo cowInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCow(CowInfo cowInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CowInfo> getAllCow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CowInfo getCowById(ObjectId oId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCowById(ObjectId oId) {
		// TODO Auto-generated method stub
		return false;
	}

	public ICowRepository getCowRepository() {
		return cowRepository;
	}

	public void setCowRepository(ICowRepository cowRepository) {
		this.cowRepository = cowRepository;
	}

}
