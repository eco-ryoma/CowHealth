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
	private ObjectId id;

	@Indexed
	private String equipmentId;

	private Date currentDate;

	private String data;

	public SportData() {
	}

	public SportData(SportDataInfo sportDataInfo) {
		if (null != sportDataInfo) {
			update(sportDataInfo);
		}
	}

	private void update(SportDataInfo sportDataInfo) {
		if (sportDataInfo.getEquipmentId() != null) {
			this.equipmentId = sportDataInfo.getEquipmentId();
		}
		try {
			this.currentDate = DateUtil.parse(sportDataInfo
					.getCurrentDate(),DateUtil.defaultDatePatternStr);
		} catch (ParseException e) {
			this.currentDate = new Date(0);
		}
		
		this.data = sportDataInfo.getData();

		if (sportDataInfo.getSportDataId() != null) {
			this.id = new ObjectId(sportDataInfo.getSportDataId());
		}
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

}
