package com.haozileung.scau.client.home.ds;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2013-3-18 上午11:45:36
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class EquipmentDataSource extends RestDataSource {
	
	final private Messages message = GWT.create(Messages.class);
	
	private static EquipmentDataSource instance;

	public static EquipmentDataSource getInstance() {
		if (null == instance) {
			instance = new EquipmentDataSource("EquipmentDataSource");
		}
		return instance;
	}

	public EquipmentDataSource(String id) {
		setID(id);
		DataSourceTextField equipmentId = new DataSourceTextField(
				"equipmentId", message.id());
		equipmentId.setPrimaryKey(true);
		equipmentId.setDetail(true);
		DataSourceTextField name = new DataSourceTextField("name", message.name());
		DataSourceTextField producter = new DataSourceTextField("producter",
				"生产商");
		DataSourceDateTimeField expireDate = new DataSourceDateTimeField("expireDate",
				"有效期");
		DataSourceTextField type = new DataSourceTextField("type", "类型");

		setFields(equipmentId, name, producter, type, expireDate);

		setClientOnly(false);
		setSendMetaData(true);
		setDataFormat(DSDataFormat.JSON);
		setRecordXPath("response/data");
		setDataProtocol(DSProtocol.POSTPARAMS);

		setAddDataURL("equipment/addEquipment.action");
		setRemoveDataURL("equipment/deleteEquipment.action");
		setFetchDataURL("equipment/getEquipment.action");
		setUpdateDataURL("equipment/updateEquipment.action");

	}

}
