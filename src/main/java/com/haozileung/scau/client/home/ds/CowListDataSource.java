/**
 * 
 */
package com.haozileung.scau.client.home.ds;

import com.google.gwt.core.client.GWT;
import com.haozileung.scau.Messages;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.events.ErrorEvent;
import com.smartgwt.client.data.events.HandleErrorHandler;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;

/**
 * @author haozi
 * 
 */
public class CowListDataSource extends RestDataSource {
	final private Messages message = GWT.create(Messages.class);
	private static CowListDataSource instance;

	public static CowListDataSource getInstance() {
		if (null == instance) {
			instance = new CowListDataSource("CowListDataSource");
		}
		return instance;
	}

	public CowListDataSource(String id) {
		setID(id);
		DataSourceTextField cowId = new DataSourceTextField("cowId",
				message.id(),24);
		cowId.setPrimaryKey(true);
		cowId.setDetail(true);
		DataSourceTextField name = new DataSourceTextField("cowName",
				message.name());
		
		setFields(cowId, name);
		setClientOnly(false);
		setSendMetaData(true);
		setDataFormat(DSDataFormat.JSON);
		setRecordXPath("response/data");
		setDataProtocol(DSProtocol.POSTPARAMS);

		setFetchDataURL("cow/getCowList.action");
		
		this.addHandleErrorHandler(new HandleErrorHandler(){

			@Override
			public void onHandleError(ErrorEvent event) {
				instance.invalidateCache();
			}
			
		});

	}

}
