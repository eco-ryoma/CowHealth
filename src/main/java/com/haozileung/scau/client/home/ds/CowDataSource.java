package com.haozileung.scau.client.home.ds;

import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.sun.tools.jdi.LinkedHashMap;

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

	private static CowDataSource instance = null;

	public static CowDataSource getInstance() {
		if (null == instance) {
			instance = new CowDataSource("CowDataSource");
		}
		return instance;
	}

	public CowDataSource(String id) {
		setID(id);
		DataSourceTextField cowId = new DataSourceTextField("cowId", "数据库主键");
		cowId.setPrimaryKey(true);
		cowId.setDetail(true);
		DataSourceIntegerField age = new DataSourceIntegerField("age", "年龄", 3);
		DataSourceTextField name = new DataSourceTextField("name", "名称", 16);
		DataSourceTextField sex = new DataSourceTextField("sex", "性别", 3);
		LinkedHashMap sexValueMap = new LinkedHashMap();
		sexValueMap.put("M", "雄性");
		sexValueMap.put("F", "雌性");
		sex.setValueMap(sexValueMap);
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
