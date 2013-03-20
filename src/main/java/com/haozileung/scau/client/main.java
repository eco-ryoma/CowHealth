package com.haozileung.scau.client;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.haozileung.scau.client.home.view.SportDataChartView;
import com.haozileung.scau.client.home.view.UserManageView;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.layout.VLayout;
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
		final Tab testTab = new Tab("Test");
		testTab.setPane(new SportDataChartView());
		tabs.addTab(testTab);
		final Tab chartTab = new Tab("图表");
		Chart chart = new Chart();
		Series series = chart.createSeries().setName("Moles per Yard")
				.setPoints(new Number[] { 163, 203, 276, 408, 547, 729, 628 });
		chart.addSeries(series);
		VLayout vLayout = new VLayout();
		vLayout.addMember(chart);
		vLayout.setID("MyChart");
		chartTab.setPane(vLayout);
		final Tab userTab = new Tab(messages.userManage());
		final UserManageView userManageView = new UserManageView();
		userTab.setPane(userManageView);
		tabs.addTab(chartTab);
		tabs.addTab(userTab);
		tabs.draw();
	}
}
