package com.haozileung.scau.server.domain;

import java.text.ParseException;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.common.utility.DateUtil;
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
		this.cowId = new ObjectId(sportDataInfo.getCowId());
		try {
			this.currentDate = DateUtil.parse(sportDataInfo.getCurrentDate(),
					DateUtil.defaultDatePatternStr);
		} catch (ParseException e) {
			this.currentDate = new Date(0);
		}
		StringBuffer dataStr = new StringBuffer();
		for (int i = 0; i < sportDataInfo.getData().length; i++) {
			dataStr.append(sportDataInfo.getData()[i] + ",");
		}
		this.data = dataStr.toString();
		this.equipmentId = new ObjectId(sportDataInfo.getEquipmentId());
		this.id = new ObjectId(sportDataInfo.getId());
		try {
			this.updateDate = DateUtil.parse(sportDataInfo.getUpdateDate(),
					DateUtil.defaultDatePatternStr);
		} catch (ParseException e) {
			this.updateDate = new Date(0);
		}

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
