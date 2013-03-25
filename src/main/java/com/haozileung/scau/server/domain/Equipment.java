package com.haozileung.scau.server.domain;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.dto.EquipmentInfo;

/**
 * 
 * 
 * <b>类名称：</b>Equipment<br/>
 * <b>类描述：</b>数据采集设备<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-01-24 上午10:52:39<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@Document(collection = "equipmentDoc")
public class Equipment implements IDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2809489995169462486L;

	@Id
	private ObjectId id;

	@Indexed
	private String name;

	private String type;

	private String producter;

	private Date expireDate;

	public Equipment() {
	}

	public Equipment(EquipmentInfo equipmentInfo) {
		if (null != equipmentInfo)
			update(equipmentInfo);
	}

	private void update(EquipmentInfo equipmentInfo) {
		try {
			this.expireDate = DateUtil.parse(equipmentInfo.getExpireDate(),
					DateUtil.defaultDatePatternStr);
		} catch (ParseException e) {
			this.expireDate = new Timestamp(0);
		}
		if (equipmentInfo.getEquipmentId() != null) {
			this.id = new ObjectId(equipmentInfo.getEquipmentId());
		}
		this.name = equipmentInfo.getName();
		this.producter = equipmentInfo.getProducter();
		this.type = equipmentInfo.getType();

	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
}
