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

	private String sportDataId;

	private String equipmentId;

	private String cowName;

	private String currentDate;

	private String data;

	public String getSportDataId() {
		return sportDataId;
	}

	public void setSportDataId(String sportDataId) {
		this.sportDataId = sportDataId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getCowName() {
		return cowName;
	}

	public void setCowName(String cowName) {
		this.cowName = cowName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
