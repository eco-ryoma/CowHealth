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
import com.haozileung.scau.client.home.view.SportDataChartHistoryView;
import com.haozileung.scau.client.home.view.SportDataChartRealTimeView;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabDeselectedEvent;
import com.smartgwt.client.widgets.tab.events.TabDeselectedHandler;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CowHealth implements EntryPoint {

	private final Messages messages = GWT.create(Messages.class);
	public static LinkedHashMap<String, Object> cowMap = new LinkedHashMap<String, Object>();

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
						final Tab realtimeTab = new Tab(messages.cowSportData());
						realtimeTab.setPane(new SportDataChartRealTimeView());
						realtimeTab
								.addTabSelectedHandler(new TabSelectedHandler() {

									@Override
									public void onTabSelected(
											TabSelectedEvent event) {
										realtimeTab.getPane().show();
									}
								});
						realtimeTab
								.addTabDeselectedHandler(new TabDeselectedHandler() {

									@Override
									public void onTabDeselected(
											TabDeselectedEvent event) {
										realtimeTab.getPane().hide();
									}

								});
						tabs.addTab(realtimeTab);
						final Tab historyTab = new Tab(messages.cowSportData());
						historyTab.setPane(new SportDataChartHistoryView());
						historyTab
								.addTabSelectedHandler(new TabSelectedHandler() {

									@Override
									public void onTabSelected(
											TabSelectedEvent event) {
										historyTab.getPane().show();
									}
								});
						historyTab
								.addTabDeselectedHandler(new TabDeselectedHandler() {

									@Override
									public void onTabDeselected(
											TabDeselectedEvent event) {
										historyTab.getPane().hide();
									}

								});
						tabs.addTab(historyTab);
						final Tab cowTab = new Tab(messages.cowManage());
						cowTab.setPane(new CowManageView());
						cowTab.addTabSelectedHandler(new TabSelectedHandler() {

							@Override
							public void onTabSelected(TabSelectedEvent event) {
								cowTab.getPane().show();
							}
						});
						cowTab.addTabDeselectedHandler(new TabDeselectedHandler() {

							@Override
							public void onTabDeselected(TabDeselectedEvent event) {
								cowTab.getPane().hide();
							}

						});
						tabs.addTab(cowTab);
						final Tab equipmentTab = new Tab(messages
								.equipmentManage());
						equipment = new EquipmentManageView();
						equipmentTab.setPane(equipment);
						equipmentTab
								.addTabSelectedHandler(new TabSelectedHandler() {

									@Override
									public void onTabSelected(
											TabSelectedEvent event) {
										equipmentTab.getPane().show();
									}
								});
						equipmentTab
								.addTabDeselectedHandler(new TabDeselectedHandler() {

									@Override
									public void onTabDeselected(
											TabDeselectedEvent event) {
										equipmentTab.getPane().hide();
									}

								});
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
