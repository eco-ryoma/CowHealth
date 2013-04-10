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
import org.bson.types.ObjectId;
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

	private String equipmentId;
	
	private String displayId;

	private String cowId;

	private String name;

	private String type;

	private String producter;

	private String expireDate;

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String id) {
		this.equipmentId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProducter() {
		return producter;
	}

	public void setProducter(String producter) {
		this.producter = producter;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public RestDataSourceResponse<EquipmentInfo> getResponse() {
		return response;
	}

	public void setResponse(RestDataSourceResponse<EquipmentInfo> response) {
		this.response = response;
	}

	@Action(value = "getEquipment")
	public String getEquipmentInfoList() {
		response.setData(equimentService.getAllEquipment());
		response.setStatus(equimentService.getAllEquipment() == null ? -1 : 0);
		response.setStartRow(0);
		response.setEndRow(equimentService.getAllEquipment() == null ? 0
				: equimentService.getAllEquipment().size());
		return SUCCESS;
	}

	@Action(value = "addEquipment")
	public String addEquipmentInfo() {
		EquipmentInfo equipmentInfo = new EquipmentInfo();
		equipmentInfo.setName(name);
		equipmentInfo.setProducter(producter);
		equipmentInfo.setType(type);
		equipmentInfo.setExpireDate(expireDate);
		equipmentInfo.setCowId(cowId);
		equipmentInfo.setDisplayId(displayId);
		if (equimentService.addEquipment(equipmentInfo)) {
			response.setStatus(0);
			return SUCCESS;
		} else {
			response.setStatus(-1);
			return ERROR;
		}
	}

	@Action(value = "updateEquipment")
	public String updateEquipmentInfo() {
		EquipmentInfo equipmentInfo = new EquipmentInfo();
		equipmentInfo.setEquipmentId(equipmentId);
		equipmentInfo.setName(name);
		equipmentInfo.setProducter(producter);
		equipmentInfo.setType(type);
		equipmentInfo.setExpireDate(expireDate);
		equipmentInfo.setCowId(cowId);
		equipmentInfo.setDisplayId(displayId);
		if (equimentService.updateEquipment(equipmentInfo)) {
			response.setStatus(0);
			return SUCCESS;
		} else {
			response.setStatus(-1);
			return ERROR;
		}
	}

	@Action(value = "deleteEquipment")
	public String deleteEquipmentInfo() {
		if (equipmentId != null && !equipmentId.isEmpty()) {
			ObjectId oId = new ObjectId();
			if (equimentService.deleteEquipmentById(oId)) {
				response.setStatus(0);
				return SUCCESS;
			}
		}
		response.setStatus(-1);
		return ERROR;
	}

	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

}
