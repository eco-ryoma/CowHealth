package com.haozileung.scau.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.haozileung.scau.client.home.view.CowManageView;
import com.haozileung.scau.client.home.view.EquipmentManageView;
import com.haozileung.scau.client.home.view.SportDataChartView;
import com.haozileung.scau.client.home.view.UserManageView;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class main implements EntryPoint {

	private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final TabSet tabs = new TabSet();
		tabs.setTabBarPosition(Side.TOP);
		tabs.setTabBarThickness(25);
		tabs.setTabBarAlign(Side.RIGHT);
		tabs.setWidth100();
		tabs.setHeight100();
		final Tab testTab = new Tab(messages.cowSportData());
		testTab.setPane(new SportDataChartView());
		tabs.addTab(testTab);
		final Tab userTab = new Tab(messages.userManage());
		userTab.setPane(new UserManageView());
		tabs.addTab(userTab);
		final Tab cowTab = new Tab(messages.cowManage());
		cowTab.setPane(new CowManageView());
		tabs.addTab(cowTab);
		final Tab equipmentTab = new Tab(messages.equipmentManage());
		equipmentTab.setPane(new EquipmentManageView());
		tabs.addTab(equipmentTab);
		tabs.draw();
		Document.get().setTitle(messages.siteName());
	}
}
