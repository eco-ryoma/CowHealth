/**
 * 
 */
package com.haozileung.scau.client.home.ds;

import java.util.LinkedHashMap;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.types.DateDisplayFormat;

/**
 * @author lianghaopeng
 * 
 */
public class UserDataSource extends RestDataSource {
	final private Messages message = GWT.create(Messages.class);
	private static UserDataSource instance = null;

	public static UserDataSource getInstance() {
		if (instance == null) {
			instance = new UserDataSource("userDataSource");
		}
		return instance;
	}

	public UserDataSource(String id) {
		setID(id);
		DataSourceTextField userId = new DataSourceTextField("userId", message.id());
		userId.setPrimaryKey(true);
		userId.setDetail(true);
		DataSourceIntegerField age = new DataSourceIntegerField("age", message.age(), 3);
		DataSourceTextField name = new DataSourceTextField("name", message.name(), 16);
		name.setRequired(true);
		DataSourceDateTimeField birthdate = new DataSourceDateTimeField(
				"birthdate", message.birthdate(), 20);
		birthdate.setRequired(true);
		birthdate.setDateFormatter(DateDisplayFormat.TOSERIALIZEABLEDATE);
		DataSourceTextField sex = new DataSourceTextField("sex", message.sex(), 10);
		LinkedHashMap<String, Object> sexValueMap = new LinkedHashMap<String, Object>();
		sexValueMap.put("man", message.man());
		sexValueMap.put("woman", message.female());
		sexValueMap.put("other", message.other());
		sex.setValueMap(sexValueMap);
		DataSourceIntegerField userType = new DataSourceIntegerField(
				"userType", message.userType());
		LinkedHashMap<String, Object> userTypeValueMap = new LinkedHashMap<String, Object>();
		userTypeValueMap.put("1", "管理员");
		userTypeValueMap.put("2", "信息员");
		userTypeValueMap.put("3", "普通用户");
		userType.setValueMap(userTypeValueMap);

		setFields(userId, name, age, sex, birthdate, userType);

		setClientOnly(false);
		setSendMetaData(true);
		setDataFormat(DSDataFormat.JSON);
		setRecordXPath("response/data");
		setDataProtocol(DSProtocol.POSTPARAMS);

		setAddDataURL("user/addUser.action");
		setRemoveDataURL("user/deleteUser.action");
		setFetchDataURL("user/getUser.action");
		setUpdateDataURL("user/updateUser.action");
	}

}
