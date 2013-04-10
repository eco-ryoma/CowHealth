package com.haozileung.scau.client.home.ds;

import java.util.LinkedHashMap;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2013-3-18 上午11:33:20
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class CowDataSource extends RestDataSource {
	
	final private Messages message = GWT.create(Messages.class);

	private static CowDataSource instance = null;

	public static CowDataSource getInstance() {
		if (null == instance) {
			instance = new CowDataSource("CowDataSource");
		}
		return instance;
	}

	public CowDataSource(String id) {
		setID(id);
		DataSourceTextField cowId = new DataSourceTextField("cowId", message.id());
		cowId.setPrimaryKey(true);
		cowId.setDetail(true);
		DataSourceIntegerField age = new DataSourceIntegerField("age", message.age(), 3);
		DataSourceTextField name = new DataSourceTextField("name", message.name(), 16);
		DataSourceTextField sex = new DataSourceTextField("sex", message.sex(), 3);
		LinkedHashMap<String,Object> sexValueMap = new LinkedHashMap<String,Object>();
		sexValueMap.put("M", message.manAnimal());
		sexValueMap.put("F", message.femaleAnimal());
		sex.setValueMap(sexValueMap);
		name.setRequired(true);
		age.setRequired(true);
		sex.setRequired(true);
		setFields(cowId, name, age, sex);
		setClientOnly(false);
		setSendMetaData(true);
		setDataFormat(DSDataFormat.JSON);
		setRecordXPath("response/data");
		setDataProtocol(DSProtocol.POSTPARAMS);

		setAddDataURL("cow/addCow.action");
		setRemoveDataURL("cow/deleteCow.action");
		setFetchDataURL("cow/getCow.action");
		setUpdateDataURL("cow/updateCow.action");
	}
}
