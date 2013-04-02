package com.haozileung.scau.server.dto;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

/**
 * 
 * 
 * <b>类名称：</b>EquipmentInfo<br/>
 * <b>类描述：</b>数据采集设备传输类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午3:11:05<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class EquipmentInfo implements IDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6154318401354363106L;
	
	private String equipmentId;
	
	private String cowId;

	private String name;

	private String type;

	private String producter;

	private String expireDate;

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

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

}
