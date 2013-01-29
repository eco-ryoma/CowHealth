package com.haozileung.scau.server.dto;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

/**
 * 
 * <b>类名称：</b>SportDataInfo<br/>
 * <b>类描述：</b>运动数据传输类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-01-24 下午2:55:08<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class SportDataInfo implements IDataTransferObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6102383745215971866L;

	private String id;
	
	private String cowId;

	private String equipmentId;

	private String updateDate;

	private String currentDate;

	private float[] data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public float[] getData() {
		return data;
	}

	public void setData(float[] data) {
		this.data = data;
	}

}
