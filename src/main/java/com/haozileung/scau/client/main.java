package com.haozileung.scau.client;

import com.google.gwt.core.client.EntryPoint;
import com.haozileung.scau.client.home.view.UserManageView;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class main implements EntryPoint {

	// private final Messages messages = GWT.create(Messages.class);

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
		final Tab userTab = new Tab("Status");
		final UserManageView userManageView = new UserManageView();
		userTab.setPane(userManageView);
		tabs.addTab(userTab);

		SelectItem selectItem = new SelectItem();
		selectItem.setValueMap("Development", "Staging", "Production");
		selectItem.setShowTitle(false);
		selectItem.setDefaultValue("Development");
		DynamicForm form = new DynamicForm();
		// form.setHeight(1);
		form.setPadding(0);
		form.setMargin(0);
		form.setCellPadding(1);
		form.setNumCols(1);
		form.setFields(selectItem);
		tabs.setTabBarControls(form, TabBarControls.TAB_SCROLLER,
				TabBarControls.TAB_PICKER);
		tabs.draw();
	}
}
