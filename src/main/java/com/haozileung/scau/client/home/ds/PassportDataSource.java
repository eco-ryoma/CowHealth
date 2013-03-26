package com.haozileung.scau.client.home.ds;

import java.util.LinkedHashMap;

import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2013-3-18 下午1:32:45
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class PassportDataSource extends RestDataSource {

	private static PassportDataSource instance;

	public static PassportDataSource getInstance() {
		if (null == instance) {
			instance = new PassportDataSource("PassportDataSource");
		}
		return instance;
	}

	public PassportDataSource(String id) {
		setID(id);
		DataSourceTextField passportId = new DataSourceTextField("passportId",
				"数据库主键");
		passportId.setPrimaryKey(true);
		passportId.setDetail(true);
		DataSourceTextField userName = new DataSourceTextField("userName",
				"用户名");
		DataSourceTextField password = new DataSourceTextField("password", "密码");
		DataSourceTextField email = new DataSourceTextField("email", "电子邮件");
		DataSourceIntegerField isEnabled = new DataSourceIntegerField(
				"isEnabled", "状态");
		LinkedHashMap<String, Object> isEnabledValueMap = new LinkedHashMap<String, Object>();
		isEnabledValueMap.put("1", "启用");
		isEnabledValueMap.put("0", "禁用");
		isEnabled.setValueMap(isEnabledValueMap);

		setFields(passportId, userName, password, email, isEnabled);
		
		setClientOnly(false);
		setSendMetaData(true);
		setDataFormat(DSDataFormat.JSON);
		setRecordXPath("response/data");
		setDataProtocol(DSProtocol.POSTPARAMS);

		setAddDataURL("passport/addPassport.action");
		setRemoveDataURL("passport/deletePassport.action");
		setFetchDataURL("passport/getPassport.action");
		setUpdateDataURL("passport/updatePassport.action");

	}

}
