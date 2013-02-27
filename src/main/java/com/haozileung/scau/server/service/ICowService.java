/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service<br />
 * <b>文件名：</b>ICowService.java<br />
 * <b>文件描述：</b>奶牛业务逻辑层<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:06:52<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.haozileung.scau.server.common.service.IService;
import com.haozileung.scau.server.dto.CowInfo;

/**
 * 
 * <b>类名称：</b>ICowService<br/>
 * <b>类描述：</b>奶牛业务逻辑层<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:06:52<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public interface ICowService extends IService {
	
	public boolean saveCow(CowInfo cowInfo);
	
	public boolean updateCow(CowInfo cowInfo);
	
	public boolean deleteCowById(ObjectId oId);
	
	public List<CowInfo> getAllCow();
	
	public CowInfo getCowById(ObjectId oId);

}
