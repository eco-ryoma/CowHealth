/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service<br />
 * <b>文件名：</b>IPassportService.java<br />
 * <b>文件描述：</b>通行证业务逻辑层<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:08:07<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.haozileung.scau.server.common.service.IService;
import com.haozileung.scau.server.dto.PassportInfo;

/**
 * 
 * <b>类名称：</b>IPassportService<br/>
 * <b>类描述：</b>通行证业务逻辑层<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:08:07<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface IPassportService extends IService {

	public boolean addPassport(PassportInfo passportInfo);

	public boolean updatePassport(PassportInfo passportInfo);

	public boolean deletePassportById(ObjectId oId);

	public List<PassportInfo> getAllPassport();

	public PassportInfo getPassportById(ObjectId oId);

}
