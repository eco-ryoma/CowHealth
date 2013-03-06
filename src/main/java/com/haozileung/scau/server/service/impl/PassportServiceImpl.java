/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service.impl<br />
 * <b>文件名：</b>PassportServiceImpl.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午4:03:43<br />
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

import com.haozileung.scau.server.dto.PassportInfo;
import com.haozileung.scau.server.repository.IPassportRepository;
import com.haozileung.scau.server.service.IPassportService;

/**
 * 
 * <b>类名称：</b>PassportServiceImpl<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午4:03:43<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Service("PassportService")
public class PassportServiceImpl implements IPassportService {
	
	@Autowired
	private IPassportRepository passportRepository;

	@Override
	public boolean addPassport(PassportInfo passportInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassport(PassportInfo passportInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePassportById(ObjectId oId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PassportInfo> getAllPassport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PassportInfo getPassportById(ObjectId oId) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPassportRepository getPassportRepository() {
		return passportRepository;
	}

	public void setPassportRepository(IPassportRepository passportRepository) {
		this.passportRepository = passportRepository;
	}

}
