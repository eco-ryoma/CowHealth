package com.haozileung.scau.client;

import java.util.LinkedHashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.haozileung.scau.client.home.view.CowManageView;
import com.haozileung.scau.client.home.view.EquipmentManageView;
import com.haozileung.scau.client.home.view.SportDataChartRealTimeView;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CowHealth implements EntryPoint {

	private final Messages messages = GWT.create(Messages.class);
	public static LinkedHashMap<String, Object> cowMap = new LinkedHashMap<String, Object>();

	public static SportDataChartRealTimeView sportData;

	public static EquipmentManageView equipment;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RequestBuilder req = new RequestBuilder(RequestBuilder.GET,
				"cow/getCow.action");
		try {
			req.sendRequest(null, new RequestCallback() {

				@Override
				public void onError(Request arg0, Throwable arg1) {
					SC.say("请求奶牛列表出错！");
				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {
					String json = response.getText();
					JSONValue jv = JSONParser.parseStrict(json).isObject()
							.get("response");
					if (jv != null) {
						JSONValue jvData = jv.isObject().get("data");
						if (jvData != null) {
							JSONArray ja = jvData.isArray();
							JSONValue jvCow = null;
							cowMap = new LinkedHashMap<String, Object>();
							for (int i = 0; i < ja.size(); i++) {
								jvCow = ja.get(i);
								if (jvCow != null) {
									JSONValue cowId = jvCow.isObject().get(
											"cowId");
									JSONValue name = jvCow.isObject().get(
											"name");
									if (cowId != null && name != null) {
										String cowIdStr = cowId.isString()
												.stringValue();
										String cowName = name.isString()
												.stringValue();
										cowMap.put(cowIdStr, cowName);
									}
								}
							}
						}
						final TabSet tabs = new TabSet();
						tabs.setTabBarPosition(Side.TOP);
						tabs.setTabBarThickness(25);
						tabs.setTabBarAlign(Side.RIGHT);
						tabs.setWidth100();
						tabs.setHeight100();
						final Tab testTab = new Tab(messages.cowSportData());
						sportData = new SportDataChartRealTimeView();
						testTab.setPane(sportData);
						tabs.addTab(testTab);
						final Tab cowTab = new Tab(messages.cowManage());
						cowTab.setPane(new CowManageView());
						tabs.addTab(cowTab);
						final Tab equipmentTab = new Tab(messages
								.equipmentManage());
						equipment = new EquipmentManageView();
						equipmentTab.setPane(equipment);
						tabs.addTab(equipmentTab);
						tabs.draw();
						Document.get().setTitle(messages.siteName());
					}
				}
			});
		} catch (RequestException e) {
		}
	}
}
