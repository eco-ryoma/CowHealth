/**
 * 
 * <b>项目名：</b>EquipmentHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.action<br />
 * <b>文件名：</b>EquipmentAction.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:10:46<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.common.dto.RestDataSourceResponse;
import com.haozileung.scau.server.dto.EquipmentInfo;
import com.haozileung.scau.server.service.IEquipmentService;

/**
 * 
 * <b>类名称：</b>EquipmentAction<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:10:46<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Namespace("/equipment")
public class EquipmentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2749244337613640317L;

	private RestDataSourceResponse<EquipmentInfo> response = new RestDataSourceResponse<EquipmentInfo>();

	@Autowired
	private IEquipmentService equimentService;

	@Action(value = "getEquipment")
	public String getEquipmentInfoList() {
		response.setData(equimentService.getAllEquipment());
		response.setStatus(0);
		response.setStartRow(0);
		response.setEndRow(equimentService.getAllEquipment() == null ? 0
				: equimentService.getAllEquipment().size());
		return SUCCESS;
	}

	@Action(value = "addEquipment")
	public String addEquipmentInfo() {
		return null;
	}

	@Action(value = "updateEquipment")
	public String updateEquipmentInfo() {
		return null;
	}

	@Action(value = "deleteEquipment")
	public String deleteEquipmentInfo() {
		return null;
	}

}
