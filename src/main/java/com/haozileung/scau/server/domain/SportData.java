package com.haozileung.scau.server.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.dto.SportDataInfo;

/**
 * 
 * 
 * <b>类名称：</b>SportData<br/>
 * <b>类描述：</b>运动数据<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-01-24 上午10:52:39<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@Document(collection = "sportDataDoc")
public class SportData implements IDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8911247246778924421L;

	@Id
	@Indexed
	private ObjectId id;

	private ObjectId cowId;

	private ObjectId equipmentId;

	private Date updateDate;

	private Date currentDate;

	private String data;

	public SportData() {
	}

	public SportData(SportDataInfo sportDataInfo) {
		if (null != sportDataInfo)
			update(sportDataInfo);
	}

	private void update(SportDataInfo sportDataInfo) {

	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ObjectId getCowId() {
		return cowId;
	}

	public void setCowId(ObjectId cowId) {
		this.cowId = cowId;
	}

	public ObjectId getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(ObjectId equipmentId) {
		this.equipmentId = equipmentId;
	}

}
