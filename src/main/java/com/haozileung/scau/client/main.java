package com.haozileung.scau.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
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
		tabs.setWidth("100%");
		tabs.setHeight("100%");
		final Tab userTab = new Tab(messages.userManage());
		final UserManageView userManageView = new UserManageView();
		userTab.setPane(userManageView);
		tabs.addTab(userTab);
		tabs.draw();
	}
}
